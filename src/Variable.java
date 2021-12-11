public class Variable {
    // 变量类
    int Register;   // 寄存器
    String VarName; // 变量名
    int Value;      // 变量值
    String Type;    // 变量类型
    boolean isValue;    // 变量是否被赋值
    int Layer;      // 变量属于第几层结构
    // 我们规定主函数属于第1层，之后的函数块属于1 + n层
    // 离大谱，if(){}语句块内也认为block

    public Variable(int register, String varName, int value, String type, boolean isValue,int Layer) {
        Register = register;
        VarName = varName;
        Value = value;
        Type = type;
        this.isValue = isValue;
        this.Layer = Layer;
    }
}
