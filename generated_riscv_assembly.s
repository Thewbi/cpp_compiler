.LABEL_0: 
        .string "test_string_test\n"
func_assign:
        # -- stack frame create --
        addi    sp, sp, -24
        sw      ra, 20(sp), 
        sw      s0, 16(sp), 
        addi    s0, sp, 24
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, 16(sp)
        li      t0, 1
        lw      t1, 16(sp)
        mul     a5, t0, t1
        # variable 'numbers.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 12(sp)
        mv      t0, a0
        lw      t1, 12(sp)
        add     a5, t0, t1
        # variable 'numbers.ptr.tmp'
        mv      t0, a5
        sw      t0, 8(sp)
        # variable 'numbers.tmp.0'
        li      t0, 255
        sw      t0, 4(sp)
        # StoreToAddress()
        lw      t2, 4(sp)
        lw      t3, 8(sp)
        sw      t2, 0(t3)
        nop
        # -- stack frame remove --
        lw      ra, 20(sp), 
        lw      s0, 16(sp), 
        addi    sp, sp, 24
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -52
        sw      ra, 48(sp), 
        sw      s0, 44(sp), 
        addi    s0, sp, 52
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, 32(sp)
        # GetAddress(numbers, numbers.ptr)
        li      t0, 131056
        sw      t0, 28(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 32(sp)
        li      t0, 0
        lw      t1, 32(sp)
        mul     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 24(sp)
        lw      t0, 28(sp)
        lw      t1, 24(sp)
        add     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 20(sp)
        # variable 'numbers.ptr.tmp.0'
        li      t0, 16
        sw      t0, 16(sp)
        # StoreToAddress()
        lw      t2, 16(sp)
        lw      t3, 20(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 32(sp)
        li      t0, 1
        lw      t1, 32(sp)
        mul     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 24(sp)
        lw      t0, 28(sp)
        lw      t1, 24(sp)
        add     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 20(sp)
        # variable 'numbers.ptr.tmp.0'
        li      t0, 32
        sw      t0, 16(sp)
        # StoreToAddress()
        lw      t2, 16(sp)
        lw      t3, 20(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 32(sp)
        li      t0, 2
        lw      t1, 32(sp)
        mul     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 24(sp)
        lw      t0, 28(sp)
        lw      t1, 24(sp)
        add     a5, t0, t1
        # variable 'numbers.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 20(sp)
        # variable 'numbers.ptr.tmp.0'
        li      t0, 48
        sw      t0, 16(sp)
        # StoreToAddress()
        lw      t2, 16(sp)
        lw      t3, 20(sp)
        sw      t2, 0(t3)
        nop
        # GetAddress(numbers, tmp.1.ptr)
        li      t0, 131056
        sw      t0, 8(sp)
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, 8(sp)
        call    func_assign
        lw      a5, 12(sp)
        # variable 'y'
        mv      t0, a5
        sw      t0, 4(sp)
        call    exit
        # -- stack frame remove --
        lw      ra, 48(sp), 
        lw      s0, 44(sp), 
        addi    sp, sp, 52
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
