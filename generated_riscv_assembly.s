exit:
        li      a7, 93   # ecall for exit
        ecall
        jr      ra
puts:
        li      a7, 92   # ecall for puts
        ecall
        jr      ra
matrixAddInto:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      s0, 4(sp)
        addi    s0, sp, 12
        # -- stack frame create --
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
standardMatrixMult:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      s0, 4(sp)
        addi    s0, sp, 12
        # -- stack frame create --
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
getSubMatrix:
        # -- stack frame create --
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      s0, 4(sp)
        addi    s0, sp, 12
        # -- stack frame create --
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        # -- stack frame remove --
        # <processReturn()>
        ret
segmentedMatrixMult:
        # -- stack frame create --
        addi    sp, sp, -304
        sw      ra, 300(sp)
        sw      s0, 296(sp)
        addi    s0, sp, 304
        # -- stack frame create --
        # variable 'nc'
        li      t0, 2
        sw      t0, -12(fp)
        mv      t0, a3
        lw      t1, -12(fp)
        div     t0, t0, t1
        # variable 'exprTemp_0'
        mv      t0, t0
        sw      t0, -16(fp)
        lw      t0, -16(fp)
        # variable 'rowSteps'
        mv      t0, t0
        sw      t0, -20(fp)
        # variable 'kc'
        li      t0, 2
        sw      t0, -24(fp)
        mv      t0, a4
        lw      t1, -24(fp)
        div     t0, t0, t1
        # variable 'exprTemp_1'
        mv      t0, t0
        sw      t0, -28(fp)
        lw      t0, -28(fp)
        # variable 'columnsSteps'
        mv      t0, t0
        sw      t0, -32(fp)
        # variable 'mc'
        li      t0, 2
        sw      t0, -36(fp)
        mv      t0, a3
        lw      t1, -12(fp)
        div     t0, t0, t1
        # variable 'exprTemp_2'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        # variable 'innerSteps'
        mv      t0, t0
        sw      t0, -44(fp)
        # variable 'iterationCounter'
        li      t0, 0
        sw      t0, -48(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        # GetAddress(subMatrixA, subMatrixA.ptr)
        li      t0, 0x1FFCC
        sw      t0, -72(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x00
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -72(fp)
        lw      t1, -76(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -80(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -84(fp)
        # StoreToAddress()
        lw      t2, -84(fp)
        lw      t3, -80(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x01
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -72(fp)
        lw      t1, -76(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -80(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -84(fp)
        # StoreToAddress()
        lw      t2, -84(fp)
        lw      t3, -80(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x02
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -72(fp)
        lw      t1, -76(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -80(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -84(fp)
        # StoreToAddress()
        lw      t2, -84(fp)
        lw      t3, -80(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x03
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -72(fp)
        lw      t1, -76(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -80(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -84(fp)
        # StoreToAddress()
        lw      t2, -84(fp)
        lw      t3, -80(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        # GetAddress(subMatrixB, subMatrixB.ptr)
        li      t0, 0x1FFA8
        sw      t0, -104(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x00
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -108(fp)
        lw      t0, -104(fp)
        lw      t1, -108(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -112(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -116(fp)
        # StoreToAddress()
        lw      t2, -116(fp)
        lw      t3, -112(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x01
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -108(fp)
        lw      t0, -104(fp)
        lw      t1, -108(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -112(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -116(fp)
        # StoreToAddress()
        lw      t2, -116(fp)
        lw      t3, -112(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x02
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -108(fp)
        lw      t0, -104(fp)
        lw      t1, -108(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -112(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -116(fp)
        # StoreToAddress()
        lw      t2, -116(fp)
        lw      t3, -112(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x03
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -108(fp)
        lw      t0, -104(fp)
        lw      t1, -108(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -112(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -116(fp)
        # StoreToAddress()
        lw      t2, -116(fp)
        lw      t3, -112(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        # GetAddress(tempMult, tempMult.ptr)
        li      t0, 0x1FF88
        sw      t0, -136(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x00
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        lw      t0, -136(fp)
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -148(fp)
        # StoreToAddress()
        lw      t2, -148(fp)
        lw      t3, -144(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x01
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        lw      t0, -136(fp)
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -148(fp)
        # StoreToAddress()
        lw      t2, -148(fp)
        lw      t3, -144(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x02
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        lw      t0, -136(fp)
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -148(fp)
        # StoreToAddress()
        lw      t2, -148(fp)
        lw      t3, -144(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x03
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -140(fp)
        lw      t0, -136(fp)
        lw      t1, -140(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -144(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -148(fp)
        # StoreToAddress()
        lw      t2, -148(fp)
        lw      t3, -144(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        # GetAddress(tempAccum, tempAccum.ptr)
        li      t0, 0x1FF68
        sw      t0, -168(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x00
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -172(fp)
        lw      t0, -168(fp)
        lw      t1, -172(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -176(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -180(fp)
        # StoreToAddress()
        lw      t2, -180(fp)
        lw      t3, -176(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x01
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -172(fp)
        lw      t0, -168(fp)
        lw      t1, -172(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -176(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -180(fp)
        # StoreToAddress()
        lw      t2, -180(fp)
        lw      t3, -176(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x02
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -172(fp)
        lw      t0, -168(fp)
        lw      t1, -172(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -176(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -180(fp)
        # StoreToAddress()
        lw      t2, -180(fp)
        lw      t3, -176(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -68(fp)
        li      t0, 0x03
        lw      t1, -68(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -172(fp)
        lw      t0, -168(fp)
        lw      t1, -172(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -176(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -180(fp)
        # StoreToAddress()
        lw      t2, -180(fp)
        lw      t3, -176(fp)
        sw      t2, 0(t3)
        # variable 'jc'
        li      t0, 0
        sw      t0, -192(fp)
start_0:
        lw      t0, -192(fp)
        lw      t1, -20(fp)
        ble     t1, t0, break_label_0
        # variable 'pc'
        li      t0, 0
        sw      t0, -204(fp)
start_1:
        lw      t0, -204(fp)
        lw      t1, -32(fp)
        ble     t1, t0, break_label_1
        lw      t0, -204(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_3'
        mv      t0, t0
        sw      t0, -208(fp)
        lw      t0, -208(fp)
        # variable 'xPos_b'
        mv      t0, t0
        sw      t0, -212(fp)
        lw      t0, -192(fp)
        lw      t1, -12(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_4'
        mv      t0, t0
        sw      t0, -216(fp)
        lw      t0, -216(fp)
        # variable 'yPos_b'
        mv      t0, t0
        sw      t0, -220(fp)
        # GetAddress(subMatrixB, tmp.1.ptr)
        li      t0, 0x1FFA8
        sw      t0, -228(fp)
        # segmentedMatrixMult() -> getSubMatrix()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a1, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a2, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a3, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a4, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -228(fp)
        # load argument register a1 with parameter 'matrixC'
        mv      a1, a2
        # load argument register a2 with parameter '4'
        li      a2, 0x04
        # load argument register a3 with parameter '1'
        li      a3, 0x01
        # load argument register a4 with parameter '2'
        li      a4, 0x02
        # load argument register a5 with parameter '3'
        li      a5, 0x03
        # load argument register a6 with parameter '4'
        li      a6, 0x04
        call    getSubMatrix
        # -- pop parameter
        lw      a4, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a3, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a2, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a1, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, -224(fp)
        # variable 'sub_matrix_1'
        mv      t0, t0
        sw      t0, -232(fp)
        # variable 'ic'
        li      t0, 0
        sw      t0, -244(fp)
start_2:
        lw      t0, -244(fp)
        lw      t1, -44(fp)
        ble     t1, t0, break_label_2
        lw      t0, -244(fp)
        lw      t1, -36(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_5'
        mv      t0, t0
        sw      t0, -248(fp)
        lw      t0, -248(fp)
        # variable 'xPos_a'
        mv      t0, t0
        sw      t0, -252(fp)
        lw      t0, -204(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_6'
        mv      t0, t0
        sw      t0, -256(fp)
        lw      t0, -256(fp)
        # variable 'yPos_a'
        mv      t0, t0
        sw      t0, -260(fp)
        # GetAddress(subMatrixA, tmp.1.ptr)
        li      t0, 0x1FFCC
        sw      t0, -228(fp)
        # segmentedMatrixMult() -> getSubMatrix()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a1, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a2, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a3, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a4, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -228(fp)
        # load argument register a1 with parameter 'matrixC'
        mv      a1, a2
        # load argument register a2 with parameter '4'
        li      a2, 0x04
        # load argument register a3 with parameter '1'
        li      a3, 0x01
        # load argument register a4 with parameter '2'
        li      a4, 0x02
        # load argument register a5 with parameter '3'
        li      a5, 0x03
        # load argument register a6 with parameter '4'
        li      a6, 0x04
        call    getSubMatrix
        # -- pop parameter
        lw      a4, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a3, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a2, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a1, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, -224(fp)
        # variable 'sub_matrix_2'
        mv      t0, t0
        sw      t0, -264(fp)
        lw      t0, -48(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'exprTemp_7'
        mv      t0, t0
        sw      t0, -268(fp)
        lw      t0, -268(fp)
        # variable 'transfer'
        mv      t0, t0
        sw      t0, -272(fp)
        lw      t0, -272(fp)
        # variable 'iterationCounter'
        mv      t0, t0
        sw      t0, -48(fp)
        # GetAddress(subMatrixA, tmp.1.ptr)
        li      t0, 0x1FFCC
        sw      t0, -228(fp)
        # GetAddress(subMatrixB, tmp.2.ptr)
        li      t0, 0x1FFA8
        sw      t0, -280(fp)
        # GetAddress(tempMult, tmp.3.ptr)
        li      t0, 0x1FF88
        sw      t0, -284(fp)
        # segmentedMatrixMult() -> standardMatrixMult()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a1, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a2, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a3, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a4, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -228(fp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, -280(fp)
        # load argument register a2 with parameter 'tmp.3.ptr'
        lw      a2, -284(fp)
        # load argument register a3 with parameter '1'
        li      a3, 0x01
        # load argument register a4 with parameter '2'
        li      a4, 0x02
        call    standardMatrixMult
        # -- pop parameter
        lw      a4, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a3, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a2, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a1, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, -276(fp)
        # variable 'a22'
        mv      t0, t0
        sw      t0, -288(fp)
        # GetAddress(tempAccum, tmp.1.ptr)
        li      t0, 0x1FF68
        sw      t0, -228(fp)
        # segmentedMatrixMult() -> getSubMatrix()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a1, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a2, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a3, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a4, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -228(fp)
        # load argument register a1 with parameter 'matrixC'
        mv      a1, a2
        # load argument register a2 with parameter '4'
        li      a2, 0x04
        # load argument register a3 with parameter '1'
        li      a3, 0x01
        # load argument register a4 with parameter '2'
        li      a4, 0x02
        # load argument register a5 with parameter '3'
        li      a5, 0x03
        # load argument register a6 with parameter '4'
        li      a6, 0x04
        call    getSubMatrix
        # -- pop parameter
        lw      a4, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a3, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a2, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a1, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, -224(fp)
        # variable 'a33423'
        mv      t0, t0
        sw      t0, -292(fp)
        # GetAddress(tempAccum, tmp.1.ptr)
        li      t0, 0x1FF68
        sw      t0, -228(fp)
        # GetAddress(tempMult, tmp.2.ptr)
        li      t0, 0x1FF88
        sw      t0, -280(fp)
        # segmentedMatrixMult() -> matrixAddInto()
        # ++ push parameter
        addi    sp, sp, -4
        sw      a0, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a1, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a2, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a3, 0(sp)
        # ++ push parameter
        # ++ push parameter
        addi    sp, sp, -4
        sw      a4, 0(sp)
        # ++ push parameter
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -228(fp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, -280(fp)
        # load argument register a2 with parameter '2'
        li      a2, 0x02
        # load argument register a3 with parameter '2'
        li      a3, 0x02
        call    matrixAddInto
        # -- pop parameter
        lw      a4, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a3, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a2, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a1, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        # -- pop parameter
        lw      a0, 0(sp)
        addi    sp, sp, 4
        # -- pop parameter
        lw      t0, -296(fp)
        # variable 'a239'
        mv      t0, t0
        sw      t0, -300(fp)
continue_label_2:
        lw      t0, -244(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.2'
        mv      t0, t0
        sw      t0, -240(fp)
        lw      t0, -240(fp)
        # variable 'ic'
        mv      t0, t0
        sw      t0, -244(fp)
        j       start_2
break_label_2:
continue_label_1:
        lw      t0, -204(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.1'
        mv      t0, t0
        sw      t0, -200(fp)
        lw      t0, -200(fp)
        # variable 'pc'
        mv      t0, t0
        sw      t0, -204(fp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, -192(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.0'
        mv      t0, t0
        sw      t0, -188(fp)
        lw      t0, -188(fp)
        # variable 'jc'
        mv      t0, t0
        sw      t0, -192(fp)
        j       start_0
break_label_0:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 300(sp)
        lw      s0, 296(sp)
        addi    sp, sp, 304
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
        # GetAddress(matrixB, matrixB.ptr)
        li      t0, 0x1FFA0
        sw      t0, -160(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x00
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 1
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 2
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 6
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 8
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 4
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 7
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
        # variable 'matrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -160(fp)
        lw      t1, -164(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -168(fp)
        # variable 'matrixB.ptr.tmp.0'
        li      t0, 5
        sw      t0, -172(fp)
        # StoreToAddress()
        lw      t2, -172(fp)
        lw      t3, -168(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        # GetAddress(matrixC, matrixC.ptr)
        li      t0, 0x1FF50
        sw      t0, -240(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -76(fp)
        li      t0, 0x00
        lw      t1, -76(fp)
        mul     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
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
        # variable 'matrixC.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -240(fp)
        lw      t1, -244(fp)
        sub     t0, t0, t1
        # variable 'matrixC.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -248(fp)
        # variable 'matrixC.ptr.tmp.0'
        li      t0, 0
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 0x1FFF4
        sw      t0, -260(fp)
        # GetAddress(matrixB, tmp.2.ptr)
        li      t0, 0x1FFA0
        sw      t0, -264(fp)
        # GetAddress(matrixC, tmp.3.ptr)
        li      t0, 0x1FF50
        sw      t0, -268(fp)
        # main() -> segmentedMatrixMult()
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, -260(fp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, -264(fp)
        # load argument register a2 with parameter 'tmp.3.ptr'
        lw      a2, -268(fp)
        # load argument register a3 with parameter '2'
        li      a3, 0x02
        # load argument register a4 with parameter '3'
        li      a4, 0x03
        call    segmentedMatrixMult
        lw      t0, -256(fp)
        # variable 'result'
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
