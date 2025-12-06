// Msys2: install gcc:
// pacman -S mingw-w64-ucrt-x86_64-gcc
// gcc.exe is installed to C:\msys64\mingw64\bin
// Add it to the path environment variable
// set PATH=%PATH%;C:\msys64\mingw64\bin\
//
// Compile an application:
// gcc main.c
//
// Compile using the Makefile
// In MSYS2 64 bit console
// ```
// cd /c/Users/lapto/dev/c/MatrixTesterC
// make
// ./bin/matrix.exe
// ```

#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

#define SUB_DIMENSION 2

/**/
int matrixAddInto(int* matrixA, int* matrixB, int rows, int columns) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {

            // int tempIndex = i * rows + j;
            int temp = i * rows;
            int tempIndex = temp + j;

            // matrixA[temp] += matrixB[temp];
            int tempAValue = matrixA[tempIndex];
            int tempBValue = matrixB[tempIndex];
            matrixA[tempIndex] = tempAValue + tempBValue;
        }
    }

    return 0;
}


/**
 * Copies a subfield into matrixDest.
 *
 * matrixDest - destination to copy data into
 * matrixSrc - source to copy data from
 * dim - dimension of source (NOT TARGET!!!!!)
 * xPos - xPos of field to copy
 * yPos - xPos of field to copy
 * width - xPos of field to copy
 * height - xPos of field to copy
 */
int getSubMatrix(int* matrixDest, int* matrixSrc, int dim, int xPos, int yPos, int width, int height) {

    /*
    // matrixDest[0] = xPos;
    // matrixDest[1] = yPos;
    // matrixDest[2] = width;
    // matrixDest[3] = height;

    // matrixDest[0] = 16;
    // matrixDest[1] = 32;
    // matrixDest[2] = 48;
    // matrixDest[3] = 64;

    int xEnd = xPos + width;
    int yEnd = yPos + height;

    // matrixDest[0] = xEnd;
    // matrixDest[1] = yEnd;

    int counter = 0;

    int innerI = 0;
    for (int i = xPos; i < xEnd; i++) {

        int innerJ = 0;
        for (int j = yPos; j < yEnd; j++) {

            // matrixC[innerI * width + innerJ] = matrix[i * dim + j];

            // int idx = i * dim + j;
            int tempIdx = i * dim;
            //matrixDest[counter] = tempIdx; // 0,0,2,2  OK

            //matrixDest[counter] = j; // 0,1,0,1  OK

            int idx = tempIdx + j;
            //matrixDest[counter] = idx; // 0,1,2,3  OK

            //matrixDest[counter] = width; // 2,2,2,2 OK
            //matrixDest[counter] = innerI; // 0,0,1,1 OK

            // // int idxC = innerI * width + innerJ;
            int tempIdxC = innerI * width;
            //matrixDest[counter] = tempIdxC; // 0,0,2,2 OK

            //matrixDest[counter] = innerJ; // 0,1,0,1 OK

            int idxC = tempIdxC + innerJ;
            //matrixDest[counter] = idxC; // 0,1,2,3

            //matrixDest[counter] = idxC; // 0,1,2,3 INCORRECT: 0,1,4,5

            //matrixDest[counter] = idx; // 0,1,2,3  OK

            int transfer = matrixSrc[idx];
            matrixDest[idxC] = transfer;

            // copy the src index into dest for debugging. Should be: 0,1,4,5 but is 0,1,3,4
            //matrixDest[idxC] = idx;

            // innerJ++;
            int t = innerJ + 1;
            innerJ = t;

            int tempCounter = counter + 1;
            counter = tempCounter;

        }

        //innerI++;
        int u = innerI + 1;
        innerI = u;
    }
    */

    return 0;
}


/**
 * Copies a subfield into matrixDest.
 *
 * matrixDest - destination to copy data into
 * matrixSrc - source to copy data from
 * dim - dimension of destination (NOT SOURCE!!!!!)
 * xPos - xPos of field to copy
 * yPos - xPos of field to copy
 * width - xPos of field to copy
 * height - xPos of field to copy
 */
