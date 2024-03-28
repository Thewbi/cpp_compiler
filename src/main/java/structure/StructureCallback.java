package structure;

import java.util.List;

import types.FuncDecl;
import types.Type;

public interface StructureCallback {
    
    void startScope();

    void endScope();

    void functionDeclaration(FuncDecl funcDecl);

    void functionCall(String name, FuncDecl funcDecl);

    void variableDeclaration(String name, Type type);

    void variableAssignment(String name);

    void returnStatement();

    void addExpression();
    
    void multExpression();

    void intLiteral(Integer value);

    void stringLiteral(String value);

    void charLiteral(String value);

    void floatLiteral(Float value);

    void plus();

    void minus();

    void mult();

    void divisor();

    List<Expression> getExpressions();

    void ascendExpression();

}
