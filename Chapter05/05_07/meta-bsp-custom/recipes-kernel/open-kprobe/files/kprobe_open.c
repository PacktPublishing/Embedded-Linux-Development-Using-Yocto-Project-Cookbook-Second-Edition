#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/kprobes.h>

static struct kprobe kp = {
	.symbol_name  = "do_sys_open",
};

static int handler_pre(struct kprobe *p, struct pt_regs *regs)
{
	pr_info("pre_handler: p->addr = 0x%p, lr = 0x%lx,"
			" sp = 0x%lx\n",
			p->addr, regs->ARM_lr, regs->ARM_sp);

	/* A dump_stack() here will give a stack backtrace */
	return 0;
}

static void handler_post(struct kprobe *p, struct pt_regs *regs,
		unsigned long flags)
{
	pr_info("post_handler: p->addr = 0x%p, status = 0x%lx\n",
			p->addr, regs->ARM_cpsr);
}

static int handler_fault(struct kprobe *p, struct pt_regs *regs,
		int trapnr)
{
	pr_info("fault_handler: p->addr = 0x%p, trap #%dn",
			p->addr, trapnr);
	/* Return 0 because we don't handle the fault. */
	return 0;
}

static int kprobe_init(void)
{
	int ret;
	kp.pre_handler = handler_pre;
	kp.post_handler = handler_post;
	kp.fault_handler = handler_fault;

	ret = register_kprobe(&kp);
	if (ret < 0) {
		pr_err("register_kprobe failed, returned %d\n", ret);
		return ret;
	}
	pr_info("Planted kprobe at %p\n", kp.addr);
	return 0;
}

static void kprobe_exit(void)
{
	unregister_kprobe(&kp);
	pr_info("kprobe at %p unregistered\n", kp.addr);
}

	module_init(kprobe_init)
module_exit(kprobe_exit)
	MODULE_LICENSE("GPL");
