# cpp_compiler

C++ compiler written in Java

## TODO

Learn about SSA (Static Single Assignment). See https://yosyshq.readthedocs.io/projects/yosys/en/latest/appendix/primer.html

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
for
structs
pointers
enum
union
switch
```


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