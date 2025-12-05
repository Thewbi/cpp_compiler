.LABEL_0: 
        .string "test_string_test\n"
exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
getSubMatrix:
        # -- stack frame create --
        addi    sp, sp, -144
        sw      ra, 140(sp)
        sw      s0, 136(sp)
        addi    s0, sp, 144
        # -- stack frame create --
        mv      t0, a3
        mv      t1, a5
        add     t0, t0, t1
        # variable 'exprTemp_0'
        mv      t0, t0
        sw      t0, 136(sp)
        lw      t0, 136(sp)
        # variable 'xEnd'
        mv      t0, t0
        sw      t0, 132(sp)
        mv      t0, a4
        mv      t1, a6
        add     t0, t0, t1
        # variable 'exprTemp_1'
        mv      t0, t0
        sw      t0, 128(sp)
        lw      t0, 128(sp)
        # variable 'yEnd'
        mv      t0, t0
        sw      t0, 124(sp)
        # variable 'counter'
        li      t0, 0
        sw      t0, 120(sp)
        # variable 'innerI'
        li      t0, 0
        sw      t0, 116(sp)
        mv      t0, a3
        # variable 'i'
        mv      t0, t0
        sw      t0, 104(sp)
start_0:
        lw      t0, 104(sp)
        lw      t1, 132(sp)
        ble     t1, t0, break_label_0
        # variable 'innerJ'
        li      t0, 0
        sw      t0, 100(sp)
        mv      t0, a4
        # variable 'j'
        mv      t0, t0
        sw      t0, 88(sp)
