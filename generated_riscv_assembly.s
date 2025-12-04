.LABEL_0: 
        .string "test_string_test\n"
func_void:
        addi    sp, sp, 0
        lui     a5, %hi(.LABEL_0)
        addi    a0, a5, %lo(.LABEL_0)
        lw      a5, 20(sp)
        mv      a1, a5
        call    puts
        # <processReturn()>
        ret
main:
_start:
        addi    sp, sp, -4
        call    func_void
        call    exit
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
