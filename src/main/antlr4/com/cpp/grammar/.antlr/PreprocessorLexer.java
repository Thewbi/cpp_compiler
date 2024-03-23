// Generated from c:/aaa_se/cpp_compiler/src/main/antlr4/com/cpp/grammar/PreprocessorLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PreprocessorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NormalWhitespace=1, NormalIdentifier=2, Hashtag=3, Greater=4, Less=5, 
		Else_PCmd=6, Elif_PCmd=7, If_PCmd=8, Endif_PCmd=9, Include_PCmd=10, NewLine=11, 
		Whitespace=12, LineComment=13, BlockComment=14, StringLiteral=15, UnterminatedStringLiteral=16, 
		TriStringLiteral=17, Number=18, Identifier=19;
	public static final int
		ISLAND=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "ISLAND"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NormalWhitespace", "NormalIdentifier", "Hashtag", "Greater", "Less", 
			"Else_PCmd", "Elif_PCmd", "If_PCmd", "Endif_PCmd", "Include_PCmd", "NewLine", 
			"Whitespace", "LineComment", "BlockComment", "StringLiteral", "UnterminatedStringLiteral", 
			"TriStringLiteral", "Number", "Identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'#'", "'>'", "'<'", "'else'", "'elif'", "'if'", "'endif'", 
			"'include'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NormalWhitespace", "NormalIdentifier", "Hashtag", "Greater", "Less", 
			"Else_PCmd", "Elif_PCmd", "If_PCmd", "Endif_PCmd", "Include_PCmd", "NewLine", 
			"Whitespace", "LineComment", "BlockComment", "StringLiteral", "UnterminatedStringLiteral", 
			"TriStringLiteral", "Number", "Identifier"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PreprocessorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PreprocessorLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\u009b\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"+
		"\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"+
		"\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"+
		"\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"+
		"\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002"+
		"\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0001\u0000\u0004\u0000*\b"+
		"\u0000\u000b\u0000\f\u0000+\u0001\u0001\u0004\u0001/\b\u0001\u000b\u0001"+
		"\f\u00010\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0003\nW\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000b^\b\u000b\u000b\u000b\f\u000b_\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\fh\b\f\n\f\f\fk\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\rq\b\r\n\r\f\rt\t\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0081\b\u000f\u0005\u000f\u0083\b"+
		"\u000f\n\u000f\f\u000f\u0086\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u008b\b\u0010\n\u0010\f\u0010\u008e\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0004\u0011\u0093\b\u0011\u000b\u0011\f\u0011\u0094"+
		"\u0001\u0012\u0004\u0012\u0098\b\u0012\u000b\u0012\f\u0012\u0099\u0001"+
		"r\u0000\u0013\u0002\u0001\u0004\u0002\u0006\u0003\b\u0004\n\u0005\f\u0006"+
		"\u000e\u0007\u0010\b\u0012\t\u0014\n\u0016\u000b\u0018\f\u001a\r\u001c"+
		"\u000e\u001e\u000f \u0010\"\u0011$\u0012&\u0013\u0002\u0000\u0001\u0006"+
		"\u0003\u0000\t\n\r\r  \b\u0000(*,,..0?A]__a{}}\u0002\u0000\n\n\r\r\u0004"+
		"\u0000\n\n\r\r\"\"\\\\\u0001\u000009\u0002\u0000AZaz\u00a6\u0000\u0002"+
		"\u0001\u0000\u0000\u0000\u0000\u0004\u0001\u0000\u0000\u0000\u0000\u0006"+
		"\u0001\u0000\u0000\u0000\u0001\b\u0001\u0000\u0000\u0000\u0001\n\u0001"+
		"\u0000\u0000\u0000\u0001\f\u0001\u0000\u0000\u0000\u0001\u000e\u0001\u0000"+
		"\u0000\u0000\u0001\u0010\u0001\u0000\u0000\u0000\u0001\u0012\u0001\u0000"+
		"\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0001\u0016\u0001\u0000"+
		"\u0000\u0000\u0001\u0018\u0001\u0000\u0000\u0000\u0001\u001a\u0001\u0000"+
		"\u0000\u0000\u0001\u001c\u0001\u0000\u0000\u0000\u0001\u001e\u0001\u0000"+
		"\u0000\u0000\u0001 \u0001\u0000\u0000\u0000\u0001\"\u0001\u0000\u0000"+
		"\u0000\u0001$\u0001\u0000\u0000\u0000\u0001&\u0001\u0000\u0000\u0000\u0002"+
		")\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00062\u0001"+
		"\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000"+
		"\f:\u0001\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000\u0010D\u0001"+
		"\u0000\u0000\u0000\u0012G\u0001\u0000\u0000\u0000\u0014M\u0001\u0000\u0000"+
		"\u0000\u0016V\u0001\u0000\u0000\u0000\u0018]\u0001\u0000\u0000\u0000\u001a"+
		"c\u0001\u0000\u0000\u0000\u001cl\u0001\u0000\u0000\u0000\u001ex\u0001"+
		"\u0000\u0000\u0000 {\u0001\u0000\u0000\u0000\"\u0087\u0001\u0000\u0000"+
		"\u0000$\u0092\u0001\u0000\u0000\u0000&\u0097\u0001\u0000\u0000\u0000("+
		"*\u0007\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,\u0003\u0001"+
		"\u0000\u0000\u0000-/\u0007\u0001\u0000\u0000.-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u00001\u0005\u0001\u0000\u0000\u000023\u0005#\u0000\u000034\u0001\u0000"+
		"\u0000\u000045\u0006\u0002\u0000\u00005\u0007\u0001\u0000\u0000\u0000"+
		"67\u0005>\u0000\u00007\t\u0001\u0000\u0000\u000089\u0005<\u0000\u0000"+
		"9\u000b\u0001\u0000\u0000\u0000:;\u0005e\u0000\u0000;<\u0005l\u0000\u0000"+
		"<=\u0005s\u0000\u0000=>\u0005e\u0000\u0000>\r\u0001\u0000\u0000\u0000"+
		"?@\u0005e\u0000\u0000@A\u0005l\u0000\u0000AB\u0005i\u0000\u0000BC\u0005"+
		"f\u0000\u0000C\u000f\u0001\u0000\u0000\u0000DE\u0005i\u0000\u0000EF\u0005"+
		"f\u0000\u0000F\u0011\u0001\u0000\u0000\u0000GH\u0005e\u0000\u0000HI\u0005"+
		"n\u0000\u0000IJ\u0005d\u0000\u0000JK\u0005i\u0000\u0000KL\u0005f\u0000"+
		"\u0000L\u0013\u0001\u0000\u0000\u0000MN\u0005i\u0000\u0000NO\u0005n\u0000"+
		"\u0000OP\u0005c\u0000\u0000PQ\u0005l\u0000\u0000QR\u0005u\u0000\u0000"+
		"RS\u0005d\u0000\u0000ST\u0005e\u0000\u0000T\u0015\u0001\u0000\u0000\u0000"+
		"UW\u0005\r\u0000\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XY\u0005\n\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0006\n\u0001\u0000[\u0017\u0001\u0000\u0000\u0000\\^\u0007\u0000\u0000"+
		"\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0006"+
		"\u000b\u0002\u0000b\u0019\u0001\u0000\u0000\u0000cd\u0005/\u0000\u0000"+
		"de\u0005/\u0000\u0000ei\u0001\u0000\u0000\u0000fh\b\u0002\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000j\u001b\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000lm\u0005/\u0000\u0000mn\u0005*\u0000\u0000nr\u0001\u0000"+
		"\u0000\u0000oq\t\u0000\u0000\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000su\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005*\u0000\u0000vw\u0005"+
		"/\u0000\u0000w\u001d\u0001\u0000\u0000\u0000xy\u0003 \u000f\u0000yz\u0005"+
		"\"\u0000\u0000z\u001f\u0001\u0000\u0000\u0000{\u0084\u0005\"\u0000\u0000"+
		"|\u0083\b\u0003\u0000\u0000}\u0080\u0005\\\u0000\u0000~\u0081\t\u0000"+
		"\u0000\u0000\u007f\u0081\u0005\u0000\u0000\u0001\u0080~\u0001\u0000\u0000"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000"+
		"\u0000\u0082|\u0001\u0000\u0000\u0000\u0082}\u0001\u0000\u0000\u0000\u0083"+
		"\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085!\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0087\u008c\u0005<\u0000\u0000\u0088\u008b\u0003"+
		"&\u0012\u0000\u0089\u008b\u0005.\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000"+
		"\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000"+
		"\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005>\u0000\u0000\u0090#\u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0007\u0004\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095%\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0007\u0005\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\'\u0001\u0000\u0000\u0000\u000f\u0000\u0001"+
		"+0V_ir\u0080\u0082\u0084\u008a\u008c\u0094\u0099\u0003\u0002\u0001\u0000"+
		"\u0002\u0000\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}