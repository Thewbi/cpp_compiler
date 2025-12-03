package grammar;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.cpp.grammar.TACKYParser;
import com.cpp.grammar.TACKYParser.Arg_listContext;
import com.cpp.grammar.TACKYParser.Array_typeContext;
import com.cpp.grammar.TACKYParser.ConstContext;
import com.cpp.grammar.TACKYParser.Constant_declContext;
import com.cpp.grammar.TACKYParser.ValContext;
import com.cpp.grammar.TACKYParserBaseListener;

import ast.ASTNode;
import ast.ASTNodeType;
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
import tacky.ast.SizeofASTNode;
import tacky.ast.StoreToAddressASTNode;
import tacky.ast.TACKYASTNodeFactory;
import tacky.ast.ValueASTNode;
import tacky.ast.VariableDeclarationASTNode;
import tacky.generation.tacky.TackyDataType;
import tacky.ast.DataType;
import tacky.ast.ExitASTNode;
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

    // Variable Declaration

    @Override
    public void enterVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {

        // create a VariableDeclarationASTNode
        VariableDeclarationASTNode variableDeclarationASTNode = tackyASTNodeFactory.createVariableDeclarationASTNode();
        variableDeclarationASTNode.astNodeType = ASTNodeType.INIT_DECLARATION;

        connectToParent(currentNode, variableDeclarationASTNode);
        descend(variableDeclarationASTNode);
    }

    @Override
    public void exitVar_declaration_statement(TACKYParser.Var_declaration_statementContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        VariableDeclarationASTNode variableDeclarationASTNode = (VariableDeclarationASTNode) currentNode;

        String variableSymbolName = ctx.getChild(0).getText();
        variableDeclarationASTNode.variableSymbolName = variableSymbolName;
        
        String variableName = StringUtil.unwrap(ctx.getChild(4).getText());
        variableDeclarationASTNode.variableName = variableName;

        // temp_array = Var ( "temp_array" , Array ( int32 , 3 ))

        if (ctx.children.size() > 6) {

            ParseTree parseTree = ctx.getChild(6);
            Array_typeContext array_typeContext = (Array_typeContext) parseTree;
            variableDeclarationASTNode.isArray = true;

            String arraySizeAsString = array_typeContext.IntegerLiteral().getText();
            variableDeclarationASTNode.arraySize = Integer.parseInt(arraySizeAsString);
        }

        // System.out.println("variableSymbolName=\"" + variableSymbolName + "\",
        // variableName=\"" + variableName + "\"");

        FunctionDefinitionASTNode functionDefinitionASTNode = (FunctionDefinitionASTNode) currentNode.parent;

        // add local variables to a special list, because why not! There is no reason.
        // Maybe remove this
        functionDefinitionASTNode.localVariables.add(variableDeclarationASTNode);

        // all statements are inserted into the children list
        // functionDefinitionASTNode.children.add(variableDeclarationASTNode);

        ascend();
    }

    @Override
    public void enterArray_type(TACKYParser.Array_typeContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        DataType dataTypeAstNode = tackyASTNodeFactory.createDataTypeASTNode();
        dataTypeAstNode.isArray = true;
        dataTypeAstNode.typeName = ctx.children.get(2).getText();
        dataTypeAstNode.arraySize = Integer.parseInt(ctx.children.get(4).getText());

        connectToParent(currentNode, dataTypeAstNode);
        descend(dataTypeAstNode);
    }

    @Override
    public void exitArray_type(TACKYParser.Array_typeContext ctx) {
        ascend();
    }

    // Pointers

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

    @Override
    public void enterStore(TACKYParser.StoreContext ctx) {
        String ptrVariableName = ctx.getChild(4).getText();
        String variableName = ctx.getChild(2).getText();

        StoreToAddressASTNode storeToAddressASTNode = tackyASTNodeFactory.createStoreToAddressASTNode();
        storeToAddressASTNode.ptrVariableName = ptrVariableName;
        storeToAddressASTNode.variableName = variableName;

        connectToParent(currentNode, storeToAddressASTNode);
        descend(storeToAddressASTNode);
    }

    @Override
    public void exitStore(TACKYParser.StoreContext ctx) {
        ascend();
    }

    @Override
    public void enterSizeof_call(TACKYParser.Sizeof_callContext ctx) {

        String type = ctx.getChild(2).getText();
        String targetVariableName = ctx.getChild(4).getText();

        SizeofASTNode sizeofASTNode = tackyASTNodeFactory.createSizeofASTNode();
        sizeofASTNode.sizeOfType = type;
        sizeofASTNode.targetVariableName = targetVariableName;

        connectToParent(currentNode, sizeofASTNode);
        descend(sizeofASTNode);
    }

    @Override
    public void exitSizeof_call(TACKYParser.Sizeof_callContext ctx) {
        ascend();
    }

    // Constant Declaration

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

    // printf()

    @Override
    public void enterPrintf_call(TACKYParser.Printf_callContext ctx) {

        PrintfASTNode printfASTNode = tackyASTNodeFactory.createPrintfASTNode();
        printfASTNode.value = ctx.getChild(2).getText();
        printfASTNode.astNodeType = ASTNodeType.FUNCTION_CALL;

        // connect parent and child
        connectToParent(currentNode, printfASTNode);

        // descend
        descend(printfASTNode);
    }

    @Override
    public void exitPrintf_call(TACKYParser.Printf_callContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ascend();
    }

    // exit()

    @Override
    public void enterExit_call(TACKYParser.Exit_callContext ctx) {

        ExitASTNode exitASTNode = tackyASTNodeFactory.createExitASTNode();
        exitASTNode.value = ctx.getChild(2).getText();
        exitASTNode.astNodeType = ASTNodeType.FUNCTION_CALL;

        // connect parent and child
        connectToParent(currentNode, exitASTNode);

        // descend
        descend(exitASTNode);
    }

    @Override
    public void exitExit_call(TACKYParser.Exit_callContext ctx) {
        ascend();
    }

    // Function Call

    @Override
    public void enterFunction_call(TACKYParser.Function_callContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        FunctionCallASTNode functionCallASTNode = tackyASTNodeFactory.createFunctionCallASTNode();
        functionCallASTNode.value = ctx.Identifier().getText();

        Arg_listContext arg_listContext = ctx.arg_list();

        // -- actual parameters --

        while (arg_listContext.arg_list() != null) {

            // DEBUG
            // System.out.println(arg_listContext);
            // System.out.println(arg_listContext.val().getText());

            ValContext valContext = arg_listContext.val();

            ParseTree parseTree = valContext.children.get(0);

            ActualParameter actualParameter = new ActualParameter();

            ResultContainer resultContainer = new ResultContainer();

            if (parseTree instanceof Constant_declContext) {

                retrieveConstantValue(valContext, resultContainer);
                actualParameter.isVariable = false;
                actualParameter.isConstant = true;

                switch (resultContainer.tackyDataType) {

                    case STRING:
                        actualParameter.tackyDataType = TackyDataType.STRING;
                        actualParameter.stringValue = resultContainer.stringValue;
                        break;

                    case INT_32:
                        actualParameter.tackyDataType = TackyDataType.INT_32;
                        actualParameter.intValue = resultContainer.integerValue;
                        break;

                    default:
                        throw new RuntimeException();

                }

            } else if (parseTree instanceof TerminalNodeImpl) {
                String val = parseTree.getText();
                actualParameter.isVariable = true;
                actualParameter.isConstant = false;
                actualParameter.name = val;
            } else {
                throw new RuntimeException("unknown node type");
            }

            functionCallASTNode.actualParameters.add(actualParameter);

            arg_listContext = arg_listContext.arg_list();
        }

        // -- Return Value Variable --

        arg_listContext = ctx.arg_list();

        // try to retrieve the variable that is used as return value
        ValContext val = getLastArgumentListValue(arg_listContext);
        // System.out.println("[" + val.hashCode() + "] " + val.getText());
        functionCallASTNode.returnVariable = val.getText();

        // connect parent and child
        connectToParent(currentNode, functionCallASTNode);

        // descend
        descend(functionCallASTNode);

        // // DEBUG
        // StringBuilder stringBuilder = new StringBuilder();
        // functionCallASTNode.printRecursive(stringBuilder, 0);
        // System.out.println(stringBuilder.toString());
    }

    @Override
    public void exitFunction_call(TACKYParser.Function_callContext ctx) {
        ascend();
    }

    // Label

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

    // Jump

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

        // this is the label to jump to
        jumpASTNode.value = ctx.getChild(4).getText();

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);

        // descend
        descend(jumpASTNode);
    }

    @Override
    public void exitJump_if_zero(TACKYParser.Jump_if_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ascend();
    }

    @Override
    public void enterJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        // this is the label to jump to
        jumpASTNode.value = ctx.getChild(4).getText();

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);

        // descend
        descend(jumpASTNode);
    }

    @Override
    public void exitJump_if_not_zero(TACKYParser.Jump_if_not_zeroContext ctx) {
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());
        ascend();
    }

    @Override
    public void enterJump_greater_than_or_equal(TACKYParser.Jump_greater_than_or_equalContext ctx) {

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());
        
        // this is the label to jump to
        jumpASTNode.value = ctx.getChild(6).getText();

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);

        // descend
        descend(jumpASTNode);
    }

    @Override
    public void exitJump_greater_than_or_equal(TACKYParser.Jump_greater_than_or_equalContext ctx) {
        ascend();
    }

    // break

    @Override
    public void enterBreak(TACKYParser.BreakContext ctx) {

        JumpASTNode jumpASTNode = tackyASTNodeFactory.createJumpASTNode();
        jumpASTNode.jumpType = JumpType.fromString(ctx.getChild(0).getText());

        // connect parent and child
        connectToParent(currentNode, jumpASTNode);
    }

    @Override
    public void exitBreak(TACKYParser.BreakContext ctx) {
    }

    // return

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

    // expressions

    @Override
    public void enterExpr(TACKYParser.ExprContext ctx) {
        // System.out.println("ENTER [" + ctx.hashCode() + "] " + ctx.getText());

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

            } else if (parseTree instanceof Constant_declContext) {
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
        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // in the return() statement, if a variable name is used instead of a constant
        // this branch stores the variable name into a ValueASTNode
        if (ctx.getChild(0) instanceof TerminalNodeImpl) {
            ValueASTNode valueASTNode = tackyASTNodeFactory.createValueASTNode();
            valueASTNode.value = ctx.getText();
            connectToParent(currentNode, valueASTNode);
        }
    }

    // Terminal - all keywords

    // @Override
    // public void visitTerminal(TerminalNode node) {
    // System.out.println(node.getSymbol());
    // }

    // utility

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

    private void retrieveConstantValue(ValContext val, ResultContainer resultContainer) {

        // DEBUG
        // System.out.println(val.getText());

        ParseTree child = val.getChild(0);
        Constant_declContext constantDecl = (Constant_declContext) child;

        // child = constantDecl.getChild(2);
        ConstContext constContext = (ConstContext) constantDecl.getChild(2);

        TerminalNodeImpl constType = (TerminalNodeImpl) constContext.children.get(0);

        // System.out.println(constType.getText());

        String constTypeAsString = constType.getText();

        // DEBUG
        // System.out.println(child.getText());

        // String rawValue = child.getText();

        child = constantDecl.getChild(2);
        child = child.getChild(2);

        if (constTypeAsString.equalsIgnoreCase("ConstInt")) {

            resultContainer.tackyDataType = TackyDataType.INT_32;
            resultContainer.integerValue = Integer.parseInt(child.getText());
            return;

        } else if (constTypeAsString.equalsIgnoreCase("ConstString")) {

            resultContainer.tackyDataType = TackyDataType.STRING;
            resultContainer.stringValue = child.getText();
            return;

        }

        throw new RuntimeException();
    }

    private ValContext getLastArgumentListValue(Arg_listContext arg_listContext) {
        while (arg_listContext.arg_list() != null) {
            arg_listContext = arg_listContext.arg_list();
        }
        return arg_listContext.val();
    }

}
