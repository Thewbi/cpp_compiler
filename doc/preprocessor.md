# Preprocessor

The processor will produce one large output file, which in the following is referred to as "output".
While processing the input files, the processor constantly adds information to it's internal state
and applies this knowledge while it processes input.

In general none of the processor commands ever is copied to the output! Once the preprocessor is
done, the output contains pure C.

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