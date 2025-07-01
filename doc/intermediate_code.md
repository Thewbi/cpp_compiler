# Goals

The purpose of intermediate code is to provide an abstract layer that is agnostic to the source language and also agnostic to the target platform. The gain is to have a layer that can be reused when the source language or the target platform is changed.

Another important function is, once a source and target agnostic layer is available, it is worthwhile to spend considerable amount of resources on creating optimizations that modify this abstract layer.

The optimized intermediate language code is then forwarded to the code generation for a specific target.

# Machine Model

- Infinite registers. All registers are general purpose, none of them has any special meaning.
- A single return register r.
- Stack for StackFrames
- Infinite Memory for instructions and also data with linear address space. The memory does not have byte-sized cells and no addresses. Instead it stores datatypes and each data type has an index in memory. Instead of referencing a memory cell by address, a memory cell is referenced by index.
- Instructions in Memory do not have a fixed byte size. They are modeled as data types


# Example Compilation

```
int main() {

	int i;

	for (i = 0; i < 5; i++) {
	    printf("%d\n", i);
	}

	return 123;
}
```


## Action: function_call main()

When a function is called, a new stack frame is placed onto the stack.

```
pushStackFrame()
```

## Action: int i;

When a new variable is declared, the variable is inserted into the current stack frame. No memory cell is used for the local variable.

```
VariableStackFrameEntry {
	name: i
	type: int
	register: register_index
}
```

The register_index is the index of one of the registers of the machine model.
This register is used to work with the variable.
The register_index has to be retrieved by calling getNextRegisterIndex().
The job if getNextRegisterIndex() is to determine the first register that is currently unused.

Intermediate Code Generation will produce:

```
addStackFrameEntry(i, int, register_index)
```

## Action: i = 0;

First the system searches the variable 'i' in the current stackframe. Now the system has access to the 'register_index' value.

Intermediate Code Generation produces the instruction:

```
loadRegister(register_index, 0)
```

At this point, the register is loaded with value 0 which means the variable is initialized with it's value 0.

## Action: i < 5;

Intermediate Code Generation produces the instruction:

```
loop_start: 	bge(i, 5, loop_end)
loop_end:
```

Because the code generation knows that it currently generates code for a for-loop, the branch will jump to loop_end memory-index, when the local variabl i is not satisfying the condition any more. (i >= 5).

Note: it is actually easier to check the original condition instead of inverting it.

```
loop_start: 	blt(i, 5, loop_body)
				j(loop_end)
loop_body:
loop_end:
```


## Action: on enter the body of the for-loop

A new stack frame is created.

Intermediate Code Generation produces the instruction:

```
pushStackFrame()
```

## Action: printf("%d\n", i);

Intermediate Code Generation: see function_call main() and also just body blocks in general.

```
pushStackFrame()
	...
popStackFrame()
```

or

```
call(printf, "%d\n", i.register_index)
```





This will read the value of the local variable i, add the immediate value 1 to it and store the result back to the register_index of i.

## Action: on end of the body of the for-loop

The instruction i++ is executed:

### Action: i++

First the system searches the variable 'i' in the current stackframe. Now the system has access to the 'register_index' value.

Intermediate Code Generation produces the instruction:

```
addi(i, i, 1)
```

### Action: on end of the body of the for-loop

The loop jumps back to the loop_start start label

```
j(loop_start)
```

## Action: end of the main function, return 123;

```
loadRegister(r, 123) // return 123;
popStackFrame()
```

# The complete generated code is

```
// main function is entered
pushStackFrame()

// int i
addStackFrameEntry(i, int-type, register_index)

// i = 0
loadRegister(register_index, 0)

// for-loop body is entered
pushStackFrame()

loop_start: 	blt(i, 5, loop_body)
				j(loop_end)

loop_body: 		call(printf, "%d\n", i.register_index)

				// increment for loop variable
				addi(i, i, 1)

				// start next iteration of the for loop
				j(loop_start)
loop_end:

// for-loop body is exited
popStackFrame()

// return 123
loadRegister(r, 123)

// main function is exited
popStackFrame()
```