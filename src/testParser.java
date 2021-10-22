// Generated from C:/Users/lhr4108/Desktop/untitled1/src\test.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		END=1, IDENT=2, LPar=3, RPar=4, FUNCTYPE=5, LBrace=6, RBrace=7, RETURN=8, 
		Semicolon=9, Nonzerodigit=10, Octaldigit=11, Digit=12, Hexadecimaldigit=13, 
		Hexadecimalprefix=14, SL_COMMENT=15, SL_COMMENT_1=16, WHITE_SPACE=17;
	public static final int
		RULE_compunit = 0, RULE_funcdef = 1, RULE_block = 2, RULE_stmt = 3, RULE_number = 4, 
		RULE_decimalconst = 5, RULE_octalconst = 6, RULE_hexadecimalconst = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"compunit", "funcdef", "block", "stmt", "number", "decimalconst", "octalconst", 
			"hexadecimalconst"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'hello'", "'main'", "'('", "')'", "'int'", "'{'", "'}'", "'return'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "END", "IDENT", "LPar", "RPar", "FUNCTYPE", "LBrace", "RBrace", 
			"RETURN", "Semicolon", "Nonzerodigit", "Octaldigit", "Digit", "Hexadecimaldigit", 
			"Hexadecimalprefix", "SL_COMMENT", "SL_COMMENT_1", "WHITE_SPACE"
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
	public String getGrammarFileName() { return "test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public testParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompunitContext extends ParserRuleContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public CompunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterCompunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitCompunit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitCompunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompunitContext compunit() throws RecognitionException {
		CompunitContext _localctx = new CompunitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compunit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			funcdef();
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

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode FUNCTYPE() { return getToken(testParser.FUNCTYPE, 0); }
		public TerminalNode IDENT() { return getToken(testParser.IDENT, 0); }
		public TerminalNode LPar() { return getToken(testParser.LPar, 0); }
		public TerminalNode RPar() { return getToken(testParser.RPar, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitFuncdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(FUNCTYPE);
			setState(19);
			match(IDENT);
			setState(20);
			match(LPar);
			setState(21);
			match(RPar);
			setState(22);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(testParser.LBrace, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(testParser.RBrace, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(LBrace);
			setState(25);
			stmt();
			setState(26);
			match(RBrace);
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

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(testParser.RETURN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(testParser.Semicolon, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(RETURN);
			setState(29);
			number();
			setState(30);
			match(Semicolon);
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

	public static class NumberContext extends ParserRuleContext {
		public DecimalconstContext decimalconst() {
			return getRuleContext(DecimalconstContext.class,0);
		}
		public OctalconstContext octalconst() {
			return getRuleContext(OctalconstContext.class,0);
		}
		public HexadecimalconstContext hexadecimalconst() {
			return getRuleContext(HexadecimalconstContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_number);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Nonzerodigit:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				decimalconst();
				}
				break;
			case Octaldigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				octalconst();
				}
				break;
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				hexadecimalconst();
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

	public static class DecimalconstContext extends ParserRuleContext {
		public TerminalNode Nonzerodigit() { return getToken(testParser.Nonzerodigit, 0); }
		public DecimalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterDecimalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitDecimalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitDecimalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalconstContext decimalconst() throws RecognitionException {
		DecimalconstContext _localctx = new DecimalconstContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(Nonzerodigit);
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

	public static class OctalconstContext extends ParserRuleContext {
		public TerminalNode Octaldigit() { return getToken(testParser.Octaldigit, 0); }
		public OctalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterOctalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitOctalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitOctalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OctalconstContext octalconst() throws RecognitionException {
		OctalconstContext _localctx = new OctalconstContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_octalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(Octaldigit);
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

	public static class HexadecimalconstContext extends ParserRuleContext {
		public TerminalNode Hexadecimalprefix() { return getToken(testParser.Hexadecimalprefix, 0); }
		public HexadecimalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexadecimalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterHexadecimalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitHexadecimalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitHexadecimalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexadecimalconstContext hexadecimalconst() throws RecognitionException {
		HexadecimalconstContext _localctx = new HexadecimalconstContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_hexadecimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(Hexadecimalprefix);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23.\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6&\n\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2\'\2\22\3\2\2\2"+
		"\4\24\3\2\2\2\6\32\3\2\2\2\b\36\3\2\2\2\n%\3\2\2\2\f\'\3\2\2\2\16)\3\2"+
		"\2\2\20+\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2\2\24\25\7\7\2\2\25\26\7\4\2"+
		"\2\26\27\7\5\2\2\27\30\7\6\2\2\30\31\5\6\4\2\31\5\3\2\2\2\32\33\7\b\2"+
		"\2\33\34\5\b\5\2\34\35\7\t\2\2\35\7\3\2\2\2\36\37\7\n\2\2\37 \5\n\6\2"+
		" !\7\13\2\2!\t\3\2\2\2\"&\5\f\7\2#&\5\16\b\2$&\5\20\t\2%\"\3\2\2\2%#\3"+
		"\2\2\2%$\3\2\2\2&\13\3\2\2\2\'(\7\f\2\2(\r\3\2\2\2)*\7\r\2\2*\17\3\2\2"+
		"\2+,\7\20\2\2,\21\3\2\2\2\3%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}