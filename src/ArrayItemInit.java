import java.util.ArrayList;

public class ArrayItemInit {
    public int value;   // 数组元素值
    public String ArrName;  // 所属数组名
    public int Register;    // 所属数组寄存器
    ArrayList<Integer> position; // 数组元素在初始化时的位置

    public ArrayItemInit() {

    }

    public ArrayItemInit(int value, String arrName, int register, ArrayList<Integer> position) {
        this.value = value;
        ArrName = arrName;
        Register = register;
//        for (int i = 0;i < position.size();i++) {
//            Position.add(position.get(i));
//        }
        this.position = new ArrayList<>(position);
    }
}
