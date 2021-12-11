// Generated from C:/Users/lhr4108/Desktop/大三上学习资料/编译原理/Test\Compile.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompileParser}.
 */
public interface CompileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompileParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CompileParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CompileParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(CompileParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(CompileParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CompileParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CompileParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(CompileParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(CompileParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(CompileParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(CompileParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(CompileParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(CompileParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(CompileParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(CompileParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(CompileParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(CompileParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(CompileParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(CompileParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(CompileParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(CompileParser.InitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(CompileParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(CompileParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(CompileParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(CompileParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParams(CompileParser.FuncFParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParams(CompileParser.FuncFParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParam(CompileParser.FuncFParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParam(CompileParser.FuncFParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CompileParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CompileParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(CompileParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(CompileParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CompileParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CompileParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CompileParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CompileParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpStmt(CompileParser.ExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpStmt(CompileParser.ExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#conditionStmt}.
	 * @param ctx the parse tree
	 */
	void enterConditionStmt(CompileParser.ConditionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#conditionStmt}.
	 * @param ctx the parse tree
	 */
	void exitConditionStmt(CompileParser.ConditionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(CompileParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(CompileParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(CompileParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(CompileParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(CompileParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(CompileParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(CompileParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(CompileParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CompileParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CompileParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(CompileParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(CompileParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(CompileParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(CompileParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(CompileParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(CompileParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CompileParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CompileParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(CompileParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(CompileParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#callee}.
	 * @param ctx the parse tree
	 */
	void enterCallee(CompileParser.CalleeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#callee}.
	 * @param ctx the parse tree
	 */
	void exitCallee(CompileParser.CalleeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(CompileParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(CompileParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncRParams(CompileParser.FuncRParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncRParams(CompileParser.FuncRParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(CompileParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(CompileParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(CompileParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(CompileParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(CompileParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(CompileParser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(CompileParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(CompileParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(CompileParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(CompileParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(CompileParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(CompileParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(CompileParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(CompileParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(CompileParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(CompileParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void enterEqOp(CompileParser.EqOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void exitEqOp(CompileParser.EqOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(CompileParser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(CompileParser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(CompileParser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(CompileParser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(CompileParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(CompileParser.ConstExpContext ctx);
}