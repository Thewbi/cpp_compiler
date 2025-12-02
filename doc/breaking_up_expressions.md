# Breaking Up Expressions

## Problems

```
int result = DIMENSION * i + j;
```

```
int temp_1 = DIMENSION * i;
int temp_2 = temp1 + j;
int result = temp_2;
```

```
mul t0, DIMENSION, i
add t1, t0, j
mv result, t1
```