#include "stdio.h"

#define DIMENSION 4
#define ELEMENTS DIMENSION * DIMENSION

/**/
void prettyPrintFormatMatrix(int* matrix, int dim) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            int temp = matrix[idx];
            printf("%d", temp);
        }
    }
}

void upCountingMatrix(int* matrix, int dim) {
    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            matrix[idx] = count;

            int jj = count;
            count = jj + 1;
            //count++;
            //count = count + 1;
        }
    }
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
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1 };

    upCountingMatrix(matrixA, DIMENSION);
    prettyPrintFormatMatrix(matrixA, DIMENSION);

    printf("END");

    return 0;
}