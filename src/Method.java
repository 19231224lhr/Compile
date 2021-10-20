import java.util.ArrayList;

public class Method {
    int CompUnit(int index, ArrayList<String> words, ArrayList<String> result) {
        int ret;
        ret = FuncDef(index, words, result);

        return 0;
    }

    int FuncDef(int index, ArrayList<String> words, ArrayList<String> result) {
        int ret1,ret2;
        ret1 = FuncType(index, words, result);
        ret2 = Ident(ret1 + 1,words,result);
        index = ret2 + 1;
        String s1,s2;
        s1 = words.get(index);
        s2 = words.get(++index);
        index++;
        if (!s1.equals("(") || !s2.equals(")")) {
            System.out.println("Error : don't have ( or )");
            System.exit(3);
        }
        result.add("()");
        index = Block(index,words,result) + 1;

        return 0;
    }

    int FuncType(int index, ArrayList<String> words, ArrayList<String> result) {
        index = 0;
        String string = words.get(index);
        if (string.equals("int")) {
            result.add("define dso_local i32");

        } else {
            System.out.println("Error : first word is not 'int'!");
            System.exit(1);
        }
        return 0;
    }

    int Ident(int index, ArrayList<String> words, ArrayList<String> result) {
        String string = words.get(index);
        if (string.equals("main")) {
            result.add("@main");
        } else {
            System.out.println("Error : the second word is not 'main'!");
            System.exit(2);
        }
        return index;
    }

    // Block方法
    int Block(int index, ArrayList<String> words, ArrayList<String> result) {
        String s1,s2;
        s1 = words.get(index);
        if (!s1.equals("{")) {
            System.out.println("Error : don't have {!");
            System.exit(4);
        }
        result.add("{");
        result.add("\n");
        index = Stmt(index + 1,words,result) + 1;
        s2 = words.get(index);
        if (!s2.equals("}")) {
            System.out.println("Error : don't have }!");
            System.exit(4);
        }
        result.add("}");

        return index;
    }

    int Stmt(int index, ArrayList<String> words, ArrayList<String> result) {
        String s1,s2,s3;
        s1 = words.get(index++);
        if (!s1.equals("return")) {
            System.out.println("Error : don't have return!");
            System.exit(5);
        }
        result.add("ret i32 ");
        s2 = words.get(index);
        index = Number(index,s2,result) + 1;
        s3 = words.get(index);
        if (!s3.equals(";")) {
            System.out.println("Error : don't have ;!");
            System.exit(7);
        }
        result.add("\n");
        return index;
    }

    int Number(int index,String string,ArrayList<String> result) {
        if (string.contains("!number_err")) {
            System.out.println("Error : Number is error!");
            System.exit(6);
        }
        if (string.contains("!number_16")) {
            result.add(String.valueOf(Integer.parseInt(string.split(" ")[1].substring(2), 16)));

        } else if (string.contains("!number")) {
            String temp;
            temp = string.split(" ")[1];
            if (temp.charAt(0) == '0') {
                result.add(String.valueOf(Integer.parseInt(temp, 8)));
            } else {
                result.add(string.split(" ")[1]);
            }

        } else {
            System.out.println("Error : Number is error!");
            System.exit(6);

        }
        return index;
    }
}
