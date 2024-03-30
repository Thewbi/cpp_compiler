// http://lab.antlr.org/

parser grammar RISCVParser;

options {
	tokenVocab = RISCVLexer;
}

asm_file : ( newline* row )+ newline* EOF ;

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
//    |
//    macro_usage
    |
    ( label_definition )? instruction_row ( comment )?
    |
    ( label_definition )? expression_list ( comment )? // example: NOTAS_PERDEU: 6,800,67,800,70,600,81,500,76,1000
    |
    label_definition ( comment )?
    |
    comment
    ;

expression_list :
    expression ( COMMA expression)*
    ;

comment:
    LINE_COMMENT | DOUBLE_SLASH_LINE_COMMENT | BLOCK_COMMENT
    ;

instruction_row :
    newline? instruction
    ;

instruction : mnemonic ( param ( COMMA param )? ( COMMA param )? )? ;

param : 
    // ( ( MINUS )? IDENTIFIER ( PLUS )? ) 
    // | 
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

//macro_usage : IDENTIFIER ( expression )* ;

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
    REG_a4
    |
    REG_a5
    ;

offset_expression
    :
    offset_expression_amount OPENING_BRACKET offset_expression_register CLOSEING_BRACKET
    ;

offset_expression_amount :
    MINUS? NUMBER
    ;

offset_expression_register :
    IDENTIFIER
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
 