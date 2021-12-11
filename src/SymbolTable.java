import java.util.ArrayList;

public class SymbolTable {
    // 符号表
    ArrayList<Variable> Table = new ArrayList<>();
    // 变量在符号表中的位置
    int index;

//    // 向符号表中增添符号，先检查符号表中是否存在想要添加的变量
//    public boolean Add(Variable variable) {
//        if (Search(variable.VarName) != null) {
//            return false;
//        } else {
//            Table.add(variable);
//        }
//        return true;
//    }

    // 查询同层是否已经声明了相同变量名的变量,主要用在int a = 0;定义变量语句中
    public boolean LayerSearch(String name,int Layer) {
        for (int i = Table.size() - 1;i >= 0;i--) {
            if (Table.get(i).VarName.equals(name) && Table.get(i).Layer == Layer) {
                // 同层找到了相同的变量名
                return true;
            }
        }
        return false;
    }
    // 查询对应符号，若查找不到对应的符号则返回null,主要用于a = 1;赋值语句中
    public Variable Search(String name,int Layer) {
        // 加入Layer层的概念后，搜索就需要从上向下搜索
        for (int i = Table.size() - 1;i >= 0 ; i--) {
            if (Table.get(i).VarName.equals(name) && Table.get(i).Layer == Layer) {
                index = i;
                return Table.get(i);
            }
        }
        return null;
    }

    // 查询对应符号，若查找不到对应的符号则返回null,主要用于a = 1;赋值语句中
    public Variable SearchWithDifferentLayer(String name, int Layer) {
        // 加入Layer层的概念后，搜索就需要从上向下搜索
        for (int i = Table.size() - 1;i >= 0 ; i--) {
            if (Table.get(i).VarName.equals(name) && Table.get(i).Layer != Layer) {
                index = i;
                return Table.get(i);
            }
        }
        return null;
    }

    // 查询变量是否已经赋值,不要求层数必须相同
    public Variable SearchValue(String name) {
        for (int i = Table.size() - 1;i >= 0 ; i--) {
            if (Table.get(i).VarName.equals(name)) {
                return Table.get(i);
            }
        }
        System.out.println("您没有定义变量");
        // System.out.println("name " + name);
        System.exit(6);
        return null;
    }

    public boolean isExist(String name) {
        // 查看变量是否存在用在a = 1;赋值语句中,因此需要从前向后搜索
        // 只要存在就行,因此找到就好
        for (int i = 0;i < Table.size();i++) {
            if (Table.get(i).VarName.equals(name)) {
                // 变量存在,可以赋值
                return true;
            }
        }
        return false;
    }

    // 不搜索指定层数变量
    public boolean isExist(String name,int Layer) {
        // 查看变量是否存在用在a = 1;赋值语句中,因此需要从前向后搜索
        // 只要存在就行,因此找到就好
        for (int i = 0;i < Table.size();i++) {
            if (Table.get(i).VarName.equals(name) && Table.get(i).Layer != Layer) {
                // 变量存在,可以赋值
                return true;
            }
        }
        return false;
    }

    // 删除指定层数变量
    public void TableDelete(int Layer) {
        for (int i = Table.size() - 1;i >= 0;i--) {
            if (Table.get(i).Layer == Layer) {
                Table.remove(Table.get(i));
            }
        }
    }

//    // 修改符号表
//    public boolean Change(Variable variable) {
//        if (Search(variable.VarName) == null) {
//            return false;
//        } else {
//            Table.set(index, variable);
//        }
//        return true;
//    }
}