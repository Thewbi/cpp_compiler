int main() {

    int array_a[4];
    int array_b[4 + 3];
    array_a[0] = 25;
    array_a[1 + 2 * 3 + 4] = 25;

    char str[] = "Hello\0World";

    int myNumbers[4];
    int myNumbers[4 + 5];
    myNumbers[0] = 25;
    myNumbers[1] = 50;
    myNumbers[2] = 75;
    myNumbers[3] = 100;
    array_a[1 + 2 * 3 + 4] = 25;

}