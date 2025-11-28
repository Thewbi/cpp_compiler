int main()
{
    int length = 3;
    int numbers[3] = {11, 22, 33};

    int count = 77;
    numbers[2] = count;

    int idxResult = numbers[2];

    printf("%d", idxResult);
}