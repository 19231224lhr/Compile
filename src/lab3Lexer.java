// Generated from C:/Users/lhr4108/Desktop/untitled\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab3Lexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "END", "IDENTs", "LPar", "RPar", "FUNCTYPE", "LBrace", 
			"RBrace", "RETURN", "Semicolon", "Nondigit", "Nondigit_1", "NondigitDigit", 
			"Nonzerodigit", "Octaldigit", "Hexadecimaldigit", "Hexadecimalprefix", 
			"SL_COMMENT", "SL_COMMENT_1", "UnaryOp", "UnaryOp_1", "Digit", "Equal", 
			"WHITE_SPACE"
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


	public lab3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lab3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00b5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16a\n\16\r"+
		"\16\16\16b\3\17\3\17\7\17g\n\17\f\17\16\17j\13\17\3\17\3\17\3\20\3\20"+
		"\7\20p\n\20\f\20\16\20s\13\20\3\20\5\20v\n\20\3\21\3\21\6\21z\n\21\r\21"+
		"\16\21{\3\22\6\22\177\n\22\r\22\16\22\u0080\3\23\3\23\3\23\3\23\5\23\u0087"+
		"\n\23\3\23\6\23\u008a\n\23\r\23\16\23\u008b\3\24\3\24\3\24\3\24\7\24\u0092"+
		"\n\24\f\24\16\24\u0095\13\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\7\25\u00a0\n\25\f\25\16\25\u00a3\13\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\4\u0093\u00a1"+
		"\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\f\5\2C\\aa"+
		"c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2\62\62\3\2\629\5\2\62;CHch\4\2--"+
		"//\5\2\'\',,\61\61\4\2\13\f\"\"\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3"+
		"\65\3\2\2\2\5\67\3\2\2\2\7=\3\2\2\2\tC\3\2\2\2\13H\3\2\2\2\rJ\3\2\2\2"+
		"\17L\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27[\3\2\2\2\31]\3\2\2"+
		"\2\33`\3\2\2\2\35d\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#~\3\2\2\2%\u0086\3\2"+
		"\2\2\'\u008d\3\2\2\2)\u009a\3\2\2\2+\u00a9\3\2\2\2-\u00ab\3\2\2\2/\u00ad"+
		"\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2\65\66\7.\2\2\66\4\3\2\2\2\67"+
		"8\7e\2\289\7q\2\29:\7p\2\2:;\7u\2\2;<\7v\2\2<\6\3\2\2\2=>\7j\2\2>?\7g"+
		"\2\2?@\7n\2\2@A\7n\2\2AB\7q\2\2B\b\3\2\2\2CD\7o\2\2DE\7c\2\2EF\7k\2\2"+
		"FG\7p\2\2G\n\3\2\2\2HI\7*\2\2I\f\3\2\2\2JK\7+\2\2K\16\3\2\2\2LM\7k\2\2"+
		"MN\7p\2\2NO\7v\2\2O\20\3\2\2\2PQ\7}\2\2Q\22\3\2\2\2RS\7\177\2\2S\24\3"+
		"\2\2\2TU\7t\2\2UV\7g\2\2VW\7v\2\2WX\7w\2\2XY\7t\2\2YZ\7p\2\2Z\26\3\2\2"+
		"\2[\\\7=\2\2\\\30\3\2\2\2]^\t\2\2\2^\32\3\2\2\2_a\t\2\2\2`_\3\2\2\2ab"+
		"\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\34\3\2\2\2dh\t\2\2\2eg\t\3\2\2fe\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\t\3\2\2l\36\3\2\2"+
		"\2mq\t\4\2\2np\t\5\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rv\3\2\2"+
		"\2sq\3\2\2\2tv\t\6\2\2um\3\2\2\2ut\3\2\2\2v \3\2\2\2wy\t\6\2\2xz\t\7\2"+
		"\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\"\3\2\2\2}\177\t\b\2\2~}\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081$\3\2"+
		"\2\2\u0082\u0083\7\62\2\2\u0083\u0087\7z\2\2\u0084\u0085\7\62\2\2\u0085"+
		"\u0087\7Z\2\2\u0086\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0089\3\2"+
		"\2\2\u0088\u008a\t\b\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c&\3\2\2\2\u008d\u008e\7\61\2\2"+
		"\u008e\u008f\7\61\2\2\u008f\u0093\3\2\2\2\u0090\u0092\13\2\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\f\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\b\24\2\2\u0099(\3\2\2\2\u009a\u009b\7\61\2\2\u009b\u009c"+
		"\7,\2\2\u009c\u00a1\3\2\2\2\u009d\u00a0\13\2\2\2\u009e\u00a0\7\f\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\7,\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\25"+
		"\2\2\u00a8*\3\2\2\2\u00a9\u00aa\t\t\2\2\u00aa,\3\2\2\2\u00ab\u00ac\t\n"+
		"\2\2\u00ac.\3\2\2\2\u00ad\u00ae\t\5\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7"+
		"?\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\t\13\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\b\32\2\2\u00b4\64\3\2\2\2\16\2bhqu{\u0080\u0086\u008b\u0093\u009f"+
		"\u00a1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}