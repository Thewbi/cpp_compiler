#include "stdio.h"

#define DIMENSION 4
#define ELEMENTS DIMENSION * DIMENSION

int prettyPrintFormatMatrix(int* matrix, int dim) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            int idx = dim * i + j;

            int temp = matrix[idx];
            // printf("%d", temp);
            putint(temp);
        }
    }

    return 0;
}

int main()
{
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1 };

    prettyPrintFormatMatrix(matrixA, DIMENSION);

    printf("END");

    return 0;
}