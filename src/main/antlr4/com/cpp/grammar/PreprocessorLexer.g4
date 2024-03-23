lexer grammar PreprocessorLexer;

// https://stackoverflow.com/questions/31255856/simple-antlr-preprocessor

//PStart : ('\r'? '\n') '#' -> channel(HIDDEN), pushMode(PreProc) ;
//PStart : [ \t\r\n]+ '#' -> channel(HIDDEN), pushMode(PreProc) ;

PIFDEFStart : '#IFDEF' -> pushMode(PreProcIFDEF) ;
PELSEStart : '#ELSE' -> pushMode(PreProcELSE) ;
PENDIFStart : '#ENDIF' -> pushMode(PreProcENDIF) ;

NEWLINE : '\r'? '\n';

//TEXT : ~[\u000C]+ ;
//TEXT : 'print';
//TEXT : ~[#]+ ;
TEXT : ~[\r\n];



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