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



// void matrixAddInto(int* matrixA, int* matrixB, int rows, int columns) {
//     for (int i = 0; i < rows; i++) {
//         for (int j = 0; j < columns; j++) {
//             matrixA[i * rows + j] += matrixB[i * rows + j];
//         }
//     }
// }

void getSubMatrix(int* matrix, int dim, int xPos, int yPos, int width, int height, int* matrixC) {
//void getSubMatrix(int* matrix, int dim, int xPos, int yPos, int width, int height) {
//void getSubMatrix(int* matrix, int dim) {

    // int xPos = 0;
    // int yPos = 0;
    // int width = 2;
    // int height = 2;

    int xEnd = xPos + width;
    int yEnd = yPos + height;

    int innerI = 0;
    for (int i = xPos; i < xEnd; i++) {

        int innerJ = 0;
        for (int j = yPos; j < yEnd; j++) {

            // matrixC[innerI * width + innerJ] = matrix[i * dim + j];
            int idx = i * dim + j;
            int idxC = innerI * width + innerJ;
            
            int gaga = matrix[idx];
            matrixC[idxC] = gaga;

            // innerJ++;
            int t = innerJ + 1;
            innerJ = t;
            
            //printf("test");

        }

        //innerI++;
        int u = innerI + 1;
        innerI = u;
    }
}

// void setSubMatrix(int* matrix, int dim, int xPos, int yPos, int width, int height, int* matrixC) {
//     for (int i = 0; i < height; i++) {
//         for (int j = 0; j < width; j++) {
//             int tempData = matrixC[i * width + j];
//             matrix[(yPos + i) * dim + (xPos + j)] = tempData;
//         }
//     }
// }

/*
void segmentedMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {
    
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

    // for jc = 0 to n-1 step nc
    // Loop 1
    for (int jc = 0; jc < rowSteps; jc++) {

        // for pc = 0 to k-1 step kc
        // Loop 2
        for (int pc = 0; pc < columnsSteps; pc++) {

            //int* subMatrixB = subMatrix(matrixB, pc * kc, jc * nc, kc, nc);
            int subMatrixB[2*2];
            getSubMatrix(matrixB, DIMENSION, pc * kc, jc * nc, kc, nc, subMatrixB);

            // for ic = 0 to m-1 step mc
            // Loop 3
            for (int ic = 0; ic < innerSteps; ic++) {

                //Matrix subMatrixA = matrixA.getSubMatrix(ic * mc, pc * kc, mc, kc);
                int subMatrixA[2*2] = { 0, 0, 0, 0 };
                getSubMatrix(matrixA, DIMENSION, ic * mc, pc * kc, mc, kc, subMatrixA);

                printf("[\n");
                prettyPrintFormatMatrix(subMatrixA, 2, "%6d");
                printf("------------------------\n");
                prettyPrintFormatMatrix(subMatrixB, 2, "%6d");
                printf("]\n");

                iterationCounter++;

                // perform a matrix mult of the sub matrices
                //Matrix temp = subMatrixA.mult(subMatrixB);
                int tempMult[2*2] = { 0, 0, 0, 0 };
                standardMatrixMult(subMatrixA, subMatrixB, tempMult, 2, 2);

                //printf("+++++++++++++++++++++++++++++\n");
                //prettyPrintFormatMatrix(tempMult, 2, "%6d");
                //printf("+++++++++++++++++++++++++++++\n");

                // // retrieve sub matrix to accumulate into
                // Matrix accumulatorSubMatrixC = matrixC.getSubMatrix(ic * kc, jc * nc, nc, kc);
                int tempAccum[2*2] = { 0, 0, 0, 0 };
                getSubMatrix(matrixC, DIMENSION, ic * kc, jc * nc, nc, kc, tempAccum);

                // // accumulate the result
                // accumulatorSubMatrixC.add(temp);
                matrixAddInto(tempAccum, tempMult, 2, 2);

                // // place the accumulator back into the large result matrix
                // matrixC.setSubMatrix(jc * nc, ic * kc, nc, kc, accumulatorSubMatrixC);
                setSubMatrix(matrixC, DIMENSION, jc * nc, ic * kc, nc, kc, tempAccum);

            }
        }
    }

    printf("%d\n", iterationCounter);
}
*/

/**/
void standardMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {
    printf("standardMatrixMult()");
    // over row of matrix B
    for (int i = 0; i < rows; i++) {
        // over column of matrix A
        for (int j = 0; j < columns; j++) {
            // fuse row and column together into a single cell of matrix C
            for (int k = 0; k < columns; k++) {

                //matrixC[i * rows + j] += matrixA[i * columns + k] * matrixB[k * columns + j];
                int aIdx = i * columns + k;
                int bIdx = k * columns + j;
                int cIdx = i * rows + j;

                int aVal = matrixA[aIdx];
                int bVal = matrixB[bIdx];

                int temp = aVal * bVal;

                // printf("aIdx: %d", aIdx);
                // printf("bIdx: %d", bIdx);
                // printf("cIdx: %d", cIdx);

                //printf("aVal: %d", aVal);
                //printf("bVal: %d", bVal);

                //printf("aVal: %d", aVal);
                //printf("bVal: %d", bVal);

                int abc = matrixC[cIdx];
                int cde = abc + temp;
                matrixC[cIdx] = cde;
            }
        }
    }
}


// void printMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             printf("%d ", matrix[dim*i + j]);
//         }
//         printf("\n");
//     }
// }

void prettyPrintFormatMatrix(int* matrix, int dim) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            int temp = matrix[idx];
            printf("%d", temp);
        }
    }
}

/*
void prettyPrintFormatMatrix(int* matrix, int dim, const char* format) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            printf(format, matrix[dim*i + j]);
        }
        printf("\n");
    }
}
*/

// void identityMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             matrix[dim*i + j] = (i==j) ? 1 : 0;
//         }
//     }
// }

// void zeroMatrix(int* matrix, int dim) {
//     for (int i = 0; i < dim; i++) {
//         for (int j = 0; j < dim; j++) {
//             matrix[dim*i + j] = 0;
//         }
//     }
// }

void upCountingMatrix(int* matrix, int dim) {
    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {

            int idx = dim * i + j;
            matrix[idx] = count;

            int t = count + 1;
            count = t;
        }
    }
}

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
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1
    };
    int matrixB[ELEMENTS] = {
        1, 2, 4, 2,
        8, 6, 0, 0,
        7, 6, 8, 5,
        8, 4, 7, 5
    };
    int matrixC[ELEMENTS] = {
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    };

    //upCountingMatrix(matrixA, DIMENSION);
    //upCountingMatrix(matrixB, DIMENSION);
    
    //printf("A\n");
    //prettyPrintFormatMatrix(matrixA, DIMENSION);

    // printf("B\n");
    // prettyPrintFormatMatrix(matrixB, DIMENSION);

    int subMatrixB[4] = { 0, 0, 0, 0 };
    getSubMatrix(matrixB, DIMENSION, 0, 0, 2, 2, subMatrixB);
    //getSubMatrix(matrixB, DIMENSION, 0, 0, 2, 2);
    //getSubMatrix(matrixB, DIMENSION);

    printf("subMatrixB\n");
    prettyPrintFormatMatrix(subMatrixB, 2);

    //standardMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);
    //segmentedMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);
    //multiParamTest(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);
    //multiParamTest(matrixA, matrixB, 4, 5);

    //printf("C\n");
    //prettyPrintFormatMatrix(matrixC, DIMENSION);

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

    return 0;
}