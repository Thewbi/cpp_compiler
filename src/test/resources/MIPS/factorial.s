# Source: https://ethz.ch/content/dam/ethz/special-interest/infk/inst-infsec/system-security-group-dam/education/Digitaltechnik_17/MIPS_Programming_24032017.pdf
#
# MIPS assembly code
factorial: addi $sp, $sp, -8 # make room
sw $a0, 4($sp) # store $a0
sw $ra, 0($sp) # store $ra
addi $t0, $0, 2
slt $t0, $a0, $t0 # a <= 1 ?
beq $t0, $0, else # no: go to else
addi $v0, $0, 1 # yes: return 1
addi $sp, $sp, 8 # restore $sp
jr $ra # return
else: addi $a0, $a0, -1 # n = n - 1
jal factorial # recursive call
lw $ra, 0($sp) # restore $ra
lw $a0, 4($sp) # restore $a0
addi $sp, $sp, 8 # restore $sp
mul $v0, $a0, $v0 # n * factorial(n-1)
jr $ra # return