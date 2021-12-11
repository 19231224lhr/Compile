// Generated from C:/Users/lhr4108/Desktop/大三上学习资料/编译原理/Test\Compile.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompileParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CompileParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(CompileParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(CompileParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(CompileParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(CompileParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(CompileParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(CompileParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(CompileParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(CompileParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(CompileParser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(CompileParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(CompileParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(CompileParser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(CompileParser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CompileParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(CompileParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CompileParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(CompileParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#expStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStmt(CompileParser.ExpStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#conditionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStmt(CompileParser.ConditionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(CompileParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(CompileParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(CompileParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(CompileParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(CompileParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(CompileParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(CompileParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(CompileParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CompileParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(CompileParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#callee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallee(CompileParser.CalleeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(CompileParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(CompileParser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(CompileParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(CompileParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(CompileParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(CompileParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(CompileParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(CompileParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(CompileParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(CompileParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#eqOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOp(CompileParser.EqOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(CompileParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(CompileParser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(CompileParser.ConstExpContext ctx);
}