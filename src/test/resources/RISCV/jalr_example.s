addi  sp,sp,-16
sd ra,8(sp)
sd s0,0(sp)
addi  s0,sp,16
mv a1,a0

auipc a0,0x0
addi  a0,a0,1998
auipc ra,0x0
jalr  1570(ra)

ld ra,8(sp)
ld s0,0(sp)
addi  sp,sp,16
ret

addi  sp,sp,-16
sd ra,8(sp)
sd s0,0(sp)
addi  s0,sp,16

li a0,3
auipc ra,0x0
jalr  -44(ra)

li a0,0
auipc ra,0x0
jalr  638(ra) # 2b4 <exit>

# https://xiayingp.gitbook.io/build_a_os/hardware-device-assembly/risc-v-assembly

# void g(int x) {
#   printf("%d", x);
# }

# void main(void) {
#   g(3);
#   exit(0);
# }


# void g(int x) {
#    0: 1141                 addi  sp,sp,-16
#    2: e406                 sd ra,8(sp)
#    4: e022                 sd s0,0(sp)
#    6: 0800                 addi  s0,sp,16
#    8: 85aa                 mv a1,a0
#   printf(“%d”, x)*;*
#    a: 00000517             auipc a0,0x0
#    e: 7ce50513             addi  a0,a0,1998*# 7d8 <malloc+0xe6>*
#   12: 00000097             auipc ra,0x0
#   16: 622080e7             jalr  1570(ra)*# 634 <printf>*
# }
#   1a: 60a2                 ld ra,8(sp)
#   1c: 6402                 ld s0,0(sp)
#   1e: 0141                 addi  sp,sp,16
#   20: 8082                 ret

# 0000000000000022 <main>:

# void main(void) {
#   22: 1141                 addi  sp,sp,-16
#   24: e406                 sd ra,8(sp)
#   26: e022                 sd s0,0(sp)
#   28: 0800                 addi  s0,sp,16
#   g(3)*;*
#   2a: 450d                 li a0,3
#   2c: 00000097             auipc ra,0x0
#   30: fd4080e7             jalr  -44(ra)*# 0 <g>*
#   exit(0)*;*
#   34: 4501                 li a0,0
#   36: 00000097             auipc ra,0x0
#   3a: 27e080e7             jalr  638(ra)*# 2b4 <exit>*