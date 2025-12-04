#include <stdio.h>

void func_void(int a) 
{
    printf("func_void() a = %d\n", a);
}

int main()
{
    func_void(123);

    exit();
    return 0;
}