int setSubMatrix(int* matrix_dest, int* matrix_src, int dim, int xPos, int yPos, int width, int height) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {

            // int temp = i * width + j;
            int temp1 = i * width;
            int temp2 = temp1 + j;
            int tempData = matrix_src[temp2];

            // int temp2 = (yPos + i) * dim + (xPos + j);
            int temp3 = (yPos + i);
            int temp4 = temp3 * dim;
            int temp5 = (xPos + j);
            int destIndex = temp4 + temp5;

            matrix_dest[destIndex] = tempData;
        }
    }
    return 0;
}




/**/
int standardMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {

    //int t1 = matrixA[2];
    // printf("test: %d\n", t1);
    //matrixC[3] = t1;
    // matrixC[3] = 32;

    // matrixA[3] = 32;

    // //printf("standardMatrixMult()\n");

    // // matrixC[1] = 1;

    int counter = 0;

    // over row of matrix B
    for (int i = 0; i < rows; i++) {

        // matrixC[i] = i;

        // over column of matrix A
        for (int j = 0; j < columns; j++) {

            // int tcounter = counter;
            // counter = tcounter + 1;
            // matrixC[1] = counter;

            //matrixC[j] = j;

            // fuse row and column together into a single cell of matrix C
            for (int k = 0; k < columns; k++) {

                // int tcounter = counter;
                // counter = tcounter + 1;
                // matrixC[1] = counter;

                // int t1 = matrixA[0];
                // // printf("test: %d\n", t1);
                // matrixC[3] = t1;

                //matrixC[i * rows + j] += matrixA[i * columns + k] * matrixB[k * columns + j];

                // int aIdx = i * columns + k;
                int temp_aIdx = i * columns;
                int aIdx = temp_aIdx + k;

                // matrixC[1] = aIdx;

                // int bIdx = k * columns + j;
                int temp_bIdx = k * columns;
                int bIdx = temp_bIdx + j;

                // matrixC[2] = bIdx;

                // int cIdx = i * rows + j;
                int temp_cIdx = i * rows;
                int cIdx = temp_cIdx + j;

                // matrixC[3] = cIdx;

                int aVal = matrixA[aIdx];
                // matrixC[4] = aVal;
                // // printf("test");

                int bVal = matrixB[bIdx];
                // matrixC[5] = bVal;

                int mult_temp = aVal * bVal;

                // matrixC[6] = mult_temp;

                //printf("test");

                // DEBUG
                // printf("aIdx: %d", aIdx);
                // printf("bIdx: %d", bIdx);
                // printf("cIdx: %d", cIdx);
                // printf("aVal: %d", aVal);
                // printf("bVal: %d", bVal);
                // printf("aVal: %d", aVal);
                // printf("bVal: %d", bVal);

                int abc = matrixC[cIdx];
                // matrixC[7] = abc;
                int cde = abc + mult_temp;
                // matrixC[8] = cde;
                matrixC[cIdx] = cde;

                // matrixC[cIdx] = 1;

                // matrixC[1] = 1;

                // exit();

            }

        }

    }

    return 0;
}


/**
 * Computes: MatrixC = MatrixA * MatrixB
 */
int segmentedMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {

    int nc = 2; // subset size
    int rowSteps = rows / nc;

    int kc = 2; // subset size
    int columnsSteps = columns / kc;

    int mc = 2; // subset size
    int innerSteps = rows / nc;

    //
    // ACT
    //

    // DEBUG
    int iterationCounter = 0;

    int subMatrixA[4] = { 0, 0, 0, 0 };
    int subMatrixB[4] = { 0, 0, 0, 0 };
    int tempMult[4] = { 0, 0, 0, 0 };
    int tempAccum[4] = { 0, 0, 0, 0 };

    // for jc = 0 to n-1 step nc
    // Loop 1
    for (int jc = 0; jc < rowSteps; jc++) {

        // for pc = 0 to k-1 step kc
        // Loop 2
        for (int pc = 0; pc < columnsSteps; pc++) {

            // int* subMatrixB = subMatrix(matrixB, pc * kc, jc * nc, kc, nc);
            //int subMatrixB[4] = { 0, 0, 0, 0 };
            int xPos_b = pc * kc;
            int yPos_b = jc * nc;
            int sub_matrix_1 = getSubMatrix(subMatrixB, matrixB, DIMENSION, xPos_b, yPos_b, kc, nc);

            //prettyPrintFormatMatrix(subMatrixB, 2);

            // for ic = 0 to m-1 step mc
            // Loop 3
            for (int ic = 0; ic < innerSteps; ic++) {

                // printf("test\n");

                //printf("//\n");
                //printf("// Iteration: %d\n", iterationCounter);
                //printf("//\n");

                // Matrix subMatrixA = matrixA.getSubMatrix(ic * mc, pc * kc, mc, kc);
                // int subMatrixA[4] = { 0, 0, 0, 0 };
                int xPos_a = ic * mc;
                int yPos_a = pc * kc;
                //int sub_matrix_2 = getSubMatrix(subMatrixA, matrixA, DIMENSION, xPos_a, yPos_a, mc, kc);

                // printf("[\n");
                // //prettyPrintFormatMatrix(subMatrixA, 2, "%6d");
                // int aba = prettyPrintFormatMatrix(subMatrixA, 2);
                // printf("------------------------\n");
                // //prettyPrintFormatMatrix(subMatrixB, 2, "%6d");
                // int cbc = prettyPrintFormatMatrix(subMatrixB, 2);
                // printf("]\n");

                int transfer = iterationCounter + 1;
                iterationCounter = transfer;

                // perform a matrix mult of the sub matrices
                //Matrix temp = subMatrixA.mult(subMatrixB);
                // int tempMult[4] = { 0, 0, 0, 0 };
                int a22 = standardMatrixMult(subMatrixA, subMatrixB, tempMult, 2, 2);

                // printf("+++++++++++++++++++++++++++++\n");
                // //prettyPrintFormatMatrix(tempMult, 2, "%6d");
                // int a3322 = prettyPrintFormatMatrix(tempMult, 2);
                // printf("+++++++++++++++++++++++++++++\n");

                // // retrieve sub matrix to accumulate into
                // Matrix accumulatorSubMatrixC = matrixC.getSubMatrix(ic * kc, jc * nc, nc, kc);
                // int tempAccum[4] = { 0, 0, 0, 0 };
                int xPos_c = ic * kc;
                int yPos_c = jc * nc;
                int a33423 = getSubMatrix(tempAccum, matrixC, DIMENSION, xPos_c, yPos_c, nc, kc);

                //prettyPrintFormatMatrix(tempAccum, 2);

                // // accumulate the result
                // accumulatorSubMatrixC.add(temp);
                int a239 = matrixAddInto(tempAccum, tempMult, 2, 2);

                //prettyPrintFormatMatrix(tempAccum, 2);

                //break;

                // // place the accumulator back into the large result matrix
                // matrixC.setSubMatrix(jc * nc, ic * kc, nc, kc, accumulatorSubMatrixC);
                //setSubMatrix(matrixC, matrix_new, DIMENSION, xPos, yPos, width, height);
                int a244 = setSubMatrix(matrixC, tempAccum, DIMENSION, yPos_c, xPos_c, nc, kc);

                //prettyPrintFormatMatrix(matrixC, DIMENSION);

                // printf("-----------------------------\n");
                // int a999 = prettyPrintFormatMatrix(matrixC, DIMENSION);
                // printf("-----------------------------\n");

                //break;

            }

            //break;

        }

        //break;

    }

    //printf("IterationCounter: \t %d\n", iterationCounter);

    return 0;
}







// int printMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             printf("%d ", matrix[dim*i + j]);
//         }
//         printf("\n");
//     }
//     return 0;
// }

/*
int prettyPrintFormatMatrix(int* matrix, int dim) {
    //int ctr = 0;
    // printf("prettyPrintFormatMatrix()\n");
    for (int i = 0; i < dim; i++) {
        // printf("prettyPrintFormatMatrix() i = %d\n", i);
        for (int j = 0; j < dim; j++) {
            // printf("prettyPrintFormatMatrix() j = %d\n", j);

            //int idx = dim * i + j;
            int temp = dim * i;
            int idx = temp + j;

            int temp = matrix[idx];
            //printf("%d: %d", ctr, temp);
            printf("\t %d", temp);

            //int tttt = ctr + 1;
            //ctr = tttt;
        }
        printf("\n");
    }
    return 0;
}
*/


