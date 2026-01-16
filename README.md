# cpp_compiler

C++ compiler written in Java

## Usage

Currently this project does not produce an executable. Instead currently the compiler is only usable when debugging the file src\main\java\main\Main.java.

The main() function makes several calls. The Calls to translate a subset of the C-application into RISC-V assembly are:

```
public static void main(String[] args) throws IOException {

    System.out.println("Start");

    preprocessor_2();

    ASTNode rootNode = translationUnit(); // <---------------- C - Compiler

    generateTACKY(rootNode);
    tacky();

    System.out.println("End");
}
```

The preprocessor_2(); function executes the preprocessor. The preprocessor reads the input file C-file. Currently only a single C-file is specified as an input inside preprocessor_2(). Then it will resolve the includes in that files and all recursively included files. The preprocessor resolves defines and then outputs a large C application into the output file "preprocessed.cpp" which is located in the root folder of the project.

The next function call is translationUnit(). This function uses the antlr4 infrastructure to convert the C-file preprocessed.cpp into a tree of nodes. This tree is called Abstract Syntax Tree, AST in the context of this project. The root node of the AST is returned.

The following call to generateTACKY() takes that root node as a parameter and generates TACKY nodes. As a result, the TACKY representation is written into a "generated_tacky.tky" file. The "generated_tacky.tky" is located in the root folder of the project, just like the "preprocessed.cpp" file. TACKY is an intermediate representation and is defined on a Virtual Machine that has infinite amount of registers and memory. There is a test implementation of TACKY which can be used to execute the TACKY scripts in order to evaluate if the TACKY code has the expected effect of the original C-application or not.

The TACKY code is then further processed by the tacky() function. The tacky() function reads the "generated_tacky.tky" again using the antlr4 infrastructure and generates another AST from it. It can print the AST to the console and start a simulation of the TACKY application. tacky() then takes the root node of the TACKY AST and processes it using a RISC code generator:

```
RISCVCodeGenerator riscvCodeGenerator = new RISCVCodeGenerator();

riscvCodeGenerator.start();

for (ASTNode child : rootNode.children) {
    riscvCodeGenerator.execute(child);
}

riscvCodeGenerator.end();
```

The RISCVCodeGenerator class internally maintains a large string buffer (StringBuilder). This buffer will contain the entire RISC-V assembly once code generation is done. The generated RISC-V code is written from the buffer into the file "generated_riscv_assembly.s". "generated_riscv_assembly.s" is contained in the root folder of this project.

This is where the compiler stops processing. In order to get machine code from the "generated_riscv_assembly.s", you need to use an assembler. This compiler will not produce machine code! You can use https://github.com/Thewbi/riscvassembler_java as an assembler if you wish.


## TODO

* Add Scopes to For-Loops so that temporary variables declared inside the scope of a nested loop do not lead to an error for variables declared twice!
* Expressions in array indexer e.g. matrixA[i * rows + j] += matrixB[i * rows + j];
* Function Protoypes
* Function Declarations
* Function Calls
* if statements
* Pointers
* Learn about SSA (Static Single Assignment). See https://yosyshq.readthedocs.io/projects/yosys/en/latest/appendix/primer.html

## Language Bugs

### Order of functions

Currently the assembler is not capable of correctly resolving circular constructs or functions
that are used before they are defined.

Try to create code that represent cycle-less call-graphs and make sure the define functions
before they are called!

### Function Calls without formal parameters do not work

Causes problems:

```
int num = 5;
int factorial_result = factorial();
```

### Function Calls are not emitted if the return value is ignored

Store the return value into a local variable. The compiler will then emit a call instruction.

```
int num = 5;
int factorial_result = factorial(num);
```

### Array Variables need Initializer!

Currently an array variable always has to be initialized:

```
int subMatrixB[4] = { 0, 0, 0, 0 };
```

If it is not initialized, it is not created on the current stack frame!

```
int subMatrixB[4];
```

### For Loops cannot evaluate expressions!

Currently, for loops can only use constraints that are atomic:

```
int xEnd = xPos + width;
for (int i = xPos; i < xEnd; i++) {
    ...
}
```

Constraints that are combined expressions cannot be used!

```
for (int i = xPos; i < xPos + width; i++) {
    ...
}
```

### Postfix Operator ++ does not work

