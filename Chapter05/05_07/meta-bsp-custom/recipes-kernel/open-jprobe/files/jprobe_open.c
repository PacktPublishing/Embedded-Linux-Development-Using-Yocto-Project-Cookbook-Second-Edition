#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/kprobes.h>
static long jdo_sys_open(int dfd, const char __user *filename, int
		flags, umode_t mode)
{
	pr_info("jprobe: dfd = 0x%x, filename = 0xs "
			"flags = 0x%x mode umode %x\n", dfd, filename, flags, mode);

	/* Always end with a call to jprobe_return(). */
	jprobe_return();
	return 0;
}

static struct jprobe my_jprobe = {
	.entry        = jdo_sys_open,
	.kp = {
		.symbol_name  = "do_sys_open",
	},
};

static int jprobe_init(void)
{
	int ret;

	ret = register_jprobe(&my_jprobe);
	if (ret < 0) {
		pr_err("register_jprobe failed, returned %d\n", ret);
		return -1;
	}
	pr_info("Planted jprobe at %p, handler addr %p\n",
			my_jprobe.kp.addr, my_jprobe.entry);
	return 0;
}

static void jprobe_exit(void)
{
	unregister_jprobe(&my_jprobe);
	pr_info("jprobe at %p unregistered\n", my_jprobe.kp.addr);
}

	module_init(jprobe_init)
module_exit(jprobe_exit)
	MODULE_LICENSE("GPL");
