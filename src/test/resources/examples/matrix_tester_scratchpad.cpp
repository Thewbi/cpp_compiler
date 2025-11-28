#define DIMENSION 4
#define ELEMENTS DIMENSION *DIMENSION

int main()
{
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1};

    for (int i = 0; i < DIMENSION; i++)
    {
        for (int j = 0; j < DIMENSION; j++)
        {
            // printf ( "%d" , matrixA [ dim * i + j ] ) ;
            printf("b");
        }
        //printf("\n");

        printf("a");
    }

    printf("END");

    return 0;
}