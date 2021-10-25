// Generated from C:/Users/lhr4108/Desktop/untitled1/src\test.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link testParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface testVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link testParser#compunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompunit(testParser.CompunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(testParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(testParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(testParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(testParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#addexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexp(testParser.AddexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#mulexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulexp(testParser.MulexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#unaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexp(testParser.UnaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#primaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexp(testParser.PrimaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(testParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#decimalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalconst(testParser.DecimalconstContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#octalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctalconst(testParser.OctalconstContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#hexadecimalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalconst(testParser.HexadecimalconstContext ctx);
}