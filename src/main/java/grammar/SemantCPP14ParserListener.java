package grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14Parser.DeclSpecifierSeqContext;
import com.cpp.grammar.CPP14Parser.InitDeclaratorContext;
import com.cpp.grammar.CPP14Parser.InitDeclaratorListContext;
import com.cpp.grammar.CPP14ParserBaseListener;

import structure.StructureCallback;
import types.FormalParameter;
import types.FuncDecl;
import types.StackFrame;
import types.Type;

/**
 * This code is bad. I am sorry.
 * The issue is that most elements conway no sematic meaning and almost
 * all the nodes are reused in different contexts multiple times.
 * To parse out any semantic meaning, weird code is necessary.
 */
public class SemantCPP14ParserListener extends CPP14ParserBaseListener {

    /** type name to type */
    private Map<String, Type> typeMap = new HashMap<>();

    /** variable name to type */
    // TODO: the varTypeMap has to go into the execution stack!!!!!!!
    private Map<String, Type> varTypeMap = new HashMap<>();

    private boolean isArray;

    private Type initializerType;

    private List<String> declaratorNames = new ArrayList<>();

    // private SemAntMode semAntMode = SemAntMode.DEFAULT;
    private Stack<SemAntMode> semAntModeStack = new Stack<>();

    private FuncDecl funcDecl;

    private Map<String, FuncDecl> funcDeclMap = new HashMap<>();

    private Stack<String> calledFunctionNameStack = new Stack<>();

    private Stack<StackFrame> executionStack = new Stack<>();

    private StructureCallback structureCallback;

    @Override
    public void enterJumpStatement(CPP14Parser.JumpStatementContext ctx) {

    }

    @Override
    public void exitJumpStatement(CPP14Parser.JumpStatementContext ctx) {
        // System.out.println(ctx.getText());

        TerminalNode returnTerminalNode = ctx.Return();
        if (returnTerminalNode != null) {
            // ExpressionContext expressionContext = ctx.expression();
            // System.out.println(expressionContext.getText());

            structureCallback.returnStatement();
        }
    }

    @Override
    public void enterRelationalExpression(CPP14Parser.RelationalExpressionContext ctx) {
    }

    @Override
    public void exitRelationalExpression(CPP14Parser.RelationalExpressionContext ctx) {

        // System.out.println(ctx.getText());

        if (ctx.getChildCount() == 1) {
            return;
        }

        Stack<Type> localExprTypeStack = executionStack.peek().exprTypeStack;

        Type rhsType = localExprTypeStack.pop();
        Type lhsType = localExprTypeStack.pop();

        performTypeCheck(lhsType, rhsType, "[ERROR: relational expression: Parameter types do not match!", ctx);

        executionStack.peek().exprTypeStack.push(typeMap.get("bool"));
    }

    @Override
    public void enterExpressionList(CPP14Parser.ExpressionListContext ctx) {
    }

    @Override
    public void exitExpressionList(CPP14Parser.ExpressionListContext ctx) {

        if (calledFunctionNameStack.isEmpty()) {
            return;
        }

        String calledFunctionName = calledFunctionNameStack.pop();

        // System.out.println("FUNCTION_CALL_WITH_PARAMETERS: " + calledFunctionName);

        FuncDecl funcDecl = funcDeclMap.get(calledFunctionName);

        processFunctionCallExit(ctx, calledFunctionName, funcDecl);

        // setSemAntMode(SemAntMode.DEFAULT);
        // semAntModeStack.pop();

        // System.out.println("");
    }

