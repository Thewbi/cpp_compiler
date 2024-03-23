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
		PIFDEFStart=1, PELSEStart=2, PENDIFStart=3, NEWLINE=4, TEXT=5, PIFDEFPTEXT=6, 
		PIFDEFPEOL=7, PIFDEFPWS=8, PIFDEFPCMT=9, PELSEPEOL=10, PELSEPWS=11, PELSEPCMT=12, 
		PENDIFPEOL=13, PENDIFPWS=14, PENDIFPCMT=15;
	public static final int
		PreProcIFDEF=1, PreProcELSE=2, PreProcENDIF=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "PreProcIFDEF", "PreProcELSE", "PreProcENDIF"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PIFDEFStart", "PELSEStart", "PENDIFStart", "NEWLINE", "TEXT", "PIFDEFPTEXT", 
			"PIFDEFPEOL", "PIFDEFPWS", "PIFDEFPCMT", "PELSEPEOL", "PELSEPWS", "PELSEPCMT", 
			"PENDIFPEOL", "PENDIFPWS", "PENDIFPCMT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#IFDEF'", "'#ELSE'", "'#ENDIF'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PIFDEFStart", "PELSEStart", "PENDIFStart", "NEWLINE", "TEXT", 
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
		"\u0004\u0000\u000f\u0093\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0003\u0003>\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0004\u0005E\b\u0005\u000b\u0005\f\u0005"+
		"F\u0001\u0006\u0003\u0006J\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0004\u0007Q\b\u0007\u000b\u0007\f\u0007R\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b[\b\b\n\b\f"+
		"\b^\t\b\u0001\b\u0001\b\u0001\t\u0003\tc\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0004\nj\b\n\u000b\n\f\nk\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000bt\b\u000b\n\u000b\f\u000bw\t"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003\f|\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0004\r\u0083\b\r\u000b\r\f\r\u0084\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u008d\b\u000e"+
		"\n\u000e\f\u000e\u0090\t\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f"+
		"\u0004\u0001\u0006\u0002\b\u0003\n\u0004\f\u0005\u000e\u0006\u0010\u0007"+
		"\u0012\b\u0014\t\u0016\n\u0018\u000b\u001a\f\u001c\r\u001e\u000e \u000f"+
		"\u0004\u0000\u0001\u0002\u0003\u0003\u0002\u0000\n\n\r\r\u0005\u0000-"+
		"-09AZ__az\u0002\u0000\t\t  \u009a\u0000\u0004\u0001\u0000\u0000\u0000"+
		"\u0000\u0006\u0001\u0000\u0000\u0000\u0000\b\u0001\u0000\u0000\u0000\u0000"+
		"\n\u0001\u0000\u0000\u0000\u0000\f\u0001\u0000\u0000\u0000\u0001\u000e"+
		"\u0001\u0000\u0000\u0000\u0001\u0010\u0001\u0000\u0000\u0000\u0001\u0012"+
		"\u0001\u0000\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0002\u0016"+
		"\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0002\u001a"+
		"\u0001\u0000\u0000\u0000\u0003\u001c\u0001\u0000\u0000\u0000\u0003\u001e"+
		"\u0001\u0000\u0000\u0000\u0003 \u0001\u0000\u0000\u0000\u0004\"\u0001"+
		"\u0000\u0000\u0000\u0006+\u0001\u0000\u0000\u0000\b3\u0001\u0000\u0000"+
		"\u0000\n=\u0001\u0000\u0000\u0000\fA\u0001\u0000\u0000\u0000\u000eD\u0001"+
		"\u0000\u0000\u0000\u0010I\u0001\u0000\u0000\u0000\u0012P\u0001\u0000\u0000"+
		"\u0000\u0014V\u0001\u0000\u0000\u0000\u0016b\u0001\u0000\u0000\u0000\u0018"+
		"i\u0001\u0000\u0000\u0000\u001ao\u0001\u0000\u0000\u0000\u001c{\u0001"+
		"\u0000\u0000\u0000\u001e\u0082\u0001\u0000\u0000\u0000 \u0088\u0001\u0000"+
		"\u0000\u0000\"#\u0005#\u0000\u0000#$\u0005I\u0000\u0000$%\u0005F\u0000"+
		"\u0000%&\u0005D\u0000\u0000&\'\u0005E\u0000\u0000\'(\u0005F\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)*\u0006\u0000\u0000\u0000*\u0005\u0001\u0000"+
		"\u0000\u0000+,\u0005#\u0000\u0000,-\u0005E\u0000\u0000-.\u0005L\u0000"+
		"\u0000./\u0005S\u0000\u0000/0\u0005E\u0000\u000001\u0001\u0000\u0000\u0000"+
		"12\u0006\u0001\u0001\u00002\u0007\u0001\u0000\u0000\u000034\u0005#\u0000"+
		"\u000045\u0005E\u0000\u000056\u0005N\u0000\u000067\u0005D\u0000\u0000"+
		"78\u0005I\u0000\u000089\u0005F\u0000\u00009:\u0001\u0000\u0000\u0000:"+
		";\u0006\u0002\u0002\u0000;\t\u0001\u0000\u0000\u0000<>\u0005\r\u0000\u0000"+
		"=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0005\n\u0000\u0000@\u000b\u0001\u0000\u0000\u0000AB\b\u0000"+
		"\u0000\u0000B\r\u0001\u0000\u0000\u0000CE\u0007\u0001\u0000\u0000DC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000G\u000f\u0001\u0000\u0000\u0000HJ\u0005\r\u0000"+
		"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0005\n\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0006\u0006"+
		"\u0003\u0000N\u0011\u0001\u0000\u0000\u0000OQ\u0007\u0002\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0006\u0007"+
		"\u0004\u0000U\u0013\u0001\u0000\u0000\u0000VW\u0005/\u0000\u0000WX\u0005"+
		"/\u0000\u0000X\\\u0001\u0000\u0000\u0000Y[\b\u0000\u0000\u0000ZY\u0001"+
		"\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000_`\u0006\b\u0004\u0000`\u0015\u0001\u0000\u0000\u0000ac\u0005\r"+
		"\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000de\u0005\n\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0006"+
		"\t\u0003\u0000g\u0017\u0001\u0000\u0000\u0000hj\u0007\u0002\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0006\n\u0004"+
		"\u0000n\u0019\u0001\u0000\u0000\u0000op\u0005/\u0000\u0000pq\u0005/\u0000"+
		"\u0000qu\u0001\u0000\u0000\u0000rt\b\u0000\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0006"+
		"\u000b\u0004\u0000y\u001b\u0001\u0000\u0000\u0000z|\u0005\r\u0000\u0000"+
		"{z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0005\n\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0006\f\u0003\u0000\u0080\u001d\u0001\u0000\u0000\u0000\u0081\u0083\u0007"+
		"\u0002\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0006"+
		"\r\u0004\u0000\u0087\u001f\u0001\u0000\u0000\u0000\u0088\u0089\u0005/"+
		"\u0000\u0000\u0089\u008a\u0005/\u0000\u0000\u008a\u008e\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\b\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0006\u000e\u0004\u0000"+
		"\u0092!\u0001\u0000\u0000\u0000\u000f\u0000\u0001\u0002\u0003=FIR\\bk"+
		"u{\u0084\u008e\u0005\u0005\u0001\u0000\u0005\u0002\u0000\u0005\u0003\u0000"+
		"\u0004\u0000\u0000\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}