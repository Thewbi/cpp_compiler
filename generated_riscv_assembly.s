exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      s0, 4(sp)
        addi    s0, sp, 12
        # -- stack frame create --
        # variable 'if_eval_0'
        li      t0, 1
        sw      t0, 4(sp)
        lw      t0, 4(sp)
        beq     zero, t0, if_label_0
        mv      t6, a0
        lui     t0, %hi(.SLL0)
        addi    a0, t0, %lo(.SLL0)
        call    puts
        mv      a0, t6
if_label_0:
        call    exit
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
.SLL0: 
        .string "abcdefghijklmnopqrstuvwxyz\n"
