# Preprocessor

The processor will produce one large output file, which in the following is referred to as "output".
While processing the input files, the processor constantly adds information to it's internal state
and applies this knowledge while it processes input.

In general none of the processor commands ever is copied to the output! Once the preprocessor is
done, the output contains pure C.

## All Statements

https://www.cprogramming.com/reference/preprocessor/

```
#include
#define
#undef
#if
#ifdef
#ifndef
#error
__FILE__
__LINE__
__DATE__
__TIME__
__TIMESTAMP__
pragma
# macro operator
## macro operator
```

## include

```
#include "funcs.h"
```

the file is searched and the include process starts:
1. Read the file, line by line and immediately process the line. (Do not only copy it to the output!)
2. Copy the processed lines to the output.
3. Ignore the line that contains the #include statement. It is not copied to the output.

## define

```
#define <SYMBOL_A>
```

Example:

```
#ifndef FUNCS_H
#define FUNCS_H
```

Place <SYMBOL_A> into the define-Map and map it to the empty-symbol.

```
#define <SYMBOL_A> <SYMBOL_B>
```

Example:

```
#define TRUE_ (1)
#define FALSE_ (0)

#define abs(x) ((x) >= 0 ? (x) : -(x))
#define min(a,b) ((a) <= (b) ? (a) : (b))
#define max(a,b) ((a) >= (b) ? (a) : (b))
```

Place <SYMBOL_A> into the define-Map and map it to the <SYMBOL_B>-symbol.

```
#define SQUARE(x) ((x) * (x))
```
Tree:
root___
    1.#define
    2.SQUARE
        (
            x
        )
    3.(
        (
            x
        )
        *
        (
            x
        )
    )

## Usage of a symbol

Example:

```
#define abs(x) ((x) >= 0 ? (x) : -(x))

if (abs(j) == 1 || abs(j) == 8) {
    goto L100;
}
```

1. For the current line, the preprocessor has to identify all <SYMBOL_A>s in the input line!
1. Detect abs(j) because it is part of the define-Map.
1. Retrieve the <SYMBOL_A>-symbol from the define-Map which yields abs(x).
1. Match x = j
1. Retrieve the mapped <SYMBOL_B>-symbol which is ((x) >= 0 ? (x) : -(x)).
1. Take the <SYMBOL_B>-symbol and perform a replacement of x by j (as identified in step 3). This yields ((j) >= 0 ? (j) : -(j)).
1. In the source code that uses the <SYMBOL_A>, perform a literal replacement of abs(j) with the result of step 5.

The result of the steps defined above applied to the example is:

```
if (((j) >= 0 ? (j) : -(j)) == 1 || ((j) >= 0 ? (j) : -(j)) == 8) {
    goto L100;
}
```

Copy these lines to the output.

## ifdef

https://gcc.gnu.org/onlinedocs/gcc-3.0.2/cpp_4.html
https://stackoverflow.com/questions/3390603/can-boolean-operators-be-used-with-the-preprocessor

```
#ifdef <SYMBOL>
	<BLOCK>
#endif
```

Process <BLOCK> and copy the result to the output only if <SYMBOL> is defined (= contained in the define-Map)!

## ifndef

```
#ifndef <SYMBOL>
	<BLOCK>
#endif
```

Process <BLOCK> and copy the result to the output only if <SYMBOL> is NOT defined (= NOT contained in the define-Map)!



# Preprocessor Test 1

```
#define orp ((integer *)&orphs_1)

printf("ORPHS= %7d%7d%7d%7d%7d%7d\n",
	   orp[0], orp[1], orp[2], orp[3], orp[4],
       last_1.lastit);
```

yields

```
printf("ORPHS= %7d%7d%7d%7d%7d%7d\n",
	   ((integer *)&orphs_1)[0], ((integer *)&orphs_1)[1], ((integer *)&orphs_1)[2], ((integer *)&orphs_1)[3], ((integer *)&orphs_1)[4],
        last_1.lastit);
```

# Preprocessor Test 2

```
#define P(x) ()
```

The symbol P(x) is converted to the AST:

```
P
    (
        x
    )
```

Input:

```
newsta_ P((integer, integer, integer, integer, integer)),
```

builds the AST:

```
root
    newsta_
    P
        (
            (
                integer
                ,
                integer
                ,
                integer
                ,
                integer
                ,
                integer
            )
        )
    ,
```

The node P ( ... ) is matched to P(x).
Perform a search through the tree (depth first by recursion)
check each node's name and search for the name in the define-Map.

If it is found: P ( ... ) is replaced with ( ).

The result is:

```
newsta_ (),
```

# Preprocessor Test 3

```
#ifdef INIT
	= { 2164, 0, 4200, 0, 15160, 0, 1600, 0, 2160, 0, 32325, 0,
	    29654, 0, 11800, 0, 26335, 5005, 0, 0 }
#endif
	;
```

the line = { 2164, 0, 4200, 0, 15160, 0, 1600, 0, 2160, 0, 32325, 0,

Q: Is this line parsed at all? There is no #define, we do not need to parse it!
A: Yes, we need to parse the line since it might contain defines that need to be matched and replaced!

is parsed into the asymetrical AST because there is not closing } bracket!
Asymetrical AST may exist!

```
root
    =
    {
        2164
        ,
        0
        ,
        4200
        ,
        0
        ,
        15160
        ,
        0
        ,
        1600
        ,
        0
        ,
        2160
        ,
        0
        ,
        32325
        ,
        0
        ,
```

# Example 4

```
#define SQUARE(x) ((x) * (x))

int main() {
  printf("Square of 4: %d\n", SQUARE(4));
  return 0;
}
```

```
#define DEBUG

int main() {
  #ifdef DEBUG
    printf("Debug mode is ON\n");
  #endif
  return 0;
}
```

https://github.com/hirrolot/metalang99


# Implementation

1. Implement a lexer that returns all the token in one stream per input-file
2. On every newline token, also start a new line in the preprocessor (delete the current asymetric AST because it is not needed any more)
3. Implement asymetric AST generation from input line
4. Implement node search against define-map
5. Implement replace

# Processing if-statements

```
#define _DEBUG
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
```

An #if is detected: A new stackframe is placed on the scope-stack

The #if, #elif is detected:
    If the ifProcessed flag is true, no evaluation is performed, no output is produced
    If the ifProcessed flag is false, the expression is evaluated.
        If the expression yields a true result, the flag ifProcessed is set to true in the current scope-stack frame.
        Output for that branch is produced.
        If the expression yields a false result, proceed to the next #if, #elif

An #endif is detected: The current stackframe is popped from the scope-stack