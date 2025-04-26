package tacky.runtime;

import ast.ASTNode;
import tacky.ast.FunctionDefinitionASTNode;

public interface TACKYExecutor {

    void executeFunction(ASTNode rootNode, int currentIndex, FunctionDefinitionASTNode functionDefinition);

}
