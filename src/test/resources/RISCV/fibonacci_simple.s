
	.text


    addi    sp, sp, 1024
    j main


# [inout] parameter: index of fibonacci number to compute goes into a0
# [inout] return: value of computed fibonacci number for index is placed into a0
	.align	2
	.globl	fib
fib:
    # create stack frame
	addi	sp, sp, -32
    sw	    ra, 28(sp)
    sw	    s0, 24(sp)
	sw	    s1, 20(sp)
	addi	s0, sp, 32

	sw	    a0, -20(s0)      # move parameter to fib() into memory to make space for further recursive calls to fib()
	lw	    a4, -20(s0)      # parameter to temp register r4
    # check abort condition. fib
	li	    a5, 1
	bgt	    a4, a5, .L2     # fib(0) = 0, fib(1) = 1, fib(2) = fib(0) + fib(1) = 0 + 1 = 1, fib(3) = fib(1) + fib(2) = 1 + 1 = 2,
	lw	    a5, -20(s0)      # return value goes into a5
	j	    .L3             # go to 
.L2:
    # compute fibonacci number x-1
	lw	    a5,-20(s0)
	addi	a5,a5,-1
	mv	    a0,a5           # parameter of fib() goes into a0
	call	fib
	mv	    s1,a0

    # compute fibonacci number x-2
	lw	    a5, -20(s0)
	addi	a5, a5, -2        # parameter of fib() goes into a0
	mv	    a0, a5
	call	fib
	mv	    a5, a0

    # add fibonacci numbers to arrive at fibonacci number x = x-1 + x-2
	add	    a5, s1, a5
.L3:
    # move result (fibonacci number x) to a0 (= x10)
	mv	    a0, a5
	lw	    ra, 28(sp)

    # destroy stack frame
	lw	    s0, 24(sp)
	lw	    s1, 20(sp)
	addi	sp, sp, 32

    # return
	jr	    ra




	.align	2
	.globl	return_function
return_function:
    # create stack frame
	addi	sp, sp, -32
	sw	    s0, 28(sp)
	addi	s0, sp, 32

	sw	    a0, -20(s0)
	lw	    a5, -20(s0)
	mv	    a0, a5

    # destroy stack frame
	lw	    s0, 28(sp)
	addi	sp, sp, 32

    # return
	jr	    ra



	.align	2
	.globl	main
main:
    # create stack frame
	addi	sp, sp, -32       # stackframe is 32 byte = 7 word
	sw	    ra, 28(sp)
	sw	    s0, 24(sp)        # sw source destination # Save s0 content onto the stack
	addi	s0, sp, 32        # s0 contains the start of the stack frame

    # call fib(3)
    # parameter (index of fibonacci number to compute) goes into a0
	li	    a5, 3           # index 3, fib(3) = fib(1) + fib(2) = 1 + 1 = 2
	sw	    a5, -20(s0)
	lw	    a0, -20(s0)     # a0 holds the parameter to the fib() function
	call	fib

    # retrieve the return value
	mv	    a5, a0          # fib() returns the value in a0

    # call return (C programming language return)
	mv	    a0, a5
	call	return_function
	sw	    a0, -24(s0)
	lw	    a5, -24(s0)
	mv	    a0, a5
	lw	    ra, 28(sp)

    # destroy stack frame
	lw	    s0, 24(sp)
	addi	sp, sp, 32

    # return
	jr	    ra