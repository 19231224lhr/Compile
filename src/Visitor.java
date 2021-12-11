import java.util.ArrayList;
import java.util.Stack;

public class Visitor extends CompileBaseVisitor<Void> {

    // 定义最终的输出字符串
    public static StringBuffer Result = new StringBuffer();
    // 定义函数类
    FunctionList functionList = new FunctionList();
    // 定义符号表
    SymbolTable symbolTable = new SymbolTable();
    // 定义寄存器
    int Register = 0;
    // 定义中间载体数字
    int TempNum = 0;
    // 定义寄存器传递值
    int TempRegister = 0;
    // 进入表达式之前的寄存器最大值
    int Before = 0;
    // 进入表达式之后的寄存器最大值
    int After = 0;
    // 定义变量是否赋值布尔类型判断值，用于常数类型判断
    boolean isValue = true;
    // 定义函数是否有返回值，用于变量赋值判断
    boolean isFuncValue = true;
    // 函数参数，用户函数调用正确性判断
    ArrayList<ArrayList<Param>> paramArrayList = new ArrayList<>();
    Param param;
    // 函数参数层数
    int ParamIndex = -1;
    // 有返回值的函数是否定义了变量来接收函数返回值
    boolean isFuncReturn = false;
    // 函数块标号
    // 错误示范，这里一定不能声明为全局变量，因为这样的话前面预留的给ret返回块的寄存器的值就有可能被下面的程序块中的语句更改
//    int Label1 = 0;
//    int Label2 = 0;
//    int Ret = 0;
    // 定义函数层级
    int Layer = 0;
    // 定义全局变量计算字符串
    String GString = "";
    // 全局变量数组
    GloableVar gloableVar = new GloableVar();
    // 全局变量
    String GName;
    int Gb;
    boolean JG = false;
    // 是否使用了单值判断
    boolean SingleJudge = false;
    // while语句条件判断块
    Stack<Integer> WhileJudge = new Stack<>();
    // while语句循环代码块
    Stack<Integer> WhileResult = new Stack<>();
    // while语句返回代码块
    Stack<Integer> WhileReturn = new Stack<>();
    // while中是否使用了break或continue语句
    boolean isBreakContinue = false;
    // 数组维数计算
    String ArrayNumString = "";
    String ArrayNumString1 = "";
    // 是否在进行数组参数运算
    boolean isArrayParam = false;
    // 存储数组类
    ArrayTable arrayTable = new ArrayTable();
    // 存储数组名称，便于查找
    String ArrayName = "";
    // 是否在进行数组赋值运算
    boolean isArrayValue = false;
    // 是否需要二维数组借助一维数组方法
    // 是否在运算数组
    boolean isArrayUse = false;
    // 存储二维数组借用一维数组传递层数
    int ArrayUseLayer1;
    int ArrayUseLayer2;
    // 二维数组借用一维数组方法是否到二维数组最后一行
    boolean isArrayEnd = false;
    // 保存二维数组最开始寄存器
    int SaveRegisterFirst;
    // 保存全局变量数组声明
    String ArrayString;
    // 进入了几次visitLVal()方法
    int Index = 0;
    // load元素识别数组名
    String ArrayNameLoad;
    // load指令是否有数组元素
    boolean isArrayUseLoad = false;
    // 函数块标签
    int FuncDefLabel = 0;
    // 函数是否调用了main函数
    static public boolean isMain = false;
    // 函数是否有返回值
    boolean isFuncNewReturn = false;

    // 数组首地址寄存器
    int ArrayFirstRegister;

    ArrayList<Integer> ArrayInit = new ArrayList<>();
    // 数组赋值标识符。多维数组
    boolean Test1 = false;

    // 多维数组全局变量声明前置部分
    ArrayList<String> FinalTempAlloca = new ArrayList<>();

    // 存储每一次运算结果的数组
    ArrayList<String> tempArrayList = new ArrayList<>();

    // 记录数组层数
    int testArrayLayer = 0;

    // 记录数组位置
    ArrayItemInit Position = new ArrayItemInit();

    // 数组位置列表
    ArrayItemInitList arrayItemInitList = new ArrayItemInitList();

    // 是否在使用const初始化
    boolean isConst = false;

    // 是否在求函数参数
    boolean isFuncParam = false;

    // 当前函数参数
    ArrayList<Param> paramArrayListNow = new ArrayList<>();
    // 函数参数
    Param paramNow;

    // 是否调用了函数
    boolean isCallee = false;

    // 是否取了数组地址
    boolean isArrayAddress = false;

    // 调用函数参数字符串
    StringBuilder paramString = new StringBuilder();

    // 数组定义与赋值之间传递函数名的字符串
    String ArrayNamePass = "";

    // 函数是否含有return语句
    boolean isFuncReturnStmt = false;

    // 是否在函数调用参数中使用了数组
    boolean isTestParam = false;

    // 是否使用了赋值语句
    boolean isEQ = false;

    // if-else语句是否有返回块
    Stack<Boolean> isIfElseReturn = new Stack<>();

    // while语句是否有返回块
    Stack<Boolean> isWhileReturn = new Stack<>();

    // 函数返回值
    String Return = "";

    // 函数调用参数栈
    Stack<String> CalleeFuncParam = new Stack<>();

    // 短路求值or，遇到true直接跳入
    Stack<Integer> OrStack = new Stack<>();

    // 短路求值and，遇到false直接跳出
    Stack<Integer> AndStack = new Stack<>();

    @Override
    public Void visitProgram(CompileParser.ProgramContext ctx) {
        visit(ctx.compUnit());
        // return super.visitProgram(ctx);
        return null;
    }

    @Override
    public Void visitCompUnit(CompileParser.CompUnitContext ctx) {
        int len = ctx.children.size();
        for (int i = 0; i < len; i++) {
            if (ctx.children.get(i).getChildCount() == 1) {
                // decl
                visit(ctx.children.get(i));
            } else if (ctx.children.get(i).getChildCount() != 1) {
                // funcdef

                visit(ctx.children.get(i));

                if (FuncDefLabel == 0) {
                    // 第一个局部符号表加入全部符号表数组
                    AllSymbolTables.allSymbolTables.add(new AllSymbolTables(symbolTable, FuncDefLabel));
                }
                FuncDefLabel++;
                if (FuncDefLabel >= AllSymbolTables.allSymbolTables.size()) {
                    // 创建一个新的局部变量表
                    // System.out.println("yes");
                    symbolTable = new SymbolTable();
                    // 将之前所有的全局变量添加到局部符号表中
                    for (int i1 = 0; i1 < gloableVar.gloableArray.size(); i1++) {
                        symbolTable.Table.add(gloableVar.gloableArray.get(i1));
                    }
                    AllSymbolTables allSymbolTables = new AllSymbolTables(symbolTable, FuncDefLabel);
                    // 添加到总变量表
                    AllSymbolTables.allSymbolTables.add(allSymbolTables);
                }
                // 层数归零
                this.Layer = 0;
                // 寄存器值归零
                // 在多维数组测试点中，两个函数中间定义全局变量测试点，因此将每个函数块寄存器值起始值改为全局变量数组长度
                this.Register = gloableVar.gloableArray.size();
                // 函数参数(判断)清空
                this.paramArrayList.clear();
                // 函数参数(定义)清空
                // 注意，不能使用clear()方法，因为这样会导致相同地址元素清空，在函数列表中存储的函数参数信息也会清空
                this.paramArrayListNow = new ArrayList<>();
                // while语句条件判断块清空
                WhileJudge.clear();
                // while语句循环代码块清空
                WhileResult.clear();
                // while语句返回代码块清空
                WhileReturn.clear();
                // 存储数组动态数组清空非全局变量数组
                arrayTable.ClearArrayList();
                // while是否有返回块栈清空
                isWhileReturn.clear();

            }
            // visit(ctx.children.get(i));
            // System.out.println("这里执行了");
        }
        // return super.visitCompUnit(ctx);
        return null;
    }

    @Override
    public Void visitDecl(CompileParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Void visitConstDecl(CompileParser.ConstDeclContext ctx) {
        int len = ctx.children.size() - 3;
        len = len / 2;
        String ResultString = "";
        for (int i = 0; i <= len; i++) {
            visit(ctx.constDef(i));
        }
        // return super.visitConstDecl(ctx);
        return null;
    }

    @Override
    public Void visitBType(CompileParser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitConstDef(CompileParser.ConstDefContext ctx) {
        if (ctx.L_BRACKT(0) == null) {
            if (this.Layer != 0) {
                String ResultString = "%x" + this.Register + " = alloca i32";
                Result.append("\t").append(ResultString).append("\n");
                this.Register++;
            }
        }
        if (symbolTable.LayerSearch(ctx.IDENT().toString(), this.Layer)) {
            System.out.println("Error:您声明常量类型变量已经被声明过了" + ctx.IDENT().toString());
            System.exit(5);
        }
        if (!this.isValue) {
            System.out.println("Error:常量类型不可用没有赋值过的变量类型赋值" + ctx.IDENT().toString());
            System.exit(6);
        }
        int len = ctx.children.size() - 3;
        len = len / 3;
//        for (int i = 0; i < len; i++) {
//            visit(ctx.L_BRACKT(i));
//            visit(ctx.constExp(i));
//            visit(ctx.R_BRACKT(i));
//        }
        if (this.Layer == 0) {
            ArrayName = ctx.IDENT().toString();
//            if (len == 1) {
//                visit(ctx.L_BRACKT(0));
//                GString = "";
//                visit(ctx.constExp(0));
//                GString = gloableVar.AnalyseString(GString);
//                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                GString = "";
//                // const int a[3] = {1, 2};
//                // @c = dso_local constant [3 x i32] [i32 1, i32 2, i32 0]
//                ArrayString = "@x" + this.Register + " = dso_local constant [" + result + " x i32]";
//                this.Register++;
//                visit(ctx.R_BRACKT(0));
//
//                // 添加数组
//                ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "constint", 1, 1, result, true, 0, new HashMap<>());
//                arrayTable.arrayItems.add(arrayItem);
//                Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "constarray", true, 0);
//                gloableVar.gloableArray.add(variable);
//                symbolTable.Table.add(variable);
//
//                visit(ctx.constInitVal());
//            } else if (len == 2) {
//                GString = "";
//                visit(ctx.constExp(0));
//                GString = gloableVar.AnalyseString(GString);
//                int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                GString = "";
//
//                visit(ctx.constExp(1));
//                GString = gloableVar.AnalyseString(GString);
//                int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                GString = "";
//
//                // @c = dso_local constant [2 x [1 x i32]] [[1 x i32] [i32 1], [1 x i32] [i32 3]]
//                ArrayString = "@x" + this.Register + " = dso_local constant [" + result1 + " x [" + result2 + " x i32]]";
//                this.Register++;
//
//                // 添加数组
//                ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "constint", result1, 2, result2, true, 0, new HashMap<>());
//                arrayTable.arrayItems.add(arrayItem);
//                Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "constarray", true, 0);
//                gloableVar.gloableArray.add(variable);
//                symbolTable.Table.add(variable);
//
//                visit(ctx.constInitVal());
//            } else
            if (len == 0) {
                visit(ctx.ASSIGN());
                GString = "";
                visit(ctx.constInitVal());
                // System.out.println(GString);
                // System.out.println(GString);
                GString = gloableVar.AnalyseString(GString);
                // System.out.println(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
                Variable variable = new Variable(this.Register, ctx.IDENT().toString(), result, "constint", true, 0);
                symbolTable.Table.add(variable);
                gloableVar.gloableArray.add(variable);
                GString = "";
                Result.append("@x").append(this.Register).append(" = dso_local constant i32 ").append(result).append("\n");
                this.Register++;
            } else {
                // 多维数组全局变量赋值
                // @x0 = dso_local global [1 x [3 x [3 x i32]]] [[3 x [3 x i32]] [[3 x i32] [i32 1, i32 3, i32 0], [3 x i32] [i32 1, i32 2, i32 3], [3 x i32] [i32 0, i32 0, i32 0]]]
                StringBuilder TempAlloca = new StringBuilder("i32");
                StringBuilder SecondString = new StringBuilder("[");
                // 存储每个方括号内的数字大小
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    visit(ctx.L_BRACKT(i));
                    int result;
                    ArrayNumString = "";
                    isArrayParam = true;
                    isConst = true;
                    visit(ctx.constExp(i));
                    isConst = false;
                    isArrayParam = false;
                    result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
                    if (result <= 0) {
                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                        System.exit(17);
                    }
                    arrayList.add(result);
                    // 字符串还原
                    ArrayNumString = "";

                    visit(ctx.R_BRACKT(i));
                }
                // @x0 = dso_local global [1 x [3 x [3 x i32]]] [[3 x [3 x i32]] [[3 x i32] [i32 1, i32 3, i32 0], [3 x i32] [i32 1, i32 2, i32 3], [3 x i32] [i32 0, i32 0, i32 0]]]
                ArrayString = "@x" + this.Register + " = dso_local constant ";
                this.Register++;

                // 添加数组
                // System.out.println("这里来过了2");
                ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "constint", len, arrayList, true, 0);
                arrayTable.arrayItems.add(arrayItem);
                Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "constarray", true, 0);
                gloableVar.gloableArray.add(variable);
                symbolTable.Table.add(variable);
                // 数组名
                ArrayName = ctx.IDENT().toString();

                ArrayInit.clear();
                Test1 = true;
                visit(ctx.constInitVal());
                Test1 = false;

                ArrayInit.clear();
                // 参数赋值
                GlobalArrayInit(arrayList, 0, ArrayName);

                Result.append(ArrayString + "\n");

                ArrayString = "";
                ArrayInit.clear();
                ArrayName = "";
                arrayItemInitList.arrayItemInitArrayList.clear();
            }
        } else {

            int leftJudge, rightJudge;
            int Num;
            String ResultString = "";
//            if (len == 1) {
//                // 一维数组
//                visit(ctx.L_BRACKT(0));
//                ArrayNumString = "";
//                isArrayParam = true;
//                isConst = true;
//                visit(ctx.constExp(0));
//                isConst = false;
//                isArrayParam = false;
//                // Result.append("\t2eqwdas\n");
//                // 将返回到的表达式化简并求值
//                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                if (result <= 0) {
//                    System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                    System.exit(17);
//                }
//                // result的值是一维数组的数组长度
//                // 字符串还原
//                ArrayNumString = "";
//                visit(ctx.R_BRACKT(0));
//                // 定义一维数组
//                // %1 = alloca [2 x i32]
//                ResultString = "%x" + this.Register + " = alloca [" + result + " x i32]";
//                Result.append("\t").append(ResultString).append("\n");
//                int ArrayRegister = this.Register;
//                this.Register++;
//                // 给数组赋予空间，获取数组指针
//                // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                ResultString = "%x" + this.Register + " = getelementptr [" + result + " x i32], [" + result + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                Result.append("\t").append(ResultString).append("\n");
//                this.Register++;
//                // 初始化数组为0
//                // call void @memset(i32* %4, i32 0, i32 16)
//                ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
//                Result.append("\t" + ResultString + "\n");
//                // 声明调用的函数memset
//                if (!functionList.returnFunction("memset").isUse) {
//                    Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                    // 将memset函数设置为已声明状态
//                    functionList.changeisUseFunction("memset");
//                }
//                // 添加数组
//                ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "const", 1, 1, result, true, this.Layer, new HashMap<>());
//                arrayTable.arrayItems.add(arrayItem);
//                Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "constarray", true, this.Layer);
//                symbolTable.Table.add(variable);
//
//                // 数组赋值
//                visit(ctx.ASSIGN());
//                this.ArrayName = ctx.IDENT().toString();
//                this.isArrayValue = true;
//                isArrayUse = false;
//                isConst = true;
//                visit(ctx.constInitVal());
//                isConst = false;
//                this.isArrayValue = false;
//            } else if (len == 2) {
//                // 二维数组
//                visit(ctx.L_BRACKT(0));
//                ArrayNumString = "";
//                isArrayParam = true;
//                isConst = true;
//                visit(ctx.constExp(0));
//                isArrayParam = false;
//                // 将返回到的表达式化简并求值
//                int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                if (result1 <= 0) {
//                    System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                    System.exit(17);
//                }
//                // result的值是一维数组的数组长度
//                // 字符串还原
//                ArrayNumString = "";
//                visit(ctx.R_BRACKT(0));
//                visit(ctx.L_BRACKT(1));
//                ArrayNumString = "";
//                isArrayParam = true;
//                visit(ctx.constExp(1));
//                isConst = false;
//                isArrayParam = false;
//                // 将返回到的表达式化简并求值
//                int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                if (result2 <= 0) {
//                    System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                    System.exit(17);
//                }
//                // result的值是一维数组的数组长度
//                // 字符串还原
//                ArrayNumString = "";
//                // %1 = alloca [2 x [2 x i32]]
//                ResultString = "%x" + this.Register + " = alloca [" + result1 + " x [" + result2 + " x i32]]";
//                Result.append("\t").append(ResultString).append("\n");
//                this.Register++;
//                int ArrayRegister = this.Register - 1;
//
//                // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
//                // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                // call void @memset(i32* %4, i32 0, i32 16)
//                ResultString = "%x" + this.Register + " = getelementptr [" + result1 + " x [" + result2 + " x i32]], [" + result1 + " x [" + result2 + " x i32]]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                Result.append("\t" + ResultString + "\n");
//                this.Register++;
//                ResultString = "%x" + this.Register + " = getelementptr [" + result2 + " x i32], [" + result2 + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                Result.append("\t" + ResultString + "\n");
//                this.Register++;
//                if (!functionList.isUseFunction("memset")) {
//                    Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                    // 将memset函数设置为已声明状态
//                    functionList.changeisUseFunction("memset");
//                }
//                ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result1 * result2 * 4) + ")";
//                Result.append("\t" + ResultString + "\n");
//                visit(ctx.R_BRACKT(1));
//
//                // 添加数组
//                ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "int", result1, 2, result2, true, this.Layer, new HashMap<>());
//                arrayTable.arrayItems.add(arrayItem);
//                Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "constarray", true, this.Layer);
//                symbolTable.Table.add(variable);
//
//                // 注意先添加数组再数组赋值，否则会在赋值时找不到定义的数组
//                visit(ctx.ASSIGN());
//                this.ArrayName = ctx.IDENT().toString();
//                this.isArrayValue = true;
//                isConst = true;
//                visit(ctx.constInitVal());
//                isConst = false;
//                this.isArrayValue = false;
//            } else if (len == 0) {
//                // 不是数组类型变量
//                visit(ctx.ASSIGN());
//                leftJudge = this.Register;
//                isConst = true;
//                visit(ctx.constInitVal());
//                isConst = false;
//                rightJudge = this.Register;
//                Num = this.TempNum;
//                Variable variable;
//                if (leftJudge != rightJudge) {
//                    // 表达式中使用了新的寄存器调用
//                    ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + (leftJudge - 1);
//                    variable = new Variable(leftJudge - 1, ctx.IDENT().toString(), rightJudge - 1, "constint", true, this.Layer);
//                } else {
//                    ResultString = "store i32 " + Num + ", i32* %x" + (leftJudge - 1);
//                    variable = new Variable(leftJudge - 1, ctx.IDENT().toString(), Num, "constint", true, this.Layer);
//                }
//                symbolTable.Table.add(variable);
//                // 变量声明不能去除，因为如果去除常数全局变量声明会面程序会无法识别全局常数变量
//                Result.append("\t").append(ResultString).append("\n");
//            } else {
            // 多维数组
            // System.out.println("aaaaaaaaaaaaa");
            if (len == 0) {
                visit(ctx.ASSIGN());
                isConst = true;
                ArrayNumString = "";
                visit(ctx.constInitVal());
                // System.out.println(GString);
                // System.out.println(GString);
                ArrayNumString = gloableVar.AnalyseString(ArrayNumString);
                // System.out.println(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(ArrayNumString));
                Variable variable = new Variable(this.Register, ctx.IDENT().toString(), result, "constint", true, this.Layer);
                symbolTable.Table.add(variable);
                gloableVar.gloableArray.add(variable);
                ArrayNumString = "";
                // store i32 456, i32* %4
                Result.append("\tstore i32 ").append(result).append(", i32* %x").append(this.Register - 1).append("\n");
                isConst = false;
            } else {
                StringBuilder TempAlloca = new StringBuilder("i32");
                // 存储每个方括号内的数字大小
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    visit(ctx.L_BRACKT(i));
                    int result;
                    ArrayNumString = "";
                    isArrayParam = true;
                    isConst = true;
                    visit(ctx.constExp(i));
                    isConst = false;
                    isArrayParam = false;
                    result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
                    if (result <= 0) {
                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                        System.exit(17);
                    }
                    arrayList.add(result);
                    // 字符串还原
                    ArrayNumString = "";

                    visit(ctx.R_BRACKT(i));
                }

                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    TempAlloca = new StringBuilder("[" + arrayList.get(i) + " x " + TempAlloca + "]");
                }

