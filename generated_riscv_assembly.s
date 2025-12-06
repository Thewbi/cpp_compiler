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
        addi    sp, sp, -160
        sw      ra, 156(sp)
        sw      s0, 152(sp)
        addi    s0, sp, 160
        # -- stack frame create --
        # variable 'counter'
        li      t0, 0
        sw      t0, -12(fp)
        # variable 'i'
        li      t0, 0
        sw      t0, -24(fp)
start_0:
        lw      t0, -24(fp)
        mv      t1, a3
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, -36(fp)
start_1:
        lw      t0, -36(fp)
        mv      t1, a4
        ble     t1, t0, break_label_1
        # variable 'k'
        li      t0, 0
        sw      t0, -48(fp)
start_2:
        lw      t0, -48(fp)
        mv      t1, a4
        ble     t1, t0, break_label_2
        lw      t0, -24(fp)
        mv      t1, a4
        mul     t0, t0, t1
        # variable 'exprTemp_0'
        mv      t0, t0
        sw      t0, -52(fp)
        lw      t0, -52(fp)
        # variable 'temp_aIdx'
        mv      t0, t0
        sw      t0, -56(fp)
        lw      t0, -56(fp)
        lw      t1, -48(fp)
        add     t0, t0, t1
        # variable 'exprTemp_1'
        mv      t0, t0
        sw      t0, -60(fp)
        lw      t0, -60(fp)
        # variable 'aIdx'
        mv      t0, t0
        sw      t0, -64(fp)
        lw      t0, -48(fp)
        mv      t1, a4
        mul     t0, t0, t1
        # variable 'exprTemp_2'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -68(fp)
        # variable 'temp_bIdx'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -72(fp)
        lw      t1, -36(fp)
        add     t0, t0, t1
        # variable 'exprTemp_3'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -76(fp)
        # variable 'bIdx'
        mv      t0, t0
        sw      t0, -80(fp)
        lw      t0, -24(fp)
        mv      t1, a3
        mul     t0, t0, t1
        # variable 'exprTemp_4'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -84(fp)
        # variable 'temp_cIdx'
        mv      t0, t0
        sw      t0, -88(fp)
        lw      t0, -88(fp)
        lw      t1, -36(fp)
        add     t0, t0, t1
        # variable 'exprTemp_5'
        mv      t0, t0
        sw      t0, -92(fp)
        lw      t0, -92(fp)
        # variable 'cIdx'
        mv      t0, t0
        sw      t0, -96(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -104(fp)
        lw      t0, -64(fp)
        lw      t1, -104(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -108(fp)
        mv      t0, a0
        lw      t1, -108(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.tmp'
        mv      t0, t0
        sw      t0, -112(fp)
        # >> dereference into temp register: t0
        lw      t0, -112(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -100(fp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, -104(fp)
        lw      t0, -80(fp)
        lw      t1, -104(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -120(fp)
        mv      t0, a1
        lw      t1, -120(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.tmp'
        mv      t0, t0
        sw      t0, -124(fp)
        # >> dereference into temp register: t0
        lw      t0, -124(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -116(fp)
        # << store to stack
        lw      t0, -100(fp)
        lw      t1, -116(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_6'
        mv      t0, t0
        sw      t0, -128(fp)
        lw      t0, -128(fp)
        # variable 'mult_temp'
        mv      t0, t0
        sw      t0, -132(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -104(fp)
        lw      t0, -96(fp)
        lw      t1, -104(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        mv      t0, a2
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        # >> dereference into temp register: t0
        lw      t0, -144(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -136(fp)
        # << store to stack
        lw      t0, -136(fp)
        lw      t1, -132(fp)
        add     t0, t0, t1
        # variable 'exprTemp_7'
        mv      t0, t0
        sw      t0, -148(fp)
        lw      t0, -148(fp)
        # variable 'cde'
        mv      t0, t0
        sw      t0, -152(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -104(fp)
        lw      t0, -96(fp)
        lw      t1, -104(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        mv      t0, a2
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        lw      t0, -152(fp)
        # variable 'matrixC.tmp.0'
        mv      t0, t0
        sw      t0, -156(fp)
        # StoreToAddress()
        lw      t2, -156(fp)
        lw      t3, -144(fp)
        sw      t2, 0(t3)
continue_label_2:
        lw      t0, -48(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.2'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        # variable 'k'
        mv      t0, t0
        sw      t0, -48(fp)
        j       start_2
break_label_2:
continue_label_1:
        lw      t0, -36(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.1'
        mv      t0, t0
        sw      t0, -32(fp)
        lw      t0, -32(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -36(fp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, -24(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.0'
        mv      t0, t0
        sw      t0, -20(fp)
        lw      t0, -20(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -24(fp)
        j       start_0
break_label_0:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 156(sp)
        lw      s0, 152(sp)
        addi    sp, sp, 160
        # -- stack frame remove --
        # <processReturn()>
        ret
zeroMatrix:
        # -- stack frame create --
        addi    sp, sp, -68
        sw      ra, 64(sp)
        sw      s0, 60(sp)
        addi    s0, sp, 68
        # -- stack frame create --
        # variable 'i'
        li      t0, 0
        sw      t0, -20(fp)
start_3:
        lw      t0, -20(fp)
        mv      t1, a1
        ble     t1, t0, break_label_3
        # variable 'j'
        li      t0, 0
        sw      t0, -32(fp)
start_4:
        lw      t0, -32(fp)
        mv      t1, a1
        ble     t1, t0, break_label_4
        mv      t0, a1
        lw      t1, -20(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_8'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -36(fp)
        # variable 'temp'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        lw      t1, -32(fp)
        add     t0, t0, t1
        # variable 'exprTemp_9'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        # variable 'idx'
        mv      t0, t0
        sw      t0, -48(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -52(fp)
        lw      t0, -48(fp)
        lw      t1, -52(fp)
        mul     t0, t0, t1
        # variable 'matrix.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -56(fp)
        mv      t0, a0
        lw      t1, -56(fp)
        sub     t0, t0, t1
        # variable 'matrix.ptr.tmp'
        mv      t0, t0
        sw      t0, -60(fp)
        # variable 'matrix.tmp.0'
        li      t0, 0
        sw      t0, -64(fp)
        # StoreToAddress()
        lw      t2, -64(fp)
        lw      t3, -60(fp)
        sw      t2, 0(t3)
continue_label_4:
        lw      t0, -32(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.4'
        mv      t0, t0
        sw      t0, -28(fp)
        lw      t0, -28(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -32(fp)
        j       start_4
break_label_4:
continue_label_3:
        lw      t0, -20(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.3'
        mv      t0, t0
        sw      t0, -16(fp)
        lw      t0, -16(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -20(fp)
        j       start_3
break_label_3:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 64(sp)
        lw      s0, 60(sp)
        addi    sp, sp, 68
        # -- stack frame remove --
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        addi    sp, sp, -276
        sw      ra, 272(sp)
        sw      s0, 268(sp)
        addi    s0, sp, 276
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 0x1FFF4
        sw      t0, -80(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x00
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x01
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x02
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x03
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x04
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x05
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x06
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x07
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x08
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x09
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0A
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 8
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0B
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0C
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0D
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0E
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0F
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -80(fp)
        lw      t1, -84(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -88(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, -92(fp)
        # StoreToAddress()
        lw      t2, -92(fp)
        lw      t3, -88(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        # GetAddress(matrixC, matrixC.ptr)
        li      t0, 0x1FFA0
        sw      t0, -160(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x00
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x01
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x02
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x03
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x04
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x05
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x06
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x07
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x08
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x09
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0A
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0B
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0C
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0D
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0E
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0F
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        # GetAddress(matrixB, matrixB.ptr)
        li      t0, 0x1FF50
        sw      t0, -240(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x00
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 1
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x01
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x02
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x03
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x04
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x05
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x06
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x07
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x08
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x09
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0A
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0B
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0C
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0D
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0E
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x0F
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 0x1FFF4
        sw      t0, -260(fp)
        # GetAddress(matrixB, tmp.2.ptr)
        li      t0, 0x1FF50
        sw      t0, -264(fp)
        # GetAddress(matrixC, tmp.3.ptr)
        li      t0, 0x1FFA0
        sw      t0, -268(fp)
        # main() -> standardMatrixMult()
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -260(fp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, -264(fp)
        # load argument register a2 with parameter 'tmp.3.ptr'
        lw      a2, -268(fp)
        # load argument register a3 with parameter '4'
        li      a3, 0x04
        # load argument register a4 with parameter '4'
        li      a4, 0x04
        call    standardMatrixMult
        lw      t0, -256(fp)
        # variable 'pp3'
        mv      t0, t0
        sw      t0, -272(fp)
        call    exit
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 272(sp)
        lw      s0, 268(sp)
        addi    sp, sp, 276
        # -- stack frame remove --
        # <processReturn()>
        ret
