int main() {

    // yields: selection-statement

    switch (1+2) {
        case 0: fail("0");
        case 3: a = 3; break;
        case 1: fail("1");
    }

    switch (100) {
        case 0: a++;
        default: a = 55;
    }

}