public class Visitor extends testBaseVisitor<Void> {
    @Override
    public Void visitCompunit(testParser.CompunitContext ctx) {
        return super.visitCompunit(ctx);
    }

    @Override
    public Void visitFuncdef(testParser.FuncdefContext ctx) {
        if (ctx.FUNCTYPE().toString().equals("int")) {
            System.out.print("define dso_local i32 ");
        }
        if (ctx.IDENT().toString().equals("main")) {
            System.out.print("@main");
        }
        // System.out.print(ctx.IDENT());
        System.out.print(ctx.LPar());
        System.out.print(ctx.RPar());
        return super.visitFuncdef(ctx);
    }

    @Override
    public Void visitBlock(testParser.BlockContext ctx) {
        System.out.println(ctx.LBrace());
        visit(ctx.stmt());
        System.out.println("\n" + ctx.RBrace());
        // return super.visitBlock(ctx);
        return null;
    }

    @Override
    public Void visitStmt(testParser.StmtContext ctx) {
        System.out.print("ret i32 ");
        return super.visitStmt(ctx);
    }

    @Override
    public Void visitNumber(testParser.NumberContext ctx) {
        // System.out.print(ctx);
        return super.visitNumber(ctx);
    }

    @Override
    public Void visitDecimalconst(testParser.DecimalconstContext ctx) {
        System.out.print(ctx.Nonzerodigit());
        return super.visitDecimalconst(ctx);
    }

    @Override
    public Void visitOctalconst(testParser.OctalconstContext ctx) {
        System.out.print(Integer.parseInt(ctx.Octaldigit().toString(), 8));
        return super.visitOctalconst(ctx);
    }

    @Override
    public Void visitHexadecimalconst(testParser.HexadecimalconstContext ctx) {
        System.out.print(Integer.parseInt(ctx.Hexadecimalprefix().toString().substring(2),16));
        // System.out.println(Integer.parseInt("0X123".substring(2),16));
        return super.visitHexadecimalconst(ctx);
    }

}
