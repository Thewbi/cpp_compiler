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
		NEWLINE=1, TEXT=2, PIFDEFStart=3, PELSEStart=4, PENDIFStart=5, PINCLUDEStart=6, 
		PINCLUDEPTEXT=7, PINCLUDEPEOL=8, PINCLUDEPWS=9, PINCLUDEPCMT=10, PIFDEFPTEXT=11, 
		PIFDEFPEOL=12, PIFDEFPWS=13, PIFDEFPCMT=14, PELSEPEOL=15, PELSEPWS=16, 
		PELSEPCMT=17, PENDIFPEOL=18, PENDIFPWS=19, PENDIFPCMT=20;
	public static final int
		RULE_code_file = 0, RULE_code_block = 1, RULE_preproc = 2, RULE_pifdef = 3, 
		RULE_pelse = 4, RULE_pendif = 5, RULE_pinclude = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"code_file", "code_block", "preproc", "pifdef", "pelse", "pendif", "pinclude"
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
		public List<TerminalNode> NEWLINE() { return getTokens(PreprocessorParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PreprocessorParser.NEWLINE, i);
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(17);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PIFDEFStart:
				case PELSEStart:
				case PENDIFStart:
				case PINCLUDEStart:
					{
					setState(14);
					preproc();
					}
					break;
				case TEXT:
					{
					setState(15);
					code_block();
					}
					break;
				case NEWLINE:
					{
					setState(16);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 126L) != 0) );
			setState(21);
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
		public TerminalNode EOF() { return getToken(PreprocessorParser.EOF, 0); }
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
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				match(TEXT);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(28);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		public PincludeContext pinclude() {
			return getRuleContext(PincludeContext.class,0);
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
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIFDEFStart:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				pifdef();
				}
				break;
			case PELSEStart:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				pelse();
				}
				break;
			case PENDIFStart:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				pendif();
				}
				break;
			case PINCLUDEStart:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				pinclude();
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
			setState(36);
			match(PIFDEFStart);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				match(PIFDEFPTEXT);
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PIFDEFPTEXT );
			setState(42);
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
			setState(44);
			match(PELSEStart);
			setState(45);
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
			setState(47);
			match(PENDIFStart);
			setState(48);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PincludeContext extends ParserRuleContext {
		public TerminalNode PINCLUDEStart() { return getToken(PreprocessorParser.PINCLUDEStart, 0); }
		public TerminalNode PINCLUDEPEOL() { return getToken(PreprocessorParser.PINCLUDEPEOL, 0); }
		public List<TerminalNode> PINCLUDEPTEXT() { return getTokens(PreprocessorParser.PINCLUDEPTEXT); }
		public TerminalNode PINCLUDEPTEXT(int i) {
			return getToken(PreprocessorParser.PINCLUDEPTEXT, i);
		}
		public PincludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinclude; }
	}

	public final PincludeContext pinclude() throws RecognitionException {
		PincludeContext _localctx = new PincludeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pinclude);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(PINCLUDEStart);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				match(PINCLUDEPTEXT);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PINCLUDEPTEXT );
			setState(56);
			match(PINCLUDEPEOL);
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
		"\u0004\u0001\u0014;\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u0001\u0019\b\u0001\u000b\u0001\f\u0001"+
		"\u001a\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002#\b\u0002\u0001\u0003\u0001\u0003\u0004\u0003\'\b\u0003"+
		"\u000b\u0003\f\u0003(\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0004\u00065\b\u0006\u000b\u0006\f\u00066\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0001\u0001"+
		"\u0001\u0001\u0001<\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0018\u0001"+
		"\u0000\u0000\u0000\u0004\"\u0001\u0000\u0000\u0000\u0006$\u0001\u0000"+
		"\u0000\u0000\b,\u0001\u0000\u0000\u0000\n/\u0001\u0000\u0000\u0000\f2"+
		"\u0001\u0000\u0000\u0000\u000e\u0012\u0003\u0004\u0002\u0000\u000f\u0012"+
		"\u0003\u0002\u0001\u0000\u0010\u0012\u0005\u0001\u0000\u0000\u0011\u000e"+
		"\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0011"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001"+
		"\u0001\u0000\u0000\u0000\u0017\u0019\u0005\u0002\u0000\u0000\u0018\u0017"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0018"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0007\u0000\u0000\u0000\u001d\u0003"+
		"\u0001\u0000\u0000\u0000\u001e#\u0003\u0006\u0003\u0000\u001f#\u0003\b"+
		"\u0004\u0000 #\u0003\n\u0005\u0000!#\u0003\f\u0006\u0000\"\u001e\u0001"+
		"\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000"+
		"\u0000\"!\u0001\u0000\u0000\u0000#\u0005\u0001\u0000\u0000\u0000$&\u0005"+
		"\u0003\u0000\u0000%\'\u0005\u000b\u0000\u0000&%\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*+\u0005\f\u0000\u0000+\u0007\u0001\u0000"+
		"\u0000\u0000,-\u0005\u0004\u0000\u0000-.\u0005\u000f\u0000\u0000.\t\u0001"+
		"\u0000\u0000\u0000/0\u0005\u0005\u0000\u000001\u0005\u0012\u0000\u0000"+
		"1\u000b\u0001\u0000\u0000\u000024\u0005\u0006\u0000\u000035\u0005\u0007"+
		"\u0000\u000043\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u0000"+
		"89\u0005\b\u0000\u00009\r\u0001\u0000\u0000\u0000\u0006\u0011\u0013\u001a"+
		"\"(6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}