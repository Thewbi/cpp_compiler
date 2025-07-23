//#define _DEBUG
//#undef _DEBUG
//#define _UNIT_TEST

//#define BUFSIZE 1
//#define BUFSIZE 2048

/**/
#if defined(_DEBUG)
    printf("test A\n");
#endif


/*
#if defined(_DEBUG) || defined(_UNIT_TEST)
  // Code here
  printf("test B\n");
#endif
*/

/*
#if defined _DEBUG || defined _UNIT_TEST
  // Code here
  printf("test C\n");
#endif
*/

/*
#if !defined _DEBUG && defined _UNIT_TEST
  // Code here
  printf("test D\n");
#endif
*/

/*
#if defined BUFSIZE && BUFSIZE >= 1024
  // Code here
  printf("test E\n");
#endif
*/

/*
#if defined (__vax__) || defined (__ns16000__)
  // Code here
  printf("test F\n");
#endif
*/

/*
#if X == 1
...
#else // X != 1
#if X == 2
...
#else // X != 2
...
#endif // X != 2
#endif // X != 1
*/
