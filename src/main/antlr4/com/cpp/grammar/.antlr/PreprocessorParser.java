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
		NormalWhitespace=1, NormalIdentifier=2, Hashtag=3, Greater=4, Less=5, 
		Else_PCmd=6, Elif_PCmd=7, If_PCmd=8, Endif_PCmd=9, Include_PCmd=10, NewLine=11, 
		Whitespace=12, LineComment=13, BlockComment=14, StringLiteral=15, UnterminatedStringLiteral=16, 
		TriStringLiteral=17, Number=18, Identifier=19;
	public static final int
		RULE_rows = 0, RULE_normal_row = 1, RULE_preproc_row = 2, RULE_expression = 3, 
		RULE_preprocessor_command = 4, RULE_if_pcmd = 5, RULE_endif_pcmd = 6, 
		RULE_include_pcmd = 7, RULE_lineComment = 8, RULE_blockComment = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"rows", "normal_row", "preproc_row", "expression", "preprocessor_command", 
			"if_pcmd", "endif_pcmd", "include_pcmd", "lineComment", "blockComment"
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
	public static class RowsContext extends ParserRuleContext {
		public List<Preproc_rowContext> preproc_row() {
			return getRuleContexts(Preproc_rowContext.class);
		}
		public Preproc_rowContext preproc_row(int i) {
			return getRuleContext(Preproc_rowContext.class,i);
		}
		public List<Normal_rowContext> normal_row() {
			return getRuleContexts(Normal_rowContext.class);
		}
		public Normal_rowContext normal_row(int i) {
			return getRuleContext(Normal_rowContext.class,i);
		}
		public List<TerminalNode> NewLine() { return getTokens(PreprocessorParser.NewLine); }
		public TerminalNode NewLine(int i) {
			return getToken(PreprocessorParser.NewLine, i);
		}
		public RowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rows; }
	}

	public final RowsContext rows() throws RecognitionException {
		RowsContext _localctx = new RowsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2062L) != 0)) {
				{
				setState(23);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Hashtag:
					{
					setState(20);
					preproc_row();
					}
					break;
				case NormalWhitespace:
				case NormalIdentifier:
					{
					setState(21);
					normal_row();
					}
					break;
				case NewLine:
					{
					setState(22);
					match(NewLine);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Normal_rowContext extends ParserRuleContext {
		public List<TerminalNode> NormalIdentifier() { return getTokens(PreprocessorParser.NormalIdentifier); }
		public TerminalNode NormalIdentifier(int i) {
			return getToken(PreprocessorParser.NormalIdentifier, i);
		}
		public List<TerminalNode> NormalWhitespace() { return getTokens(PreprocessorParser.NormalWhitespace); }
		public TerminalNode NormalWhitespace(int i) {
			return getToken(PreprocessorParser.NormalWhitespace, i);
		}
		public Normal_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_row; }
	}

	public final Normal_rowContext normal_row() throws RecognitionException {
		Normal_rowContext _localctx = new Normal_rowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_normal_row);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(28);
					_la = _input.LA(1);
					if ( !(_la==NormalWhitespace || _la==NormalIdentifier) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(31); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class Preproc_rowContext extends ParserRuleContext {
		public TerminalNode Hashtag() { return getToken(PreprocessorParser.Hashtag, 0); }
		public Preprocessor_commandContext preprocessor_command() {
			return getRuleContext(Preprocessor_commandContext.class,0);
		}
		public TerminalNode NewLine() { return getToken(PreprocessorParser.NewLine, 0); }
		public TerminalNode EOF() { return getToken(PreprocessorParser.EOF, 0); }
		public Preproc_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preproc_row; }
	}

	public final Preproc_rowContext preproc_row() throws RecognitionException {
		Preproc_rowContext _localctx = new Preproc_rowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_preproc_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(Hashtag);
			setState(34);
			preprocessor_command();
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NewLine) ) {
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(PreprocessorParser.Number, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Greater() { return getToken(PreprocessorParser.Greater, 0); }
		public TerminalNode Less() { return getToken(PreprocessorParser.Less, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(38);
			match(Number);
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(40);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(41);
						match(Greater);
						setState(42);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(43);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(44);
						match(Less);
						setState(45);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Preprocessor_commandContext extends ParserRuleContext {
		public If_pcmdContext if_pcmd() {
			return getRuleContext(If_pcmdContext.class,0);
		}
		public Endif_pcmdContext endif_pcmd() {
			return getRuleContext(Endif_pcmdContext.class,0);
		}
		public Include_pcmdContext include_pcmd() {
			return getRuleContext(Include_pcmdContext.class,0);
		}
		public Preprocessor_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessor_command; }
	}

	public final Preprocessor_commandContext preprocessor_command() throws RecognitionException {
		Preprocessor_commandContext _localctx = new Preprocessor_commandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_preprocessor_command);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If_PCmd:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				if_pcmd();
				}
				break;
			case Endif_PCmd:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				endif_pcmd();
				}
				break;
			case Include_PCmd:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				include_pcmd();
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
	public static class If_pcmdContext extends ParserRuleContext {
		public TerminalNode If_PCmd() { return getToken(PreprocessorParser.If_PCmd, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public If_pcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_pcmd; }
	}

	public final If_pcmdContext if_pcmd() throws RecognitionException {
		If_pcmdContext _localctx = new If_pcmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_pcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(If_PCmd);
			setState(57);
			expression(0);
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
	public static class Endif_pcmdContext extends ParserRuleContext {
		public TerminalNode Endif_PCmd() { return getToken(PreprocessorParser.Endif_PCmd, 0); }
		public Endif_pcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endif_pcmd; }
	}

	public final Endif_pcmdContext endif_pcmd() throws RecognitionException {
		Endif_pcmdContext _localctx = new Endif_pcmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_endif_pcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(Endif_PCmd);
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
	public static class Include_pcmdContext extends ParserRuleContext {
		public TerminalNode Include_PCmd() { return getToken(PreprocessorParser.Include_PCmd, 0); }
		public TerminalNode StringLiteral() { return getToken(PreprocessorParser.StringLiteral, 0); }
		public TerminalNode TriStringLiteral() { return getToken(PreprocessorParser.TriStringLiteral, 0); }
		public Include_pcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_pcmd; }
	}

	public final Include_pcmdContext include_pcmd() throws RecognitionException {
		Include_pcmdContext _localctx = new Include_pcmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_include_pcmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(Include_PCmd);
			setState(62);
			_la = _input.LA(1);
			if ( !(_la==StringLiteral || _la==TriStringLiteral) ) {
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
	public static class LineCommentContext extends ParserRuleContext {
		public TerminalNode LineComment() { return getToken(PreprocessorParser.LineComment, 0); }
		public LineCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineComment; }
	}

	public final LineCommentContext lineComment() throws RecognitionException {
		LineCommentContext _localctx = new LineCommentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lineComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(LineComment);
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
	public static class BlockCommentContext extends ParserRuleContext {
		public TerminalNode BlockComment() { return getToken(PreprocessorParser.BlockComment, 0); }
		public BlockCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockComment; }
	}

	public final BlockCommentContext blockComment() throws RecognitionException {
		BlockCommentContext _localctx = new BlockCommentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(BlockComment);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013E\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0004\u0001\u001e"+
		"\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003/\b\u0003"+
		"\n\u0003\f\u00032\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"7\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0000\u0001\u0006\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0000\u0003\u0001\u0000\u0001\u0002\u0001\u0001\u000b\u000b\u0002\u0000"+
		"\u000f\u000f\u0011\u0011B\u0000\u0019\u0001\u0000\u0000\u0000\u0002\u001d"+
		"\u0001\u0000\u0000\u0000\u0004!\u0001\u0000\u0000\u0000\u0006%\u0001\u0000"+
		"\u0000\u0000\b6\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\f;"+
		"\u0001\u0000\u0000\u0000\u000e=\u0001\u0000\u0000\u0000\u0010@\u0001\u0000"+
		"\u0000\u0000\u0012B\u0001\u0000\u0000\u0000\u0014\u0018\u0003\u0004\u0002"+
		"\u0000\u0015\u0018\u0003\u0002\u0001\u0000\u0016\u0018\u0005\u000b\u0000"+
		"\u0000\u0017\u0014\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000"+
		"\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000"+
		"\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000"+
		"\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000"+
		"\u0000\u001c\u001e\u0007\u0000\u0000\u0000\u001d\u001c\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000\u001f \u0001\u0000\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!"+
		"\"\u0005\u0003\u0000\u0000\"#\u0003\b\u0004\u0000#$\u0007\u0001\u0000"+
		"\u0000$\u0005\u0001\u0000\u0000\u0000%&\u0006\u0003\uffff\uffff\u0000"+
		"&\'\u0005\u0012\u0000\u0000\'0\u0001\u0000\u0000\u0000()\n\u0003\u0000"+
		"\u0000)*\u0005\u0004\u0000\u0000*/\u0003\u0006\u0003\u0004+,\n\u0002\u0000"+
		"\u0000,-\u0005\u0005\u0000\u0000-/\u0003\u0006\u0003\u0003.(\u0001\u0000"+
		"\u0000\u0000.+\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0007\u0001\u0000\u0000"+
		"\u000020\u0001\u0000\u0000\u000037\u0003\n\u0005\u000047\u0003\f\u0006"+
		"\u000057\u0003\u000e\u0007\u000063\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000065\u0001\u0000\u0000\u00007\t\u0001\u0000\u0000\u000089\u0005"+
		"\b\u0000\u00009:\u0003\u0006\u0003\u0000:\u000b\u0001\u0000\u0000\u0000"+
		";<\u0005\t\u0000\u0000<\r\u0001\u0000\u0000\u0000=>\u0005\n\u0000\u0000"+
		">?\u0007\u0002\u0000\u0000?\u000f\u0001\u0000\u0000\u0000@A\u0005\r\u0000"+
		"\u0000A\u0011\u0001\u0000\u0000\u0000BC\u0005\u000e\u0000\u0000C\u0013"+
		"\u0001\u0000\u0000\u0000\u0006\u0017\u0019\u001f.06";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}