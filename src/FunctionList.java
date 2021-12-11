import java.util.ArrayList;

public class FunctionList {
    // 总存储函数信息的数组
    public ArrayList<Function> functionArrayList = new ArrayList<>();

    // 构造器，初始化函数时创建
    public FunctionList() {
        Function function = new Function("main", new FunctionParam(0, "null", null), false, "i32");
        functionArrayList.add(function);
        Function function1 = new Function("getint", new FunctionParam(0, "null", null), false, "i32");
        functionArrayList.add(function1);
        Function function2 = new Function("getch", new FunctionParam(0, "null", null), false, "i32");
        functionArrayList.add(function2);
        ArrayList<Param> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0);
        arrayList.add(new Param("i32*", null, 1, arrayList1));
        // 注意函数getarray参数类型
        Function function3 = new Function("getarray", new FunctionParam(1, "i32*", arrayList), false, "i32");
        functionArrayList.add(function3);
        arrayList = new ArrayList<>();
        arrayList.add(new Param("i32", null, 0, null));
        Function function4 = new Function("putint", new FunctionParam(1, "i32", arrayList), false, "void");
        functionArrayList.add(function4);
        arrayList = new ArrayList<>();
        arrayList.add(new Param("i32", null, 0, null));
        Function function5 = new Function("putch", new FunctionParam(1, "i32", arrayList), false, "void");
        functionArrayList.add(function5);
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        arrayList1.add(0);
        arrayList.add(new Param("i32", null, 0, null));
        arrayList.add(new Param("i32*", null, 1, arrayList1));
        Function function6 = new Function("putarray", new FunctionParam(2, "i32 i32*", arrayList), false, "void");
        functionArrayList.add(function6);
        // memset函数不需要参数检测
        Function function7 = new Function("memset", new FunctionParam(3, "i32* i32 i32", null), false, "void");
        functionArrayList.add(function7);
    }

    public boolean judgeParamFunction(String FuncName, ArrayList<Param> paramArrayList) {
        // 函数是否存在
        Function function = null;
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(FuncName)) {
                function = functionArrayList.get(i);
            }
        }
        if (function == null) {
            System.out.println("Error:您调用了未定义的函数");
            return false;
        }
        if (function.Param.Num == 0 && paramArrayList == null) {
            return true;
        } else if (function.Param.Num != 0 && paramArrayList == null) {
            System.out.println("Error:函数参数数量不正确");
            return false;
        }
        // 函数参数数量是否正确
        if (function.Param.Num != paramArrayList.size()) {
            System.out.println("Error:函数参数数量不正确，需要" + function.Param.Num + "个参数，传入" + paramArrayList.size() + "个参数");
            return false;
        } else {
            // 函数参数判断
            for (int i = 0; i < function.Param.Num; i++) {
                if (!function.Param.ParamList.get(i).Type.equals(paramArrayList.get(i).Type)) {
                    System.out.println("Error:函数参数类型错误" + function.Param.ParamList.get(i).Type + " " + paramArrayList.get(i).Type);
                    return false;
                }
                if (function.Param.ParamList.get(i).Num != paramArrayList.get(i).Num) {
                    System.out.println("Error:函数参数数组维数错误");
                    return false;
                }

            }
            return true;
        }
    }

    // 给定参数名称，查找参数使用是否正确的方法
//    public boolean judgeParamFunction(String name, ArrayList<Param> paramArrayList) {
//        for (int i = 0; i < functionArrayList.size(); i++) {
//            if (functionArrayList.get(i).FuntionName.equals(name)) {
//                if (paramArrayList == null) {
//                    if (functionArrayList.get(i).Param.Num == 0) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//                // 找到对应函数
//                if (functionArrayList.get(i).Param.Num == paramArrayList.size()) {
//                    for (int i1 = 0; i1 < paramArrayList.size(); i1++) {
//                        if (functionArrayList.get(i).Param.ParamType.split(" ")[i1].equals(paramArrayList.get(i1).Type)) {
//
//                        } else {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // 给定函数名称，查看函数是否已经被声明过了
    public boolean isUseFunction(String name) {
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(name)) {
                if (functionArrayList.get(i).isUse) {
                    return true;
                } else {
                    functionArrayList.get(i).isUse = true;
                    return false;
                }
            }
        }
        return false;
    }

    // 给定函数名称，将函数改为已经声明过的状态
    public void changeisUseFunction(String name) {
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(name)) {
                functionArrayList.set(i, new Function(functionArrayList.get(i).FuntionName, functionArrayList.get(i).Param, true, functionArrayList.get(i).ReturnType));
            }
        }
    }

    // 给定函数名称，返回函数所有信息
    public Function returnFunction(String name) {
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(name)) {
                return functionArrayList.get(i);
            }
        }
        return null;
    }
    // 先调用函数检查正确性，在调用检查是否声明的函数

    // 检查是否有同名函数
    public boolean isSameFunction(String FuncName) {
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(FuncName)) {
                return true;
            }
        }
        return false;
    }
}
