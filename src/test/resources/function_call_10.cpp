#include "stdio.h"

int test(int dim) {
    
    for (int i = 0; i < dim; i++) {
        printf("test\n");
    }

    return 0;
}

int test2(int dim) {
    
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            printf("test2\n");
        }
    }

    return 0;
}

int main()
{
    int count = 4;
    int result = test2(count);

    exit();
    return 0;
}