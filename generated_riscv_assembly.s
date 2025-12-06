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
segmentedMatrixMult:
        # -- stack frame create --
        addi    sp, sp, -408
        sw      ra, 404(sp)
        sw      s0, 400(sp)
        addi    s0, sp, 408
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
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        # GetAddress(subMatrixA, subMatrixA.ptr)
        li      t0, 0x1FFD0
        sw      t0, -68(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x00
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -68(fp)
        lw      t1, -72(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -76(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -80(fp)
        # StoreToAddress()
        lw      t2, -80(fp)
        lw      t3, -76(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x01
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -68(fp)
        lw      t1, -72(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -76(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -80(fp)
        # StoreToAddress()
        lw      t2, -80(fp)
        lw      t3, -76(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x02
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -68(fp)
        lw      t1, -72(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -76(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -80(fp)
        # StoreToAddress()
        lw      t2, -80(fp)
        lw      t3, -76(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x03
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -68(fp)
        lw      t1, -72(fp)
        sub     t0, t0, t1
        # variable 'subMatrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -76(fp)
        # variable 'subMatrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, -80(fp)
        # StoreToAddress()
        lw      t2, -80(fp)
        lw      t3, -76(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        # GetAddress(subMatrixB, subMatrixB.ptr)
        li      t0, 0x1FFAC
        sw      t0, -100(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x00
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -104(fp)
        lw      t0, -100(fp)
        lw      t1, -104(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -108(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -112(fp)
        # StoreToAddress()
        lw      t2, -112(fp)
        lw      t3, -108(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x01
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -104(fp)
        lw      t0, -100(fp)
        lw      t1, -104(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -108(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -112(fp)
        # StoreToAddress()
        lw      t2, -112(fp)
        lw      t3, -108(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x02
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -104(fp)
        lw      t0, -100(fp)
        lw      t1, -104(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -108(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -112(fp)
        # StoreToAddress()
        lw      t2, -112(fp)
        lw      t3, -108(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x03
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -104(fp)
        lw      t0, -100(fp)
        lw      t1, -104(fp)
        sub     t0, t0, t1
        # variable 'subMatrixB.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -108(fp)
        # variable 'subMatrixB.ptr.tmp.0'
        li      t0, 0
        sw      t0, -112(fp)
        # StoreToAddress()
        lw      t2, -112(fp)
        lw      t3, -108(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        # GetAddress(tempMult, tempMult.ptr)
        li      t0, 0x1FF8C
        sw      t0, -132(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x00
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -144(fp)
        # StoreToAddress()
        lw      t2, -144(fp)
        lw      t3, -140(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x01
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -144(fp)
        # StoreToAddress()
        lw      t2, -144(fp)
        lw      t3, -140(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x02
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -144(fp)
        # StoreToAddress()
        lw      t2, -144(fp)
        lw      t3, -140(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x03
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempMult.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempMult.ptr.tmp.0'
        li      t0, 0
        sw      t0, -144(fp)
        # StoreToAddress()
        lw      t2, -144(fp)
        lw      t3, -140(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        # GetAddress(tempAccum, tempAccum.ptr)
        li      t0, 0x1FF6C
        sw      t0, -164(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x00
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -168(fp)
        lw      t0, -164(fp)
        lw      t1, -168(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -172(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -176(fp)
        # StoreToAddress()
        lw      t2, -176(fp)
        lw      t3, -172(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x01
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -168(fp)
        lw      t0, -164(fp)
        lw      t1, -168(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -172(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -176(fp)
        # StoreToAddress()
        lw      t2, -176(fp)
        lw      t3, -172(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x02
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -168(fp)
        lw      t0, -164(fp)
        lw      t1, -168(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -172(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -176(fp)
        # StoreToAddress()
        lw      t2, -176(fp)
        lw      t3, -172(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x03
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -168(fp)
        lw      t0, -164(fp)
        lw      t1, -168(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -172(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 0
        sw      t0, -176(fp)
        # StoreToAddress()
        lw      t2, -176(fp)
        lw      t3, -172(fp)
        sw      t2, 0(t3)
        # variable 'jc'
        li      t0, 0
        sw      t0, -188(fp)
start_0:
        lw      t0, -188(fp)
        lw      t1, -20(fp)
        ble     t1, t0, break_label_0
        # variable 'pc'
        li      t0, 0
        sw      t0, -200(fp)
start_1:
        lw      t0, -200(fp)
        lw      t1, -32(fp)
        ble     t1, t0, break_label_1
        lw      t0, -200(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_3'
        mv      t0, t0
        sw      t0, -204(fp)
        lw      t0, -204(fp)
        # variable 'xPos_b'
        mv      t0, t0
        sw      t0, -208(fp)
        lw      t0, -188(fp)
        lw      t1, -12(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_4'
        mv      t0, t0
        sw      t0, -212(fp)
        lw      t0, -212(fp)
        # variable 'yPos_b'
        mv      t0, t0
        sw      t0, -216(fp)
        # variable 'ic'
        li      t0, 0
        sw      t0, -228(fp)
start_2:
        lw      t0, -228(fp)
        lw      t1, -44(fp)
        ble     t1, t0, break_label_2
        lw      t0, -228(fp)
        lw      t1, -36(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_5'
        mv      t0, t0
        sw      t0, -232(fp)
        lw      t0, -232(fp)
        # variable 'xPos_a'
        mv      t0, t0
        sw      t0, -236(fp)
        lw      t0, -200(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_6'
        mv      t0, t0
        sw      t0, -240(fp)
        lw      t0, -240(fp)
        # variable 'yPos_a'
        mv      t0, t0
        sw      t0, -244(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_7'
        mv      t0, t0
        sw      t0, -248(fp)
        lw      t0, -248(fp)
        # variable 'xPos_c'
        mv      t0, t0
        sw      t0, -252(fp)
        lw      t0, -188(fp)
        lw      t1, -12(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_8'
        mv      t0, t0
        sw      t0, -256(fp)
        lw      t0, -256(fp)
        # variable 'yPos_c'
        mv      t0, t0
        sw      t0, -260(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_9'
        mv      t0, t0
        sw      t0, -264(fp)
        lw      t0, -264(fp)
        # variable 'xPos_d'
        mv      t0, t0
        sw      t0, -268(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_10'
        mv      t0, t0
        sw      t0, -272(fp)
        lw      t0, -272(fp)
        # variable 'xPos_e'
        mv      t0, t0
        sw      t0, -276(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_11'
        mv      t0, t0
        sw      t0, -280(fp)
        lw      t0, -280(fp)
        # variable 'xPos_f'
        mv      t0, t0
        sw      t0, -284(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_12'
        mv      t0, t0
        sw      t0, -288(fp)
        lw      t0, -288(fp)
        # variable 'xPos_g'
        mv      t0, t0
        sw      t0, -292(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_13'
        mv      t0, t0
        sw      t0, -296(fp)
        lw      t0, -296(fp)
        # variable 'xPos_h'
        mv      t0, t0
        sw      t0, -300(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_14'
        mv      t0, t0
        sw      t0, -304(fp)
        lw      t0, -304(fp)
        # variable 'xPos_i'
        mv      t0, t0
        sw      t0, -308(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_15'
        mv      t0, t0
        sw      t0, -312(fp)
        lw      t0, -312(fp)
        # variable 'xPos_j'
        mv      t0, t0
        sw      t0, -316(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_16'
        mv      t0, t0
        sw      t0, -320(fp)
        lw      t0, -320(fp)
        # variable 'xPos_k'
        mv      t0, t0
        sw      t0, -324(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_17'
        mv      t0, t0
        sw      t0, -328(fp)
        lw      t0, -328(fp)
        # variable 'xPos_l'
        mv      t0, t0
        sw      t0, -332(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_18'
        mv      t0, t0
        sw      t0, -336(fp)
        lw      t0, -336(fp)
        # variable 'xPos_m'
        mv      t0, t0
        sw      t0, -340(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_19'
        mv      t0, t0
        sw      t0, -344(fp)
        lw      t0, -344(fp)
        # variable 'xPos_n'
        mv      t0, t0
        sw      t0, -348(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_20'
        mv      t0, t0
        sw      t0, -352(fp)
        lw      t0, -352(fp)
        # variable 'xPos_o'
        mv      t0, t0
        sw      t0, -356(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_21'
        mv      t0, t0
        sw      t0, -360(fp)
        lw      t0, -360(fp)
        # variable 'xPos_p'
        mv      t0, t0
        sw      t0, -364(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_22'
        mv      t0, t0
        sw      t0, -368(fp)
        lw      t0, -368(fp)
        # variable 'xPos_q'
        mv      t0, t0
        sw      t0, -372(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_23'
        mv      t0, t0
        sw      t0, -376(fp)
        lw      t0, -376(fp)
        # variable 'xPos_d2'
        mv      t0, t0
        sw      t0, -380(fp)
        lw      t0, -228(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_24'
        mv      t0, t0
        sw      t0, -384(fp)
        lw      t0, -384(fp)
        # variable 'xPos_e2'
        mv      t0, t0
        sw      t0, -388(fp)
        # GetAddress(tempAccum, tmp.1.ptr)
        li      t0, 0x1FF6C
        sw      t0, -396(fp)
        # GetAddress(tempMult, tmp.2.ptr)
        li      t0, 0x1FF8C
        sw      t0, -400(fp)
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
        lw      a0, -396(fp)
        # load argument register a1 with parameter 'tmp.2.ptr'
        lw      a1, -400(fp)
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
        lw      t0, -392(fp)
        # variable 'a239'
        mv      t0, t0
        sw      t0, -404(fp)
continue_label_2:
        lw      t0, -228(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.2'
        mv      t0, t0
        sw      t0, -224(fp)
        lw      t0, -224(fp)
        # variable 'ic'
        mv      t0, t0
        sw      t0, -228(fp)
        j       start_2
break_label_2:
continue_label_1:
        lw      t0, -200(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.1'
        mv      t0, t0
        sw      t0, -196(fp)
        lw      t0, -196(fp)
        # variable 'pc'
        mv      t0, t0
        sw      t0, -200(fp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, -188(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.0'
        mv      t0, t0
        sw      t0, -184(fp)
        lw      t0, -184(fp)
        # variable 'jc'
        mv      t0, t0
        sw      t0, -188(fp)
        j       start_0
break_label_0:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 404(sp)
        lw      s0, 400(sp)
        addi    sp, sp, 408
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
