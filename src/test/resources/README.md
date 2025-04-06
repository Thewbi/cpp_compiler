# Parsing C from Low Level to High Level

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
int value = get_value(1, get_value());
```

Next declare and initialize pointers

```
int i = 1;
int *ptr = 0;
int *ptr = &i;
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