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
}
