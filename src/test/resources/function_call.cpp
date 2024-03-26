int func3() {
    return 3;
}

char funcChar() {
    return 'c';
}

int funcIntParam(int a, int b) {
    return a;
}
// int funcIntParam(int a, char b) {
//     return a;
// }

int main()
{
    int length = 0;

    //length = func3();
    //length = funcChar();

    //length = funcIntParam(1);
    //length = funcIntParam(1, 2);
    //length = funcIntParam(1, 2, 3);
    //length = funcIntParam(1+2+3+4+5, '2');
    //length = funcIntParam(1+2+3+4+5, 1);
    //length = funcIntParam(1+2+3+4+5, 2, 'c', 1.0f, "abc");

    length = funcIntParam(1, funcIntParam(2, 3));

    return length;
}