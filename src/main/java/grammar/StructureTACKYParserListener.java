package grammar;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.cpp.grammar.TACKYParser;
import com.cpp.grammar.TACKYParser.Arg_listContext;
import com.cpp.grammar.TACKYParser.ConstContext;
import com.cpp.grammar.TACKYParser.Constant_declContext;
import com.cpp.grammar.TACKYParser.ValContext;
import com.cpp.grammar.TACKYParserBaseListener;

import ast.ASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import common.StringUtil;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.FunctionCallASTNode;
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
import tacky.ast.ValueASTNode;
import tacky.ast.VariableDeclarationASTNode;
import types.FormalParameter;

public class StructureTACKYParserListener extends TACKYParserBaseListener {

    public ASTNode currentNode;

    public ASTNode constVal;

    public TACKYASTNodeFactory tackyASTNodeFactory = new TACKYASTNodeFactory();

    public Map<String, FunctionDefinitionASTNode> functionDefinitionMap = new HashMap<>();

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

        // name
        String wrappedName = ctx.getChild(2).getText();
        String unwrappedName = StringUtil.unwrap(wrappedName);
        functionDefinitionASTNode.value = unwrappedName;

        // global flag
        functionDefinitionASTNode.global = Boolean.parseBoolean(ctx.getChild(4).getText());

        // formal parameters are collected in param_list handler

        addFunctionDefinition(unwrappedName, functionDefinitionASTNode);

        connectToParent(currentNode, functionDefinitionASTNode);

