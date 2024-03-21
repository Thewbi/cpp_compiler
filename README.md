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
