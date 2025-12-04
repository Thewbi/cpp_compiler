#include <stdio.h>

int func_void(int a, int b)
{
    //printf("func_void() a = %d\n", a);

    int c = a + b;
    //int c = a * b;

    return c;
}

int main()
{
    int c = func_void(123, 12);

    printf("func_void() c = %d\n", c);

    exit();
    return 0;
}