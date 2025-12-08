#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

int test_function(int param_1) {

    int matrix_in_test_function[4] = {
        80,81,82,83
    };

    return 0;
}

int main()
{
    printf("main() start \n");

    // int a = 1;
    // putint(a);

    int matrixA[4] = {
        1,2,3,4
        // ,
        // 5,6,7,8,
        // 9,10,11,12,
        // 13,14,15,16
    };

    int param_1 = 1;
    int test_function_result = test_function(param_1);

    int a = matrixA[0];
    putint(a);
    a = matrixA[1];
    putint(a);
    a = matrixA[2];
    putint(a);
    a = matrixA[3];
    putint(a);

    printf("main() end \n");

    exit();
    return 0;
}