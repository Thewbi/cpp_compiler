#include <stdio.h>

int func_assign(int* numbers)
{
    // numbers[0] = 64; // 0x40
    numbers[1] = 255; // 0xFF

    return 0;
}

int main()
{
    int numbers[3] = {16, 32, 48}; // 0x10, 0x20, 0x30 

    int y = func_assign(numbers);

    //int c = numbers[0];

    //printf("func_assign() c = %d\n", c);

    exit();
    return 0;
}