import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Start!");
        BailErrorStrategy bailErrorStrategy = new BailErrorStrategy();
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

//        String input ="int field[2];\n" +
//                "int main() {\n" +
//                "    int i[1];\n" +
//                "    int j[3];\n" +
//                "    int k;\n" +
//                "\n" +
//                "    field[0] = getint();\n" +
//                "    field[1] = getint();\n" +
//                "\n" +
//                "    j[0 + 0] = -1;\n" +
//                "    j[1]     = j[0] - 2;\n" +
//                "    k        = j[1];\n" +
//                "    j[2]     = 16;\n" +
//                "\n" +
//                "    putint(j[3 - field[0]] + 2 + k);\n" +
//                "\n" +
//                "    return 0;\n" +
//                "}";
        // System.out.println(OperatorPrecedenceParse.getResult(OperatorPrecedenceParse.getPost("0-1+2*4-99/99")));
        CharStream inputStream = CharStreams.fromString(input.toString());
        CompileLexer lexer = new CompileLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CompileParser parser = new CompileParser(tokenStream);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.program();
//        Visitor visitor = new Visitor();
//        visitor.visit(tree);
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        if (!Visitor.isMain) {
            System.out.println("Error:函数没有定义main函数入口");
            System.exit(19);
        }
        System.out.println(Visitor.Result);
        // System.out.println(tree.toStringTree(parser));
        // System.out.println("End!");
    }
}