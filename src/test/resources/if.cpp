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
    //if (1 > 0) {
    //if (1 > 'c') {
    if (1 > funcInt()) {
    //if (1 > funcChar()) {
        return 1;
    }

    return 0;
}
