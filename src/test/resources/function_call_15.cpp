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

    // printf("getSubMatrix()\n");

    /**/
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
            //putint(idx);
            //putint(transfer);
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

    // printf("setSubMatrix()\n");

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

    int subMatrixA[4] = { 0, 0, 0, 0 };
    int subMatrixB[4] = { 0, 0, 0, 0 };

    //int sub_matrix_1 = getSubMatrix(subMatrixB, matrixB, DIMENSION, 0, 0, 2, 2);
    // int resultPrettyPrint = prettyPrintFormatMatrix(subMatrixB, SUB_DIMENSION);

    // int subMatrixTemp[4] = { 81, 82, 83, 84 };
    // int a244 = setSubMatrix(matrixB, subMatrixTemp, DIMENSION, 0, 0, 2, 2);

    // for jc = 0 to n-1 step nc
    // Loop 1
    for (int jc = 0; jc < rowSteps; jc++) {

        // for pc = 0 to k-1 step kc
        // Loop 2
        for (int pc = 0; pc < columnsSteps; pc++) {

            int xPos_b = pc * kc;
            int yPos_b = jc * nc;
            int sub_matrix_1 = getSubMatrix(subMatrixB, matrixB, DIMENSION, xPos_b, yPos_b, kc, nc);

            // test 1
            int resultPrettyPrintB = prettyPrintFormatMatrix(subMatrixB, SUB_DIMENSION);
            int separator = 123;
            putint(separator);

            // int sub_matrix_2 = getSubMatrix(subMatrixA, matrixA, DIMENSION, xPos_b, yPos_b, kc, nc);

            // // test 1
            // int resultPrettyPrintA = prettyPrintFormatMatrix(subMatrixA, SUB_DIMENSION);
            // int separator2 = 124;
            // putint(separator2);


/**/
            // for ic = 0 to m-1 step mc
            // Loop 3
            for (int ic = 0; ic < innerSteps; ic++) {

                int xPos_a = ic * mc;
                int yPos_a = pc * kc;

                int sub_matrix_2 = getSubMatrix(subMatrixA, matrixA, DIMENSION, xPos_a, yPos_a, mc, kc);

                // test 1
                int resultPrettyPrintA = prettyPrintFormatMatrix(subMatrixA, SUB_DIMENSION);
                int separator2 = 124;
                putint(separator2);

            }


        }

    }

    return 0;
}




int main()
{
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

    int result_1 = segmentedMatrixMult(matrixA, matrixB, matrixC, DIMENSION, DIMENSION);

    exit();
    return 0;
}