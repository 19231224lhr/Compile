import java.util.ArrayList;

public class lab3Vistor extends lab3BaseVisitor<Void> {
    // 程序通用寄存器计数值
    // 由于%x0需要分配给函数使用，所以通用寄存器的值从%x1开始
    /*
     * 每出现一个int类型的赋值语句，就需要调用alloc LLVM IR代码为其分配一个寄存器
     * 分配完后，寄存器计数值++
     * 同时，要记录下来存储的变量的名字，与其对应的寄存器的值，方便其他语句调用该变量时的搜索
     * 注意：const int这种常量类型不用分配存储空间，我们只需要将其存入数组中即可，也不需要生成alloc语句，出现此变量时直接转换成其常量值即可
     * 注意：const int类型的值不允许在赋值的时候使用变量，但可以使用常量，同样的const int类型的值也不允许再次被赋值
     * 注意：寄存器的值前面一定要加上一个字母，比如说字母'x'来表示成字符串寄存器，因为数字寄存器LLVM IR强制要求出现的顺序是递增的，这可能会出现许多意想不到的错误
     */
    int RegisterNum = 1;
    // 存储变量名字，类型与寄存器的动态数组
    ArrayList<Variable> VariableArray = new ArrayList<>();
    // 存储每一次exp中的表达式，数组注意做完一次运算后应该清空
    ArrayList<Exp1> arrayList = new ArrayList();

    // 存储load运算的寄存器或变量值
    String savetemp;

    // 数组中的元素的数据结构
    class Variable {
        // String类型的变量名
        String name;
        // String类型的变量类型
        // lab3中应该只会出现int和const int类型变量
        String type;
        // int类型的寄存器值
        int RegisterNumber;
        // int类型变量存储的值，现在设计给存储const int类型的数据
        int value;
    }

    String name;
    int value;

    // 存储最后输出结果的数组
    public static ArrayList<String> Result = new ArrayList<>();

    // 单独存储所有常量的数组
    ArrayList<Variable> ConstArray = new ArrayList<>();

    // 单独存储所有变量的数组
    ArrayList<String> NotConstArray = new ArrayList<>();

    // 返回最后的结果数组
    public ArrayList<String> getResult() {
        return Result;
    }

    @Override
    public Void visitCompunit(lab3Parser.CompunitContext ctx) {
        visit(ctx.funcdef());
        return null;
        // return super.visitCompunit(ctx);
    }

    @Override
    public Void visitFuncdef(lab3Parser.FuncdefContext ctx) {
        if (ctx.FUNCTYPE().toString().equals("int")) {
            Result.add("define dso_local i32 ");
        }
        if (ctx.IDENTs().toString().equals("main")) {
            Result.add("@main");
        }
        Result.add(ctx.LPar().toString());
        Result.add(ctx.RPar().toString());
        visit(ctx.block());
        return null;
    }

    @Override
    public Void visitBlock(lab3Parser.BlockContext ctx) {
        // System.out.println(ctx.LBrace());
        Result.add(ctx.LBrace().toString());
        Result.add("\n");
        int num = ctx.children.size() - 2;
        for (int i = 0; i < num; i++) {
            visit(ctx.blockitem(i));
        }
        // System.out.println("\n" + ctx.RBrace());
        Result.add("\n");
        Result.add(ctx.RBrace().toString());
        return null;
        // return super.visitBlock(ctx);
    }