                // 走出循环的TempAlloca中存储的就是数组声明alloca右边的语句
                // System.out.println("Test\t%x" + this.Register + " = alloca " + TempAlloca + "\n");
                Result.append("\t%x").append(this.Register).append(" = alloca ").append(TempAlloca).append("\n");
                ArrayFirstRegister = this.Register;
                this.Register++;
                ArrayName = ctx.IDENT().toString();

                // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
                String temp = "";
                int result = 1; // memset()函数中使用
                for (int i = 0; i < len; i++) {
                    temp += ", i32 0";
                    result *= arrayList.get(i);
                }
                temp = "%x" + this.Register + " = getelementptr " + TempAlloca + ", " + TempAlloca + "* %x" + ArrayFirstRegister + ", i32 0" + temp;
                Result.append("\t").append(temp).append("\n");
                this.Register++;

                // 初始化数组为0
                // call void @memset(i32* %4, i32 0, i32 16)
                temp = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
                Result.append("\t").append(temp).append("\n");
                // 声明调用的函数memset
                if (!functionList.returnFunction("memset").isUse) {
                    Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
                    // 将memset函数设置为已声明状态
                    functionList.changeisUseFunction("memset");
                }

                // 添加数组
                ArrayItem arrayItem = new ArrayItem(ArrayFirstRegister, ctx.IDENT().toString(), "constint", len, arrayList, true, this.Layer);
                arrayTable.arrayItems.add(arrayItem);
                Variable variable = new Variable(ArrayFirstRegister, ctx.IDENT().toString(), 0, "constarray", true, this.Layer);
                symbolTable.Table.add(variable);

                // 数组赋值
                visit(ctx.ASSIGN());
                this.ArrayName = ctx.IDENT().toString();
                this.isArrayValue = true;
                isArrayUse = false;
                Test1 = true;
                isConst = true;
                visit(ctx.constInitVal());
                isConst = false;
                Test1 = false;
                this.isArrayValue = false;
            }
        }
//        }
        // return super.visitConstDef(ctx);
        return null;
    }

    @Override
    public Void visitConstInitVal(CompileParser.ConstInitValContext ctx) {
        if (ctx.children.size() == 1) {
            int leftJudge, rightJudge;
            int Num;
            leftJudge = this.Register;
            visit(ctx.constExp());
            rightJudge = this.Register;
            Num = TempNum;
            /*
             * %x2 = getelementptr [1 x [2 x [3 x i32]]], [1 x [2 x [3 x i32]]]* %x0, i32 0, i32 0, i32 0, i32 0
             * store i32 1, i32* %x2
             */
            if (Test1 && this.Layer != 0) {
                String ResultString = "i32";
                ArrayItem arrayItem = arrayTable.SearchArray(ArrayName);
                for (int i = 0; i < arrayTable.SearchArray(ArrayName).Dimension; i++) {
                    // System.out.println(ArrayInit.get(i) + " " + arrayItem.arrayList.get(i));
                    if (ArrayInit.size() != arrayItem.arrayList.size()) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    if (ArrayInit.get(i) >= arrayItem.arrayList.get(i)) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                }
                for (int i = arrayItem.arrayList.size() - 1; i >= 0; i--) {
                    ResultString = "[" + arrayItem.arrayList.get(i) + " x " + ResultString + "]";
                }
                ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* %x" + arrayItem.ArrayRegister + ", i32 0";
                for (int i = 0; i < arrayItem.Dimension; i++) {
                    ResultString += ", i32 " + ArrayInit.get(i);
                }
                this.Register++;
                Result.append("\t").append(ResultString).append("\n");
                if (leftJudge == rightJudge) {
                    ResultString = "store i32 " + Num + ", i32* %x" + (this.Register - 1);
                } else {
                    ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + (this.Register - 1);
                }
                Result.append("\t").append(ResultString).append("\n");
                // ArrayInit.clear();
            } else if (Test1) {
                // 全局变量
                GString = "";
                visit(ctx.constExp());
                GString = gloableVar.AnalyseString(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));   // 数组元素值
                // System.out.println(result);
                int r = arrayTable.SearchArray(ArrayName).ArrayRegister;    // 数组元素所在数组寄存器值
                ArrayList<Integer> arrayList = new ArrayList<>();           // 数组元素所在数组位置
                // System.out.println(ArrayInit);
                ArrayItem arrayItem = arrayTable.SearchArray(ArrayName);
                for (int i = 0; i < arrayTable.SearchArray(ArrayName).Dimension; i++) {
                    // System.out.println(ArrayInit.get(i) + " " + arrayItem.arrayList.get(i));
                    if (ArrayInit.size() != arrayTable.SearchArray(ArrayName).Dimension) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    if (ArrayInit.get(i) >= arrayItem.arrayList.get(i)) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    arrayList.add(ArrayInit.get(i));
                }
                // System.out.println(">>>" + arrayList);
                ArrayItemInit arrayItemInit = new ArrayItemInit(result, ArrayName, r, arrayList);

                arrayItemInitList.arrayItemInitArrayList.add(arrayItemInit);

            }
        } else {
            if (!symbolTable.SearchValue(this.ArrayName).Type.contains("array")) {
                System.out.println("Error:赋值类型错误array");
                System.exit(16);
            }
            if (ctx.constInitVal(0) == null) {
                ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
                visit(ctx.L_BRACE());
                visit(ctx.R_BRACE());
                // 全为0，不用输出语
                // 全局变量数组需要输出0
                if (this.Layer == 0) {
                    if (arrayItem.Dimension == 1) {
                        ArrayString += "[i32 0";
                        for (int i = 0; i < arrayItem.Width - 1; i++) {
                            ArrayString += ", i32 0";
                        }
                        ArrayString += "]";
                        Result.append(ArrayString).append("\n");
                    } else {
                        ArrayString += "zeroinitializer";
                        Result.append(ArrayString).append("\n");
                    }
                }
            } else if (ctx.constInitVal(0).children.size() == 2) {
                // int a[2][2] = {{},{}};
                if (ctx.constInitVal(1) != null) {
                    if (ctx.constInitVal(1).children.size() == 2) {
                        ArrayString += "zeroinitializer";
                        Result.append(ArrayString).append("\n");

                    }
                } else {
                    ArrayString += "zeroinitializer";
                    Result.append(ArrayString).append("\n");
                }
            } else {
                int leftJudge, rightJudge;
                int Num;
                int SaveRegister = this.Register - 1;
                if (!isArrayUse) {
                    SaveRegisterFirst = this.Register - 1;
                }
                if (isArrayUse && Index == 2) {
                    ArrayString += " [";
                }
                String ResultString = "";
//                if (arrayTable.SearchArray(this.ArrayName).Dimension == 1 || isArrayUse) {
//                    // 一维数组
//                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
//                    int len = ctx.children.size() - 3;
//                    len = len / 2;
//                    if (ctx.constInitVal(0).children.size() != 1 && !isArrayUse) {
//                        System.out.println("Error:一维数组不能用二维数组初始化");
//                        System.exit(16);
//                    }
//                    // store i32 1, i32* %4
//                    // %5 = getelementptr i32, i32* %4, i32 2
//                    leftJudge = this.Register;
//                    GString = "";
//                    visit(ctx.constInitVal(0));
//                    if (this.Layer == 0) {
//                        GString = gloableVar.AnalyseString(GString);
//                        int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                        GString = "";
//                        // [i32 1, i32 2, i32 0]
//                        if (isArrayUse) {
//                            ArrayString += "[" + arrayItem.Width + " x i32] [i32 " + result;
//                        } else {
//                            ArrayString += "[i32 " + result;
//                        }
//                    }
//                    rightJudge = this.Register;
//                    Num = TempNum;
//                    // 没有考虑全局变量
//                    if (this.Layer != 0) {
//                        if (leftJudge == rightJudge) {
//                            ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
//                        } else {
//                            ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
//                        }
//                        Result.append("\t").append(ResultString).append("\n");
//                    }
//                    // 记录指针移动次数
//                    int MoveNumber = 1;
//                    if (isArrayUse) {
//                        MoveNumber = ArrayUseLayer1 + 1;
//                    }
//                    if (len == 0 && this.Layer == 0) {
//                        // System.out.println("wofule");
//                        for (int i = 1; i < arrayItem.Width; i++) {
//                            ArrayString += ", i32 0";
//                        }
//                        ArrayString += "]";
//                        if (isArrayEnd && isArrayUse) {
//                            int a = arrayItem.ArrayLayer - Index;
//                            for (int i = 0; i < a; i++) {
//                                ArrayString += ", [" + arrayItem.Width + " x i32] zeroinitializer";
//                            }
//                            ArrayString += "]";
//                            Result.append(ArrayString + "\n");
//                        } else if (!isArrayEnd && isArrayUse) {
//                            ArrayString += ", ";
//                        } else if (!isArrayUse) {
//                            Result.append(ArrayString + "\n");
//                        }
//                    }
//                    if (len != 0) {
//                        if (this.Layer != 0) {
//                            // 需要再输出getelementptr移动指针命令
//                            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
//                            Result.append("\t").append(ResultString).append("\n");
//                            MoveNumber++;
//                            this.Register++;
//                            SaveRegister = this.Register - 1;
//                        }
//                    } else {
////                        if (this.Layer == 0) {
////                            for (int i = 1; i < arrayItem.Width; i++) {
////                                ArrayString += ", i32 0";
////                            }
////                            if (!isArrayEnd || Index == 1) {
////                                ArrayString += "],";
////                            } else {
////                                ArrayString += "]";
////                            }
////                            if (!isArrayUse) {
////                                Result.append(ArrayString + "\n");
////                            }
////                            if (isArrayEnd && Index == 1) {
////                                Result.append(ArrayString + "[" + arrayItem.Width + " x i32] zeroinitializer]").append("\n");
////                            }
////                            if (isArrayEnd && Index != 1) {
////                                Result.append(ArrayString + "]").append("\n");
////                            }
////                        }
//                    }
//                    for (int i = 0; i < len; i++) {
//                        visit(ctx.COMMA(i));
//                        if (ctx.constInitVal(i + 1).children.size() != 1 && !isArrayUse) {
//                            System.out.println("Error:一维数组不能用二维数组初始化");
//                            System.exit(16);
//                        }
//                        leftJudge = this.Register;
//                        GString = "";
//                        visit(ctx.constInitVal(i + 1));
//                        if (this.Layer == 0) {
//                            GString = gloableVar.AnalyseString(GString);
//                            int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                            GString = "";
//                            ArrayString += ", i32 " + result;
//                        }
//                        rightJudge = this.Register;
//                        Num = TempNum;
//                        if (this.Layer != 0) {
//                            if (leftJudge == rightJudge) {
//                                ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
//                            } else {
//                                ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
//                            }
//                            Result.append("\t").append(ResultString).append("\n");
//                        }
//                        // 记录指针移动次数
//                        if (i + 1 != len) {
//                            // 需要再输出getelementptr移动指针命令
//                            if (this.Layer != 0) {
//                                ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
//                                Result.append("\t").append(ResultString).append("\n");
//                                MoveNumber++;
//                                this.Register++;
//                                SaveRegister = this.Register - 1;
//                            }
//                        } else {
//                            if (this.Layer == 0) {
//                                for (int i1 = i + 2; i1 < arrayItem.Width; i1++) {
//                                    ArrayString += ", i32 0";
//                                }
//                                ArrayString += "]";
//                                if (isArrayEnd && isArrayUse) {
//                                    int a = arrayItem.ArrayLayer - Index;
//                                    for (int i1 = 0; i1 < a; i1++) {
//                                        ArrayString += ", [" + arrayItem.Width + " x i32] zeroinitializer";
//                                    }
//                                    ArrayString += "]";
//                                    Result.append(ArrayString + "\n");
//                                }
//                                if (isArrayUse && !isArrayEnd) {
//                                    ArrayString += ", ";
//                                }
//                                if (!isArrayUse) {
//                                    Result.append(ArrayString + "\n");
//                                }
//                            }
//                            // System.out.println(ArrayString);
//                        }
//                    }
//                    if (!isArrayEnd && isArrayUse) {
//                        if (this.Layer != 0) {
//                            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + ArrayUseLayer2;
//                            Result.append("\t").append(ResultString).append("\n");
//                            MoveNumber++;
//                            this.Register++;
//                            SaveRegister = this.Register - 1;
//                        }
//                    }
//                    if ((MoveNumber - 1) > arrayTable.SearchArray(this.ArrayName).Width && !isArrayUse) {
//                        System.out.println("Error:赋值数量大于数组元素个数" + this.ArrayName);
//                        System.exit(16);
//                    }
//                } else if (arrayTable.SearchArray(this.ArrayName).Dimension == 2) {
//                    // 二维数组
//                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
//                    int len = ctx.children.size() - 3;
//                    len = len / 2;
//                    if (ctx.constInitVal(0).children.size() == 1) {
//                        System.out.println("Error:二维数组不能用一维数组初始化");
//                        System.exit(16);
//                    }
//                    leftJudge = this.Register;
//                    isArrayUse = true;
//                    ArrayUseLayer1 = 0;
//                    ArrayUseLayer2 = arrayItem.Width;
//                    SaveRegisterFirst = this.Register - 1;
//                    if (len == 0) {
//                        isArrayEnd = true;
//                    } else {
//                        isArrayEnd = false;
//                        Index++;
//                    }
//                    visit(ctx.constInitVal(0));
//                    isArrayUse = false;
//                    for (int i = 0; i < len; i++) {
//                        visit(ctx.COMMA(i));
//                        isArrayUse = true;
//                        if ((i + 1) != len) {
//                            isArrayEnd = false;
//                            Index++;
//                        } else if ((i + 1) == len) {
//                            isArrayEnd = true;
//                        }
//                        ArrayUseLayer1 = (i + 1) * arrayItem.Width;
//                        ArrayUseLayer2 = (i + 2) * arrayItem.Width;
//                        visit(ctx.constInitVal(i + 1));
//                        isArrayUse = false;
//                    }
//                    isArrayUse = false;
//                    isArrayEnd = false;
//                    Index = 1;

//                } else {

                // 多维数组
                if (this.Layer != 0) {
                    Test1 = true;
                    int len = ctx.children.size() - 1;
                    len = len / 2;

                    for (int i = 0; i < len; i++) {
                        ArrayInit.add(i);
                        visit(ctx.getChild(2 * i + 1));
                        ArrayInit.remove(ArrayInit.size() - 1);
                    }
                    Test1 = false;
                } else {
                    ArrayItem arrayItem = arrayTable.SearchArray(ArrayName);
                    // 全局数组初始化
                    Test1 = true;
                    int len = ctx.children.size() - 1;
                    len = len / 2;

                    for (int i = 0; i < len; i++) {
                        int a;
                        if (ctx.children.size() == 2) {
                            a = 0;
                        } else {
                            a = ctx.children.size() / 2;
                        }
                        ArrayInit.add(i);
                        visit(ctx.getChild(2 * i + 1));
                        ArrayInit.remove(ArrayInit.size() - 1);
                    }
                    Test1 = false;
                }
//                }
            }
        }
        // return super.visitConstInitVal(ctx);
        return null;
    }

    @Override
    public Void visitVarDecl(CompileParser.VarDeclContext ctx) {
        visit(ctx.bType());
        int len = ctx.children.size() - 3;
        len = len / 2;
        String ResultString = "";
        for (int i = 0; i <= len; i++) {
            // 命名变量区域，直接调用allocate函数
            // 参考格式：%1 = alloca i32
            // 后续i32可能需要根据格式替换
//            if (this.Layer != 0) {
//                ResultString = "%x" + this.Register + " = alloca i32";
//                Result.append("\t").append(ResultString).append("\n");
//                // 不要忘记寄存器的值加一
//                // 一定要注意寄存器的值加一的位置，必须在访问varDef()节点前
//                this.Register++;
//            }
            // 注意isFuncReturn = true;语句的位置
            this.isFuncReturn = true;
            visit(ctx.varDef(i));
            // System.out.println("_____________" + this.Register);
        }
        // return super.visitVarDecl(ctx);
        return null;
    }

    @Override
    public Void visitVarDef(CompileParser.VarDefContext ctx) {
        visit(ctx.IDENT());
        // 声明的变量是否是数组
        if (ctx.L_BRACKT(0) == null) {
            // 声明的变量是整形变量
            if (this.Layer != 0) {
                String ResultString = "%x" + this.Register + " = alloca i32";
                Result.append("\t").append(ResultString).append("\n");
                // 不要忘记寄存器的值加一
                // 一定要注意寄存器的值加一的位置，必须在访问varDef()节点前
                this.Register++;
            }
        }
        if (symbolTable.LayerSearch(ctx.IDENT().toString(), this.Layer)) {
            System.out.println("Error:您的程序已经在同层内声明了相同名称的变量" + ctx.IDENT().toString());
            System.exit(3);
        }
        ArrayNamePass = ctx.IDENT().toString();
        if (ctx.ASSIGN() != null && ctx.L_BRACKT(0) != null) {
            // System.out.println("声明数组变量，初始化");
            int len = ctx.children.size() - 3;
            len = len / 3;
//            if (len > 2) {
//                System.out.println("Error:您声明的数组维数超过了2");
//                System.exit(14);
//            }

            if (this.Layer == 0) {
                ArrayName = ctx.IDENT().toString();
                ArrayNamePass = ctx.IDENT().toString();
//                if (len == 1) {
//                    visit(ctx.L_BRACKT(0));
//                    GString = "";
//                    visit(ctx.constExp(0));
//                    GString = gloableVar.AnalyseString(GString);
//                    // System.out.println(GString);
//                    int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                    GString = "";
//                    // const int a[3] = {1, 2};
//                    // @c = dso_local constant [3 x i32] [i32 1, i32 2, i32 0]
//                    ArrayString = "@x" + this.Register + " = dso_local global [" + result + " x i32]";
//                    this.Register++;
//                    visit(ctx.R_BRACKT(0));
//
//                    // 添加数组
//                    // System.out.println("这里来过了1");
//                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "int", 1, 1, result, true, 0, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "array", true, 0);
//                    gloableVar.gloableArray.add(variable);
//                    symbolTable.Table.add(variable);
//
//                    visit(ctx.initVal());
//                } else if (len == 2) {
//                    GString = "";
//                    visit(ctx.constExp(0));
//                    GString = gloableVar.AnalyseString(GString);
//                    int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                    GString = "";
//
//                    visit(ctx.constExp(1));
//                    GString = gloableVar.AnalyseString(GString);
//                    int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                    GString = "";
//
//                    // @c = dso_local constant [2 x [1 x i32]] [[1 x i32] [i32 1], [1 x i32] [i32 3]]
//                    ArrayString = "@x" + this.Register + " = dso_local global [" + result1 + " x [" + result2 + " x i32]]";
//                    this.Register++;
//
//                    // 添加数组
//                    // System.out.println("这里来过了2");
//                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "int", result1, 2, result2, true, 0, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "array", true, 0);
//                    gloableVar.gloableArray.add(variable);
//                    symbolTable.Table.add(variable);
//
//                    visit(ctx.initVal());
//                } else
                if (len == 0) {
                    System.out.println("Error:数组定义必须有中括号" + ctx.IDENT().toString() + " Array");
                    System.exit(18);
                } else {
                    // 多维数组全局变量赋值
                    // @x0 = dso_local global [1 x [3 x [3 x i32]]] [[3 x [3 x i32]] [[3 x i32] [i32 1, i32 3, i32 0], [3 x i32] [i32 1, i32 2, i32 3], [3 x i32] [i32 0, i32 0, i32 0]]]
                    StringBuilder TempAlloca = new StringBuilder("i32");
                    StringBuilder SecondString = new StringBuilder("[");
                    // 存储每个方括号内的数字大小
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    isConst = true;
                    for (int i = 0; i < len; i++) {
                        visit(ctx.L_BRACKT(i));
                        int result;
                        ArrayNumString = "";
                        isArrayParam = true;

                        visit(ctx.constExp(i));
                        isArrayParam = false;
                        result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
                        if (result <= 0) {
                            System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                            System.exit(17);
                        }
                        arrayList.add(result);
                        // 字符串还原
                        ArrayNumString = "";

                        visit(ctx.R_BRACKT(i));
                    }
                    // @x0 = dso_local global [1 x [3 x [3 x i32]]] [[3 x [3 x i32]] [[3 x i32] [i32 1, i32 3, i32 0], [3 x i32] [i32 1, i32 2, i32 3], [3 x i32] [i32 0, i32 0, i32 0]]]
                    ArrayString = "@x" + this.Register + " = dso_local global ";
                    this.Register++;

                    // 添加数组
                    // System.out.println("这里来过了2");
                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "int", len, arrayList, true, 0);
                    arrayTable.arrayItems.add(arrayItem);
                    Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "array", true, 0);
                    gloableVar.gloableArray.add(variable);
                    symbolTable.Table.add(variable);
                    // 数组名
                    ArrayName = ctx.IDENT().toString();

                    ArrayInit.clear();
                    Test1 = true;
                    visit(ctx.initVal());
                    Test1 = false;

                    ArrayInit.clear();
                    // 参数赋值
                    GlobalArrayInit(arrayList, 0, ArrayName);

                    Result.append(ArrayString).append("\n");

                    ArrayString = "";
                    ArrayInit.clear();
                    ArrayName = "";
                    isConst = false;
                    arrayItemInitList.arrayItemInitArrayList.clear();

                }

            } else {
//                if (len == 1) {
//                    // 一维数组
//                    visit(ctx.L_BRACKT(0));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(0));
//                    isArrayParam = false;
//                    // Result.append("\t2eqwdas\n");
//                    // 将返回到的表达式化简并求值
//                    // System.out.println(ArrayNumString);
//                    int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    visit(ctx.R_BRACKT(0));
//                    // 定义一维数组
//                    // %1 = alloca [2 x i32]
//                    String ResultString = "%x" + this.Register + " = alloca [" + result + " x i32]";
//                    Result.append("\t").append(ResultString).append("\n");
//                    int ArrayRegister = this.Register;
//                    this.Register++;
//                    // 给数组赋予空间，获取数组指针
//                    // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result + " x i32], [" + result + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t").append(ResultString).append("\n");
//                    this.Register++;
//                    // 初始化数组为0
//                    // call void @memset(i32* %4, i32 0, i32 16)
//                    ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
//                    Result.append("\t" + ResultString + "\n");
//                    // 声明调用的函数memset
//                    if (!functionList.returnFunction("memset").isUse) {
//                        Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                        // 将memset函数设置为已声明状态
//                        functionList.changeisUseFunction("memset");
//                    }
//                    // 添加数组
//                    ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "int", 1, 1, result, true, this.Layer, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "array", true, this.Layer);
//                    symbolTable.Table.add(variable);
//
//                    // 数组赋值
//                    visit(ctx.ASSIGN());
//                    this.ArrayName = ctx.IDENT().toString();
//                    this.isArrayValue = true;
//                    isArrayUse = false;
//                    visit(ctx.initVal());
//                    this.isArrayValue = false;
//                    // VarDef 中表示各维长度的 ConstExp 必须能在编译时求值到非负整数的常量表达式。
//                    // 在声明数组时各维长度都需要显式给出，而不允许是未知的。
//                    // 这里采用直接求出表达式的值，不再采用寄存器的方式
//                } else if (len == 2) {
//                    // 二维数组
//                    visit(ctx.L_BRACKT(0));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(0));
//                    isArrayParam = false;
//                    // 将返回到的表达式化简并求值
//                    int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result1 <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    visit(ctx.R_BRACKT(0));
//                    visit(ctx.L_BRACKT(1));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(1));
//                    isArrayParam = false;
//                    // 将返回到的表达式化简并求值
//                    int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result2 <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    // %1 = alloca [2 x [2 x i32]]
//                    String ResultString = "";
//                    ResultString = "%x" + this.Register + " = alloca [" + result1 + " x [" + result2 + " x i32]]";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    int ArrayRegister = this.Register - 1;
//
//                    // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
//                    // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                    // call void @memset(i32* %4, i32 0, i32 16)
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result1 + " x [" + result2 + " x i32]], [" + result1 + " x [" + result2 + " x i32]]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result2 + " x i32], [" + result2 + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    if (!functionList.isUseFunction("memset")) {
//                        Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                        // 将memset函数设置为已声明状态
//                        functionList.changeisUseFunction("memset");
//                    }
//                    ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result1 * result2 * 4) + ")";
//                    Result.append("\t" + ResultString + "\n");
//                    visit(ctx.R_BRACKT(1));
//
//                    // 添加数组
//                    ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "int", result1, 2, result2, true, this.Layer, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "array", true, this.Layer);
//                    symbolTable.Table.add(variable);
//
//                    // 注意先添加数组再数组赋值，否则会在赋值时找不到定义的数组
//                    visit(ctx.ASSIGN());
//                    this.ArrayName = ctx.IDENT().toString();
//                    this.isArrayValue = true;
//                    visit(ctx.initVal());
//                    this.isArrayValue = false;
//
//                } else {
                // 多维数组
                // %1 = alloca [2 x [2 x i32]]
                if (len == 0) {
                    System.out.println("Error:数组定义必须有中括号" + ctx.IDENT().toString() + " Array");
                    System.exit(18);
                }
                StringBuilder TempAlloca = new StringBuilder("i32");
                // 存储每个方括号内的数字大小
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    visit(ctx.L_BRACKT(i));
                    int result;
                    ArrayNumString = "";
                    isArrayParam = true;
                    visit(ctx.constExp(i));
                    isArrayParam = false;
                    result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
                    if (result <= 0) {
                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                        System.exit(17);
                    }
                    arrayList.add(result);
                    // 字符串还原
                    ArrayNumString = "";

                    visit(ctx.R_BRACKT(i));
                }

                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    TempAlloca = new StringBuilder("[" + arrayList.get(i) + " x " + TempAlloca + "]");
                }

                // 走出循环的TempAlloca中存储的就是数组声明alloca右边的语句
                // System.out.println("Test\t%x" + this.Register + " = alloca " + TempAlloca + "\n");
                Result.append("\t%x").append(this.Register).append(" = alloca ").append(TempAlloca).append("\n");
                ArrayFirstRegister = this.Register;
                this.Register++;
                ArrayName = ctx.IDENT().toString();

                // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
                String temp = "";
                int result = 1; // memset()函数中使用
                for (int i = 0; i < len; i++) {
                    temp += ", i32 0";
                    result *= arrayList.get(i);
                }
                temp = "%x" + this.Register + " = getelementptr " + TempAlloca + ", " + TempAlloca + "* %x" + ArrayFirstRegister + ", i32 0" + temp;
                Result.append("\t").append(temp).append("\n");
                this.Register++;

                // 初始化数组为0
                // call void @memset(i32* %4, i32 0, i32 16)
                temp = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
                Result.append("\t").append(temp).append("\n");
                // 声明调用的函数memset
                if (!functionList.returnFunction("memset").isUse) {
                    Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
                    // 将memset函数设置为已声明状态
                    functionList.changeisUseFunction("memset");
                }

                // 添加数组
                ArrayItem arrayItem = new ArrayItem(ArrayFirstRegister, ctx.IDENT().toString(), "int", len, arrayList, true, this.Layer);
                arrayTable.arrayItems.add(arrayItem);
                Variable variable = new Variable(ArrayFirstRegister, ctx.IDENT().toString(), 0, "array", true, this.Layer);
                symbolTable.Table.add(variable);

                // 数组赋值
                visit(ctx.ASSIGN());
                this.ArrayName = ctx.IDENT().toString();
                this.isArrayValue = true;
                isArrayUse = false;
                Test1 = true;
                visit(ctx.initVal());
                Test1 = false;
                this.isArrayValue = false;
