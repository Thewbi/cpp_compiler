package tacky.ast;

public class TACKYASTNodeFactory {

    public ProgramASTNode createProgramASTNode() {
        ProgramASTNode node = new ProgramASTNode();
        node.nodeType = NodeType.Program;
        return node;
    }

    public FunctionDefinitionASTNode createFunctionDefinitionASTNode() {
        FunctionDefinitionASTNode node = new FunctionDefinitionASTNode();
        node.nodeType = NodeType.FunctionDefinition;
        return node;
    }

    public VariableDeclarationASTNode createVariableDeclarationASTNode() {
        VariableDeclarationASTNode node = new VariableDeclarationASTNode();
        node.nodeType = NodeType.VariableDeclaration;
        return node;
    }

    public ConstantDeclarationASTNode createConstantDeclarationASTNode() {
        ConstantDeclarationASTNode node = new ConstantDeclarationASTNode();
        node.nodeType = NodeType.ConstantDeclaration;
        return node;
    }

    public AssignmentASTNode createAssignmentASTNode() {
        AssignmentASTNode node = new AssignmentASTNode();
        node.nodeType = NodeType.Assignment;
        return node;
    }

    public PrintfASTNode createPrintfASTNode() {
        PrintfASTNode node = new PrintfASTNode();
        node.nodeType = NodeType.Printf;
        return node;
    }

    public LabelASTNode createLabelASTNode() {
        LabelASTNode node = new LabelASTNode();
        node.nodeType = NodeType.Label;
        return node;
    }

    public JumpASTNode createJumpASTNode() {
        JumpASTNode node = new JumpASTNode();
        node.nodeType = NodeType.Jump;
        return node;
    }

    public ReturnASTNode createReturnASTNode() {
        ReturnASTNode node = new ReturnASTNode();
        node.nodeType = NodeType.Return;
        return node;
    }

}
