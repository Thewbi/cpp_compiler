exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
factorial:
        # -- stack frame create --
        addi    sp, sp, -32
        sw      ra, 28(sp)
        sw      s0, 24(sp)
        addi    s0, sp, 32
        # -- stack frame create --
        mv      t0, a0
        li      t1, 1
        bne     t0, t1, if_label_0
        # -- stack frame remove --
        lw      ra, 28(sp)
        lw      s0, 24(sp)
        addi    sp, sp, 32
        # -- stack frame remove --
        # <processReturn()>
        ret
if_label_0:
        mv      t0, a0
        li      t1, 1
        sub     t0, t0, t1
        # variable 'exprTemp_0'
        mv      t0, t0
        sw      t0, 24(sp)
        lw      t0, 24(sp)
        # variable 'temp'
        mv      t0, t0
        sw      t0, 20(sp)
        # factorial() -> factorial()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'temp'
        lw      a0, 20(sp)
        call    factorial
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, 16(sp)
        # variable 'factorial_result'
        mv      t0, t0
        sw      t0, 12(sp)
        mv      t0, a0
        lw      t1, 12(sp)
        mul     t0, t0, t1
        # variable 'exprTemp_1'
        mv      t0, t0
        sw      t0, 8(sp)
        lw      t0, 8(sp)
        # variable 'result'
        mv      t0, t0
        sw      t0, 4(sp)
        # -- stack frame remove --
        lw      ra, 28(sp)
        lw      s0, 24(sp)
        addi    sp, sp, 32
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -20
        sw      ra, 16(sp)
        sw      s0, 12(sp)
        addi    s0, sp, 20
        # -- stack frame create --
        # variable 'num'
        li      t0, 5
        sw      t0, 12(sp)
        # main() -> factorial()
        # load argument register a0 with parameter 'num'
        lw      a0, 12(sp)
        call    factorial
        lw      t0, 8(sp)
        # variable 'factorial_result'
        mv      t0, t0
        sw      t0, 4(sp)
        mv      t6, a0
        lui     t0, %hi(.SLL0)
        addi    a0, t0, %lo(.SLL0)
        call    puts
        mv      a0, t6
        call    exit
        # -- stack frame remove --
        lw      ra, 16(sp)
        lw      s0, 12(sp)
        addi    sp, sp, 20
        # -- stack frame remove --
        # <processReturn()>
        ret
.SLL0: 
        .string "factorial of %d is %d\n"
