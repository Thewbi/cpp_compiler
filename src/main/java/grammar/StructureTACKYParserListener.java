package grammar;

import java.util.Stack;

import com.cpp.grammar.TACKYParser;
import com.cpp.grammar.TACKYParserBaseListener;

import ast.ASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import common.StringUtil;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.GetAddressASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.JumpType;
import tacky.ast.LabelASTNode;
import tacky.ast.LoadFromAddressASTNode;
import tacky.ast.PrintfASTNode;
import tacky.ast.ProgramASTNode;
import tacky.ast.ReturnASTNode;
import tacky.ast.TACKYASTNodeFactory;
import tacky.ast.VariableDeclarationASTNode;

public class StructureTACKYParserListener extends TACKYParserBaseListener {

    public ASTNode currentNode;

    public ASTNode constVal;

    public Stack<ExpressionASTNode> expressionStack = new Stack<>();

    public TACKYASTNodeFactory tackyASTNodeFactory = new TACKYASTNodeFactory();

    @Override
    public void enterProgram(TACKYParser.ProgramContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
    }

    @Override
    public void exitProgram(TACKYParser.ProgramContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ProgramASTNode programASTNode = tackyASTNodeFactory.createProgramASTNode();

        String wrappedName = ctx.getChild(2).getText();
        String unwrappedName = StringUtil.unwrap(wrappedName);
        programASTNode.value = unwrappedName;

        currentNode.children.add(programASTNode);
    }

    @Override
    public void enterFunction_definition(TACKYParser.Function_definitionContext ctx) {
        FunctionDefinitionASTNode functionDefinitionASTNode = tackyASTNodeFactory.createFunctionDefinitionASTNode();

        String wrappedName = ctx.getChild(2).getText();
        String unwrappedName = StringUtil.unwrap(wrappedName);
        functionDefinitionASTNode.value = unwrappedName;
        functionDefinitionASTNode.global = Boolean.parseBoolean(ctx.getChild(4).getText());

        connectToParent(currentNode, functionDefinitionASTNode);

        // descend
        currentNode = functionDefinitionASTNode;
    }

    @Override
    public void exitFunction_definition(TACKYParser.Function_definitionContext ctx) {
        // ascend
        currentNode = currentNode.parent;
    }

    //
    // Variable Declaration
    //

    @Override
    public void enterVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {
    }

    @Override
    public void exitVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        String variableSymbolName = ctx.getChild(0).getText();
        String variableName = StringUtil.unwrap(ctx.getChild(4).getText());

        // System.out.println("variableSymbolName=\"" + variableSymbolName + "\",
        // variableName=\"" + variableName + "\"");

        // create a VariableDeclarationASTNode
        VariableDeclarationASTNode variableDeclarationASTNode = tackyASTNodeFactory.createVariableDeclarationASTNode();
        variableDeclarationASTNode.variableSymbolName = variableSymbolName;
        variableDeclarationASTNode.variableName = variableName;

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;

        // add local variables to a special list, because why not! There is no reason.
        // Maybe remove this
        functionDefinitionASTNode.localVariables.add(variableDeclarationASTNode);

