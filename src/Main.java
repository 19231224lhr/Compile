import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
         // System.out.println("Start!");
        // BailErrorStrategy bailErrorStrategy = new BailErrorStrategy();
//        String filePath = args[0];
//        String OutputPath = args[1];
//        File file = new File(filePath);
//        InputStreamReader read = null;
//        try {
//            read = new InputStreamReader(
//                    new FileInputStream(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader bufferedReader = new BufferedReader(read);
//        String input_1 = null;
//        StringBuilder input = new StringBuilder();
//        while (true) {
//            try {
//                if ((input_1 = bufferedReader.readLine()) == null) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            input.append(input_1 + "\n");
//            // System.out.println(input_1);
//        }
//        System.out.println(input);
//        try {
//            System.setOut(new PrintStream(new BufferedOutputStream(
//                    new FileOutputStream(OutputPath)), true));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        }

        String input = "int main() {\n" +
                "    return -+(+-((-+(-+(1)))));\n" +
                "}";
        CharStream inputStream = CharStreams.fromString(input.toString());
        testLexer lexer = new testLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        testParser parser = new testParser(tokenStream);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.compunit();
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        // System.out.println(tree.toStringTree(parser));
        // System.out.println("End!");
    }
}
