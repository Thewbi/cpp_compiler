# RISC-V

int main() {
	
	int temp_array[3] = { 1, 2, 3 };
	
	temp_array[1] = 17;
	
	return 0;
}




; structure of a stackframe
; 
; fp (frame pointer) points to the beginning of the stack frame (higher address than stack pointer since the stack grows towards address 0)
; sp (stack pointer) points to the end       of the stack frame (lower  address than frame pointer since the stack grows towards address 0)
;
; ra (return address) needs to contain the return address to place into PC once the function ends and the stackframe is destroyed



sp, s0/fp'  [32] -
-------------------------------------------------------
			[28] - ra (saved)
			[24] - s0/fp (frame pointer) (old frame pointer)
			[20] - not_used
			[16] - not_used
			[12] - 3
			[ 8] - 2
			[ 4] - 1
sp'      	[ 0] - not_used




main:
		; create stack frame
        addi    sp,sp,-32           ; move stack pointer, make space for new stackframe (8 elements) 
                                    ; (I think GCC always builds stack frames with a multiple of 
                                    ; 16 byte sizes! Not all elements are used!)
        sw      ra,28(sp)           ; store address to return to (stored in ra) onto the stack 
                                    ; (SHOULD WE WANT TO CALL MORE FUNCTIONS WITHIN THE BODY OF 
                                    ; THIS FUNCTION)
        sw      s0,24(sp)           ; store old s0/fp (frame pointer) on the stack so it can be 
                                    ; restored later because it will be used within this function
        addi    s0,sp,32            ; set new s0/fp (frame pointer) to the start of our new stackframe. 
                                    ; Now offseting (with negative offsets) from new s0/fp grants 
                                    ; access to all elements of the new stack frame

        ; throughout the code, a5 is used as a temporary, working, scratch register
        ; a5 is caller saved, so we need not save it on the stack

        ; int temp_array[3] = { 1, 2, 3 };
        li      a5,1
        sw      a5,-28(s0)
        li      a5,2
        sw      a5,-24(s0)
        li      a5,3
        sw      a5,-20(s0)

        ; temp_array[1] = 17;
        li      a5,17
        sw      a5,-24(s0)

        ; prepare return value (here: 0)
        ; the return value goes into register a0 (and a1)
        li      a5,0
        mv      a0,a5

        ; delete stack frame (inverse operation to create stack frame)
        lw      ra,28(sp)           ; restore address to return to
        lw      s0,24(sp)           ; restore s0/fp (frame pointer)
        addi    sp,sp,32            ; remove stack pointer, return space for new stackframe, 8 elements

        ; return
        jr      ra                  ; jump to return address