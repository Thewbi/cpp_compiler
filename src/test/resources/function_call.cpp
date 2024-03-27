void funcVoid() {
    ;
}

int funcInt() {
    return 3;
}

char funcChar() {
    return 'c';
}

int funcIntParamIntInt(int a, int b) {
    return a;
}

int funcIntParamIntChar(int a, char b) {
     return a;
}

// int length = 0;
// length = funcInt();

/**/
int main()
{
    int length = 0;

    // // ok
    // funcVoid();
    // funcInt();
    // funcChar();
    // funcIntParamIntInt(1, 2);
    // funcIntParamIntChar(1, 'a');
    // length = funcInt();
    // length = funcIntParamIntInt(1, 2);
    // length = funcIntParamIntInt(1+2+3+4+5, 1);
    // length = funcIntParamIntChar(1+2+3+4+5, '2');
    // length = funcIntParamIntInt(1, funcIntParamIntChar(2, '3'));
    // funcIntParamIntInt(1, funcIntParamIntChar(funcIntParamIntInt(1, funcIntParamIntChar(2, '3')), '3'));
    // length = funcIntParamIntInt(1, funcIntParamIntChar(funcIntParamIntInt(1, funcIntParamIntChar(2, '3')), '3'));

    // errors
    //call_to_function_which_is_not_declared();
    //funcInt(1);
    //funcInt(funcVoid());
    //funcIntParamIntInt(1, funcVoid());
    //funcIntParamIntInt(1);
    //length = funcIntParamIntInt(1);
    //funcIntParamIntInt(1, 2, 3);
    //length = funcIntParamIntInt(1, 2, 3);
    //length = funcIntParamIntChar(1, 1);
    //length = funcNotDefined(1+2+3+4+5, 2, 'c', 1.0f, "abc");
    length = funcChar();

    //return length;
    return 0;
}