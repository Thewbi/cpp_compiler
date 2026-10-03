        .text


exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
putint:
        li      a7, 105   # ecall for putint
        ecall
        jr      ra



main:
_start:
        # -- START stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      fp, 4(sp)
        addi    fp, sp, 12
        # -- END stack frame create --
        mv      t6, a0
        lui     a0, %hi(.SLL0)
        addi    a0, a0, %lo(.SLL0)
        call    puts
        mv      a0, t6
        li      a0, 0x00
        # -- START stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- END stack frame remove --
        # <processReturn()>
        ret
.SLL0: 
        .string "Debug mode is ON\n"
