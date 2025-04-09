int main() {

    // yields: selection-statement

    switch (a) {

        case 0:
            a = 0;
            break;

        case 1:
            a = 1;
            break;

        case 2:
            a = 2;
            break;

        default:
            a = 55;
            break;
    }

    // switch (1+2) {
    //     case 0: fail("0");
    //     case 3: a = 3; break;
    //     case 1: fail("1");
    // }

    // switch (100) {
    //     case 0: a++;
    //     default: a = 55;
    // }

}