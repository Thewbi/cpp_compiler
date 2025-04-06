int main() {
    int n, reversed = 0, remainder, original;

    //printf("Enter an integer: ");
    //scanf("%d", &n);

    n = 1001;
    original = n;

    // reversed integer is stored in reversed variable
    while (n != 0) {
        remainder = n % 10;
        reversed = reversed * 10 + remainder;
        n /= 10;
    }

    // palindrome if orignal and reversed are equal
    if (original == reversed)
        //printf("%d is a palindrome.", original);
        return 0;
    else
        //printf("%d is not a palindrome.", original);
        return 1;

    return 0;
}