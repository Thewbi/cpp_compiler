// https://www.geeksforgeeks.org/c/c-program-for-factorial-of-a-number/

#include <stdio.h>

int factorial(int n) {

    // printf("factorial\n");

    // Base Case:
    if (n == 1)
    {
        return 1;
    }

    // Multiplying the current N with the previous product
    // of Ns

    // return n * factorial(n - 1);
    int temp = n - 1;
    int factorial_result = factorial(temp);
    int result = n * factorial_result;

    // printf("factorial of %d is %d\n", n, result);

    return result;
}

int main() {

    // printf("main\n");

    int num = 2;
    int factorial_result = factorial(num);

    printf("factorial of %d is %d\n", num, factorial_result);

    exit();
    return 0;
}