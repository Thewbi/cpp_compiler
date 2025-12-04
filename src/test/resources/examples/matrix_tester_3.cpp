#include <stdio.h>

#define DIMENSION 4
#define ELEMENTS DIMENSION*DIMENSION

void init(int *temp_array) {
    temp_array[0] = 15;
}

int main()
{
    //printf("Matrix\n");

    // int matrixA[ELEMENTS] = {
    //     9, 0, 9, 4,
    //     2, 6, 6, 7,
    //     9, 3, 8, 1,
    //     6, 9, 7, 1 
    // };

    int temp_array[3] = { 10, 11, 12 };
    //temp_array[0] = 15;

    init(temp_array);

    printf("temp_array[0]: %d\n", temp_array[0]);
    printf("temp_array[1]: %d\n", temp_array[1]);
    printf("temp_array[2]: %d\n", temp_array[2]);

    // int matrixA[ELEMENTS] = {
    //     1, 2, 3, 4,
    //     5, 6, 7, 8,
    //     9, 10, 11, 12,
    //     13, 14, 15, 16 
    // };

    // matrixA[0] = 77;

/*
    for (int i = 0; i < DIMENSION; i++)
    {
        for (int j = 0; j < DIMENSION; j++)
        {
            int temp = DIMENSION * i + j; // 0, 1, 2, 3, 4, 5, .., 15

            printf("Matrix %d\n", temp);
        }
    }
*/
    exit();
    return 0;
}