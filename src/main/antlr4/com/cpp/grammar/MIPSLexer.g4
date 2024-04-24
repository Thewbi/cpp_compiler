lexer grammar MIPSLexer;

fragment A:[aA];
fragment B:[bB];
fragment C:[cC];
fragment D:[dD];
fragment E:[eE];
fragment F:[fF];
fragment G:[gG];
fragment H:[hH];
fragment I:[iI];
fragment J:[jJ];
fragment K:[kK];
fragment L:[lL];
fragment M:[mM];
fragment N:[nN];
fragment O:[oO];
fragment P:[pP];
fragment Q:[qQ];
fragment R:[rR];
fragment S:[sS];
fragment T:[tT];
fragment U:[uU];
fragment V:[vV];
fragment W:[wW];
fragment X:[xX];
fragment Y:[yY];
fragment Z:[zZ];

ADD : A D D ;
ADDU : A D D U ;
//ADDW : A D D W ;
ADDI : A D D I ;
//ADDIW : A D D I W ;
ADDIU : A D D I U ;
AND : A N D ;
ANDI : A N D I ;
//AUIPC : A U I P C ;
ADD_S : A D D '.' S ;
ADD_D : A D D '.' D ;
ABS_S : A B S '.' S ;
ABS_D : A B S '.' D ;

BLTZ : B L T Z ;
BGEZ : B G E Z ;
BEQ : B E Q ;
BNE : B N E ;
BLEZ : B L E Z ;
BGTZ : B G T Z ;
BCLF : B C L F ;
BCLT : B C L T ;
BREAK : B R E A K ;

// CALL : C A L L ;
// CSRW : C S R W ;
// CSRRW : C S R R W ;
// CSRRS : C S R R S ;
// CSRRC : C S R R C ;
// CSRRWI : C S R R W I ;
// CSRRSI : C S R R S I ;
// CSRRCI : C S R R C I ;
// CSRSI : C S R S I ;
C_SEQ_S : C '.' S E Q '.' S ;
C_SEQ_D : C '.' S E Q '.' D ;
C_LT_S : C '.' L T '.' S ;
C_LT_D : C '.' L T '.' D ;
C_LE_S : C '.' L E '.' S ;
C_LE_D : C '.' L E '.' D ;

DIV : D I V ;
DIVU : D I V U ;
// DIVW : D I V W ;
// DIVUW : D I V U W ;
DIV_S : D I V '.' S ;
DIV_D : D I V '.' D ;

// ECALL : E C A L L ;
// EBREAK : E B R E A K ;

// FENCE : F E N C E ;
// FENCE_I : F E N C E '.' I ;

J_ : J ;
JAL : J A L ;
JALR : J A L R ;
JR : J R ;

//LA : L A ;
LB : L B ;
//LD : L D ;
//LI : L I ;
LH : L H ;
LW : L W ;
//LUI : L U I ;
LBU : L B U ;
LHU : L H U ;
//LWU : L W U ;
LWCL : L W C L ;

//MV : M V ;
MUL : M U L ;
// MULH : M U L H ;
// MULHSU : M U L H S U ;
// MULHU : M U L H U ;
MFCO : M F C O ;
MFHI : M F H I ;
MTHI : M T H I ;
MFLO : M F L O ;
MTLO : M T L O ;
MULT : M U L T ;
MULTU : M U L T U ;
MUL_S : M U L '.' S ;
MUL_D : M U L '.' D ;

NOR : N O R;
NEG_S : N E G '.' S ;
NEG_D : N E G '.' D ;

OR : O R ;
ORI : O R I ;

//RET : R E T ;

SB : S B ;
// SD : S D ;
SH : S H ;
SW : S W ;
SWCL : S W C L ;
// SLLI : S L L I ;
// SLLIW : S L L I W ;
SRL : S R L ;
// SRLW : S R L W ;
// SRLI : S R L I ;
// SRLIW : S R L I W ;
SRA : S R A ;
SRAV : S R A V ;
// SRAW : S R A W ;
// SRAI : S R A I ;
// SRAIW : S R A I W ;
SUB : S U B ;
SUBU : S U B U ;
// SUBW : S U B W ;
SLT : S L T ;
SLTU : S L T U ;
SLTI : S L T I ;
SLTIU : S L T I U ;
SLL : S L L ;
// SLLW : S L L W ;
SLLV : S L L V ;
SRLV : S R L V ;
SYSCALL : S Y S C A L L ;
SUB_S : S U B '.' S ;
SUB_D : S U B '.' D ;

XOR : X O R ;
XORI : X O R I ;

// zero, the constant value zero - index 0
REG_0 : '$0' ;

// assembler temporary - index 1
REG_at : 'at' ;
REG_1 : '$1' ;

// function return value - index 2
REG_v0 : '$v0' ;
REG_2 : '$2' ;

// function return value - index 3
REG_v1 : '$v1' ;
REG_3 : '$3' ;

// function arguments - index 4
REG_a0 : '$a0' ;
REG_4 : '$4' ;

// function arguments - index 5
REG_a1 : '$a1' ;
REG_5 : '$5' ;

