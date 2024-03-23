lexer grammar PreprocessorLexer;

// https://stackoverflow.com/questions/31255856/simple-antlr-preprocessor

//PStart : ('\r'? '\n') '#' -> channel(HIDDEN), pushMode(PreProc) ;
//PStart : [ \t\r\n]+ '#' -> channel(HIDDEN), pushMode(PreProc) ;

NEWLINE : '\r'? '\n';

//TEXT : ~[\u000C]+ ;
//TEXT : 'print';
//TEXT : ~[#]+ ;
TEXT : ~[\r\n];

PIFDEFStart : [ ]* '#ifdef' -> pushMode(PreProcIFDEF) ;
PELSEStart : [ ]* '#else' -> pushMode(PreProcELSE) ;
PENDIFStart : [ ]* '#endif' -> pushMode(PreProcENDIF) ;
PINCLUDEStart : [ ]* '#include' -> pushMode(PreProcINCLUDE) ;




mode PreProcINCLUDE ;

PINCLUDEPTEXT   : [a-zA-Z0-9_-]+ ;
PINCLUDEPEOL   : '\r'? '\n'    -> popMode ;
PINCLUDEPWS    : [ \t]+        -> channel(HIDDEN) ;
PINCLUDEPCMT   : '//' ~[\r\n]* -> channel(HIDDEN) ;




mode PreProcIFDEF ;

//PIFDEF : 'IFDEF' ;
//PELSE  : 'ELSE'  ;
//PENDIF : 'ENDIF' ;
PIFDEFPTEXT  : [a-zA-Z0-9_-]+ ;
PIFDEFPEOL   : '\r'? '\n'    -> popMode ;
PIFDEFPWS    : [ \t]+        -> channel(HIDDEN) ;
PIFDEFPCMT   : '//' ~[\r\n]* -> channel(HIDDEN) ;



mode PreProcELSE ;

//PIFDEF : 'IFDEF' ;
//PELSE  : 'ELSE'  ;
//PENDIF : 'ENDIF' ;
//PELSEPTEXT  : [a-zA-Z0-9_-]+ ;
PELSEPEOL   : '\r'? '\n'    -> popMode ;
PELSEPWS    : [ \t]+        -> channel(HIDDEN) ;
PELSEPCMT   : '//' ~[\r\n]* -> channel(HIDDEN) ;


mode PreProcENDIF ;

//PIFDEF : 'IFDEF' ;
//PELSE  : 'ELSE'  ;
//PENDIF : 'ENDIF' ;
//PENDIFPTEXT  : [a-zA-Z0-9_-]+ ;
PENDIFPEOL   : '\r'? '\n'    -> popMode ;
PENDIFPWS    : [ \t]+        -> channel(HIDDEN) ;
PENDIFPCMT   : '//' ~[\r\n]* -> channel(HIDDEN) ;