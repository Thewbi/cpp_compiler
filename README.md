# cpp_compiler
C++ compiler written in Java

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