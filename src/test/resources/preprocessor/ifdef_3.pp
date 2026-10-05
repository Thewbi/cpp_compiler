//#if _USE_DECLSPECS_FOR_SAL && defined( MIDL_PASS )

#if _USE_DECLSPECS_FOR_SAL && ( defined( MIDL_PASS ) )

//#if _USE_DECLSPECS_FOR_SAL && ( defined( MIDL_PASS ) || defined(__midl) || defined(RC_INVOKED) || !defined(_PREFAST_) ) // [
//#undef _USE_DECLSPECS_FOR_SAL
//#define _USE_DECLSPECS_FOR_SAL 0
//#endif // ]

//#if _USE_ATTRIBUTES_FOR_SAL && ( !defined(_MSC_EXTENSIONS) || defined( MIDL_PASS ) || defined(__midl) || defined(RC_INVOKED) ) // [
//#undef _USE_ATTRIBUTES_FOR_SAL
//#define _USE_ATTRIBUTES_FOR_SAL 0
//#endif // ]