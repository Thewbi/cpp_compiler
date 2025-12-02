.LABEL_0: 
        .string "test_string_test\n"
main:
_start:
        addi    sp, sp, -36
        # variable 'i'
        li      t0, 0
        sw      t0, 28(sp)
start_0:
        lw      t0, 28(sp)
        li      t1, 4
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, 24(sp)
start_1:
        lw      t0, 24(sp)
        li      t1, 4
        ble     t1, t0, break_label_1
        li      t0, 4
        lw      t1, 28(sp)
        mul     a5, t0, t1
        # variable 'exprTemp_0'
        mv      t0, a5
        sw      t0, 16(sp)
        lw      t0, 16(sp)
        lw      t1, 24(sp)
        add     a5, t0, t1
        # variable 'exprTemp_1'
        mv      t0, a5
        sw      t0, 20(sp)
        lw      a5, 20(sp)
        # variable 'temp'
        mv      t0, a5
        sw      t0, 36(sp)
        lui     a5, %hi(.LABEL_0)
        addi    a0, a5, %lo(.LABEL_0)
        lw      a5, 20(sp)
        mv      a1, a5
        call    puts
continue_label_1:
        lw      t0, 24(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.1'
        mv      t0, a5
        sw      t0, 12(sp)
        lw      a5, 12(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 24(sp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, 28(sp)
        li      t1, 1
        add     a5, t0, t1
        # variable 'tmp.1.0'
        mv      t0, a5
        sw      t0, 8(sp)
        lw      a5, 8(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 28(sp)
        j       start_0
break_label_0:
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
