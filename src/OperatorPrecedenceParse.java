import java.util.ArrayList;
import java.util.Stack;

/* 需要进行第一次重构
 * 接受一个参数，代表计算开始的寄存器的初始值
 * 还需要返回最后寄存器的值
 */
public class OperatorPrecedenceParse {
    // 定义算术符号
    String Symbol = "+ - * / % ( ) #";

    // 定义寄存器数字全局变量
    // 每次调用后就将数字栈中的元素增添一个a/b/c...使用a - 索引值即可定位到使用的是哪一个寄存器
    // 比如减完后结果是1，则代表当前元素已经存储在了%x1寄存器中，调用相关的寄存器即可
    // String Register = "abcdefghigklmnopqrstuvwxyz";
    int Register = 0;
    int Index = 0;

    // 定义算符优先矩阵
    // > 是 1，< 是 0，出错或者不存在这种情况 是 -1，()里面只有一个数字 是 2
    static int[][] Priority = {
            // +  -  *  /  %  (  )  #
            {1, 1, 0, 0, 0, 0, 1, 1},   // +
            {1, 1, 0, 0, 0, 0, 1, 1},   // -
            {1, 1, 1, 1, 1, 0, 1, 1},   // *
            {1, 1, 1, 1, 1, 0, 1, 1},   // /
            {1, 1, 1, 1, 1, 0, 1, 1},   // %
            {0, 0, 0, 0, 0, 0, 0, -1},  // (
            {1, 1, 1, 1, 1, -1, 1, 1},  // )
            {0, 0, 0, 0, 0, 0, 0, -1}   // #

    };

    // 定义运算符栈
    Stack<String> Operator = new Stack<String>();

    // 定义运算元素栈
    // 考虑到存在寄存器的影响，所以我们将结果栈的类型定义为String
    Stack<String> Results = new Stack<String>();

    public String calculator(ArrayList<String> input, int RegisterIndex) {
        // 赋值
        Index = RegisterIndex;
        Register = RegisterIndex;
        // 运算表达式先在结尾添加终结符号#
        input.add("#");
        // 运算符栈现在栈的开头添加终结符号#
        Operator.push("#");
        // System.out.println("您输入的字符串算式是：" + input);
        // 将负数的'-'符号替换为'~'符号
        input = format(input);
        // System.out.println("字符串转换结果是：" + input);
        int i = 0;
        while (true) {
            // 当符号栈到栈底并且输入字符串也到栈底时，退出循环
            if (Operator.peek().equals("#") && input.get(i).equals("#")) {
                // System.out.println("分析完成，退出循环！");
                break;
            }
            // 当输入字符串是数字时直接进栈，注意负数的判断
            if (!Symbol.contains(input.get(i))) {
                // 负数
                if (input.get(i).equals("~")) {
                    // ~ 号后面一定是数字，因此不用判断i + 1 < length
                    // 为每个负数都构造一个LLVM IR表达式
                    // System.out.println("%x" + (Register.charAt(Index) - 97) + " = sub i32 0," + input.get(i + 1));
                    lab3Vistor.Result.add("%x" + Register + " = sub i32 0," + input.get(i + 1));
                    lab3Vistor.Result.add("\n");
                    Results.push("%x" + Register);
                    Register++;
                    i += 2;
                } else {
                    // 正数
                    Results.push(input.get(i));
                    i++;
                }
            } else
                // 当输入字符串是运算符时，需要进行运算优先级的运算，同时需要打印寄存器的信息
                if (Symbol.contains(input.get(i))) {
                    int priority;
                    priority = searchPriority(Operator.peek(), input.get(i));
                    // System.out.println("当前运算符：in = " + Operator.peek() + " out = " + input.get(i) + "，两者的运算优先级为：" + priority);
                    if (input.get(i).equals(")") && Operator.peek().equals("(")) {
                        // System.out.println("两个括号之间是一个数字");
                        Operator.pop();
                        i++;
                        continue;
                    }
                    switch (priority) {
                        case 1: {
                            // 1 表示 大于，因此应该计算结果
                            // 如果此时运算符是)，并且运算符栈的栈顶元素是(，说明此时括号里面的只是一个数字，不需要进行计算，将(符号出栈，)符号不需要入栈
                            // 注意顺序
                            String a, b;
                            b = Results.pop();
                            a = Results.pop();
//                            // 如果a或者b是寄存器，则转换为寄存器格式
//                            if (Register.contains(a)) {
//                                a = "%" + (a.charAt(0) - 97);
//                            }
//                            if (Register.contains(b)) {
//                                b = "%" + (b.charAt(0) - 97);
//                            }
                            // 如果a或b是字母，则代表这是一个存储在寄存器中的值
                            String symbol = Operator.pop();
                            switch (symbol) {
                                /*
                                LLVM IR指令集具体参考文章链接：https://blog.csdn.net/qq_37206105/article/details/115274241
                                 */
                                case "+": {
                                    // 加法
                                    // System.out.println("%" + (Register.charAt(Index) - 97) + " = add i32 " + a + "," + b);
                                    lab3Vistor.Result.add("%x" + Register + " = add i32 " + a + "," + b);
                                    lab3Vistor.Result.add("\n");
                                    Results.push("%x" + Register);
                                    Register++;
                                    break;
                                }
                                case "-": {
                                    // 减法
                                    // System.out.println("%" + (Register.charAt(Index) - 97) + " = sub i32 " + a + "," + b);
                                    lab3Vistor.Result.add("%x" + Register + " = sub i32 " + a + "," + b);
                                    lab3Vistor.Result.add("\n");
                                    Results.push("%x" + Register);
                                    Register++;
                                    break;
                                }
                                case "*": {
                                    // 乘法
                                    // System.out.println("%" + (Register.charAt(Index) - 97) + " = mul i32 " + a + "," + b);
                                    lab3Vistor.Result.add("%x" + Register + " = mul i32 " + a + "," + b);
                                    lab3Vistor.Result.add("\n");
                                    Results.push("%x" + Register);
                                    Register++;
                                    break;
                                }
                                case "/": {
                                    // 除法
                                    // 注意要使用sdiv作为除法符号，因为sdiv表示有符号除法，udiv表示无符号除法，fdiv表示浮点数除法
                                    // System.out.println("%" + (Register.charAt(Index) - 97) + " = sdiv i32 " + a + "," + b);
                                    lab3Vistor.Result.add("%x" + Register + " = sdiv i32 " + a + "," + b);
                                    lab3Vistor.Result.add("\n");
                                    Results.push("%x" + Register);
                                    Register++;
                                    break;
                                }
                                case "%": {
                                    // 取余
                                    // 注意要使用srem作为取余符号，因为srem表示有符号取余，frem表示浮点数运算取余
                                    // System.out.println("%" + (Register.charAt(Index) - 97) + " = srem i32 " + a + "," + b);
                                    lab3Vistor.Result.add("%x" + Register + " = srem i32 " + a + "," + b);
                                    lab3Vistor.Result.add("\n");
                                    Results.push("%x" + Register);
                                    Register++;
                                    break;
                                }
//                                }
                            }
                            break;
                        }
                        case 0: {
                            // 简写版本
                            Operator.push(input.get(i));
                            i++;
                            break;
                            // 0 表示 小于，此时应该数字入栈
                        }
                    }
                }
        }
        return "%" + (--Register);
    }

