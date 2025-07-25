package main;

import org.antlr.v4.runtime.Token;

public interface ExpressionBuilder {

    boolean addToken(Token token, Token lookAheadToken);

}
