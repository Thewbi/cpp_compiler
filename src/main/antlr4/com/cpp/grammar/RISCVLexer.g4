lexer grammar RISCVLexer;

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
ADDW : A D D W ;
ADDI : A D D I ;
ADDIW : A D D I W ;
AND : A N D ;
ANDI : A N D I ;
AUIPC : A U I P C ;

BEQ : B E Q ;
BNE : B N E ;
BLT : B L T ;
BGE : B G E ;
BGT : B G T ; // pseudo instruction
BLTU : B L T U ;
BGEU : B G E U ;

CALL : C A L L ;
CSRW : C S R W ;
CSRRW : C S R R W ;
CSRRS : C S R R S ;
CSRRC : C S R R C ;
CSRRWI : C S R R W I ;
CSRRSI : C S R R S I ;
CSRRCI : C S R R C I ;
CSRSI : C S R S I ;

DIV : D I V ;
DIVU : D I V U ;
DIVW : D I V W ;
DIVUW : D I V U W ;

ECALL : E C A L L ;
EBREAK : E B R E A K ;

FENCE : F E N C E ;
FENCE_I : F E N C E '.' I ;

J_ : J ;
JAL : J A L ;
JALR : J A L R ;
JR : J R ;

LA : L A ;
LB : L B ;
LD : L D ;
LI : L I ;
LH : L H ;
LW : L W ;
LUI : L U I ;
LBU : L B U ;
LHU : L H U ;
LWU : L W U ;

MV : M V ;
MUL : M U L ;
MULH : M U L H ;
MULHSU : M U L H S U ;
MULHU : M U L H U ;

OR : O R ;
ORI : O R I ;

RET : R E T ;

SB : S B ;
SD : S D ;
SH : S H ;
SW : S W ;
SLLI : S L L I ;
SLLIW : S L L I W ;
SRL : S R L ;
SRLW : S R L W ;
SRLI : S R L I ;
SRLIW : S R L I W ;
SRA : S R A ;
SRAW : S R A W ;
SRAI : S R A I ;
SRAIW : S R A I W ;
SUB : S U B ;
SUBW : S U B W ;
SLT : S L T ;
SLTU : S L T U ;
SLTI : S L T I ;
SLTIU : S L T I U ;
SLL : S L L ;
SLLW : S L L W ;

XOR : X O R ;
XORI : X O R I ;

// zero - index 0
REG_x0 : 'x0' ;
REG_zero : 'zero' ;

// return address - index 1
REG_x1 : 'x1' ;
REG_ra : 'ra' ;

// stack pointer - index 2
REG_x2 : 'x2' ;
REG_sp : 'sp' ;

// global pointer - index 3
REG_x3 : 'x3' ;
REG_gp : 'gp' ;

// thread pointer - index 4
REG_x4 : 'x4' ;
REG_tp : 'tp' ;

// temporary register 0 - index 5
REG_x5 : 'x5' ;
REG_t0 : 't0' ;

// temporary register 1
REG_x6 : 'x6' ;
REG_t1 : 't1' ;

// temporary register 2
REG_x7 : 'x7' ;
REG_t2 : 't2' ;

// saved register 0 / frame pointer
REG_x8 : 'x8' ;
REG_s0 : 's0' ;
REG_fp : 'fp' ;

// saved register 1
REG_x9 : 'x9' ;
REG_s1 : 's1' ;

// function argument 0 / return value 0
REG_x10 : 'x10' ;
REG_a0 : 'a0' ;

// function argument 1 / return value 1
REG_x11 : 'x11' ;
REG_a1 : 'a1' ;

// function argument 2
REG_x12 : 'x12' ;
REG_a2 : 'a2' ;

// function argument 3
REG_x13 : 'x13' ;
REG_a3 : 'a3' ;

// function argument 4
REG_x14 : 'x14' ;
REG_a4 : 'a4' ;

// function argument 5
REG_x15	: 'x15' ;
REG_a5 : 'a5' ;

// function argument 6
REG_x16	: 'x16' ;
REG_a6 : 'a6' ;

// function argument 7
REG_x17	: 'x17' ;
REG_a7 : 'a7' ;

// saved register 2
REG_x18	: 'x18' ;
REG_s2 : 's2' ;

// saved register 3
REG_x19	: 'x19' ;
REG_s3 : 's3' ;	

// saved register 4
REG_x20	: 'x20' ;
REG_s4 : 's4' ;

// saved register 5
REG_x21	: 'x21' ;
REG_s5 : 's5' ;

// saved register 6
REG_x22	: 'x22' ;
REG_s6 : 's6' ;

// saved register 7
REG_x23	: 'x23' ;
REG_s7 : 's7' ;

// saved register 8
REG_x24	: 'x24' ;
REG_s8 : 's8' ;

// saved register 9
REG_x25	: 'x25' ;
REG_s9 : 's9' ;

// saved register 10
REG_x26	: 'x26' ;
REG_s10	: 's10' ;

// saved register 11
REG_x27	: 'x27' ;
REG_s11	: 's11' ;

// temporary register 3
REG_x28	: 'x28' ;
REG_t3 : 't3' ;

// temporary register 4
REG_x29	: 'x29' ;
REG_t4 : 't4' ;

// temporary register 5
REG_x30	: 'x30' ;
REG_t5 : 't5' ;

// temporary register 6
REG_x31	: 'x31' ;
REG_t6 : 't6' ;





ALIGN : '.align' ;
ASTERISK : '*' ;
AT : '@' ;

CLOSEING_BRACKET : ')' ;
COLON : ':' ;
COMMA : ',' ;
CSEG : '.cseg' ;

DATA : '.data' ;
DEF : '.def' ;
DEVICE : '.device' ;
DOT : '.' ;

ELSE : '.else' ;
END_MACRO : '.endmacro' ;
ENDIF : '.endif' ;
EQUALS : '=' ;
EQU : '.equ';
ERROR : '.error' ;

FILE : '.file' ;
FUNCTION : 'function' ;

GLOBL : '.globl' ;
GT : '>' ;

HASH_TAG : '#' ;

IDENT : '.ident' ;
IF : '.if' ;
INCLUDE : '.include' ;

LEFT_SHIFT : '<<' ;
LT : '<' ;

MACRO : '.macro' ;
MINUS : '-' ;

NOPIC : 'nopic' ;

OPENING_BRACKET : '(' ;
OPTION : '.option' ;
ORG : '.org' ;

PLUS : '+' ;

RIGHT_SHIFT : '>>' ;
REM : R E M ;
REMW : R E M W ;
REMU : R E M U ;
REMUW : R E M U W ;

SIZE : '.size' ;
SLASH : '/' ;
SPACE : '.space' ;
STRING_KEYWORD : '.string' ;

TEXT : '.text' ;
TYPE : '.type' ;

WORD : '.word' ;

MULW : M U L W ;

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