// function arguments - index 6
REG_a2 : '$a2' ;
REG_6 : '$6' ;

// function arguments - index 7
REG_a3 : '$a3' ;
REG_7 : '$7' ;

// temporary variables - index 8
REG_t0 : '$t0' ;
REG_8 : '$8' ;

// temporary variables - index 9
REG_t1 : '$t1' ;
REG_9 : '$9' ;

// temporary variables - index 10
REG_t2 : '$t2' ;
REG_10 : '$10' ;

// temporary variables - index 11
REG_t3 : '$t3' ;
REG_11 : '$11' ;

// temporary variables - index 12
REG_t4 : '$t4' ;
REG_12 : '$12' ;

// temporary variables - index 13
REG_t5 : '$t5' ;
REG_13 : '$13' ;

// temporary variables - index 14
REG_t6 : '$t6' ;
REG_14 : '$14' ;

// temporary variables - index 15
REG_t7 : '$t7' ;
REG_15 : '$15' ;

// saved variables - index 16
REG_s0 : '$s0' ;
REG_16 : '$16' ;

// saved variables - index 17
REG_s1 : '$s1' ;
REG_17 : '$17' ;

// saved variables - index 18
REG_s2 : '$s2' ;
REG_18 : '$18' ;

// saved variables - index 19
REG_s3 : '$s3' ;
REG_19 : '$19' ;

// saved variables - index 20
REG_s4 : '$s4' ;
REG_20 : '$20' ;

// saved variables - index 21
REG_s5 : '$s5' ;
REG_21 : '$21' ;

// saved variables - index 22
REG_s6 : '$s6' ;
REG_22 : '$22' ;

// saved variables - index 23
REG_s7 : '$s7' ;
REG_23 : '$23' ;

// temporary variables - index 24
REG_t8 : '$t8' ;
REG_24 : '$24' ;

// temporary variables - index 25
REG_t9 : '$t9' ;
REG_25 : '$25' ;

// operating system (OS) temporary variables - index 26
REG_k0 : '$k0' ;
REG_26 : '$26' ;

// operating system (OS) temporary variables - index 27
REG_k1 : '$k1' ;
REG_27 : '$27' ;

// global pointer - index 28
REG_gp : '$gp' ;
REG_28 : '$28' ;

// global pointer - index 29
REG_sp : '$sp' ;
REG_29 : '$29' ;

// global pointer - index 30
REG_fp : '$fp' ;
REG_30 : '$30' ;

// global pointer - index 31
REG_ra : '$ra' ;
REG_31 : '$31' ;





// ALIGN : '.align' ;
// ASTERISK : '*' ;
// AT : '@' ;

CLOSEING_BRACKET : ')' ;
COLON : ':' ;
COMMA : ',' ;
// CSEG : '.cseg' ;

// DATA : '.data' ;
// DEF : '.def' ;
// DEVICE : '.device' ;
DOT : '.' ;

// ELSE : '.else' ;
// END_MACRO : '.endmacro' ;
// ENDIF : '.endif' ;
EQUALS : '=' ;
// EQU : '.equ';
// ERROR : '.error' ;

// FILE : '.file' ;
// FUNCTION : 'function' ;

// GLOBL : '.globl' ;
GT : '>' ;

// HASH_TAG : '#' ;

// IDENT : '.ident' ;
// IF : '.if' ;
// INCLUDE : '.include' ;

LEFT_SHIFT : '<<' ;
LT : '<' ;

// MACRO : '.macro' ;
MINUS : '-' ;

// NOPIC : 'nopic' ;

OPENING_BRACKET : '(' ;
// OPTION : '.option' ;
// ORG : '.org' ;

PLUS : '+' ;

RIGHT_SHIFT : '>>' ;
// REM : R E M ;
// REMW : R E M W ;
// REMU : R E M U ;
// REMUW : R E M U W ;

// SIZE : '.size' ;
SLASH : '/' ;
// SPACE : '.space' ;
// STRING_KEYWORD : '.string' ;

// TEXT : '.text' ;
// TYPE : '.type' ;

// WORD : '.word' ;

// MULW : M U L W ;

NEWLINE : '\r'? '\n' ;

//WS : [ \t\n\r\f]+ -> skip ;
WS : 
    [ \t\f]+ -> skip 
    ;

LINE_COMMENT 
    : 
    ( ';' | '#' ) ~[\r\n]* // -> skip 
    ;

BLOCK_COMMENT : 
    '/*' ( BLOCK_COMMENT | . )*? '*/' //-> channel(HIDDEN) 
    ;

DOUBLE_SLASH_LINE_COMMENT : 
    '//' .*? '\n' //-> channel(HIDDEN) 
    ;

STRING : '"' ('""'|~'"')* '"' ;

NUMBER : [0-9]+ ;
HEX_NUMBER : ('0' 'x' | '$') [a-fA-F0-9]+ ;
BINARY_NUMBER : '0' 'b' [0,1]+ ;

IDENTIFIER : (DOT | [a-zA-Z_])([a-zA-Z0-9_])* ;
