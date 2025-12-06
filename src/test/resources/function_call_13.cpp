#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

int matrixAddInto(int* matrixA, int* matrixB, int rows, int columns) {
    return 0;
}
int segmentedMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {

    int nc = 2;
    int rowSteps = rows / nc;

    int kc = 2;
    int columnsSteps = columns / kc;

    int mc = 2;
    int innerSteps = rows / nc;

    //
    // ACT
    //

    int subMatrixA[4] = { 0, 0, 0, 0 };
    int subMatrixB[4] = { 0, 0, 0, 0 };
    int tempMult[4] = { 0, 0, 0, 0 };
    int tempAccum[4] = { 0, 0, 0, 0 };
    for (int jc = 0; jc < rowSteps; jc++) {
        for (int pc = 0; pc < columnsSteps; pc++) {
            int xPos_b = pc * kc;
            int yPos_b = jc * nc;
            for (int ic = 0; ic < innerSteps; ic++) {

                int xPos_a = ic * mc;
                int yPos_a = pc * kc;
                int xPos_c = ic * kc;
                int yPos_c = jc * nc;
                int xPos_d = ic * kc;
                int xPos_e = ic * kc;
                int xPos_f = ic * kc;
                int xPos_g = ic * kc;
                int xPos_h = ic * kc;
                int xPos_i = ic * kc;
                int xPos_j = ic * kc;
                int xPos_k = ic * kc;
                int xPos_l = ic * kc;
                int xPos_m = ic * kc;
                int xPos_n = ic * kc;
                int xPos_o = ic * kc;
                int xPos_p = ic * kc;
                int xPos_q = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_f2 = ic * kc; // THIS LINE MAKES THE DIFFERENCE

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