# Parsing C from Low Level to High Level

In the first step, convert the parse tree into an AST by constructing the AST traversing the parse tree. The AST will contain less nodes than the parse tree, effectively it will only contain a condensed version of the parse tree where each node carries meaningful information.

During AST construction step, do not care about semantic correctness. Do not check the amount of parameters to function calls. Do not check for type correctness, do not check anything, just construct the AST. Semantic analysis is part of a later step.

Firstly, collect all bits of information while traversing the ParseTree. For example when parsing a cast, print the source variable of the case, print the target-type that the variable is cast into and print the target variable that will receive the cast value. In a second step, you can then maybe use a callback where the traversal places all these bits of information into a callback-method. The callback can then construct the AST using the information retrieved from the ParseTree traversal. Or alternatively, immediately build the AST during ParseTree traversal by constructing a tree of AST nodes directly.

## main() function

Idealy, you would start with a main() function so you can place test data into the main() function later.
This is important because the grammar only allows statements within functions.

```
int main() {
    return 0;
}
```

## Expressions

Make sure that the AST reflects operator precedence by nesting higher priority operations (e.g. Multiplication and Division) deeper (closer to the leafs) than lower operations (Addition and Subtraction).

```
int a = 1;
int b = (1);
int c = 1 + 2;
int d = (1 + 2);
int e = (1) + (2);
int f = (1) + (2 + 3);
int g = 1 + 2 * 3;
int h = 1 * 2 + 3;
int i = (1 * 2) + 3;
int j = 1 + (2 * 3);
int k = (1 + 2) * 3;
```

## Return statements

```
return 1;
return 1 + 2;
return 1 + 2 + 3;
return (1 + 2) * (3 + 4);
return function_call();
return function_call() + 222;
```

## Variable Declarations

Start with initialization using literal expressions:

```
double i = a;
int i = 10;
float i = 11 + 21;
long i = 1 + j;
int n, reversed = 0, remainder = 1, original;
```

Proceed to initialization using function call expressions.

```
int value = get_value();
int value = get_value(1);
int value = get_value(1, 2);
int value = get_value_c(1, 2, 3 + 4 + 5);
int value = get_value(1, get_value());
int value = get_value_d(1, get_value(1, 2));
int value = get_value_d(1, get_value(1, (2 + 3) * 7));
```

Next declare and initialize pointers

```
int i = 1;
int *ptr = 0;
int *ptr = temp_array;
int *ptr = &i;
int *ptr = &(i);
int *ptr = &(temp_array[129] + 4);
int *ptr = &(temp_array + 4);
```

Test static variables

```
static BOOL transmissionIsRunning;
static UBYTE sendBuffer[MAX_BYTES];
```

## Array Variable Declarations

```
char str[] = "Hello\0World";

int myNumbers[4];
int myNumbers[4 + 5];
myNumbers[0] = 25;
myNumbers[1] = 50;
myNumbers[2] = 75;
myNumbers[3] = 100;
array_a[1 + 2 * 3 + 4] = 25;

int myNumbers[] = {25, 50, 75, 100};
myNumbers[0] = 33;

printf("%d", myNumbers[0]);
```

## Pointer usage

```
dev->addPath(newpoly);
```

## Variable assignments

```
a = 0;
*ptr = &a;
```

## Variable Casting

```
int a = 1;
float b = (float) a;
```

## Function declarations

Parse parameter declarations in prototypes

```
int main(int argc, char *argv[])
{
    return 0;
}
```

Static function declarations

```
static void function_test(UBYTE);
```

## Function Calls

```
printf("Hello World!");

int a;
scanf("%d", &a); // Store keyboard input in a variable with address (address of a or &a)
printf("%d", a);
```

## Statements using Unary Operators

```
bytesTransmitted++;
++bytesTransmitted;

bytesLeft--;
--bytesLeft;
```

## struct declarations

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://github.com/rui314/8cc/tree/master/test

## typedef

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://github.com/rui314/8cc/tree/master/test

## FILE datatype

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://github.com/rui314/8cc/tree/master/test

## if, if-else, if-elseif-else, nested if

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://www.reddit.com/r/TheInsaneApp/comments/pk5163/c_and_c_cheat_sheets/#lightbox
see https://github.com/rui314/8cc/tree/master/test
see https://github.com/rui314/8cc/blob/master/test/control.c

## switch case

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://github.com/rui314/8cc/tree/master/test

## while-loop, for-loop, do-while-loop

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://github.com/rui314/8cc/tree/master/test
