// Generated from c:/aaa_se/cpp_compiler/src/main/antlr4/com/cpp/grammar/PreprocessorParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PreprocessorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PIFDEFStart=1, PELSEStart=2, PENDIFStart=3, NEWLINE=4, TEXT=5, PIFDEFPTEXT=6, 
		PIFDEFPEOL=7, PIFDEFPWS=8, PIFDEFPCMT=9, PELSEPEOL=10, PELSEPWS=11, PELSEPCMT=12, 
		PENDIFPEOL=13, PENDIFPWS=14, PENDIFPCMT=15;
	public static final int
		RULE_code_file = 0, RULE_code_block = 1, RULE_preproc = 2, RULE_pifdef = 3, 
		RULE_pelse = 4, RULE_pendif = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"code_file", "code_block", "preproc", "pifdef", "pelse", "pendif"
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

	@Override
	public String getGrammarFileName() { return "PreprocessorParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PreprocessorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Code_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PreprocessorParser.EOF, 0); }
		public List<PreprocContext> preproc() {
			return getRuleContexts(PreprocContext.class);
		}
		public PreprocContext preproc(int i) {
			return getRuleContext(PreprocContext.class,i);
		}
		public List<Code_blockContext> code_block() {
			return getRuleContexts(Code_blockContext.class);
		}
		public Code_blockContext code_block(int i) {
			return getRuleContext(Code_blockContext.class,i);
		}
		public Code_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_file; }
	}

	public final Code_fileContext code_file() throws RecognitionException {
		Code_fileContext _localctx = new Code_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(14);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PIFDEFStart:
				case PELSEStart:
				case PENDIFStart:
					{
					setState(12);
					preproc();
					}
					break;
				case TEXT:
					{
					setState(13);
					code_block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 46L) != 0) );
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Code_blockContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PreprocessorParser.NEWLINE, 0); }
		public List<TerminalNode> TEXT() { return getTokens(PreprocessorParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(PreprocessorParser.TEXT, i);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				match(TEXT);
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(25);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PreprocContext extends ParserRuleContext {
		public PifdefContext pifdef() {
			return getRuleContext(PifdefContext.class,0);
		}
		public PelseContext pelse() {
			return getRuleContext(PelseContext.class,0);
		}
		public PendifContext pendif() {
			return getRuleContext(PendifContext.class,0);
		}
		public PreprocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preproc; }
	}

	public final PreprocContext preproc() throws RecognitionException {
		PreprocContext _localctx = new PreprocContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_preproc);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIFDEFStart:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				pifdef();
				}
				break;
			case PELSEStart:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				pelse();
				}
				break;
			case PENDIFStart:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				pendif();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PifdefContext extends ParserRuleContext {
		public TerminalNode PIFDEFStart() { return getToken(PreprocessorParser.PIFDEFStart, 0); }
		public TerminalNode PIFDEFPEOL() { return getToken(PreprocessorParser.PIFDEFPEOL, 0); }
		public List<TerminalNode> PIFDEFPTEXT() { return getTokens(PreprocessorParser.PIFDEFPTEXT); }
		public TerminalNode PIFDEFPTEXT(int i) {
			return getToken(PreprocessorParser.PIFDEFPTEXT, i);
		}
		public PifdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pifdef; }
	}

	public final PifdefContext pifdef() throws RecognitionException {
		PifdefContext _localctx = new PifdefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pifdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(PIFDEFStart);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				match(PIFDEFPTEXT);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PIFDEFPTEXT );
			setState(38);
			match(PIFDEFPEOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PelseContext extends ParserRuleContext {
		public TerminalNode PELSEStart() { return getToken(PreprocessorParser.PELSEStart, 0); }
		public TerminalNode PELSEPEOL() { return getToken(PreprocessorParser.PELSEPEOL, 0); }
		public PelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pelse; }
	}

	public final PelseContext pelse() throws RecognitionException {
		PelseContext _localctx = new PelseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pelse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(PELSEStart);
			setState(41);
			match(PELSEPEOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PendifContext extends ParserRuleContext {
		public TerminalNode PENDIFStart() { return getToken(PreprocessorParser.PENDIFStart, 0); }
		public TerminalNode PENDIFPEOL() { return getToken(PreprocessorParser.PENDIFPEOL, 0); }
		public PendifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pendif; }
	}

	public final PendifContext pendif() throws RecognitionException {
		PendifContext _localctx = new PendifContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pendif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(PENDIFStart);
			setState(44);
			match(PENDIFPEOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000f/\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0004\u0000\u000f\b\u0000\u000b"+
		"\u0000\f\u0000\u0010\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u0016"+
		"\b\u0001\u000b\u0001\f\u0001\u0017\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0004\u0003#\b\u0003\u000b\u0003\f\u0003$\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0000.\u0000"+
		"\u000e\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004"+
		"\u001e\u0001\u0000\u0000\u0000\u0006 \u0001\u0000\u0000\u0000\b(\u0001"+
		"\u0000\u0000\u0000\n+\u0001\u0000\u0000\u0000\f\u000f\u0003\u0004\u0002"+
		"\u0000\r\u000f\u0003\u0002\u0001\u0000\u000e\f\u0001\u0000\u0000\u0000"+
		"\u000e\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010"+
		"\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011"+
		"\u0012\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0000\u0000\u0001\u0013"+
		"\u0001\u0001\u0000\u0000\u0000\u0014\u0016\u0005\u0005\u0000\u0000\u0015"+
		"\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017"+
		"\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0004\u0000\u0000\u001a"+
		"\u0003\u0001\u0000\u0000\u0000\u001b\u001f\u0003\u0006\u0003\u0000\u001c"+
		"\u001f\u0003\b\u0004\u0000\u001d\u001f\u0003\n\u0005\u0000\u001e\u001b"+
		"\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000 \"\u0005"+
		"\u0001\u0000\u0000!#\u0005\u0006\u0000\u0000\"!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0007\u0000\u0000\'\u0007\u0001"+
		"\u0000\u0000\u0000()\u0005\u0002\u0000\u0000)*\u0005\n\u0000\u0000*\t"+
		"\u0001\u0000\u0000\u0000+,\u0005\u0003\u0000\u0000,-\u0005\r\u0000\u0000"+
		"-\u000b\u0001\u0000\u0000\u0000\u0005\u000e\u0010\u0017\u001e$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}