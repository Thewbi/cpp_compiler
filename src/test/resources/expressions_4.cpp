int main()
{
    int length = 3;
    int numbers[3] = {11, 22, 33};

    int i = 1;
    int j = 1;
    int temp = i + j;
    int idxResult = numbers[temp];

    // TODO: this does not work yet!!!!!!!!! Need intermediate variable currently!!!
    //int idxResult = numbers[i+j];

    printf("%d", idxResult);
}