import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class FunctionParam {
    // 函数参数类
    public int Num; // 参数数量
    public String ParamType;    // 参数类型
    public ArrayList<Param> ParamList;  // 每个参数详细信息
    /*
     * 参数类型以字符串类型存储，如果Num不为一，则说明参数有多个，此时不同的参数类型之间用空格分隔，比如"int intArray"表示有两个参数，参数int和参数intArray
     * int: 整形
     * intArray: 整型数组
     * null: 没有参数
     */

    // 构造器

    public FunctionParam(int num, String paramType, ArrayList<Param> paramList) {
        Num = num;
        ParamType = paramType;
        ParamList = paramList;
    }
}
