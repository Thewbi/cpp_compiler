#include <stdio.h>

void func_void()
{
    printf("This comes from func_void()!\n");

    return 0;
}

int main()
{
    int a = 1;
    putint(a);
    func_void();

    exit();
    return 0;
}