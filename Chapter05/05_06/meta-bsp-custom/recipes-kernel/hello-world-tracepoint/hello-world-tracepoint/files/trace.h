#undef TRACE_SYSTEM
#define TRACE_SYSTEM log_dbg

#if !defined(_HELLOWORLD_TRACE) || defined(TRACE_HEADER_MULTI_READ)
#define _HELLOWORLD_TRACE

#include <linux/tracepoint.h>

TRACE_EVENT(log_dbg,
		TP_PROTO(char *a, char *b),
		TP_ARGS(a, b),
		TP_STRUCT__entry(
			__string(a, a)
			__string(b, b)),
		TP_fast_assign(
			__assign_str(a, a);
			__assign_str(b, b);),
		TP_printk("log_dbg: a %s b %s",
			__get_str(a), __get_str(b))
	   );
#endif

/* This part must be outside protection */
#undef TRACE_INCLUDE_PATH
#undef TRACE_INCLUDE_FILE
#define TRACE_INCLUDE_PATH .
#define TRACE_INCLUDE_FILE trace
#include <trace/define_trace.h>
