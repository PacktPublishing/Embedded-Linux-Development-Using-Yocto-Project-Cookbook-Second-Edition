#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/kprobes.h>
#include <linux/ktime.h>
#include <linux/limits.h>
#include <linux/sched.h>

/* per-instance private data */
struct my_data {
	ktime_t entry_stamp;
};

static int entry_handler(struct kretprobe_instance *ri, struct
		pt_regs *regs)
{
	struct my_data *data;

	if (!current->mm)
		return 1;  /* Skip kernel threads */

	data = (struct my_data *)ri->data;
	data->entry_stamp = ktime_get();
	return 0;
}

static int ret_handler(struct kretprobe_instance *ri, struct
		pt_regs *regs)
{
	int retval = regs_return_value(regs);
	struct my_data *data = (struct my_data *)ri->data;
	s64 delta;
	ktime_t now;

	now = ktime_get();
	delta = ktime_to_ns(ktime_sub(now, data->entry_stamp));
	pr_info("returned %d and took %lld ns to execute\n",
			retval, (long long)delta);
	return 0;
}

static struct kretprobe my_kretprobe = {
	.handler    = ret_handler,
	.entry_handler    = entry_handler,
	.data_size    = sizeof(struct my_data),
	.maxactive    = 20,
};

static int kretprobe_init(void)
{
	int ret;

	my_kretprobe.kp.symbol_name = "do_sys_open";
	ret = register_kretprobe(&my_kretprobe);
	if (ret < 0) {
		pr_err("register_kretprobe failed, returned %d\n",
				ret);
		return -1;
	}
	pr_info("Planted return probe at %s: %p\n",
			my_kretprobe.kp.symbol_name,            my_kretprobe.kp.addr);
	return 0;
}

static void kretprobe_exit(void)
{
	unregister_kretprobe(&my_kretprobe);
	pr_info("kretprobe at %p unregistered\n",
			my_kretprobe.kp.addr);

	/* nmissed > 0 suggests that maxactive was set too low. */
	pr_info("Missed probing %d instances of %s\n",
			my_kretprobe.nmissed, my_kretprobe.kp.symbol_name);
}

	module_init(kretprobe_init)
module_exit(kretprobe_exit)
	MODULE_LICENSE("GPL");
