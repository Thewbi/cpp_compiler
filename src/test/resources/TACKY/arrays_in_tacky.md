# Memory Layout for Local Variabels (No Dynamic Memory Allocation)

The TACKY grammar itself does not contain any elements, to describe the size of an array variable, i.e. how many elements the array has. This information is not available to modules using the TACKY intermediate language AST or a TACKY interpreter.

This means that the memory layout has to be created by another module besides TACKY! Some other module has to read in all variables including information about their types and array sizes and needs to create a memory layout for all the variables.

This module is called the memory layout module. The task of the memory layout module is it to design stack frames for functions. The overall idea is that whenever a function (including the main entry point, main()) is called, a stack frame is created and placed on the stack. The stack is nothing but a part of the data memory. The only thing that makes the stack special is that a stack pointer is maintained by the programming language runtime to point to the stack in memory. The stack frame has to contain memory for all local variables used in the function. The memory layout module will design stack frames but not yet assign memory addresses to the variables. Assigning real memory addresses can only be done at runtime.

Dynamically allocated memory is performed on a heap datastructure that lives in memory but is not part of the stack. This discussion only deals with local variables that are not created using dynamic memory allocation.

The memory layout module determines if a variable is (spilled into memory) located in memory or in a register. If the variable is contained in memory, the stack frame layout will contain a variable object for that variable. This variable object is flagged as memory-type and not register-type so that the TACKY Interpreter knows that the variable is not a register variable but a variable located in memory.

When a new function is called during runtime, the TACKY interpreter will create a stack frame object which is constructed acording to the stack frame layout for that function. In Java, the stack frame layout could be deep-cloned, the deep-clone them becomes the stack frame object. It will then iterate over variable objects contained in the newly created stack frame object and place them all on the stack if they are of memory-type (not register-type). While it places them on the stack, it can determine real memory addresses and assign them to the memory-type variables objects in the stack frame object.

These real memory addresses are then available to the TACKY interpreter. The TACKY interpreter can now perform pointer arithmetic on the array variable to acceess the elements of the array.

The TACKY interpreter does not use the information how many elements an array has. Instead, it just retrieves the address of the array base pointer and performs pointer arithmetic on that array base pointer.

Whenever you read TACKY instructions that deal with arrays, rest assured that you will not find information about array sizes in the TACKY code. TACKY contains only statements that read and write array elements or perform pointer offsets. TACKY contains no instructions that create an array variable including the element size. Instead TACKY only contains the var() function to create a function that deals as the array's base pointer. There is no information about the amount of elements. The stack frame layout has already reserved enough memory to store all the variable's elements.

The TACKY interpreter could be implemented to check if the user performs out of bounds operations on arrays. Standard C does not perform those checks so this is optional behaviour. The TACKY interpreter just hopes or assumes that the code that it executes is thouroghly semantically checked and out-of-bounds errors have been caught in a stage prior the TACKY code generation.