    private void processFunctionCallExit(ParserRuleContext ctx, String calledFunctionName, FuncDecl funcDecl) {

        // verify that the parameter count between formal and actual parameters matches
        int returnValueIsOnStackToo = 1;
        if (funcDecl.getParams().size() != (executionStack.peek().exprTypeStack.size() - returnValueIsOnStackToo)) {
            throw new RuntimeException(
                    "[ERROR: Bonked! Actual parameter count does not match formal parameter count! (Line \""
                            + ctx.getStart().getLine() + "\")]");
        }

        // iterate in reverse, check each type
        ListIterator<FormalParameter> literator = funcDecl.getParams().listIterator(funcDecl.getParams().size());
        while (literator.hasPrevious()) {

            // System.out.println(li.previous());

            Type actualParameterType = executionStack.peek().exprTypeStack.pop();

            FormalParameter formalParameter = (FormalParameter) literator.previous();
            // System.out.println(formalParameter);

            performTypeCheck(formalParameter.getType(), actualParameterType, "[ERROR: function call of function: \""
                    + calledFunctionName + "\"(). Actual parameter type does not match!", ctx);
        }

        // last value on the stack is the return type of the function
        // store it into initializerType so that the declaration can perform type check
        // between the function value and the assigned variable
        initializerType = executionStack.peek().exprTypeStack.peek();

        // System.out.println("FUNCTION_CALL exit detected");

        // the return type of the the called function goes onto the exprTypeStack of
        // the lower stackFrame
        Type returnValue = executionStack.peek().exprTypeStack.pop();
        executionStack.pop();
        executionStack.peek().exprTypeStack.push(returnValue);

        // STRUCTURE CALLBACK
        structureCallback.functionCall(funcDecl.getName(), funcDecl);

        // STRUCTURE CALLBACK
        structureCallback.endScope();
        // structureCallback.getExpressions().clear();
    }

    @Override
    public void enterStatement(CPP14Parser.StatementContext ctx) {
        // setSemAntMode(SemAntMode.STATEMENT);
        semAntModeStack.push(SemAntMode.STATEMENT);
    }

    @Override
    public void exitStatement(CPP14Parser.StatementContext ctx) {
        // setSemAntMode(SemAntMode.DEFAULT);
        semAntModeStack.pop();
    }

    /**
     * Function Definition begins
     */
    @Override
    public void enterFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        // setSemAntMode(SemAntMode.FUNCTION_DECLARATION);
        semAntModeStack.push(SemAntMode.FUNCTION_DECLARATION);

        funcDecl = new FuncDecl();

