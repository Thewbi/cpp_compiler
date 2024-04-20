# https://mcyoung.xyz/2021/11/29/assembly-1/
# compile with https://riscvasm.lucasteske.dev/#

.text
        .file   "square.c"
        .globl  square_and_print
square_and_print:
        addi    sp, sp, -16
        sw      ra, 12(sp)
        sw      s0, 8(sp)
        mul     s0, a0, a0          
        lui     a0, %hi(.L.str)
        addi    a0, a0, %lo(.L.str)
        mv      a1, s0
        call    printf              
        mv      a0, s0
        lw      s0, 8(sp)
        lw      ra, 12(sp)
        addi    sp, sp, 16
        ret
        
printf:
	ret

        .section        .rodata
.L.str:
        .asciz  "%d\n"



# ff010113
# 00112623
# 00812423
# 02a50433
# 03400513
# 00040593
# 018000ef
# 00040513
# 00812403
# 00c12083
# 01010113
# 00008067
# 00008067
# 000a6425