// int identityMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             matrix[dim*i + j] = (i==j) ? 1 : 0;
//         }
//     }
//     return 0;
// }

// int zeroMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             matrix[dim*i + j] = 0;
//         }
//     }
//     return 0;
// }

/*
int upCountingMatrix(int* matrix, int dim) {
    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            //int idx = dim * i + j;
            int temp = dim * i;
            int idx = temp + j;

            matrix[idx] = count;

            int t = count + 1;
            count = t;
        }
    }
    return 0;
}
*/

/*
int zeroMatrix(int* matrix, int dim) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            //int idx = dim * i + j;
            int temp = dim * i;
            int idx = temp + j;

            matrix[idx] = 0;
        }
    }
    return 0;
}
*/

/*
//void multiParamTest(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {
//void multiParamTest(int* matrixA, int rows, int columns) {
void multiParamTest(int* matrixA, int* matrixB, int rows, int columns) {

    printf("multiParamTest()");

    printf("-- A -------------------------------------");
    int dim = 4;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            int temp = matrixA[idx];
            printf("%d", temp);
        }
    }

    printf("-- B -------------------------------------");
    int dim = 4;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            int temp = matrixB[idx];
            printf("%d", temp);
        }
    }

    // int temp = matrixA[0];
    // printf("%d", temp);

    // int temp = matrixB[0];
    // printf("%d", temp);

}*/

int main()
{
    //printf("Matrix\n");

    /*
    9 0 9 4
    2 6 6 7
    9 3 8 1
    6 9 7 1
    */
    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1
    };

    // int matrixC[ELEMENTS] = {
    //     254, 255, 255, 255,
    //     255, 255, 255, 255,
    //     255, 255, 255, 255,
    //     255, 255, 255, 254
    // };

    /*
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 0 0 0
    */
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
    int matrixB[ELEMENTS] = {
        1, 2, 4, 2,
        8, 6, 0, 0,
        7, 6, 8, 5,
        8, 4, 7, 5
    };

    //int upResult = upCountingMatrix(matrixA, DIMENSION);
    //int upResult = upCountingMatrix(matrixB, DIMENSION);
    // int upResult = upCountingMatrix(matrixC, DIMENSION);

//    printf("A\n");
//    int pp1 = prettyPrintFormatMatrix(matrixA, DIMENSION);

//    printf("B\n");
//    int pp2 = prettyPrintFormatMatrix(matrixB, DIMENSION);

    //int subMatrixB[4] = { 16, 32, 48, 64 };
    // int subMatrixB[4] = { 255, 255, 255, 255 };
    // int getResult = getSubMatrix(subMatrixB, matrixB, DIMENSION, 0, 0, SUB_DIMENSION, SUB_DIMENSION);
    // int setResult = setSubMatrix(matrixC, subMatrixB, DIMENSION, 0, 0, SUB_DIMENSION, SUB_DIMENSION);

    // int subMatrixA[4] = { 1, 2, 3, 4 };
    // int subMatrixB[4] = { 1, 2, 3, 4 };
    // int getResult = matrixAddInto(subMatrixA, subMatrixB, SUB_DIMENSION, SUB_DIMENSION);

    // printf("subMatrixB\n");
    // prettyPrintFormatMatrix(subMatrixB, 2);

    // int pp2 = zeroMatrix(matrixC, DIMENSION);

//    int pp3 = standardMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);

    int result_1 = segmentedMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);

    //multiParamTest(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);
    //multiParamTest(matrixA, matrixB, 4, 5);

    // printf("C\n");
    // int result_2 = prettyPrintFormatMatrix(matrixC, DIMENSION);

    // Expected result for the two sample matrixes
    // int[] intArray = new int[] {
    //     104,    88,   136,    83,
    //     148,   104,   105,    69,
    //      97,    88,   107,    63,
    //     135,   112,    87,    52
    // };

    // Expected result for two up-counting matrices:
    // int[] intArray = new int[] {
    //      90,   100,   110,   120,
    //     202,   228,   254,   280,
    //     314,   356,   398,   440,
    //     426,   484,   542,   600
    // };

    exit();
    return 0;
}