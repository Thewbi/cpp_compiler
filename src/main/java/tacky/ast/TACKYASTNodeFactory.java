package tacky.ast;

import ast.ASTNodeType;
import grammar.PutintASTNode;

public class TACKYASTNodeFactory {

    public ProgramASTNode createProgramASTNode() {
        ProgramASTNode node = new ProgramASTNode();
        node.nodeType = NodeType.Program;
        node.astNodeType = ASTNodeType.PROGRAM;
        return node;
    }

    public FunctionDefinitionASTNode createFunctionDefinitionASTNode() {
        FunctionDefinitionASTNode node = new FunctionDefinitionASTNode();
        node.nodeType = NodeType.FunctionDefinition;
        node.astNodeType = ASTNodeType.FUNCTION_DEFINITION;
        return node;
    }

    public VariableDeclarationASTNode createVariableDeclarationASTNode() {
        VariableDeclarationASTNode node = new VariableDeclarationASTNode();
        node.nodeType = NodeType.VariableDeclaration;
        node.astNodeType = ASTNodeType.VARIABLE_DECLARATION;
        return node;
    }

    public ConstantDeclarationASTNode createConstantDeclarationASTNode() {
        ConstantDeclarationASTNode node = new ConstantDeclarationASTNode();
        node.nodeType = NodeType.ConstantDeclaration;
        node.astNodeType = ASTNodeType.CONSTANT_DECLARATION;
        return node;
    }

    public AssignmentASTNode createAssignmentASTNode() {
        AssignmentASTNode node = new AssignmentASTNode();
        node.nodeType = NodeType.Assignment;
        node.astNodeType = ASTNodeType.ASSIGNMENT;
        return node;
    }

    public LabelASTNode createLabelASTNode() {
        LabelASTNode node = new LabelASTNode();
        node.nodeType = NodeType.Label;
        node.astNodeType = ASTNodeType.LABEL;
        return node;
    }

    public JumpASTNode createJumpASTNode() {
        JumpASTNode node = new JumpASTNode();
        node.nodeType = NodeType.Jump;
        node.astNodeType = ASTNodeType.JUMP_STATEMENT;
        return node;
    }

    public ReturnASTNode createReturnASTNode() {
        ReturnASTNode node = new ReturnASTNode();
        node.nodeType = NodeType.Return;
        node.astNodeType = ASTNodeType.RETURN;
        return node;
    }

    public GetAddressASTNode createGetAddressASTNode() {
        GetAddressASTNode node = new GetAddressASTNode();
        node.nodeType = NodeType.GetAddress;
        node.astNodeType = ASTNodeType.GET_ADDRESS;
        return node;
    }

    public LoadFromAddressASTNode createLoadFromAddressASTNode() {
        LoadFromAddressASTNode node = new LoadFromAddressASTNode();
        node.nodeType = NodeType.LoadFromAddress;
        node.astNodeType = ASTNodeType.LOAD_FROM_ADDRESS;
        return node;
    }

    public StoreToAddressASTNode createStoreToAddressASTNode() {
        StoreToAddressASTNode node = new StoreToAddressASTNode();
        node.nodeType = NodeType.StoreToAddress;
        node.astNodeType = ASTNodeType.STORE_TO_ADDRESS;
        return node;
    }

    public FunctionCallASTNode createFunctionCallASTNode() {
        FunctionCallASTNode node = new FunctionCallASTNode();
        node.nodeType = NodeType.FunctionCall;
        node.astNodeType = ASTNodeType.FUNCTION_CALL;
        return node;
    }

    public ValueASTNode createValueASTNode() {
        ValueASTNode node = new ValueASTNode();
        node.nodeType = NodeType.Value;
        node.astNodeType = ASTNodeType.VALUE;
        return node;
    }

    public DataType createDataTypeASTNode() {
        DataType node = new DataType();
        node.nodeType = NodeType.DataType;
        node.astNodeType = ASTNodeType.DATA_TYPE;
        return node;
    }

    public PrintfASTNode createPrintfASTNode() {
        PrintfASTNode node = new PrintfASTNode();
        node.nodeType = NodeType.Printf;
        node.astNodeType = ASTNodeType.PRINTF;
        return node;
    }

    public ExitASTNode createExitASTNode() {
        ExitASTNode node = new ExitASTNode();
        node.nodeType = NodeType.Exit;
        node.astNodeType = ASTNodeType.EXIT;
        return node;
    }

    public SizeofASTNode createSizeofASTNode() {
        SizeofASTNode node = new SizeofASTNode();
        node.nodeType = NodeType.Sizeof;
        node.astNodeType = ASTNodeType.SIZEOF;
        return node;
    }

    public PutintASTNode createPutintASTNode() {
        PutintASTNode node = new PutintASTNode();
        node.nodeType = NodeType.Putint;
        node.astNodeType = ASTNodeType.PUTINT;
        return node;
    }

    public AsmStatementASTNode createAsmStatementASTNode() {
        AsmStatementASTNode node = new AsmStatementASTNode();
        node.nodeType = NodeType.AsmStatement;
        node.astNodeType = ASTNodeType.ASM_STATEMENT;
        return node;
    }

}
