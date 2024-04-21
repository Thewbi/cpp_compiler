// http://lab.antlr.org/

parser grammar MIPSParser;

options {
	tokenVocab = MIPSLexer;
}

asm_file : 
    ( newline* row )+ newline* EOF 
    ;

newline:
    NEWLINE
    ;

label_definition : 
    label_name COLON 
    ;

row :
//    preprocessor_directive ( comment )?    
//    |
    // ( label_definition )? asm_intrinsic_instruction ( comment )?
    // |
    ( label_definition )? instruction_row ( comment )?
    |
    ( label_definition )? const_list ( comment )? // example: NOTAS_PERDEU: 6,800,67,800,70,600,81,500,76,1000
    |
    label_definition ( comment )?
    |
    comment
    ;

const_list :
    NUMBER ( COMMA NUMBER )*
    ;

comment:
    LINE_COMMENT | DOUBLE_SLASH_LINE_COMMENT | BLOCK_COMMENT
    ;

instruction_row :
    newline? instruction
    ;

instruction : 
    mnemonic ( param ( COMMA param )? ( COMMA param )? )? 
    ;

param : 
    register
    |
    offset_expression
    | 
    label_name
    | 
    // asm_intrinsic_usage 
    // | 
    // macro_placeholder 
    // | 
    expression 
    ;

label_name :
    IDENTIFIER
    ;

// macro_placeholder : 
//     AT NUMBER 
//     ;

expression : 
    OPENING_BRACKET expression CLOSEING_BRACKET
    |
    expression LEFT_SHIFT expression
    |
    expression RIGHT_SHIFT expression
    |
    expression SLASH expression
    |
    expression GT expression
    |
    expression LT expression
    |
    expression EQUALS expression
    |
    expression MINUS expression
    |
    expression PLUS expression
    |
    PLUS expression
    |
    MINUS expression
    |
    BINARY_NUMBER
    |
    HEX_NUMBER
    | 
    NUMBER
    |
    IDENTIFIER
    |
    STRING
    // |
    // macro_placeholder
    |
    register
    |
    DOT
    ;

register :
    // zero, the constant value zero - index 0
    REG_x0 |

    // assembler temporary - index 1
    REG_at |

    // function return value - index 2
    REG_v0 |

    // function return value - index 3
    REG_v1 |

    // function arguments - index 4
    REG_a0 |

    // function arguments - index 5
    REG_a1 |

    // function arguments - index 6
    REG_a2 |

    // function arguments - index 7
    REG_a3 |

    // temporary variables - index 8
    REG_t0 |

    // temporary variables - index 9
    REG_t1 |

    // temporary variables - index 10
    REG_t2 |

    // temporary variables - index 11
    REG_t3 |

    // temporary variables - index 12
    REG_t4 |

    // temporary variables - index 13
    REG_t5 |

    // temporary variables - index 14
    REG_t6 |

    // temporary variables - index 15
    REG_t7 |

    // saved variables - index 16
    REG_s0 |

    // saved variables - index 17
    REG_s1 |

    // saved variables - index 18
    REG_s2 |

    // saved variables - index 19
    REG_s3 |

    // saved variables - index 20
    REG_s4 |

    // saved variables - index 21
    REG_s5 |

    // saved variables - index 22
    REG_s6 |

    // saved variables - index 23
    REG_s7 |

    // temporary variables - index 24
    REG_t8 |

    // temporary variables - index 25
    REG_t9 |

    // operating system (OS) temporary variables - index 26
    REG_k0 |

    // operating system (OS) temporary variables - index 27
    REG_k1 |

    // global pointer - index 28
    REG_gp |

    // global pointer - index 29
    REG_sp |

    // global pointer - index 30
    REG_fp |

    // global pointer - index 31
    REG_ra
    ;

offset_expression
    :
    offset_expression_amount OPENING_BRACKET offset_expression_register CLOSEING_BRACKET
    ;

offset_expression_amount :
    MINUS? NUMBER
    ;

offset_expression_register :
    register
    ;

