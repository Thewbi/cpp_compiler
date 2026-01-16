#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

/**/
int prettyPrintFormatMatrix(int* matrix, int dim) {

    int count = 1;

    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            // int idx = dim * i + j;
            int idx_temp = dim * i;
            int idx = idx_temp + j;

            int temp = matrix[idx];

            putint(temp);
        }
    }

    return 0;
}


/**/
int standardMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {

    // printf("standardMatrixMult()\n");

    int counter = 0;

    // over row of matrix B
    for (int i = 0; i < rows; i++) {

        // over column of matrix A
        for (int j = 0; j < columns; j++) {

            // fuse row and column together into a single cell of matrix C
            for (int k = 0; k < columns; k++) {

                // int aIdx = i * columns + k;
                int temp_aIdx = i * columns;
                int aIdx = temp_aIdx + k;

                // int bIdx = k * columns + j;
                int temp_bIdx = k * columns;
                int bIdx = temp_bIdx + j;

                // int cIdx = i * rows + j;
                int temp_cIdx = i * rows;
                int cIdx = temp_cIdx + j;

                int aVal = matrixA[aIdx];
                int bVal = matrixB[bIdx];

                int mult_temp = aVal * bVal;

                int abc = matrixC[cIdx];
                int cde = abc + mult_temp;
                matrixC[cIdx] = cde;

            }

        }

    }

    return 0;
}


int main()
{
    // printf("main starts\n");

    /*
    9 0 9 4
    2 6 6 7
    9 3 8 1
    6 9 7 1
    */
    // int matrixA[ELEMENTS] = {
    //     9, 0, 9, 4,
    //     2, 6, 6, 7,
    //     9, 3, 8, 1,
    //     6, 9, 7, 1
    // };

    /*
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
    */
    /**/
    int matrixA[ELEMENTS] = {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10, 11, 12,
        13, 14, 15, 16
    };


    // int matrixA[ELEMENTS] = {
    //     1, 2, 3, 4,
    //     5, 6, 7, 8,
    //     1, 2, 3, 4,
    //     5, 6, 7, 8
    // };

    /*
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 0 0 0
    */
    // int matrixC[ELEMENTS] = {
    //     0, 0, 0, 0,
    //     0, 0, 0, 0,
    //     0, 0, 0, 0,
    //     0, 0, 0, 0
    // };
    // int matrixC[ELEMENTS] = {
    //     1, 2, 3, 4,
    //     5, 6, 7, 8,
    //     9, 10, 11, 12,
    //     13, 14, 15, 16
    // };
    /**/
    int matrixC[ELEMENTS] = {
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    };


    /*
    1 2 4 2
    8 6 0 0
    7 6 8 5
    8 4 7 5
    */
    // int matrixB[ELEMENTS] = {
    //     1, 2, 4, 2,
    //     8, 6, 0, 0,
    //     7, 6, 8, 5,
    //     8, 4, 7, 5
    // };

    /*
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
    */
    /**/
    int matrixB[ELEMENTS] = {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10, 11, 12,
        13, 14, 15, 16
    };


    /*
    1 2 3 4
    5 6 7 8
    1 2 3 4
    5 6 7 8
    */
    // int matrixB[ELEMENTS] = {
    //     1, 2, 3, 4,
    //     5, 6, 7, 8,
    //     1, 2, 3, 4,
    //     5, 6, 7, 8
    // };

    // upCountingMatrix(matrixA, DIMENSION);
    // upCountingMatrix(matrixB, DIMENSION);

    //int result_1 = segmentedMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);

    int a22 = standardMatrixMult(matrixA, matrixB, matrixC, 4, 4);

    /* Expected resutl for multiplying two up-counting matrixes ( 1, 2, 3, ... )
    90
    100
    110
    120
    102
    228
    254
    280
    314
    356
    398
    440
    426
    484
    542
    600
    */

    int resultPrettyPrintC = prettyPrintFormatMatrix(matrixC, DIMENSION);
    // int separatorC = 127;
    // putint(separatorC);

    exit();
    return 0;
}