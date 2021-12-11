import java.util.ArrayList;

public class FunctionList {
    // 总存储函数信息的数组
    public ArrayList<Function> functionArrayList = new ArrayList<>();

    // 构造器，初始化函数时创建
    public FunctionList() {
        Function function = new Function("main", new FunctionParam(0, "null",-1), false, "i32");
        functionArrayList.add(function);
        Function function1 = new Function("getint", new FunctionParam(0, "null",-1), false, "i32");
        functionArrayList.add(function1);
        Function function2 = new Function("getch", new FunctionParam(0, "null",-1), false, "i32");
        functionArrayList.add(function2);
        Function function3 = new Function("getarray", new FunctionParam(1, "array",-1), false, "i32");
        functionArrayList.add(function3);
        Function function4 = new Function("putint", new FunctionParam(1, "i32",-1), false, "void");
        functionArrayList.add(function4);
        Function function5 = new Function("putch", new FunctionParam(1, "i32",-1), false, "void");
        functionArrayList.add(function5);
        Function function6 = new Function("putarray", new FunctionParam(2, "i32 array",-1), false, "i32");
        functionArrayList.add(function6);
        Function function7 = new Function("memset", new FunctionParam(3, "i32* i32 i32",-1), false, "void");
        functionArrayList.add(function7);
    }

    // 给定参数名称，查找参数使用是否正确的方法
    public boolean judgeParamFunction(String name,ArrayList<Param> paramArrayList) {
        for (int i = 0; i < functionArrayList.size(); i++) {
            if (functionArrayList.get(i).FuntionName.equals(name)) {
                if (paramArrayList == null) {
                    if (functionArrayList.get(i).Param.Num == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
                // 找到对应函数
                if (functionArrayList.get(i).Param.Num == paramArrayList.size()) {
                    for (int i1 = 0;i1 < paramArrayList.size();i1++) {
                        if (functionArrayList.get(i).Param.ParamType.split(" ")[i1].equals(paramArrayList.get(i1).Type)) {

                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        // 没有找到对应函数，返回false
        return false;
    }

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
}
