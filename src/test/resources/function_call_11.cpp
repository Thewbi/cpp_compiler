int function_2(int* matrixB) {

    matrixB[0] = 16;
    matrixB[1] = 32;
    matrixB[2] = 48;
    matrixB[3] = 64;

    return 0;
}

int function_1(int* matrixA) {

    matrixA[0] = 252;
    matrixA[1] = 253;
    matrixA[2] = 254;
    matrixA[3] = 255;

    int result_2 = function_2(matrixA);

    return 0;
}

int main()
{
    int matrixC[4] = {
        1, 2, 3, 4
    };

    int result_1 = function_1(matrixC);

    exit();
    return 0;
}