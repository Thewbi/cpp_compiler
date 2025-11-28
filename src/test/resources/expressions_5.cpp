int main()
{
    int length = 3;
    int numbers_a[3] = {11, 22, 33};
    int numbers_b[3] = {11, 22, 33};

    //int i = 1;
    //int j = 1;
    //int temp = i + j;

    // TODO: this does not work yet!!!!!!!!! Need intermediate variable currently!!!

    int temp_a = numbers_a[0];
    int temp_b = numbers_b[0];
    int idxResult = temp_a + temp_b;

    // TODO: this does not work yet!!!!!!!!! Need intermediate variable currently!!!
    //int idxResult = numbers[i+j];

    printf("%d", idxResult);
}