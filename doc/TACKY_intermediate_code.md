# Credits

Writing a C Compiler: Build a Real Programming Language from Scratch (1st Edition, 20 Aug. 2024)
Nora Sandler
Buy on Amazon:
https://www.amazon.com/-/en/Writing-Compiler-Programming-Language-Scratch/dp/1718500424
https://www.amazon.de/-/en/Writing-Compiler-Programming-Language-Scratch/dp/1718500424

# TACKY Intermediate Language Statements

Some general things that are important to know

* Variables have to be declared first before they can be used. Exceptions are temporary variable that are usable via tmp.<index>.
* Variables can be assigned values using the Copy() operation or by using them as destinations of Unary() and Binary() operations.
* It is not allowed to assign a value to a constant
* Variables are created using the Var(identifier) operation
* Constants are created using the Constant(int) operation
* Labels can be defined using the Label(identifier) operation
* Labels can be used as jump targets using the Jump(identifier target), JumpIfZero(val condition, identifier target) and JumpIfNotZero(val condition, identifier target) operations

## Unanswered Questions

How to handle ...
* types such as long, float, double?
* pointers?
* structs?
* typedef?
* enums?
* arrays?
* switch-case statement?

## Constants (Page 36)

The grammar is:

```
Constant(int)
val = Constant(int)
```

Example

```
v1 = Constant(1)
Unary(Negate, Constant(1), Var("tmp"))
```

## Variables

The grammar is:

```
Var(identifier)
val = Var(identifier)
```

Example:

```
v1 = Var("tmp")
Unary(Negate, Constant(1), Var("tmp"))
```

## Copy (for assignments) (Page 110)

The grammar is:

```
src = Constant(int) | Variable(identifier)
dest = Variable(identifier)
Copy(src, dest)
```

Example:

```
var_v = Var("v")
Copy(Constant(0), var_v)
```

## Unary Operator

The grammar is:

```
unary_operator = Complement | Negate | Not

val_src = Var(identifier) | Constant(int)
val_dst = Constant(int)
Unary(unary_operator, val_src src, val_dst dst)
```

Example:

```
Unary(Negate, Constant(1), Var("tmp"))
```

## Binary Operator

The grammar is:

```
binary_operator = Add | Subtract | Multiply | Divide | Remainder | Equal | NotEqual | LessThan | LessOrEqual | GreaterThan | GreaterOrEqual

val_src = Var(identifier) | Constant(int)
val_dst = Constant(int)
Binary(binary_operator, val_src src1, val_src src2, val_dst dst)
```

## Local Variables (Page 111)

```
int main(void) {

    int b;              // line 1
    int a = 10 + 1;     // line 2
    b = a * 2;          // line 3

    return b;           // line 4
}
```

Example:

Note: Page 111 introduces shorthand notations for Binary() and Copy()! Do not get confused!
The comments in the example below mention how to read the shorthand notation.

Note: emission without optimization does not directly assign the result into the target instead the emission outputs a intermediate step of assigning the result to a local variable and in a second step assigns the local variable to the destination.

Assumption, variables are called a.1 and b.0 for some reason.
The emission generates tmp variables by using the well-known name "tpm" and suffising indexes to it which yields:
tmp.2 and tmp3 in this example.

```
// line 1
b.0 = Var("b")

// line 2
a.1 = Var("a")
tmp.2 = 10 + 1      // short for Binary(Add, 10, 1, tmp.2)
a.1 = tmp.2         // short for Copy(tmp.2, a.1)

// line 3
tmp.3 = a.1 * 2     // short for Binary(Mul, a.1, 2, tmp.3)
b.0 = tmp.3         // short for Copy(tmp.3, b.0)

// line 4
Return(b.0)
```

## Labels

The grammar is:

```
Label(identifier)
```

Example:

```
Label("there")
```

## Return Statement

The grammar is:

```
val = Constant(int) | Var(identifier)

Return(val)
```

Example:

```
Return(Constant(0))
Return(Var("tmp"))
```

## Jump (Page 75)

```
| Jump(identifier target)
| JumpIfZero(val condition, identifier target)
| JumpIfNotZero(val condition, identifier target)
```

### JumpIfZero(condition, target) (Page 87)

### JumpIfNotZero(condition, target) (Page 87)

## Function Definition

The grammar is:

```
function_definition = Function(identifier, instruction* body)
```

## main() method

```
int main()
{
    int a;
    int b;

    a = 1;
    b = 3;

    a = b + 2;

    return 0;
}
```

The [ ... ] notation is used to define a list of statements.
Currently the separator between statements is the comma-character ','.

```
function_definition_1 = Function("main",
    [
        // int a; a = 1;
        //Binary(Add, Constant(0), Constant(1), Var(a)),
        var_a = Var("a"),
        Copy(Constant(1), a), // Copy() is mentioned on page 111

        // int b; b = 3;
        //Binary(Add, Constant(0), Constant(3), Var(b)),
        var_b = Var("b"),
        Copy(Constant(3), var_b),

        Binary(Add, var_b, Constant(2), var_a), // a = b + 2;

        return Constant(2)
    ]
)

program = Program(function_definition_1)
```

## If Statements (Page 126)

```
        <instructions for condition>
        c = <result of condition>
        JumpIfZero(c, end)
        <instructions for statement>
Label(end)
```

## If-Else Statements (Page 126)

```
        <instructions for condition>
        c = <result of condition>
        JumpIfZero(c, else_label)
        <instructions for statement1>
        Jump(end)
Label(else_label)
        <instructions for statement2>
Label(end)
```

## While Loops (Page 157)

```
start:  while (<instructions for condition>)
        {
            <instructions for body>
        }
end:
```

```
Label(start)
        <instructions for condition>
        v = <result of condition>
        JumpIfZero(v, end)
        <instructions for body>
        Jump(start)
Label(end)
```

## For Loops

```
start:
        for (<instructions for init> ; continue_label:  <instructions for condition> ; continue_label: <instructions for post>)
        {
            <instructions for body>
        }
break_label:
```

```
        <instructions for init>
Label(start)
        <instructions for condition>
        v = <result of condition>
        JumpIfZero(v, break_label)
        <instructions for body>
Label(continue_label)
        <instructions for post>
        Jump(start)
Label(break_label)
```