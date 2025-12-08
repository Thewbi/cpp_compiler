#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

int main()
{
    printf("main() start \n");

    // int a = 1;
    // putint(a);

    int matrixA[ELEMENTS] = {
        1,2,3,4,
        5,6,7,8,
        9,10,11,12,
        13,14,15,16
    };

    int a = matrixA[3];
    putint(a);

    printf("main() end \n");

    exit();
    return 0;
}