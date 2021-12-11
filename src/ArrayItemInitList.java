import java.util.ArrayList;

public class ArrayItemInitList {
    ArrayList<ArrayItemInit> arrayItemInitArrayList = new ArrayList<>();

    public ArrayItemInit FindItem(String ArrayName,ArrayList<Integer> position) {
        boolean isFind = false;
        for (int i = 0;i < arrayItemInitArrayList.size();i++) {
            // System.out.println(arrayItemInitArrayList.get(i).position);
            if (arrayItemInitArrayList.get(i).ArrName.equals(ArrayName) && arrayItemInitArrayList.get(i).position.size() == position.size()) {
                int judge = 0;
                for (int j = 0; j < arrayItemInitArrayList.get(i).position.size(); j++) {
                    // System.out.println(arrayItemInits.get(i).Position.get(j) + " " + position.get(j));
                    if (arrayItemInitArrayList.get(i).position.get(j).intValue() == position.get(j).intValue()) {
                        judge++;
                    }
                }
                if (judge == arrayItemInitArrayList.get(0).position.size()) {
                    // 找到目标元素
                    return arrayItemInitArrayList.get(i);
                }
            }
        }
        return null;
    }
}
