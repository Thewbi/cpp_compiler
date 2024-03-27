/*
void func1() {
    ;
}
*/
/*
void func2() {
    ;
}
*/

/*
int func3() {
    return 1;
}
*/

/*
void func4(int a) {
    ;
}
*/

/*
void func4(int a, float b) {
    ;
}
*/

int func5(int a, float b) {
    return a;
}


// error - parameter is not defined but returned
int func6(int a, float b) {
    return c;
}