A intermediate variable needs to be used

```
int tttt = ctr + 1;
ctr = tttt;
```

The ++ postfix operator does not work currently.

```
int ctr = 0;
ctr++;
```

### += operator not working

```
matrixA[temp] += matrixB[temp];
```

currently an intermediate value is needed.

```
int tempIndex = i * rows + j;
int tempValue = matrixB[tempIndex];
matrixA[tempIndex] = tempValue;
```


## Phases

See https://en.cppreference.com/w/cpp/language/translation_phases

## Implementation

The compiler will only compile single .cpp files to object files.
It is not possible to specify more than a single .cpp file since this
is a compiler and not a linker.

## Preprocessor

The compiler contains a preprocessor which will resolve #include files
and standard preprocessor commands. A single large .cpp file is created
from pasting the included files into the initial .cpp file. Then this
large .cpp file is compiled into a single object file.

```
#define
#elif
#else
#endif
#error
#if
#ifdef
#ifndef
#import
#include
#line
#pragma
#undef
#using
```

## Linking

Linking of the object files is not part of this compiler.

## TODO

```
add true/false constants
else if
while
do while
elvis operator
for [DONE]
structs
pointers
enum
union
switch
```

## Inline Assembly

Source: https://www.ibiblio.org/gferg/ldp/GCC-Inline-Assembly-HOWTO.html

The whole point of inline assembly is that it allows assembly instructions to
be inserted into C code. The C compiler will pass through the assembly to
the code generation. The inline assembly will part of the output just like
the rest of the generated assembly code.

Inline assembly is usefull if you want to make use of custom assembly
instructions that the C compiler does not know and hence cannot generate.
It is also usefull if you want to access custom registers that the Compiler would
otherwise not be able to access.

## Assembler Syntaxes for x86 assembler

```
+------------------------------+------------------------------------+
|       Intel Code             |      AT&T Code                     |
+------------------------------+------------------------------------+
| mov     eax,1                |  movl    $1,%eax                   |
| mov     ebx,0ffh             |  movl    $0xff,%ebx                |
| int     80h                  |  int     $0x80                     |
| mov     ebx, eax             |  movl    %eax, %ebx                |
| mov     eax,[ecx]            |  movl    (%ecx),%eax               |
| mov     eax,[ebx+3]          |  movl    3(%ebx),%eax              |
| mov     eax,[ebx+20h]        |  movl    0x20(%ebx),%eax           |
| add     eax,[ebx+ecx*2h]     |  addl    (%ebx,%ecx,0x2),%eax      |
| lea     eax,[ebx+ecx]        |  leal    (%ebx,%ecx),%eax          |
| sub     eax,[ebx+ecx*4h-20h] |  subl    -0x20(%ebx,%ecx,0x4),%eax |
+------------------------------+------------------------------------+
```

There are two ways to insert assembly:

1. Basic Inline
1. Extended Asm

### Basic Inline

Two syntaxes is allowed:

```
asm("movl %ecx %eax"); /* moves the contents of ecx to eax */
__asm__("movb %bh (%eax)"); /*moves the byte from bh to the memory pointed by eax */
```

> You might have noticed that here I’ve used asm and __asm__. Both are valid. We can use __asm__ if the keyword asm conflicts with something in our program. If we have more than one instructions, we write one per line in double quotes, and also suffix a ’\n’ and ’\t’ to the instruction. This is because gcc sends each instruction as a string to as(GAS) and by using the newline/tab we send correctly formatted lines to the assembler.

```
asm ("movl %eax, %ebx\n\t"
    "movl $56, %esi\n\t"
    "movl %ecx, $label(%edx,%ebx,$4)\n\t"
    "movb %ah, (%ebx)");

__asm__ ("movl %eax, %ebx\n\t"
        "movl $56, %esi\n\t"
        "movl %ecx, $label(%edx,%ebx,$4)\n\t"
        "movb %ah, (%ebx)");
```

When inspecting the Parse Tree that the cpp antlr grammar generates using http://lab.antlr.org/ it can be seen that the asm variant produces different ast nodes then the __asm__ variant. The asm variant produces a way simpler parse tree with an explicit asnDefinition node!



### Extended Asm

To complicated for me to implement.

## RISC V

Goal: Build a RISC V assembler, instruciton decoder and simulator.

