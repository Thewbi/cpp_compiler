#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

int matrixAddInto(/*int* matrixA, int* matrixB,*/ int rows, int columns) {
    // printf("matrixAddInto()\n");
    return 0;
}

int segmentedMatrixMult(/*int* matrixA, int* matrixB, int* matrixC,*/ int rows, int columns) {

    printf("segmentedMatrixMult\n");

    int nc = 2;
    int rowSteps = rows / nc;

    int kc = 2;
    int columnsSteps = columns / kc;

    int mc = 2;
    int innerSteps = rows / nc;

    //
    // ACT
    //

    // int subMatrixA[4] = { 0, 0, 0, 0 };
    // int subMatrixB[4] = { 0, 0, 0, 0 };
    // int tempMult[4] = { 0, 0, 0, 0 };
    // int tempAccum[4] = { 0, 0, 0, 0 };

    for (int jc = 0; jc < rowSteps; jc++) {

        // printf("1 loop\n");

        for (int pc = 0; pc < columnsSteps; pc++) {

            // printf("2 loop\n");

            for (int ic = 0; ic < innerSteps; ic++) {

                // printf("3 loop\n");
/*
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
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_f2 = ic * kc; // THIS LINE MAKES THE DIFFERENCE
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
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc; // Makes the difference
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_d2 = ic * kc;
                int xPos_e2 = ic * kc;
                int xPos_e2 = ic * kc;
               */

                //int a239 = matrixAddInto(/*tempAccum, tempMult, */2, 2);
                matrixAddInto(/*tempAccum, tempMult, */2, 2);

            }
        }
    }

    return 0;
}

int main()
{
    printf("main() 1\n");

    int result = segmentedMatrixMult(/*matrixA, matrixB, matrixC,*/ 4, 4);

    // matrixAddInto(2, 2);

    printf("main() 2\n");

    exit();
    return 0;
}