// asm_intrinsic_instruction :
//     INCLUDE STRING
//     |
//     DEVICE IDENTIFIER
//     |
//     DEF expression
//     |
//     EQU expression
//     | 
//     CSEG 
//     |
//     ORG ( HEX_NUMBER | IDENTIFIER )
//     | 
//     MACRO IDENTIFIER
//     | 
//     END_MACRO
//     | 
//     IF expression
//     | 
//     ELSE
//     | 
//     ENDIF
//     | 
//     ERROR STRING
//     |
//     FILE STRING
//     |
//     TEXT
//     |
//     IDENT STRING
//     |
//     SIZE expression COMMA expression
//     |
//     ALIGN NUMBER
//     |
//     GLOBL IDENTIFIER
//     |
//     TYPE ( IDENTIFIER COMMA entity_type )
//     |
//     OPTION ( NOPIC )
//     |
//     DATA
//     |
//     WORD expression
//     |
//     SPACE expression
//     |
//     STRING_KEYWORD STRING
//     ;

// entity_type :
//     AT (
//         FUNCTION
//     )
//     ;

// asm_intrinsic_usage :
//     IDENTIFIER OPENING_BRACKET ( IDENTIFIER | macro_placeholder ) CLOSEING_BRACKET
//     ;

// preprocessor_directive : 
//     HASH_TAG ( IF | ENDIF | IDENTIFIER | HEX_NUMBER | BINARY_NUMBER | NUMBER )+
//     ;

mnemonic :
    mnemonic_a
    |
    mnemonic_b
    |
    mnemonic_c
    |
    mnemonic_d
/*
    |
    mnemonic_e
    |
    mnemonic_f
    |
    mnemonic_g
    |
    mnemonic_h
    |
    mnemonic_i
*/
    |
    mnemonic_j
    |
    mnemonic_l
    |
    mnemonic_m
    |
    mnemonic_n
    |
    mnemonic_o
/*
    |
    mnemonic_p
    |
    mnemonic_r
*/
    |
    mnemonic_s
/*
    |
    mnemonic_t
    |
    mnemonic_w
*/
    |
    mnemonic_x 
    ;

mnemonic_a :
    ADD | ADDU | ADDI | ADDIU | AND | ANDI | ADD_S | ADD_D | ABS_S | ABS_D
    ;

mnemonic_b :
    BLTZ | BGEZ | BEQ | BNE | BLEZ | BGTZ | BCLF | BCLT | BREAK
    ;

mnemonic_c :
    C_SEQ_S | C_SEQ_D | C_LT_S | C_LT_D | C_LE_S | C_LE_D
    ;

mnemonic_d :
    DIV | DIVU | DIV_S | DIV_D
    ;

// mnemonic_e :
//     ECALL | EBREAK
//     ;

// mnemonic_f :
//     FENCE | FENCE_I
//    ;
/*
mnemonic_i :
    ICALL | IJMP | IN | INC
    ;
*/
mnemonic_j :
    J_ | JAL | JALR | JR
    ;

mnemonic_l :
    LB | LH | LW | LBU | LHU | LWCL
    ; 

mnemonic_m :
    MUL | MFCO | MFHI | MTHI | MFLO | MTLO | MULT | MULTU | MUL_S | MUL_D
    ;

mnemonic_n :
    NOR | NEG_S | NEG_D
    ;

mnemonic_o :
    OR | ORI
    ;
/*
mnemonic_p :
    POP | PUSH
    ;
*/
// mnemonic_r :
//     RET
//     ;

mnemonic_s :
    SB |
    SH |
    SW |
    SWCL |
    SRL |
    SRA |
    SRAV |
    SUB |
    SUBU |
    SLT |
    SLTU |
    SLTI |
    SLTIU |
    SLL |
    SLLV |
    SLRV |
    SYSCALL |
    SUB_S |
    SUB_D
    ;
/*
mnemonic_t :
    TST
    ;

mnemonic_w :
    WDR
    ;
*/
mnemonic_x :
    XOR | XORI
    ;
 