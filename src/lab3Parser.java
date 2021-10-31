// Generated from C:/Users/lhr4108/Desktop/untitled\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, END=3, IDENTs=4, LPar=5, RPar=6, FUNCTYPE=7, LBrace=8, 
		RBrace=9, RETURN=10, Semicolon=11, Nondigit=12, Nondigit_1=13, NondigitDigit=14, 
		Nonzerodigit=15, Octaldigit=16, Hexadecimaldigit=17, Hexadecimalprefix=18, 
		SL_COMMENT=19, SL_COMMENT_1=20, UnaryOp=21, UnaryOp_1=22, Digit=23, Equal=24, 
		WHITE_SPACE=25;
	public static final int
		RULE_compunit = 0, RULE_funcdef = 1, RULE_block = 2, RULE_blockitem = 3, 
		RULE_stmt = 4, RULE_lval = 5, RULE_exp = 6, RULE_addexp = 7, RULE_mulexp = 8, 
		RULE_unaryexp = 9, RULE_funcRParams = 10, RULE_primaryexp = 11, RULE_number = 12, 
		RULE_decimalconst = 13, RULE_octalconst = 14, RULE_hexadecimalconst = 15, 
		RULE_decl = 16, RULE_constDecl = 17, RULE_bType = 18, RULE_constDef = 19, 
		RULE_constInitVal = 20, RULE_constExp = 21, RULE_varDecl = 22, RULE_varDef = 23, 
		RULE_initVal = 24, RULE_ident = 25, RULE_nondigit = 26, RULE_nondigit_1 = 27, 
		RULE_nondigitDigit = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"compunit", "funcdef", "block", "blockitem", "stmt", "lval", "exp", "addexp", 
			"mulexp", "unaryexp", "funcRParams", "primaryexp", "number", "decimalconst", 
			"octalconst", "hexadecimalconst", "decl", "constDecl", "bType", "constDef", 
			"constInitVal", "constExp", "varDecl", "varDef", "initVal", "ident", 
			"nondigit", "nondigit_1", "nondigitDigit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'const'", "'hello'", "'main'", "'('", "')'", "'int'", "'{'", 
			"'}'", "'return'", "';'", null, null, null, null, null, null, null, null, 
			null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "END", "IDENTs", "LPar", "RPar", "FUNCTYPE", "LBrace", 
			"RBrace", "RETURN", "Semicolon", "Nondigit", "Nondigit_1", "NondigitDigit", 
			"Nonzerodigit", "Octaldigit", "Hexadecimaldigit", "Hexadecimalprefix", 
			"SL_COMMENT", "SL_COMMENT_1", "UnaryOp", "UnaryOp_1", "Digit", "Equal", 
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
	public String getGrammarFileName() { return "lab3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lab3Parser(TokenStream input) {
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
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterCompunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitCompunit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitCompunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompunitContext compunit() throws RecognitionException {
		CompunitContext _localctx = new CompunitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compunit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
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
		public TerminalNode FUNCTYPE() { return getToken(lab3Parser.FUNCTYPE, 0); }
		public TerminalNode IDENTs() { return getToken(lab3Parser.IDENTs, 0); }
		public TerminalNode LPar() { return getToken(lab3Parser.LPar, 0); }
		public TerminalNode RPar() { return getToken(lab3Parser.RPar, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitFuncdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(FUNCTYPE);
			setState(61);
			match(IDENTs);
			setState(62);
			match(LPar);
			setState(63);
			match(RPar);
			setState(64);
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
		public TerminalNode LBrace() { return getToken(lab3Parser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(lab3Parser.RBrace, 0); }
		public List<BlockitemContext> blockitem() {
			return getRuleContexts(BlockitemContext.class);
		}
		public BlockitemContext blockitem(int i) {
			return getRuleContext(BlockitemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(LBrace);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << LPar) | (1L << FUNCTYPE) | (1L << RETURN) | (1L << Nondigit) | (1L << Nondigit_1) | (1L << NondigitDigit) | (1L << Nonzerodigit) | (1L << Octaldigit) | (1L << Hexadecimalprefix) | (1L << UnaryOp))) != 0)) {
				{
				{
				setState(67);
				blockitem();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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

	public static class BlockitemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterBlockitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitBlockitem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitBlockitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockitemContext blockitem() throws RecognitionException {
		BlockitemContext _localctx = new BlockitemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockitem);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case FUNCTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				decl();
				}
				break;
			case LPar:
			case RETURN:
			case Nondigit:
			case Nondigit_1:
			case NondigitDigit:
			case Nonzerodigit:
			case Octaldigit:
			case Hexadecimalprefix:
			case UnaryOp:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				stmt();
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

	public static class StmtContext extends ParserRuleContext {
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode Equal() { return getToken(lab3Parser.Equal, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(lab3Parser.Semicolon, 0); }
		public TerminalNode RETURN() { return getToken(lab3Parser.RETURN, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				lval();
				setState(80);
				match(Equal);
				setState(81);
				exp();
				setState(82);
				match(Semicolon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				exp();
				setState(85);
				match(Semicolon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(RETURN);
				setState(88);
				exp();
				setState(89);
				match(Semicolon);
				}
				break;
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

	public static class LvalContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterLval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitLval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitLval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			ident();
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
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		public List<TerminalNode> UnaryOp() { return getTokens(lab3Parser.UnaryOp); }
		public TerminalNode UnaryOp(int i) {
			return getToken(lab3Parser.UnaryOp, i);
		}
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterAddexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitAddexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		AddexpContext _localctx = new AddexpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addexp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			mulexp();
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(UnaryOp);
					setState(99);
					mulexp();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public List<TerminalNode> UnaryOp_1() { return getTokens(lab3Parser.UnaryOp_1); }
		public TerminalNode UnaryOp_1(int i) {
			return getToken(lab3Parser.UnaryOp_1, i);
		}
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterMulexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitMulexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		MulexpContext _localctx = new MulexpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mulexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			unaryexp();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UnaryOp_1) {
				{
				{
				setState(106);
				match(UnaryOp_1);
				setState(107);
				unaryexp();
				}
				}
				setState(112);
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
		public TerminalNode UnaryOp() { return getToken(lab3Parser.UnaryOp, 0); }
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPar() { return getToken(lab3Parser.LPar, 0); }
		public TerminalNode RPar() { return getToken(lab3Parser.RPar, 0); }
		public List<FuncRParamsContext> funcRParams() {
			return getRuleContexts(FuncRParamsContext.class);
		}
		public FuncRParamsContext funcRParams(int i) {
			return getRuleContext(FuncRParamsContext.class,i);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterUnaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitUnaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryexp);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(UnaryOp);
				setState(115);
				unaryexp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				ident();
				setState(117);
				match(LPar);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPar) | (1L << Nondigit) | (1L << Nondigit_1) | (1L << NondigitDigit) | (1L << Nonzerodigit) | (1L << Octaldigit) | (1L << Hexadecimalprefix) | (1L << UnaryOp))) != 0)) {
					{
					{
					setState(118);
					funcRParams();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(RPar);
				}
				break;
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

	public static class FuncRParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncRParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcRParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterFuncRParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitFuncRParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitFuncRParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncRParamsContext funcRParams() throws RecognitionException {
		FuncRParamsContext _localctx = new FuncRParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcRParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			exp();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(129);
				match(T__0);
				setState(130);
				exp();
				}
				}
				setState(135);
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

	public static class PrimaryexpContext extends ParserRuleContext {
		public TerminalNode LPar() { return getToken(lab3Parser.LPar, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPar() { return getToken(lab3Parser.RPar, 0); }
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterPrimaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitPrimaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primaryexp);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPar:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(LPar);
				setState(137);
				exp();
				setState(138);
				match(RPar);
				}
				break;
			case Nondigit:
			case Nondigit_1:
			case NondigitDigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				lval();
				}
				break;
			case Nonzerodigit:
			case Octaldigit:
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
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
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_number);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Nonzerodigit:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				decimalconst();
				}
				break;
			case Octaldigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				octalconst();
				}
				break;
			case Hexadecimalprefix:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
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
		public TerminalNode Nonzerodigit() { return getToken(lab3Parser.Nonzerodigit, 0); }
		public DecimalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterDecimalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitDecimalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitDecimalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalconstContext decimalconst() throws RecognitionException {
		DecimalconstContext _localctx = new DecimalconstContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
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
		public TerminalNode Octaldigit() { return getToken(lab3Parser.Octaldigit, 0); }
		public OctalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterOctalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitOctalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitOctalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OctalconstContext octalconst() throws RecognitionException {
		OctalconstContext _localctx = new OctalconstContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_octalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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
		public TerminalNode Hexadecimalprefix() { return getToken(lab3Parser.Hexadecimalprefix, 0); }
		public HexadecimalconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexadecimalconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterHexadecimalconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitHexadecimalconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitHexadecimalconst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexadecimalconstContext hexadecimalconst() throws RecognitionException {
		HexadecimalconstContext _localctx = new HexadecimalconstContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_hexadecimalconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
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

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_decl);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				constDecl();
				}
				break;
			case FUNCTYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				varDecl();
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode FUNCTYPE() { return getToken(lab3Parser.FUNCTYPE, 0); }
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(lab3Parser.Semicolon, 0); }
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__1);
			setState(160);
			match(FUNCTYPE);
			setState(161);
			constDef();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(162);
				match(T__0);
				setState(163);
				constDef();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
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

	public static class BTypeContext extends ParserRuleContext {
		public TerminalNode FUNCTYPE() { return getToken(lab3Parser.FUNCTYPE, 0); }
		public BTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterBType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitBType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitBType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_bType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(FUNCTYPE);
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

	public static class ConstDefContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode Equal() { return getToken(lab3Parser.Equal, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			ident();
			setState(174);
			match(Equal);
			setState(175);
			constInitVal();
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

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterConstInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitConstInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constInitVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			constExp();
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

	public static class ConstExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterConstExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitConstExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode FUNCTYPE() { return getToken(lab3Parser.FUNCTYPE, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(lab3Parser.Semicolon, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(FUNCTYPE);
			setState(182);
			varDef();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(183);
				match(T__0);
				setState(184);
				varDef();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
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

	public static class VarDefContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode Equal() { return getToken(lab3Parser.Equal, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_varDef);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				ident();
				setState(194);
				match(Equal);
				setState(195);
				initVal();
				}
				break;
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

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_initVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			exp();
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

	public static class IdentContext extends ParserRuleContext {
		public NondigitContext nondigit() {
			return getRuleContext(NondigitContext.class,0);
		}
		public Nondigit_1Context nondigit_1() {
			return getRuleContext(Nondigit_1Context.class,0);
		}
		public NondigitDigitContext nondigitDigit() {
			return getRuleContext(NondigitDigitContext.class,0);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ident);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Nondigit:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				nondigit();
				}
				break;
			case Nondigit_1:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				nondigit_1();
				}
				break;
			case NondigitDigit:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				nondigitDigit();
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

	public static class NondigitContext extends ParserRuleContext {
		public TerminalNode Nondigit() { return getToken(lab3Parser.Nondigit, 0); }
		public NondigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nondigit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterNondigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitNondigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitNondigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NondigitContext nondigit() throws RecognitionException {
		NondigitContext _localctx = new NondigitContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_nondigit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(Nondigit);
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

	public static class Nondigit_1Context extends ParserRuleContext {
		public TerminalNode Nondigit_1() { return getToken(lab3Parser.Nondigit_1, 0); }
		public Nondigit_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nondigit_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterNondigit_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitNondigit_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitNondigit_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nondigit_1Context nondigit_1() throws RecognitionException {
		Nondigit_1Context _localctx = new Nondigit_1Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_nondigit_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(Nondigit_1);
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

	public static class NondigitDigitContext extends ParserRuleContext {
		public TerminalNode NondigitDigit() { return getToken(lab3Parser.NondigitDigit, 0); }
		public NondigitDigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nondigitDigit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterNondigitDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitNondigitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitNondigitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NondigitDigitContext nondigitDigit() throws RecognitionException {
		NondigitDigitContext _localctx = new NondigitDigitContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nondigitDigit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(NondigitDigit);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00d7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\5\3\5\5\5P\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\n\3\n\3\n\7\no\n\n\f\n\16\n"+
		"r\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13z\n\13\f\13\16\13}\13\13\3\13"+
		"\3\13\5\13\u0081\n\13\3\f\3\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u0091\n\r\3\16\3\16\3\16\5\16\u0096\n\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\5\22\u00a0\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00a7\n\23\f\23\16\23\u00aa\13\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00bc"+
		"\n\30\f\30\16\30\u00bf\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00c8"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\5\33\u00cf\n\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:\2\2\2\u00cd\2<\3\2\2\2\4>\3\2\2\2\6D\3\2\2\2\bO\3\2\2\2\n]\3"+
		"\2\2\2\f_\3\2\2\2\16a\3\2\2\2\20c\3\2\2\2\22k\3\2\2\2\24\u0080\3\2\2\2"+
		"\26\u0082\3\2\2\2\30\u0090\3\2\2\2\32\u0095\3\2\2\2\34\u0097\3\2\2\2\36"+
		"\u0099\3\2\2\2 \u009b\3\2\2\2\"\u009f\3\2\2\2$\u00a1\3\2\2\2&\u00ad\3"+
		"\2\2\2(\u00af\3\2\2\2*\u00b3\3\2\2\2,\u00b5\3\2\2\2.\u00b7\3\2\2\2\60"+
		"\u00c7\3\2\2\2\62\u00c9\3\2\2\2\64\u00ce\3\2\2\2\66\u00d0\3\2\2\28\u00d2"+
		"\3\2\2\2:\u00d4\3\2\2\2<=\5\4\3\2=\3\3\2\2\2>?\7\t\2\2?@\7\6\2\2@A\7\7"+
		"\2\2AB\7\b\2\2BC\5\6\4\2C\5\3\2\2\2DH\7\n\2\2EG\5\b\5\2FE\3\2\2\2GJ\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\13\2\2L\7\3\2\2\2M"+
		"P\5\"\22\2NP\5\n\6\2OM\3\2\2\2ON\3\2\2\2P\t\3\2\2\2QR\5\f\7\2RS\7\32\2"+
		"\2ST\5\16\b\2TU\7\r\2\2U^\3\2\2\2VW\5\16\b\2WX\7\r\2\2X^\3\2\2\2YZ\7\f"+
		"\2\2Z[\5\16\b\2[\\\7\r\2\2\\^\3\2\2\2]Q\3\2\2\2]V\3\2\2\2]Y\3\2\2\2^\13"+
		"\3\2\2\2_`\5\64\33\2`\r\3\2\2\2ab\5\20\t\2b\17\3\2\2\2ch\5\22\n\2de\7"+
		"\27\2\2eg\5\22\n\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\21\3\2\2\2"+
		"jh\3\2\2\2kp\5\24\13\2lm\7\30\2\2mo\5\24\13\2nl\3\2\2\2or\3\2\2\2pn\3"+
		"\2\2\2pq\3\2\2\2q\23\3\2\2\2rp\3\2\2\2s\u0081\5\30\r\2tu\7\27\2\2u\u0081"+
		"\5\24\13\2vw\5\64\33\2w{\7\7\2\2xz\5\26\f\2yx\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\b\2\2\177\u0081\3\2\2\2\u0080"+
		"s\3\2\2\2\u0080t\3\2\2\2\u0080v\3\2\2\2\u0081\25\3\2\2\2\u0082\u0087\5"+
		"\16\b\2\u0083\u0084\7\3\2\2\u0084\u0086\5\16\b\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\27\3\2\2"+
		"\2\u0089\u0087\3\2\2\2\u008a\u008b\7\7\2\2\u008b\u008c\5\16\b\2\u008c"+
		"\u008d\7\b\2\2\u008d\u0091\3\2\2\2\u008e\u0091\5\f\7\2\u008f\u0091\5\32"+
		"\16\2\u0090\u008a\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\31\3\2\2\2\u0092\u0096\5\34\17\2\u0093\u0096\5\36\20\2\u0094\u0096\5"+
		" \21\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\33\3\2\2\2\u0097\u0098\7\21\2\2\u0098\35\3\2\2\2\u0099\u009a\7\22\2\2"+
		"\u009a\37\3\2\2\2\u009b\u009c\7\24\2\2\u009c!\3\2\2\2\u009d\u00a0\5$\23"+
		"\2\u009e\u00a0\5.\30\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0#"+
		"\3\2\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a8\5(\25\2\u00a4"+
		"\u00a5\7\3\2\2\u00a5\u00a7\5(\25\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7\r\2\2\u00ac%\3\2\2\2\u00ad\u00ae\7\t\2\2"+
		"\u00ae\'\3\2\2\2\u00af\u00b0\5\64\33\2\u00b0\u00b1\7\32\2\2\u00b1\u00b2"+
		"\5*\26\2\u00b2)\3\2\2\2\u00b3\u00b4\5,\27\2\u00b4+\3\2\2\2\u00b5\u00b6"+
		"\5\20\t\2\u00b6-\3\2\2\2\u00b7\u00b8\7\t\2\2\u00b8\u00bd\5\60\31\2\u00b9"+
		"\u00ba\7\3\2\2\u00ba\u00bc\5\60\31\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c1\7\r\2\2\u00c1/\3\2\2\2\u00c2\u00c8\5\64\33"+
		"\2\u00c3\u00c4\5\64\33\2\u00c4\u00c5\7\32\2\2\u00c5\u00c6\5\62\32\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\61\3\2\2"+
		"\2\u00c9\u00ca\5\16\b\2\u00ca\63\3\2\2\2\u00cb\u00cf\5\66\34\2\u00cc\u00cf"+
		"\58\35\2\u00cd\u00cf\5:\36\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\65\3\2\2\2\u00d0\u00d1\7\16\2\2\u00d1\67\3\2\2\2"+
		"\u00d2\u00d3\7\17\2\2\u00d39\3\2\2\2\u00d4\u00d5\7\20\2\2\u00d5;\3\2\2"+
		"\2\21HO]hp{\u0080\u0087\u0090\u0095\u009f\u00a8\u00bd\u00c7\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}