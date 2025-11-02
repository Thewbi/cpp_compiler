package tacky.runtime;

import ast.ASTNode;
import tacky.ast.FunctionDefinitionASTNode;

public interface TACKYExecutor {

    int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
            FunctionDefinitionASTNode functionDefinition);

}
