    addi  $s0, $0, 4
    addi  $s1, $0, 1
    sll   $s1, $s1, 2
    bne   $s0, $s1, target
    addi  $s1, $s1, 1
    sub   $s1, $s1, $s0

target:
    add   $s1, $s1, $s0

