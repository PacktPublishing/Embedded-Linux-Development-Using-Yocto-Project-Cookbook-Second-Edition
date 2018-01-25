#include <linux/module.h>
#include "linux/timer.h"
#define CREATE_TRACE_POINTS
#include "trace.h"

static struct timer_list hello_timer;

void hello_timer_callback(unsigned long data)
{
	char a[] = "Hello";
	char b[] = "World";
	printk("%s %s\n",a,b);
	/* Insert the static tracepoint */
	trace_log_dbg(a, b);
	/* Trigger the timer again in 8 seconds */
	mod_timer(&hello_timer, jiffies + msecs_to_jiffies(8000));
}

static int hello_world_init(void)
{
	/* Setup a timer to fire in 2 seconds */
	setup_timer(&hello_timer, hello_timer_callback, 0);
	mod_timer(&hello_timer, jiffies + msecs_to_jiffies(2000));
	return 0;
}

static void hello_world_exit(void)
{
	/* Delete the timer */
	del_timer(&hello_timer);
}

module_init(hello_world_init);
module_exit(hello_world_exit);

MODULE_LICENSE("GPL v2");
