import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String judge = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        String judgeDight = "0123456789";
        String judgeLetter = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
//        String filePath = scanner.nextLine();
        String filePath = args[0];
//        System.out.println(filePath);
        File file = new File(filePath);
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
                    judge_Letter = false;
                    c = line.charAt(k);
                    if (c == 'i' && k + 1 < length) {
                        // 判断是不是if
                        c = line.charAt(k + 1);
                        if (k + 2 == length) {
                            if (c == 'f') {
                                System.out.println("If");
                                test = true;
                                k = k + 2;
                            }
                        } else if (k + 2 < length) {
                            c1 = line.charAt(k + 2);
                            if (c == 'f' && (c1 == ' ' || c1 == ';') || c1 == '(') {
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
                            if (c1 == 'l' && c2 == 's' && c3 == 'e' && (c4 == ' ' || c4 == ';' || c4 == '{')) {
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
                            if (c1 == 'h' && c2 == 'i' && c3 == 'l' && c4 == 'e' && (c5 == ' ' || c5 == ';' || c5 == '(')) {
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
                            if (c1 == 'r' && c2 == 'e' && c3 == 'a' && c4 == 'k' && (c5 == ' ' || c5 == ';')) {
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
                            if (c1 == 'o' && c2 == 'n' && c3 == 't' && c4 == 'i' && c5 == 'n' && c6 == 'u' && c7 == 'e' && (c8 == ' ' || c8 == ';')) {
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
                                System.out.println("Return");
                                test = true;
                                k = k + 6;
                            }
                        } else if (k + 6 < length) {
                            c6 = line.charAt(k + 6);
                            if (c1 == 'e' && c2 == 't' && c3 == 'u' && c4 == 'r' && c5 == 'n' && (c6 == ' ' || c6 == ';' || c6 == '(' || c6 == '{')) {
                                System.out.println("Return");
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
                        System.out.println("Semicolon");
                        test = true;
                        k++;
                    }
                    if (c == '(') {
                        System.out.println("LPar");
                        test = true;
                        k++;
                    }
                    if (c == ')') {
                        System.out.println("RPar");
                        test = true;
                        k++;
                    }
                    if (c == '{') {
                        System.out.println("LBrace");
                        test = true;
                        k++;
                    }
                    if (c == '}') {
                        System.out.println("RBrace");
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
                        System.out.println("Div");
                        test = true;
                        k++;
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
                                    System.out.println("Number" + "(" + tempDight + ")");
                                    break;
                                }
                                c = line.charAt(k);
                                if (judgeDight.indexOf(c) == -1 && (c == '=' || c == '+' || c == '*' || c == '/' || c == ')' || c == '}' || c == ';' || c == ' ')) {
                                    System.out.println("Number" + "(" + tempDight + ")");
                                    break;
                                } else if (judgeDight.indexOf(c) == -1) {
                                    System.out.println("Err");
                                    return;
                                }
                            }
                        }
                        if (judgeLetter.indexOf(c) != -1 && !test) {
                            test = true;
                            System.out.print("Ident(" + c);
                            k++;
                            c = line.charAt(k);
                            while (judge.indexOf(c) != -1) {
                                System.out.print(c);
                                k++;
                                if (k == length) {
                                    break;
                                }
                                c = line.charAt(k);
                            }
                            System.out.println(")");
                        }
                    }
                    if (c == ' ') {
                        test = true;
                        k++;
                    }
                    if (c == '\t') {
                        test = true;
                        k++;
                    }
                    if (!test) {
                        System.out.println("Err");
                        break;
                    }
                }
            }
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

