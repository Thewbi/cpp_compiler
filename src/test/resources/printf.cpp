#include <stdio.h>

int main()
{
    printf("printf test ...\n");

    int length = 10;
    for (int i = 0; i < length; i++)
    {
        //printf("test: %d\n", i);
        putint(i);
    }

    printf("printf test.\n");

    exit();
    return 0;
}