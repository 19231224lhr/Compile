// Generated from C:/Users/lhr4108/Desktop/untitled\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lab3Parser}.
 */
public interface lab3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lab3Parser#compunit}.
	 * @param ctx the parse tree
	 */
	void enterCompunit(lab3Parser.CompunitContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#compunit}.
	 * @param ctx the parse tree
	 */
	void exitCompunit(lab3Parser.CompunitContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(lab3Parser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(lab3Parser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(lab3Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(lab3Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#blockitem}.
	 * @param ctx the parse tree
	 */
	void enterBlockitem(lab3Parser.BlockitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#blockitem}.
	 * @param ctx the parse tree
	 */
	void exitBlockitem(lab3Parser.BlockitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(lab3Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(lab3Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#lval}.
	 * @param ctx the parse tree
	 */
	void enterLval(lab3Parser.LvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#lval}.
	 * @param ctx the parse tree
	 */
	void exitLval(lab3Parser.LvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(lab3Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(lab3Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#addexp}.
	 * @param ctx the parse tree
	 */
	void enterAddexp(lab3Parser.AddexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#addexp}.
	 * @param ctx the parse tree
	 */
	void exitAddexp(lab3Parser.AddexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#mulexp}.
	 * @param ctx the parse tree
	 */
	void enterMulexp(lab3Parser.MulexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#mulexp}.
	 * @param ctx the parse tree
	 */
	void exitMulexp(lab3Parser.MulexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexp(lab3Parser.UnaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexp(lab3Parser.UnaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncRParams(lab3Parser.FuncRParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncRParams(lab3Parser.FuncRParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryexp(lab3Parser.PrimaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryexp(lab3Parser.PrimaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(lab3Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(lab3Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#decimalconst}.
	 * @param ctx the parse tree
	 */
	void enterDecimalconst(lab3Parser.DecimalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#decimalconst}.
	 * @param ctx the parse tree
	 */
	void exitDecimalconst(lab3Parser.DecimalconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#octalconst}.
	 * @param ctx the parse tree
	 */
	void enterOctalconst(lab3Parser.OctalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#octalconst}.
	 * @param ctx the parse tree
	 */
	void exitOctalconst(lab3Parser.OctalconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#hexadecimalconst}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimalconst(lab3Parser.HexadecimalconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#hexadecimalconst}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimalconst(lab3Parser.HexadecimalconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(lab3Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(lab3Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(lab3Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(lab3Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(lab3Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(lab3Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(lab3Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(lab3Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(lab3Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(lab3Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(lab3Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(lab3Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(lab3Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(lab3Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(lab3Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(lab3Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(lab3Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(lab3Parser.InitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(lab3Parser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(lab3Parser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#nondigit}.
	 * @param ctx the parse tree
	 */
	void enterNondigit(lab3Parser.NondigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#nondigit}.
	 * @param ctx the parse tree
	 */
	void exitNondigit(lab3Parser.NondigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#nondigit_1}.
	 * @param ctx the parse tree
	 */
	void enterNondigit_1(lab3Parser.Nondigit_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#nondigit_1}.
	 * @param ctx the parse tree
	 */
	void exitNondigit_1(lab3Parser.Nondigit_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#nondigitDigit}.
	 * @param ctx the parse tree
	 */
	void enterNondigitDigit(lab3Parser.NondigitDigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#nondigitDigit}.
	 * @param ctx the parse tree
	 */
	void exitNondigitDigit(lab3Parser.NondigitDigitContext ctx);
}