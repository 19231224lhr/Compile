import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Start!");
        // BailErrorStrategy bailErrorStrategy = new BailErrorStrategy();
        String filePath = args[0];
        String OutputPath = args[1];
        File file = new File(filePath);
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(
                    new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(read);
        String input_1 = null;
        StringBuilder input = new StringBuilder();
        while (true) {
            try {
                if ((input_1 = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            input.append(input_1 + "\n");
            // System.out.println(input_1);
        }
        System.out.println(input);
        try {
            System.setOut(new PrintStream(new BufferedOutputStream(
                    new FileOutputStream(OutputPath)), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

//        String input = "// sample:input n number, sort them and print them;\n" +
//                "int main() {\n" +
//                "\tint n;\n" +
//                "    int a0;\n" +
//                "    int a1;\n" +
//                "    int a2;\n" +
//                "    int a3;\n" +
//                "    int a4;\n" +
//                "    int a5;\n" +
//                "    int a6;\n" +
//                "    int a7;\n" +
//                "    int a8;\n" +
//                "    int a9;\n" +
//                "    int a10;\n" +
//                "    int a11;\n" +
//                "    int a12;\n" +
//                "    int a13;\n" +
//                "    int a14;\n" +
//                "    int a15;\n" +
//                "    int a16;\n" +
//                "    int a17;\n" +
//                "    int a18;\n" +
//                "    int a19;\n" +
//                "    int a20;\n" +
//                "    int a21;\n" +
//                "    int a22;\n" +
//                "    int a23;\n" +
//                "    int a24;\n" +
//                "    int a25;\n" +
//                "    int a26;\n" +
//                "    int a27;\n" +
//                "    int a28;\n" +
//                "    int a29;\n" +
//                "    int b;\n" +
//                "    b = getint();\n" +
//                "    b = b + 1;\n" +
//                "    a0  = 0;\n" +
//                "    a1  = a0 + 1;\n" +
//                "    a2  = a1 + 1;\n" +
//                "    a3  = a2 + 1;\n" +
//                "    a4  = a3 + 1;\n" +
//                "    a5  = a4 + 1;\n" +
//                "    a6  = a5 + 1;\n" +
//                "    a7  = a6 + 1;\n" +
//                "    a8  = a7 + 1;\n" +
//                "    a9  = a8 + 1;\n" +
//                "    a10 = a9 + 1;\n" +
//                "    a11 = a10 + 1;\n" +
//                "    a12 = a11 + 1;\n" +
//                "    a13 = a12 + 1;\n" +
//                "    a14 = a13 + 1;\n" +
//                "    a15 = a14 + 1;\n" +
//                "    a16 = a15 + 1;\n" +
//                "    a17 = a16 + 1;\n" +
//                "    a18 = a17 + 1;\n" +
//                "    a19 = a18 + 1;\n" +
//                "    a20 = a19 + 1;\n" +
//                "    a21 = a20 + 1;\n" +
//                "    a22 = a21 + 1;\n" +
//                "    a23 = a22 + 1;\n" +
//                "    a24 = a23 + 1;\n" +
//                "    a25 = a24 + 1;\n" +
//                "    a26 = a25 + 1;\n" +
//                "    a27 = a26 + 1;\n" +
//                "    a28 = a27 + 1;\n" +
//                "    a29 = a28 + 1;\n" +
//                "    int t;\n" +
//                "    putint(a0);\n" +
//                "    putint(a1);\n" +
//                "    putint(a2);\n" +
//                "    putint(a3);\n" +
//                "    putint(a4);\n" +
//                "    putint(a5);\n" +
//                "    putint(a6);\n" +
//                "    putint(a7);\n" +
//                "    putint(a8);\n" +
//                "    putint(a9);\n" +
//                "    putint(a10);\n" +
//                "    putint(a11);\n" +
//                "    putint(a12);\n" +
//                "    putint(a13);\n" +
//                "    putint(a14);\n" +
//                "    putint(a15);\n" +
//                "    putint(a16);\n" +
//                "    putint(a17);\n" +
//                "    putint(a18);\n" +
//                "    putint(a19);\n" +
//                "    putint(a20);\n" +
//                "    putint(a21);\n" +
//                "    putint(a22);\n" +
//                "    putint(a23);\n" +
//                "    putint(a24);\n" +
//                "    putint(a25);\n" +
//                "    putint(a26);\n" +
//                "    putint(a27);\n" +
//                "    putint(a28);\n" +
//                "    putint(a29);\n" +
//                "    int newline;\n" +
//                "    newline = 10;\n" +
//                "    putch(newline);\n" +
//                "    putint(b);\n" +
//                "    putch(newline);\n" +
//                "    putint(a25);\n" +
//                "    return 0;\n" +
//                "}\n";
        CharStream inputStream = CharStreams.fromString(input.toString());
        lab3Lexer lexer = new lab3Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lab3Parser parser = new lab3Parser(tokenStream);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.compunit();
//        Visitor visitor = new Visitor();
//        visitor.visit(tree);
        lab3Vistor visitor = new lab3Vistor();
        visitor.visit(tree);
        ArrayList<String> Result = new ArrayList<>();
        Result = visitor.getResult();
        for (int i = 0;i < Result.size();i++) {
            System.out.print(Result.get(i));
        }
        // System.out.println(tree.toStringTree(parser));
        // System.out.println("End!");
    }
}
