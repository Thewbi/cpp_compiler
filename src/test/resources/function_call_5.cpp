#include "stdio.h"

#define DIMENSION 4
#define ELEMENTS DIMENSION * DIMENSION

/**/
int prettyPrintFormatMatrix(int* matrix, int dim) {

    int count = 1;

    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            
            //int idx = dim * i + j;
            int idx_temp = dim * i;
            int idx = idx_temp + j;

            int temp = matrix[idx];

            printf("%d\n", temp);

            // printf("test\n");
        }
    }

    // for (int i = 0; i < dim; i++) {
    //     printf("test\n");
    // }

    return 0;
}

/**/
int upCountingMatrix(int* matrix, int dim) {

    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            // printf("a\n");

            //int idx = dim * i + j;
            int temp = dim * i;
            int idx = temp + j;
            matrix[idx] = count;

            //count++;
            int jj = count;
            count = jj + 1;
        }
    }
    return 0;
}


int main()
{
    /*
    int count = 0;

    for (int i = 0; i < 10; i++) {
        int jj = count;
        count = jj + 1;
    }

    printf("%d", count);
    */

    /**/
    //printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1 };

    int result1 = upCountingMatrix(matrixA, DIMENSION);
    int result2 = prettyPrintFormatMatrix(matrixA, DIMENSION);

    //printf("END\n");

    exit();
    return 0;
}