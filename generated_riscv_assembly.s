.LABEL_0: 
        .string "test_string_test\n"
main:
_start:
        addi    sp, sp, -24
        # variable 'i'
        li      t0, 0
        sw      t0, 20(sp)
start_0:
        lw      t0, 20(sp)
        li      t1, 4
        ble     t1, t0, break_label_0
        # variable 'j'
        li      t0, 0
        sw      t0, 16(sp)
start_1:
        lw      t0, 16(sp)
        li      t1, 4
        ble     t1, t0, break_label_1
        lui     a5, %hi(.LABEL_0)
        addi    a0, a5, %lo(.LABEL_0)
        call    puts
continue_label_1:
        lw      t0, 16(sp)
        addi    a5, t0, 1
        # variable 'tmp.1.1'
        mv      t0, a5
        sw      t0, 12(sp)
        lw      a5, 12(sp)
        # variable 'j'
        mv      t0, a5
        sw      t0, 16(sp)
        j       start_1
break_label_1:
continue_label_0:
        lw      t0, 20(sp)
        addi    a5, t0, 1
        # variable 'tmp.1.0'
        mv      t0, a5
        sw      t0, 8(sp)
        lw      a5, 8(sp)
        # variable 'i'
        mv      t0, a5
        sw      t0, 20(sp)
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