//                }
            }
//            for (int i = 0; i < len; i++) {
//                visit(ctx.L_BRACKT(i));
//                visit(ctx.constExp(i));
//                visit(ctx.R_BRACKT(i));
//            }
        } else if (ctx.ASSIGN() == null && ctx.L_BRACKT(0) != null) {
            // System.out.println("声明数组变量，没有初始化");
            int len = ctx.children.size() - 1;
            len = len / 3;
            if (this.Layer == 0) {
                // 全局变量数组
//                if (len == 1) {
//                    // 一维数组
//                    // @d = dso_local global [5 x i32] zeroinitializer
//                    String ResultString = "";
//                    GString = "";
//                    visit(ctx.constExp(0));
//                    GString = gloableVar.AnalyseString(GString);
//                    int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                    ResultString = "@x" + this.Register + " = dso_local global [" + result + " x i32] zeroinitializer";
//                    Result.append(ResultString).append("\n");
//                    GString = "";
//                    this.Register++;
//                    // 添加数组
//                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "int", 1, 1, result, true, 0, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "array", true, 0);
//                    gloableVar.gloableArray.add(variable);
//                    symbolTable.Table.add(variable);
//                } else if (len == 2) {
//                    // 二维数组
//                    // @e = dso_local global [4 x [4 x i32]] zeroinitializer
//                    String ResultString = "";
//                    GString = "";
//                    visit(ctx.constExp(0));
//                    GString = gloableVar.AnalyseString(GString);
//                    int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//
//                    GString = "";
//                    visit(ctx.constExp(1));
//                    GString = gloableVar.AnalyseString(GString);
//                    int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//
//                    ResultString = "@x" + this.Register + " = dso_local global [" + result1 + " x [" + result2 + " x i32]] zeroinitializer";
//                    Result.append(ResultString).append("\n");
//                    GString = "";
//                    this.Register++;
//                    // 添加数组
//                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, ctx.IDENT().toString(), "int", result1, 2, result2, true, 0, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "array", true, 0);
//                    gloableVar.gloableArray.add(variable);
//                    symbolTable.Table.add(variable);
//                } else {
                // 多维数组
                StringBuilder TempAlloca = new StringBuilder("i32");
                // 存储每个方括号内的数字大小
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    visit(ctx.L_BRACKT(i));
                    int result;
                    GString = "";
                    isArrayParam = true;
                    visit(ctx.constExp(i));
                    isArrayParam = false;
                    result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(GString)));
                    if (result <= 0) {
                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                        System.exit(17);
                    }
                    arrayList.add(result);
                    // 字符串还原
                    GString = "";

                    visit(ctx.R_BRACKT(i));
                }

                // @e = dso_local global [4 x [4 x i32]] zeroinitializer
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    TempAlloca = new StringBuilder("[" + arrayList.get(i) + " x " + TempAlloca + "]");
                }

                Result = new StringBuffer("@x" + this.Register + " = dso_local global " + TempAlloca + " zeroinitializer\n" + Result);

                ArrayItem arrayItem = new ArrayItem(this.Register, ctx.IDENT().toString(), "int", len, arrayList, true, 0);
                arrayTable.arrayItems.add(arrayItem);
                Variable variable = new Variable(this.Register, ctx.IDENT().toString(), 0, "array", true, 0);
                gloableVar.gloableArray.add(variable);
                symbolTable.Table.add(variable);

                this.Register++;
//                }

            } else {
//                if (len == 1) {
//                    // 一维数组
//                    visit(ctx.L_BRACKT(0));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(0));
//                    isArrayParam = false;
//                    // Result.append("\t2eqwdas\n");
//                    // 将返回到的表达式化简并求值
//                    int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    visit(ctx.R_BRACKT(0));
//                    // 定义一维数组
//                    // %1 = alloca [2 x i32]
//                    String ResultString = "%x" + this.Register + " = alloca [" + result + " x i32]";
//                    Result.append("\t").append(ResultString).append("\n");
//                    this.Register++;
//                    int ArrayRegister = this.Register - 1;
//                    // 给数组赋予空间，获取数组指针
//                    // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result + " x i32], [" + result + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t").append(ResultString).append("\n");
//                    this.Register++;
//                    if (!functionList.isUseFunction("memset")) {
//                        Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                        // 将memset函数设置为已声明状态
//                        functionList.changeisUseFunction("memset");
//                    }
//                    // 初始化数组为0
//                    // call void @memset(i32* %4, i32 0, i32 16)
//                    ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
//                    Result.append("\t" + ResultString + "\n");
//
//                    ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "int", 1, 1, result, false, this.Layer, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "array", false, this.Layer);
//                    symbolTable.Table.add(variable);
//                } else if (len == 2) {
//                    // 二维数组
//                    visit(ctx.L_BRACKT(0));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(0));
//                    isArrayParam = false;
//                    // 将返回到的表达式化简并求值
//                    int result1 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result1 <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    visit(ctx.R_BRACKT(0));
//                    visit(ctx.L_BRACKT(1));
//                    ArrayNumString = "";
//                    isArrayParam = true;
//                    visit(ctx.constExp(1));
//                    isArrayParam = false;
//                    // 将返回到的表达式化简并求值
//                    int result2 = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
//                    if (result2 <= 0) {
//                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
//                        System.exit(17);
//                    }
//                    // result的值是一维数组的数组长度
//                    // 字符串还原
//                    ArrayNumString = "";
//                    // %1 = alloca [2 x [2 x i32]]
//                    String ResultString = "";
//                    ResultString = "%x" + this.Register + " = alloca [" + result1 + " x [" + result2 + " x i32]]";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    int ArrayRegister = this.Register - 1;
//
//                    // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
//                    // %4 = getelementptr [2 x i32], [2 x i32]* %3, i32 0, i32 0
//                    // call void @memset(i32* %4, i32 0, i32 16)
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result1 + " x [" + result2 + " x i32]], [" + result1 + " x [" + result2 + " x i32]]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    ResultString = "%x" + this.Register + " = getelementptr [" + result2 + " x i32], [" + result2 + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//                    Result.append("\t" + ResultString + "\n");
//                    this.Register++;
//                    if (!functionList.isUseFunction("memset")) {
//                        Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                        // 将memset函数设置为已声明状态
//                        functionList.changeisUseFunction("memset");
//                    }
//                    if (!functionList.isUseFunction("memset")) {
//                        Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
//                        // 将memset函数设置为已声明状态
//                        functionList.changeisUseFunction("memset");
//                    }
//                    ResultString = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result1 * result2 * 4) + ")";
//                    Result.append("\t" + ResultString + "\n");
//                    visit(ctx.R_BRACKT(1));
//
//                    // 添加数组
//                    ArrayItem arrayItem = new ArrayItem(ArrayRegister, ctx.IDENT().toString(), "int", result1, 2, result2, true, this.Layer, new HashMap<>());
//                    arrayTable.arrayItems.add(arrayItem);
//                    Variable variable = new Variable(ArrayRegister, ctx.IDENT().toString(), 0, "array", true, this.Layer);
//                    symbolTable.Table.add(variable);
//                } else {
                // 多维数组
                // %1 = alloca [2 x [2 x i32]]
                StringBuilder TempAlloca = new StringBuilder("i32");
                // 存储每个方括号内的数字大小
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    visit(ctx.L_BRACKT(i));
                    int result;
                    ArrayNumString = "";
                    isArrayParam = true;
                    visit(ctx.constExp(i));
                    isArrayParam = false;
                    result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(gloableVar.AnalyseString(ArrayNumString)));
                    if (result <= 0) {
                        System.out.println("Error:定义数组的长度不能为0或负数" + ctx.IDENT().toString() + " Array");
                        System.exit(17);
                    }
                    arrayList.add(result);
                    // 字符串还原
                    ArrayNumString = "";

                    visit(ctx.R_BRACKT(i));
                }

                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    TempAlloca = new StringBuilder("[" + arrayList.get(i) + " x " + TempAlloca + "]");
                }

                // 走出循环的TempAlloca中存储的就是数组声明alloca右边的语句
                // System.out.println("Test\t%x" + this.Register + " = alloca " + TempAlloca + "\n");
                Result.append("\t%x").append(this.Register).append(" = alloca ").append(TempAlloca).append("\n");
                ArrayFirstRegister = this.Register;
                this.Register++;
                ArrayName = ctx.IDENT().toString();

                // %3 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
                String temp = "";
                int result = 1; // memset()函数中使用
                for (int i = 0; i < len; i++) {
                    temp += ", i32 0";
                    result *= arrayList.get(i);
                }
                temp = "%x" + this.Register + " = getelementptr " + TempAlloca + ", " + TempAlloca + "* %x" + ArrayFirstRegister + ", i32 0" + temp;
                Result.append("\t").append(temp).append("\n");
                this.Register++;

                // 初始化数组为0
                // call void @memset(i32* %4, i32 0, i32 16)
                temp = "call void @memset(i32* %x" + (this.Register - 1) + ", i32 0, i32 " + (result * 4) + ")";
                Result.append("\t").append(temp).append("\n");
                // 声明调用的函数memset
                if (!functionList.returnFunction("memset").isUse) {
                    Result = new StringBuffer("declare void @memset(i32*, i32, i32)\n" + Result);
                    // 将memset函数设置为已声明状态
                    functionList.changeisUseFunction("memset");
                }

                // 添加数组
                ArrayItem arrayItem = new ArrayItem(ArrayFirstRegister, ctx.IDENT().toString(), "int", len, arrayList, true, this.Layer);
                arrayTable.arrayItems.add(arrayItem);
                Variable variable = new Variable(ArrayFirstRegister, ctx.IDENT().toString(), 0, "array", true, this.Layer);
                symbolTable.Table.add(variable);
