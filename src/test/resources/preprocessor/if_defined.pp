/**/
#if defined(_DEBUG) || defined(_UNIT_TEST)
  // Code here
#endif


/*
#if defined _DEBUG || defined _UNIT_TEST
  // Code here
#endif
*/

/*
#if !defined _DEBUG && defined _UNIT_TEST
  // Code here
#endif
*/

/*
#if defined BUFSIZE && BUFSIZE >= 1024
  // Code here
#endif
*/

/*
#if defined (__vax__) || defined (__ns16000__)
  // Code here
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
