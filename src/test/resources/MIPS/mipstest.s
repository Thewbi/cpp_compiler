# riscvtest.asm
# Sarah.Harris@unlv.edu
# David_Harris@hmc.edu
# 5 April 2020
# Adapted from mipstest.asm
#
# Test the MIPS processor.  
# add, sub, and, or, slt, addi, lw, sw, beq, jal
# If successful, it should write the value 71 to address 84

#       RISC-V Assembly         Description             Address           Machine Code
main:   addi $2, $0, 5          # initialize $2 = 5     0                 20020005   
        addi $3, $0, 12         # initialize $3 = 12    4                 2003000c
        addi $7, $3, -9         # initialize $7 = 3     8                 2067fff7
        or   $4, $7, $2         # $4 = (3 OR 5) = 7     C                 00e22025
        and  $5, $3, $4         # $5 = (12 AND 7) = 4   10                
        add  $5, $5, $4         # $5 = 4 + 7 = 11       14                
        beq  $5, $7, end        # shouldn't be taken    18                
        slt  $4, $3, $4         # $4 = (12 < 7) = 0     1C                
        beq  $4, $0, around     # should be taken       20                
        addi $5, $0, 0          # shouldn't happen      24                
around: slt  $4, $7, $2         # $4 = (3 < 5) = 1      28                
        add  $7, $4, $5         # $7 = 1 + 11 = 12      2C                
        sub  $7, $7, $2         # $7 = 12 - 5 = 7       30                
//        sw   $7, 68($3)         # [80] = 7              34                
        lw   $2, 80($0)         # $2 = [80] = 7         38                
        j    end                # jump to end, $3 = 64  3C                
        addi $2, $0, 1          # shouldn't happen      40                
end:    sw   $2, 84($0)         # write mem[84] = 71    44                