import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>(100);
        String judge = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        String judgeDight = "0123456789";
        String judgeLetter = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        String hexadecimal_digit = "0123456789ABCDEFABCDEF";
        String[] save_words = new String[]{"int", "boolean", "double", "string"};
//        String filePath = scanner.nextLine();
        String filePath = args[0];
        String OutputPath = args[1];
//        String filePath = "C:\\Users\\lhr4108\\Desktop\\test.txt";
//        System.out.println(filePath);
        File file = new File(filePath);
        int a = 0x123;
        if (file.isFile() && file.exists()) {
            InputStreamReader read = null;
            try {
                read = new InputStreamReader(
                        new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            boolean isZhushi = false;
            while (true) {
                try {
                    if ((lineTxt = bufferedReader.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String line = lineTxt;
                int length = line.length();
                int k = 0;
                boolean test = false;
                boolean judge_Letter = false;
                char c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

                while (k <= length - 1) {
                    test = false;
                    c = line.charAt(k);
                    if (isZhushi) {
                        while (k != length) {
                            if (line.charAt(k) == '*') {
                                if (k + 1 < length) {
                                    if (line.charAt(k + 1) == '/') {
                                        isZhushi = false;
                                        k = k + 2;
                                        // System.out.println("k = " + k);
                                        break;
                                    }
                                }
                            }
                            k++;
                        }
                    }
                    if (c == '0' && k + 1 < length && (line.charAt(k + 1) == 'X' || line.charAt(k + 1) == 'x')) {
                        // 16
                        String temp = "";
                        if (line.charAt(k + 1) == 'X') {
                            temp = "!number 0X";
                        } else {
                            temp = "!number 0x";
                        }
                        k = k + 2;
                        while (k < length) {
                            c = line.charAt(k);
                            if (hexadecimal_digit.indexOf(c) != -1) {
                                temp = temp + c;
                            } else {
                                k++;
                                break;
                            }
                            k++;
                        }
                        words.add(temp);
                        test = true;
                    }

                    if (c == 'i' && k + 1 < length) {
                        // 判断是不是if
                        c1 = line.charAt(k + 1);
                        if (k + 2 == length) {
                            if (c1 == 'f') {
                                System.out.println("If");
                                test = true;
                                k = k + 2;
                            }
                        } else if (k + 2 < length) {
                            c2 = line.charAt(k + 2);
                            if (c1 == 'f' && (c2 == ' ' || c2 == ';' || c2 == '(' || c2 == '\t' || c2 == '\n')) {
                                System.out.println("If");
                                test = true;
                                k = k + 2;
                            }
                        }
                    }
                    if (c == 'e' && k + 3 < length) {
                        c1 = line.charAt(k + 1);
                        c2 = line.charAt(k + 2);
                        c3 = line.charAt(k + 3);
                        if (k + 4 == length) {
                            if (c1 == 'l' && c2 == 's' && c3 == 'e') {
                                System.out.println("Else");
                                test = true;
                                k = k + 4;
                            }
                        } else if (k + 4 < length) {
                            c4 = line.charAt(k + 4);
                            if (c1 == 'l' && c2 == 's' && c3 == 'e' && (c4 == ' ' || c4 == ';' || c4 == '{' || c4 == '\t' || c4 == '\n')) {
                                System.out.println("Else");
                                test = true;
                                k = k + 4;
                            }
                        }
                    }
                    if (c == 'w' && k + 4 < length) {
                        c1 = line.charAt(k + 1);
                        c2 = line.charAt(k + 2);
                        c3 = line.charAt(k + 3);
                        c4 = line.charAt(k + 4);
                        if (k + 5 == length) {
                            if (c1 == 'h' && c2 == 'i' && c3 == 'l' && c4 == 'e') {
                                System.out.println("While");
                                test = true;
                                k = k + 5;
                            }
                        } else if (k + 5 < length) {
                            c5 = line.charAt(k + 5);
                            if (c1 == 'h' && c2 == 'i' && c3 == 'l' && c4 == 'e' && (c5 == ' ' || c5 == ';' || c5 == '(' || c5 == '\t' || c5 == '\n')) {
                                // 符合条件
                                System.out.println("While");
                                test = true;
                                k = k + 5;
                            }
                        }
                    }
                    if (c == 'b' && k + 4 < length) {
                        // 判断是不是break
                        c1 = line.charAt(k + 1);
                        c2 = line.charAt(k + 2);
                        c3 = line.charAt(k + 3);
                        c4 = line.charAt(k + 4);
                        if (k + 5 == length) {
                            if (c1 == 'r' && c2 == 'e' && c3 == 'a' && c4 == 'k') {
                                System.out.println("Break");
                                test = true;
                                k = k + 5;
                            }
                        } else if (k + 5 < length) {
                            c5 = line.charAt(k + 5);
                            if (c1 == 'r' && c2 == 'e' && c3 == 'a' && c4 == 'k' && (c5 == ' ' || c5 == ';' || c5 == '\t' || c5 == '\n')) {
                                System.out.println("Break");
                                test = true;
                                k = k + 5;
                            }
                        }
                    }
                    if (c == 'c' && k + 7 < length) {
                        // 判断是不是continue
                        c1 = line.charAt(k + 1);
                        c2 = line.charAt(k + 2);
                        c3 = line.charAt(k + 3);
                        c4 = line.charAt(k + 4);
                        c5 = line.charAt(k + 5);
                        c6 = line.charAt(k + 6);
                        c7 = line.charAt(k + 7);
                        if (k + 8 == length) {
                            if (c1 == 'o' && c2 == 'n' && c3 == 't' && c4 == 'i' && c5 == 'n' && c6 == 'u' && c7 == 'e') {
                                System.out.println("Continue");
                                test = true;
                                k = k + 8;
                            }
                        } else if (k + 8 < length) {
                            c8 = line.charAt(k + 8);
                            if (c1 == 'o' && c2 == 'n' && c3 == 't' && c4 == 'i' && c5 == 'n' && c6 == 'u' && c7 == 'e' && (c8 == ' ' || c8 == ';' || c8 == '\t' || c8 == '\n')) {
                                System.out.println("Continue");
                                test = true;
                                k = k + 8;
                            }

                        }
                    }
                    if (c == 'r' && k + 5 < length) {
                        // 判断是不是return
                        c1 = line.charAt(k + 1);
                        c2 = line.charAt(k + 2);
                        c3 = line.charAt(k + 3);
                        c4 = line.charAt(k + 4);
                        c5 = line.charAt(k + 5);
                        if (k + 6 == length) {
                            if (c1 == 'e' && c2 == 't' && c3 == 'u' && c4 == 'r' && c5 == 'n') {
                                // System.out.println("Return");
                                words.add("return");
                                test = true;
                                k = k + 6;
                            }
                        } else if (k + 6 < length) {
                            c6 = line.charAt(k + 6);
                            if (c1 == 'e' && c2 == 't' && c3 == 'u' && c4 == 'r' && c5 == 'n' && (c6 == ' ' || c6 == ';' || c6 == '(' || c6 == '{' || c6 == '\t' || c6 == '\n')) {
                                // System.out.println("Return");
                                words.add("return");
                                test = true;
                                k = k + 6;
                            }

                        }
                    }
                    if (c == '=') {
                        if (k + 1 == length) {
                            System.out.println("Assign");
                            test = true;
                            k++;
                        } else {
                            c1 = line.charAt(k + 1);
                            if (c1 != '=') {
                                System.out.println("Assign");
                                test = true;
                                k++;
                            } else {
                                System.out.println("Eq");
                                test = true;
                                k = k + 2;
                            }
                        }

                    }
                    if (c == ';') {
                        // System.out.println("Semicolon");
                        words.add(";");
                        test = true;
                        k++;
                    }
                    if (c == '(') {
                        // System.out.println("LPar");
                        words.add("(");
                        test = true;
                        k++;
                    }
                    if (c == ')') {
                        // System.out.println("RPar");
                        words.add(")");
                        test = true;
                        k++;
                    }
                    if (c == '{') {
                        // System.out.println("LBrace");
                        words.add("{");
                        test = true;
                        k++;
                    }
                    if (c == '}') {
                        // System.out.println("RBrace");
                        words.add("}");
                        test = true;
                        k++;
                    }
                    if (c == '+') {
                        System.out.println("Plus");
                        test = true;
                        k++;
                    }
                    if (c == '*') {
                        System.out.println("Mult");
                        test = true;
                        k++;
                    }
                    if (c == '/') {
                        if (line.charAt(++k) == '/') {
                            test = true;
                            while (k <= length - 1) {
                                // System.out.println("*");
                                k++;
                            }
                            continue;
                        } else if (line.charAt(k) == '*') {
                            k++;
                            isZhushi = true;
                            test = true;
                            while (k < length - 1) {
                                if (line.charAt(k) == '*') {
                                    if (k < length - 1) {
                                        if (line.charAt(++k) == '/') {
                                            isZhushi = false;
                                            k = k + 1;
                                            // System.out.println("k = " + k + " " + line.charAt(k));
                                            break;
                                        }
                                    }
                                }
                                k++;
                            }
                            continue;
                        } else if (!isZhushi) {
                            // System.out.println("Div " + k + " " + line.charAt(k));
                            test = true;
                            k++;
                        }
                    }
                    if (c == '<') {
                        System.out.println("Lt");
                        test = true;
                        k++;
                    }
                    if (c == '>') {
                        System.out.println("Gt");
                        test = true;
                        k++;
                    }
                    if (judge.indexOf(c) != -1) {
                        if (judgeDight.indexOf(c) != -1) {
                            test = true;
                            int m = 0;
                            String tempDight = "";
                            while (judgeDight.indexOf(c) != -1) {
                                // System.out.print(c);
                                tempDight = tempDight + c;
                                k++;
                                if (k == length) {
                                    // System.out.println("Number" + "(" + tempDight + ")");
                                    words.add("!number " + tempDight);
                                    break;
                                }
                                c = line.charAt(k);
                                if (judgeDight.indexOf(c) == -1 && (c == '=' || c == '+' || c == '*' || c == '/' || c == ')' || c == '}' || c == ';' || c == ' ' || c == '\t' || c == '\n')) {
                                    // System.out.println("Number" + "(" + tempDight + ")");
                                    words.add("!number " + tempDight);
                                    break;
                                } else if (judgeDight.indexOf(c) == -1) {
//                                    System.out.println("Err");
//                                    System.out.println("result1: c = " + c);
                                    // System.out.println("Number" + "(" + tempDight + ")");
                                    words.add("!number " + tempDight);
                                }
                            }
                        }
                        if (judgeLetter.indexOf(c) != -1 && !test) {
                            String temp_words = "";
                            test = true;
                            // System.out.print("Ident(" + c);
                            temp_words += c;
                            k++;
                            if (k == length) {
                                words.add(temp_words);
                                // System.out.println(")");
                                break;
                            }
                            c = line.charAt(k);
                            while (judge.indexOf(c) != -1) {
                                temp_words += c;
                                // System.out.print(c);
                                k++;
                                if (k == length) {
                                    break;
                                }
                                c = line.charAt(k);
                            }
                            words.add(temp_words);
                            // System.out.println(")");
                        }
                    }
                    if (c == ' ') {
                        test = true;
                        k++;
                    }
                    if (c == '\t') {
                        test = true;
//                        System.out.println("ttt");
                        k++;
                    }
                    if (c == '\n') {
                        test = true;
//                        System.out.println("nnn");
//                        words.add("\n");
                        k++;
                    }
                    if (!test) {
                        System.out.println("Err");
                        System.out.println("result" + k + ": c = " + c);
                        return 0;
                    }
                }
            }
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.setOut(new PrintStream(new BufferedOutputStream(
                    new FileOutputStream(OutputPath)), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //加一个true相当于flush
        // System.out.println("bbb");
//        for (int i = 0; i <= words.size() - 1; i++) {
//            System.out.println("The " + (i + 1) + " word is " + words.get(i));
//        }
        if (words.size() != 9) {
            // System.out.println(2);
            return 2;
        }
        ArrayList<String> result = new ArrayList<>(10);
        boolean isTrue = true;
        for (int i = 0; i <= words.size() - 1; i++) {
            if (i == 0) {
                if (words.get(0).equals("int")) {
                    // System.out.print("define dso_local i32 ");
                    result.add("define dso_local i32 ");
                } else {
                    isTrue = false;
                    // System.out.println("Err 1");
                    break;
                }
            }
            if (i == 1) {
                if (words.get(1).equals("main")) {
                    // System.out.print("@main");
                    result.add("@main");
                } else {
                    isTrue = false;
                    // System.out.println("Err 2");
                    break;
                }
            }
            if (i == 2) {
                if (i + 1 == words.size()) {
                    isTrue = false;
                    // System.out.println("Err 3");
                    break;
                }
                if (words.get(2).equals("(") && words.get(3).equals(")")) {
                    // System.out.print("()");
                    result.add("()");
                    i++;
                } else {
                    isTrue = false;
                    // System.out.println("Err 4");
                }
            }
            if (i == 4) {
                if (words.get(i).equals("{")) {
                    // System.out.println("{");
                    result.add("{");
                    result.add("\n");
                    result.add("\t");
                }
            }
            if (i == 5) {
                if (words.get(5).equals("return")) {
                    // System.out.print("ret i32 ");
                    result.add("ret i32 ");
                } else {
                    isTrue = false;
                    // System.out.println("Err 5");
                    break;
                }
            }
            if (i == 6) {
                if (words.get(6).contains("!number")) {
                    // System.out.print(words.get(6).split(" ")[1]);
                    result.add(words.get(6).split(" ")[1]);
                } else {
                    isTrue = false;
                    // System.out.println("Err 6");
                    break;
                }
            }
            if (i == 7) {
                if (words.get(7).equals(";")) {
                    // System.out.println();
                    result.add("\n");
                } else {
                    isTrue = false;
                    // System.out.println("Err 7");
                }
            }
            if (i == 8) {
                if (words.get(8).equals("}")) {
                    // System.out.print("}");
                    result.add("}");
                } else {
                    isTrue = false;
                    // System.out.println("Err 8");
                }
            }
        }
        if (isTrue == false) {
            // System.out.println(2);
            return 2;
        }
        for (int i = 0; i <= result.size() - 1; i++) {
            System.out.print(result.get(i));
        }

        return 0;
    }


}

