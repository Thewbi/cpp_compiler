lexer grammar PreprocessorLexer;



If_PCmd: '#if';
Include_PCmd: '#include';

//Element: .+ ~[ \t\r\n];
Element            :   [a-zA-Z_0-9\\.]+;

//Whitespace: [ \t\r\n]+ -> skip;
Whitespace:
    [ \t\r\n]
    ;

LineComment: '//' ~ [\r\n]*;

StringLiteral: 
    UnterminatedStringLiteral '"'
    ;

UnterminatedStringLiteral: 
    '"' (~["\\\r\n] | '\\' (. | EOF))*
    ;