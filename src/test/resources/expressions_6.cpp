#include "stdio.h"

int main()
{
    int rows = 4;
    int nc = 2;
    int rowSteps = rows / nc;

    printf("%d", rowSteps);

    return 0;
}