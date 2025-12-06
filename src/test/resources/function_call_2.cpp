#include <stdio.h>

void func_void()
{
    printf("This comes from func_void()!\n");

    return 0;
}

int main()
{
    func_void();

    exit();
    return 0;
}