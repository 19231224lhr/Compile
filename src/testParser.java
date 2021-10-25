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
		Semicolon=9, Nonzerodigit=10, Octaldigit=11, Hexadecimaldigit=12, Hexadecimalprefix=13, 
		SL_COMMENT=14, SL_COMMENT_1=15, UnaryOp=16, UnaryOp_1=17, WHITE_SPACE=18;
	public static final int
		RULE_compunit = 0, RULE_funcdef = 1, RULE_block = 2, RULE_stmt = 3, RULE_exp = 4, 
		RULE_addexp = 5, RULE_mulexp = 6, RULE_unaryexp = 7, RULE_primaryexp = 8, 
		RULE_number = 9, RULE_decimalconst = 10, RULE_octalconst = 11, RULE_hexadecimalconst = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"compunit", "funcdef", "block", "stmt", "exp", "addexp", "mulexp", "unaryexp", 
			"primaryexp", "number", "decimalconst", "octalconst", "hexadecimalconst"
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
			"RETURN", "Semicolon", "Nonzerodigit", "Octaldigit", "Hexadecimaldigit", 
			"Hexadecimalprefix", "SL_COMMENT", "SL_COMMENT_1", "UnaryOp", "UnaryOp_1", 
			"WHITE_SPACE"
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
			setState(26);
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
			setState(28);
			match(FUNCTYPE);
			setState(29);
			match(IDENT);
			setState(30);
			match(LPar);
			setState(31);
			match(RPar);
			setState(32);
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
			setState(34);
			match(LBrace);
			setState(35);
			stmt();
			setState(36);
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
			setState(38);
			match(RETURN);
			setState(39);
			exp();
			setState(40);
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

	public static class ExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			addexp();
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

	public static class AddexpContext extends ParserRuleContext {
		public List<MulexpContext> mulexp() {
			return getRuleContexts(MulexpContext.class);
		}
		public MulexpContext mulexp(int i) {
			return getRuleContext(MulexpContext.class,i);
		}
		public List<TerminalNode> UnaryOp() { return getTokens(testParser.UnaryOp); }
		public TerminalNode UnaryOp(int i) {
			return getToken(testParser.UnaryOp, i);
		}
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterAddexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitAddexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		AddexpContext _localctx = new AddexpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_addexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			mulexp();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UnaryOp) {
				{
				{
				setState(45);
				match(UnaryOp);
				setState(46);
				mulexp();
				}
				}
				setState(51);
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

	public static class MulexpContext extends ParserRuleContext {
		public List<UnaryexpContext> unaryexp() {
			return getRuleContexts(UnaryexpContext.class);
		}
		public UnaryexpContext unaryexp(int i) {
			return getRuleContext(UnaryexpContext.class,i);
		}
		public List<TerminalNode> UnaryOp_1() { return getTokens(testParser.UnaryOp_1); }
		public TerminalNode UnaryOp_1(int i) {
			return getToken(testParser.UnaryOp_1, i);
		}
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterMulexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitMulexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		MulexpContext _localctx = new MulexpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mulexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			unaryexp();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UnaryOp_1) {
				{
				{
				setState(53);
				match(UnaryOp_1);
				setState(54);
				unaryexp();
				}
				}
				setState(59);
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

	public static class UnaryexpContext extends ParserRuleContext {
		public PrimaryexpContext primaryexp() {
			return getRuleContext(PrimaryexpContext.class,0);
		}
		public TerminalNode UnaryOp() { return getToken(testParser.UnaryOp, 0); }
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterUnaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitUnaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryexp);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPar:
			case Nonzerodigit:
			case Octaldigit:
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				primaryexp();
				}
				break;
			case UnaryOp:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(UnaryOp);
				setState(62);
				unaryexp();
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

	public static class PrimaryexpContext extends ParserRuleContext {
		public TerminalNode LPar() { return getToken(testParser.LPar, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPar() { return getToken(testParser.RPar, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterPrimaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitPrimaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof testVisitor ) return ((testVisitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primaryexp);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPar:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(LPar);
				setState(66);
				exp();
				setState(67);
				match(RPar);
				}
				break;
			case Nonzerodigit:
			case Octaldigit:
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				number();
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
		enterRule(_localctx, 18, RULE_number);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Nonzerodigit:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				decimalconst();
				}
				break;
			case Octaldigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				octalconst();
				}
				break;
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
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
		enterRule(_localctx, 20, RULE_decimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		enterRule(_localctx, 22, RULE_octalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
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
		enterRule(_localctx, 24, RULE_hexadecimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24V\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7\62\n\7\f\7\16\7\65\13\7\3\b"+
		"\3\b\3\b\7\b:\n\b\f\b\16\b=\13\b\3\t\3\t\3\t\5\tB\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\nI\n\n\3\13\3\13\3\13\5\13N\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\2N\2\34\3\2\2\2\4\36\3\2"+
		"\2\2\6$\3\2\2\2\b(\3\2\2\2\n,\3\2\2\2\f.\3\2\2\2\16\66\3\2\2\2\20A\3\2"+
		"\2\2\22H\3\2\2\2\24M\3\2\2\2\26O\3\2\2\2\30Q\3\2\2\2\32S\3\2\2\2\34\35"+
		"\5\4\3\2\35\3\3\2\2\2\36\37\7\7\2\2\37 \7\4\2\2 !\7\5\2\2!\"\7\6\2\2\""+
		"#\5\6\4\2#\5\3\2\2\2$%\7\b\2\2%&\5\b\5\2&\'\7\t\2\2\'\7\3\2\2\2()\7\n"+
		"\2\2)*\5\n\6\2*+\7\13\2\2+\t\3\2\2\2,-\5\f\7\2-\13\3\2\2\2.\63\5\16\b"+
		"\2/\60\7\22\2\2\60\62\5\16\b\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\r\3\2\2\2\65\63\3\2\2\2\66;\5\20\t\2\678\7\23\2\28:"+
		"\5\20\t\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\17\3\2\2\2=;\3\2"+
		"\2\2>B\5\22\n\2?@\7\22\2\2@B\5\20\t\2A>\3\2\2\2A?\3\2\2\2B\21\3\2\2\2"+
		"CD\7\5\2\2DE\5\n\6\2EF\7\6\2\2FI\3\2\2\2GI\5\24\13\2HC\3\2\2\2HG\3\2\2"+
		"\2I\23\3\2\2\2JN\5\26\f\2KN\5\30\r\2LN\5\32\16\2MJ\3\2\2\2MK\3\2\2\2M"+
		"L\3\2\2\2N\25\3\2\2\2OP\7\f\2\2P\27\3\2\2\2QR\7\r\2\2R\31\3\2\2\2ST\7"+
		"\17\2\2T\33\3\2\2\2\7\63;AHM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}