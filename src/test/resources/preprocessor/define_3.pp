// choose attribute or __declspec implementation
#ifndef _USE_DECLSPECS_FOR_SAL // [
#define _USE_DECLSPECS_FOR_SAL 1
#endif // ]

#if _USE_DECLSPECS_FOR_SAL
    printf("Using _USE_DECLSPECS_FOR_SAL\n");
#else
    printf("Not using _USE_DECLSPECS_FOR_SAL\n");
#endif