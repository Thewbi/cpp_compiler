int main() {

    // yields: selection-statement

    // simple

    if (true)
        int a;

    if (true) {
        int a;
    }

    if (true) {
        return 0;
    } else {
        return 1;
    }

    // nested

    if (true)
        if (false)
            int a;

    return 0;

}