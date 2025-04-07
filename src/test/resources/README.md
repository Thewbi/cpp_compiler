# Parsing C from Low Level to High Level

In the first step, convert the parse tree into an AST by constructing the AST traversing the parse tree. The AST will contain less nodes than the parse tree, effectively it will only contain a condensed version of the parse tree where each node carries meaningful information.

During AST construction step, do not care about semantic correctness. Do not check the amount of parameters to function calls. Do not check for type correctness, do not check anything, just construct the AST. Semantic analysis is part of a later step.

## main() function

Idealy, you would start with a main() function so you can place test data into the main() function later.
This is important because the grammar only allows statements within functions.

```
int main() {
    return 0;
}
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
```

Next declare and initialize pointers

```
int i = 1;
int *ptr = 0;
int *ptr = &i;
```

## Array Variable Declarations

```
char str[] = "Hello\0World";

int myNumbers[4];
myNumbers[0] = 25;
myNumbers[1] = 50;
myNumbers[2] = 75;
myNumbers[3] = 100;

int myNumbers[] = {25, 50, 75, 100};
myNumbers[0] = 33;

printf("%d", myNumbers[0]);
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

## Function Calls

```
printf("Hello World!");

int a;
scanf("%d", &a); // Store keyboard input in a variable with address (address of a or &a)
printf("%d", a);
```

## if, if-else, if-elseif-else, nested if

see https://www.codewithharry.com/blogpost/c-cheatsheet/
see https://www.reddit.com/r/TheInsaneApp/comments/pk5163/c_and_c_cheat_sheets/#lightbox

## switch case

see https://www.codewithharry.com/blogpost/c-cheatsheet/

## while-loop, for-loop, do-while-loop

see https://www.codewithharry.com/blogpost/c-cheatsheet/

## struct declarations

see https://www.codewithharry.com/blogpost/c-cheatsheet/

## typedef

see https://www.codewithharry.com/blogpost/c-cheatsheet/

## FILE datatype

see https://www.codewithharry.com/blogpost/c-cheatsheet/