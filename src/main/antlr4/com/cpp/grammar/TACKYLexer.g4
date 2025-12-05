lexer grammar TACKYLexer;

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

//
// Custom
//

PRINTF : P R I N T F ;

SIZEOF : S I Z E O F ;

//
// Base Tacky
//

ADD : A D D ;
ADDPTR : A D D P T R ;
ASCII : A S C I I ;
ASCIIZ : A S C I I Z ;
ARRAY : A R R A Y ;

BINARY : B I N A R Y ;
BOOL : B O O L ;
BREAK : B R E A K ;

CHARINIT : C H A R I N I T ;
COMPLEMENT : C O M P L E M E N T ;
CONSTANT : C O N S T A N T ;
CONSTINT : C O N S T I N T ;
CONSTUINT : C O N S T U I N T ;
CONSTCHAR : C O N S T C H A R ;
CONSTUCHAR : C O N S T U C H A R ;
CONSTLONG : C O N S T L O N G ;
CONSTULONG : C O N S T U L O N G ;
CONSTDOUBLE : C O N S T D O U B L E ;
CONSTSTRING : C O N S T S T R I N G ;

COPY : C O P Y ;
COPYTOOFFSET : C O P Y T O O F F S E T ;
COPYFROMOFFSET : C O P Y F R O M O F F S E T ;

DIVIDE : D I V I D E ;
DOUBLEINIT : D O U B L E I N I T ;
DOUBLETOINT : D O U B L E T O I N T ;
DOUBLETOUINT : D O U B L E T O U I N T ;

EQUAL : E Q U A L ;
EXIT : E X I T ;

FALSE : F A L S E ;
FUNCCALL : F U N C C A L L ;
FUNCTION : F U N C T I O N ;

GETADDRESS : G E T A D D R E S S ;
GLOBAL : G L O B A L ;
GREATERTHAN : G R E A T E R T H A N ;
GREATEROREQUAL : G R E A T E R O R E Q U A L ;

INTINIT : I N T I N I T ;
INT8 : I N T '8' ;
INT16 : I N T '1' '6' ;
INT32 : I N T '3' '2' ;
INTTODOUBLE : I N T T O D O U B L E ;

JUMP : J U M P ;
JUMPIFZERO : J U M P I F Z E R O ;
JUMPIFNOTZERO : J U M P I F N O T Z E R O ;
JUMPGREATERTHANOREQUAL : J U M P G R E A T E R T H A N O R E Q U A L ;

LABEL : L A B E L ;
LESSTHAN : L E S S T H A N ;
LESSOREQUAL : L E S S O R E Q U A L ;
LOAD : L O A D ;
LONGINIT : L O N G I N I T ;

MULTIPLY : M U L T I P L Y ;

NEGATE : N E G A T E ;
NOT : N O T ;
NOTEQUAL : N O T E Q U A L ;

POINTERINIT : P O I N T E R I N I T ;
PROGRAM : P R O G R A M ;

REMAINDER : R E M A I N D E R ;
RETURN : R E T U R N ;

SIGNEXTEND : S I G N E X T E N D ;
STATICCONSTANT : S T A T I C C O N S T A N T ;
STATICVARIABLE : S T A T I C V A R I A B L E ;
STORE : S T O R E ;
STRINGINIT : S T R I N G I N I T ;
SUBTRACT : S U B T R A C T ;

TRUE : T R U E ;
TRUNCATE : T R U N C A T E ;

UCHARINIT : U C H A R I N I T ;
UNARY : U N A R Y ;
UINTINIT : U I N T I N I T ;
ULONGINIT : U L O N G I N I T ;
UINTTODOUBLE : U I N T T O D O U B L E ;

VAR : V A R ;

ZEROINIT : Z E R O I N I T ;
ZEROEXTEND : Z E R O E X T E N D ;

IntegerLiteral
	: DecimalLiteral Integersuffix?
	| OctalLiteral Integersuffix?
	| HexadecimalLiteral Integersuffix?
	| BinaryLiteral Integersuffix?
    ;

