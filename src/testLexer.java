// Generated from C:/Users/lhr4108/Desktop/untitled1/src\test.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		END=1, IDENT=2, LPar=3, RPar=4, FUNCTYPE=5, LBrace=6, RBrace=7, RETURN=8, 
		Semicolon=9, Nonzerodigit=10, Octaldigit=11, Digit=12, Hexadecimaldigit=13, 
		Hexadecimalprefix=14, SL_COMMENT=15, SL_COMMENT_1=16, WHITE_SPACE=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"END", "IDENT", "LPar", "RPar", "FUNCTYPE", "LBrace", "RBrace", "RETURN", 
			"Semicolon", "Nonzerodigit", "Octaldigit", "Digit", "Hexadecimaldigit", 
			"Hexadecimalprefix", "SL_COMMENT", "SL_COMMENT_1", "WHITE_SPACE"
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


	public testLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "test.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\7\13H\n\13\f\13\16\13K\13\13\3\f\3\f\6\fO\n\f\r\f\16\fP\3\r\7\r"+
		"T\n\r\f\r\16\rW\13\r\3\16\6\16Z\n\16\r\16\16\16[\3\17\3\17\3\17\3\17\5"+
		"\17b\n\17\3\17\6\17e\n\17\r\17\16\17f\3\20\3\20\3\20\3\20\7\20m\n\20\f"+
		"\20\16\20p\13\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21{\n"+
		"\21\f\21\16\21~\13\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\4n"+
		"|\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23\3\2\b\3\2\63;\3\2\62;\3\2\62\62\3\2\629\5\2\62;C"+
		"Hch\4\2\13\f\"\"\2\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5+\3\2\2\2\7\60\3\2\2\2\t\62\3\2"+
		"\2\2\13\64\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21<\3\2\2\2\23C\3\2\2\2\25E"+
		"\3\2\2\2\27L\3\2\2\2\31U\3\2\2\2\33Y\3\2\2\2\35a\3\2\2\2\37h\3\2\2\2!"+
		"u\3\2\2\2#\u0084\3\2\2\2%&\7j\2\2&\'\7g\2\2\'(\7n\2\2()\7n\2\2)*\7q\2"+
		"\2*\4\3\2\2\2+,\7o\2\2,-\7c\2\2-.\7k\2\2./\7p\2\2/\6\3\2\2\2\60\61\7*"+
		"\2\2\61\b\3\2\2\2\62\63\7+\2\2\63\n\3\2\2\2\64\65\7k\2\2\65\66\7p\2\2"+
		"\66\67\7v\2\2\67\f\3\2\2\289\7}\2\29\16\3\2\2\2:;\7\177\2\2;\20\3\2\2"+
		"\2<=\7t\2\2=>\7g\2\2>?\7v\2\2?@\7w\2\2@A\7t\2\2AB\7p\2\2B\22\3\2\2\2C"+
		"D\7=\2\2D\24\3\2\2\2EI\t\2\2\2FH\t\3\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2J\26\3\2\2\2KI\3\2\2\2LN\t\4\2\2MO\t\5\2\2NM\3\2\2\2OP\3\2\2"+
		"\2PN\3\2\2\2PQ\3\2\2\2Q\30\3\2\2\2RT\t\3\2\2SR\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2V\32\3\2\2\2WU\3\2\2\2XZ\t\6\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3"+
		"\2\2\2[\\\3\2\2\2\\\34\3\2\2\2]^\7\62\2\2^b\7z\2\2_`\7\62\2\2`b\7Z\2\2"+
		"a]\3\2\2\2a_\3\2\2\2bd\3\2\2\2ce\t\6\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2"+
		"fg\3\2\2\2g\36\3\2\2\2hi\7\61\2\2ij\7\61\2\2jn\3\2\2\2km\13\2\2\2lk\3"+
		"\2\2\2mp\3\2\2\2no\3\2\2\2nl\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\f\2\2rs\3"+
		"\2\2\2st\b\20\2\2t \3\2\2\2uv\7\61\2\2vw\7,\2\2w|\3\2\2\2x{\13\2\2\2y"+
		"{\7\f\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2\2}\177\3\2\2"+
		"\2~|\3\2\2\2\177\u0080\7,\2\2\u0080\u0081\7\61\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0083\b\21\2\2\u0083\"\3\2\2\2\u0084\u0085\t\7\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0087\b\22\2\2\u0087$\3\2\2\2\f\2IPU[afnz|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}