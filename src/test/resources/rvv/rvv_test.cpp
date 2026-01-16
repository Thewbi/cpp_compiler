#include <stdio.h>

int main()
{
    // asm ("movl %eax, %ebx\n\t"
    //     "movl $56, %esi\n\t"
    //     "movl %ecx, $label(%edx,%ebx,$4)\n\t"
    //     "movb %ah, (%ebx)");

    asm ("vsetivli         t0, 32, e8,m1,tu,mu");

    exit();
    return 0;
}