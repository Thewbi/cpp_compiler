lexer grammar CPreprocessorLexer;

// FROM: https://wrice.blogspot.com/2013/12/antlr-grammar-for-cc-preprocessor.html

// lexer rules must start with upper case.

@lexer::members {
    //public const int CHANNEL_COMMENT_BLOCK = 1;
    //public const int CHANNEL_COMMENT_LINE = 2;
    //protected const int EOF = Eof;
    //protected const int HIDDEN = Hidden;
}

//=======================================================================
//COMMENT_BLOCK        :    '/*'    .*?        '*/'            -> channel(CHANNEL_COMMENT_BLOCK) ;
//COMMENT_LINE        :    '//'    NOT_NL*                    -> channel(CHANNEL_COMMENT_LINE) ;
NL_ESC                :    '\\'    NL                        -> skip ;
STRING                :    '"'    (STRING_ESC|.)*?    '"'        ;
WS                    :    ' '    |    '\t'                    ;    // preprocessor cannot "skip" white space, because wb matters in several cases.
NEWLINE                :    NL                                ;    // preprocessor cannot "skip" new line, because wb matters in several cases.
PREPROCESS_BEGIN    :    '#'                                ;

//=======================================================================
// nmode doesn't seem to work for C#
// mode preprocessMode;
//=======================================================================
PREPROCESS_INCLUDE    :    'include'    ;
PREPROCESS_DEFINE    :    'define'    ;
PREPROCESS_UNDEF    :    'undef'        ;
PREPROCESS_IFDEF    :    'ifdef'        ;    // this must appear before 'if'
PREPROCESS_IFNDEF    :    'ifndef'    ;    // this must appear before 'if'
PREPROCESS_IF        :    'if'        ;
PREPROCESS_ELSE        :    'else'        ;
PREPROCESS_ELIF        :    'elif'        ;
PREPROCESS_ENDIF    :    'endif'        ;
PREPROCESS_PRAGMA    :    'pragma'    ;
PREPROCESS_ERROR    :    'error'        ;

//=======================================================================
// These must be below reserved keywords
//=======================================================================
DEFINED        :    'defined'    ;
ID            :    ID_LETTER    (ID_LETTER|DIGIT)*    ;
COMMA        :    ','                                ;
PAREN_OPEN    :    '('                                ;
PAREN_CLOSE    :    ')'                                ;
CHAR        :    '\''    .    '\''
            |    .                                // the rest of all
            ;

//=======================================================================
// fragment can be referenced only by lexer.
// fragment itself is not lexer rule so that it cannot be used by parser.
//=======================================================================
fragment ID_LETTER    :    [a-zA-Z_]            ;
fragment DIGIT        :    [0-9]                ;
fragment STRING_ESC    :    '\\'    [btnr0"\\]    ; // \b, \t, \n etc...
fragment NL            :    '\r'?    '\n'        ;
fragment NOT_NL        :    ~[\r\n]                ;


//lexer grammar CPConditionLexerRule;

// Logic operator
LOP_AND    :    '&&'    ;
LOP_OR    :    '||'    ;
LOP_NOT    :    '!'    ;

// Bit operator
BOP_NOT    :    '~'    ;
BOP_XOR    :    '^'    ;
BOP_AND    :    '&'    ;
BOP_OR    :    '|'    ;
BOP_SHL    :    '<<'    ;
BOP_SHR    :    '>>'    ;

// Arithmatic operator
AOP_ADD    :    '+'    ;
AOP_SUB    :    '-'    ;
AOP_MUL    :    '*'    ;
AOP_DIV    :    '/'    ;
AOP_MOD    :    '%'    ;

// Comparison operator
CMP_EQ    :    '=='    ;
CMP_NE    :    '!='    ;
CMP_LE    :    '<='    ;
CMP_LT    :    '<'    ;
CMP_GE    :    '>='    ;
CMP_GT    :    '>'    ;

// Ternary conditional
TER_IF    :    '?'    ;
TER_ELS    :    ':'    ;

// Parentheses
//PAREN_OPEN    :    '('    ;
//PAREN_CLOSE    :    ')'    ;

// Reserved keyword
//DEFINED    :    'defined'    ;
TRUE    :    'true'    ;
FALSE    :    'false'    ;

// typed values
FLOAT    :    DIGIT+    '.'    DIGIT*    'f'?            // match 1. 39. 3.14159 etc...
        |            '.'    DIGIT+    'f'?            // match .1 .14159
        ;
INT        :    [1-9]    DIGIT*
        |    '0'
        ;
HEX        :    '0x'    DIGIT+    ;    // 0x000
OCT        :    '0'        DIGIT+    ;    // 0123
//ID        :    ID_LETTER    (ID_LETTER|DIGIT)*    ;

// skip
//NL_ESC    :    '\\'    '\r'?    '\n'    -> skip ;
//WS        :    [ \t]+                    -> skip ;


// fragments
//fragment ID_LETTER    :    [a-zA-Z_]    ;
//fragment DIGIT        :    [0-9]    ;
