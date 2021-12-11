public class Function {
    // 函数定义类，包含函数名称，函数参数信息，函数是否被使用了，函数返回值类型
    public String FuntionName;
    public FunctionParam Param;
    public boolean isUse;
    public String ReturnType;
    // 构造器
    public Function(String funtionName,FunctionParam param,boolean isUse,String returnType) {
        this.FuntionName = funtionName;
        this.Param = param;
        this.isUse = isUse;
        this.ReturnType = returnType;
    }
}