    // 将负数的'-'转换为'~'
    // 注意，不能将减法的减号也转换
    public ArrayList<String> format(ArrayList<String> input) {
        int i = 0;
        ArrayList<String> result = new ArrayList<>();
        String judge = "*/%(";
        for (i = 0; i < input.size(); i++) {
            if (i == 0 && input.get(i).equals("-") && !input.get(i + 1).equals("(")) {
                result.add("~");
            } else if (i == 0 && input.get(i).equals("-") && input.get(i + 1).equals("(")) {
                result.add("0");
                result.add("-");
            } else {
                result.add(input.get(i));
                if (judge.contains(input.get(i))) {
                    // * / % ( 肯定不是算是字符串的最后一位，所以不用判断i + 1 < length
                    if (input.get(i + 1).equals("-") && !input.get(i + 2).equals("(")) {
                        // 这个是负号
                        result.add("~");
                        i++;
                    } else if (input.get(i + 1).equals("-") && input.get(i + 2).equals("(")) {
                        result.add("0");
                    }
                }
            }
        }
        return result;
    }

    // 输入运算符查询运算符优先级的函数
    public int searchPriority(String symbol_in, String symbol_out) {
        int in = 0, out = 0;
        switch (symbol_in) {
            case "+":
                in = 0;
                break;
            case "-":
                in = 1;
                break;
            case "*":
                in = 2;
                break;
            case "/":
                in = 3;
                break;
            case "%":
                in = 4;
                break;
            case "(":
                in = 5;
                break;
            case ")":
                in = 6;
                break;
            case "#":
                in = 7;
                break;
        }
        switch (symbol_out) {
            case "+":
                out = 0;
                break;
            case "-":
                out = 1;
                break;
            case "*":
                out = 2;
                break;
            case "/":
                out = 3;
                break;
            case "%":
                out = 4;
                break;
            case "(":
                out = 5;
                break;
            case ")":
                out = 6;
                break;
            case "#":
                out = 7;
                break;
        }
        return Priority[in][out];
    }
}
