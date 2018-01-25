#include <stdio.h>
#include <lttng/tracef.h>

int main(void)
{
	printf("Hello World");
	tracef("I said: %s", "Hello World");
	return 0;
}