//                }
            }
//            for (int i = 0; i < len; i++) {
//                visit(ctx.L_BRACKT(i));
//                visit(ctx.constExp(i));
//                visit(ctx.R_BRACKT(i));
//            }
        } else if (ctx.ASSIGN() != null && ctx.L_BRACKT(0) == null) {
            if (this.Layer == 0) {
                GString = "";
                visit(ctx.initVal());
                // System.out.print(GString + "-");
                GString = gloableVar.AnalyseString(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
                // System.out.println(result);
                Variable variable = new Variable(this.Register, ctx.IDENT().toString(), result, "int", true, 0);
                symbolTable.Table.add(variable);
                gloableVar.gloableArray.add(variable);
                GString = "";
                Result.append("@x").append(this.Register).append(" = dso_local global i32 ").append(result).append("\n");
                this.Register++;
            } else {
                // 变量已经赋值
                int leftJudge, rightJudge;
                int Num;
                this.isValue = true;
                String ResultString = "";
                visit(ctx.IDENT());
                visit(ctx.ASSIGN());
                leftJudge = this.Register;
                // 一定要将this.isFuncValue的值在进入判断函数前重置为true
                this.isFuncValue = true;
                GString = "";
                visit(ctx.initVal());
                // 判断赋值变量是否赋值
                if (!this.isValue) {
                    System.out.println("Error:您的初始化赋值语句右边调用了没有初始化的变量" + ctx.IDENT().toString());
                    System.exit(8);
                }
                // 判断是否调用了函数返回值
                if (!this.isFuncValue) {
                    System.out.println("Error:您的初始化赋值语句右边调用了没有返回值的函数" + ctx.IDENT().toString());
                    System.exit(9);
                }
                // 还原为true
                this.isValue = true;
                this.isFuncValue = true;
                rightJudge = this.Register;
                Num = this.TempNum;
                if (leftJudge == rightJudge) {
                    // 没有调用新的寄存器，变量中直接存储数字的大小
                    // 一定要注意，调用的是leftJudge而不是Register，调用Register会导致寄存器的值不再是一开始定义的变量寄存器的值
                    Variable variable = new Variable(leftJudge - 1, ctx.IDENT().toString(), Num, "int", true, this.Layer);
                    symbolTable.Table.add(variable);
                    // 参考格式：store i32 2, i32* %1
                    ResultString = "store i32 " + Num + ", i32* %x" + (leftJudge - 1);
                } else {
                    // 调用了新的寄存器，变量中存储保存值的寄存器
                    Variable variable = new Variable(leftJudge - 1, ctx.IDENT().toString(), rightJudge - 1, "int", true, this.Layer);
                    symbolTable.Table.add(variable);
                    // 参考格式：store i32 %2, i32* %1
                    ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + (leftJudge - 1);
                }
                // System.out.println(ctx.IDENT().getText() + " = %x" + (leftJudge - 1));
                Result.append("\t").append(ResultString).append("\n");
            }
        } else {
            // 变量还没有赋值，不需要输出语句
            // 全局变量
            if (this.Layer == 0) {
                // 注意，全局变量寄存器的值是随着this.Register变化的
                Variable variable1 = new Variable(this.Register, ctx.IDENT().toString(), 0, "i32", true, 0);
                symbolTable.Table.add(variable1);
                gloableVar.gloableArray.add(variable1);
                GString = "";
                Result.append("@x").append(this.Register).append(" = dso_local global i32 0\n");
                this.Register++;
            } else {
                visit(ctx.IDENT());
                Variable variable = new Variable(this.Register - 1, ctx.IDENT().toString(), 0, "int", false, this.Layer);
                symbolTable.Table.add(variable);
            }
        }
        // return super.visitVarDef(ctx);
        return null;
    }

    @Override
    public Void visitInitVal(CompileParser.InitValContext ctx) {
        // 先不管第二种复杂的情况
        if (ctx.children.size() == 1) {
            // System.out.println("exp1 " + isArrayUse);
            int leftJudge, rightJudge;
            int Num;
            leftJudge = this.Register;
            visit(ctx.exp());
            rightJudge = this.Register;
            Num = TempNum;
            /*
             * %x2 = getelementptr [1 x [2 x [3 x i32]]], [1 x [2 x [3 x i32]]]* %x0, i32 0, i32 0, i32 0, i32 0
             * store i32 1, i32* %x2
             */
            if (Test1 && this.Layer != 0) {
                String ResultString = "i32";
                ArrayItem arrayItem = arrayTable.SearchArray(ArrayNamePass);
                for (int i = 0; i < arrayTable.SearchArray(ArrayNamePass).Dimension; i++) {
                    // System.out.println(ArrayInit.get(i) + " " + arrayItem.arrayList.get(i));
                    if (ArrayInit.size() != arrayItem.arrayList.size()) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    if (ArrayInit.get(i) >= arrayItem.arrayList.get(i)) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                }
                for (int i = arrayItem.arrayList.size() - 1; i >= 0; i--) {
                    ResultString = "[" + arrayItem.arrayList.get(i) + " x " + ResultString + "]";
                }
                ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* %x" + arrayItem.ArrayRegister + ", i32 0";
                for (int i = 0; i < arrayItem.Dimension; i++) {
                    ResultString += ", i32 " + ArrayInit.get(i);
                }
                this.Register++;
                Result.append("\t").append(ResultString).append("\n");
                if (leftJudge == rightJudge) {
                    ResultString = "store i32 " + Num + ", i32* %x" + (this.Register - 1);
                } else {
                    ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + (this.Register - 1);
                }
                Result.append("\t").append(ResultString).append("\n");
                // ArrayInit.clear();
            } else if (Test1) {
                // 全局变量
                GString = "";
                visit(ctx.exp());
                GString = gloableVar.AnalyseString(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));   // 数组元素值
                // System.out.println(result);
                int r = arrayTable.SearchArray(ArrayNamePass).ArrayRegister;    // 数组元素所在数组寄存器值
                ArrayList<Integer> arrayList = new ArrayList<>();           // 数组元素所在数组位置
                // System.out.println(ArrayInit);
                ArrayItem arrayItem = arrayTable.SearchArray(ArrayNamePass);
                for (int i = 0; i < arrayTable.SearchArray(ArrayNamePass).Dimension; i++) {
                    // System.out.println(ArrayInit.get(i) + " " + arrayItem.arrayList.get(i));
                    if (ArrayInit.size() != arrayTable.SearchArray(ArrayNamePass).Dimension) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    if (ArrayInit.get(i) >= arrayItem.arrayList.get(i)) {
                        System.out.println("Error:数组维数与赋值不匹配");
                        System.exit(22);
                    }
                    arrayList.add(ArrayInit.get(i));
                }
                // System.out.println(">>>" + arrayList);
                ArrayItemInit arrayItemInit = new ArrayItemInit(result, ArrayNamePass, r, arrayList);

                arrayItemInitList.arrayItemInitArrayList.add(arrayItemInit);

            }

        } else {
            if (!symbolTable.SearchValue(this.ArrayNamePass).Type.contains("array")) {
                System.out.println("Error:赋值类型错误array");
                System.exit(16);
            }
            if (ctx.initVal(0) == null && !Test1) {
                ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayNamePass);
                visit(ctx.L_BRACE());
                visit(ctx.R_BRACE());
                // 全为0，不用输出语
                // 全局变量数组需要输出0
                if (this.Layer == 0) {
                    if (arrayItem.Dimension == 1) {
                        ArrayString += "[i32 0";
                        for (int i = 0; i < arrayItem.Width - 1; i++) {
                            ArrayString += ", i32 0";
                        }
                        ArrayString += "]";
                        Result.append(ArrayString).append("\n");
                    } else {
                        ArrayString += "zeroinitializer";
                        Result.append(ArrayString).append("\n");
                    }
                }
                // 全为0，不用输出语
            } else if (!Test1 && ctx.initVal(0).children.size() == 2) {
                // int a[2][2] = {{},{}};
                // System.out.println("sacccccccccc");
                if (ctx.initVal(1) != null) {
                    if (ctx.initVal(1).children.size() == 2) {
                        ArrayString += " zeroinitializer";
                        Result.append(ArrayString).append("\n");

                    }
                } else {
                    ArrayString += " zeroinitializer";
                    Result.append(ArrayString).append("\n");
                }
            } else {

//                int leftJudge, rightJudge;
//                int Num;
//                int SaveRegister = this.Register - 1;
//                if (isArrayUse && Index == 2) {
//                    ArrayString += " [";
//                }
//                if (!isArrayUse) {
//                    SaveRegisterFirst = this.Register - 1;
//                }
//                String ResultString = "";
//                // Result.append("Name = " + this.ArrayName);
//                if (!Test1 && (arrayTable.SearchArray(this.ArrayName).Dimension == 1 || isArrayUse)) {
//                    // 一维数组
//                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
//                    int len = ctx.children.size() - 3;
//                    len = len / 2;
//                    // System.out.println("Name = " + this.ArrayName + arrayTable.SearchArray(this.ArrayName).Dimension);
//                    // 需要加上判断条件没有初始化二维数组时
//                    if (ctx.initVal(0).children.size() != 1 && !isArrayUse) {
//                        System.out.println("Error:一维数组不能用二维数组初始化");
//                        System.exit(16);
//                    }
//                    // store i32 1, i32* %4
//                    // %5 = getelementptr i32, i32* %4, i32 2
//                    leftJudge = this.Register;
//                    if (this.Layer == 0) {
//                        GString = "";
//                    }
//                    visit(ctx.initVal(0));
//                    // System.out.println(Test1);
//                    // System.out.println(GString + ArrayName);
//                    if (this.Layer == 0) {
//                        GString = gloableVar.AnalyseString(GString);
//                        int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                        GString = "";
//                        // [i32 1, i32 2, i32 0]
//                        if (isArrayUse) {
//                            ArrayString += "[" + arrayItem.Width + " x i32] [i32 " + result;
//                        } else {
//                            ArrayString += "[i32 " + result;
//                        }
//                    }
//                    rightJudge = this.Register;
//                    Num = TempNum;
//                    // 没有考虑全局变量
//                    if (this.Layer != 0) {
//                        if (leftJudge == rightJudge) {
//                            ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
//                        } else {
//                            ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
//                        }
//                        Result.append("\t").append(ResultString).append("\n");
//                    }
//                    // 记录指针移动次数
//                    int MoveNumber = 1;
//                    if (isArrayUse) {
//                        MoveNumber = ArrayUseLayer1 + 1;
//                    }
//                    if (len == 0 && this.Layer == 0) {
//                        // System.out.println("wofule");
//                        for (int i = 1; i < arrayItem.Width; i++) {
//                            ArrayString += ", i32 0";
//                        }
//                        ArrayString += "]";
//                        if (isArrayEnd && isArrayUse) {
//                            int a = arrayItem.ArrayLayer - Index;
//                            for (int i = 0; i < a; i++) {
//                                ArrayString += ", [" + arrayItem.Width + " x i32] zeroinitializer";
//                            }
//                            ArrayString += "]";
//                            Result.append(ArrayString + "\n");
//                        } else if (!isArrayEnd && isArrayUse) {
//                            ArrayString += ", ";
//                        } else if (!isArrayUse) {
//                            Result.append(ArrayString + "\n");
//                        }
//                    }
//                    if (len != 0) {
//                        if (this.Layer != 0) {
//                            // 需要再输出getelementptr移动指针命令
//                            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
//                            Result.append("\t").append(ResultString).append("\n");
//                            MoveNumber++;
//                            this.Register++;
//                            SaveRegister = this.Register - 1;
//                        }
//                    } else {
////                        if (this.Layer == 0) {
////                            for (int i = 1; i < arrayItem.Width; i++) {
////                                ArrayString += ", i32 0";
////                            }
////                            System.out.println("111111111111111" + isArrayUse);
////                            if (!isArrayEnd || Index == 1) {
////                                ArrayString += "],";
////                            } else {
////                                ArrayString += "]";
////                            }
////                            if (!isArrayUse) {
////                                Result.append(ArrayString + "\n");
////                            }
////                            if (isArrayEnd && Index == 1) {
////                                Result.append(ArrayString + "[" + arrayItem.Width + " x i32] zeroinitializer]").append("\n");
////                            }
////                            if (isArrayEnd && Index != 1) {
////                                Result.append(ArrayString + "]").append("\n");
////                            }
////                        }
//                    }
//                    for (int i = 0; i < len; i++) {
//                        visit(ctx.COMMA(i));
//                        // 需要加上判断条件没有使用二维数组初始化时
//                        if (ctx.initVal(i + 1).children.size() != 1 && !isArrayUse) {
//                            System.out.println("Error:一维数组不能用二维数组初始化");
//                            System.exit(16);
//                        }
//                        leftJudge = this.Register;
//                        GString = "";
//                        visit(ctx.initVal(i + 1));
//                        if (this.Layer == 0) {
//                            GString = gloableVar.AnalyseString(GString);
//                            int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
//                            GString = "";
//                            ArrayString += ", i32 " + result;
//                        }
//                        rightJudge = this.Register;
//                        Num = TempNum;
//                        if (this.Layer != 0) {
//                            if (leftJudge == rightJudge) {
//                                ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
//                            } else {
//                                ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
//                            }
//                            Result.append("\t").append(ResultString).append("\n");
//                        }
//                        // 记录指针移动次数
//                        if (i + 1 != len) {
//                            // 需要再输出getelementptr移动指针命令
//                            if (this.Layer != 0) {
//                                ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
//                                Result.append("\t").append(ResultString).append("\n");
//                                MoveNumber++;
//                                this.Register++;
//                                SaveRegister = this.Register - 1;
//                            }
//                        } else {
//                            if (this.Layer == 0) {
//                                for (int i1 = i + 2; i1 < arrayItem.Width; i1++) {
//                                    ArrayString += ", i32 0";
//                                }
//                                ArrayString += "]";
//                                if (isArrayEnd && isArrayUse) {
//                                    int a = arrayItem.ArrayLayer - Index;
//                                    for (int i1 = 0; i1 < a; i1++) {
//                                        ArrayString += ", [" + arrayItem.Width + " x i32] zeroinitializer";
//                                    }
//                                    ArrayString += "]";
//                                    Result.append(ArrayString).append("\n");
//                                }
//                                if (isArrayUse && !isArrayEnd) {
//                                    ArrayString += ", ";
//                                }
//                                if (!isArrayUse) {
//                                    Result.append(ArrayString).append("\n");
//                                }
//                            }
//                            // System.out.println(ArrayString);
//                        }
//                    }
//                    // System.out.println(isArrayEnd + ArrayName);
//                    // System.out.println(isArrayUse + ArrayName);
//                    if (!isArrayEnd && isArrayUse) {
//                        if (this.Layer != 0) {
//                            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + ArrayUseLayer2;
//                            Result.append("\t").append(ResultString).append("\n");
//                            MoveNumber++;
//                            this.Register++;
//                            SaveRegister = this.Register - 1;
//                        }
//                    }
//                    // System.out.println(this.ArrayName);
//                    if ((MoveNumber - 1) > arrayTable.SearchArray(this.ArrayName).Width && !isArrayUse) {
//                        System.out.println("Error:赋值数量大于数组元素个数" + this.ArrayName);
//                        System.exit(16);
//                    }
//                } else if (arrayTable.SearchArray(this.ArrayName).Dimension == 2) {
//                    // 二维数组
//                    // System.out.println("asffffff");
//                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
//                    int len = ctx.children.size() - 3;
//                    len = len / 2;
//                    if (ctx.initVal(0).children.size() == 1) {
//                        System.out.println("Error:二维数组不能用一维数组初始化");
//                        System.exit(16);
//                    }
//                    leftJudge = this.Register;
//                    isArrayUse = true;
//                    ArrayUseLayer1 = 0;
//                    ArrayUseLayer2 = arrayItem.Width;
//                    SaveRegisterFirst = this.Register - 1;
//                    if (len == 0) {
//                        isArrayEnd = true;
//                    } else {
//                        isArrayEnd = false;
//                        Index++;
//                    }
//                    // System.out.println(isArrayUse);
//                    visit(ctx.initVal(0));
//                    // Result.append("\t测试，这里需要插入一句话\n");
//                    isArrayUse = false;
//                    for (int i = 0; i < len; i++) {
//                        visit(ctx.COMMA(i));
//                        isArrayUse = true;
//                        if ((i + 1) != len) {
//                            isArrayEnd = false;
//                            Index++;
//                        } else if ((i + 1) == len) {
//                            isArrayEnd = true;
//                        }
//                        ArrayUseLayer1 = (i + 1) * arrayItem.Width;
//                        ArrayUseLayer2 = (i + 2) * arrayItem.Width;
//                        visit(ctx.initVal(i + 1));
//                        isArrayUse = false;
//                    }
//                    isArrayUse = false;
//                    isArrayEnd = false;
//                    Index = 1;

                // } else {
                // 多维数组
                // int a[1][2][3] ={{{1,2,3},{1,2,3}}};
                // 下面处理的妙啊
                if (this.Layer != 0) {
                    Test1 = true;
                    int len = ctx.children.size() - 1;
                    len = len / 2;

                    for (int i = 0; i < len; i++) {
                        ArrayInit.add(i);
                        visit(ctx.getChild(2 * i + 1));
                        ArrayInit.remove(ArrayInit.size() - 1);
                    }
                    Test1 = false;
                } else {
                    ArrayItem arrayItem = arrayTable.SearchArray(ArrayNamePass);
                    // 全局数组初始化
                    Test1 = true;
                    int len = ctx.children.size() - 1;
                    len = len / 2;

                    for (int i = 0; i < len; i++) {
                        int a;
                        if (ctx.children.size() == 2) {
                            a = 0;
                        } else {
                            a = ctx.children.size() / 2;
                        }
                        ArrayInit.add(i);
                        visit(ctx.getChild(2 * i + 1));
                        ArrayInit.remove(ArrayInit.size() - 1);
                    }
                    Test1 = false;
                    // }

//                        visit(ctx.initVal(0));
//                        if (Test1) {
//                            System.out.println(ArrayInit);
//                            if (ctx.children.size() == 3) {
//                                ArrayInit.remove(ArrayInit.size() - 1);
//                                ArrayInit.remove(ArrayInit.size() - 1);
//                            } else {
//                                ArrayInit.remove(ArrayInit.size() - 1);
//                            }
//                            Test1 = false;
//                        }
//                        for (int i = 0;i < len;i++) {
//                            ArrayInit.add(i + 1);
//                            visit(ctx.COMMA(i));
//
//                            visit(ctx.initVal(i + 1));
//                            if (Test1) {
//                                System.out.println(ArrayInit);
//                                if (i + 1 == len) {
//                                    ArrayInit.remove(ArrayInit.size() - 1);
//                                    ArrayInit.remove(ArrayInit.size() - 1);
//                                } else {
//                                    ArrayInit.remove(ArrayInit.size() - 1);
//                                }
//                                Test1 = false;
//                            }
//                        }
                }
                /*int leftJudge, rightJudge;
                int Num;
                int SaveRegister = this.Register - 1;
                if (!isArrayUse) {
                    SaveRegisterFirst = this.Register - 1;
                }
                String ResultString = "";
                if (arrayTable.SearchArray(this.ArrayName).Dimension == 1 || isArrayUse) {
                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
                    // 一维数组
                    int len = ctx.children.size() - 3;
                    len = len / 2;
                    if (ctx.initVal(0).children.size() != 1) {
                        System.out.println("Error:一维数组不能用二维数组初始化");
                        System.exit(16);
                    }
                    // store i32 1, i32* %4
                    // %5 = getelementptr i32, i32* %4, i32 2
                    leftJudge = this.Register;
                    visit(ctx.initVal(0));
                    rightJudge = this.Register;

                    Num = TempNum;
                    // 没有考虑全局变量
                    if (leftJudge == rightJudge) {
                        ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
                    } else {
                        ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
                    }
                    Result.append("\t").append(ResultString).append("\n");
                    // 记录指针移动次数
                    int MoveNumber = 1;
                    if (isArrayUse) {
                        MoveNumber = ArrayUseLayer1 + 1;
                    }
                    if (len != 0) {
                        // 需要再输出getelementptr移动指针命令
                        ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
                        Result.append("\t").append(ResultString).append("\n");
                        MoveNumber++;
                        this.Register++;
                        SaveRegister = this.Register - 1;
                    }
                    for (int i = 0; i < len; i++) {
                        visit(ctx.COMMA(i));
                        if (ctx.initVal(i + 1).children.size() != 1) {
                            System.out.println("Error:一维数组不能用二维数组初始化");
                            System.exit(16);
                        }
                        leftJudge = this.Register;
                        visit(ctx.initVal(i + 1));

                        rightJudge = this.Register;
                        Num = TempNum;
                        if (leftJudge == rightJudge) {
                            ResultString = "store i32 " + Num + ", i32* %x" + SaveRegister;
                        } else {
                            ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + SaveRegister;
                        }
                        Result.append("\t").append(ResultString).append("\n");
                        // 记录指针移动次数
                        if (i + 1 != len) {
                            // 需要再输出getelementptr移动指针命令
                            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + MoveNumber;
                            Result.append("\t").append(ResultString).append("\n");
                            MoveNumber++;
                            this.Register++;
                            SaveRegister = this.Register - 1;
                        }
                    }
                    if (!isArrayEnd && isArrayUse) {
                        ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegisterFirst + ", i32 " + ArrayUseLayer2;
                        Result.append("\t").append(ResultString).append("\n");
                        MoveNumber++;
                        this.Register++;
                        SaveRegister = this.Register - 1;
                    }
                    if ((MoveNumber - 1) > arrayTable.SearchArray(this.ArrayName).Width && !isArrayUse) {
                        System.out.println("Error:赋值数量大于数组元素个数" + this.ArrayName);
                        System.exit(16);
                    }
                } else if (arrayTable.SearchArray(this.ArrayName).Dimension == 2) {
                    // 二维数组
                    ArrayItem arrayItem = arrayTable.SearchArray(this.ArrayName);
                    int len = ctx.children.size() - 3;
                    len = len / 2;
                    if (ctx.initVal(0).children.size() == 1) {
                        System.out.println("Error:二维数组不能用一维数组初始化");
                        System.exit(16);
                    }
                    leftJudge = this.Register;
                    isArrayUse = true;
                    ArrayUseLayer1 = 0;
                    ArrayUseLayer2 = arrayItem.Width;
                    SaveRegisterFirst = this.Register - 1;
                    visit(ctx.initVal(0));
                    isArrayUse = false;
                    for (int i = 0; i < len; i++) {
                        visit(ctx.COMMA(i));
                        isArrayUse = true;
                        if ((i + 1) != len) {
                            isArrayEnd = false;
                        } else if ((i + 1) == len) {
                            isArrayEnd = true;
                        }
                        ArrayUseLayer1 = (i + 1) * arrayItem.Width;
                        ArrayUseLayer2 = (i + 2) * arrayItem.Width;
                        visit(ctx.initVal(i + 1));
                        isArrayUse = false;
                    }
                    isArrayEnd = false;

                }

                 */
            }


        }
        // return super.visitInitVal(ctx);
        return null;
    }

    @Override
    public Void visitFuncDef(CompileParser.FuncDefContext ctx) {
        Result.append("define dso_local ");
        visit(ctx.funcType());
        String FuncReturnType = "";
        // 暂时只考虑main()函数作为主函数入口
        if (ctx.IDENT().toString().equals("main")) {
            // 是否已经声明过同名函数
            if (isMain) {
                System.out.println("Error:您已经定义过同名函数" + ctx.IDENT().toString());
                System.exit(21);
            }
            isMain = true;
            // 函数返回值
            if (ctx.funcType().getText().equals("int")) {
                Return = "i32 0";
                Result.append("i32 @main");
            } else {
                Return = "void";
                Result.append("void @main");
            }
            // Result.append("i32 @main");
            Result.append(ctx.L_PAREN());
            Result.append(ctx.R_PAREN());
            Result.append("{");
            Result.append("\n");
            functionList.judgeParamFunction("main", null);
            functionList.isUseFunction("main");
            // main函数暂时没有参数
            if (ctx.funcFParams() != null) {
                System.out.println("Error:函数参数错误" + ctx.IDENT().toString());
                System.exit(20);
            }
        } else {
            // 新定义函数
            // 新定义函数是否已经定义过了
            if (functionList.isSameFunction(ctx.IDENT().toString())) {
                System.out.println("Error:您已经定义过同名函数" + ctx.IDENT().toString());
                System.exit(21);
            }

            // 函数返回值
            if (ctx.funcType().getText().equals("int")) {
                isFuncNewReturn = true;
                FuncReturnType = "i32";
                Return = "i32 0";
            } else {
                isFuncNewReturn = false;
                FuncReturnType = "void";
                Return = "void";
            }

            // 函数参数
            if (ctx.funcFParams() == null) {
                // 函数没有参数
                paramArrayListNow.clear();
            } else {
                // 函数有参数
                paramArrayListNow.clear();
                visit(ctx.funcFParams());
            }
        }

        if (!ctx.IDENT().toString().equals("main")) {
            // 声明函数
            Result.append(FuncReturnType + " @" + ctx.IDENT().toString() + "(");
            // 函数参数类型
            StringBuffer functionType = new StringBuffer();
            for (int i = 0; i < paramArrayListNow.size(); i++) {
                functionType.append(paramArrayListNow.get(i).Type);
                if (i + 1 != paramArrayListNow.size()) {
                    functionType.append(" ");
                }
            }
            // 声明函数参数
            // 记录函数开始声明参数时寄存器的值
            int StartRegister = this.Register;
            StringBuilder stringBufferParam = new StringBuilder();
            for (int i = 0; i < paramArrayListNow.size(); i++) {
                if (paramArrayListNow.get(i).Type.equals("i32*")) {
                    // 数组类型参数
                    String tempArrayParam = "i32";
//                    if (paramArrayListNow.get(i).ArrayDimension.size() != 1) {
//                        tempArrayParam = "i32";
//                    }
                    for (int i1 = paramArrayListNow.get(i).ArrayDimension.size() - 1; i1 >= 1; i1--) {
                        tempArrayParam = "[" + paramArrayListNow.get(i).ArrayDimension.get(i1) + " x " + tempArrayParam + "]";
                    }
                    stringBufferParam.append(tempArrayParam + "* %x" + this.Register);

                    // 注意需要将参数添加到局部符号表中，并执行alloca与store命令语句

                } else {
                    // 整数类型参数
                    stringBufferParam.append("i32 %x" + this.Register);
                }
                this.Register++;
                if (i + 1 != paramArrayListNow.size()) {
                    stringBufferParam.append(", ");
                }
            }
            Result.append(stringBufferParam + ") {\n");
            if (functionType.length() == 0) {
                // 函数没有参数
                functionType.append("null");
            }

            // alloca命令与store命令
            String ResultString = "";
            for (int i = 0; i < paramArrayListNow.size(); i++) {
                if (paramArrayListNow.get(i).Type.equals("i32*")) {
                    // 数组参数
                    String tempArrayParam = "i32";
//                    if (paramArrayListNow.get(i).ArrayDimension.size() != 1) {
//                        tempArrayParam = "i32";
//                    }
                    for (int i1 = paramArrayListNow.get(i).ArrayDimension.size() - 1; i1 >= 1; i1--) {
                        tempArrayParam = "[" + paramArrayListNow.get(i).ArrayDimension.get(i1) + " x " + tempArrayParam + "]";
                    }
                    // alloca命令
                    ResultString = "%x" + this.Register + " = alloca ";
                    ResultString += tempArrayParam + "*";
                    Result.append("\t" + ResultString + "\n");
                    this.Register++;
                    // store命令
                    ResultString = "store " + tempArrayParam + "* %x" + StartRegister + ", " + tempArrayParam + "* * %x" + (this.Register - 1);
                    Result.append("\t" + ResultString + "\n");
                    StartRegister++;
                    // 将参数添加到局部符号表里
                    ArrayItem arrayItem = new ArrayItem(this.Register - 1, paramArrayListNow.get(i).Name, "paramint", paramArrayListNow.get(i).Num, paramArrayListNow.get(i).ArrayDimension, true, 1);
                    arrayTable.arrayItems.add(arrayItem);
                    Variable variable = new Variable(this.Register - 1, paramArrayListNow.get(i).Name, 0, "paramarray", true, 1);
                    symbolTable.Table.add(variable);
                } else {
                    // 整数参数
                    // alloca命令
                    ResultString = "%x" + this.Register + " = alloca i32";
                    this.Register++;
                    Result.append("\t" + ResultString + "\n");
                    // store命令
                    ResultString = "store i32 %x" + StartRegister + ", i32* %x" + (this.Register - 1);
                    StartRegister++;
                    Result.append("\t" + ResultString + "\n");
                    // 将函数参数添加到局部符号表里
                    Variable variable = new Variable(this.Register - 1, paramArrayListNow.get(i).Name, 0, "paramint", true, 1);
                    symbolTable.Table.add(variable);
                }
            }
            // 将新建函数信息存储在函数数组中
            FunctionParam functionParam = new FunctionParam(paramArrayListNow.size(), String.valueOf(functionType), paramArrayListNow);
            // 将函数声明为已使用函数，因为自定义函数不需要声明
            Function function = new Function(ctx.IDENT().toString(), functionParam, true, FuncReturnType);
            functionList.functionArrayList.add(function);
        }
//        if (ctx.funcFParams() != null) {
//            System.out.println("函数调用参数");
//            visit(ctx.funcFParams());
//        }

        visit(ctx.block());
        if (!isFuncReturnStmt) {
            // 函数没有返回值
            if (ctx.funcType().getText().equals("int")) {
                System.out.println("Error:函数没有返回值");
                System.exit(26);
            } else {
                // 函数没有返回值
                String ResultString = "";
                ResultString = "ret void";
                Result.append("\t" + ResultString + "\n");
            }
        }
        isFuncReturnStmt = false;
        Result.append("}\n\n");
        // return super.visitFuncDef(ctx);
        return null;
    }

    @Override
    public Void visitFuncType(CompileParser.FuncTypeContext ctx) {
        // 暂时不考虑void类型
//        if (ctx.INT_KW() != null) {
//            Result.append("i32 ");
//        } else {
//            System.out.println("入口函数的类型是void");
//            Result.append("void ");
//        }
        // return super.visitFuncType(ctx);
        return null;
    }

    @Override
    public Void visitFuncFParams(CompileParser.FuncFParamsContext ctx) {
        int len = ctx.children.size();
        len = len / 2 + 1;
        for (int i = 0; i < len; i++) {
            visit(ctx.funcFParam(i));
            paramArrayListNow.add(paramNow);
        }
        // return super.visitFuncFParams(ctx);
        return null;
    }

    @Override
    public Void visitFuncFParam(CompileParser.FuncFParamContext ctx) {
        visit(ctx.bType());
        visit(ctx.IDENT());

        if (ctx.L_BRACKT(0) == null) {
            // 函数参数不是数组
            // 注意，int类型变量在符号表中的Type是i32
            paramNow = new Param("i32", ctx.IDENT().toString(), 0, null);
        } else {
            isArrayUse = true;
            // 函数参数是数组
            int len = ctx.children.size() - 4;
            len = len / 3;
            // 数组参数数组
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(0);
            for (int i = 0; i < len; i++) {
                GString = "";
                visit(ctx.exp(i));
                GString = gloableVar.AnalyseString(GString);
                int result = OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost(GString));
                arrayList.add(result);
            }
            len = len + 1;
            paramNow = new Param("i32*", ctx.IDENT().toString(), len, arrayList);
        }
        isArrayUse = false;
        // return super.visitFuncFParam(ctx);
        return null;
    }

    @Override
    public Void visitBlock(CompileParser.BlockContext ctx) {
        // Result.append(ctx.L_BRACE());
        // Result.append("\n");

        // 层数+1
        this.Layer++;
        int len = ctx.blockItem().size();
//        if (len == 1) {
//            // if-else语句没有返回块
//            // while语句没有返回块
//            isIfElseReturn = false;
//            isWhileReturn = false;
//        } else {
//            isIfElseReturn = true;
//            isWhileReturn = true;
//        }
//        if (ctx.blockItem(len - 1).stmt().continueStmt() != null && this.Layer == 1) {
//            // is-else语句无返回语句
//            isIfElseReturn = false;
//        } else {
//            isIfElseReturn = true;
//        }
        boolean testWhile = false;
        for (int i = 0; i < len; i++) {
            if (ctx.blockItem(i).stmt() != null && ctx.blockItem(i).stmt().conditionStmt() != null) {
                // 存在while
                testWhile = true;
            }
        }
        if (testWhile) {
            if (ctx.blockItem(len - 1).stmt().conditionStmt() != null && this.Layer == 1) {
                // if-else语句无返回语句
                isIfElseReturn.push(false);
            } else {
                isIfElseReturn.push(true);
            }
        }
        testWhile = false;
        for (int i = 0; i < len; i++) {
            if (ctx.blockItem(i).stmt() != null && ctx.blockItem(i).stmt().whileStmt() != null) {
                // 存在while
                testWhile = true;
            }
        }
        if (testWhile) {
            if (ctx.blockItem(len - 1).stmt().whileStmt() != null && this.Layer == 1) {
                // while语句无返回语句
                isWhileReturn.push(false);
            } else {
                isWhileReturn.push(true);
            }
        }
        for (int i = 0; i < len; i++) {
            visit(ctx.blockItem(i));
        }
        // 层数-1
        // 注意调用位置
        // 出栈,相关层定义的变量出栈
        // 注意调用位置,不要放在for()循环里面,还没有跳出块就把块内变量删了
        symbolTable.TableDelete(this.Layer);
        this.Layer--;

        // Result.append(ctx.R_BRACE());
        // return super.visitBlock(ctx);
        return null;
    }

    @Override
    public Void visitBlockItem(CompileParser.BlockItemContext ctx) {
        if (ctx.constDecl() != null) {
            visit(ctx.constDecl());
        } else if (ctx.varDecl() != null) {
            visit(ctx.varDecl());
        } else if (ctx.stmt() != null) {
            visit(ctx.stmt());
        }
        // return super.visitBlockItem(ctx);
        return null;
    }

    @Override
    public Void visitStmt(CompileParser.StmtContext ctx) {
        if (ctx.assignStmt() != null) {
            // 赋值语句a = 1
            visit(ctx.assignStmt());
        } else if (ctx.expStmt() != null) {
            // 表达式语句1 + 1
            visit(ctx.expStmt());
        } else if (ctx.block() != null) {
            visit(ctx.block());
        } else if (ctx.conditionStmt() != null) {
            // 条件语句if(a > 1) else
            visit(ctx.conditionStmt());
        } else if (ctx.whileStmt() != null) {
            // 循环语句while(a > 1)
            visit(ctx.whileStmt());
        } else if (ctx.breakStmt() != null) {
            // break语句break
            visit(ctx.breakStmt());
        } else if (ctx.continueStmt() != null) {
            // continue语句continue
            visit(ctx.continueStmt());
        } else if (ctx.returnStmt() != null) {
            // return语句return
            visit(ctx.returnStmt());
        }
        // return super.visitStmt(ctx);
        return null;
    }

    @Override
    public Void visitAssignStmt(CompileParser.AssignStmtContext ctx) {
        // 处理赋值语句节点
        Variable variable = symbolTable.SearchValue(ctx.lVal().children.get(0).toString());
        if (variable.Type.contains("const")) {
            System.out.println("Error:常量值不能更改");
            System.exit(6);
        }
        // 将符号表中对应变量的isValue值改为true，表示已赋值
        variable.isValue = true;
        // 将整体判断是否复制变量isValue，isFuncValue赋值为true，避免之前的语句对结果的影响
        this.isValue = true;
        this.isFuncValue = true;
        int leftJudge, rightJudge;
        int Num;
        String ResultString = "";
        isEQ = true;
        visit(ctx.lVal());
        isEQ = false;
        this.isFuncReturn = true;
        // 一定要提前保存寄存器中的值，因为很可能在exp()表达式中还会重新赋值TempRegister
        // 注意赋值语句位置
        int LValTempRegister;
        LValTempRegister = this.TempRegister;
        leftJudge = this.Register;
        visit(ctx.exp());
        rightJudge = this.Register;
        // 判断赋值变量是否赋值
        if (!this.isValue) {
            System.out.println("Error:您的赋值语句右边调用了没有初始化的变量" + ctx.lVal().children.get(0));
            System.exit(8);
        }
        // System.out.println(">>>????????????????");
        // 判断是否调用了函数返回值
        if (!this.isFuncValue) {
            System.out.println("Error:您的赋值语句右边调用了没有返回值的函数" + ctx.lVal().children.get(0));
            System.exit(9);
        }
        // 还原为true
        this.isValue = true;
        this.isFuncValue = true;
        Num = this.TempNum;
        if (leftJudge == rightJudge) {
            if (symbolTable.isExist(ctx.lVal().IDENT().toString(), 0) || symbolTable.SearchValue(ctx.lVal().IDENT().toString()).Type.contains("array")) {
                // 复制元素不是最初的全局变量元素
                ResultString = "store i32 " + Num + ", i32* %x" + LValTempRegister;
            } else {
                // 重新赋值全局变量
                LValTempRegister = gloableVar.SearchName(ctx.lVal().IDENT().toString()).Register;
                ResultString = "store i32 " + Num + ", i32* @x" + LValTempRegister;
            }
//            // 语句没有调用新寄存器
//            ResultString = "store i32 " + Num + ", i32* %x" + LValTempRegister;
        } else {
            if (symbolTable.isExist(ctx.lVal().IDENT().toString(), 0) || symbolTable.SearchValue(ctx.lVal().IDENT().toString()).Type.contains("array")) {
                // 复制元素不是最初的全局变量元素
                ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + LValTempRegister;
            } else {
                // 重新赋值全局变量
                LValTempRegister = gloableVar.SearchName(ctx.lVal().IDENT().toString()).Register;
                ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* @x" + LValTempRegister;
            }
//            // 语句调用了新寄存器
//            ResultString = "store i32 %x" + (rightJudge - 1) + ", i32* %x" + LValTempRegister;
        }
        Result.append("\t").append(ResultString).append("\n");
        // return super.visitAssignStmt(ctx);
        return null;
    }

    @Override
    public Void visitExpStmt(CompileParser.ExpStmtContext ctx) {
        return super.visitExpStmt(ctx);
    }

    @Override
    public Void visitConditionStmt(CompileParser.ConditionStmtContext ctx) {
        // 考虑吧只有一个数字的情况
        int leftJudge, rightJudge;
        int Num;
        int Label0, Label1, Label2, ret = 0;
        if (ctx.ELSE_KW() != null) {
            Label0 = this.Register - 1;
            Label1 = this.Register;
            Label2 = this.Register + 1;
            ret = this.Register + 2;
            this.Register += 3;
            // and指令遇到false直接跳到Label1语句块
            AndStack.push(Label2);
            // or指令遇到true直接跳到Label1语句块
            OrStack.push(Label1);
        } else {
            Label0 = this.Register - 1;
            Label1 = this.Register;
            Label2 = this.Register + 1;
            // and命令遇到false直接跳到Label语句块
            AndStack.push(Label2);
            // or命令遇到true直接跳到Label1语句块
            OrStack.push(Label1);
            this.Register += 2;
        }
//        if (leftJudge == rightJudge) {
//            // 括号里面可能是一个数字
//            Result.append("\t%x").append(this.Register).append(" = icmp ne i32 ").append(Num).append(", 0").append("\n");
//            this.Register++;
//        } else {
//            Result.append("\t%x").append(this.Register).append(" = icmp ne i32 %x").append(rightJudge - 1).append(", 0\n");
//            this.Register++;
//        }
        visit(ctx.cond());
        // 有else语句
        if (ctx.ELSE_KW() != null) {
            // 实现跳转语句
            // br i1 %7,label %8, label %10
            /*
             * if(label0) {
             *  label1
             * } else {
             *  label2
             * }
             * ret
             */
            String ResultString = "";
            // System.out.println(this.Register);
            ResultString = "br i1 %x" + (this.Register - 1) + ",label %x" + Label1 + ", label %x" + Label2;
            Result.append("\t").append(ResultString).append("\n");
            // Label0块结束

            // Label1块开始
            Result.append("\nx").append(Label1).append(":\n");
            isBreakContinue = false;
            visit(ctx.stmt(0));
            // 每块语句执行完后都跳到Ret返回块
            // bug:label写成了i1
            if (!isBreakContinue) {
                ResultString = "br label %x" + ret;
                Result.append("\t").append(ResultString).append("\n");
            }
            isBreakContinue = false;
            // Label1块结束，跳转到返回块x(Ret)

            // Label2块开始
            Result.append("\nx").append(Label2).append(":\n");
            isBreakContinue = false;
            visit(ctx.stmt(1));
            if (!isBreakContinue) {
                ResultString = "br label %x" + ret;
                Result.append("\t").append(ResultString).append("\n");
            }
            isBreakContinue = false;
            // Label2块结束，跳转到返回块x(Ret)

            // Ret返回块开始
            Result.append("\nx").append(ret).append(":\n");
            // 当返回块没有语句时，输出ret i32 0
            if (isIfElseReturn.size() != 0 && !isIfElseReturn.pop()) {
                ResultString = "ret " + Return;
                Result.append("\t").append(ResultString).append("\n");
            }
            // Ret返回块结束，程序运行结束
        } else if (ctx.ELSE_KW() == null) {
            // 实现跳转语句
            // br i1 %7,label %8, label %10
            /*
             * if(Label0) {
             *   Label1
             * }
             * Label2
             */
            String ResultString = "";
            ResultString = "br i1 %x" + (this.Register - 1) + ",label %x" + Label1 + ", label %x" + Label2;
            Result.append("\t").append(ResultString).append("\n");
            // Label0块结束

            // Labek1块开始
            Result.append("\nx").append(Label1).append(":\n");
            isBreakContinue = false;
            visit(ctx.stmt(0));
            // 每块语句执行完后都跳到Ret返回块
            if (!isBreakContinue) {
                ResultString = "br label %x" + Label2;
                Result.append("\t").append(ResultString).append("\n");
            }
            isBreakContinue = false;
            // Label1块结束，跳转到返回块x(Ret)

            // 返回块Ret开始
            Result.append("\nx").append(Label2).append(":\n");
            // 返回块Ret结束
        }
        // 出栈
        AndStack.pop();
        OrStack.pop();
        // return super.visitConditionStmt(ctx);
        return null;
    }

    @Override
    public Void visitWhileStmt(CompileParser.WhileStmtContext ctx) {
        // 进入while循环前
        // 条件判断块
        WhileJudge.push(this.Register);
        this.Register++;
        // 循环代码块
        WhileResult.push(this.Register);
        this.Register++;
        // 返回代码块
        WhileReturn.push(this.Register);
        this.Register++;

        /*
         * while(WhileJudge) {
         *   WhileResult
         * }
         * WhileReturn
         */
        // and命令遇到false直接跳转到返回代码快
        AndStack.push(WhileReturn.peek());
        // or命令遇到true直接跳转到循环代码块
        OrStack.push(WhileResult.peek());

        // 进入while循环
        // br label %5
        String ResultString = "";
        ResultString = "br label %x" + WhileJudge.peek();
        Result.append("\t").append(ResultString).append("\n");

        // 进入条件判断代码块
        // %8 = icmp slt i32 %6, %7
        // br i1 %8, label %9, label %16
        ResultString = "\nx" + WhileJudge.peek();
        Result.append(ResultString).append(":\n");
        visit(ctx.cond());
        ResultString = "br i1 %x" + (this.Register - 1) + ", label %x" + WhileResult.peek() + ", label %x" + WhileReturn.peek();
        Result.append("\t").append(ResultString).append("\n");

        // 进入循环代码块
        ResultString = "\nx" + WhileResult.pop();
        Result.append(ResultString).append(":\n");
        isBreakContinue = false;
        visit(ctx.stmt());
        // 跳转到条件判断代码块
        if (!isBreakContinue) {
            ResultString = "br label %x" + WhileJudge.pop();
            Result.append("\t").append(ResultString).append("\n");
        }
        isBreakContinue = false;

        // 进入返回代码块
        ResultString = "\nx" + WhileReturn.pop();
        Result.append(ResultString).append(":\n");
        if (isWhileReturn.size() != 0 && !isWhileReturn.pop()) {
            ResultString = "ret " + Return;
            Result.append("\t").append(ResultString).append("\n");
        }
        // return super.visitWhileStmt(ctx);

        // 出栈
        AndStack.pop();
        OrStack.pop();
        return null;
    }

    @Override
    public Void visitBreakStmt(CompileParser.BreakStmtContext ctx) {
        isBreakContinue = true;
        String ResultString = "";
        ResultString = "br label %x" + WhileReturn.peek();
        Result.append("\t").append(ResultString).append("\n");
        // return super.visitBreakStmt(ctx);
        return null;
    }

    @Override
    public Void visitContinueStmt(CompileParser.ContinueStmtContext ctx) {
        isBreakContinue = true;
        String ResultString = "";
        ResultString = "br label %x" + WhileJudge.peek();
        Result.append("\t").append(ResultString).append("\n");
        // return super.visitContinueStmt(ctx);
        return null;
    }

    @Override
    public Void visitReturnStmt(CompileParser.ReturnStmtContext ctx) {
        isFuncReturnStmt = true;
        visit(ctx.RETURN_KW());
        String ResultString = "ret i32 ";
        // 保存进入表达式之前寄存器的值
        Before = Register;
        if (ctx.exp() != null) {
            visit(ctx.exp());
            // 保存进入表达式之后寄存器的值
            After = Register;
            if (Before == After) {
                // 如果两者值相等，则说明函数在执行表达式时没有生成或占用新的寄存器
                ResultString += TempNum;
            } else {
                // 如果两者值不相等。则说明函数在执行表达式的时候使用了新的寄存器，因此返回值应该以寄存器的形式返回
                ResultString += "%x" + (After - 1);
            }
            Result.append("\t").append(ResultString).append("\n");
            this.Register++;
        } else {
            ResultString = "ret void";
            Result.append("\t").append(ResultString).append("\n");
        }
        // 去掉函数返回了空值输出语句
//        else {
//            System.out.println("函数返回了空值");
//        }
        visit(ctx.SEMICOLON());
        // return super.visitReturnStmt(ctx);
        return null;
    }

    @Override
    public Void visitExp(CompileParser.ExpContext ctx) {
        visit(ctx.addExp());
        // return super.visitExp(ctx);
        return null;
    }

    @Override
    public Void visitCond(CompileParser.CondContext ctx) {
        visit(ctx.lOrExp());
        // return super.visitCond(ctx);
        return null;
    }

    @Override
    public Void visitLVal(CompileParser.LValContext ctx) {
        Index++;
        int len = ctx.children.size() - 1;
        len = len / 3;
        // 是否为数组元素
        boolean judge = false;

        // 只有在第一层进入visitLVal()方式时执行函数参数判断
        if (len == 0 && Index == 1) {
            if (arrayTable.SearchArray(ctx.IDENT().toString()) != null) {
                // 数组元素
                judge = true;
                isArrayUse = true;
                param = new Param("i32*", ctx.IDENT().toString(), arrayTable.SearchArray(ctx.IDENT().toString()).Dimension - len, null);
                isArrayAddress = true;
            } else {
                // 整数元素
                param = new Param("i32", ctx.IDENT().toString(), 0, null);
                judge = false;
                isArrayAddress = false;
            }
        } else if (len >= 1 && Index == 1) {
            if (arrayTable.SearchArray(ctx.IDENT().toString()).Dimension == len) {
                // 整数元素
                param = new Param("i32", ctx.IDENT().toString(), 0, null);
                judge = false;
                isArrayAddress = false;
            } else {
                // 数组元素
                isArrayUse = true;
                judge = true;
                param = new Param("i32*", ctx.IDENT().toString(), arrayTable.SearchArray(ctx.IDENT().toString()).Dimension - len, null);
                isArrayAddress = true;
            }
        }
        visit(ctx.IDENT());
        GName = ctx.IDENT().toString();
        if (this.Layer == 0) {
            // 全局变量
            if (gloableVar.SearchName(ctx.IDENT().toString()) != null) {
                if (gloableVar.SearchName(ctx.IDENT().toString()).Type.contains("const")) {
                    GString += gloableVar.SearchName(ctx.IDENT().toString()).Value;
                } else {
                    System.out.println("Error:全局变量定义式中必须使用常量表达式" + ctx.IDENT());
                    System.exit(12);
                }
            } else {
                System.out.println("Error:全局变量的定义不能使用没有赋值的变量" + ctx.IDENT());
                System.exit(10);
            }
        }
        // 查看变量是否存在,只要能找到变量存在就算成功,因此从内向外查找
        if (!symbolTable.isExist(ctx.IDENT().toString())) {
            System.out.println("Error:您调用了还没有定义的变量,无法为变量执行赋值操作" + ctx.IDENT().toString());
            System.exit(4);
        } else {
            // System.out.println(ctx.IDENT().toString() + isConst);
            if (isConst) {
                // 正在使用全局变量初始化，所有值都需要是常量
                Variable variable = symbolTable.SearchValue(ctx.IDENT().toString());
                if (variable == null) {
                    variable = gloableVar.SearchName(ctx.IDENT().toString());
                }
                if (!variable.Type.contains("const")) {
                    System.out.println("Error:您在赋值常量时使用了变量 " + ctx.IDENT().toString());
                    System.exit(23);
                }
            }
            if (this.isArrayParam) {
                int result;
                Variable variable = symbolTable.SearchValue(ctx.IDENT().toString());
                if (variable == null) {
                    variable = gloableVar.SearchName(ctx.IDENT().toString());
                }
                if (variable.isValue) {
                    result = variable.Value;
                    ArrayNumString += result;
                } else {
                    System.out.println("Error:您调用了还没有赋值的变量,无法为变量执行赋值操作" + ctx.IDENT().toString());
                    System.exit(4);
                }
            }
        }
        // 查看变量是否已经赋值,块优先调用离块最近的变量值,采用从外向内查找
        if (!symbolTable.SearchValue(ctx.IDENT().toString()).isValue) {
            this.isValue = false;
        } else {
            // 注意这个并运算
            this.isValue = true && this.isValue;
        }

//        // 查看变量是否为数组类型变量，如果是数组类型变量是否取值
//        if (arrayTable.SearchArray(ctx.IDENT().toString()) != null) {
//            isArrayUseLoad = true;
//            ArrayItem arrayItem = arrayTable.SearchArray(ctx.IDENT().toString());
//            if (ctx.L_BRACKT(0) == null && arrayItem.Dimension - len ==  a) {
//                System.out.println("Error:数组类型变量没有取值，直接将地址作为值" + ctx.IDENT().toString() + " Array");
//                System.exit(17);
//            }
//            // System.out.println(arrayItem.Width);
//            if (arrayItem.Dimension != ctx.L_BRACKT().size() && !isCallee) {
//                System.out.println("Error:数组取值位置与数组维数不同" + ctx.IDENT().toString() + " Array");
//                System.exit(17);
//            }
//            // 指针越界
//            // 数组下标越界是未定义行为，不作为编译错误考察。
//        }
        this.TempRegister = symbolTable.SearchValue(ctx.IDENT().toString()).Register;
        // System.out.println(ctx.IDENT().getText() + " = %x" + TempRegister);

        int leftJudge, rightJudge;
        int Num;
        String ResultString = "";
        int SaveRegister;
        // 告知是否需要load数组元素
        if (len != 0) {
            isArrayUseLoad = true;
            ArrayNameLoad = ctx.IDENT().toString();
        } else {
            isArrayUseLoad = false;
        }
//        if (len == 1) {
//            // 一维数组取值
//            // %10 = getelementptr [2 x i32], [2 x i32]* %7, i32 0, i32 0
//            // %11 = add i32 %9, 0
//            // %12 = getelementptr i32, i32* %10, i32 %11
//            ArrayItem arrayItem = arrayTable.SearchArray(ctx.IDENT().toString());
//            if (gloableVar.SearchName(ArrayNameLoad) != null) {
//                // 全局变量数组
//                if (arrayItem.ArrayRegister == gloableVar.SearchName(ArrayNameLoad).Register) {
//                    // 全局变量数组没有被重新赋值
//                    ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.Width + " x i32], [" + arrayItem.Width + " x i32]* @x" + arrayItem.ArrayRegister + ", i32 0,i32 0";
//                } else {
//                    // 全局变量数组已经被重新赋值
//                    ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.Width + " x i32], [" + arrayItem.Width + " x i32]* %x" + arrayItem.ArrayRegister + ", i32 0,i32 0";
//                }
//            } else {
//                ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.Width + " x i32], [" + arrayItem.Width + " x i32]* %x" + arrayItem.ArrayRegister + ", i32 0,i32 0";
//            }
//            Result.append("\t").append(ResultString).append("\n");
//            SaveRegister = this.Register;
//            this.Register++;
//            visit(ctx.L_BRACKT(0));
//            leftJudge = this.Register;
//            visit(ctx.exp(0));
//            rightJudge = this.Register;
//            Num = TempNum;
//            if (leftJudge == rightJudge) {
//                ResultString = "%x" + this.Register + " = add i32 " + Num + ", 0";
//                Result.append("\t").append(ResultString).append("\n");
//            } else {
//                ResultString = "%x" + this.Register + " = add i32 %x" + (rightJudge - 1) + ", 0";
//                Result.append("\t").append(ResultString).append("\n");
//            }
//            this.Register++;
//            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegister + ", i32 %x" + (this.Register - 1);
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
//            // %13 = load i32, i32* %12
//            TempRegister = this.Register - 1;
//            // 表达式中可能有其他变量将GName修改，重新赋值GName
//            GName = ctx.IDENT().toString();
//
//        } else if (len == 2) {
//            // 二维数组
//            // %7 = getelementptr [2 x [2 x i32]], [2 x [2 x i32]]* %2, i32 0, i32 0
//            // %8 = add i32 0, 0
//            // %9 = mul i32 %8, 2
//            // %10 = getelementptr [2 x i32], [2 x i32]* %7, i32 0, i32 0
//            // %11 = add i32 %9, 0
//            // %12 = getelementptr i32, i32* %10, i32 %11
//            // %13 = load i32, i32* %12
//            int SaveRegister1;
//            visit(ctx.IDENT());
//
//            ArrayItem arrayItem = arrayTable.SearchArray(ctx.IDENT().toString());
//            if (gloableVar.SearchName(ArrayNameLoad) != null) {
//                // 全局变量数组
//                if (gloableVar.SearchName(ArrayNameLoad).Register == arrayItem.ArrayRegister) {
//                    // 全局变量数组没有被重新赋值
//                    ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]], [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]]* @x" + arrayItem.ArrayRegister + ", i32 0, i32 0";
//                } else {
//                    // 全局变量数组已经被重新赋值
//                    ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]], [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]]* %x" + arrayItem.ArrayRegister + ", i32 0, i32 0";
//                }
//            } else {
//                ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]], [" + arrayItem.ArrayLayer + " x [" + arrayItem.Width + " x i32]]* %x" + arrayItem.ArrayRegister + ", i32 0, i32 0";
//            }
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
//            ResultString = "%x" + this.Register + " = getelementptr [" + arrayItem.Width + " x i32], [" + arrayItem.Width + " x i32]* %x" + (this.Register - 1) + ", i32 0, i32 0";
//            Result.append("\t").append(ResultString).append("\n");
//            SaveRegister1 = this.Register;
//            this.Register++;
//
//            visit(ctx.L_BRACKT(0));
//            leftJudge = this.Register;
//            visit(ctx.exp(0));
//            rightJudge = this.Register;
//            Num = TempNum;
//            if (leftJudge == rightJudge) {
//                ResultString = "%x" + this.Register + " = add i32 0, " + Num;
//            } else {
//                ResultString = "%x" + this.Register + " = add i32 0, %x" + (rightJudge - 1);
//            }
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
//            ResultString = "%x" + this.Register + " = mul i32 %x" + (this.Register - 1) + ", " + arrayItem.Width;
//            Result.append("\t").append(ResultString).append("\n");
//            SaveRegister = this.Register;
//            this.Register++;
//            visit(ctx.R_BRACKT(0));
//
//            visit(ctx.L_BRACKT(1));
//            leftJudge = this.Register;
//            visit(ctx.exp(1));
//            rightJudge = this.Register;
//            Num = TempNum;
//            if (leftJudge == rightJudge) {
//                ResultString = "%x" + this.Register + " = add i32 %x" + SaveRegister + ", " + Num;
//            } else {
//                ResultString = "%x" + this.Register + " = add i32 %x" + SaveRegister + ", %x" + (rightJudge - 1);
//            }
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
//            // %12 = getelementptr i32, i32* %10, i32 %11
//            ResultString = "%x" + this.Register + " = getelementptr i32, i32* %x" + SaveRegister1 + ", i32 %x" + (this.Register - 1);
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
//            visit(ctx.R_BRACKT(1));
//            TempRegister = this.Register - 1;
//            // 表达式中可能有其他变量将GName修改，重新赋值GName
//            GName = ctx.IDENT().toString();
//        } else if (len > 2) {
        if (len >= 1 || arrayTable.SearchArray(ctx.IDENT().toString()) != null) {
            // 多维数组取值
            // 注意，不能写为else，因为这样会导致普通变量也会进入这部分函数判断
            /*
             * %x8 = getelementptr [1 x [2 x [3 x i32]]], [1 x [2 x [3 x i32]]]* %x0, i32 0, i32 0, i32 1, i32 2
             * %x9 = load i32, i32* %x8
             */
            visit(ctx.IDENT());
            ArrayName = ctx.IDENT().toString();
            String tempString = "";
            ArrayItem arrayItem = arrayTable.SearchArray(ctx.IDENT().toString());
            if (arrayItem.Dimension - len < 0) {
                System.out.println("Error:数组取值超出数组维数" + ArrayName);
                System.exit(24);
            }
            for (int i = 0; i < len; i++) {
                visit(ctx.L_BRACKT(i));
                leftJudge = this.Register;
                visit(ctx.exp(i));
                rightJudge = this.Register;
                Num = TempNum;
//                if (Num >= arrayTable.SearchArray(ctx.IDENT().toString()).arrayList.get(i)) {
//                    System.out.println("Error:数组取值下标越界 " + ctx.IDENT().toString());
//                    System.exit(24);
//                }
                if (leftJudge == rightJudge) {
                    tempString += ", i32 " + Num;
                } else {
                    tempString += ", i32 %x" + (rightJudge - 1);
                }
                visit(ctx.R_BRACKT(i));
            }
            ResultString = "i32";
            // System.out.println(ctx.IDENT().toString());
            if (!arrayItem.ArrayType.contains("param")) {
                for (int i = arrayItem.arrayList.size() - 1; i >= 0; i--) {
                    ResultString = "[" + arrayItem.arrayList.get(i) + " x " + ResultString + "]";
                }
            } else {
                for (int i = arrayItem.arrayList.size() - 1; i >= 1; i--) {
                    ResultString = "[" + arrayItem.arrayList.get(i) + " x " + ResultString + "]";
                }
            }
            int tempRegister = 0;
            if (arrayItem.ArrayType.contains("param")) {
                // store i32*  %1, i32* * %3
                String tempStore = "%x" + this.Register + " = load " + ResultString + "*, " + ResultString + "* * %x" + arrayItem.ArrayRegister;
                this.Register++;
                Result.append("\t" + tempStore + "\n");
                tempRegister = this.Register - 1;
            }
            // 没有被重新赋值过的全局数组
            if (gloableVar.SearchName(ctx.IDENT().toString()) != null && symbolTable.SearchWithDifferentLayer(ctx.IDENT().toString(), 0) == null) {
                // 全局数组
                // 是全局数组并且数组没有被重新赋值
                // System.out.println(symbolTable.Search(ctx.IDENT().toString(), 0));
                if (symbolTable.SearchWithDifferentLayer(ctx.IDENT().toString(), 0) == null) {
                    ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* @x" + arrayItem.ArrayRegister + ", i32 0" + tempString;
                } else {
                    // 是全局数组但已经被重新赋值
                    ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* %x" + arrayItem.ArrayRegister + ", i32 0" + tempString;
                }
            } else {
                // 局部数组
                if (!arrayItem.ArrayType.contains("param")) {
                    ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* %x" + arrayItem.ArrayRegister + ", i32 0" + tempString;
                } else {
                    ResultString = "%x" + this.Register + " = getelementptr " + ResultString + ", " + ResultString + "* %x" + tempRegister + tempString;
                }
            }
            // 当函数参数是数组地址时，应该再加上一个i32 0
            if (isArrayAddress) {
                ResultString += ", i32 0";
            }
            Result.append("\t" + ResultString + "\n");
            this.Register++;
            TempRegister = this.Register - 1;
            ArrayName = ctx.IDENT().toString();
        }

//        for (int i = 0; i < len; i++) {
//            visit(ctx.L_BRACKT(i));
//            visit(ctx.exp(i));
//            visit(ctx.R_BRACKT(i));
//        }
        // 判断ctx.IDENT().toString()是否属于数组变量
        // param = new Param("intArray",ctx.IDENT().toString(),len + 1);
        // lab3暂时不考虑数组变量，因此，所有的变量都默认为int类型变量
        // return super.visitLVal(ctx);
        return null;
    }

    @Override
    public Void visitPrimaryExp(CompileParser.PrimaryExpContext ctx) {
        if (ctx.children.size() == 3) {
            visit(ctx.L_PAREN());
            if (this.Layer == 0) {
                GString += "(";
            }
            ArrayNumString += "(";
            ArrayNumString1 += "(";
            visit(ctx.exp());
            visit(ctx.R_PAREN());
            if (this.Layer == 0) {
                GString += ")";
            }
            ArrayNumString += ")";
            ArrayNumString1 += ")";
        } else if (ctx.lVal() != null) {
            // 遇到变量名，需要调用load指令
            // %3 = load i32, i32* %1
            GName = "";
            ArrayName = "";
            visit(ctx.lVal());
            String ResultString = "";
            // 这里就不需要提前保存TempRegister大小了，因为直接调用了TempRegister
            // 函数参数中出现数组地址时不需要输出load指令
            if (this.Layer != 0 && !isArrayParam && !isArrayAddress) {
                // 非全局变量层，因为全局变量不需要输出中间执行命令
                // Result.append("aaaaaaaaa\n");
                if (symbolTable.isExist(GName, 0) || arrayTable.SearchArray(ArrayName) != null) {
                    ResultString = "%x" + this.Register + " = load i32, i32* %x" + this.TempRegister;
                } else if (gloableVar.SearchRegister(this.TempRegister)) {
                    // 如果使用到了全局变量，则需要将%x1寄存器替换为@x1
                    ResultString = "%x" + this.Register + " = load i32, i32* @x" + this.TempRegister;
                }
                Result.append("\t").append(ResultString).append("\n");
                this.Register++;
            }
            // ArrayName不需要清空，如果ArrayName清空会导致搜索数组函数找不到数组报错
            // ArrayName = "";
            GName = "";
        } else {
            visit(ctx.number());
        }
        // return super.visitPrimaryExp(ctx);
        return null;
    }

    @Override
    public Void visitNumber(CompileParser.NumberContext ctx) {
        if (ctx.OCTAL_CONST() != null) {
            TempNum = Integer.parseInt(ctx.OCTAL_CONST().getText(), 8);
        } else if (ctx.DECIMAL_CONST() != null) {
            TempNum = Integer.parseInt(ctx.DECIMAL_CONST().getText());
        } else if (ctx.HEXADECIMAL_CONST() != null) {
            TempNum = Integer.parseInt(ctx.HEXADECIMAL_CONST().getText().substring(2), 16);
        }
        if (this.Layer == 0) {
            // 全局变量
            GString += TempNum;
            // System.out.println(TempNum);
        }
        ArrayNumString += TempNum;
        ArrayNumString1 += TempNum;
        if (!isArrayUse) {
            param = new Param("i32", TempNum + "", 0, null);
        }
        // return super.visitNumber(ctx);
        return null;
    }

    @Override
    public Void visitUnaryExp(CompileParser.UnaryExpContext ctx) {
        if (ctx.primaryExp() != null) {
            visit(ctx.primaryExp());
        } else if (ctx.callee() != null) {
            // 调用函数
            visit(ctx.callee());
        } else {
            int leftJudge, rightJudge;
            int Num;
            String Symbol, ResultString = "";
            visit(ctx.unaryOp());
            // ctx.getText()方法：获得终结符字符串的值
            // System.out.println("@" + ctx.unaryOp().getText());
            if (ctx.unaryOp().getText().equals("+")) {
                Symbol = "add i32 0";
            } else if (ctx.unaryOp().getText().equals("-")) {
                Symbol = "sub i32 0";
            } else {
                Symbol = "icmp eq i32 0";
            }

            if (this.Layer == 0) {
                if (ctx.unaryOp().getText().equals("+")) {
                    this.GString += "+";
                } else if (ctx.unaryOp().getText().equals("-")) {
                    this.GString += "-";
                } else {
                    System.out.println("Error:全局变量目前不支持i1格式变量" + ctx.unaryOp().getText());
                    System.exit(11);
                }
            }

            if (ctx.unaryOp().getText().equals("+")) {
                ArrayNumString += "+";
                ArrayNumString1 += "+";
            } else if (ctx.unaryOp().getText().equals("-")) {
                ArrayNumString += "-";
                ArrayNumString1 += "-";
            }
            // 去掉一个判断条件，数组定义不考虑i1格式变量
//            else {
//                System.out.println("Error:数组定义目前不支持i1格式变量" + ctx.unaryOp().getText());
//                System.exit(11);
//            }

            leftJudge = this.Register;
            visit(ctx.unaryExp());
            rightJudge = this.Register;
            Num = this.TempNum;
            if (this.Layer != 0 && !isArrayParam) {
                if (leftJudge == rightJudge) {
                    ResultString = "%x" + this.Register + " = " + Symbol + ", " + Num + "\n";
                } else {
                    // 注意：rightJudge中存储的寄存器值是+1后的寄存器值，使用时需要将rightJudge - 2
                    ResultString = "%x" + this.Register + " = " + Symbol + ", %x" + (rightJudge - 1) + "\n";
                }
                Result.append("\t").append(ResultString);
                this.Register++;

                if (ctx.unaryOp().getText().equals("!")) {
                    // %3 = icmp eq i32 %2, 0
                    // %4 = zext i1 %3 to i32
                    // LLVM IR执行icmp指令后，寄存器中存储的结果数据类型为i1，我们需要将其转化为i32类型，使用LLVM IR的zext命令
                    // %4 = zext i1 %3 to i32
                    Result.append("\t%x").append(this.Register).append(" = zext i1 %x").append(this.Register - 1).append(" to i32\n");
                    // 注意，下面这行语句this.Register++;必须写在if()条件内，否则会引起-号调用寄存器序号错误
                    this.Register++;
                }
            }

        }
        // return super.visitUnaryExp(ctx);
        return null;
    }

    @Override
    public Void visitCallee(CompileParser.CalleeContext ctx) {
        isCallee = true;
        ParamIndex++;
        // System.out.println(ctx.IDENT().toString());
        // 参数输出，由于存在无参数调用函数，所以参数输出字符串需要在函数前面push入栈
        String funcParam = new String();
        CalleeFuncParam.push(funcParam);

        if (ctx.funcRParams() != null) {
            // 有参数调用的函数
            String FuncName = ctx.IDENT().toString();
            Function function = functionList.returnFunction(FuncName);
            // int n = function()
            if (function == null) {
                System.out.println("Error:您调用了没有定义的函数 " + ctx.IDENT().toString());
                System.exit(25);
            }
            if (function.ReturnType.contains("void")) {
                this.isFuncValue = false;
            } else {
                this.isFuncValue = this.isFuncValue && true;
            }
            // System.out.println("+++++++++++++++++" + function.ReturnType + " " + this.isFuncValue);
            int leftJudge, rightJudge;
            int Num;
            String ResultString = "";
            leftJudge = this.Register;

            // 参数检验
            if (ParamIndex >= paramArrayList.size()) {
                ArrayList<Param> arrayList = new ArrayList<>();
                paramArrayList.add(arrayList);
            }
            paramArrayList.get(ParamIndex).clear();


            visit(ctx.funcRParams());

            rightJudge = this.Register;
            Num = this.TempNum;
            // 所有函数的调用信息全部保存在数组paramArrayList中
            if (!functionList.judgeParamFunction(ctx.IDENT().toString(), paramArrayList.get(ParamIndex))) {
                System.out.println("Error:您的函数调用参数不合法" + ctx.IDENT().toString() + " Index = " + ParamIndex);
                System.exit(9);
            }
            // 清空函数参数数组
            paramArrayList.get(ParamIndex).clear();
            if (functionList.isUseFunction(ctx.IDENT().toString())) {

            } else {
                // 函数还没有声明，需要声明函数
                // declare i32 @getint()
                // 现在没有考虑参数是数组类型的函数
                StringBuilder tempParam = new StringBuilder();
                for (int i = 0; i < function.Param.Num; i++) {
                    tempParam.append(function.Param.ParamType.split(" ")[i]);
                    if (i + 1 != function.Param.Num) {
                        tempParam.append(", ");
                    }
                }
                ResultString = "declare " + function.ReturnType + " @" + function.FuntionName + "(" + String.valueOf(tempParam) + ")\n";
                // 在输出结果最前面添加函数声明语句
                Result = new StringBuffer(ResultString + Result.toString());
                // 将函数状态修改为已声明
                functionList.changeisUseFunction(FuncName);
                // 注意将ResultString字符串设置为""，否则会影响下面的输出语句
                ResultString = "";
            }
            if (!function.ReturnType.equals("void")) {
                ResultString = "%x" + this.Register + " = ";
                this.Register++;
            }
            this.isFuncReturn = false;
            // call void @putint(i32 %4)
            // 没有考虑参数是数组的情况
//            if (leftJudge == rightJudge) {
//                ResultString += "call " + function.ReturnType + " @" + function.FuntionName + "(" + function.Param.ParamType + " " + Num + ")\n";
//            } else {
//                // 注意，执行过函数参数节点后，寄存器的最新值可能已经改变，需要使用this.Register - 1的值作为新的寄存器的值
//                ResultString += "call " + function.ReturnType + " @" + function.FuntionName + "(" + function.Param.ParamType + " %x" + (this.Register - 1) + ")\n";
//            }
            // 注意，这里CalleeFuncParam调用peek方法
            ResultString += "call " + function.ReturnType + " @" + function.FuntionName + "(" + CalleeFuncParam.peek() + ")\n";
            paramString = new StringBuilder();
            Result.append("\t").append(ResultString);
        } else {
            // 没有参数调用的函数
            String FuncName = ctx.IDENT().toString();
            // System.out.println(FuncName);
            Function function = functionList.returnFunction(FuncName);
            if (function.ReturnType.contains("void")) {
                this.isFuncValue = false;
            } else {
                this.isFuncValue = this.isFuncValue && true;
            }
            if (functionList.judgeParamFunction(FuncName, null)) {
                // 函数声明正确
                // 检查函数是否已经声明过了
                if (functionList.isUseFunction(FuncName)) {
                    // 函数已经声明过了，不需要再次声明
                } else {
                    // 函数还没有声明，需要声明函数
                    // declare i32 @getint()
                    String ResultString = "declare " + function.ReturnType + " @" + function.FuntionName + "()\n";
                    // 在输出结果最前面添加函数声明语句
                    Result = new StringBuffer(ResultString + Result.toString());
                    // 将函数状态修改为已声明
                    functionList.changeisUseFunction(FuncName);
                }
            } else {
                // 函数声明错误
                System.out.println("Error:您声明的函数有错误" + FuncName + "()");
                System.exit(7);
            }
            String ResultString = "";
            // System.out.println("+++++++++" + function.ReturnType + this.isFuncReturn);
            if (!function.ReturnType.equals("void")) {
                ResultString = "%x" + this.Register + " = ";
                this.Register++;
            }
            this.isFuncReturn = false;
            // call i32 @getch()
            ResultString += "call " + function.ReturnType + " @" + function.FuntionName + "()\n";
            Result.append("\t").append(ResultString);
        }
        // return super.visitCallee(ctx);
        isCallee = false;
        param = new Param(functionList.returnFunction(ctx.IDENT().toString()).ReturnType, ctx.IDENT().toString(), 0, null);
        ParamIndex--;
        CalleeFuncParam.pop();
        return null;
    }

    @Override
    public Void visitUnaryOp(CompileParser.UnaryOpContext ctx) {
        return super.visitUnaryOp(ctx);
    }

    @Override
    public Void visitFuncRParams(CompileParser.FuncRParamsContext ctx) {
        int len = ctx.children.size() - 1;
        len = len / 2;
        // FuncParam是调用函数参数部分，pop方法要在for循环之前执行
        String FuncParam = CalleeFuncParam.pop();
        for (int i = 0; i <= len; i++) {
            param = null;
            // 进入visitLVal()方法次数重置为0
            Index = 0;
            isArrayAddress = false;
            int leftJudge, rightJudge;
            int Num;
            leftJudge = this.Register;
            visit(ctx.param(i));
            rightJudge = this.Register;
            Num = TempNum;
            paramArrayList.get(ParamIndex).add(param);
            isArrayAddress = false;
            if (leftJudge == rightJudge) {
                // 寄存器的值没有发生改变，说明函数参数一定是整数
                paramString.append("i32 " + Num);
                FuncParam += "i32 " + Num;
            } else {
                // 寄存器的值发生了改变，需要根据函数参数类型判断是整数还是地址
                // System.out.println(len);
                if (param.Type.equals("i32")) {
                    // 函数参数类型是整数
                    paramString.append("i32 %x" + (rightJudge - 1));
                    FuncParam += "i32 %x" + (rightJudge - 1);
                } else {
                    // 函数参数类型是数组地址
                    ArrayItem arrayItem = arrayTable.SearchArray(param.Name);
                    String tempParam = "i32";
                    for (int i1 = arrayItem.Dimension - 1; i1 > arrayItem.Dimension - param.Num; i1--) {
                        tempParam = "[" + arrayItem.arrayList.get(i1) + " x " + tempParam + "]";
                    }
                    if (param.Num == 1) {
                        tempParam = "i32";
                    }
                    paramString.append(tempParam + "* %x" + (rightJudge - 1));
                    FuncParam += tempParam + "* %x" + (rightJudge - 1);
                }
            }
            if (i + 1 <= len) {
                paramString.append(", ");
                FuncParam += ", ";
            }
            CalleeFuncParam.push(FuncParam);
        }
        // return super.visitFuncRParams(ctx);
        return null;
    }

    @Override
    public Void visitParam(CompileParser.ParamContext ctx) {
        if (ctx.exp() != null) {
            isArrayUse = false;
            visit(ctx.exp());
        } else {
            visit(ctx.STRING());
            // param = new Param("String", ctx.STRING().toString(), -1);
        }
        // return super.visitParam(ctx);
        return null;
    }

    @Override
    public Void visitMulExp(CompileParser.MulExpContext ctx) {
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String Symbol;
        leftJudge = this.Register;
        visit(ctx.unaryExp(0));
        middleJudge = this.Register;
        Num1 = this.TempNum;
        int len = ctx.children.size() - 1;
        len = len / 2;
        for (int i = 0; i < len; i++) {
            visit(ctx.mulOp(i));
//            if (this.Layer == 0) {
//                GString += ctx.mulOp(i).getText();
//            }
            visit(ctx.unaryExp(i + 1));
            rightJudge = this.Register;
            Num2 = this.TempNum;
            String ResultString = "";
            if (ctx.mulOp(i).getText().equals("*")) {
                Symbol = "mul i32";
            } else if (ctx.mulOp(i).getText().equals("/")) {
                Symbol = "sdiv i32";
            } else {
                Symbol = "srem i32";
            }
            if (this.Layer != 0 && !isArrayParam) {
                if (leftJudge == middleJudge && middleJudge == rightJudge) {
                    // 寄存器的值没有改变，说明表达式中是两个数字
                    ResultString = "%x" + this.Register + " = " + Symbol + " " + Num1 + ", " + Num2 + "\n";
                } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
                    // 进入第二个表达式后寄存器的值发生了改变，说明第二个表达式中使用了寄存器，注意，寄存器的值是judge - 1，因为每次调用新的寄存器后寄存器的值Register都会加一
                    ResultString = "%x" + this.Register + " = " + Symbol + " " + Num1 + ", %x" + (rightJudge - 1) + "\n";
                } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
                    // 进入第一个表达式后寄存器的值发生了改变，但是进入第二个表达式后寄存器的值没有发生改变，说明第一个表达式中调用了寄存器，而第二个表达式中没有调用寄存器
                    ResultString = "%x" + this.Register + " = " + Symbol + " %x" + (middleJudge - 1) + ", " + Num2 + "\n";
                } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
                    // 两个表达式进入前后寄存器的值都不想等，说明两个表达式中都调用了寄存器
                    ResultString = "%x" + this.Register + " = " + Symbol + " %x" + (middleJudge - 1) + ", %x" + (rightJudge - 1) + "\n";
                }
                Result.append("\t").append(ResultString);
                // 不要忘记本次表达式调用了新的寄存器，寄存器的值应该+1
                this.Register++;
                // System.out.println("Mul");
                middleJudge = this.Register;
                Num1 = this.TempNum;
            }
        }
        // return super.visitMulExp(ctx);
        return null;
    }

    @Override
    public Void visitMulOp(CompileParser.MulOpContext ctx) {
        if (this.Layer == 0) {
            GString += ctx.getText();
        }
        ArrayNumString += ctx.getText();
        ArrayNumString1 += ctx.getText();
        // return super.visitMulOp(ctx);
        return null;
    }

    @Override
    public Void visitAddExp(CompileParser.AddExpContext ctx) {
        // return super.visitAddExp(ctx);
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String Symbol;
        leftJudge = this.Register;
        visit(ctx.mulExp(0));
        middleJudge = this.Register;
        Num1 = this.TempNum;
        int len = ctx.children.size() - 1;
        len = len / 2;
        for (int i = 0; i < len; i++) {
            visit(ctx.addOp(i));
//            if (this.Layer == 0) {
//                GString += ctx.addOp(i).getText();
//            }
            visit(ctx.mulExp(i + 1));
            rightJudge = this.Register;
            Num2 = this.TempNum;
            String ResultString = "";
            if (ctx.addOp(i).getText().equals("+")) {
                Symbol = "add i32";
            } else {
                Symbol = "sub i32";
            }
            if (this.Layer != 0 && !isArrayParam) {
                // 没有在进行数组参数运算，可以输出中间过程语句
                if (leftJudge == middleJudge && middleJudge == rightJudge) {
                    // 寄存器的值没有改变，说明表达式中是两个数字
                    ResultString = "%x" + this.Register + " = " + Symbol + " " + Num1 + ", " + Num2 + "\n";
                } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
                    // 进入第二个表达式后寄存器的值发生了改变，说明第二个表达式中使用了寄存器，注意，寄存器的值是judge - 1，因为每次调用新的寄存器后寄存器的值Register都会加一
                    ResultString = "%x" + this.Register + " = " + Symbol + " " + Num1 + ", %x" + (rightJudge - 1) + "\n";
                } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
                    // 进入第一个表达式后寄存器的值发生了改变，但是进入第二个表达式后寄存器的值没有发生改变，说明第一个表达式中调用了寄存器，而第二个表达式中没有调用寄存器
                    ResultString = "%x" + this.Register + " = " + Symbol + " %x" + (middleJudge - 1) + ", " + Num2 + "\n";
                } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
                    // 两个表达式进入前后寄存器的值都不想等，说明两个表达式中都调用了寄存器
                    ResultString = "%x" + this.Register + " = " + Symbol + " %x" + (middleJudge - 1) + ", %x" + (rightJudge - 1) + "\n";
                }
                Result.append("\t").append(ResultString);
                // 不要忘记本次表达式调用了新的寄存器，寄存器的值应该+1
                this.Register++;
                // System.out.println("Add");
                // 一定要注意这个易错点，需要更新middleJudge和NUM1的值
                middleJudge = this.Register;
                Num1 = this.TempNum;
            }
        }
        return null;
    }

    @Override
    public Void visitAddOp(CompileParser.AddOpContext ctx) {
        // return super.visitAddOp(ctx);
        if (this.Layer == 0) {
            // 全局变量
            GString += ctx.getText();
        }
        ArrayNumString += ctx.getText();
        return null;
    }

    @Override
    public Void visitRelExp(CompileParser.RelExpContext ctx) {
        // <
        // >
        // <=
        // >=
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String ResultString = "";
        leftJudge = this.Register;
        visit(ctx.addExp(0));
        middleJudge = this.Register;
        Num1 = this.TempNum;
        int len = ctx.children.size() - 1;
        len = len / 2;
        String middleString = "";
        for (int i = 0; i < len; i++) {
            if (this.Layer == 0) {
                System.out.println("Error:全局变量不支持i1类型变量");
                System.exit(12);
            }
            if (this.isArrayParam) {
                System.out.println("Error:数组不支持i1类型变量");
                System.exit(15);
            }
            visit(ctx.relOp(i));
            visit(ctx.addExp(i + 1));
            rightJudge = this.Register;
            Num2 = this.TempNum;
            if (ctx.relOp(i).getText().equals("<")) {
                middleString = " = icmp slt i32 ";
            } else if (ctx.relOp(i).getText().equals(">")) {
                middleString = " = icmp sgt i32 ";
            } else if (ctx.relOp(i).getText().equals("<=")) {
                middleString = " = icmp sle i32 ";
            } else if (ctx.relOp(i).getText().equals(">=")) {
                middleString = " = icmp sge i32 ";
            }
            // %x1 = and %x2,%x3;
            if (leftJudge == middleJudge && middleJudge == rightJudge) {
                // int int
                ResultString = "%x" + this.Register + middleString + Num1 + ", " + Num2;
            } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
                // int %x1
                ResultString = "%x" + this.Register + middleString + Num1 + ", %x" + (rightJudge - 1);
            } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
                // %x1 int
                ResultString = "%x" + this.Register + middleString + "%x" + (middleJudge - 1) + ", " + Num2;
            } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
                // %x1 %x1
                ResultString = "%x" + this.Register + middleString + "%x" + (middleJudge - 1) + ", %x" + (rightJudge - 1);
            }
            Result.append("\t").append(ResultString).append("\n");
            this.Register++;
            // 注意，这里表达式得出的结果存储在%x1中，类型是i1，布尔类型，为了后续在非简化版本的&&和||语句中使用，我们需要将其转化为i32类型
            // 当然，也可以不转化，直接使用i1类型变量，但是后面代码中有关&&和||语句的代码需要将表达式的值改为i1类型
            // zext指令的使用方法是<result> = zext <ty> <value> to <ty2>, 下面是一个简单的例子
            // %x1 = zext i1 %x to i32
            // 上一条语句运算出的i1类型的值存储在寄存器%x(this.Register - 1)中
            /*
            ResultString = "%x" + this.Register + " = zext i1 %x" + (this.Register - 1) + " to i32";
            Result.append("\t").append(ResultString).append("\n");
            this.Register++;
             */
            // 不要忘记更新middleJudge和Num1中的值
            middleJudge = this.Register;
            Num1 = this.TempNum;
        }
        // return super.visitRelExp(ctx);
        return null;
    }

    @Override
    public Void visitRelOp(CompileParser.RelOpContext ctx) {
        SingleJudge = true;
        // return super.visitRelOp(ctx);
        return null;
    }

    @Override
    public Void visitEqExp(CompileParser.EqExpContext ctx) {
        // ==
        // !=
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String ResultString = "";
        leftJudge = this.Register;
        visit(ctx.relExp(0));
        middleJudge = this.Register;
        Num1 = this.TempNum;
        int len = ctx.children.size() - 1;
        len = len / 2;
        String middleString = "";
        for (int i = 0; i < len; i++) {
            if (this.Layer == 0) {
                System.out.println("Error:全局变量不支持i1类型变量");
                System.exit(12);
            }
            if (this.isArrayParam) {
                System.out.println("Error:数组不支持i1类型变量");
                System.exit(15);
            }
            visit(ctx.eqOp(i));
            visit(ctx.relExp(i + 1));
            rightJudge = this.Register;
            Num2 = this.TempNum;
            if (ctx.eqOp(i).getText().equals("==")) {
                middleString = " = icmp eq i32 ";
            } else if (ctx.eqOp(i).getText().equals("!=")) {
                middleString = " = icmp ne i32 ";
            }
            // %x1 = and %x2,%x3;
            if (leftJudge == middleJudge && middleJudge == rightJudge) {
                // int int
                ResultString = "%x" + this.Register + middleString + Num1 + ", " + Num2;
            } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
                // int %x1
                ResultString = "%x" + this.Register + middleString + Num1 + ", %x" + (rightJudge - 1);
            } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
                // %x1 int
                ResultString = "%x" + this.Register + middleString + "%x" + (middleJudge - 1) + ", " + Num2;
            } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
                // %x1 %x1
                ResultString = "%x" + this.Register + middleString + "%x" + (middleJudge - 1) + ", %x" + (rightJudge - 1);
            }
            Result.append("\t").append(ResultString).append("\n");
            this.Register++;
            // 注意，这里表达式得出的结果存储在%x1中，类型是i1，布尔类型，为了后续在非简化版本的&&和||语句中使用，我们需要将其转化为i32类型
            // 当然，也可以不转化，直接使用i1类型变量，但是后面代码中有关&&和||语句的代码需要将表达式的值改为i1类型
            // zext指令的使用方法是<result> = zext <ty> <value> to <ty2>, 下面是一个简单的例子
            // %x1 = zext i1 %x to i32
            // 上一条语句运算出的i1类型的值存储在寄存器%x(this.Register - 1)中
            /*ResultString = "%x" + this.Register + " = zext i1 %x" + (this.Register - 1) + " to i32";
            Result.append("\t").append(ResultString).append("\n");
            this.Register++;
             */
            // 不要忘记更新middleJudge和Num1中的值
            middleJudge = this.Register;
            Num1 = this.TempNum;
        }
        // return super.visitEqExp(ctx);
        return null;
    }

    @Override
    public Void visitEqOp(CompileParser.EqOpContext ctx) {
        SingleJudge = true;
        // return super.visitEqOp(ctx);
        return null;
    }

    @Override
    public Void visitLAndExp(CompileParser.LAndExpContext ctx) {
        // &&
        // and和or是按位与/或指令 <result> = and/or <ty> <op1>, <op2>，将被用来实现较复杂条件语句的运算。
        // %x1 = and i32 %x2,%x3;

        // 短路求值
        // and遇到false命令直接跳到结尾
        if (this.Layer == 0) {
            System.out.println("Error:全局变量不支持i1类型变量");
            System.exit(12);
        }
        if (this.isArrayParam) {
            System.out.println("Error:数组不支持i1类型变量");
            System.exit(15);
        }
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String ResultString = "";
        leftJudge = this.Register;
        SingleJudge = false;

        visit(ctx.eqExp(0));

        middleJudge = this.Register;
        Num1 = this.TempNum;
        if (!this.SingleJudge) {
            // 当判断条件没有使用比较符号时，需要将结果i32类型强制转化为i1类型
            // %11 = icmp ne i32 %10, 0
            if (leftJudge == middleJudge) {
                // i32后面忘记加空格
                Result.append("\t%x").append(this.Register).append(" = icmp ne i32 ").append(Num1).append(", 0\n");
            } else {
                Result.append("\t%x").append(this.Register).append(" = icmp ne i32 %x").append(middleJudge - 1).append(", 0\n");
            }
            this.Register++;
            this.SingleJudge = true;
        }
        int len = ctx.children.size() - 1;
        len = len / 2;
        if (len >= 1) {
            this.Register++;
            // and遇到false跳转到返回代码快
            ResultString = "br i1 %x" + (this.Register - 2) + ", label %x" + (this.Register - 1) + ", label %x" + AndStack.peek();
            Result.append("\t" + ResultString + "\n\n");
            ResultString = "x" + (this.Register - 1) + ":";
            Result.append(ResultString + "\n");
        }
        middleJudge = this.Register;
        for (int i = 0; i < len; i++) {
            SingleJudge = false;

            visit(ctx.eqExp(i + 1));

            // System.out.println(this.Register);
            rightJudge = this.Register;
            Num2 = this.TempNum;
            if (!this.SingleJudge) {
                // 当判断条件没有使用比较符号时，需要将结果i32类型强制转化为i1类型
                // %11 = icmp ne i32 %10, 0
                if (middleJudge == rightJudge) {
                    // i32后面忘记加空格
                    Result.append("\t%x").append(this.Register).append(" = icmp ne i32 ").append(Num1).append(", 0\n");
                } else {
                    Result.append("\t%x").append(this.Register).append(" = icmp ne i32 %x").append(rightJudge - 1).append(", 0\n");
                }
                this.Register++;
                this.SingleJudge = true;
            }
            if (i + 1 != len) {
                this.Register++;
                // and遇到false跳转到返回代码快
                ResultString = "br i1 %x" + (this.Register - 2) + ", label %x" + (this.Register - 1) + ", label %x" + AndStack.peek();
                Result.append("\t" + ResultString + "\n\n");
                ResultString = "x" + (this.Register - 1) + ":";
                Result.append(ResultString + "\n");
            }
            rightJudge = this.Register;
//            // %x1 = and %x2,%x3;
//            if (leftJudge == middleJudge && middleJudge == rightJudge) {
//                // int int
//                ResultString = "%x" + this.Register + " = and i1 " + Num1 + ", " + Num2;
//            } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
//                // int %x1
//                ResultString = "%x" + this.Register + " = and i1 " + Num1 + ", %x" + (rightJudge - 1);
//            } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
//                // %x1 int
//                ResultString = "%x" + this.Register + " = and i1 %x" + (middleJudge - 1) + ", " + Num2;
//            } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
//                // %x1 %x1
//                ResultString = "%x" + this.Register + " = and i1 %x" + (middleJudge - 1) + ", %x" + (rightJudge - 1);
//            }
//            Result.append("\t").append(ResultString).append("\n");
//            this.Register++;
            // 不要忘记更新middleJudge和Num1中的值
            middleJudge = this.Register;
            Num1 = this.TempNum;
        }
        // return super.visitLAndExp(ctx);
        return null;
    }

    @Override
    public Void visitLOrExp(CompileParser.LOrExpContext ctx) {
        // ||
        // and和or是按位与/或指令 <result> = and/or <ty> <op1>, <op2>，将被用来实现较复杂条件语句的运算。
        /*
         * %res_xy = icmp eq i32 %x,%y
         * %res_mn = icmp eq i32 %m,%n
         * %cond = and i1 %res_xy,%res_mn; 你可以把 and 改成 or 看有什么变化
         */
        if (this.Layer == 0) {
            System.out.println("Error:全局变量不支持i1类型变量");
            System.exit(12);
        }
        if (this.isArrayParam) {
            System.out.println("Error:数组不支持i1类型变量");
            System.exit(15);
        }
        int leftJudge, middleJudge, rightJudge;
        int Num1, Num2;
        String ResultString = "";
        leftJudge = this.Register;
        int len = ctx.children.size() - 1;
        len = len / 2;
        int nextRegister = 0;
        // && || &&优先级问题
        if (len >= 1) {
            nextRegister = this.Register;
            this.Register++;
            AndStack.push(nextRegister);
        }
        // false表示没有使用判断符号
        this.SingleJudge = false;
        visit(ctx.lAndExp(0));
        if (len >= 1) {
            AndStack.pop();
        }
        middleJudge = this.Register;
        Num1 = this.TempNum;
        if (!this.SingleJudge) {
            // 当判断条件没有使用比较符号时，需要将结果i32类型强制转化为i1类型
            // %11 = icmp ne i32 %10, 0
            if (leftJudge == middleJudge) {
                Result.append("\t%x").append(this.Register).append(" = icmp ne i32").append(Num1).append(", 0\n");
            } else if (leftJudge != middleJudge) {
                Result.append("\t%x").append(this.Register).append(" = icmp ne i32 %x").append(middleJudge - 1).append(", 0\n");
            }
            this.Register++;
            middleJudge = this.Register;
            this.SingleJudge = true;
        }
        if (len >= 1) {
            ResultString = "br i1 %x"+ (this.Register - 1) + ", label %x" + OrStack.peek() + ", label %x" + nextRegister;
            Result.append("\t" + ResultString + "\n\n");
            ResultString = "x" + nextRegister + ":";
            Result.append(ResultString + "\n");
            this.Register++;
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 != len) {
                nextRegister = this.Register;
                this.Register++;
                AndStack.push(nextRegister);
            }
            visit(ctx.lAndExp(i + 1));
            if (i + 1 != len) {
                AndStack.pop();
            } else {
                nextRegister = this.Register;
            }
            rightJudge = this.Register;
            Num2 = this.TempNum;
            // %x1 = or =%x2,%x3;
//            if (leftJudge == middleJudge && middleJudge == rightJudge) {
//                // int int
//                ResultString = "%x" + this.Register + " = or i1 " + Num1 + ", " + Num2;
//            } else if (leftJudge == middleJudge && middleJudge != rightJudge) {
//                // int %x1
//                ResultString = "%x" + this.Register + " = or i1 " + Num1 + ", %x" + (rightJudge - 1);
//            } else if (leftJudge != middleJudge && middleJudge == rightJudge) {
//                // %x1 int
//                ResultString = "%x" + this.Register + " = or i1 %x" + (middleJudge - 1) + ", " + Num2;
//            } else if (leftJudge != middleJudge && middleJudge != rightJudge) {
//                // %x1 %x1
//                ResultString = "%x" + this.Register + " = or i1 %x" + (middleJudge - 1) + ", %x" + (rightJudge - 1);
//            }
//            Result.append("\t").append(ResultString).append("\n");
            if (i + 1 != len) {
                // System.out.println(this.Register);
                ResultString = "br i1 %x" + (this.Register - 1) + ", label %x" + OrStack.peek() + ", label %x" + nextRegister;
                Result.append("\t" + ResultString + "\n\n");
                ResultString = "x" + nextRegister + ":";
                Result.append(ResultString + "\n");
                this.Register++;
            }
            // 不要忘记更新middleJudge和Num1中的值
            middleJudge = this.Register;
            Num1 = this.TempNum;
        }
        // return super.visitLOrExp(ctx);
        return null;
    }

    @Override
    public Void visitConstExp(CompileParser.ConstExpContext ctx) {
        return super.visitConstExp(ctx);
    }

    public void GlobalArrayInit(ArrayList<Integer> arrayList, int startPositon, String ArrayName) {
        int len = arrayList.size();
        ArrayItem arrayItem = arrayTable.SearchArray(ArrayName);
        // 当没有遍历到数字层时，晚上前面的字符串
        if (startPositon < len - 1) {
            for (int i = startPositon; i < len; i++) {
                ArrayString += "[" + arrayItem.arrayList.get(i) + " x ";
            }
            ArrayString += "i32";
            for (int i = startPositon; i < len; i++) {
                ArrayString += "]";
            }

            ArrayString += " [";

            for (int i = 0; i < arrayItem.arrayList.get(startPositon); i++) {
                if (i != 0) {
                    ArrayString += ", ";
                }
                ArrayInit.add(i);
                // 递归
                GlobalArrayInit(arrayList, startPositon + 1, ArrayName);
                ArrayInit.remove(ArrayInit.size() - 1);
            }

            ArrayString += "]";
        } else {
            ArrayString += "[" + arrayItem.arrayList.get(len - 1) + " x i32] [";
            for (int i = 0; i < arrayItem.arrayList.get(startPositon); i++) {
                if (i != 0) {
                    ArrayString += ", ";
                }
                ArrayInit.add(i);
                // System.out.println(ArrayInit);
                ArrayItemInit arrayItemInit = arrayItemInitList.FindItem(ArrayName, ArrayInit);
                if (arrayItemInit != null) {
                    // 赋值
                    ArrayString += "i32 " + arrayItemInit.value;
                } else {
                    ArrayString += "i32 0";
                }
                ArrayInit.remove(ArrayInit.size() - 1);
            }
            ArrayString += "]";
        }
    }
}
