// http://lab.antlr.org/

parser grammar RISCVParser;

options {
	tokenVocab = RISCVLexer;
}

asm_file : ( newline* row )+ newline* EOF ;

newline:
    NEWLINE
    ;

row :
    comment
    |
    preprocessor_directive
    |
    asm_intrinsic_instruction
//    |
//    macro_usage
    |
    instruction_row
    ;

comment:
    LINE_COMMENT | DOUBLE_SLASH_LINE_COMMENT | BLOCK_COMMENT
    ;

instruction_row :
    label_definition? newline? instruction
    ;

instruction : mnemonic ( param ( COMMA param )? ( COMMA param )? )? ;

param : ( ( MINUS )? IDENTIFIER ( PLUS )? ) | offset_expression | expression | asm_intrinsic_usage | macro_placeholder | label_name;

//macro_usage : IDENTIFIER ( expression )* ;

label_definition : label_name COLON ;

label_name:
    (DOT)? IDENTIFIER
    ;

macro_placeholder : AT NUMBER ;

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
    DOT
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
    DOT (
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
    )
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
    |
    mnemonic_e
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
    |
    mnemonic_x
 */
    ;

mnemonic_a :
    ADD | ADDI
    ;

mnemonic_b :
    BGT
    ;

mnemonic_c :
    CALL
    ;
/*
mnemonic_d :
    DEC | DES
    ;

mnemonic_e :
    EICALL | EIJMP | ELPM | EOR
    ;

mnemonic_f :
    FMUL | FMULS | FMULSU
    ;

mnemonic_i :
    ICALL | IJMP | IN | INC
    ;
*/
mnemonic_j :
    J_ | JR
    ;

mnemonic_l :
    LI | LW
    ; 

mnemonic_m :
    MV
    ;
/*
mnemonic_n :
    NEG | NOP
    ;

mnemonic_o :
    OR | ORI | OUT
    ;

mnemonic_p :
    POP | PUSH
    ;

mnemonic_r :
    RCALL | RET | RETI | RJMP | ROL|  ROR
    ;
*/
mnemonic_s :
    SW
    ;
/*
mnemonic_t :
    TST
    ;

mnemonic_w :
    WDR
    ;

mnemonic_x :
    XCH
    ;
 */