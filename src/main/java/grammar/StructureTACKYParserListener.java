package grammar;

import com.cpp.grammar.TACKYParser;
import com.cpp.grammar.TACKYParserBaseListener;

import ast.ASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.ProgramASTNode;

public class StructureTACKYParserListener extends TACKYParserBaseListener {

    public ASTNode currentNode;

    @Override
    public void enterProgram(TACKYParser.ProgramContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
    }

    @Override
    public void exitProgram(TACKYParser.ProgramContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ProgramASTNode programASTNode = new ProgramASTNode();
        programASTNode.value = ctx.getChild(2).getText();

        currentNode.children.add(programASTNode);
    }

    @Override
    public void enterFunction_definition(TACKYParser.Function_definitionContext ctx) {
        FunctionDefinitionASTNode functionDefinitionASTNode = new FunctionDefinitionASTNode();
        functionDefinitionASTNode.value = ctx.getChild(2).getText();

        connectToParent(currentNode, functionDefinitionASTNode);

        // descend
        currentNode = functionDefinitionASTNode;
    }

    @Override
    public void exitFunction_definition(TACKYParser.Function_definitionContext ctx) {
        // ascend
        currentNode = currentNode.parent;
    }

    @Override
    public void enterVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {
    }

    @Override
    public void exitVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {
        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        String variableSymbolName = ctx.getChild(0).getText();
        String variableName = ctx.getChild(4).getText();

        System.out.println("variableSymbolName=\"" + variableSymbolName + "\", variableName=\"" + variableName + "\"");

        // TODO: create a VariableDeclarationASTNode
    }

    //
    // utility
    //

    private void connectToParent(ASTNode parent, ASTNode child) {
        // connect parent and child
        parent.children.add(child);
        child.parent = parent;
    }

}
