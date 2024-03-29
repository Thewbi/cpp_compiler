package grammar;

import org.antlr.runtime.BitSet;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class SyntaxErrorListener extends BaseErrorListener {

    private int syntaxErrorCount;

    private int ambiguityCount;

    private int attemptingFullContextCount;

    private int contextSensitivityCount;

    public int getErrorCount() {
        return syntaxErrorCount + ambiguityCount + attemptingFullContextCount + contextSensitivityCount;
    }

    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        System.out.println("syntaxError()");
        syntaxErrorCount++;
    }

    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
            BitSet ambigAlts, ATNConfigSet configs) {
        System.out.println("reportAmbiguity()");
        ambiguityCount++;
    }

    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
            BitSet conflictingAlts, ATNConfigSet configs) {
        System.out.println("reportAttemptingFullContext()");
        attemptingFullContextCount++;
    }

    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
            ATNConfigSet configs) {
        System.out.println("reportContextSensitivity()");
        contextSensitivityCount++;
    }

}
