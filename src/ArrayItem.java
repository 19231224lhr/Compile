import java.util.ArrayList;
import java.util.HashMap;

public class ArrayItem {
    public int ArrayRegister;   // 数组寄存器
    public String ArrayName;    // 数组名
    public String ArrayType;    // 数组类型int,constint
    public int ArrayLayer;
    public int Dimension;       // 数组维度
    public int Width;
    public ArrayList<Integer> arrayList;    // 数组每个方括号内的数字
    public boolean isValue;     // 数组是否被初始化
    public int Layer;
    public HashMap<Integer,Integer> hashMap;

    // 一维数组，二维数组构造器
    public ArrayItem(int arrayRegister, String arrayName, String arrayType,int ArrayLayer, int dimension,int Width, boolean isValue, int Layer,HashMap<Integer,Integer> hashMap) {
        ArrayRegister = arrayRegister;
        ArrayName = arrayName;
        ArrayType = arrayType;
        this.ArrayLayer = ArrayLayer;
        Dimension = dimension;
        this.Width = Width;
        this.isValue = isValue;
        this.Layer = Layer;
        this.hashMap = hashMap;
    }

    // 多维数组构造器
    public ArrayItem(int arrayRegister, String arrayName, String arrayType, int dimension,ArrayList<Integer> arrayList, boolean isValue, int Layer) {
        ArrayRegister = arrayRegister;
        ArrayName = arrayName;
        ArrayType = arrayType;
        Dimension = dimension;
        this.arrayList = arrayList;
        this.isValue = isValue;
        this.Layer = Layer;
    }

    // 函数参数数组类型构造器
    public ArrayItem(String arrayType, int dimension) {
        ArrayType = arrayType;
        Dimension = dimension;
    }

}