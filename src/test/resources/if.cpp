int funcInt() {
    return 3;
}

char funcChar() {
    return 'c';
}

int main()
{
    //funcInt();

/**/
    // ok
    if (1 > 0) {
    //if (1 > funcInt()) {
    //if ('c' > funcChar()) {
    //if (funcChar() > 'c') {

    // error
    //if (1 > 'c') {
    //if (1 > funcChar()) {
    //if (funcChar() > 1) {
        return 1;
    }

    exit();
    return 0;
}
