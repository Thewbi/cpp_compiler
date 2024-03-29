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
ADDI : A D D I ;

BGT : B G T ;

CALL : C A L L ;

J_ : J ;
JR : J R ;

LI : L I ;
LW : L W ;

MV : M V ;

SW : S W ;

ALIGN : 'align' ;
ASTERISK : '*' ;
AT : '@' ;

CLOSEING_BRACKET : ')' ;
COLON : ':' ;
COMMA : ',' ;
CSEG : 'cseg' ;

DEF : 'def' ;
DEVICE : 'device' ;
DOT : '.' ;

ELSE : 'else' ;
END_MACRO : 'endmacro' ;
ENDIF : 'endif' ;
EQUALS : '=' ;
EQU : E Q U ;
ERROR : 'error' ;

FILE : 'file' ;
FUNCTION : 'function' ;

GLOBL : 'globl' ;
GT : '>' ;

HASH_TAG : '#' ;

IDENT : 'ident' ;
IF : 'if' ;
INCLUDE : 'include' ;

LEFT_SHIFT : '<<' ;
LT : '<' ;

MACRO : 'macro' ;
MINUS : '-' ;

NOPIC : 'nopic' ;

OPENING_BRACKET : '(' ;
OPTION : 'option' ;
ORG : 'org' ;

PLUS : '+' ;

RIGHT_SHIFT : '>>' ;

SIZE : 'size' ;
SLASH : '/' ;

TEXT : 'text' ;
TYPE : 'type' ;

NEWLINE : '\r'? '\n' ;

//WS : [ \t\n\r\f]+ -> skip ;
WS : 
    [ \t\f]+ -> skip 
    ;

LINE_COMMENT 
    : 
    ';' ~[\r\n]* // -> skip 
    ;

BLOCK_COMMENT : 
    '/*' (BLOCK_COMMENT|.)*? '*/' //-> channel(HIDDEN) 
    ;

DOUBLE_SLASH_LINE_COMMENT : 
    '//' .*? '\n' //-> channel(HIDDEN) 
    ;

STRING : '"' ('""'|~'"')* '"' ;

NUMBER : [0-9]+ ;
HEX_NUMBER : ('0' 'x' | '$') [a-fA-F0-9]+ ;
BINARY_NUMBER : '0' 'b' [0,1]+ ;

IDENTIFIER : [a-zA-Z_]([a-zA-Z0-9_])* ;