start_1:
        lw      t0, 88(sp)
        lw      t1, 124(sp)
        ble     t1, t0, break_label_1
        lw      t0, 104(sp)
        mv      t1, a2
        mul     t0, t0, t1
        # variable 'exprTemp_2'
        mv      t0, t0
        sw      t0, 84(sp)
        lw      t0, 84(sp)
        # variable 'tempIdx'
        mv      t0, t0
        sw      t0, 80(sp)
        lw      t0, 80(sp)
        lw      t1, 88(sp)
        add     t0, t0, t1
        # variable 'exprTemp_3'
        mv      t0, t0
        sw      t0, 76(sp)
        lw      t0, 76(sp)
        # variable 'idx'
        mv      t0, t0
        sw      t0, 72(sp)
        lw      t0, 116(sp)
        mv      t1, a5
        mul     t0, t0, t1
        # variable 'exprTemp_4'
        mv      t0, t0
        sw      t0, 68(sp)
        lw      t0, 68(sp)
        # variable 'tempIdxC'
        mv      t0, t0
        sw      t0, 64(sp)
        lw      t0, 64(sp)
        lw      t1, 100(sp)
        add     t0, t0, t1
        # variable 'exprTemp_5'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 60(sp)
        # variable 'idxC'
        mv      t0, t0
        sw      t0, 56(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        lw      t0, 72(sp)
        lw      t1, 48(sp)
        mul     t0, t0, t1
        # variable 'matrixSrc.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 44(sp)
        mv      t0, a1
        lw      t1, 44(sp)
        add     t0, t0, t1
        # variable 'matrixSrc.ptr.tmp'
        mv      t0, t0
        sw      t0, 40(sp)
        # >> dereference into temp register: t0
        lw      t0, 40(sp)
        lw t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, 52(sp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, 48(sp)
        lw      t0, 56(sp)
        lw      t1, 48(sp)
        mul     t0, t0, t1
        # variable 'matrixDest.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 36(sp)
        mv      t0, a0
        lw      t1, 36(sp)
        add     t0, t0, t1
        # variable 'matrixDest.ptr.tmp'
        mv      t0, t0
        sw      t0, 32(sp)
        lw      t0, 52(sp)
        # variable 'matrixDest.tmp.0'
        mv      t0, t0
        sw      t0, 28(sp)
        # StoreToAddress()
        lw      t2, 28(sp)
        lw      t3, 32(sp)
        sw      t2, 0(t3)
        lw      t0, 100(sp)
        li      t1, 1
        add     t0, t0, t1
        # variable 'exprTemp_6'
        mv      t0, t0
        sw      t0, 24(sp)
        lw      t0, 24(sp)
        # variable 't'
        mv      t0, t0
        sw      t0, 20(sp)
        lw      t0, 20(sp)
        # variable 'innerJ'
        mv      t0, t0
        sw      t0, 100(sp)
        lw      t0, 120(sp)
        li      t1, 1
        add     t0, t0, t1
        # variable 'exprTemp_7'
        mv      t0, t0
        sw      t0, 16(sp)
        lw      t0, 16(sp)
        # variable 'tempCounter'
        mv      t0, t0
        sw      t0, 12(sp)
        lw      t0, 12(sp)
        # variable 'counter'
        mv      t0, t0
        sw      t0, 120(sp)
continue_label_1:
        lw      t0, 88(sp)
        li      t1, 1
        add     t0, t0, t1
        # variable 'tmp.1.1'
        mv      t0, t0
        sw      t0, 92(sp)
        lw      t0, 92(sp)
        # variable 'j'
        mv      t0, t0
        sw      t0, 88(sp)
        j       start_1
break_label_1:
        lw      t0, 116(sp)
        li      t1, 1
        add     t0, t0, t1
        # variable 'exprTemp_8'
        mv      t0, t0
        sw      t0, 8(sp)
        lw      t0, 8(sp)
        # variable 'u'
        mv      t0, t0
        sw      t0, 4(sp)
        lw      t0, 4(sp)
        # variable 'innerI'
        mv      t0, t0
        sw      t0, 116(sp)
continue_label_0:
        lw      t0, 104(sp)
        li      t1, 1
        add     t0, t0, t1
        # variable 'tmp.1.0'
        mv      t0, t0
        sw      t0, 108(sp)
        lw      t0, 108(sp)
        # variable 'i'
        mv      t0, t0
        sw      t0, 104(sp)
        j       start_0
break_label_0:
        # -- stack frame remove --
        lw      ra, 140(sp), 
        lw      s0, 136(sp), 
        addi    sp, sp, 144
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -300
        sw      ra, 296(sp)
        sw      s0, 292(sp)
        addi    s0, sp, 300
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 131004
        sw      t0, 224(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 0
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 1
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 2
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 3
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 4
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 5
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 6
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 7
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 8
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 9
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 10
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 8
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 11
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 12
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 13
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 14
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 15
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 220(sp)
        lw      t0, 224(sp)
        lw      t1, 220(sp)
        add     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 216(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 212(sp)
        # StoreToAddress()
        lw      t2, 212(sp)
        lw      t3, 216(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        # GetAddress(matrixC, matrixC.ptr)
        li      t0, 130920
        sw      t0, 144(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 0
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 1
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 2
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 3
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 4
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 5
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 6
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 7
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 8
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 9
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 10
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 11
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 12
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 13
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 14
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 15
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 140(sp)
        lw      t0, 144(sp)
        lw      t1, 140(sp)
        add     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 136(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 132(sp)
        # StoreToAddress()
        lw      t2, 132(sp)
        lw      t3, 136(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        # GetAddress(matrixB, matrixB.ptr)
        li      t0, 130840
        sw      t0, 64(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 0
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 1
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 1
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 2
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 3
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 4
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 5
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 6
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 7
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 8
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 9
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 10
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 11
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 12
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 13
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 14
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 15
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 60(sp)
        lw      t0, 64(sp)
        lw      t1, 60(sp)
        add     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 56(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, 52(sp)
        # StoreToAddress()
        lw      t2, 52(sp)
        lw      t3, 56(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        # GetAddress(subMatrixB, subMatrixB.ptr)
        li      t0, 130808
        sw      t0, 32(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 0
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 28(sp)
        lw      t0, 32(sp)
        lw      t1, 28(sp)
        add     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 24(sp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 255
        sw      t0, 20(sp)
        # StoreToAddress()
        lw      t2, 20(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 1
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 28(sp)
        lw      t0, 32(sp)
        lw      t1, 28(sp)
        add     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 24(sp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 255
        sw      t0, 20(sp)
        # StoreToAddress()
        lw      t2, 20(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 2
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 28(sp)
        lw      t0, 32(sp)
        lw      t1, 28(sp)
        add     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 24(sp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 255
        sw      t0, 20(sp)
        # StoreToAddress()
        lw      t2, 20(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 228(sp)
        li      t0, 3
        lw      t1, 228(sp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, 28(sp)
        lw      t0, 32(sp)
        lw      t1, 28(sp)
        add     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, 24(sp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 255
        sw      t0, 20(sp)
        # StoreToAddress()
        lw      t2, 20(sp)
        lw      t3, 24(sp)
        sw      t2, 0(t3)
        # GetAddress(subMatrixB, tmp.1.ptr)
        li      t0, 130808
        sw      t0, 12(sp)
        # GetAddress(matrixB, tmp.2.ptr)
        li      t0, 130840
        sw      t0, 8(sp)
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, 12(sp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, 8(sp)
        # load argument register a2 with parameter '4'
        li      a2, 4
        # load argument register a3 with parameter '0'
        li      a3, 0
        # load argument register a4 with parameter '0'
        li      a4, 0
        # load argument register a5 with parameter '2'
        li      a5, 2
        # load argument register a6 with parameter '2'
        li      a6, 2
        call    getSubMatrix
        lw      t0, 16(sp)
        # variable 'getResult'
        mv      t0, t0
        sw      t0, 4(sp)
        call    exit
        # -- stack frame remove --
        lw      ra, 296(sp), 
        lw      s0, 292(sp), 
        addi    sp, sp, 300
        # -- stack frame remove --
        # <processReturn()>
        ret
