.LABEL_0: 
        .string "test_string_test\n"
prettyPrintFormatMatrix:
        # -- stack frame create --
        addi    sp, sp, -68
        sw      ra, 64(sp), 
        sw      s0, 60(sp), 
        addi    s0, sp, 68
        # -- stack frame create --
        # variable 'count'
        li      t0, 1
        sw      t0, 60(sp)
        # variable 'i'
        li      t0, 0
        sw      t0, 48(sp)
start_0:
        lw      t0, 48(sp)
        mv      t1, a1
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, 36(sp)
start_1:
        lw      t0, 36(sp)
        mv      t1, a1
        ble     t1, t0, break_label_1
        mv      t0, a1
        lw      t1, 48(sp)
        mul     a5, t0, t1
        # variable 'exprTemp_0'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      a5, 32(sp)
        # variable 'idx_temp'
        mv      t0, a5
        sw      t0, 28(sp)
        lw      t0, 28(sp)
        lw      t1, 36(sp)
        add     a5, t0, t1
        # variable 'exprTemp_1'
        mv      t0, a5
        sw      t0, 24(sp)
        lw      a5, 24(sp)
        # variable 'idx'
        mv      t0, a5
        sw      t0, 20(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 12(sp)
        lw      t0, 20(sp)
        lw      t1, 12(sp)
        mul     a5, t0, t1
        # variable 'matrix.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 8(sp)
        mv      t0, a0
        lw      t1, 8(sp)
        add     a5, t0, t1
        # variable 'matrix.ptr.tmp'
        mv      t0, a5
        sw      t0, 4(sp)
        lw      t0, 4(sp)
        sw      t0, 16(sp)
        mv      t6, a0
        lui     t0, %hi(.LABEL_0)
        addi    a0, t0, %lo(.LABEL_0)
        call    puts
        mv      a0, t6
continue_label_1:
        lw      t0, 36(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.1'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      a5, 40(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 36(sp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, 48(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.0'
        mv      t0, a5
        sw      t0, 52(sp)
        lw      a5, 52(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 48(sp)
        j       start_0
break_label_0:
        # -- stack frame remove --
        lw      ra, 64(sp), 
        lw      s0, 60(sp), 
        addi    sp, sp, 68
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
start_2:
        lw      t0, 56(sp)
        mv      t1, a1
        ble     t1, t0, break_label_2
        # variable 'j'
        li      t0, 0
        sw      t0, 44(sp)
start_3:
        lw      t0, 44(sp)
        mv      t1, a1
        ble     t1, t0, break_label_3
        mv      t0, a1
        lw      t1, 56(sp)
        mul     a5, t0, t1
        # variable 'exprTemp_2'
        mv      t0, a5
        sw      t0, 40(sp)
        lw      a5, 40(sp)
        # variable 'temp'
        mv      t0, a5
        sw      t0, 36(sp)
        lw      t0, 36(sp)
        lw      t1, 44(sp)
        add     a5, t0, t1
        # variable 'exprTemp_3'
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
        nop
        lw      a5, 68(sp)
        # variable 'jj'
        mv      t0, a5
        sw      t0, 8(sp)
        lw      t0, 8(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'exprTemp_4'
        mv      t0, a5
        sw      t0, 4(sp)
        lw      a5, 4(sp)
        # variable 'count'
        mv      t0, a5
        sw      t0, 68(sp)
continue_label_3:
        lw      t0, 44(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.3'
        mv      t0, a5
        sw      t0, 48(sp)
        lw      a5, 48(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 44(sp)
        j       start_3
break_label_3:
continue_label_2:
        lw      t0, 56(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.2'
        mv      t0, a5
        sw      t0, 60(sp)
        lw      a5, 60(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 56(sp)
        j       start_2
break_label_2:
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
        addi    sp, sp, -112
        sw      ra, 108(sp), 
        sw      s0, 104(sp), 
        addi    s0, sp, 112
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 131004
        sw      t0, 36(sp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 0
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 1
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 0
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 2
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 3
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 4
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 5
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 6
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 7
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 8
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 9
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 10
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 8
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 11
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 12
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 6
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 13
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 9
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 14
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 7
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # <sizeof int32>
        li      t0, 4
        sw      t0, 40(sp)
        li      t0, 15
        lw      t1, 40(sp)
        mul     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, a5
        sw      t0, 32(sp)
        lw      t0, 36(sp)
        lw      t1, 32(sp)
        add     a5, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, a5
        sw      t0, 28(sp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, 24(sp)
        # StoreToAddress()
        lw      t2, 24(sp)
        lw      t3, 28(sp)
        sw      t2, 0(t3)
        nop
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 131004
        sw      t0, 16(sp)
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, 16(sp)
        # load argument register a1 with parameter '4'
        li      a1, 4
        call    upCountingMatrix
        lw      a5, 20(sp)
        # variable 'result1'
        mv      t0, a5
        sw      t0, 12(sp)
        # GetAddress(matrixA, tmp.1.ptr)
        li      t0, 131004
        sw      t0, 16(sp)
        # load argument register a0 with parameter 'tmp.1.ptr'
        lw      a0, 16(sp)
        # load argument register a1 with parameter '4'
        li      a1, 4
        call    prettyPrintFormatMatrix
        lw      a5, 8(sp)
        # variable 'result2'
        mv      t0, a5
        sw      t0, 4(sp)
        call    exit
        # -- stack frame remove --
        lw      ra, 108(sp), 
        lw      s0, 104(sp), 
        addi    sp, sp, 112
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
