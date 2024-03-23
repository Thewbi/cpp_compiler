lexer grammar PreprocessorLexer;

NormalWhitespace:
    [ \t\r\n]+
    ;

NormalIdentifier:
    [a-zA-Z_0-9\\.\\(\\),*\\[\]\\{\\};=<>?:]+
    ;

// https://stackoverflow.com/questions/17218096/antlr4-how-to-specify-line-does-not-start-with-specific-character
//Hashtag: '#' {_input.LA(-2) == '\n'}?
//    ;

// https://media.pragprog.com/titles/tpantlr2/islands.pdf
Hashtag: '#' -> mode(ISLAND)
    ;




mode ISLAND;
Greater: '>'
    ;

Less: '<'
    ;

Else_PCmd: 'else';
Elif_PCmd: 'elif';
If_PCmd: 'if';
Endif_PCmd: 'endif';
Include_PCmd: 'include';





//Element : [a-zA-Z_0-9\\.\\(\\),*\\[\]\\{\\};]+;

NewLine:
    '\r'? '\n' -> mode(DEFAULT_MODE)
    ;

Whitespace:
    [ \t\r\n]+ -> skip
    ;

LineComment: '//' ~ [\r\n]*;

BlockComment: '/*' .*? '*/';

StringLiteral: 
    UnterminatedStringLiteral '"'
    ;

UnterminatedStringLiteral: 
    '"' (~["\\\r\n] | '\\' (. | EOF))*
    ;


TriStringLiteral:
    '<'
    ( Identifier | '.' )*
    '>'
    ;

/*
TriStringLiteral: 
    UnterminatedTStringLiteral '>'
    ;

UnterminatedTStringLiteral: 
    '<' (~[>\\\r\n] | '\\' (. | EOF))*
    ;
     */

Number: 
    [0-9]+
    ;

Identifier:
    [a-zA-Z]+
    ;




