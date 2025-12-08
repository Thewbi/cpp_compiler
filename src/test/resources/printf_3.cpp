#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION * DIMENSION

int main()
{
    printf("main() 1\n");

    int matrixA[ELEMENTS] = {
        1,2,3,4,
        5,6,7,8,
        9,10,11,12,
        13,14,15,16
    };

    printf("main() 2\n");

    int matrixC[ELEMENTS] = {
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    };

    printf("main() 3\n");

    exit();
    return 0;
}