FloatingLiteral
	: Fractionalconstant Exponentpart? Floatingsuffix?
	| Digitsequence Exponentpart Floatingsuffix?;

// fix according to https://stackoverflow.com/questions/64108151/how-to-resolve-parsing-error-in-antlr-cpp14-grammar
StringLiteral
    : Encodingprefix? '"' Schar* '"'
    | Encodingprefix? '"' Schar* '" GST_TIME_FORMAT'
    | Encodingprefix? 'R' Rawstring
    ;

CharLiteral
    : Encodingprefix? '\'' Schar '\''
//    : '\'' [a-z] '\''
    ;

fragment Schar
    : ~ ["\\\r\n]
	| Escapesequence
	| Universalcharactername
    ;

fragment Hexquad
    : HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT
    ;

fragment Universalcharactername
    : '\\u' Hexquad
	| '\\U' Hexquad Hexquad
    ;

Identifier
    : Identifiernondigit ( DOT | Identifiernondigit | DIGIT )*
    ;

fragment Identifiernondigit : NONDIGIT | Universalcharactername;

fragment NONDIGIT : [a-zA-Z_];

fragment DIGIT : [0-9];

DecimalLiteral : NONZERODIGIT ('\''? DIGIT)*;

OctalLiteral : '0' ('\''? OCTALDIGIT)*;

HexadecimalLiteral : ('0x' | '0X') HEXADECIMALDIGIT (
		'\''? HEXADECIMALDIGIT
	)*;

Integersuffix
	: Unsignedsuffix Longsuffix?
	| Unsignedsuffix Longlongsuffix?
	| Longsuffix Unsignedsuffix?
	| Longlongsuffix Unsignedsuffix?
    ;

fragment Unsignedsuffix : [uU] ;

fragment Longsuffix : [lL] ;

fragment Longlongsuffix : 'll' | 'LL' ;

BinaryLiteral : ('0b' | '0B') BINARYDIGIT ('\''? BINARYDIGIT)* ;

fragment NONZERODIGIT : [1-9] ;

fragment OCTALDIGIT : [0-7] ;

fragment HEXADECIMALDIGIT : [0-9a-fA-F] ;

fragment BINARYDIGIT : [01] ;

fragment Encodingprefix : 'u8' | 'u' | 'U' | 'L' ;

fragment Escapesequence
    : Simpleescapesequence
	| Octalescapesequence
	| Hexadecimalescapesequence
    ;

fragment Simpleescapesequence
	: '\\\''
	| '\\"'
	| '\\?'
	| '\\\\'
	| '\\a'
	| '\\b'
	| '\\f'
	| '\\n'
	| '\\r'
	| '\\' ('\r' '\n'? | '\n')
	| '\\t'
	| '\\v'
    ;

fragment Octalescapesequence
	: '\\' OCTALDIGIT
	| '\\' OCTALDIGIT OCTALDIGIT
	| '\\' OCTALDIGIT OCTALDIGIT OCTALDIGIT
    ;

fragment Hexadecimalescapesequence
    : '\\x' HEXADECIMALDIGIT+
    ;

fragment Fractionalconstant
	: Digitsequence? '.' Digitsequence
	| Digitsequence '.'
    ;

fragment Exponentpart
	: 'e' SIGN? Digitsequence
	| 'E' SIGN? Digitsequence
    ;

fragment SIGN : [+-];

fragment Digitsequence : DIGIT ('\''? DIGIT)*;

fragment Floatingsuffix : [flFL];

ASTERISK : '*' ;
AMPERSAND_DOUBLE : '&&' ;

BAR_DOUBLE : '||' ;

COMMA : ',' ;

DOT : '.' ;

EQUAL_OPERATOR : '==' ;
EQUAL_SIGN : '=' ;

LESS_THAN : '<' ;
LESS_THAN_OR_EQUAL : '<=' ;
GREATER_THAN_OR_EQUAL : '>=' ;
GREATER_THAN : '>' ;

MINUS : '-' ;

PLUS : '+' ;

LEFT_PAREN : '(' ;

RIGHT_PAREN : ')' ;

LEFT_BRACKET : '[' ;

RIGHT_BRACKET : ']' ;

LEFT_BRACE : '{' ;

RIGHT_BRACE : '}' ;

SLASH : '/' ;

// fix according to https://stackoverflow.com/questions/64108151/how-to-resolve-parsing-error-in-antlr-cpp14-grammar
fragment Rawstring
 : '"'              // Match Opening Double Quote
   ( /* Handle Empty D_CHAR_SEQ without Predicates
        This should also work
        '(' .*? ')'
      */
     '(' ( ~')' | ')'+ ~'"' )* (')'+)

   | D_CHAR_SEQ
         /*  // Limit D_CHAR_SEQ to 16 characters
            { ( ( getText().length() - ( getText().indexOf("\"") + 1 ) ) <= 16 ) }?
         */
     '('
     /* From Spec :
        Any member of the source character set, except
        a right parenthesis ) followed by the initial D_CHAR_SEQUENCE
        ( which may be empty ) followed by a double quote ".

      - The following loop consumes characters until it matches the
        terminating sequence of characters for the RAW STRING
      - The options are mutually exclusive, so Only one will
        ever execute in each loop pass
      - Each Option will execute at least once.  The first option needs to
        match the ')' character even if the D_CHAR_SEQ is empty. The second
        option needs to match the closing \" to fall out of the loop. Each
        option will only consume at most 1 character
      */
     (   //  Consume everthing but the Double Quote
       ~'"'
     |   //  If text Does Not End with closing Delimiter, consume the Double Quote
       '"'
       {
        /*
            // !getText().endsWith(
            //     ")"
            //   + getText().substring( getText().indexOf( "\"" ) + 1
            //                        , getText().indexOf( "(" )
            //                        )
            //   + '\"'
            // )

			//println!("line_number: {}", recog.get_line());

				let ttext = recog.get_text();
				//println!("{:?}", ttext);

				let mut start_index: i64 = -1;
				match ttext.find("\"") {
					None => { start_index = -1; }
					Some(x) => { start_index = x as i64; }
				}
				start_index += 1;

				let mut end_index: i64 = -1;
				match ttext.find("(") {
					None => { end_index = -1; }
					Some(x) => { end_index = x as i64; }
				}

				let slice = &ttext[start_index as usize..end_index as usize];

				let mut substring: String = ")".to_owned();
				substring.push_str(slice);
				substring.push_str("\"");

				//println!("substring; {}", substring);

				return !ttext.ends_with(&substring);
                 */

                 false
       }?
     )*
   )
   '"'              // Match Closing Double Quote

   /*
   // Strip Away R"D_CHAR_SEQ(...)D_CHAR_SEQ"
   //  Send D_CHAR_SEQ <TAB> ... to Parser
   {
     setText( getText().substring( getText().indexOf("\"") + 1
                                 , getText().indexOf("(")
                                 )
            + "\t"
            + getText().substring( getText().indexOf("(") + 1
                                 , getText().lastIndexOf(")")
                                 )
            );
   }
    */
 ;

fragment D_CHAR_SEQ     // Should be limited to 16 characters
    : D_CHAR+
    ;

fragment D_CHAR
      /*  Any member of the basic source character set except
          space, the left parenthesis (, the right parenthesis ),
          the backslash \, and the control characters representing
           horizontal tab, vertical tab, form feed, and newline.
      */
    : '\u0021'..'\u0023'
    | '\u0025'..'\u0027'
    | '\u002a'..'\u003f'
    | '\u0041'..'\u005b'
    | '\u005d'..'\u005f'
    | '\u0061'..'\u007e'
    ;

WS
    : [ \t\n\r\f]+ -> skip
    ;

LINE_COMMENT
    : ( ';' | '#' ) ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' ( BLOCK_COMMENT | . )*? '*/' -> skip
    ;

DOUBLE_SLASH_LINE_COMMENT
    : '//' .*? '\n' -> skip
    ;