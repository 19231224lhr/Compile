// Generated from C:/Users/lhr4108/Desktop/untitled\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lab3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lab3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lab3Parser#compunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompunit(lab3Parser.CompunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(lab3Parser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(lab3Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#blockitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockitem(lab3Parser.BlockitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(lab3Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#lval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLval(lab3Parser.LvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(lab3Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#addexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexp(lab3Parser.AddexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#mulexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulexp(lab3Parser.MulexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#unaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexp(lab3Parser.UnaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(lab3Parser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#primaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexp(lab3Parser.PrimaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(lab3Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#decimalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalconst(lab3Parser.DecimalconstContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#octalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctalconst(lab3Parser.OctalconstContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#hexadecimalconst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalconst(lab3Parser.HexadecimalconstContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(lab3Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(lab3Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(lab3Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(lab3Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(lab3Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(lab3Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(lab3Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(lab3Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(lab3Parser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(lab3Parser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#nondigit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNondigit(lab3Parser.NondigitContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#nondigit_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNondigit_1(lab3Parser.Nondigit_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#nondigitDigit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNondigitDigit(lab3Parser.NondigitDigitContext ctx);
}