#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

int matrixAddInto(int* matrixA, int* matrixB, int rows, int columns) {
    return 0;
}

int standardMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {
    return 0;
}

int getSubMatrix(int* matrixDest, int* matrixSrc, int dim, int xPos, int yPos, int width, int height) {
    return 0;
}

/**
 * Computes: MatrixC = MatrixA * MatrixB
 */
int segmentedMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {

    int nc = 2; // subset size
    int rowSteps = rows / nc;
    // int rowSteps = 0;

    int kc = 2; // subset size
    int columnsSteps = columns / kc;
    // int columnsSteps = 0;

    int mc = 2; // subset size
    int innerSteps = rows / nc;
    // int innerSteps = 0;

    //
    // ACT
    //

    // DEBUG
    int iterationCounter = 0;

    int subMatrixA[4] = { 0, 0, 0, 0 };
    int subMatrixB[4] = { 0, 0, 0, 0 };
    int tempMult[4] = { 0, 0, 0, 0 };
    int tempAccum[4] = { 0, 0, 0, 0 };
    for (int jc = 0; jc < rowSteps; jc++) {
        for (int pc = 0; pc < columnsSteps; pc++) {
            int xPos_b = pc * kc;
            int yPos_b = jc * nc;
            int sub_matrix_1 = getSubMatrix(subMatrixB, matrixC, DIMENSION, 1, 2, 3, 4);
            for (int ic = 0; ic < innerSteps; ic++) {
                int xPos_a = ic * mc;
                int yPos_a = pc * kc;
                int sub_matrix_2 = getSubMatrix(subMatrixA, matrixC, DIMENSION, 1, 2, 3, 4);
                int transfer = iterationCounter + 1;
                iterationCounter = transfer;
                int a22 = standardMatrixMult(subMatrixA, subMatrixB, tempMult, 1, 2);
                //int xPos_c = ic * kc;
                //int yPos_c = jc * nc; // adding this line back in causes problems!!!
                int a33423 = getSubMatrix(tempAccum, matrixC, DIMENSION, 1, 2, 3, 4);
                int a239 = matrixAddInto(tempAccum, tempMult, 2, 2);
            }
        }
    }

    return 0;
}

int main()
{

    int matrixA[16] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1
    };

    int matrixB[16] = {
        1, 2, 4, 2,
        8, 6, 0, 0,
        7, 6, 8, 5,
        8, 4, 7, 5
    };

    int matrixC[16] = {
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    };

    int result = segmentedMatrixMult(matrixA, matrixB, matrixC, 2, 3);

    exit();
    return 0;
}