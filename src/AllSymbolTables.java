import java.util.ArrayList;

public class AllSymbolTables {
    public SymbolTable symbolTable; // 局部符号表
    public int TableLabel;  // 符号表序号

    public static ArrayList<AllSymbolTables> allSymbolTables = new ArrayList<>();   // 全部符号表

    public AllSymbolTables(SymbolTable symbolTable, int tableLabel) {
        this.symbolTable = symbolTable;
        TableLabel = tableLabel;
    }
}