        descend(functionDefinitionASTNode);
    }

    private void addFunctionDefinition(String name, FunctionDefinitionASTNode functionDefinitionASTNode) {
        if (functionDefinitionMap.containsKey(name)) {
            throw new RuntimeException("FunctionDefinition \"" + name + "\" already contained!");
        }
        functionDefinitionMap.put(name, functionDefinitionASTNode);
    }

    @Override
    public void exitFunction_definition(TACKYParser.Function_definitionContext ctx) {
        ascend();
    }

    @Override
    public void enterParam_list(TACKYParser.Param_listContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        FormalParameter formalParameter = new FormalParameter();
        formalParameter.setName(ctx.Identifier().getText());

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;
        functionDefinitionASTNode.formalParameters.add(formalParameter);
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
        
        String variableName = ctx.getChild(2).getText();
        String ptrVariableName = ctx.getChild(4).getText();

        GetAddressASTNode getAddressASTNode = tackyASTNodeFactory.createGetAddressASTNode();
        getAddressASTNode.variableName = variableName;
        getAddressASTNode.ptrVariableName = ptrVariableName;

        connectToParent(currentNode, getAddressASTNode);
        descend(getAddressASTNode);
    }

    @Override
    public void exitGet_address(TACKYParser.Get_addressContext ctx) {
        ascend();
    }

    @Override
    public void enterLoad(TACKYParser.LoadContext ctx) {

        String ptrVariableName = ctx.getChild(2).getText();
        String variableName = ctx.getChild(4).getText();

        LoadFromAddressASTNode loadFromAddressASTNode = tackyASTNodeFactory.createLoadFromAddressASTNode();
        loadFromAddressASTNode.ptrVariableName = ptrVariableName;
        loadFromAddressASTNode.variableName = variableName;

        connectToParent(currentNode, loadFromAddressASTNode);
        descend(loadFromAddressASTNode);
    }

    @Override
    public void exitLoad(TACKYParser.LoadContext ctx) {
        ascend();
    }

    //
    // Constant Declaration
    //

    /**
     * e.g. ConstInt(0)
     */
    @Override
    public void exitConst(TACKYParser.ConstContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        constVal = new ConstIntASTNode();
        constVal.value = ctx.getChild(2).getText();

        connectToParent(currentNode, constVal);
    }

    @Override
    public void enterConstant_decl(TACKYParser.Constant_declContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // create a VariableDeclarationASTNode
        ConstantDeclarationASTNode constantDeclarationASTNode = tackyASTNodeFactory.createConstantDeclarationASTNode();

        connectToParent(currentNode, constantDeclarationASTNode);

        descend(constantDeclarationASTNode);
    }

    @Override
    public void exitConstant_decl(TACKYParser.Constant_declContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        ascend();

        if (currentNode instanceof ExpressionASTNode) {
            ((ExpressionASTNode) currentNode).expressionType = ExpressionType.Constant;
        }
    }

    @Override
    public void enterAssignment_statement(TACKYParser.Assignment_statementContext ctx) {

        AssignmentASTNode assignmentASTNode = tackyASTNodeFactory.createAssignmentASTNode();

        connectToParent(currentNode, assignmentASTNode);
        descend(assignmentASTNode);
    }

    @Override
    public void exitAssignment_statement(TACKYParser.Assignment_statementContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        AssignmentASTNode assignmentASTNode = (AssignmentASTNode) currentNode;

        assignmentASTNode.lhs = ctx.getChild(0).getText();
        assignmentASTNode.expression = (ExpressionASTNode) assignmentASTNode.children.get(0);

        ascend();
    }

    //
    // printf()
    //

    @Override
    public void enterPrintf_call(TACKYParser.Printf_callContext ctx) {

        PrintfASTNode printfASTNode = tackyASTNodeFactory.createPrintfASTNode();
        printfASTNode.value = ctx.getChild(2).getText();

        // connect parent and child
        connectToParent(currentNode, printfASTNode);

        // descend
        descend(printfASTNode);
    }

    @Override
    public void exitPrintf_call(TACKYParser.Printf_callContext ctx) {
        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // PrintfASTNode printfASTNode = tackyASTNodeFactory.createPrintfASTNode();
        // printfASTNode.value = ctx.getChild(2).getText();

        // currentNode.children.add(printfASTNode);

        ascend();
    }

    //
    // Function Call
    //

    @Override
    public void enterFunction_call(TACKYParser.Function_callContext ctx) {
        
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        FunctionCallASTNode functionCallASTNode = tackyASTNodeFactory.createFunctionCallASTNode();
        functionCallASTNode.value = ctx.Identifier().getText();

        Arg_listContext arg_listContext = ctx.arg_list();

        //
        // actual parameters
        //

        while (arg_listContext.arg_list() != null) {
            // System.out.println(arg_listContext);
            System.out.println(arg_listContext.val().getText());

            ValContext valContext = arg_listContext.val();

            int aval = retrieveConstantValue(valContext);

            functionCallASTNode.actualParameters.add(aval);

            arg_listContext = arg_listContext.arg_list();
        }

        //
        // Return Value Variable
        //

        arg_listContext = ctx.arg_list();

        // try to retrieve the variable that is used as return value
        ValContext val = getLastArgumentListValue(arg_listContext);
        // System.out.println("[" + val.hashCode() + "] " + val.getText());
        functionCallASTNode.returnVariable = val.getText();

        // connect parent and child
        connectToParent(currentNode, functionCallASTNode);

        // descend
        descend(functionCallASTNode);
    }

    @Override
    public void exitFunction_call(TACKYParser.Function_callContext ctx) {
        ascend();
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

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        jumpASTNode.value = ctx.getChild(4).getText();

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);

        // descend
        descend(jumpASTNode);
    }

    @Override
    public void exitJump_if_zero(TACKYParser.Jump_if_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        // jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        // jumpASTNode.variable = ctx.getChild(2).getText();
        // jumpASTNode.value = ctx.getChild(4).getText();

        // FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;

        // functionDefinitionASTNode.children.add(jumpASTNode);

        ascend();
    }

    @Override
    public void enterJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        jumpASTNode.value = ctx.getChild(4).getText();

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);

        // descend
        descend(jumpASTNode);
    }

    @Override
    public void exitJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        // jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        // jumpASTNode.variable = ctx.getChild(2).getText();
        // jumpASTNode.value = ctx.getChild(4).getText();

        // FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode;

        // functionDefinitionASTNode.children.add(jumpASTNode);

        ascend();
    }

    //
    // return
    //

    @Override
    public void enterReturn_statement(TACKYParser.Return_statementContext ctx) {
        ReturnASTNode returnASTNode = tackyASTNodeFactory.createReturnASTNode();

        connectToParent(currentNode, returnASTNode);
        descend(returnASTNode);
    }

    @Override
    public void exitReturn_statement(TACKYParser.Return_statementContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ascend();
    }

    //
    // expressions
    //

    @Override
    public void enterExpr(TACKYParser.ExprContext ctx) {
        System.out.println("ENTER [" + ctx.hashCode() + "] " + ctx.getText());

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;

        if (ctx.children.size() == 1) {

            ParseTree parseTree = ctx.children.get(0);

            if (parseTree instanceof TerminalNodeImpl) {
            
                TerminalNodeImpl terminalNodeImpl = (TerminalNodeImpl) parseTree;
                int type = terminalNodeImpl.getSymbol().getType();
                switch (type) {
                    case TACKYParser.StringLiteral:
                        expressionASTNode.expressionType = ExpressionType.StringLiteral;
                        break;
                    case TACKYParser.Identifier:
                        expressionASTNode.expressionType = ExpressionType.Identifier;
                        break;
                    case TACKYParser.IntegerLiteral:
                        expressionASTNode.expressionType = ExpressionType.IntegerLiteral;
                        break;
                    default:
                        throw new RuntimeException("Unknown type: " + type);
                }

            } 
            else if (parseTree instanceof Constant_declContext) {
                expressionASTNode.expressionType = ExpressionType.Primary;
            }
        } else if (ctx.children.size() == 3) {
            String expressionAsText = ctx.getChild(1).getText();
            expressionASTNode.expressionType = ExpressionType.fromString(expressionAsText);
        } else {
            throw new RuntimeException("Unhandled case!");
        }

        connectToParent(currentNode, expressionASTNode);
        descend(expressionASTNode);
    }

    @Override
    public void exitExpr(TACKYParser.ExprContext ctx) {
        // System.out.println("EXIT [" + ctx.hashCode() + "] " + ctx.getText());

        ExpressionASTNode expressionASTNode = (ExpressionASTNode) currentNode;
        if (ctx.children.size() == 1) {
            expressionASTNode.value = ctx.getText();
        } else if (expressionASTNode.getChildren().size() == 2) {
            expressionASTNode.lhs = (ExpressionASTNode) expressionASTNode.getChildren().get(0);
            expressionASTNode.rhs = (ExpressionASTNode) expressionASTNode.getChildren().get(1);
        }

        ascend();
    }

    @Override
    public void enterVal(ValContext ctx) {
        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // in the return() statement, if a variable name is used instead of a constant
        // this branch stores the variable name into a ValueASTNode
        if (ctx.getChild(0) instanceof TerminalNodeImpl) {
            ValueASTNode valueASTNode = tackyASTNodeFactory.createValueASTNode();
            valueASTNode.value = ctx.getText();
            connectToParent(currentNode, valueASTNode);
        }
    }

    //
    // utility
    //

    /**
     * connect parent and child
     * 
     * @param parent
     * @param child
     */
    private void connectToParent(ASTNode parent, ASTNode child) {
        parent.children.add(child);
        child.parent = parent;
    }

    private void ascend() {
        currentNode = currentNode.parent;
    }

    private void descend(ASTNode astNode) {
        currentNode = astNode;
    }

    private int retrieveConstantValue(ValContext val) {
        
        System.out.println(val.getText());

        ParseTree child = val.getChild(0);
        Constant_declContext constantDecl = (Constant_declContext) child;

        child = constantDecl.getChild(2);
        ConstContext constContext = (ConstContext) child;

        child = constantDecl.getChild(2);
        child = child.getChild(2);

        System.out.println(child.getText());

        return Integer.parseInt(child.getText());
    }

    private ValContext getLastArgumentListValue(Arg_listContext arg_listContext) {
        while (arg_listContext.arg_list() != null) {
            arg_listContext = arg_listContext.arg_list();
        }
        return arg_listContext.val();
    }

}
