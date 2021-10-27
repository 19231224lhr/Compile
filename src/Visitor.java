import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class Visitor extends testBaseVisitor<Void> {
    @Override
    public Void visitCompunit(testParser.CompunitContext ctx) {
        // return super.visitCompunit(ctx);
        visit(ctx.funcdef());
//        System.out.println("数组的结果是：");
//        for (int i = 0;i < arrayList.size();i++) {
//            System.out.println("第" + i + "项:" + "类型是 " + arrayList.get(i).judge + ",值是 " + arrayList.get(i).value);
//        }
        return null;
    }

    @Override
    public Void visitFuncdef(testParser.FuncdefContext ctx) {
        if (ctx.FUNCTYPE().toString().equals("int")) {
            System.out.print("define dso_local i32 ");
        }
        if (ctx.IDENT().toString().equals("main")) {
            System.out.print("@main");
        }
        // System.out.print(ctx.IDENT());
        System.out.print(ctx.LPar());
        System.out.print(ctx.RPar());
        return super.visitFuncdef(ctx);
    }

    @Override
    public Void visitBlock(testParser.BlockContext ctx) {
        System.out.println(ctx.LBrace());
        visit(ctx.stmt());
        System.out.println("\n" + ctx.RBrace());
        // return super.visitBlock(ctx);
        return null;
    }

    ArrayList<String> retnum = new ArrayList<>();

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
//        for (int i = 0; i < result.length(); i++) {
//            if (result.charAt(i) == '(') {
//                // 如果出现了(-(这种情况，需要将其替换为(0-(，因为现在设计的运算方法会将-也是别为一个单独的数字
//                if (i + 2 < length) {
//                    if (result.charAt(i + 1) == '-' && result.charAt(i + 2) == '(') {
//                        result.insert(i + 1, 0);
//
//                    }
//                }
//            }
//        }
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
//        for (int i = 0; i < result.length(); i++) {
//            if (result.charAt(i) == '(') {
//                // 如果出现了(-(这种情况，需要将其替换为(0-(，因为现在设计的运算方法会将-也是别为一个单独的数字
//                if (i + 2 < length) {
//                    if (result.charAt(i + 1) == '-' && result.charAt(i + 2) == '(') {
//                        result.insert(i + 1, 0);
//
//                    }
//                }
//            }
//        }
        return result;
    }

    @Override
    public Void visitStmt(testParser.StmtContext ctx) {
        visit(ctx.exp());
        // System.out.println("数组的结果是：");
        String string = "";
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            // System.out.println("第" + i + "项:" + "类型是 " + arrayList.get(i).judge + ",值是 " + arrayList.get(i).value);
            array.add(arrayList.get(i).value);
            string += arrayList.get(i).value;
        }
        // System.out.println(string);
        // test是简化后的字符串
        String test = analyseString(string);
        String true_result = "";
        // System.out.println("简化后的计算表达式为 = " + test);
        OperatorPrecedenceParse o = new OperatorPrecedenceParse();
        // true_result是通过寄存器计算出来的寄存器表达式，是LLVM IR指令中的寄存器的表达式
        // 如果只有一个数字，直接返回即可
        array = analyseString(array);
        if (array.size() == 1) {
            System.out.print("ret i32 " + array.get(0));
            return null;
        } else {
            true_result = o.calculator(array);
            // result是通过计算算出来的表达式的计算值，不是LLVM IR指令
            // int result = (int) Calculator.conversion(test);
            // System.out.print(result);
            System.out.print("ret i32 " + true_result);
            return null;
        }
    }

    @Override
    public Void visitExp(testParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    ArrayList<Exp> arrayList = new ArrayList();
    Exp exp = new Exp();

    @Override
    public Void visitAddexp(testParser.AddexpContext ctx) {
        int num = ctx.children.size();
        num = (num - 1) / 2;
        visit(ctx.mulexp(0));
        for (int i = 0; i < num; i++) {
            Exp exp = new Exp();
            exp.judge = "symbol";
            exp.value = ctx.UnaryOp(i).toString();
            arrayList.add(exp);
            visit(ctx.mulexp(i + 1));
        }
        return null;
    }

    @Override
    public Void visitMulexp(testParser.MulexpContext ctx) {
        int num = ctx.children.size();
        num = (num - 1) / 2;
        visit(ctx.unaryexp(0));
        for (int i = 0; i < num; i++) {
            Exp exp = new Exp();

            exp.judge = "symbol";
            exp.value = ctx.UnaryOp_1(i).toString();
            arrayList.add(exp);
            visit(ctx.unaryexp(i + 1));
        }
        return null;
    }

    int x = 0;

    @Override
    public Void visitUnaryexp(testParser.UnaryexpContext ctx) {

        if (ctx.UnaryOp() != null) {
            Exp exp = new Exp();

            exp.judge = "symbol";
            exp.value = ctx.UnaryOp().toString();
            arrayList.add(exp);
            visit(ctx.unaryexp());
        } else {
            visit(ctx.primaryexp());
        }

        // return super.visitUnaryexp(ctx);
        return null;
    }

    @Override
    public Void visitPrimaryexp(testParser.PrimaryexpContext ctx) {
        if (ctx.children.size() == 3) {
            // System.out.print(ctx.LPar());
            // System.out.print(x++);
            Exp exp = new Exp();

            exp.judge = "left";
            exp.value = "(";
            arrayList.add(exp);
            // System.out.println("添加一个" + exp.judge + " value = " + exp.value);
            visit(ctx.exp());
            Exp exp1 = new Exp();

            exp1.judge = "right";
            exp1.value = ")";
            arrayList.add(exp1);
            // System.out.println("添加一个" + exp1.judge + " value = " + exp1.value);
            // System.out.print(ctx.RPar());
            // System.out.print(x++);
        } else {
            visit(ctx.number());
        }
        // return super.visitPrimaryexp(ctx);
        return null;
    }


    @Override
    public Void visitNumber(testParser.NumberContext ctx) {
        // System.out.println(ctx.toString());
        // System.out.print(ctx);
        if (ctx.decimalconst() != null) {
            visit(ctx.decimalconst());
        } else if (ctx.octalconst() != null) {
            visit(ctx.octalconst());
        } else if (ctx.hexadecimalconst() != null) {
            visit(ctx.hexadecimalconst());
        }
        // return super.visitNumber(ctx);
        return null;
    }

    @Override
    public Void visitDecimalconst(testParser.DecimalconstContext ctx) {
        // System.out.print(ctx.Nonzerodigit());
        Exp exp = new Exp();

        exp.judge = "num";
        exp.value = ctx.Nonzerodigit().toString();
        arrayList.add(exp);
        // System.out.println("添加一个" + exp.judge + " value = " + exp.value);
        return super.visitDecimalconst(ctx);
    }

    @Override
    public Void visitOctalconst(testParser.OctalconstContext ctx) {
        Exp exp = new Exp();

        exp.judge = "num";
        exp.value = Integer.parseInt(ctx.Octaldigit().toString(), 8) + "";
        arrayList.add(exp);
        // System.out.println("添加一个" + exp.judge + " value = " + exp.value);
        return super.visitOctalconst(ctx);
    }

    @Override
    public Void visitHexadecimalconst(testParser.HexadecimalconstContext ctx) {
        // System.out.print(Integer.parseInt(ctx.Hexadecimalprefix().toString().substring(2),16));
        // System.out.println(Integer.parseInt("0X123".substring(2),16));
        Exp exp = new Exp();

        exp.judge = "num";
        exp.value = Integer.parseInt(ctx.Hexadecimalprefix().toString().substring(2), 16) + "";
        arrayList.add(exp);
        // System.out.println("添加一个" + exp.judge + " value = " + exp.value);
        return super.visitHexadecimalconst(ctx);
    }

}

class Exp {
    String judge;
    // number is num
    // +-*/% is symbol
    // ( is left
    // ) is right
    String value;
    // num is num
    // +-*/% is +-*/%
    // ( is (
    // ) is )
}
