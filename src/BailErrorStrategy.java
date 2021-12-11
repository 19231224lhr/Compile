import org.antlr.v4.runtime.*;

public class BailErrorStrategy extends DefaultErrorStrategy {
    /** Instead of recovering from exception e, rethrow it wrapped
     *  in a generic RuntimeException so it is not caught by the
     *  rule function catches.  Exception e is the "cause" of the
     *  RuntimeException.
     */

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        System.out.println("Error test1");
        System.exit(2);
        throw new RuntimeException(e);
    }

    /** Make sure we don't attempt to recover inline; if the parser
     *  successfully recovers, it won't throw an exception.
     */
    @Override
    public Token recoverInline(Parser recognizer)
            throws RecognitionException
    {
        System.out.println("Error test2");
        System.exit(2);

        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    /** Make sure we don't attempt to recover from problems in subrules. */
    @Override
    public void sync(Parser recognizer) {
        // System.out.println("Right!");
    }
}