import java.util.ArrayList;

public class AllSymbolTables {
    public SymbolTable symbolTable;
    public int TableLabel;
    public String TableFuncName;

    public static ArrayList<AllSymbolTables> allSymbolTables = new ArrayList<>();

    public AllSymbolTables(SymbolTable symbolTable, int tableLabel, String tableFuncName) {
        this.symbolTable = symbolTable;
        TableLabel = tableLabel;
        TableFuncName = tableFuncName;
    }
}
