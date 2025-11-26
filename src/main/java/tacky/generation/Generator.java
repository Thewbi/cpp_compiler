package tacky.generation;

import ast.ASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.runtime.TACKYStackFrame;

public interface Generator {

    /**
     * 
     * @param tackyStackFrame
     * @param rootNode
     * @param currentIndex When removing this stack frame from the stack, continue executing at this index
     * @param functionDefinition
     * @return
     */
    int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
            FunctionDefinitionASTNode functionDefinition);

}