1. A lexer/parser that parses a GAS syntax input file into line objects
1. A preprocessor takes line objects and resolves .inc assembly instructions. This will create a single large preprocessed.s file
1. The preprocessed.s file goes through the lexer/parser once again which again produces line objects.
1. The assembler takes instructions in the form of line objects and produces binary files where instructions are encoded in machine language.
1. The instruction decoder can read and decode binary files and it produces instructions in the form of line objects.
1. The simulator executes instructions in the form of line objects.

To run the simulator, line objects (= instructions) are required.
Line objects can be produced from two sources:
1. The lexer/parser run on the preprocessed.s file
2. The instruction decoder run on the binary file

As a first step, line objects are taken from the preprocessed.s file. This means the assembler and decoder are not required
and no binary files are produced and decoded.
Step one only requires the lexer/parser, the preprocessor to produce the preprocessed.s and then the simulator.

In a second step, the assembler and instruction decoder are added. The source of line objects (= instructions) then
is the binary file.

* Write grammar for GNU assembler's (GAS) syntax including assembler instructions (not only ISA assembly statements)
* Make sure the ABI register names are understood and also the raw register names are understood
* Parse .s file into lines and resolve .inc assembly instructions. This will create a single large preprocessed.s file
* Go through and indetify addresses for labels
* Produce line objects
* Write a simulator for line objects


# Adding a new CPU architecture (RISC V, MIPS, x86, ...)

1. Create a new folder for your architecture (e.g. cpp_compiler\src\main\java\mips)
2. Collect many, many sample assembler example programms in your language so you know what the grammar has to be able to process. Store the examples into the test\resources folder: cpp_compiler\src\test\resources\MIPS\add.s
3. Write a lexer and parser that parses the source code (assembly). Antlr4 .g4 files go into the C:\aaa_se\cpp_compiler\src\main\antlr4\com\cpp\grammar folder so that the antlr4 maven plugin will process them.
4. Write a ParserListener. ParserListenerS derive from the BaseParserListeners generated by antlr4. They go into the new architecture's folder.
5. Define the classes for the registers (template: RISCVRegister.java) and the instructions (template: RISCVInstruction.java) and instruction type (template: RISCVInstructionType.java)
6. Define a row type that fits the need of your architecture. As an example or template, take a look at RISCVRow.java.
7. Implement the ParserListener. The ParserListener has to output a collection of your new RowType (MIPSRow).
8. Define a specific byte[] buffer to store your machine code (Harvard-Architecture where code and data are pyhsically separated into distinct memories), or if you want to write the machine code directly into the memory (Von-Neumann architecture where a single memory contains code and data), prepare the memory of your computer system.
9. Define an encoder class and assign the code-memory buffer to the encoder class so that it can insert the machine code into the memory.
10. Define your CPU (as an example or template check out: riscv.DecodingRISCVProcessor). The CPU has to have a reference to the memory that contains the machine code.
11. Write a Decoder (see riscv.RISCVInstructionDecoder) and assign it to the CPU. The Decoder has to access the code memory at the location stored in the CPU's program counter (PC).
12. The Decoder has to convert a machine code instruction into another RowType (see grammar.ExplicitRISCVRow). The Decoder has to have a methode which takes the machine instruction as input, decodes it and returns the resulting RowType (e.g. grammar.ExplicitRISCVRow). The RowType will provide the opcode, registers, immediate values, offsets in a convenient manner.
13. Implement the CPU. The CPU will have a PC (program counter) register that points into the code memory onto the next instruction to execute. The CPU will fetch the word of machine code at the current PC. It will decode that word of machine code into a row (e.g. grammar.ExplicitRISCVRow). It will then execute that machine instruction.
14. Write a driver (= fancy word for a main() function that executes your code) which parses the source code, calls the encoder on the rows and then assigns the memory to your CPU. Then run the CPU in the driver.
15. Implement the UI. Implement the interfaces common.IRegisterFile and common.IMemory. As templates, check out riscv.DefaultMemory and riscv.DefaultRegisterFile.
16. Follow ide.App.start(Stage primaryStage) as a template to see how to put together a GUI.
17. Implement the Assemble and the Step Buttons. Assemble will call the parser on the source code currently pasted into the GUI. Step will make the CPU perform a single step (exceute the machine code at the current PC).