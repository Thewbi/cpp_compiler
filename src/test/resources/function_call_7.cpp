#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

void prettyPrintFormatMatrix(int* matrix, int dim) {
    int ctr = 0;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            int idx = dim * i + j;
            int temp = matrix[idx];
            printf("\t %d", temp);

            int tttt = ctr + 1;
            ctr = tttt;
        }
        printf("\n");
    }
}

void setSubMatrix(int* matrix_dest, int* matrix_src, int dim, int xPos, int yPos, int width, int height) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {

            int temp = i * width + j;
            int tempData = matrix_src[temp];

            int temp2 = (yPos + i) * dim + (xPos + j);
            matrix_dest[temp2] = tempData;
        }
    }
}

int main()
{
    printf("function_call_7\n");

    int matrixC[ELEMENTS] = {
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    };

    int matrix_new[4] = {
        1, 2, 
        3, 4,
    };

    int xPos = 0;
    int yPos = 0;
    int width = 2;
    int height = 2;
    setSubMatrix(matrixC, matrix_new, DIMENSION, xPos, yPos, width, height);

    prettyPrintFormatMatrix(matrixC, DIMENSION);
}