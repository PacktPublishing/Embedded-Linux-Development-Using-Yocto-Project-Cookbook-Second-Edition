#include <stdio.h>
#include "hw.h"

main(void)
{
	printf("Hello World");
	tracepoint(hello_world_trace_provider,  hw_tracepoint, 1, "I said: Hello World");
}