        // return type
        String typeName = ctx.declSpecifierSeq().getText();
        Type returnType = null;
        if (StringUtils.equalsIgnoreCase("void", typeName)) {
            returnType = null;
        } else {
            if (!typeMap.containsKey(typeName)) {
                throw new RuntimeException("type \"" + typeName + "\" not covered!");
            }
            returnType = typeMap.get(typeName);
        }
        funcDecl.setReturnType(returnType);
    }

    @Override
    public void exitFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        // structureCallback.functionDeclaration(funcDecl);

        // setSemAntMode(SemAntMode.DEFAULT);
        semAntModeStack.pop();

        FuncDecl oldFuncDecl = funcDeclMap.put(funcDecl.getName(), funcDecl);
        if (oldFuncDecl != null) {
            throw new RuntimeException("[Function Declaration Error (Line " + ctx.getStart().getLine()
                    + ")] Function \"" + funcDecl.getName() + "\" already defined!");
        }
        funcDecl = null;
    }

    @Override
    public void enterFunctionBody(CPP14Parser.FunctionBodyContext ctx) {
        // setSemAntMode(SemAntMode.FUNCTION_BODY);
        semAntModeStack.push(SemAntMode.FUNCTION_BODY);

        structureCallback.functionDeclaration(funcDecl);
    }

    @Override
    public void exitFunctionBody(CPP14Parser.FunctionBodyContext ctx) {
        // setSemAntMode(SemAntMode.DEFAULT);
        semAntModeStack.pop();
    }

    @Override
    public void enterParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {
        // setSemAntMode(SemAntMode.PARAMETER_DECLARATION);
        semAntModeStack.push(SemAntMode.PARAMETER_DECLARATION);

        FormalParameter formalParameter = new FormalParameter();
        funcDecl.getParams().add(formalParameter);

      
    }

    @Override
    public void exitParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {
        // setSemAntMode(SemAntMode.DEFAULT);
        semAntModeStack.pop();
    }

    @Override
    public void exitSimpleTypeSpecifier(CPP14Parser.SimpleTypeSpecifierContext ctx) {
        final String typeName = ctx.getText();
        // System.out.println(typeName);
        if (semAntModeStack.peek() == SemAntMode.PARAMETER_DECLARATION) {

            if (!typeMap.containsKey(typeName)) {
                throw new RuntimeException("type \"" + typeName + "\" not covered!");
            }
            Type formalParameterType = typeMap.get(typeName);

            FormalParameter formalParameter = funcDecl.getParams().get(funcDecl.getParams().size() - 1);
            formalParameter.setType(formalParameterType);

            // // parameter also appears as a local variable in the current scope
            // varTypeMap.put("a", formalParameterType);
        }
    }

    @Override
    public void enterDeclarator(CPP14Parser.DeclaratorContext ctx) {
    }

    @Override
    public void exitDeclarator(CPP14Parser.DeclaratorContext ctx) {
        structureCallback.getExpressions().clear();
    }

    @Override
    public void enterSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        // System.out.println(ctx.getText());

        if ((ctx.getChild(0) instanceof DeclSpecifierSeqContext)
                || (ctx.getChild(0) instanceof InitDeclaratorListContext)) {
            // semAntMode = SemAntMode.VARIABLE_DECLARATION;
            semAntModeStack.push(SemAntMode.VARIABLE_DECLARATION);
        }
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        // System.out.println(ctx.getText());

        if (declaratorNames.isEmpty()) {
            return;
        }

        if (semAntModeStack.peek() == SemAntMode.STATEMENT) {
            return;
        }

        // check if this declaration is a single semicolon and then skip the empty
        // statement
        if (StringUtils.equalsIgnoreCase(ctx.getText(), ";")) {
            return;
        }

        InitDeclaratorListContext initDeclaratorListContext = ctx.initDeclaratorList();
        List<InitDeclaratorContext> InitDeclaratorContexts = initDeclaratorListContext.initDeclarator();
        InitDeclaratorContext initDeclaratorContext = InitDeclaratorContexts.get(0);
        final ParserRuleContext parserRuleContext = initDeclaratorContext.declarator();

        for (String varName : declaratorNames) {
            processVariableDeclaration(ctx, parserRuleContext, varName);
        }

        // reset
        executionStack.peek().exprTypeStack.clear();
        initializerType = null;
        isArray = false;
        declaratorNames.clear();

        if (ctx.getChild(0) instanceof DeclSpecifierSeqContext) {
            semAntModeStack.pop();
        }
    }

    private void processVariableDeclaration(CPP14Parser.SimpleDeclarationContext ctx,
            ParserRuleContext parserRuleContext,
            String varName) {

        // System.out.println(ctx.getText());

        if (ctx.declSpecifierSeq() == null) {

            // assignment without type declaration (a = 1;)

            Type targetType = varTypeMap.get(varName);
            if (targetType == null) {
                throw new RuntimeException("Unknown variable:  \"" + varName + "\"");
            }

            // type of the assigned value (right hand side (rhs))
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError] VarName: \"" + varName + "\"",
                        parserRuleContext);
            }

            // STRUCTURE CALLBACK
            structureCallback.variableAssignment(varName);

        } else {

            // assignment with type declaration (int a = 1;)

            // type of declared variable
            DeclSpecifierSeqContext declSpecifierSeqContext = ctx.declSpecifierSeq();
            String targetTypeName = declSpecifierSeqContext.getText();
            Type targetType = typeMap.get(targetTypeName);

            if (targetType == null) {
                throw new RuntimeException("Unknown Variable-Type:  \"" + targetType + "\"");
            }

            // type of the assigned value
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError]", declSpecifierSeqContext);
            }

            Type type = null;

            // create an array type if the variable is an array
            if (isArray) {
                Type arrayVarType = new Type();
                arrayVarType.setArraySubType(targetType);
                varTypeMap.put(varName, arrayVarType);

                type = arrayVarType;

            } else {
                varTypeMap.put(varName, targetType);

                type = targetType;
            }

            // STRUCTURE CALLBACK - declaration
            structureCallback.variableDeclaration(varName, type);

            // System.out.println(structureCallback.getExpressions());

            // STRUCTURE CALLBACK - assignment of an expression
            structureCallback.variableAssignment(varName);
        }
    }

    @Override
    public void exitDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {

        String id = ctx.getText();

        // System.out.println(id);

        if (semAntModeStack.empty()) {
            // declaratorNames.add(id);
            return;
        }

        switch (semAntModeStack.peek()) {

            case FUNCTION_DECLARATION:
                funcDecl.setName(id);
                break;

            case FUNCTION_CALL:
                break;

            case STATEMENT:
                declaratorNames.add(id);
                break;

            default:
                declaratorNames.add(id);
                break;
        }
    }

    @Override
    public void enterBraceOrEqualInitializer(CPP14Parser.BraceOrEqualInitializerContext ctx) {
        // int numbers[3] = {10, '20', 30};
        // forget about the array length literal '3'
        executionStack.peek().exprTypeStack.clear();
        // setSemAntMode(SemAntMode.INITIALIZER);
        semAntModeStack.push(SemAntMode.INITIALIZER);
    }

    @Override
    public void exitInitializerClause(CPP14Parser.InitializerClauseContext ctx) {

        // System.out.println(ctx.getText());

        // store type in the initializerType member so the SimpleDeclaration rule
        // can retrieve the type from the member

        if (executionStack.peek().exprTypeStack.size() == 1) {
            Type tempInitializerType = executionStack.peek().exprTypeStack.pop();
            if ((initializerType != null) && (!initializerType.equals(tempInitializerType))) {
                throw new RuntimeException(
                        "[Error: Initializer Types not compatible! (Line " + ctx.getStart().getLine() + ")] "
                                + tempInitializerType + " is added to " + initializerType);
            }
            initializerType = tempInitializerType;
        }

        // setSemAntMode(SemAntMode.DEFAULT);

        // if (!semAntModeStack.empty()) {
        // semAntModeStack.pop();
        // }
    }

    @Override
    public void exitNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {

        // sometimes two NoPointerDeclaratorContext are directly nested!
        // Only deal with the nexted node, ignore the parent!
        if (ctx.getParent() instanceof CPP14Parser.NoPointerDeclaratorContext) {
            return;
        }

        if (ctx.getChildCount() > 1) {

            boolean arrayStartFound = false;
            boolean arrayEndFound = false;

            if (StringUtils.equalsIgnoreCase(ctx.getChild(1).getText(), "[")) {
                arrayStartFound = true;
            }
            if (StringUtils.equalsIgnoreCase(ctx.getChild(ctx.getChildCount() - 1).getText(), "]")) {
                arrayEndFound = true;
            }

            if (arrayStartFound && arrayEndFound) {
                isArray = true;
            }
        }
    }

    @Override
    public void enterMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {
        if (ctx.getChildCount() != 1) {
            structureCallback.addExpression();
        }
    }

    @Override
    public void exitMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {
        getExpr(ctx.pointerMemberExpression());
        if (ctx.getChildCount() != 1) {
            structureCallback.ascendExpression();
        }
    }

    @Override
    public void enterAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {
        if (ctx.getChildCount() != 1) {
            structureCallback.addExpression();
        }
    }

    @Override
    public void exitAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {
        getExpr(ctx.multiplicativeExpression());

        if (ctx.getChildCount() != 1) {
            structureCallback.ascendExpression();
        }
    }

    private void getExpr(List<? extends ParserRuleContext> objs) {

        int size = CollectionUtils.size(objs);
        if (size == 1) {
            return;
        }

        for (ParserRuleContext expr : objs) {

            if (size == 1) {
                break;
            }
            size--;

            StackFrame stackFrame = executionStack.peek();
            Stack<Type> stack = stackFrame.exprTypeStack;

            Type typeA = stack.pop();
            Type typeB = stack.pop();

            performTypeCheck(typeA, typeB, "TypeError", expr);

            executionStack.peek().exprTypeStack.push(typeA);
        }
    }

    @Override
    public void exitIdExpression(CPP14Parser.IdExpressionContext ctx) {

        final String varName = ctx.getText();

        // System.out.println(varName);

        if (semAntModeStack.empty()) {
            return;
        }

        switch (semAntModeStack.peek()) {

            case INITIALIZER: {
                if (!varTypeMap.containsKey(varName)) {

                    if (!funcDeclMap.containsKey(varName)) {
                        throw new RuntimeException(
                                "[Error: Initializer variable not defined! (Line " + ctx.getStart().getLine() + ")] "
                                        + " Undefined variable is: \"" + varName + "\" node = " + ctx.hashCode());
                    }
                }

                Type type = varTypeMap.get(ctx.getText());
                executionStack.peek().exprTypeStack.push(type);
            }
                break;

            case PARAMETER_DECLARATION: {
                // System.out.println("Add parameter");

                FormalParameter formalParameter = funcDecl.getParams().get(funcDecl.getParams().size() - 1);
                formalParameter.setName(varName);

                // in the current local scope, parameters are treated as local variables!
                varTypeMap.put(formalParameter.getName(), formalParameter.getType());

                StackFrame stackFrame = executionStack.peek();
                Stack<Type> stack = stackFrame.exprTypeStack;
                stack.push(formalParameter.getType());
            }
                break;

            case FUNCTION_DECLARATION: {
                funcDecl.setName(varName);
                declaratorNames.clear();

                // structureCallback.functionDeclaration(funcDecl);
            }
                break;

            case FUNCTION_CALL: {
                if (!funcDeclMap.containsKey(varName)) {
                    throw new RuntimeException(
                            "[Error: Function not defined! (Line " + ctx.getStart().getLine() + ")] "
                                    + " Undefined function is: \"" + varName + "\"");
                }

                FuncDecl funcDecl = funcDeclMap.get(ctx.getText());
                executionStack.peek().exprTypeStack.push(funcDecl.getReturnType());
                // System.out.println("FUNCTION_CALL: " + varName);
                calledFunctionNameStack.push(varName);
            }
                break;

            case STATEMENT: {
                // this was added for return values of functions
                structureCallback.identifierLiteral(varName);
            }

            default:
                break;
        }
    }

    @Override
    public void enterLiteral(CPP14Parser.LiteralContext ctx) {

        boolean typeProcessed = false;

        // int
        TerminalNode literalTerminalNode = ctx.IntegerLiteral();
        if (literalTerminalNode != null) {
            typeProcessed = true;
            Integer value = Integer.parseInt(ctx.getText());
            structureCallback.intLiteral(value);
        }

        // std::string
        literalTerminalNode = ctx.StringLiteral();
        if (literalTerminalNode != null) {
            typeProcessed = true;
            String value = ctx.getText();
            structureCallback.stringLiteral(value);
        }

        // char
        literalTerminalNode = ctx.CharacterLiteral();
        if (literalTerminalNode != null) {
            typeProcessed = true;
            String value = ctx.getText();
            structureCallback.charLiteral(value);
        }

        // float
        literalTerminalNode = ctx.FloatingLiteral();
        if (literalTerminalNode != null) {
            typeProcessed = true;
            Float value = Float.parseFloat(ctx.getText());
            structureCallback.floatLiteral(value);
        }

        // unknown type
        if (!typeProcessed) {
            throw new RuntimeException("type not covered!");
        }
    }

    @Override
    public void exitLiteral(CPP14Parser.LiteralContext ctx) {

        // System.out.println(ctx.getText());

        boolean typeProcessed = false;

        // int
        TerminalNode literalTerminalNode = ctx.IntegerLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("int");
            typeProcessed = true;
        }

        // std::string
        literalTerminalNode = ctx.StringLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("std::string");
            typeProcessed = true;
        }

        // char
        literalTerminalNode = ctx.CharacterLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("char");
            typeProcessed = true;
        }

        // float
        literalTerminalNode = ctx.FloatingLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("float");
            typeProcessed = true;
        }

        // unknown type
        if (!typeProcessed) {
            throw new RuntimeException("type not covered!");
        }
    }

    private void checkAndAddType(final String typeName) {
        if (!typeMap.containsKey(typeName)) {
            throw new RuntimeException("type \"" + typeName + "\" not covered!");
        }
        executionStack.peek().exprTypeStack.push(typeMap.get(typeName));
    }

    private void performTypeCheck(final Type targetType, final Type rhsType, final String label,
            final ParserRuleContext ctx) {
        if (targetType != rhsType) {
            throw new RuntimeException(
                    "[Error: " + label + " Line: " + ctx.getStart().getLine() + "]" + " Var's type: \"" + targetType
                            + "\" Assigned value's type: \"" + rhsType
                            + "\" ");
        }
    }

    /**
     * With the AST that the grammar produces, it is hard to tell where a function
     * call occurs!
     * 
     * The strategy here is to check every identifier versus known declared function
     * names.
     * If the identifier is a function name, then assume a function call.
     */
    @Override
    public void enterUnqualifiedId(CPP14Parser.UnqualifiedIdContext ctx) {

        String identifier = ctx.getText();

        // System.out.println(identifier);

        // if (StringUtils.equalsIgnoreCase(identifier, "main")) {
        // return;
        // }

        if ((!semAntModeStack.isEmpty()) && (semAntModeStack.peek() == SemAntMode.PARAMETER_DECLARATION)) {

            // parameter also appears as a local variable in the current scope
            //varTypeMap.put(identifier, null);

            // StackFrame stackFrame = executionStack.peek();
            // Stack<Type> stack = stackFrame.exprTypeStack;
            // stack.push(typeMap.get("int"));

            return;
        }

        if (varTypeMap.containsKey(identifier)) {
            //throw new RuntimeException("[ERROR] variable \"" + identifier + "\" not defined in the current scope!");
             return;
        }

        if (funcDeclMap.containsKey(identifier)) {

            FuncDecl funcDecl = funcDeclMap.get(identifier);

            if (funcDecl.getParams().size() == 0) {

                // System.out.println("FUNCTION_CALL enter without parameters detected");

                // setSemAntMode(SemAntMode.FUNCTION_CALL);
                semAntModeStack.push(SemAntMode.FUNCTION_CALL);

                // STRUCTURE CALLBACK
                structureCallback.functionCall(identifier, funcDecl);

            } else {

                // System.out.println("FUNCTION_CALL enter detected");

                StackFrame stackFrame = new StackFrame();
                executionStack.push(stackFrame);

                // setSemAntMode(SemAntMode.FUNCTION_CALL);
                semAntModeStack.push(SemAntMode.FUNCTION_CALL);

                // // STRUCTURE CALLBACK
                // structureCallback.functionCall(identifier, funcDecl);

            }

        } else {

            if ((semAntModeStack.peek() != SemAntMode.FUNCTION_DECLARATION)
                    && (semAntModeStack.peek() != SemAntMode.VARIABLE_DECLARATION)) {
                throw new RuntimeException(
                        "Unknown function / variable: \"" + identifier + "\". Line " + ctx.getStart().getLine());
            }

        }
    }

    @Override
    public void exitUnqualifiedId(CPP14Parser.UnqualifiedIdContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {

        if (StringUtils.equalsIgnoreCase(node.getText(), "+")) {
            structureCallback.plus();
        } else if (StringUtils.equalsIgnoreCase(node.getText(), "-")) {
            structureCallback.minus();
        } else if (StringUtils.equalsIgnoreCase(node.getText(), "*")) {
            structureCallback.mult();
        } else if (StringUtils.equalsIgnoreCase(node.getText(), "/")) {
            structureCallback.divisor();
        }
    }

    public Map<String, Type> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Type> typeMap) {
        this.typeMap = typeMap;
    }

    // public Map<String, Type> getVarTypeMap() {
    //     return varTypeMap;
    // }

    public Map<String, FuncDecl> getFuncDeclMap() {
        return funcDeclMap;
    }

    public void setFuncDeclMap(Map<String, FuncDecl> funcDeclMap) {
        this.funcDeclMap = funcDeclMap;
    }

    public Stack<StackFrame> getExecutionStack() {
        return executionStack;
    }

    public void setExecutionStack(Stack<StackFrame> executionStack) {
        this.executionStack = executionStack;
    }

    public StructureCallback getStructureCallback() {
        return structureCallback;
    }

    public void setStructureCallback(StructureCallback structureCallback) {
        this.structureCallback = structureCallback;
    }

}
