import java.util.ArrayList;

public class GloableVar {
    ArrayList<Variable> gloableArray = new ArrayList<>();

    // 通过变量名寻找对应的全局变量，用于全局变量定义
    public Variable SearchName(String name) {
        for (int i = 0;i < gloableArray.size();i++) {
            if (gloableArray.get(i).VarName.equals(name)) {
                return gloableArray.get(i);
            }
        }
        return null;
    }

    // 通过寄存器的值判断寄存器中存储的是否为全局变量，用于全局变量调用
    public boolean SearchRegister(int Register) {
        for (int i = 0;i < gloableArray.size();i++) {
            if (gloableArray.get(i).Register == Register) {
                return true;
            }
        }
        return false;
    }

    // 全局变量表达式化简，将++-化简为-等
    public String AnalyseString(String string) {
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
        if (result.toString().charAt(0) == '-') {
            result = new StringBuilder("0" + result.toString());
        }

        return result.toString();
    }
}
