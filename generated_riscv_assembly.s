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
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      fp, 4(sp)
        addi    fp, sp, 12
        # -- stack frame create --
        movl %eax, %ebx
        movl $56, %esi
        movl %ecx, $label(%edx,%ebx,$4)
        movb %ah, (%ebx)
        call    exit
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        print_reg sp
        # -- stack frame remove --
        # <processReturn()>
        ret
