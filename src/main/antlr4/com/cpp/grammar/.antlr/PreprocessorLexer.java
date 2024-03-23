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
		NEWLINE=1, TEXT=2, PIFDEFStart=3, PELSEStart=4, PENDIFStart=5, PINCLUDEStart=6, 
		PINCLUDEPTEXT=7, PINCLUDEPEOL=8, PINCLUDEPWS=9, PINCLUDEPCMT=10, PIFDEFPTEXT=11, 
		PIFDEFPEOL=12, PIFDEFPWS=13, PIFDEFPCMT=14, PELSEPEOL=15, PELSEPWS=16, 
		PELSEPCMT=17, PENDIFPEOL=18, PENDIFPWS=19, PENDIFPCMT=20;
	public static final int
		PreProcINCLUDE=1, PreProcIFDEF=2, PreProcELSE=3, PreProcENDIF=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "PreProcINCLUDE", "PreProcIFDEF", "PreProcELSE", "PreProcENDIF"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "TEXT", "PIFDEFStart", "PELSEStart", "PENDIFStart", "PINCLUDEStart", 
			"PINCLUDEPTEXT", "PINCLUDEPEOL", "PINCLUDEPWS", "PINCLUDEPCMT", "PIFDEFPTEXT", 
			"PIFDEFPEOL", "PIFDEFPWS", "PIFDEFPCMT", "PELSEPEOL", "PELSEPWS", "PELSEPCMT", 
			"PENDIFPEOL", "PENDIFPWS", "PENDIFPCMT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TEXT", "PIFDEFStart", "PELSEStart", "PENDIFStart", 
			"PINCLUDEStart", "PINCLUDEPTEXT", "PINCLUDEPEOL", "PINCLUDEPWS", "PINCLUDEPCMT", 
			"PIFDEFPTEXT", "PIFDEFPEOL", "PIFDEFPWS", "PIFDEFPCMT", "PELSEPEOL", 
			"PELSEPWS", "PELSEPCMT", "PENDIFPEOL", "PENDIFPWS", "PENDIFPCMT"
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
		"\u0004\u0000\u0014\u00df\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0003\u0000"+
		"/\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0005\u00026\b\u0002\n\u0002\f\u00029\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0005\u0003E\b\u0003\n\u0003\f\u0003H\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004S\b\u0004\n\u0004\f\u0004"+
		"V\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0005\u0005"+
		"b\b\u0005\n\u0005\f\u0005e\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006s\b\u0006\u000b\u0006"+
		"\f\u0006t\u0001\u0007\u0003\u0007x\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0004\b\u007f\b\b\u000b\b\f\b\u0080\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0089\b\t\n\t\f\t\u008c"+
		"\t\t\u0001\t\u0001\t\u0001\n\u0004\n\u0091\b\n\u000b\n\f\n\u0092\u0001"+
		"\u000b\u0003\u000b\u0096\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0004\f\u009d\b\f\u000b\f\f\f\u009e\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u00a7\b\r\n\r\f\r\u00aa\t\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0003\u000e\u00af\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f\u00b6\b\u000f\u000b\u000f"+
		"\f\u000f\u00b7\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00c0\b\u0010\n\u0010\f\u0010\u00c3\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u00c8\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u00cf\b\u0012\u000b"+
		"\u0012\f\u0012\u00d0\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00d9\b\u0013\n\u0013\f\u0013\u00dc\t\u0013"+
		"\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0005\u0001\u0007\u0002\t\u0003"+
		"\u000b\u0004\r\u0005\u000f\u0006\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019"+
		"\u000b\u001b\f\u001d\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013"+
		"+\u0014\u0005\u0000\u0001\u0002\u0003\u0004\u0004\u0002\u0000\n\n\r\r"+
		"\u0001\u0000  \u0005\u0000--09AZ__az\u0002\u0000\t\t  \u00ed\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0011\u0001\u0000"+
		"\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000"+
		"\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000"+
		"\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0002\u001d\u0001\u0000"+
		"\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0003!\u0001\u0000\u0000"+
		"\u0000\u0003#\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0004"+
		"\'\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0004+\u0001"+
		"\u0000\u0000\u0000\u0005.\u0001\u0000\u0000\u0000\u00072\u0001\u0000\u0000"+
		"\u0000\t7\u0001\u0000\u0000\u0000\u000bF\u0001\u0000\u0000\u0000\rT\u0001"+
		"\u0000\u0000\u0000\u000fc\u0001\u0000\u0000\u0000\u0011r\u0001\u0000\u0000"+
		"\u0000\u0013w\u0001\u0000\u0000\u0000\u0015~\u0001\u0000\u0000\u0000\u0017"+
		"\u0084\u0001\u0000\u0000\u0000\u0019\u0090\u0001\u0000\u0000\u0000\u001b"+
		"\u0095\u0001\u0000\u0000\u0000\u001d\u009c\u0001\u0000\u0000\u0000\u001f"+
		"\u00a2\u0001\u0000\u0000\u0000!\u00ae\u0001\u0000\u0000\u0000#\u00b5\u0001"+
		"\u0000\u0000\u0000%\u00bb\u0001\u0000\u0000\u0000\'\u00c7\u0001\u0000"+
		"\u0000\u0000)\u00ce\u0001\u0000\u0000\u0000+\u00d4\u0001\u0000\u0000\u0000"+
		"-/\u0005\r\u0000\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000001\u0005\n\u0000\u00001\u0006\u0001\u0000\u0000"+
		"\u000023\b\u0000\u0000\u00003\b\u0001\u0000\u0000\u000046\u0007\u0001"+
		"\u0000\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000:;\u0005#\u0000\u0000;<\u0005i\u0000\u0000<"+
		"=\u0005f\u0000\u0000=>\u0005d\u0000\u0000>?\u0005e\u0000\u0000?@\u0005"+
		"f\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0006\u0002\u0000\u0000B\n\u0001"+
		"\u0000\u0000\u0000CE\u0007\u0001\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005#\u0000"+
		"\u0000JK\u0005e\u0000\u0000KL\u0005l\u0000\u0000LM\u0005s\u0000\u0000"+
		"MN\u0005e\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0006\u0003\u0001\u0000"+
		"P\f\u0001\u0000\u0000\u0000QS\u0007\u0001\u0000\u0000RQ\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005"+
		"#\u0000\u0000XY\u0005e\u0000\u0000YZ\u0005n\u0000\u0000Z[\u0005d\u0000"+
		"\u0000[\\\u0005i\u0000\u0000\\]\u0005f\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^_\u0006\u0004\u0002\u0000_\u000e\u0001\u0000\u0000\u0000`b\u0007"+
		"\u0001\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000fg\u0005#\u0000\u0000gh\u0005i\u0000\u0000"+
		"hi\u0005n\u0000\u0000ij\u0005c\u0000\u0000jk\u0005l\u0000\u0000kl\u0005"+
		"u\u0000\u0000lm\u0005d\u0000\u0000mn\u0005e\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000op\u0006\u0005\u0003\u0000p\u0010\u0001\u0000\u0000\u0000"+
		"qs\u0007\u0002\u0000\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u0012\u0001"+
		"\u0000\u0000\u0000vx\u0005\r\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\n\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0006\u0007\u0004\u0000|\u0014\u0001\u0000\u0000"+
		"\u0000}\u007f\u0007\u0003\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0006\b\u0005\u0000\u0083\u0016\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"/\u0000\u0000\u0085\u0086\u0005/\u0000\u0000\u0086\u008a\u0001\u0000\u0000"+
		"\u0000\u0087\u0089\b\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0006\t\u0005\u0000\u008e"+
		"\u0018\u0001\u0000\u0000\u0000\u008f\u0091\u0007\u0002\u0000\u0000\u0090"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093"+
		"\u001a\u0001\u0000\u0000\u0000\u0094\u0096\u0005\r\u0000\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005\n\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0006\u000b\u0004\u0000\u009a\u001c\u0001"+
		"\u0000\u0000\u0000\u009b\u009d\u0007\u0003\u0000\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0006\f\u0005\u0000\u00a1\u001e\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005/\u0000\u0000\u00a3\u00a4\u0005/\u0000\u0000"+
		"\u00a4\u00a8\u0001\u0000\u0000\u0000\u00a5\u00a7\b\u0000\u0000\u0000\u00a6"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0006\r\u0005\u0000\u00ac \u0001\u0000\u0000\u0000\u00ad\u00af"+
		"\u0005\r\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"\n\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u000e"+
		"\u0004\u0000\u00b3\"\u0001\u0000\u0000\u0000\u00b4\u00b6\u0007\u0003\u0000"+
		"\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u000f\u0005"+
		"\u0000\u00ba$\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005/\u0000\u0000\u00bc"+
		"\u00bd\u0005/\u0000\u0000\u00bd\u00c1\u0001\u0000\u0000\u0000\u00be\u00c0"+
		"\b\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0006\u0010\u0005\u0000\u00c5&\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0005\r\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0005\n\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0006\u0011\u0004\u0000\u00cc(\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cf\u0007\u0003\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0006\u0012\u0005\u0000\u00d3*\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0005/\u0000\u0000\u00d5\u00d6\u0005/\u0000\u0000\u00d6\u00da\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d9\b\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dd\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00de\u0006\u0013\u0005"+
		"\u0000\u00de,\u0001\u0000\u0000\u0000\u0018\u0000\u0001\u0002\u0003\u0004"+
		".7FTctw\u0080\u008a\u0092\u0095\u009e\u00a8\u00ae\u00b7\u00c1\u00c7\u00d0"+
		"\u00da\u0006\u0005\u0002\u0000\u0005\u0003\u0000\u0005\u0004\u0000\u0005"+
		"\u0001\u0000\u0004\u0000\u0000\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}