    public String analyseString(String string) {
        int length = string.length();
        StringBuilder result = new StringBuilder();
        int add_num = 0, sub_num = 0;
        for (int i = 0; i < length; ) {
            // 判断开头
            if (i == 0 && (string.charAt(0) == '-' || string.charAt(0) == '+')) {
                int j = 0;
                while (j < length) {
                    if (string.charAt(j) == '+') {
                        add_num++;
                    } else if (string.charAt(j) == '-') {
                        sub_num++;
                    } else {
                        if (sub_num % 2 == 0) {
                            result = new StringBuilder();
                        } else {
                            result.append("-");
                        }
                        i = i + add_num + sub_num;
                        add_num = sub_num = 0;
                        break;
                    }
                    j++;
                }
            } else {
                if (string.charAt(i) == '(' || string.charAt(i) == '*' || string.charAt(i) == '/' || string.charAt(i) == '%') {
                    result.append(string.charAt(i));
                    int j = i + 1;
                    while (j < length) {
                        if (string.charAt(j) == '+') {
                            add_num++;
                        } else if (string.charAt(j) == '-') {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                // 加号去掉
                            } else {
                                result.append("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }
                        j++;
                    }
                } else if (string.charAt(i) == ')') {
                    result.append(string.charAt(i));
                    int j = i + 1;
                    while (j < length) {
                        if (string.charAt(j) == '*' || string.charAt(j) == '/' || string.charAt(j) == '%') {
                            i++;
                            break;
                        }
                        if (string.charAt(j) == '+') {
                            add_num++;
                        } else if (string.charAt(j) == '-') {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                result.append("+");
                            } else {
                                result.append("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }
                        j++;
                    }
                    if (j == length) {
                        i++;
                    }
                } else {
                    // result.append(string.charAt(i));
                    //i++;
                    result.append(string.charAt(i));
                    int j = i + 1;
                    while (j < length) {
                        if (string.charAt(j) == '+') {
                            add_num++;
                        } else if (string.charAt(j) == '-') {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                // 加号去掉
                                result.append("+");
                            } else {
                                result.append("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }

                        j++;
                    }
                    if (j == length) {
                        i++;
                    }
                }
            }

        }
        return result.toString();
    }

    public ArrayList<String> analyseString(ArrayList<String> string) {
        int length = string.size();
        ArrayList<String> result = new ArrayList<>();
        int add_num = 0, sub_num = 0;
        for (int i = 0; i < length; ) {
            // 判断开头
            if (i == 0 && (string.get(i).equals("-") || string.get(i).equals("+"))) {
                int j = 0;
                while (j < length) {
                    if (string.get(j).equals("+")) {
                        add_num++;
                    } else if (string.get(j).equals("-")) {
                        sub_num++;
                    } else {
                        if (sub_num % 2 == 0) {
                        } else {
                            result.add("-");
                        }
                        i = i + add_num + sub_num;
                        add_num = sub_num = 0;
                        break;
                    }
                    j++;
                }
            } else {
                if (string.get(i).equals("(") || string.get(i).equals("*") || string.get(i).equals("/") || string.get(i).equals("%")) {
                    result.add(string.get(i));
                    int j = i + 1;
                    while (j < length) {
                        if (string.get(j).equals("+")) {
                            add_num++;
                        } else if (string.get(j).equals("-")) {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                // 加号去掉
                            } else {
                                result.add("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }
                        j++;
                    }
                } else if (string.get(i).equals(")")) {
                    result.add(")");
                    int j = i + 1;
                    while (j < length) {
                        if (string.get(j).equals("*") || string.get(j).equals("/") || string.get(j).equals("%")) {
                            i++;
                            break;
                        }
                        if (string.get(j).equals("+")) {
                            add_num++;
                        } else if (string.get(j).equals("-")) {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                result.add("+");
                            } else {
                                result.add("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }
                        j++;
                    }
                    if (j == length) {
                        i++;
                    }
                } else {
                    // result.append(string.charAt(i));
                    //i++;
                    result.add(string.get(i));
                    int j = i + 1;
                    while (j < length) {
                        if (string.get(j).equals("+")) {
                            add_num++;
                        } else if (string.get(j).equals("-")) {
                            sub_num++;
                        } else {
                            if (sub_num + add_num == 0) {
                                i++;
                                break;
                            }
                            if (sub_num % 2 == 0) {
                                // 加号去掉
                                result.add("+");
                            } else {
                                result.add("-");
                            }
                            i = i + add_num + sub_num + 1;
                            add_num = sub_num = 0;
                            break;
                        }

                        j++;
                    }
                    if (j == length) {
                        i++;
                    }
                }
            }

        }
        return result;
    }

    @Override
    public Void visitBlockitem(lab3Parser.BlockitemContext ctx) {
        if (ctx.decl() != null) {
            visit(ctx.decl());
        } else {
            visit(ctx.stmt());
        }
        return null;
        // return super.visitBlockitem(ctx);
    }

    public ArrayList<String> ArrayToRegister(ArrayList arrayList) {
        boolean isNum;
        for (int i = 0; i < arrayList.size(); i++) {
            isNum = arrayList.get(i).toString().matches("[0-9]+");
            // 判断是不是变量
            if (arrayList.get(i) != "+" && arrayList.get(i) != "-" && arrayList.get(i) != "*" && arrayList.get(i) != "/" && arrayList.get(i) != "%" && !isNum) {
                for (int j = 0; j < VariableArray.size(); j++) {
                    if (arrayList.get(i).equals(VariableArray.get(j).name)) {
                        // 注意，const常量直接转换为数字的值即可(字符类型)，不需要转换成寄存器的值
                        if (VariableArray.get(j).type.contains("const")) {
                            arrayList.set(i, VariableArray.get(j).value + "");
                            break;
                        }
                        arrayList.set(i, "%x" + RegisterNum);
                        // System.out.println("%" + RegisterNum + " = load i32, i32* %" + VariableArray.get(j).RegisterNumber);
                        Result.add("%x" + RegisterNum + " = load i32, i32* %x" + VariableArray.get(j).RegisterNumber);
                        Result.add("\n");
                        RegisterNum++;
                        break;
                    }
                }

            }
        }
        return arrayList;
    }

    // 判断是不是常量方法
    public int judgeConst(String string) {
        for (int i = 0; i < ConstArray.size(); i++) {
            if (ConstArray.get(i).name.equals(string)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Void visitStmt(lab3Parser.StmtContext ctx) {
        switch (ctx.children.size()) {
            case 4: {
                // LVal '=' Exp ';'
                visit(ctx.lval());
                for (int i = 0; i < VariableArray.size(); i++) {
                    if (VariableArray.get(i).name.equals(name) && VariableArray.get(i).type.contains("const")) {
                        // System.out.println("Error : Lval is not a val!");
                        Result.add("Error : Lval is not a val!");
                        Result.add("\n");
                        System.exit(2);
                    }
                }
                // System.out.println("需要赋值的变量名为：" + name);
                String varRegister = "";
                // 找出该变量所存储的寄存器编号
                for (int i = 0; i < VariableArray.size(); i++) {
                    if (VariableArray.get(i).name.equals(name)) {
                        varRegister = "%x" + VariableArray.get(i).RegisterNumber;
                        break;
                    }
                }
                // System.out.println("=");
                visit(ctx.exp());
                String string = "";
                int judgenum = 0;
                ArrayList<String> array = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    judgenum = judgeConst(arrayList.get(i).value);
                    if (judgenum != -1) {
                        // 将常量替换为常量值
                        array.add(ConstArray.get(judgenum).value + "");
                        string += ConstArray.get(judgenum).value;
                    } else {
                        array.add(arrayList.get(i).value);
                        string += arrayList.get(i).value;
                    }
                }
                // test是简化后的字符串
                String test = analyseString(string);
                String true_result = "";
                OperatorPrecedenceParse o = new OperatorPrecedenceParse();
                array = analyseString(array);
                // 将array数组中的变量名全部替换为寄存器格式，因为传给OPP类的数组需要输出寄存器格式
                array = ArrayToRegister(array);
                // System.out.println(array.toString());
                if (array.size() == 1) {
                    // System.out.println("store i32 " + array.get(0) + ", i32* " + varRegister);
                    Result.add("store i32 " + array.get(0) + ", i32* " + varRegister);
                    Result.add("\n");
                } else {
                    true_result = o.calculator(array, RegisterNum);
                    RegisterNum = Integer.parseInt(true_result.substring(1));
                    savetemp = "%x" + RegisterNum;
                    RegisterNum++;
                    // System.out.println("store i32 " + savetemp + ", i32* " + varRegister);
                    Result.add("store i32 " + savetemp + ", i32* " + varRegister);
                    Result.add("\n");

                }
                arrayList.clear();
                visit(ctx.Semicolon());
                break;
            }
            case 2: {
                visit(ctx.exp());
                visit(ctx.Semicolon());
                break;
            }
            case 3: {
                visit(ctx.exp());
                String string = "";
                ArrayList<String> array = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    array.add(arrayList.get(i).value);
                    string += arrayList.get(i).value;
                }
                String test = analyseString(string);
                // System.out.println(test);
                String true_result = "";
                OperatorPrecedenceParse o = new OperatorPrecedenceParse();
                array = analyseString(array);
                // 将array数组中的变量名全部替换为寄存器格式，因为传给OPP类的数组需要输出寄存器格式
                array = ArrayToRegister(array);
                if (array.size() == 1) {
                    if (array.get(0).matches("[0-9]+")) {
                        Result.add("ret i32 " + array.get(0));
                    } else {
                        // System.out.println("%" + RegisterNum + " = load i32, i32* " + array.get(0));
                        // System.out.print("ret i32 %" + --RegisterNum);
                        Result.add("ret i32 %x" + --RegisterNum);
                    }
                    break;
                } else {
                    true_result = o.calculator(array, RegisterNum);
                    // System.out.print("ret i32 " + true_result);
                    Result.add("ret i32 " + true_result);
                    break;
                }
            }
            default: {
                // System.out.println("Don't match switch.2");
                Result.add("Don't match switch.2");
                Result.add("\n");
            }
        }
        return null;
        // return super.visitStmt(ctx);
    }

    @Override
    public Void visitLval(lab3Parser.LvalContext ctx) {
        visit(ctx.ident());
        return null;
        // return super.visitLval(ctx);
    }

    @Override
    public Void visitIdent(lab3Parser.IdentContext ctx) {
        if (ctx.nondigit() != null) {
            visit(ctx.nondigit());
        } else if (ctx.nondigit_1() != null) {
            visit(ctx.nondigit_1());
        } else {
            visit(ctx.nondigitDigit());
        }
        return null;
        // return super.visitIdent(ctx);
    }

    @Override
    public Void visitNondigit(lab3Parser.NondigitContext ctx) {

        visit(ctx.Nondigit());
        name = ctx.Nondigit().toString();
        return null;
        // return super.visitNondigit(ctx);
    }

    @Override
    public Void visitNondigit_1(lab3Parser.Nondigit_1Context ctx) {
        visit(ctx.Nondigit_1());
        name = ctx.Nondigit_1().toString();
        return null;
        // return super.visitNondigit_1(ctx);
    }

    @Override
    public Void visitNondigitDigit(lab3Parser.NondigitDigitContext ctx) {
        visit(ctx.NondigitDigit());
        name = ctx.NondigitDigit().toString();
        return null;
        // return super.visitNondigitDigit(ctx);
    }

    @Override
    public Void visitBType(lab3Parser.BTypeContext ctx) {
        visit(ctx.FUNCTYPE());
        return null;
        // return super.visitBType(ctx);
    }

    @Override
    public Void visitExp(lab3Parser.ExpContext ctx) {
        visit(ctx.addexp());
        return null;
        // return super.visitExp(ctx);
    }

    @Override
    public Void visitAddexp(lab3Parser.AddexpContext ctx) {
        int num = ctx.children.size();
        num = (num - 1) / 2;
        visit(ctx.mulexp(0));
        for (int i = 0; i < num; i++) {
            Exp1 exp = new Exp1();
            exp.judge = "symbol";
            exp.value = ctx.UnaryOp(i).toString();
            arrayList.add(exp);
            visit(ctx.mulexp(i + 1));
        }
        return null;
        // return super.visitAddexp(ctx);
    }

    @Override
    public Void visitMulexp(lab3Parser.MulexpContext ctx) {
        int num = ctx.children.size();
        num = (num - 1) / 2;
        visit(ctx.unaryexp(0));
        for (int i = 0; i < num; i++) {
            Exp1 exp = new Exp1();

            exp.judge = "symbol";
            exp.value = ctx.UnaryOp_1(i).toString();
            arrayList.add(exp);
            visit(ctx.unaryexp(i + 1));
        }
        return null;
        // return super.visitMulexp(ctx);
    }

    FunctionCheck functionCheck = new FunctionCheck();
    // 存储函数参数的动态数组
    ArrayList<Variable> ParamsArray = new ArrayList<>();
    // 存储已经声明过的函数字符串
    String FuncName = "";

    @Override
    public Void visitUnaryexp(lab3Parser.UnaryexpContext ctx) {
        //System.out.println(ctx.children);
        if (ctx.UnaryOp() != null) {
            Exp1 exp = new Exp1();

            exp.judge = "symbol";
            exp.value = ctx.UnaryOp().toString();
            arrayList.add(exp);
            visit(ctx.unaryexp());
        } else {
            if (ctx.ident() == null) {
                visit(ctx.primaryexp());
            } else {
                // 遍历调用库函数名
                visit(ctx.ident());

                visit(ctx.LPar());
                int num = ctx.children.size() - 3;
                String temp_name = name;
                if (num == 0) {
                    // 无参数库函数调用
                    ArrayList<Variable> array = new ArrayList<>();
                    array.clear();
                    String judge = functionCheck.reback(temp_name);
                    if (functionCheck.judge(name, array)) {
                        if (!FuncName.contains(temp_name)) {
                            Result.add(0, "declare " + judge.split("\\|")[0] + " @" + name + "(" + judge.split("\\|")[1] + "\n");
                            FuncName += temp_name;
                        }
                        if (judge.split("\\|")[0].equals("i32")) {
                            Result.add("%x" + RegisterNum + " = call i32 @" + name + "(" + functionCheck.reback(temp_name).split("\\|")[1]);
                        } else {
                            Result.add("call i32 @" + name + "(" + functionCheck.reback(temp_name).split("\\|")[1]);
                        }
                        Result.add("\n");
                        savetemp = "%x" + RegisterNum;
                        RegisterNum++;
                    }
                } else {
                    for (int i = 0; i < num; i++) {
                        visit(ctx.funcRParams(i));
                    }
                    String judge = functionCheck.reback(temp_name);
                    if (functionCheck.judge(temp_name, ParamsArray)) {
                        if (!FuncName.contains(temp_name)) {
                            Result.add(0, "declare " + judge.split("\\|")[0] + " @" + temp_name + "(" + judge.split("\\|")[1] + "\n");
                            FuncName += temp_name;
                        }
                        // Result.add("%" + RegisterNum + " = call i32 @" + temp_name + "(i32 " + ParamsArray.get(0).name + ")");
                        if (judge.split("\\|")[0].equals("i32")) {
                            Result.add("%x" + RegisterNum + " = call " + judge.split("\\|")[0] + " @" + temp_name + "(i32 " + ParamsArray.get(0).name + ")");
                        } else {
                            Result.add("call " + judge.split("\\|")[0] + " @" + temp_name + "(i32 " + ParamsArray.get(0).name + ")");
                        }
                        Result.add("\n");
                        savetemp = "%x" + RegisterNum;
                        // RegisterNum++;
                    }

                }
                ParamsArray.clear();
                visit(ctx.RPar());
            }
        }
        return null;
        // return super.visitUnaryexp(ctx);
    }

    @Override
    public Void visitFuncRParams(lab3Parser.FuncRParamsContext ctx) {
        int num = ctx.children.size() - 1;
        num = num / 2 + 1;
        for (int j = 0; j < num; j++) {
            visit(ctx.exp(j));
            String string = "";
            ArrayList<String> array = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                array.add(arrayList.get(i).value);
                string += arrayList.get(i).value;
            }
            // test是简化后的字符串
            String test = analyseString(string);
            String true_result = "";
            OperatorPrecedenceParse o = new OperatorPrecedenceParse();
            array = analyseString(array);
            array = ArrayToRegister(array);
            Variable variable = new Variable();
            if (array.size() == 1) {
                savetemp = array.get(0);
                variable.name = array.get(0);
                variable.type = "int";
                ParamsArray.add(variable);
            } else {
                true_result = o.calculator(array, RegisterNum);
                RegisterNum = Integer.parseInt(true_result.substring(1));
                savetemp = "%x" + RegisterNum;
                RegisterNum++;
                variable.type = "int";
                variable.name = savetemp;
                ParamsArray.add(variable);
            }
            arrayList.clear();
        }
        return null;
        // return super.visitFuncRParams(ctx);
    }

    @Override
    public Void visitPrimaryexp(lab3Parser.PrimaryexpContext ctx) {
        if (ctx.children.size() == 3) {
            // System.out.print(ctx.LPar());
            // System.out.print(x++);
            Exp1 exp = new Exp1();

            exp.judge = "left";
            exp.value = "(";
            arrayList.add(exp);
            visit(ctx.exp());
            Exp1 exp1 = new Exp1();

            exp1.judge = "right";
            exp1.value = ")";
            arrayList.add(exp1);
        } else {
            if (ctx.lval() != null) {
                visit(ctx.lval());
                // 一定要注意加的位置
                Exp1 exp1 = new Exp1();
                exp1.judge = "var";
                exp1.value = name;
                arrayList.add(exp1);
            } else {
                visit(ctx.number());
            }
        }


        return null;
        // return super.visitPrimaryexp(ctx);
    }

    @Override
    public Void visitNumber(lab3Parser.NumberContext ctx) {
        if (ctx.decimalconst() != null) {
            visit(ctx.decimalconst());
        } else if (ctx.octalconst() != null) {
            visit(ctx.octalconst());
        } else if (ctx.hexadecimalconst() != null) {
            visit(ctx.hexadecimalconst());
        }
        return null;
        // return super.visitNumber(ctx);
    }

    @Override
    public Void visitDecimalconst(lab3Parser.DecimalconstContext ctx) {
        Exp1 exp = new Exp1();

        exp.judge = "num";
        exp.value = ctx.Nonzerodigit().toString();
        arrayList.add(exp);
        return null;
        // return super.visitDecimalconst(ctx);
    }

    @Override
    public Void visitOctalconst(lab3Parser.OctalconstContext ctx) {
        Exp1 exp = new Exp1();

        exp.judge = "num";
        exp.value = Integer.parseInt(ctx.Octaldigit().toString(), 8) + "";
        arrayList.add(exp);
        return null;
        // return super.visitOctalconst(ctx);
    }


    @Override
    public Void visitHexadecimalconst(lab3Parser.HexadecimalconstContext ctx) {
        Exp1 exp = new Exp1();

        exp.judge = "num";
        exp.value = Integer.parseInt(ctx.Hexadecimalprefix().toString().substring(2), 16) + "";
        arrayList.add(exp);
        return null;
        // return super.visitHexadecimalconst(ctx);
    }

    @Override
    public Void visitDecl(lab3Parser.DeclContext ctx) {
        if (ctx.constDecl() != null) {
            visit(ctx.constDecl());
        } else {
            visit(ctx.varDecl());
        }
        return null;
        // return super.visitDecl(ctx);
    }

    @Override
    public Void visitConstDecl(lab3Parser.ConstDeclContext ctx) {
        visit(ctx.constDef(0));
        int num = ctx.children.size() - 4;
        num = num / 2;
        for (int i = 0; i < num; i++) {
            visit(ctx.constDef(i + 1));
        }
        return null;
        // return super.visitConstDecl(ctx);
    }

    @Override
    public Void visitConstDef(lab3Parser.ConstDefContext ctx) {
        Variable variable = new Variable();
        visit(ctx.ident());
        String temp = name;
        if (judgeConst(temp) != -1) {
            System.out.println("Error : Const int can't be named again!");
            System.exit(2);
        }
        visit(ctx.constInitVal());

        variable.name = temp;
        variable.type = "const int";
        // -1代表是const int类型的常量，不需要分配寄存器
        variable.RegisterNumber = -1;
        variable.value = value;
        VariableArray.add(variable);
        ConstArray.add(variable);
        name = null;
        value = 0;
        // 注意清空数组，可以再额外建一个新数组
        arrayList.clear();

        return null;
        // return super.visitConstDef(ctx);
    }

    @Override
    public Void visitConstInitVal(lab3Parser.ConstInitValContext ctx) {
        visit(ctx.constExp());
        // const int只需要取得结果就行，不需要计算中间的LLVM IR表达式
        String string = "";
        int judgenum = 0;
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (NotConstArray.contains(arrayList.get(i).value)) {
                System.out.println("Error : Const int can't be declared by variable!");
                System.exit(2);
            }
            judgenum = judgeConst(arrayList.get(i).value);
            if (judgenum != -1) {
                // 将常量替换为常量值
                array.add(ConstArray.get(judgenum).value + "");
                string += ConstArray.get(judgenum).value;
            } else {
                array.add(arrayList.get(i).value);
                string += arrayList.get(i).value;
            }
        }
        String test = analyseString(string);
        int result = (int) Calculator.conversion(test);
        value = result;
        return null;
        // return super.visitConstInitVal(ctx);
    }

    @Override
    public Void visitConstExp(lab3Parser.ConstExpContext ctx) {
        visit(ctx.addexp());
        return null;
        // return super.visitConstExp(ctx);
    }

    @Override
    public Void visitVarDecl(lab3Parser.VarDeclContext ctx) {
        visit(ctx.FUNCTYPE());
        visit(ctx.varDef(0));
        int num = ctx.children.size() - 3;
        num = num / 2;
        for (int i = 0; i < num; i++) {
            visit(ctx.varDef(i + 1));
        }
        visit(ctx.Semicolon());
        return null;
        // return super.visitVarDecl(ctx);
    }

    @Override
    public Void visitVarDef(lab3Parser.VarDefContext ctx) {
        switch (ctx.children.size()) {
            case 1: {
                visit(ctx.ident());
                if (NotConstArray.contains(name) || judgeConst(name) != -1) {
                    System.out.println("Error : Variable can't be named again!");
                    System.exit(2);
                }
                NotConstArray.add(name);
                // int a;
                Variable variable = new Variable();
                variable.name = name;
                // 没有赋值的变量值统一取为0
                variable.value = 0;
                variable.RegisterNumber = RegisterNum;
                variable.type = "int";
                RegisterNum++;
                VariableArray.add(variable);
                // System.out.println("增添一个" + variable.type + "类型的变量，寄存器的值为：" + variable.RegisterNumber + "，变量名为：" + variable.name);
                arrayList.clear();

                // System.out.println("%" + variable.RegisterNumber + " = alloca i32");
                Result.add("%x" + variable.RegisterNumber + " = alloca i32");
                Result.add("\n");
                break;
            }
            case 3: {
                visit(ctx.ident());
                // int a = 1;
                if (NotConstArray.contains(name) || judgeConst(name) != -1) {
                    System.out.println("Error : Variable can't be named again!");
                    System.exit(2);
                }
                NotConstArray.add(name);
                Variable variable = new Variable();
                variable.name = name;
                // 变量值统一取为0
                variable.value = 0;
                variable.RegisterNumber = RegisterNum;
                variable.type = "int";
                RegisterNum++;
                VariableArray.add(variable);
                Result.add("%x" + variable.RegisterNumber + " = alloca i32");
                Result.add("\n");

                visit(ctx.initVal());
                arrayList.clear();
                // System.out.println("store i32 " + savetemp + ", i32* %" + variable.RegisterNumber);
                Result.add("store i32 " + savetemp + ", i32* %x" + variable.RegisterNumber);
                Result.add("\n");

                break;
            }
            default: {
                Result.add("Switch don't match.3");
                Result.add("\n");
                break;
            }
        }
        return null;
        // return super.visitVarDef(ctx);
    }

    @Override
    public Void visitInitVal(lab3Parser.InitValContext ctx) {
        visit(ctx.exp());
        String string = "";
        int judgenum = 0;
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            judgenum = judgeConst(arrayList.get(i).value);
            if (judgenum != -1) {
                // 将常量替换为常量值
                array.add(ConstArray.get(judgenum).value + "");
                string += ConstArray.get(judgenum).value;
            } else {
                array.add(arrayList.get(i).value);
                string += arrayList.get(i).value;
            }
        }
        // test是简化后的字符串
        String test = analyseString(string);
        String true_result = "";
        OperatorPrecedenceParse o = new OperatorPrecedenceParse();
        array = analyseString(array);
        array = ArrayToRegister(array);
        if (array.size() == 1) {
            savetemp = array.get(0);
        } else {
            true_result = o.calculator(array, RegisterNum);
            RegisterNum = Integer.parseInt(true_result.substring(1));
            savetemp = "%x" + RegisterNum;
            RegisterNum++;
        }

        return null;
        // return super.visitInitVal(ctx);
    }
}

class Exp1 {
    String judge;
    // number is num
    // +-*/% is symbol
    // ( is left
    // ) is right
    // variable is var
    String value;
    // num is num
    // +-*/% is +-*/%
    // ( is (
    // ) is )
    // var is var
}
