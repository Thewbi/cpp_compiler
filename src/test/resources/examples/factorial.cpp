// https://www.geeksforgeeks.org/c/c-program-for-factorial-of-a-number/

#include <stdio.h>

int factorial(int n) {
  
    // Base Case:
    if (n == 1) 
    {
        return 1;
    }

    // Multiplying the current N with the previous product
    // of Ns

    // return n * factorial(n - 1);
    int factorial_result = factorial(n - 1);
    int result = n * factorial_result;
    return result;
}

int main() {
    int num = 5;
    //printf("Factorial of %d is %d", num, factorial(num));

    factorial(num);

    exit();
    return 0;
}