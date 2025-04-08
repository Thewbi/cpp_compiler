//typedef int Integer;

// // anonymous struct is directly typedefed to the new 'person' type
// typedef struct {
// 	char name[50];
// 	int alter;
// } person;

// // first define (named) struct, then typedef it to the new 'STR' type
// struct mystruct {
//     int a;
//     short b;
// };
// typedef struct mystruct STR;

// // combine the two steps above into one (define named struct and directly typedef it to the new 'STR' type)
// typedef struct mystruct {
//     int a;
//     short b;
// } STR;

// declare and initialize variable useing typedefed type
//  STR s1 = {10, 20};

// // https://www.tutorialspoint.com/cprogramming/c_typedef.htm

typedef short unsigned int USHORT;

// typedef signed long SLONG;