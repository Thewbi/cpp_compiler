void upCountingMatrix(int* matrix, int dim) {
    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            matrix[dim*i + j] = count;
            count++;
        }
    }
}

int main()
{
    int matrixA[ELEMENTS] = {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10, 11, 12,
        13, 14, 15, 16
    };

    upCountingMatrix(matrixA, 16);

    for (int i = 0; i < length; i++)
    {
        printf("a");
    }

    return 0;
}