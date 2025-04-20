lexer grammar TACKY;

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

CONSTANT : C O N S T A N T ;

FUNCTION : F U N C T I O N ;

GLOBAL : G L O B A L ;

PROGRAM : P R O G R A M ;

RETURN : R E T U R N ;

VAR : V A R ;

IntegerLiteral
	: DecimalLiteral Integersuffix?
	| OctalLiteral Integersuffix?
	| HexadecimalLiteral Integersuffix?
	| BinaryLiteral Integersuffix?
    ;

// fix according to https://stackoverflow.com/questions/64108151/how-to-resolve-parsing-error-in-antlr-cpp14-grammar
StringLiteral
    : Encodingprefix? '"' Schar* '"'
    | Encodingprefix? '"' Schar* '" GST_TIME_FORMAT'
    | Encodingprefix? 'R' Rawstring
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
    :
	/*
	 Identifiernondigit | Identifier Identifiernondigit | Identifier DIGIT
	 */
	Identifiernondigit ( Identifiernondigit | DIGIT )*
    ;

fragment Identifiernondigit: NONDIGIT | Universalcharactername;

fragment NONDIGIT: [a-zA-Z_];

fragment DIGIT: [0-9];

DecimalLiteral: NONZERODIGIT ('\''? DIGIT)*;

OctalLiteral: '0' ('\''? OCTALDIGIT)*;

HexadecimalLiteral: ('0x' | '0X') HEXADECIMALDIGIT (
		'\''? HEXADECIMALDIGIT
	)*;

Integersuffix
	: Unsignedsuffix Longsuffix?
	| Unsignedsuffix Longlongsuffix?
	| Longsuffix Unsignedsuffix?
	| Longlongsuffix Unsignedsuffix?
    ;

fragment Unsignedsuffix: [uU];

fragment Longsuffix: [lL];

fragment Longlongsuffix: 'll' | 'LL';

BinaryLiteral: ('0b' | '0B') BINARYDIGIT ('\''? BINARYDIGIT)*;

fragment NONZERODIGIT: [1-9];

fragment OCTALDIGIT: [0-7];

fragment HEXADECIMALDIGIT: [0-9a-fA-F];

fragment BINARYDIGIT: [01];

fragment Encodingprefix: 'u8' | 'u' | 'U' | 'L';

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

Comma: ',';

LeftParen : '(' ;

RightParen : ')' ;

LeftBracket : '[' ;

RightBracket : ']' ;

LeftBrace : '{' ;

RightBrace : '}' ;

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