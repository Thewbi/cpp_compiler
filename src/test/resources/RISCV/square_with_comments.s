# https://mcyoung.xyz/2021/11/29/assembly-1/
# compile with https://riscvasm.lucasteske.dev/#

        // This tells the assembler to place all code that
        // follows in the `.text` section, where executable
        // data goes.
        .text

        // This is just metadata that tools can use to figure out
        // how the executable was built.
        .file   "square.c"

        // This asks the assembler to mark `square_and_print`
        // as an externally linkable symbol. Other files that
        // refer to `square_and_print` will be able to find it
        // at link time.
        .globl  square_and_print

square_and_print: // This is a label, which gives this position
                  // in the executable a name that can be
                  // referenced. They're very similar to `goto`
                  // labels from C.
                  //
                  // We'll see more labels later on.


        // This is the function prologue, which "sets up" the
        // function: it allocates stack space and saves the
        // return address, along with other calling-convention
        // fussiness.
        addi    sp, sp, -16
        sw      ra, 12(sp)
        sw      s0, 8(sp)

        // This is our `x *= x;` from before! Notice that the
        // compiler rewrote this to `temp = x * x;` at some
        // point, since the destination register is `s0`.
        mul     s0, a0, a0

        // These two instructions load the address of a string
        // constant; this pattern is specific to RISC-V.
        lui     a0, %hi(.L.str)
        addi    a0, a0, %lo(.L.str)
        
        // This copies the multiplication result into `a1`.
        mv      a1, s0

        // Call to printf!
        call    printf

        // Move `s0` into `a0`, since it's the return value.
        mv      a0, s0

        // This is the function epilogue, which restores state
        // saved in the prologue and de-allocates the stack
        // frame.
        lw      s0, 8(sp)
        lw      ra, 12(sp)
        addi    sp, sp, 16
        
        // We're done; return from the function!
        ret

        // This tells the assembler to place what follows in
        // the `.rodata` section, for read-only constants like
        // strings.
        .section        .rodata

.L.str: // Give our string constant a private name. By convention,
        // .L labels are "private" names emitted by the compiler.

        // Emit an ASCII string into `.rodata` with an extra null
        // terminator at the end: that's what the `z` stands for.
        .asciz  "%d\n"