package main;

import java.util.Stack;

import org.antlr.v4.runtime.Token;

import ast.ASTNode;

public interface ExpressionBuilder {

    boolean addToken(Token token, Token lookAheadToken);

    Stack<ASTNode> getStack();

}
