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
        addi    sp, sp, -48
        sw      ra, 44(sp)
        sw      fp, 40(sp)
        addi    fp, sp, 48
        # -- stack frame create --
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        # GetAddress(matrix_in_test_function, matrix_in_test_function.ptr)
        li      t0, 0x1FFF4
        sw      t0, -32(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x00
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrix_in_test_function.ptr.tmp.0'
        li      t0, 80
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x01
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrix_in_test_function.ptr.tmp.0'
        li      t0, 81
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x02
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrix_in_test_function.ptr.tmp.0'
        li      t0, 82
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x03
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrix_in_test_function.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrix_in_test_function.ptr.tmp.0'
        li      t0, 83
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 44(sp)
        lw      s0, 40(sp)
        addi    sp, sp, 48
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
main:
_start:
        # -- stack frame create --
        print_reg sp
        addi    sp, sp, -76
        sw      ra, 72(sp)
        sw      fp, 68(sp)
        addi    fp, sp, 76
        # -- stack frame create --
        mv      t6, a0
        lui     t0, %hi(.SLL0)
        addi    a0, t0, %lo(.SLL0)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        # GetAddress(matrixA, matrixA.ptr)
        li      t0, 0x1FFF4
        sw      t0, -32(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x00
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 1
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x01
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 2
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x02
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 3
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x03
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -36(fp)
        lw      t0, -32(fp)
        lw      t1, -36(fp)
        sub     t0, t0, t1
        # variable 'matrixA.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -40(fp)
        # variable 'matrixA.ptr.tmp.0'
        li      t0, 4
        sw      t0, -44(fp)
        # StoreToAddress()
        lw      t2, -44(fp)
        lw      t3, -40(fp)
        sw      t2, 0(t3)
        # variable 'param_1'
        li      t0, 1
        sw      t0, -48(fp)
        # main() -> test_function()
        # load argument register a0 with parameter 'param_1'
        lw      a0, -48(fp)
        print_reg sp
        call    test_function
        print_reg sp
        nop
        lw      t0, -52(fp)
        # variable 'test_function_result'
        mv      t0, t0
        sw      t0, -56(fp)
        # GetAddress(matrixA, matrixA.addr.ptr)
        li      t0, 0x1FFF4
        sw      t0, -64(fp)
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x00
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -64(fp)
        lw      t1, -68(fp)
        sub     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -72(fp)
        # >> dereference into temp register: t0
        lw      t0, -72(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -60(fp)
        # << store to stack
        mv      t6, a0
        lw      a0, -60(fp)
        call    putint
        mv      a0, t6
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x01
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -64(fp)
        lw      t1, -68(fp)
        sub     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -72(fp)
        # >> dereference into temp register: t0
        lw      t0, -72(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -60(fp)
        # << store to stack
        mv      t6, a0
        lw      a0, -60(fp)
        call    putint
        mv      a0, t6
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x02
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -64(fp)
        lw      t1, -68(fp)
        sub     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -72(fp)
        # >> dereference into temp register: t0
        lw      t0, -72(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -60(fp)
        # << store to stack
        mv      t6, a0
        lw      a0, -60(fp)
        call    putint
        mv      a0, t6
        # <sizeof int32>
        li      t0, 4
        sw      t0, -28(fp)
        li      t0, 0x03
        lw      t1, -28(fp)
        mul     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp.1'
        mv      t0, t0
        sw      t0, -68(fp)
        lw      t0, -64(fp)
        lw      t1, -68(fp)
        sub     t0, t0, t1
        # variable 'matrixA.addr.ptr.ptr.tmp'
        mv      t0, t0
        sw      t0, -72(fp)
        # >> dereference into temp register: t0
        lw      t0, -72(fp)
        lw      t0, 0(t0)
        # << dereference into temp register: t0
        # >> store to stack
        sw      t0, -60(fp)
        # << store to stack
        mv      t6, a0
        lw      a0, -60(fp)
        call    putint
        mv      a0, t6
        mv      t6, a0
        lui     t0, %hi(.SLL1)
        addi    a0, t0, %lo(.SLL1)
        print_reg sp
        call    puts
        print_reg sp
        mv      a0, t6
        call    exit
        li      a0, 0x00
        # -- stack frame remove --
        lw      ra, 72(sp)
        lw      s0, 68(sp)
        addi    sp, sp, 76
        print_reg sp
        # -- stack frame remove --
        nop
        # <processReturn()>
        ret
.SLL0: 
        .string "main() start \n"
.SLL1: 
        .string "main() end \n"
