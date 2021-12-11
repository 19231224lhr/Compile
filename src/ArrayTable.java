import java.util.ArrayList;

public class ArrayTable {
    public ArrayList<ArrayItem> arrayItems = new ArrayList<>();

    public ArrayItem SearchArray(String ArrayName) {
        for (int i = arrayItems.size() - 1;i >= 0;i--) {
            if (arrayItems.get(i).ArrayName.equals(ArrayName)) {
                return arrayItems.get(i);
            }
        }
        return null;
    }

    // 清除非全局变量数组信息
    // 注意，此时数组信息中的数组位于函数第几层信息存储位置是Layer，不再是ArrayLayer
    public void ClearArrayList() {
        for (int i = 0;i < arrayItems.size();i++) {
            if (arrayItems.get(i).Layer != 0) {
                arrayItems.remove(i);
            }
        }
    }
}
