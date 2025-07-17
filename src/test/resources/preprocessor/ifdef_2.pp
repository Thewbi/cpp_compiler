//#define __STDC__

#ifdef __STDC__

#define P(x) x

#else

#define P(x) ()
#define void int
#define const

#endif