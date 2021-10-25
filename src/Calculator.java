import java.util.Collections;
import java.util.Stack;

/**
 *  算数表达式求值 
 *  直接调用Calculator的类方法conversion() 
 *  传入算数表达式，将返回一个浮点值结果
 *  如果计算过程错误，将返回一个NaN
 */
public class Calculator {
    private Stack<String> postfixStack = new Stack<String>();// 后缀式栈
    private Stack<Character> opStack = new Stack<Character>();// 运算符栈
    private int[] operatPriority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2,2 };// 运用运算符ASCII码-40做索引的运算符优先级

    public static double conversion(String expression) {
        if (expression.length() == 1) {
            return Double.parseDouble(expression);
        }
        double result = 0;
        Calculator cal = new Calculator();
        try {
            expression = transform(expression);
            result = cal.calculate(expression);
        } catch (Exception e) {
            // e.printStackTrace();
            // 运算错误返回NaN
            return 0.0 / 0.0;
        }
        // return new String().valueOf(result);
        return result;
    }

    /**
     * 将表达式中负数的符号更改
     *
     * @param expression
     *            例如-2+-1*(-3E-2)-(-1) 被转为 ~2+~1*(~3E~2)-(~1)
     * @return
     */
    private static String transform(String expression) {
        char[] arr = expression.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                if (i == 0) {
                    arr[i] = '~';
                } else {
                    char c = arr[i - 1];
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == 'E' || c == 'e' || c == '%') {
                        arr[i] = '~';
                    }
                }
            }
        }
        if(arr[0] != '(' && (arr[0]=='~'||arr[1]=='(')){
            arr[0]='-';
            return "0"+new String(arr);
        }else{
            return new String(arr);
        }
    }

    /**
     * 按照给定的表达式计算
     *
     * @param expression
     *            要计算的表达式例如:5+12*(3+5)/7
     * @return
     */
    public double calculate(String expression) {
        Stack<String> resultStack = new Stack<String>();
        prepare(expression);
        Collections.reverse(postfixStack);// 将后缀式栈反转
        String firstValue, secondValue, currentValue;// 参与计算的第一个值，第二个值和算术运算符
        while (!postfixStack.isEmpty()) {
            currentValue = postfixStack.pop();
            if (!isOperator(currentValue.charAt(0))) {// 如果不是运算符则存入操作数栈中
                currentValue = currentValue.replace("~", "-");
                resultStack.push(currentValue);
            } else {// 如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                secondValue = resultStack.pop();
                firstValue = resultStack.pop();

                // 将负数标记符改为负号
                firstValue = firstValue.replace("~", "-");
                secondValue = secondValue.replace("~", "-");

                String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }
        return Double.valueOf(resultStack.pop());
    }

    /**
     * 数据准备阶段将表达式转换成为后缀式栈
     *
     * @param expression
     */
    private void prepare(String expression) {
        opStack.push(',');// 运算符放入栈底元素逗号，此符号优先级最低
        char[] arr = expression.toCharArray();
        int currentIndex = 0;// 当前字符的位置
        int count = 0;// 上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
        char currentOp, peekOp;// 当前操作符和栈顶操作符
        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            if (isOperator(currentOp)) {// 如果当前字符是运算符
                if (count > 0) {
                    postfixStack.push(new String(arr, currentIndex, count));// 取两个运算符之间的数字
                }
                peekOp = opStack.peek();
                if (currentOp == ')') {// 遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
                    while (opStack.peek() != '(') {
                        postfixStack.push(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)) {
                        postfixStack.push(String.valueOf(opStack.pop()));
                        peekOp = opStack.peek();
                    }
                    opStack.push(currentOp);
                }
                count = 0;
                currentIndex = i + 1;
            } else {
                count++;
            }
        }
        if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {// 最后一个字符不是括号或者其他运算符的则加入后缀式栈中
            postfixStack.push(new String(arr, currentIndex, count));
        }

        while (opStack.peek() != ',') {
            postfixStack.push(String.valueOf(opStack.pop()));// 将操作符栈中的剩余的元素添加到后缀式栈中
        }
    }

    /**
     * 判断是否为算术符号
     *
     * @param c
     * @return
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '%';
    }

    /**
     * 利用ASCII码-40做下标去算术符号优先级
     *
     * @param cur
     * @param peek
     * @return
     */
    public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
        boolean result = false;
        int a = (peek) - 40;
        int b = (cur) - 40;
        if (a < 0) {
            a = 8;
        }
        if (b < 0) {
            b = 8;
        }
        if (operatPriority[a] >= operatPriority[b]) {
            result = true;
        }
        return result;
    }

    /**
     * 按照给定的算术运算符做计算
     *
     * @param firstValue
     * @param secondValue
     * @param currentOp
     * @return
     */
    private String calculate(String firstValue, String secondValue, char currentOp) {
        String result = "";
        switch (currentOp) {
            case '+':
                result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                break;
            case '-':
                result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                break;
            case '*':
                result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                break;
            case '/':
                result = String.valueOf(ArithHelper.div(firstValue, secondValue));
                break;
            case '%' :
                result = String.valueOf(ArithHelper.yushu(firstValue,secondValue));
                break;
        }
        return result;
    }
}

class ArithHelper {

    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 16;

    // 这个类不能实例化
    private ArithHelper() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static double add(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    public static double yushu(String v1, String v2) {
        int a,b;
        if (v1.indexOf('.') != -1) {
            a = Integer.parseInt(v1.substring(0, v1.indexOf('.')));
        } else {
            a = Integer.parseInt(v1);
        }
        if (v2.indexOf('.') != -1) {
            b = Integer.parseInt(v2.substring(0, v2.indexOf('.')));
        } else {
            b = Integer.parseInt(v2);
        }
        int c = a/ b;
        return (double) a - c * b;
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double sub(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1
     *            被乘数
     * @param v2
     *            乘数
     * @return 两个参数的积
     */

    public static double mul(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double mul(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    public static double div(String v1, String v2) {
//        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
//        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        int a,b;
        if (v1.indexOf('.') != -1) {
            a = Integer.parseInt(v1.substring(0, v1.indexOf('.')));
        } else {
            a = Integer.parseInt(v1);
        }
        if (v2.indexOf('.') != -1) {
            b = Integer.parseInt(v2.substring(0, v2.indexOf('.')));
        } else {
            b = Integer.parseInt(v2);
        }
        int result = a / b;
        // return b1.divide(b2, DEF_DIV_SCALE, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
        return (double) result;
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        java.math.BigDecimal b = new java.math.BigDecimal(Double.toString(v));
        java.math.BigDecimal one = new java.math.BigDecimal("1");
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        java.math.BigDecimal b = new java.math.BigDecimal(v);
        java.math.BigDecimal one = new java.math.BigDecimal("1");
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}