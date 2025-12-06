exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
func_void:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      s0, 4(sp)
        addi    s0, sp, 12
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL0)
        addi    a0, t0, %lo(.SLL0)
        call    puts
        mv      a0, t6
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -16
        sw      ra, 12(sp)
        sw      s0, 8(sp)
        addi    s0, sp, 16
        # -- stack frame create --
        # main() -> func_void()
        # load argument register a0 with parameter '123'
        li      a0, 0x7B
        call    func_void
        call    exit
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 12(sp)
        lw      s0, 8(sp)
        addi    sp, sp, 16
        # -- stack frame remove --
        # <processReturn()>
        ret
.SLL0: 
        .string "func_void() a = %d\n"
