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
test_function:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -12
        sw      ra, 8(sp)
        sw      fp, 4(sp)
        addi    fp, sp, 12
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL0)
        addi    a0, t0, %lo(.SLL0)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 8(sp)
        lw      s0, 4(sp)
        addi    sp, sp, 12
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
matrixAddInto:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -84
        sw      ra, 80(sp)
        sw      fp, 76(sp)
        addi    fp, sp, 84
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL1)
        addi    a0, t0, %lo(.SLL1)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # variable 'i'
        li      t0, 0
        sw      t0, -20(fp)
start_0:
        lw      t0, -20(fp)
        mv      t1, a2
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, -32(fp)
start_1:
        lw      t0, -32(fp)
        mv      t1, a3
        ble     t1, t0, break_label_1
        lw      t0, -20(fp)
        mv      t1, a2
        mul     t0, t0, t1
        # variable 'exprTemp_0'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -36(fp)
        # variable 'temp'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        lw      t1, -32(fp)
        add     t0, t0, t1
        # variable 'exprTemp_1'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        # variable 'tempIndex'
        mv      t0, t0
        sw      t0, -48(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -48(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -60(fp)
        mv      t0, a0
        lw      t1, -60(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.tmp'
        mv      t0, t0
        sw      t0, -64(fp)
        # >> dereference into temp register: t0
        lw      t0, -64(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -52(fp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -48(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrixB.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -72(fp)
        mv      t0, a1
        lw      t1, -72(fp)
        sub     t0, t0, t1
        # variable 'matrixB.ptr.tmp'
        mv      t0, t0
        sw      t0, -76(fp)
        # >> dereference into temp register: t0
        lw      t0, -76(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -68(fp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -48(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -60(fp)
        mv      t0, a0
        lw      t1, -60(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.tmp'
        mv      t0, t0
        sw      t0, -64(fp)
        lw      t0, -52(fp)
        lw      t1, -68(fp)
        add     t0, t0, t1
        # variable 'matrixA.tmp.0'
        mv      t0, t0
        sw      t0, -80(fp)
        # StoreToAddress()
        lw      t2, -80(fp)
        lw      t3, -64(fp)
        sw      t2, 0(t3)
continue_label_1:
        lw      t0, -32(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.1'
        mv      t0, t0
        sw      t0, -28(fp)
        lw      t0, -28(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -32(fp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, -20(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.0'
        mv      t0, t0
        sw      t0, -16(fp)
        lw      t0, -16(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -20(fp)
        j       start_0
break_label_0:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 80(sp)
        lw      s0, 76(sp)
        addi    sp, sp, 84
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
getSubMatrix:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -148
        sw      ra, 144(sp)
        sw      fp, 140(sp)
        addi    fp, sp, 148
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL2)
        addi    a0, t0, %lo(.SLL2)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        mv      t0, a3
        mv      t1, a5
        add     t0, t0, t1
        # variable 'exprTemp_2'
        mv      t0, t0
        sw      t0, -12(fp)
        lw      t0, -12(fp)
        # variable 'xEnd'
        mv      t0, t0
        sw      t0, -16(fp)
        mv      t0, a4
        mv      t1, a6
        add     t0, t0, t1
        # variable 'exprTemp_3'
        mv      t0, t0
        sw      t0, -20(fp)
        lw      t0, -20(fp)
        # variable 'yEnd'
        mv      t0, t0
        sw      t0, -24(fp)
        # variable 'counter'
        li      t0, 0
        sw      t0, -28(fp)
        # variable 'innerI'
        li      t0, 0
        sw      t0, -32(fp)
        mv      t0, a3
        # variable 'i'
        mv      t0, t0
        sw      t0, -44(fp)
start_2:
        lw      t0, -44(fp)
        lw      t1, -16(fp)
        ble     t1, t0, break_label_2
        # variable 'innerJ'
        li      t0, 0
        sw      t0, -48(fp)
        mv      t0, a4
        # variable 'j'
        mv      t0, t0
        sw      t0, -60(fp)
start_3:
        lw      t0, -60(fp)
        lw      t1, -24(fp)
        ble     t1, t0, break_label_3
        lw      t0, -44(fp)
        mv      t1, a2
        mul     t0, t0, t1
        # variable 'exprTemp_4'
        mv      t0, t0
        sw      t0, -64(fp)
        lw      t0, -64(fp)
        # variable 'tempIdx'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -68(fp)
        lw      t1, -60(fp)
        add     t0, t0, t1
        # variable 'exprTemp_5'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -72(fp)
        # variable 'idx'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -32(fp)
        mv      t1, a5
        mul     t0, t0, t1
        # variable 'exprTemp_6'
        mv      t0, t0
        sw      t0, -80(fp)
        lw      t0, -80(fp)
        # variable 'tempIdxC'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -84(fp)
        lw      t1, -48(fp)
        add     t0, t0, t1
        # variable 'exprTemp_7'
        mv      t0, t0
        sw      t0, -88(fp)
        lw      t0, -88(fp)
        # variable 'idxC'
        mv      t0, t0
        sw      t0, -92(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -100(fp)
        lw      t0, -76(fp)
        lw      t1, -100(fp)
        mul     t0, t0, t1
        # variable 'matrixSrc.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -104(fp)
        mv      t0, a1
        lw      t1, -104(fp)
        sub     t0, t0, t1
        # variable 'matrixSrc.ptr.tmp'
        mv      t0, t0
        sw      t0, -108(fp)
        # >> dereference into temp register: t0
        lw      t0, -108(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -96(fp)
        # << store to stack
        # <sizeof int32>
        li      t0, 4
        sw      t0, -100(fp)
        lw      t0, -92(fp)
        lw      t1, -100(fp)
        mul     t0, t0, t1
        # variable 'matrixDest.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -112(fp)
        mv      t0, a0
        lw      t1, -112(fp)
        sub     t0, t0, t1
        # variable 'matrixDest.ptr.tmp'
        mv      t0, t0
        sw      t0, -116(fp)
        lw      t0, -96(fp)
        # variable 'matrixDest.tmp.0'
        mv      t0, t0
        sw      t0, -120(fp)
        # StoreToAddress()
        lw      t2, -120(fp)
        lw      t3, -116(fp)
        sw      t2, 0(t3)
        lw      t0, -48(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'exprTemp_8'
        mv      t0, t0
        sw      t0, -124(fp)
        lw      t0, -124(fp)
        # variable 't'
        mv      t0, t0
        sw      t0, -128(fp)
        lw      t0, -128(fp)
        # variable 'innerJ'
        mv      t0, t0
        sw      t0, -48(fp)
        lw      t0, -28(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'exprTemp_9'
        mv      t0, t0
        sw      t0, -132(fp)
        lw      t0, -132(fp)
        # variable 'tempCounter'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -136(fp)
        # variable 'counter'
        mv      t0, t0
        sw      t0, -28(fp)
continue_label_3:
        lw      t0, -60(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.3'
        mv      t0, t0
        sw      t0, -56(fp)
        lw      t0, -56(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -60(fp)
        j       start_3
break_label_3:
        lw      t0, -32(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'exprTemp_10'
        mv      t0, t0
        sw      t0, -140(fp)
        lw      t0, -140(fp)
        # variable 'u'
        mv      t0, t0
        sw      t0, -144(fp)
        lw      t0, -144(fp)
        # variable 'innerI'
        mv      t0, t0
        sw      t0, -32(fp)
continue_label_2:
        lw      t0, -44(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.2'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -44(fp)
        j       start_2
break_label_2:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 144(sp)
        lw      s0, 140(sp)
        addi    sp, sp, 148
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
setSubMatrix:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -112
        sw      ra, 108(sp)
        sw      fp, 104(sp)
        addi    fp, sp, 112
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL3)
        addi    a0, t0, %lo(.SLL3)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # variable 'i'
        li      t0, 0
        sw      t0, -20(fp)
start_4:
        lw      t0, -20(fp)
        mv      t1, a6
        ble     t1, t0, break_label_4
        # variable 'j'
        li      t0, 0
        sw      t0, -32(fp)
start_5:
        lw      t0, -32(fp)
        mv      t1, a5
        ble     t1, t0, break_label_5
        lw      t0, -20(fp)
        mv      t1, a5
        mul     t0, t0, t1
        # variable 'exprTemp_11'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -36(fp)
        # variable 'temp1'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        lw      t1, -32(fp)
        add     t0, t0, t1
        # variable 'exprTemp_12'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        # variable 'temp2'
        mv      t0, t0
        sw      t0, -48(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -48(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrix_src.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -60(fp)
        mv      t0, a1
        lw      t1, -60(fp)
        sub     t0, t0, t1
        # variable 'matrix_src.ptr.tmp'
        mv      t0, t0
        sw      t0, -64(fp)
        # >> dereference into temp register: t0
        lw      t0, -64(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -52(fp)
        # << store to stack
        mv      t0, a4
        lw      t1, -20(fp)
        add     t0, t0, t1
        # variable 'exprTemp_13'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -68(fp)
        # variable 'temp3'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -72(fp)
        mv      t1, a2
        mul     t0, t0, t1
        # variable 'exprTemp_14'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -76(fp)
        # variable 'temp4'
        mv      t0, t0
        sw      t0, -80(fp)
        mv      t0, a3
        lw      t1, -32(fp)
        add     t0, t0, t1
        # variable 'exprTemp_15'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -84(fp)
        # variable 'temp5'
        mv      t0, t0
        sw      t0, -88(fp)
        lw      t0, -80(fp)
        lw      t1, -88(fp)
        add     t0, t0, t1
        # variable 'exprTemp_16'
        mv      t0, t0
        sw      t0, -92(fp)
        lw      t0, -92(fp)
        # variable 'destIndex'
        mv      t0, t0
        sw      t0, -96(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -96(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrix_dest.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -100(fp)
        mv      t0, a0
        lw      t1, -100(fp)
        sub     t0, t0, t1
        # variable 'matrix_dest.ptr.tmp'
        mv      t0, t0
        sw      t0, -104(fp)
        lw      t0, -52(fp)
        # variable 'matrix_dest.tmp.0'
        mv      t0, t0
        sw      t0, -108(fp)
        # StoreToAddress()
        lw      t2, -108(fp)
        lw      t3, -104(fp)
        sw      t2, 0(t3)
continue_label_5:
        lw      t0, -32(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.5'
        mv      t0, t0
        sw      t0, -28(fp)
        lw      t0, -28(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -32(fp)
        j       start_5
break_label_5:
continue_label_4:
        lw      t0, -20(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.4'
        mv      t0, t0
        sw      t0, -16(fp)
        lw      t0, -16(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -20(fp)
        j       start_4
break_label_4:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 108(sp)
        lw      s0, 104(sp)
        addi    sp, sp, 112
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
standardMatrixMult:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -160
        sw      ra, 156(sp)
        sw      fp, 152(sp)
        addi    fp, sp, 160
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL4)
        addi    a0, t0, %lo(.SLL4)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # variable 'counter'
        li      t0, 0
        sw      t0, -12(fp)
        # variable 'i'
        li      t0, 0
        sw      t0, -24(fp)
start_6:
        lw      t0, -24(fp)
        mv      t1, a3
        ble     t1, t0, break_label_6
        # variable 'j'
        li      t0, 0
        sw      t0, -36(fp)
start_7:
        lw      t0, -36(fp)
        mv      t1, a4
        ble     t1, t0, break_label_7
        # variable 'k'
        li      t0, 0
        sw      t0, -48(fp)
start_8:
        lw      t0, -48(fp)
        mv      t1, a4
        ble     t1, t0, break_label_8
        lw      t0, -24(fp)
        mv      t1, a4
        mul     t0, t0, t1
        # variable 'exprTemp_17'
        mv      t0, t0
        sw      t0, -52(fp)
        lw      t0, -52(fp)
        # variable 'temp_aIdx'
        mv      t0, t0
        sw      t0, -56(fp)
        lw      t0, -56(fp)
        lw      t1, -48(fp)
        add     t0, t0, t1
        # variable 'exprTemp_18'
        mv      t0, t0
        sw      t0, -60(fp)
        lw      t0, -60(fp)
        # variable 'aIdx'
        mv      t0, t0
        sw      t0, -64(fp)
        lw      t0, -48(fp)
        mv      t1, a4
        mul     t0, t0, t1
        # variable 'exprTemp_19'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -68(fp)
        # variable 'temp_bIdx'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -72(fp)
        lw      t1, -36(fp)
        add     t0, t0, t1
        # variable 'exprTemp_20'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -76(fp)
        # variable 'bIdx'
        mv      t0, t0
        sw      t0, -80(fp)
        lw      t0, -24(fp)
        mv      t1, a3
        mul     t0, t0, t1
        # variable 'exprTemp_21'
        mv      t0, t0
        sw      t0, -84(fp)
        lw      t0, -84(fp)
        # variable 'temp_cIdx'
        mv      t0, t0
        sw      t0, -88(fp)
        lw      t0, -88(fp)
        lw      t1, -36(fp)
        add     t0, t0, t1
        # variable 'exprTemp_22'
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
        # variable 'exprTemp_23'
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
        # variable 'exprTemp_24'
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
continue_label_8:
        lw      t0, -48(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.8'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        # variable 'k'
        mv      t0, t0
        sw      t0, -48(fp)
        j       start_8
break_label_8:
continue_label_7:
        lw      t0, -36(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.7'
        mv      t0, t0
        sw      t0, -32(fp)
        lw      t0, -32(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -36(fp)
        j       start_7
break_label_7:
continue_label_6:
        lw      t0, -24(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.6'
        mv      t0, t0
        sw      t0, -20(fp)
        lw      t0, -20(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -24(fp)
        j       start_6
break_label_6:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 156(sp)
        lw      s0, 152(sp)
        addi    sp, sp, 160
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
segmentedMatrixMult:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -216
        sw      ra, 212(sp)
        sw      fp, 208(sp)
        addi    fp, sp, 216
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL5)
        addi    a0, t0, %lo(.SLL5)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # variable 'nc'
        li      t0, 2
        sw      t0, -12(fp)
        mv      t0, a3
        lw      t1, -12(fp)
        div     t0, t0, t1
        # variable 'exprTemp_25'
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
        # variable 'exprTemp_26'
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
        # variable 'exprTemp_27'
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
        li      t0, 80
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
        li      t0, 81
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
        li      t0, 82
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
        li      t0, 83
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
        li      t0, 70
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
        li      t0, 71
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
        li      t0, 72
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
        li      t0, 73
        sw      t0, -112(fp)
        # StoreToAddress()
        lw      t2, -112(fp)
        lw      t3, -108(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        # GetAddress(tempAccum, tempAccum.ptr)
        li      t0, 0x1FF8C
        sw      t0, -132(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -64(fp)
        li      t0, 0x00
        lw      t1, -64(fp)
        mul     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 60
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
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 61
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
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 62
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
        # variable 'tempAccum.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -136(fp)
        lw      t0, -132(fp)
        lw      t1, -136(fp)
        sub     t0, t0, t1
        # variable 'tempAccum.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -140(fp)
        # variable 'tempAccum.ptr.tmp.0'
        li      t0, 63
        sw      t0, -144(fp)
        # StoreToAddress()
        lw      t2, -144(fp)
        lw      t3, -140(fp)
        sw      t2, 0(t3)
        # variable 'jc'
        li      t0, 0
        sw      t0, -156(fp)
start_9:
        lw      t0, -156(fp)
        lw      t1, -20(fp)
        ble     t1, t0, break_label_9
        # variable 'pc'
        li      t0, 0
        sw      t0, -168(fp)
start_10:
        lw      t0, -168(fp)
        lw      t1, -32(fp)
        ble     t1, t0, break_label_10
        lw      t0, -168(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_28'
        mv      t0, t0
        sw      t0, -172(fp)
        lw      t0, -172(fp)
        # variable 'xPos_b'
        mv      t0, t0
        sw      t0, -176(fp)
        lw      t0, -156(fp)
        lw      t1, -12(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_29'
        mv      t0, t0
        sw      t0, -180(fp)
        lw      t0, -180(fp)
        # variable 'yPos_b'
        mv      t0, t0
        sw      t0, -184(fp)
        # variable 'ic'
        li      t0, 0
        sw      t0, -196(fp)
start_11:
        lw      t0, -196(fp)
        lw      t1, -44(fp)
        ble     t1, t0, break_label_11
        lw      t0, -196(fp)
        lw      t1, -36(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_30'
        mv      t0, t0
        sw      t0, -200(fp)
        lw      t0, -200(fp)
        # variable 'xPos_a'
        mv      t0, t0
        sw      t0, -204(fp)
        lw      t0, -168(fp)
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_31'
        mv      t0, t0
        sw      t0, -208(fp)
        lw      t0, -208(fp)
        # variable 'yPos_a'
        mv      t0, t0
        sw      t0, -212(fp)
continue_label_11:
        lw      t0, -196(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.11'
        mv      t0, t0
        sw      t0, -192(fp)
        lw      t0, -192(fp)
        # variable 'ic'
        mv      t0, t0
        sw      t0, -196(fp)
        j       start_11
break_label_11:
continue_label_10:
        lw      t0, -168(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.10'
        mv      t0, t0
        sw      t0, -164(fp)
        lw      t0, -164(fp)
        # variable 'pc'
        mv      t0, t0
        sw      t0, -168(fp)
        j       start_10
break_label_10:
continue_label_9:
        lw      t0, -156(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.9'
        mv      t0, t0
        sw      t0, -152(fp)
        lw      t0, -152(fp)
        # variable 'jc'
        mv      t0, t0
        sw      t0, -156(fp)
        j       start_9
break_label_9:
        mv      t6, a0
        lui     t0, %hi(.SLL6)
        addi    a0, t0, %lo(.SLL6)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 212(sp)
        lw      s0, 208(sp)
        addi    sp, sp, 216
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
upCountingMatrix:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -80
        sw      ra, 76(sp)
        sw      fp, 72(sp)
        addi    fp, sp, 80
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL7)
        addi    a0, t0, %lo(.SLL7)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # variable 'count'
        li      t0, 1
        sw      t0, -12(fp)
        # variable 'i'
        li      t0, 0
        sw      t0, -24(fp)
start_12:
        lw      t0, -24(fp)
        mv      t1, a1
        ble     t1, t0, break_label_12
        # variable 'j'
        li      t0, 0
        sw      t0, -36(fp)
start_13:
        lw      t0, -36(fp)
        mv      t1, a1
        ble     t1, t0, break_label_13
        mv      t0, a1
        lw      t1, -24(fp)
        mul     t0, t0, t1
        # variable 'exprTemp_32'
        mv      t0, t0
        sw      t0, -40(fp)
        lw      t0, -40(fp)
        # variable 'temp'
        mv      t0, t0
        sw      t0, -44(fp)
        lw      t0, -44(fp)
        lw      t1, -36(fp)
        add     t0, t0, t1
        # variable 'exprTemp_33'
        mv      t0, t0
        sw      t0, -48(fp)
        lw      t0, -48(fp)
        # variable 'idx'
        mv      t0, t0
        sw      t0, -52(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -56(fp)
        lw      t0, -52(fp)
        lw      t1, -56(fp)
        mul     t0, t0, t1
        # variable 'matrix.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -60(fp)
        mv      t0, a0
        lw      t1, -60(fp)
        sub     t0, t0, t1
        # variable 'matrix.ptr.tmp'
        mv      t0, t0
        sw      t0, -64(fp)
        lw      t0, -12(fp)
        # variable 'matrix.tmp.0'
        mv      t0, t0
        sw      t0, -68(fp)
        # StoreToAddress()
        lw      t2, -68(fp)
        lw      t3, -64(fp)
        sw      t2, 0(t3)
        lw      t0, -12(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'exprTemp_34'
        mv      t0, t0
        sw      t0, -72(fp)
        lw      t0, -72(fp)
        # variable 't'
        mv      t0, t0
        sw      t0, -76(fp)
        lw      t0, -76(fp)
        # variable 'count'
        mv      t0, t0
        sw      t0, -12(fp)
continue_label_13:
        lw      t0, -36(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.13'
        mv      t0, t0
        sw      t0, -32(fp)
        lw      t0, -32(fp)
        # variable 'j'
        mv      t0, t0
        sw      t0, -36(fp)
        j       start_13
break_label_13:
continue_label_12:
        lw      t0, -24(fp)
        li      t1, 0x01
        add     t0, t0, t1
        # variable 'tmp.1.12'
        mv      t0, t0
        sw      t0, -20(fp)
        lw      t0, -20(fp)
        # variable 'i'
        mv      t0, t0
        sw      t0, -24(fp)
        j       start_12
break_label_12:
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 76(sp)
        lw      s0, 72(sp)
        addi    sp, sp, 80
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -276
        sw      ra, 272(sp)
        sw      fp, 268(sp)
        addi    fp, sp, 276
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL8)
        addi    a0, t0, %lo(.SLL8)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
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
        li      t0, 1
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
        li      t0, 2
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
        li      t0, 3
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
        li      t0, 5
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
        li      t0, 7
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
        li      t0, 8
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
        li      t0, 10
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
        li      t0, 11
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
        li      t0, 12
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
        li      t0, 13
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
        li      t0, 14
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
        li      t0, 15
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
        li      t0, 16
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
        li      t0, 3
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
        li      t0, 4
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
        li      t0, 5
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
        li      t0, 7
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
        li      t0, 8
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
        li      t0, 9
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
        li      t0, 10
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
        li      t0, 11
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
        li      t0, 12
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
        li      t0, 13
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
        li      t0, 14
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
        li      t0, 15
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
        li      t0, 16
        sw      t0, -252(fp)
        # StoreToAddress()
        lw      t2, -252(fp)
        lw      t3, -248(fp)
        sw      t2, 0(t3)
        mv      t6, a0
        lui     t0, %hi(.SLL9)
        addi    a0, t0, %lo(.SLL9)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 0x1FFF4
        sw      t0, -260(fp)
        # GetAddress(matrixB, tmp.2.ptr)
        li      t0, 0x1FF50
        sw      t0, -264(fp)
        # GetAddress(matrixC, tmp.3.ptr)
        li      t0, 0x1FFA0
        sw      t0, -268(fp)
        # main() -> segmentedMatrixMult()
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
        print_reg sp
        call    segmentedMatrixMult
        print_reg sp
        nop
        lw      t0, -256(fp)
        # variable 'result_1'
        mv      t0, t0
        sw      t0, -272(fp)
        mv      t6, a0
        lui     t0, %hi(.SLL10)
        addi    a0, t0, %lo(.SLL10)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        mv      t6, a0
        lui     t0, %hi(.SLL11)
        addi    a0, t0, %lo(.SLL11)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        call    exit
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 272(sp)
        lw      s0, 268(sp)
        addi    sp, sp, 276
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
.SLL0: 
        .string "test_function\n"
.SLL1: 
        .string "matrixAddInto()\n"
.SLL2: 
        .string "getSubMatrix()\n"
.SLL3: 
        .string "setSubMatrix()\n"
.SLL4: 
        .string "standardMatrixMult()\n"
.SLL5: 
        .string "segmentedMatrixMult()\n"
.SLL6: 
        .string "segmentedMatrixMult() end\n"
.SLL7: 
        .string "upCountingMatrix()\n"
.SLL8: 
        .string "main() 1\n"
.SLL9: 
        .string "main() 2\n"
.SLL10: 
        .string "main() 3\n"
.SLL11: 
        .string "main() 4\n"
