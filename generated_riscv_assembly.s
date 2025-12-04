.LABEL_0: 
        .string "test_string_test\n"
func_void:
        # -- stack frame create --
        addi    sp, sp, -8
        sw      ra, 4(sp), 
        sw      s0, 0(sp), 
        addi    s0, sp, 8
        # -- stack frame create --
        lui     a5, %hi(.LABEL_0)
        addi    a0, a5, %lo(.LABEL_0)
        lw      a5, 20(sp)
        mv      a1, a5
        call    puts
        # -- stack frame remove --
        lw      ra, 4(sp), 
        lw      s0, 0(sp), 
        addi    sp, sp, 8
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp), 
        sw      s0, 4(sp), 
        addi    s0, sp, 12
        # -- stack frame create --
        call    func_void
        call    exit
        # -- stack frame remove --
        lw      ra, 8(sp), 
        lw      s0, 4(sp), 
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
