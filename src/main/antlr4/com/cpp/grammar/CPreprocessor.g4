grammar CPreprocessor;

// FROM: https://wrice.blogspot.com/2013/12/antlr-grammar-for-cc-preprocessor.html

//import CPreprocessorLexerRule;

options {
	tokenVocab = CPreprocessorLexer;
}

// parser rules must start with lower case.

@parser::members
{
    //protected const int EOF = Eof;
}

program        :    statement*    EOF    ;

statement    :    preprocess
//            |    ( COMMENT_BLOCK | COMMENT_LINE )
            |    STRING                        // ignore
            |    ( ppChars | NEWLINE )        // ignore
            | macro_statement
            | condition
            ;

// pp means preprocess
preprocess    :    ppInclude
            |    ppDefineFunc    // this must be before ppDefineVar: eg. #define AAA  ( a )
            |    ppDefineVar
            |    ppUndef
            |    ppPragma
            |    ppError
            |    ppIfStatement
            ;

ppChars        :    ( STRING | WS | PREPROCESS_BEGIN | DEFINED | ID | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )+    ;

ppInclude    :    PREPROCESS_BEGIN    WS*    PREPROCESS_INCLUDE    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;
ppPragma    :    PREPROCESS_BEGIN    WS*    PREPROCESS_PRAGMA    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;
ppError        :    PREPROCESS_BEGIN    WS*    PREPROCESS_ERROR    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;

ppUndef            :    PREPROCESS_BEGIN    WS*    PREPROCESS_UNDEF    WS+    ID                            WS*    ( NEWLINE | EOF )    ;
ppDefineVar        :    PREPROCESS_BEGIN    WS*    PREPROCESS_DEFINE    WS+    ID        ( WS+    ppChars )?    WS*    ( NEWLINE | EOF )    ;
ppDefineFunc    :    PREPROCESS_BEGIN    WS*    PREPROCESS_DEFINE    WS+    ppdfId    WS*    ppdfChars        WS*    ( NEWLINE | EOF )    ;

// ppdfi means preprocess define function ID
ppdfId            :    ID    PAREN_OPEN    WS*    ppdfiArguments    WS*    PAREN_CLOSE    ;    // WS between ID and '(' is not allowed.
ppdfiArguments    :    ppdfiArgument    ( WS*    COMMA    WS*    ppdfiArgument    )*    ;    // at least 1 argument is required.
ppdfiArgument    :    ID    ;

// ppdfc means preprocess define function characters
ppdfChars    :    ( ppdfcId | ppdfcNotId )+    ;
ppdfcId        :    ID    ;
ppdfcNotId    :    ( STRING | WS | PREPROCESS_BEGIN | DEFINED | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )    ;


ppIfStatement    :    ( ppisIF | ppisIfDef | ppisIfNdef )    ;

ppisIF            :    PREPROCESS_BEGIN    WS*    PREPROCESS_IF        WS+    condition    WS*    NEWLINE            ppisStatement    ppisElifElseEndif    ;
ppisElif        :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELIF        WS+    ppChars    WS*    NEWLINE            ppisStatement    ppisElifElseEndif    ;
ppisElse        :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELSE                    WS*    NEWLINE            ppisStatement    ppisEndif    ;
ppisEndif        :    PREPROCESS_BEGIN    WS*    PREPROCESS_ENDIF                WS*    (NEWLINE|EOF)    ;
ppisIfDef        :    PREPROCESS_BEGIN    WS*    PREPROCESS_IFDEF    WS+    ID        WS*    NEWLINE            ppisStatement    ppisElseEndif    ;
ppisIfNdef        :    PREPROCESS_BEGIN    WS*    PREPROCESS_IFNDEF    WS+    ID        WS*    NEWLINE            ppisStatement    ppisElseEndif    ;

ppisStatement        :    statement*
                     ;

ppisElifElseEndif    :    ppisElif
                    |    ppisElseEndif
                    ;

ppisElseEndif        :    ppisElse
                    |    ppisEndif
                    ;

// Assumptions:
// 1. Lexer will remove white spaces.

condition    : expression ;

// Indirect left-recursion for binary/ternary expressions is solved by "direct" left-recursion
expression    :
                PAREN_OPEN    expression    PAREN_CLOSE                                                    # ceParen
            |    unaryExpression                                                                        # ceUnary
            |    expression    op=(AOP_MUL|AOP_DIV|AOP_MOD)        expression                            # ceMulDivMod
            |    expression    op=(AOP_ADD|AOP_SUB)                expression                            # ceAddSub
            |    expression    op=(BOP_SHL|BOP_SHR)                expression                            # ceShlShr
            |    expression    op=(CMP_LE|CMP_LT|CMP_GE|CMP_GT)    expression                            # ceCmpLeLtGeGt
            |    expression    op=(CMP_EQ|CMP_NE)                    expression                            # ceCmpEqNe
            |    expression    BOP_AND                                expression                            # ceBitAnd
            |    expression    BOP_XOR                                expression                            # ceBitXor
            |    expression    BOP_OR                                expression                            # ceBitOr
            |    expression    LOP_AND                                expression                            # ceLogicAnd
            |    expression    LOP_OR                                expression                            # ceLogicOr
            |    expression    TER_IF                                expression    TER_ELS    expression        # ceTerIf
            |    value                                                                                # ceValue
            | ppChars # cePpChars
            ;

unaryExpression    :    op=(AOP_ADD|AOP_SUB|BOP_NOT|LOP_NOT)    expression    ;

value   :    val=FLOAT
        |    val=INT
        |    val=HEX
        |    val=OCT
        |    val=TRUE
        |    val=FALSE
        |    val=ID    // error
        ;

// Asumptions for the input statement:
// 1. No block/line comment exists.
// 2. No '#' character exists.
// 3. No preprocessor keywords exists except "defined"

macro_statement    :    sToken+    ;

sToken        :    stDefined
            |    stFunctionCall
            |    stVariable
            |    stOther
            ;

stDefined    :    DEFINED    WS+    stdId    ;
stdId        :    PAREN_OPEN    WS*    stdId    WS*    PAREN_CLOSE
            |    stdiId
            ;
stdiId        :    ID    ;

stVariable    :    ID    ;

stFunctionCall    :    ID    WS*    PAREN_OPEN    stfcArguments    PAREN_CLOSE    ;
stfcArguments    :    stfcaArgument    ( COMMA    stfcaArgument )*    ;
stfcaArgument    :    ( PAREN_OPEN    stfcaArgument    PAREN_CLOSE | STRING | WS | ID | CHAR )*    ;

stOther        :    ( STRING | WS | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )    ;
