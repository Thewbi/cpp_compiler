.LABEL_0: 
        .string "test_string_test\n"
main:
_start:
        addi    sp, sp, -48
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        # GetAddress(temp_array, temp_array.ptr)
        li      t0, 131052
        sw      t0, 12(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        li      t0, 0
        lw      t1, 48(sp)
        mul     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      t0, 12(sp)
        lw      t1, 40(sp)
        add     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 24(sp)
        # variable 'temp_array.ptr.tmp.0'
        li      t0, 10
        sw      t0, 44(sp)
        # StoreToAddress()
        lw      t2, 44(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        li      t0, 1
        lw      t1, 48(sp)
        mul     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      t0, 12(sp)
        lw      t1, 40(sp)
        add     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 24(sp)
        # variable 'temp_array.ptr.tmp.0'
        li      t0, 11
        sw      t0, 44(sp)
        # StoreToAddress()
        lw      t2, 44(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        li      t0, 2
        lw      t1, 48(sp)
        mul     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      t0, 12(sp)
        lw      t1, 40(sp)
        add     a5, t0, t1
        # variable 'temp_array.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 24(sp)
        # variable 'temp_array.ptr.tmp.0'
        li      t0, 12
        sw      t0, 44(sp)
        # StoreToAddress()
        lw      t2, 44(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        nop
        # GetAddress(temp_array, temp_array.addr.ptr)
        li      t0, 131052
        sw      t0, 4(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        li      t0, 0
        lw      t1, 48(sp)
        mul     a5, t0, t1
        # variable 'temp_array.addr.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 4(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'temp_array.addr.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 20(sp)
        # variable 'temp_array.addr.ptr.tmp.0'
        li      t0, 15
        sw      t0, 8(sp)
        # StoreToAddress()
        lw      t2, 8(sp)
        lw      t3, 20(sp)
        sw      t2, 0(t3)
        nop
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
