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
standardMatrixMult:
        # -- stack frame create --
        addi    sp, sp, -156
        sw      ra, 152(sp), 
        sw      s0, 148(sp), 
        addi    s0, sp, 156
        # -- stack frame create --
        # variable 'counter'
        li      t0, 0
        sw      t0, 148(sp)
        # variable 'i'
        li      t0, 0
        sw      t0, 136(sp)
start_0:
        lw      t0, 136(sp)
        mv      t1, a3
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, 124(sp)
start_1:
        lw      t0, 124(sp)
        mv      t1, a4
        ble     t1, t0, break_label_1
        # variable 'k'
        li      t0, 0
        sw      t0, 112(sp)
start_2:
        lw      t0, 112(sp)
        mv      t1, a4
        ble     t1, t0, break_label_2
        lw      t0, 136(sp)
        mv      t1, a4
        mul     a5, t0, t1
        # variable 'exprTemp_0'
        mv      t0, a5
        sw      t0, 108(sp)
        lw      a5, 108(sp)
        # variable 'temp_aIdx'
        mv      t0, a5
        sw      t0, 104(sp)
        lw      t0, 104(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'exprTemp_1'
        mv      t0, a5
        sw      t0, 100(sp)
        lw      a5, 100(sp)
        # variable 'aIdx'
        mv      t0, a5
        sw      t0, 96(sp)
        lw      t0, 112(sp)
        mv      t1, a4
        mul     a5, t0, t1
        # variable 'exprTemp_2'
        mv      t0, a5
        sw      t0, 92(sp)
        lw      a5, 92(sp)
        # variable 'temp_bIdx'
        mv      t0, a5
        sw      t0, 88(sp)
        lw      t0, 88(sp)
        lw      t1, 124(sp)
        add     a5, t0, t1
        # variable 'exprTemp_3'
        mv      t0, a5
        sw      t0, 84(sp)
        lw      a5, 84(sp)
        # variable 'bIdx'
        mv      t0, a5
        sw      t0, 80(sp)
        lw      t0, 136(sp)
        mv      t1, a3
        mul     a5, t0, t1
        # variable 'exprTemp_4'
        mv      t0, a5
        sw      t0, 76(sp)
        lw      a5, 76(sp)
        # variable 'temp_cIdx'
        mv      t0, a5
        sw      t0, 72(sp)
        lw      t0, 72(sp)
        lw      t1, 124(sp)
        add     a5, t0, t1
        # variable 'exprTemp_5'
        mv      t0, a5
        sw      t0, 68(sp)
        lw      a5, 68(sp)
        # variable 'cIdx'
        mv      t0, a5
        sw      t0, 64(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 56(sp)
        lw      t0, 96(sp)
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 52(sp)
        mv      t0, a0
        lw      t1, 52(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.tmp'
        mv      t0, a5
        sw      t0, 48(sp)
        # >> dereference into temp register: t0
        lw      t0, 48(sp)
        lw t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, 60(sp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, 56(sp)
        lw      t0, 80(sp)
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 40(sp)
        mv      t0, a1
        lw      t1, 40(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.tmp'
        mv      t0, a5
        sw      t0, 36(sp)
        # >> dereference into temp register: t0
        lw      t0, 36(sp)
        lw t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, 44(sp)
        # << store to stack
        lw      t0, 60(sp)
        lw      t1, 44(sp)
        mul     a5, t0, t1
        # variable 'exprTemp_6'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      a5, 32(sp)
        # variable 'mult_temp'
        mv      t0, a5
        sw      t0, 28(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 56(sp)
        lw      t0, 64(sp)
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 20(sp)
        mv      t0, a2
        lw      t1, 20(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.tmp'
        mv      t0, a5
        sw      t0, 16(sp)
        # >> dereference into temp register: t0
        lw      t0, 16(sp)
        lw t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, 24(sp)
        # << store to stack
        lw      t0, 24(sp)
        lw      t1, 28(sp)
        add     a5, t0, t1
        # variable 'exprTemp_7'
        mv      t0, a5
        sw      t0, 12(sp)
        lw      a5, 12(sp)
        # variable 'cde'
        mv      t0, a5
        sw      t0, 8(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 56(sp)
        lw      t0, 64(sp)
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 20(sp)
        mv      t0, a2
        lw      t1, 20(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.tmp'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      a5, 8(sp)
        # variable 'matrixC.tmp.0'
        mv      t0, a5
        sw      t0, 4(sp)
        # StoreToAddress()
        lw      t2, 4(sp)
        lw      t3, 16(sp)
        sw      t2, 0(t3)
continue_label_2:
        lw      t0, 112(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.2'
        mv      t0, a5
        sw      t0, 116(sp)
        lw      a5, 116(sp)
        # variable 'k'
        mv      t0, a5
        sw      t0, 112(sp)
        j       start_2
break_label_2:
continue_label_1:
        lw      t0, 124(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.1'
        mv      t0, a5
        sw      t0, 128(sp)
        lw      a5, 128(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 124(sp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, 136(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.0'
        mv      t0, a5
        sw      t0, 140(sp)
        lw      a5, 140(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 136(sp)
        j       start_0
break_label_0:
        # -- stack frame remove --
        lw      ra, 152(sp), 
        lw      s0, 148(sp), 
        addi    sp, sp, 156
        # -- stack frame remove --
        # <processReturn()>
        ret
upCountingMatrix:
        # -- stack frame create --
        addi    sp, sp, -76
        sw      ra, 72(sp), 
        sw      s0, 68(sp), 
        addi    s0, sp, 76
        # -- stack frame create --
        # variable 'count'
        li      t0, 1
        sw      t0, 68(sp)
        # variable 'i'
        li      t0, 0
        sw      t0, 56(sp)
start_3:
        lw      t0, 56(sp)
        mv      t1, a1
        ble     t1, t0, break_label_3
        # variable 'j'
        li      t0, 0
        sw      t0, 44(sp)
start_4:
        lw      t0, 44(sp)
        mv      t1, a1
        ble     t1, t0, break_label_4
        mv      t0, a1
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'exprTemp_8'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      a5, 40(sp)
        # variable 'temp'
        mv      t0, a5
        sw      t0, 36(sp)
        lw      t0, 36(sp)
        lw      t1, 44(sp)
        add     a5, t0, t1
        # variable 'exprTemp_9'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      a5, 32(sp)
        # variable 'idx'
        mv      t0, a5
        sw      t0, 28(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 24(sp)
        lw      t0, 28(sp)
        lw      t1, 24(sp)
        mul     a5, t0, t1
        # variable 'matrix.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 20(sp)
        mv      t0, a0
        lw      t1, 20(sp)
        add     a5, t0, t1
        # variable 'matrix.ptr.tmp'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      a5, 68(sp)
        # variable 'matrix.tmp.0'
        mv      t0, a5
        sw      t0, 12(sp)
        # StoreToAddress()
        lw      t2, 12(sp)
        lw      t3, 16(sp)
        sw      t2, 0(t3)
        lw      t0, 68(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'exprTemp_10'
        mv      t0, a5
        sw      t0, 8(sp)
        lw      a5, 8(sp)
        # variable 't'
        mv      t0, a5
        sw      t0, 4(sp)
        lw      a5, 4(sp)
        # variable 'count'
        mv      t0, a5
        sw      t0, 68(sp)
continue_label_4:
        lw      t0, 44(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.4'
        mv      t0, a5
        sw      t0, 48(sp)
        lw      a5, 48(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 44(sp)
        j       start_4
break_label_4:
continue_label_3:
        lw      t0, 56(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.3'
        mv      t0, a5
        sw      t0, 60(sp)
        lw      a5, 60(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 56(sp)
        j       start_3
break_label_3:
        # -- stack frame remove --
        lw      ra, 72(sp), 
        lw      s0, 68(sp), 
        addi    sp, sp, 76
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -272
        sw      ra, 268(sp), 
        sw      s0, 264(sp), 
        addi    s0, sp, 272
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 131004
        sw      t0, 196(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 0
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 1
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 2
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 3
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 4
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 5
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 6
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 7
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 8
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 9
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 10
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 8
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 11
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 12
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 13
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 14
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 15
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 192(sp)
        lw      t0, 196(sp)
        lw      t1, 192(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 188(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 184(sp)
        # StoreToAddress()
        lw      t2, 184(sp)
        lw      t3, 188(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        # GetAddress(matrixC, matrixC.ptr)
        li      t0, 130920
        sw      t0, 116(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 0
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 1
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 2
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 3
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 4
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 5
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 6
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 7
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 8
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 9
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 10
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 11
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 12
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 13
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 14
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 15
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 112(sp)
        lw      t0, 116(sp)
        lw      t1, 112(sp)
        add     a5, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 108(sp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, 104(sp)
        # StoreToAddress()
        lw      t2, 104(sp)
        lw      t3, 108(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        # GetAddress(matrixB, matrixB.ptr)
        li      t0, 130840
        sw      t0, 36(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 0
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 1
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 1
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 2
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 3
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 4
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 5
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 6
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 7
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 8
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 9
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 10
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 11
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 12
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 13
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 14
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 200(sp)
        li      t0, 15
        lw      t1, 200(sp)
        mul     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 131004
        sw      t0, 16(sp)
        # GetAddress(matrixB, tmp.2.ptr)
        li      t0, 130840
        sw      t0, 12(sp)
        # GetAddress(matrixC, tmp.3.ptr)
        li      t0, 130920
        sw      t0, 8(sp)
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, 16(sp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, 12(sp)
        # load argument register a2 with parameter 'tmp.3.ptr'
        lw      a2, 8(sp)
        # load argument register a3 with parameter '4'
        li      a3, 4
        # load argument register a4 with parameter '4'
        li      a4, 4
        call    standardMatrixMult
        lw      a5, 20(sp)
        # variable 'pp3'
        mv      t0, a5
        sw      t0, 4(sp)
        call    exit
        # -- stack frame remove --
        lw      ra, 268(sp), 
        lw      s0, 264(sp), 
        addi    sp, sp, 272
        # -- stack frame remove --
        # <processReturn()>
        ret
