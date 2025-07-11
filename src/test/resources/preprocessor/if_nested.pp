#define _DEBUG 1
#define _UNIT_TEST

#define _DEBUG_INNER
#define _UNIT_TEST_INNER

#define _DEBUG_INNER_2
#define _UNIT_TEST_INNER_2

#if defined(_DEBUG) || defined(_UNIT_TEST)
  printf("a");
  #if defined(_DEBUG_INNER) || defined(_UNIT_TEST_INNER)
    printf("b");
  #elif defined(_DEBUG_INNER_2) || defined(_UNIT_TEST_INNER_2)
    printf("c");
  #else
    printf("d");
  #endif
#else
  printf("e");
#endif