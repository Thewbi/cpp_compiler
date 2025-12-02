#define DIMENSION 4
#define ELEMENTS DIMENSION *DIMENSION

int main()
{
    printf("Matrix\n");

    int matrixA[ELEMENTS] = {
        9, 0, 9, 4,
        2, 6, 6, 7,
        9, 3, 8, 1,
        6, 9, 7, 1 
    };

    for (int i = 0; i < DIMENSION; i++)
    {
        for (int j = 0; j < DIMENSION; j++)
        {
            // printf ( "%d" , matrixA [ dim * i + j ] ) ;

            int temp = DIMENSION * i + j;
            // printf("%d: ", temp);

            int val = matrixA[temp];
            printf("%d", val);
            
            //printf("b");
        }
        //printf("\n");

        // printf("a");
    }

    // printf("END");

    return 0;
}