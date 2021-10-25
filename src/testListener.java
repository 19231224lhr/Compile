// Generated from C:/Users/lhr4108/Desktop/untitled1/src\test.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link testParser}.
 */
public interface testListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link testParser#compunit}.
	 * @param ctx the parse tree
	 */
	void enterCompunit(testParser.CompunitContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#compunit}.
	 * @param ctx the parse tree
	 */
	void exitCompunit(testParser.CompunitContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(testParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(testParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(testParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(testParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(testParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(testParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(testParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(testParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#addexp}.
	 * @param ctx the parse tree
	 */
	void enterAddexp(testParser.AddexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#addexp}.
	 * @param ctx the parse tree
	 */
	void exitAddexp(testParser.AddexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#mulexp}.
	 * @param ctx the parse tree
	 */
	void enterMulexp(testParser.MulexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#mulexp}.
	 * @param ctx the parse tree
	 */
	void exitMulexp(testParser.MulexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexp(testParser.UnaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexp(testParser.UnaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryexp(testParser.PrimaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryexp(testParser.PrimaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(testParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(testParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#decimalconst}.
	 * @param ctx the parse tree
	 */
	void enterDecimalconst(testParser.DecimalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#decimalconst}.
	 * @param ctx the parse tree
	 */
	void exitDecimalconst(testParser.DecimalconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#octalconst}.
	 * @param ctx the parse tree
	 */
	void enterOctalconst(testParser.OctalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#octalconst}.
	 * @param ctx the parse tree
	 */
	void exitOctalconst(testParser.OctalconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#hexadecimalconst}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimalconst(testParser.HexadecimalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#hexadecimalconst}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimalconst(testParser.HexadecimalconstContext ctx);
}