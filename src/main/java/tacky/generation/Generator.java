package tacky.generation;

import ast.ASTNode;

public interface Generator {

    void start();

    // /**
    //  * 
    //  * @param tackyStackFrame
    //  * @param rootNode
    //  * @param currentIndex When removing this stack frame from the stack, continue executing at this index
    //  * @param functionDefinition
    //  */
    // // int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
    // //         FunctionDefinitionASTNode functionDefinition);
    // void executeFunction(ASTNode functionAstNode);

    void execute(ASTNode astNode);

    void end();

}
