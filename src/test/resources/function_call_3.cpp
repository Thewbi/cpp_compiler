#include <stdio.h>

void func_void(int a) 
{
    printf("func_void() a = %d", a);
}

int main()
{
    func_void(123);

    return 0;
}