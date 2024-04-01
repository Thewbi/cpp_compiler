// http://lab.antlr.org/

parser grammar RISCVParser;

options {
	tokenVocab = RISCVLexer;
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
    preprocessor_directive ( comment )?    
    |
    ( label_definition )? asm_intrinsic_instruction ( comment )?
    |
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
    asm_intrinsic_usage 
    | 
    macro_placeholder 
    | 
    expression 
    ;

label_name :
    IDENTIFIER
    ;

macro_placeholder : 
    AT NUMBER 
    ;

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
    |
    macro_placeholder
    |
    register
    |
    DOT
    ;

register :
    REG_x0 |
    REG_zero |

    // return address
    REG_x1 |
    REG_ra |

    // stack pointer
    REG_x2 |
    REG_sp |

    // global pointer
    REG_x3 |
    REG_gp |

    // thread pointer
    REG_x4 |
    REG_tp |

    // temporary register 0
    REG_x5 |
    REG_t0 |

    // temporary register 1
    REG_x6 |
    REG_t1 |

    // temporary register 2
    REG_x7 |
    REG_t2 |

    // saved register 0 / frame pointer
    REG_x8 |
    REG_s0 |
    REG_fp |

    // saved register 1
    REG_x9 |
    REG_s1 |

    // function argument 0 / return value 0
    REG_x10 |
    REG_a0 |

    // function argument 1 / return value 1
    REG_x11 |
    REG_a1 |

    // function argument 2
    REG_x12 |
    REG_a2 |

    // function argument 3
    REG_x13 |
    REG_a3 |

    // function argument 4
    REG_x14 |
    REG_a4 |

    // function argument 5
    REG_x15 |
    REG_a5 |

    // function argument 6
    REG_x16 |
    REG_a6 |

    // function argument 7
    REG_x17 |
    REG_a7 |

    // saved register 2
    REG_x18 |
    REG_s2 |

    // saved register 3
    REG_x19 |
    REG_s3 |

    // saved register 4
    REG_x20 |
    REG_s4 |

    // saved register 5
    REG_x21 |
    REG_s5 |

    // saved register 6
    REG_x22 |
    REG_s6 |

    // saved register 7
    REG_x23 |
    REG_s7 |

    // saved register 8
    REG_x24 |
    REG_s8 |

    // saved register 9
    REG_x25 |
    REG_s9 |

    // saved register 10
    REG_x26 |
    REG_s10 |

    // saved register 11
    REG_x27 |
    REG_s11 |

    // temporary register 3
    REG_x28 |
    REG_t3 |

    // temporary register 4
    REG_x29 |
    REG_t4 |

    // temporary register 5
    REG_x30 |
    REG_t5 |

    // temporary register 6
    REG_x31 |
    REG_t6
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

asm_intrinsic_instruction :
    INCLUDE STRING
    |
    DEVICE IDENTIFIER
    |
    DEF expression
    |
    EQU expression
    | 
    CSEG 
    |
    ORG ( HEX_NUMBER | IDENTIFIER )
    | 
    MACRO IDENTIFIER
    | 
    END_MACRO
    | 
    IF expression
    | 
    ELSE
    | 
    ENDIF
    | 
    ERROR STRING
    |
    FILE STRING
    |
    TEXT
    |
    IDENT STRING
    |
    SIZE expression COMMA expression
    |
    ALIGN NUMBER
    |
    GLOBL IDENTIFIER
    |
    TYPE ( IDENTIFIER COMMA entity_type )
    |
    OPTION ( NOPIC )
    |
    DATA
    |
    WORD expression
    |
    SPACE expression
    |
    STRING_KEYWORD STRING
    ;

entity_type :
    AT (
        FUNCTION
    )
    ;

asm_intrinsic_usage :
    IDENTIFIER OPENING_BRACKET ( IDENTIFIER | macro_placeholder ) CLOSEING_BRACKET
    ;

preprocessor_directive : 
    HASH_TAG ( IF | ENDIF | IDENTIFIER | HEX_NUMBER | BINARY_NUMBER | NUMBER )+
    ;

mnemonic :
    mnemonic_a
    |
    mnemonic_b
    |
    mnemonic_c
 /*   
    |
    mnemonic_d
*/
    |
    mnemonic_e
/*
    |
    mnemonic_f
    |
    mnemonic_i
*/
    |
    mnemonic_j
    |
    mnemonic_l
    |
    mnemonic_m
/*
    |
    mnemonic_n
    |
    mnemonic_o
    |
    mnemonic_p
*/
    |
    mnemonic_r
    |
    mnemonic_s
/*
    |
    mnemonic_t
    |
    mnemonic_w
    |
    mnemonic_x
 */
    ;

mnemonic_a :
    ADD | ADDW | ADDI | ADDIW | AND | ANDI | AUIPC
    ;

mnemonic_b :
    BEQ | BNE | BLT | BGE | BGT | BLT | BLTU | BGEU
    ;

mnemonic_c :
    CALL | CSRW | CSRRW | CSRRS | CSRRC | CSRRWI | CSRRSI | CSRRCI | CSRSI
    ;

mnemonic_d :
    DIV | DIVU | DIVW | DIVUW
    ;

mnemonic_e :
    ECALL | EBREAK
    ;

mnemonic_f :
    FENCE | FENCE_I
    ;
/*
mnemonic_i :
    ICALL | IJMP | IN | INC
    ;
*/
mnemonic_j :
    J_ | JAL | JALR | JR
    ;

mnemonic_l :
    LA | LB | LD | LI | LH | LW | LUI | LBU | LHU | LWU
    ; 

mnemonic_m :
    MV | MUL | MULH | MULHSU | MULHU
    ;
/*
mnemonic_n :
    NEG | NOP
    ;
*/
mnemonic_o :
    OR | ORI
    ;
/*
mnemonic_p :
    POP | PUSH
    ;
*/
mnemonic_r :
    RET
    ;

mnemonic_s :
    SB |
    SD |
    SH |
    SW |
    SLLI |
    SLLIW |
    SRL |
    SRLW |
    SRLI |
    SRLIW |
    SRA |
    SRAW |
    SRAI |
    SRAIW |
    SUB |
    SUBW |
    SLT |
    SLTU |
    SLTI |
    SLTIU |
    SLL |
    SLLW
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
 