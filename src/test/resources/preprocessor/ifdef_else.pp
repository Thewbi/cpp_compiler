//#define DEBUG

/*
#ifdef DEBUG
printf("Debug mode is ON\n");
#else
printf("Debug mode is OFF\n");
#endif
*/

/**/
int main() {

  #ifdef DEBUG
    printf("Debug mode is ON\n");
  #else
    printf("Debug mode is OFF\n");
  #endif

    return 0;
}
