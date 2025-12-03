.LABEL_0: 
        .string "test_string_test\n"
main:
_start:
        addi    sp, sp, -84
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 131008
        sw      t0, 8(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 0
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 1
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 2
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 3
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 4
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 5
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 5
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 6
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 7
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 8
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 8
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 9
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 10
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 10
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 11
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 11
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 12
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 12
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 13
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 13
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 14
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 14
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 15
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 84(sp)
        li      t0, 15
        lw      t1, 84(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 8(sp)
        lw      t1, 16(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 16
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 4(sp)
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
