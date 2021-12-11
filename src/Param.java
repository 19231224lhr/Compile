import java.util.ArrayList;

public class Param {
    public String Type; // 参数类型 int, array
    public String Name; // 参数名字
    public int Num;     // 如果参数类型是array，则此处存储数组维数
    public ArrayList<Integer> ArrayDimension;   // 数组中括号内的数组
    // 如果参数不是数组类型，存储null


    public Param(String type, String name, int num, ArrayList<Integer> ArrayDimension) {
        Type = type;
        this.Name = name;
        Num = num;
        this.ArrayDimension = ArrayDimension;
    }
}
