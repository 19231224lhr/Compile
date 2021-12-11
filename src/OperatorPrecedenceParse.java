import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

/* 需要进行第一次重构
 * 接受一个参数，代表计算开始的寄存器的初始值
 * 还需要返回最后寄存器的值
 */
public class OperatorPrecedenceParse {
    public static int getResult(List<String> list) {
        // System.out.println(list);
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String c = list.get(i);
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/") && !c.equals("%") && !c.equals("(") && !c.equals(")")) { //当遇到操作数直接压栈
                stack.push(c);
            } else {//当遇到操作符的时候，从栈中弹出两个元素，然后根据运算符的不同做相应的运算，然后把运算结果压栈。
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (c.equals("+")) stack.push(a + b + "");
                else if (c.equals("-")) stack.push(a - b + "");
                else if (c.equals("*")) stack.push(a * b + "");
                else if (c.equals("/")) stack.push(a / b + "");
                else if (c.equals("%")) stack.push(a % b + "");
            }
        }
        //最终栈中肯定只剩下一个元素，就是计算的结果。
        // 最终栈中肯定只剩下一个元素，就是计算的结果。
        // 将栈中的元素转化为数值
        int result = 0;
        int a = 1;
        while (!stack.isEmpty()) {
            result += a * Integer.parseInt(stack.pop());
            a *= 10;
        }
        return result;
    }

    /**
     * 把中缀表达式转为后缀表达式
     * 前提条件：操作数的范围为0-9，操作符为+,-,*,/,%,以及()
     *
     * @param s 字符串表达式
     * @return
     */
    public static List<String> getPost(String s) {
        Stack<Character> stack = new Stack<>(); //保存操作符
        LinkedList<String> list = new LinkedList<>(); //保存最终的后缀表达式
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                //操作数直接输出到后缀表达式中
                String a = "";
                while(c >= '0' && c <= '9') {
                    a += c;
                    // System.out.println(i);
                    if (i + 1 != s.length()) {
                        c = s.charAt(i + 1);
                        i++;
                    } else {
                        i++;
                        break;
                    }
                }
                list.add(a);
                i--;
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                //把比当前操作符c的优先级高或者等于c的优先级的操作符依次弹出栈并保存到后缀表达式中，直到遇到栈顶操作符的优先级比c低
                while (!stack.isEmpty()) {
                    if (compare(stack.peek()) >= compare(c)) {
                        list.add(stack.pop() + "");
                    } else break;
                }
                stack.push(c);//当前操作符c入栈
            } else if (c == '(') stack.push(c); //左括号直接入栈
            else {
                //当遇到右括号的时候，把栈中的操作符依次弹出并追加到后缀表达式中，直到遇到左括号停止，并把左括号弹出。
                while (stack.peek() != '(') {
                    list.add(stack.pop() + "");
                }
                stack.pop();
            }
        }
        //把栈中所有的操作符全部弹出追加到后缀表达式中
        while (!stack.isEmpty()) list.add(stack.pop() + "");
        return list;
    }

    /**
     * 计算运算符的优先级
     *
     * @param c 运算符
     * @return
     */
    public static int compare(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/' || c == '%') return 2;
        else return 0;
    }
}