        // all statements are inserted into the children list
        functionDefinitionASTNode.children.add(variableDeclarationASTNode);
    }

    //
    // Pointers
    //

    @Override
    public void enterGet_address(TACKYParser.Get_addressContext ctx) {
    }

    @Override
    public void exitGet_address(TACKYParser.Get_addressContext ctx) {

        String variableName = ctx.getChild(2).getText();
        String ptrVariableName = ctx.getChild(4).getText();

        GetAddressASTNode getAddressASTNode = tackyASTNodeFactory.createGetAddressASTNode();
        getAddressASTNode.variableName = variableName;
        getAddressASTNode.ptrVariableName = ptrVariableName;

        currentNode.children.add(getAddressASTNode);
    }

    @Override
    public void enterLoad(TACKYParser.LoadContext ctx) {
    }

    @Override
    public void exitLoad(TACKYParser.LoadContext ctx) {

        String ptrVariableName = ctx.getChild(2).getText();
        String variableName = ctx.getChild(4).getText();

        LoadFromAddressASTNode loadFromAddressASTNode = tackyASTNodeFactory.createLoadFromAddressASTNode();
        loadFromAddressASTNode.ptrVariableName = ptrVariableName;
        loadFromAddressASTNode.variableName = variableName;

        currentNode.children.add(loadFromAddressASTNode);
    }

    //
    // Constant Declaration
    //

    @Override
    public void enterConst(TACKYParser.ConstContext ctx) {
    }

    /**
     * e.g. ConstInt(0)
     */
    @Override
    public void exitConst(TACKYParser.ConstContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        constVal = new ConstIntASTNode();
        constVal.value = ctx.getChild(2).getText();
    }

    @Override
    public void enterConstant_decl(TACKYParser.Constant_declContext ctx) {
    }

    @Override
    public void exitConstant_decl(TACKYParser.Constant_declContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // create a VariableDeclarationASTNode
        ConstantDeclarationASTNode constantDeclarationASTNode = tackyASTNodeFactory.createConstantDeclarationASTNode();
        constantDeclarationASTNode.children.add(constVal);

        currentNode.children.add(constantDeclarationASTNode);
    }

    @Override
    public void enterAssignment_statement(TACKYParser.Assignment_statementContext ctx) {
    }

    @Override
    public void exitAssignment_statement(TACKYParser.Assignment_statementContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        AssignmentASTNode assignmentASTNode = tackyASTNodeFactory.createAssignmentASTNode();
        assignmentASTNode.lhs = ctx.getChild(0).getText();
        assignmentASTNode.expression = expressionStack.pop();

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;
        functionDefinitionASTNode.children.add(assignmentASTNode);
    }

    //
    // printf()
    //

    @Override
    public void enterPrintf_call(TACKYParser.Printf_callContext ctx) {
    }

    @Override
    public void exitPrintf_call(TACKYParser.Printf_callContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        PrintfASTNode printfASTNode = tackyASTNodeFactory.createPrintfASTNode();
        printfASTNode.value = ctx.getChild(2).getText();
        currentNode.children.add(printfASTNode);
    }

    //
    // Function Call
    //

	@Override public void enterFunc_call(TACKYParser.Func_callContext ctx) {
        // TODO: implement function call (with stack frames)
        throw new RuntimeException();
    }

	@Override public void exitFunc_call(TACKYParser.Func_callContext ctx) {
        throw new RuntimeException();
     }

    //
    // Label
    //

    @Override
    public void enterLabel(TACKYParser.LabelContext ctx) {
    }

    @Override
    public void exitLabel(TACKYParser.LabelContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        LabelASTNode labelASTNode = tackyASTNodeFactory.createLabelASTNode();
        labelASTNode.value = ctx.getChild(2).getText();
        currentNode.children.add(labelASTNode);
    }

    //
    // Jump
    //

    @Override
    public void enterJump(TACKYParser.JumpContext ctx) {
    }

    @Override
    public void exitJump(TACKYParser.JumpContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        jumpASTNode.value = ctx.getChild(2).getText();

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;
        functionDefinitionASTNode.children.add(jumpASTNode);
    }

    @Override
    public void enterJump_if_zero(TACKYParser.Jump_if_zeroContext ctx) {
    }

    @Override
    public void exitJump_if_zero(TACKYParser.Jump_if_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        jumpASTNode.variable = ctx.getChild(2).getText();
        jumpASTNode.value = ctx.getChild(4).getText();

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;
        functionDefinitionASTNode.children.add(jumpASTNode);
    }

    @Override
    public void enterJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {
    }

    @Override
    public void exitJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        jumpASTNode.variable = ctx.getChild(2).getText();
        jumpASTNode.value = ctx.getChild(4).getText();

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;
        functionDefinitionASTNode.children.add(jumpASTNode);
    }

    //
    // return
    //

    @Override
    public void enterReturn_statement(TACKYParser.Return_statementContext ctx) {

        ReturnASTNode returnASTNode = tackyASTNodeFactory.createReturnASTNode();

        connectToParent(currentNode, returnASTNode);

        // descend
        currentNode = returnASTNode;
    }

    @Override
    public void exitReturn_statement(TACKYParser.Return_statementContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // ascend
        currentNode = currentNode.parent;
    }

    //
    // expressions
    //

    @Override
    public void enterExpr(TACKYParser.ExprContext ctx) {
    }

    @Override
    public void exitExpr(TACKYParser.ExprContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            ExpressionASTNode expressionASTNode = new ExpressionASTNode();
            expressionASTNode.ctx = ctx;
            expressionASTNode.value = ctx.getText();
            expressionASTNode.expressionType = ExpressionType.Primary;
            expressionStackPush(expressionASTNode);

            return;
        }

        if (ctx.children.size() == 3) {

            ExpressionASTNode expressionASTNode = new ExpressionASTNode();
            expressionASTNode.ctx = ctx;
            expressionASTNode.value = ctx.getText();
            expressionASTNode.expressionType = ExpressionType.fromString(ctx.getChild(1).getText());
            expressionASTNode.rhs = expressionStackPop();
            expressionASTNode.lhs = expressionStackPop();
            expressionStackPush(expressionASTNode);

            return;
        }

        throw new RuntimeException("Unhandled case!");
    }

    //
    // utility
    //

    private void connectToParent(ASTNode parent, ASTNode child) {
        // connect parent and child
        parent.children.add(child);
        child.parent = parent;
    }

    private ExpressionASTNode expressionStackPop() {
        return expressionStack.pop();
    }

    private void expressionStackPush(ExpressionASTNode expressionASTNode) {
        expressionStack.push(expressionASTNode);
    }

}
