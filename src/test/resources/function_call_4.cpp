#include "stdio.h"

#define DIMENSION 4
#define ELEMENTS DIMENSION *DIMENSION

//void prettyPrintFormatMatrix(int* matrix, int dim, const char* format) {
void prettyPrintFormatMatrix(int* matrix, int dim) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            //printf(format, matrix[dim*i + j]);
            //printf("a");
            printf("%d", matrix[i]);
        }
        printf("\n");
    }
}

int main()
{
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1 };

        /*
    for (int i = 0; i < DIMENSION; i++)
    {
        for (int j = 0; j < DIMENSION; j++)
        {
            // printf ( "%d" , matrixA [ dim * i + j ] ) ;
            printf("b");
        }
        //printf("\n");

        printf("a");
    }
        */

    //prettyPrintFormatMatrix(matrixA, DIMENSION, "%6d");
    prettyPrintFormatMatrix(matrixA, DIMENSION);

    printf("END");

    return 0;
}