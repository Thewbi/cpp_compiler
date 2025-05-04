https://stackoverflow.com/questions/16642291/address-of-a-variable-stored-in-a-register

# Question:

If somewhere in my code, I use the address of a variable (pass it to some other
function, for example), the compiler will automatically choose to store it in
memory? (as opposed to the possibility of storing it in a register).

Otherwise, what happens if I ask for the address of a variable like that
(stored as register)? I know we can't take the address of variables explicitly
set to register (register int c).

For example, if i do something like

```
int c = 1;
print("Address of c: %p", &c);
```

Then this variable couldn't be stored in a register, could it?
The compiler would automatically set it as stored in memory? Otherwise
(if it is just stored in a register), what would be the address shown in the screen?

# Answer:

First, the C Standard prohibits taking the address of a variable that is declared register,
just as it does for bit fields in structs.

For non-register ("auto") variables, the short answer is yes.
The simplest strategy of an optimizer is to immediately spill variables whose addresses are taken.

"Spill" is just a term from the literature of register allocation meaning "decide to place in memory rather than a register."

A sophisticated optimizer can do an alias analysis and still hold a value in a
register, even though its address has been taken. This is possible wherever it
can be proven that the resulting pointer can't possibly be used to change the value.

Another relevant optimization is live range splitting. This allows a variable
to be stored in a register for part of the range of instructions where it's
holding a useful value (its "live range") and to be spilled in other parts.
In this case the spilled parts would correspond to places where the pointer
might be used to change the variable's value. For example:

```
x = 3;
... lots of computations involving x
if T {
  // SPILL HERE, so store register holding x to memory
  int *p = &x;
  ... lots of computations, perhaps using p to change x
  *p = 2;
  // DONE SPILL HERE, so reload register
  ... more code here not using p to change x.
}
else {
  ... lots of computations involving x.
}
```

An aggressive optimizer of this code might allocate a stack position for x,
but load it into a register at the top of the code, maintaining it there except
for the region marked as a SPILL. This region would be surrounded by a store of
the register to memory and a matching register load.