import java.util.ArrayList;

public class FunctionCheck {
    /*
     * 库函数合法性类
     * 1 检查库函数名称是否合法
     * 2 检查库函数参数数量是否合法
     * 3 检查库函数参数种类是否合法
     * 返回值为boolean类型的true或false
     */
    public String reback(String FunctionName) {
        switch (FunctionName) {
            case "getint": {
                return "i32|)";
            }
            case "getch": {
                return "i32|)";
            }
            case "getarray": {
                return "i32|i32 [])";
            }
            case "putint": {
                return "void|i32)";
            }
            case "putch": {
                return "void|i32)";
            }
            case "putarray": {
                return "void|i32,i32 []) ";
            }
            default: {
                System.out.println("Error : Don't match any Function!");
                System.exit(3);
            }
        }
        return "yes";
    }

    public boolean judge(String FunctionName, ArrayList<lab3Vistor.Variable> arrayList) {
        switch (FunctionName) {
            case "getint": {
                return check_getint(arrayList);
            }
            case "getch": {
                return check_getch(arrayList);
            }
            case "getarray": {
                return check_getarray(arrayList);
            }
            case "putint": {
                return check_putint(arrayList);
            }
            case "putch": {
                return check_putch(arrayList);
            }
            case "putarray": {
                return check_putarray(arrayList);
            }
            default: {
                System.out.println("Error : Don't match any Function!");
                System.exit(3);
            }
        }

        return true;
    }

    public boolean check_getint(ArrayList arrayList) {
        if (arrayList.size() == 0)
            return true;
        else {
            System.exit(2);
            return true;
        }

    }

    public boolean check_getch(ArrayList arrayList) {
        if (arrayList.size() == 0)
            return true;
        else {
            System.exit(2);
            return true;
        }

    }

    public boolean check_getarray(ArrayList arrayList) {
        // lab3中暂不要求支持getarray()函数
        return true;
    }

    public boolean check_putint(ArrayList<lab3Vistor.Variable> arrayList) {
        if (arrayList.size() == 1 && arrayList.get(0).type.contains("int")) {
            return true;
        } else {
            System.exit(2);
            return true;
        }
    }

    public boolean check_putch(ArrayList<lab3Vistor.Variable> arrayList) {
        if (arrayList.size() == 1 && arrayList.get(0).type.contains("int")) {
            if (arrayList.get(0).value >= 0 && arrayList.get(0).value <= 255) {
                return true;
            }
        } else {
            System.exit(2);
        }
        return true;

    }

    public boolean check_putarray(ArrayList<lab3Vistor.Variable> arrayList) {
        // lab3中暂不要求支持putarray()函数
        return true;
    }
}
