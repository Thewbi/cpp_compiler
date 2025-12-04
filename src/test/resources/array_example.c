int main() {

    int numbers[3] = {16, 32, 48}; // 0x10, 0x20, 0x30 

    //printf("%d", numbers[0]);

    numbers[1] = 64; // 0x40

    int idxResult = numbers[1];

    //printf("%d\n", numbers[1]);
    printf("%d\n", idxResult);

    exit();
    return 0;
}