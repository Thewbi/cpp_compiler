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

REG_a4 : 'a4' ;
REG_a5 : 'a5' ;

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
