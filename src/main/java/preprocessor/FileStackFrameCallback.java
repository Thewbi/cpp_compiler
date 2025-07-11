package preprocessor;

import ast.ASTNode;

public interface FileStackFrameCallback {

    void execute(ASTNode rootNode);

}
