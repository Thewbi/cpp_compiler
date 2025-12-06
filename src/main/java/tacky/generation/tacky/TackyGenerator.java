package tacky.generation.tacky;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import ast.ASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.JumpStatementASTNode;
import ast.ParameterDeclarationASTNode;
import ast.ParameterDeclarationListASTNode;
import ast.ParametersAndQualifiersASTNode;
import ast.PostFixExpressionASTNode;
import ast.SelectionStatementASTNode;
import ast.SimpleDeclarationASTNode;
import ast.StatementASTNode;
import tacky.ast.FunctionCallASTNode;
import tacky.runtime.TACKYStackFrame;
import tacky.runtime.TACKYStackFrameVariableDescriptor;

public class TackyGenerator {

    public StringBuilder stringBuilder = new StringBuilder();

    public int forLoopCount = 0;

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public TACKYStackFrame tackyStackFrame;

    public int tempCounter = 0;

    public int ifCounter = 0;

    public boolean generateDefaultLoopConditionExpression = false;

    public void process(int indent, ASTNode astNode) {

        switch (astNode.astNodeType) {

            case ROOT:

                // base scope
                addScope();

                // process all children
                for (ASTNode childNode : astNode.children) {
                    process(indent, childNode);
                }
                break;

            case FUNCTION_DECLARATION:
                enterFunctionDeclaration(indent, astNode);
                // all children
                for (ASTNode child : astNode.children) {
                    process(indent + 1, child);
                }
                exitFunctionDeclaration(indent, astNode);
                break;

            case FUNCTION_CALL:
                enterFunctionCall(indent, (DeclaratorASTNode) astNode);
                exitFunctionCall(indent, (DeclaratorASTNode) astNode);
                break;

            case ITERATION_STATEMENT:
                StatementASTNode statementASTNode = (StatementASTNode) astNode;
                switch (statementASTNode.statementType) {
                    case FOR:
                        enterForLoop(indent, statementASTNode);
                        // the children of the FOR loop are visited within enterForLoop()
                        exitForLoop(indent, statementASTNode);
                        break;

                    default:
                        enterUnknown(astNode);
                        for (ASTNode child : astNode.children) {
                            process(indent, child);
                        }
                        exitUnknown(astNode);
                        break;
                }
                break;

            case SIMPLE_DECLARATION:
                SimpleDeclarationASTNode simpleDeclarationASTNode = (SimpleDeclarationASTNode) astNode;
                enterSimpleDeclaration(indent, simpleDeclarationASTNode);
                exitSimpleDeclaration(simpleDeclarationASTNode);
                break;

            case INIT_DECLARATION:
                DeclaratorASTNode declaratorASTNode = (DeclaratorASTNode) astNode;
                enterInitDeclaration(indent, declaratorASTNode);
                exitInitDeclaration(declaratorASTNode);
                break;

            case JUMP_STATEMENT:
                JumpStatementASTNode jumpStatementASTNode = (JumpStatementASTNode) astNode;
                switch (jumpStatementASTNode.statementType) {
                    case BREAK:
                        enterBreak(indent, jumpStatementASTNode);
                        exitBreak(indent, jumpStatementASTNode);
                        break;
                    default:
                        throw new RuntimeException();
                }
                break;

            case SELECTION_STATEMENT:
                SelectionStatementASTNode selectionStatementASTNode = (SelectionStatementASTNode) astNode;
                switch (selectionStatementASTNode.statementType) {
                    case IF:
                        enterIf(indent, selectionStatementASTNode);
                        exitIf(indent, selectionStatementASTNode);
                        break;
                    default:
                        throw new RuntimeException();
                }
                break;

            case RETURN: {
                // System.out.println("return");
                JumpStatementASTNode returnStatementASTNode = (JumpStatementASTNode) astNode;
                switch (returnStatementASTNode.statementType) {
                    case RETURN:
                        enterReturn(indent, returnStatementASTNode);
                        exitReturn(indent, returnStatementASTNode);
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
                break;

            default:
                // System.out.println("Unknown Tacky-Generator type: \"" + astNode.astNodeType +
                // "\" ");
                enterUnknown(astNode);
                for (ASTNode child : astNode.children) {
                    process(indent, child);
                }
                exitUnknown(astNode);
                return;
        }

    }

    // Scope

    private void addScope() {
        tackyStackFrame = new TACKYStackFrame();
        executionStack.add(tackyStackFrame);
    }

    private void removeScope() {
        tackyStackFrame = executionStack.pop();
        tackyStackFrame = executionStack.peek();
    }

    private void addVariableToScope(String name, TackyDataType tackyDataType, boolean isArray, boolean isPointer) {

        // if (name.equalsIgnoreCase("matrix")) {
        // System.out.println("");
        // }
        TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = new TACKYStackFrameVariableDescriptor();
        tackyStackFrameVariableDescriptor.name = name;
        tackyStackFrameVariableDescriptor.tackyDataType = tackyDataType;
        tackyStackFrameVariableDescriptor.isArray = isArray;
        tackyStackFrameVariableDescriptor.isPointer = isPointer;

        tackyStackFrame.variables.put(name, tackyStackFrameVariableDescriptor);
    }

    // Declarations

    private String enterFunctionCall(int indent, DeclaratorASTNode astNode) {

        String returnValueVariableName = null;

        // -- build indent string --

        String indentString = buildIndentString(indent);

        // -- add new line for improved readability --

        String calledFunctionName = astNode.children.get(0).value;

        stringBuilder.append("\n");
        stringBuilder.append(indentString).append("# -- Function -- ").append(calledFunctionName).append("\n");

        // -- function return value + actual parameters --

        // String calledFunctionName = astNode.value.substring(0,
        // astNode.value.indexOf("("));

        // // DEBUG
        // System.out.println("Processing function: \"" + calledFunctionName + "\"");

        if (calledFunctionName.equalsIgnoreCase("printf")) {

            // special treatment for printf()
            processFunctionCall(indent, astNode);

        } else if (calledFunctionName.equalsIgnoreCase("exit")) {

            // special treatment for exit()
            processFunctionCall(indent, astNode);

        } else {

            // create a variable to store the functions return value
            // tmp.0 = Var("tmp.0")
            returnValueVariableName = "tmp." + calledFunctionName;
            defineVariable(indent, returnValueVariableName, TackyDataType.INT_8);

            ASTNode parameters = astNode.children.get(1);

            // sadly because the grammar is wierd, function calls without parameters
            // and function calls with parameters lead to different AST nodes!
            // Maybe unify the AST generation if you have a very large brain!
            if (parameters instanceof ParametersAndQualifiersASTNode) {

                // do nothing, empty parameter list

                // // unwrap parameter decl list ASTNode
                // ParametersAndQualifiersASTNode parametersAndQualifiersASTNode =
                // (ParametersAndQualifiersASTNode)

                // // if the function has any formal parameters prepare code for pointer
                // parameters
                // if (parametersAndQualifiersASTNode.children.size() > 0) {
                // ParameterDeclarationListASTNode parameterDeclarationListASTNode =
                // (ParameterDeclarationListASTNode)
                // parametersAndQualifiersASTNode.children.get(0);

                // // formal parameters
                // for (int i = 0; i < parameterDeclarationListASTNode.children.size(); i++) {

                // }

                // }

            } else {

                // determine if a parameter requires a pointer variable

                // formal parameters
                for (int i = 1; i < astNode.children.size(); i++) {

                    ASTNode param = astNode.children.get(i);

                    // DEBUG

                    // System.out.println(param);

                    if (param instanceof ExpressionASTNode) {

                        ExpressionASTNode expr = (ExpressionASTNode) param;
                        switch (expr.expressionType) {

                            case Primary:
                                // ignored: Just pass the number as is without wrapping it in const
                                // stringBuilder.append(",
                                // Constant(ConstInt(").append(param.value).append("))");
                                break;

                            case Identifier:

                                // // DEBUG
                                // if (param.value.equalsIgnoreCase("subMatrixB")) {
                                // System.out.println("subMatrixB");
                                // }

                                TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = findVariableDescriptorInStack(
                                        param.value);

                                // CHECK
                                if (tackyStackFrameVariableDescriptor == null) {
                                    throw new RuntimeException(
                                            "Parameter cannot be identified: \"" + param.value + "\"");
                                }

                                // check if the identifier is an array
                                if (tackyStackFrameVariableDescriptor.isArray) {

                                    stringBuilder.append(indentString);
                                    stringBuilder.append("// parameter " + i + " for function call").append("\n");

                                    // tmp.1.ptr = Var("tmp.1.ptr") // address: 8
                                    String varName = "tmp." + i + ".ptr";
                                    defineVariable(indent, varName, TackyDataType.INT_32);
                                    addVariableToScope(varName, TackyDataType.INT_32, false, false);

                                    // store an address into the pointer
                                    // GetAddress(tmp.1, tmp.1.ptr)
                                    stringBuilder.append(indentString).append("GetAddress(")
                                            .append(param.value).append(", ").append(varName).append(")");
                                    stringBuilder.append("\n");

                                }
                                break;

                            default:
                                throw new RuntimeException("Case not treated! type=" + expr.expressionType);
                        }
                    }
                }

            }

            // // Function Call
            // // provide actual parameters for both arguments
            // // provide a parameter for the return value
            // funccall(test_function, false, Constant(ConstInt(2)), Constant(ConstInt(3)),
            // tmp.0)

            // @formatter:off

            stringBuilder.append(indentString)
                .append("funccall(")
                .append(calledFunctionName)
                .append(", false");

            // @formatter:on

            // actual parameters

            if (parameters instanceof ParametersAndQualifiersASTNode) {

                // do nothing, empty parameter list

                // ParametersAndQualifiersASTNode parametersAndQualifiersASTNode =
                // (ParametersAndQualifiersASTNode) astNode.children.get(1);
                // ParameterDeclarationListASTNode parameterDeclarationListASTNode =
                // (ParameterDeclarationListASTNode)
                // parametersAndQualifiersASTNode.children.get(0);
                // if the function has any formal parameters prepare code for pointer parameters
                // if (parametersAndQualifiersASTNode.children.size() > 0) {

                // ParameterDeclarationListASTNode parameterDeclarationListASTNode =
                // (ParameterDeclarationListASTNode)
                // parametersAndQualifiersASTNode.children.get(0);
                // for (int i = 0; i < parameterDeclarationListASTNode.children.size(); i++) {
                // ASTNode param = parameterDeclarationListASTNode.children.get(i);

                // }

                // }

            } else {

                for (int i = 1; i < astNode.children.size(); i++) {

                    ASTNode param = astNode.children.get(i);

                    // System.out.println(param);

                    if (param instanceof ExpressionASTNode) {

                        ExpressionASTNode expr = (ExpressionASTNode) param;
                        switch (expr.expressionType) {

                            case Primary:
                                // stringBuilder.append(",
                                // Constant(ConstInt(").append(param.value).append("))");
                                stringBuilder.append(", ").append(wrapInConstant(param.value));
                                break;

                            case StringLiteral:
                                stringBuilder.append(", Constant(ConstString(").append(param.value).append("))");
                                break;

                            case Identifier:

                                // TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor =
                                // tackyStackFrame.variables
                                // .get(param.value);

                                TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = findVariableDescriptorInStack(
                                        param.value);

                                // System.out.println("test");

                                // check if the identifier is an array
                                if (tackyStackFrameVariableDescriptor.isArray) {

                                    // // tmp.1.ptr = Var("tmp.1.ptr") // address: 8
                                    // defineVariable(0, "tmp.1.ptr", TackyDataType.INT_32);
                                    // addVariableToScope("tmp.1.ptr", TackyDataType.INT_32, false);

                                    // // store an address into the pointer
                                    // // GetAddress(tmp.1, tmp.1.ptr)
                                    // stringBuilder.append(indentString).append("GetAddress(")
                                    // .append(param.value).append(", ").append("tmp.1.ptr").append(")");

                                    // // Function Call
                                    // // provide actual parameters for both arguments
                                    // // provide a parameter for the return value
                                    // funccall(test_function, false,
                                    // tmp.1.ptr,
                                    // tmp.0
                                    // )
                                    stringBuilder.append(", tmp." + i + ".ptr");

                                } else {
                                    // throw new RuntimeException();
                                    stringBuilder.append(", " + tackyStackFrameVariableDescriptor.name);
                                }

                                break;

                            default:
                                throw new RuntimeException("Unhandeled expression type: " + expr.expressionType);
                        }

                    } else {

                        throw new RuntimeException("Unhandeled Parameter Type: " + param);

                    }

                }

            }

            // return variable
            stringBuilder.append(", ").append(returnValueVariableName).append(")").append("\n");
        }

        stringBuilder.append("\n");

        return returnValueVariableName;
    }

    private void exitFunctionCall(int indent, DeclaratorASTNode astNode) {
        ;
    }

    private void enterSimpleDeclaration(int indent, SimpleDeclarationASTNode simpleDeclarationASTNode) {
        for (ASTNode astNode : simpleDeclarationASTNode.children) {
            process(indent, astNode);
        }
    }

    private void exitSimpleDeclaration(SimpleDeclarationASTNode simpleDeclarationASTNode) {
        ;
    }

    private void enterInitDeclaration(int indent, DeclaratorASTNode declaratorASTNode) {

        // System.out.println(declaratorASTNode);

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // declaratorASTNode.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        if (declaratorASTNode.isFunctionCall) {
            processFunctionCall(indent, declaratorASTNode);
        } else {
            processVariableDeclaration(indent, declaratorASTNode);
        }
    }

    private void exitInitDeclaration(DeclaratorASTNode declaratorASTNode) {
        // System.out.println(declaratorASTNode);
    }

    private void processFunctionCall(int indent, DeclaratorASTNode declaratorASTNode) {

        String indentString = buildIndentString(indent);

        String functionName = declaratorASTNode.getChildren().get(0).value;

        if (functionName.equalsIgnoreCase("printf")) {

            stringBuilder.append(indentString).append("printf").append("(");

            int counter = 0;
            for (ASTNode child : declaratorASTNode.getChildren()) {
                counter++;
                if (counter == 1) {
                    continue;
                }
                if (counter > 2) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(child.value);
            }

            stringBuilder.append(")");
            stringBuilder.append("\n");

        } else if (functionName.equalsIgnoreCase("exit")) {

            stringBuilder.append(indentString).append("exit").append("(");

            int counter = 0;
            for (ASTNode child : declaratorASTNode.getChildren()) {
                counter++;
                if (counter == 1) {
                    continue;
                }
                if (counter > 2) {
                    stringBuilder.append(",");
                }

                if (child.value != null) {
                    stringBuilder.append(child.value);
                }
            }

            stringBuilder.append(")");
            stringBuilder.append("\n");

        }
    }

    private void processVariableDeclaration(int indent, DeclaratorASTNode declaratorASTNode) {

        String indentString = buildIndentString(indent);

        // retrieve type from parent
        SimpleDeclarationASTNode parent = (SimpleDeclarationASTNode) declaratorASTNode.parent;

        // determine if this is a variable declaration or not
        if (parent.type != null) {

            // declaration of new variable (possibly with initialization)

            String type = parent.type;

            boolean isArray = false;
            boolean isFunctionCall = false;
            int arraySize = 0;

            ASTNode child0ASTNode = declaratorASTNode.children.get(0);
            if (child0ASTNode instanceof DeclaratorASTNode) {

                DeclaratorASTNode child0 = (DeclaratorASTNode) child0ASTNode;
                isArray = child0.isArray;
                isFunctionCall = child0.isFunctionCall;
                arraySize = (Integer) evaluate((ExpressionASTNode) child0.indexExpression);

            } else if (child0ASTNode instanceof ExpressionASTNode) {

                if (declaratorASTNode.children.get(1) instanceof PostFixExpressionASTNode) {
                    // nop
                } else if (declaratorASTNode.children.get(1) instanceof ExpressionASTNode) {

                    ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;
                    ExpressionASTNode child1ExpressionASTNode = (ExpressionASTNode) declaratorASTNode.children.get(1);

                    String variableName = child0ExpressionASTNode.value;

                    // System.out.println(variableName);

                    String expr = evaluateToString(indent, child1ExpressionASTNode);

                    // System.out.println(expr);

                    defineVariable(indent, variableName, null);

                    stringBuilder.append(indentString).append(variableName).append(" = ").append(expr).append("\n");
                }

            } else {

                throw new RuntimeException("type");

            }

            ASTNode child1ASTNode = declaratorASTNode.children.get(1);

            String name = child0ASTNode.value;

            ASTNode valueASTNode = declaratorASTNode.children.get(1);

            if (isArray) {

                // create a variable for the array. Define the array as a variable

                defineVariable(indent, name, TackyDataType.INT_32, isArray, arraySize);

                // sizeof
                // sizeof_int = Var("sizeof_int")
                // sizeof(int8, sizeof_int)

                // determine the size of the array element type and store it into a variable for
                // later use
                stringBuilder.append(indentString).append("sizeof_array_type = Var(\"sizeof_array_type\")")
                        .append("\n");
                stringBuilder.append(indentString)
                        .append("sizeof(" + TackyDataType.toString(TackyDataType.INT_32) + ", sizeof_array_type)")
                        .append("\n");

                // create a pointer (= normal variable that stores an address)
                // to the first element of the array
                // array1d.ptr = Var("array1d.ptr")
                String pointerName = name + ".ptr";
                defineVariable(indent, pointerName, TackyDataType.INT_32);
                // GetAddress(array1d, array1d.ptr)
                stringBuilder.append(indentString).append("GetAddress(" + name + ", " + name + ".ptr)").append("\n");

                // // temp variable for loading data into the array
                // // tmp.0 = Var("tmp.0")
                // defineVariable(0, name + ".tmp.0", TackyDataType.INT_32);

                int index = 0;
                for (int i = 1; i < declaratorASTNode.children.size(); i++) {

                    String tempValue = declaratorASTNode.children.get(i).value;
                    assignValueToArrayElement(indent, declaratorASTNode, pointerName, Integer.toString(index),
                            tempValue);

                    index++;

                }

                // } else if (valueASTNode instanceof FunctionCallASTNode) {
            } else if (valueASTNode instanceof DeclaratorASTNode) {

                String returnVariableName = enterFunctionCall(indent, (DeclaratorASTNode) valueASTNode);
                exitFunctionCall(indent, (DeclaratorASTNode) valueASTNode);

                // declare assigned variable
                String destinationVarname = ((ExpressionASTNode) child0ASTNode).value;
                defineVariable(indent, destinationVarname, null);

                stringBuilder.append(indentString)
                        .append(destinationVarname).append(" = ").append(returnVariableName)
                        .append("\n");

            } else if (valueASTNode instanceof ExpressionASTNode) {

                ExpressionASTNode expressionASTNode = (ExpressionASTNode) valueASTNode;

                if (expressionASTNode.expressionType == ExpressionType.ArrayIndexing) {

                    // System.out.println("ArrayIndexing");

                    // stringBuilder.append("\n");

                    ExpressionASTNode assignedValueExpression = (ExpressionASTNode) valueASTNode;

                    ASTNode c1 = assignedValueExpression.children.get(1);

                    // // DEBUG
                    // System.out.println(tackyStackFrame.variables.size());

                    String arrayName = child1ASTNode.value;
                    TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = findVariableDescriptorInStack(
                            arrayName);

                    String destinationVariableName = child0ASTNode.value;
                    defineVariable(indent, destinationVariableName, null);

                    String arrayPointerName = null;
                    if (tackyStackFrameVariableDescriptor.isPointer) {

                        // if a pointer is available already, use it
                        arrayPointerName = tackyStackFrameVariableDescriptor.name;

                    } else {

                        // if no pointer is available, create a pointer first

                        String tempVarName = arrayName + ".addr.ptr";

                        defineVariable(indent, tempVarName, null);

                        // store an address into the pointer
                        // GetAddress(tmp.1, tmp.1.ptr)
                        stringBuilder.append(indentString).append("GetAddress(")
                                .append(arrayName).append(", ").append(tempVarName).append(")");
                        stringBuilder.append("\n");

                        arrayPointerName = tempVarName;

                    }

                    if (NumberUtils.isParsable(c1.value)) {

                        int arrayIndex = (int) evaluate((ExpressionASTNode) c1);
                        retrieveValueFromArrayElement(indent, declaratorASTNode, arrayPointerName, arrayIndex,
                                destinationVariableName);

                    } else {

                        retrieveValueFromArrayElementByVariable(indent, declaratorASTNode, arrayPointerName, c1.value,
                                destinationVariableName);

                    }

                }

            } else {

                addVariableToScope(name, TackyDataType.fromString(type), isArray, false);

                ExpressionASTNode assignedValueExpression = (ExpressionASTNode) valueASTNode;

                String exprAsString = evaluateToString(indent, assignedValueExpression);

                // // DEBUG
                // System.out.println("Declaration. type=" + type + ", name=" + name + ",
                // isArray=" + isArray
                // + ", assignedValue=" + exprAsString);

                // i = Var("i")
                // @formatter:off
                stringBuilder.append(indentString)
                    .append(name).append(" = Var(").append("\"").append(name).append("\")")
                    .append("\n");
                // @formatter:on

                // if (type.equalsIgnoreCase("int")) {
                // // i = Constant(ConstInt(0))
                //     // @formatter:off
                //     stringBuilder.append(indentString).append(name)
                //         .append(" = Constant(").append("ConstInt(")
                //         // .append(assignedValue)
                //         .append(exprAsString)
                //         .append("))").append("\n");
                //     // @formatter:on
                // }

                // @formatter:off
                stringBuilder.append(indentString).append(name).append(" = ")
                    .append(exprAsString)
                    .append("\n");
                // @formatter:on

            }

        } else {

            // existing variable is initialized

            String index = "0";

            ASTNode child0ASTNode = declaratorASTNode.children.get(0);
            if (child0ASTNode instanceof DeclaratorASTNode) {

                DeclaratorASTNode child0 = (DeclaratorASTNode) child0ASTNode;

                ExpressionASTNode expressionASTNode = child0.indexExpression;

                switch (expressionASTNode.expressionType) {

                    case Identifier:
                        index = evaluate(expressionASTNode).toString();
                        break;

                    case IntegerLiteral:
                        index = wrapInConstant(evaluate(expressionASTNode).toString());
                        break;

                    case Primary:
                        // System.out.println(expressionASTNode);
                        index = evaluate(expressionASTNode).toString();
                        break;

                    default:
                        throw new RuntimeException(
                                "Unhandeled expressionType: '" + expressionASTNode.expressionType + "'");
                }

                String arrayName = child0ASTNode.value;

                Object assignedValue = evaluate((ExpressionASTNode) declaratorASTNode.children.get(1));

                // DEBUG
                // System.out.println("Assignment. name=" + arrayName + ", isArray=" + isArray +
                // ", index=" + index
                // + ", assignedValue=" + assignedValue);

                TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = findVariableDescriptorInStack(
                        arrayName);

                String arrayPointerName = null;
                if (tackyStackFrameVariableDescriptor.isPointer) {

                    // if a pointer is available already, use it
                    arrayPointerName = tackyStackFrameVariableDescriptor.name;

                } else {

                    // if no pointer is available, create a pointer first

                    String tempVarName = arrayName + ".addr.ptr";

                    defineVariable(indent, tempVarName, null);

                    // store an address into the pointer
                    // GetAddress(tmp.1, tmp.1.ptr)
                    stringBuilder.append(indentString).append("GetAddress(")
                            .append(arrayName).append(", ").append(tempVarName).append(")");
                    stringBuilder.append("\n");

                    arrayPointerName = tempVarName;

                }

                // @formatter:off
                assignValueToArrayElement(indent,
                    declaratorASTNode,
                    arrayPointerName,
                    index,
                    assignedValue.toString());
                // @formatter:on

            } else if (child0ASTNode instanceof ExpressionASTNode) {

                ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;

                // ASTNode child1ASTNode = declaratorASTNode.children.get(1);
                ExpressionASTNode child1expressionASTNode = (ExpressionASTNode) declaratorASTNode.children.get(1);

                // String expr = outputExpression(child1expressionASTNode);
                String expr = evaluateToString(indent + 1, child1expressionASTNode);

                // defineVariable(indent, child0ExpressionASTNode.value, null);

                stringBuilder.append(indentString)
                        .append(child0ExpressionASTNode.value).append(" = ");
                stringBuilder.append(expr).append("\n");

                // // @formatter:off
                // stringBuilder.append(child0ExpressionASTNode.value)
                //     .append("(").append(child1ASTNode.value).append(")")
                //     .append("\n");
                // // @formatter:on

                // original:
                // // @formatter:off
                // stringBuilder.append(child0ExpressionASTNode.value)
                //     .append("(").append(child1ASTNode.value).append(")")
                //     .append("\n");
                // // @formatter:on

            } else {

                throw new RuntimeException("type");

            }

        }
    }

    private TACKYStackFrameVariableDescriptor findVariableDescriptorInStack(String varName) {

        // for (TACKYStackFrame tackyStackFrame : executionStack) {
        // System.out.println(tackyStackFrame);
        // }

        for (int i = executionStack.size() - 1; i >= 0; i--) {
            TACKYStackFrame tackyStackFrame = executionStack.elementAt(i);
            // System.out.println(tackyStackFrame);

            if (tackyStackFrame.variables.containsKey(varName)) {
                return tackyStackFrame.variables.get(varName);
            }
        }

        return null;
    }

    private void assignValueToArrayElement(int indent, DeclaratorASTNode declaratorASTNode,
            String arrayPtrName, String arrayElementIndex, String value) {

        String indentString = buildIndentString(indent);

        // stringBuilder.append("\n");
        stringBuilder.append(indentString).append("// assign to array-element").append("\n");

        stringBuilder.append(indentString).append("// " + arrayElementIndex).append("\n");

        // determine the size of the array element type and store it into a variable for
        // later use
        stringBuilder.append(indentString).append("sizeof_array_type = Var(\"sizeof_array_type\")")
                .append("\n");

        stringBuilder.append(indentString)
                .append("sizeof(" + TackyDataType.toString(TackyDataType.INT_32) + ", sizeof_array_type)")
                .append("\n");

        // advance the pointer forward to the requested n-th element
        // to point to element #n, move the pointer four times
        //
        // array1d.ptr = array1d.ptr + (n-1) * sizeof_int

        // @formatter:off

        defineVariable(indent, arrayPtrName + ".ptr.tmp.1", null);

        stringBuilder.append(indentString)
            .append(arrayPtrName + ".ptr.tmp.1").append(" = ")
            //.append(wrapInConstant(arrayElementIndex))
            .append(arrayElementIndex)
            .append(" * ").append("sizeof_array_type")
            .append("\n");

        defineVariable(indent, arrayPtrName + ".ptr.tmp", null);

        // compute the correct address for the index used
        stringBuilder.append(indentString)
            .append(arrayPtrName + ".ptr.tmp").append(" = ")
            .append(arrayPtrName).append(" + ")
            .append(arrayPtrName + ".ptr.tmp.1")
            .append("\n");

        // @formatter:on

        // temp variable for loading data into the array
        // tmp.0 = Var("tmp.0")
        defineVariable(indent, arrayPtrName + ".tmp.0", TackyDataType.INT_32);

        // write data into the array element

        // tmp.0 = 18
        stringBuilder.append(indentString)
                .append(arrayPtrName + ".tmp.0").append(" = ")
                .append(value)
                // .append(wrapInConstant(value))
                .append("\n");

        // write data into the array element
        // Store(tmp.0, array1d.ptr)

        // @formatter:off
        stringBuilder.append(indentString)
            .append("Store(").append(arrayPtrName + ".tmp.0").append(", ")
            .append(arrayPtrName + ".ptr.tmp").append(")")
            .append("\n");
        // @formatter:on
    }

    private String wrapInConstant(String constant) {
        return "Constant(ConstInt(" + constant + "))";
    }

    private void retrieveValueFromArrayElement(int indent, DeclaratorASTNode declaratorASTNode,
            String arrayPtrName, int arrayElementIndex, String destinationVariableName) {

        generateArrayAccessIndexer(indent,
                arrayPtrName,
                wrapInConstant("" + arrayElementIndex),
                destinationVariableName);
    }

    private void retrieveValueFromArrayElementByVariable(int indent, DeclaratorASTNode declaratorASTNode,
            String arrayPtrName, String indexVarName, String destinationVariableName) {
        generateArrayAccessIndexer(indent, arrayPtrName, indexVarName, destinationVariableName);
    }

    private void generateArrayAccessIndexer(int indent, String arrayPtrName, String arrayElementIndex,
            String destinationVariableName) {

        // // WBI
        // TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor =
        // tackyStackFrame.variables
        // .get(arrayPtrName);

        String indentString = buildIndentString(indent);

        // stringBuilder.append("\n");
        stringBuilder.append(indentString)
                .append("// retrieve from array-element").append("\n");

        // determine the size of the array element type and store it into a variable for
        // later use
        stringBuilder.append(indentString).append("sizeof_array_type = Var(\"sizeof_array_type\")")
                .append("\n");
        stringBuilder.append(indentString)
                .append("sizeof(" + TackyDataType.toString(TackyDataType.INT_32) + ", sizeof_array_type)")
                .append("\n");

        defineVariable(indent, arrayPtrName + ".ptr.tmp.1", null);
        stringBuilder.append(indentString)
                .append(arrayPtrName + ".ptr.tmp.1").append(" = ")
                .append(arrayElementIndex).append(" * ").append("sizeof_array_type")
                .append("\n");

        // advance the pointer forward to the requested fifth element
        // to point to element #5, move the pointer four times
        // array1d.ptr = array1d.ptr + 4 * sizeof_int
        defineVariable(indent, arrayPtrName + ".ptr.tmp", null);
        stringBuilder.append(indentString)
                .append(arrayPtrName + ".ptr.tmp").append(" = ")
                .append(arrayPtrName).append(" + ")
                .append(arrayPtrName + ".ptr.tmp.1")
                .append("\n");

        // write data into the array element
        // Store(tmp.0, array1d.ptr)
        stringBuilder.append(indentString).append("Load(")
                .append(arrayPtrName + ".ptr.tmp")
                .append(", ")
                .append(destinationVariableName)
                .append(")")
                .append("\n");
    }

    // Function Declaration

    private void enterFunctionDeclaration(int indent, ASTNode astNode) {

        addScope();

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // astNode.printRecursive(debugStringBuilder, 0);
        // System.out.println("++++++++++++++++++++++++++++++++++++");
        // System.out.println(debugStringBuilder.toString());

        ASTNode child0 = astNode.getChildren().get(0);

        // function name
        String functionName = child0.value.substring(0, child0.value.indexOf("("));

        // global (TODO, this is a hardcoded value!)
        boolean global = true;

        ParametersAndQualifiersASTNode parametersAndQualifiersASTNode = (ParametersAndQualifiersASTNode) child0
                .getChildren().get(1);

        // DEBUG - print all parameters
        // boolean printAllParameters = true;
        boolean printAllParameters = false;
        if (printAllParameters) {
            StringBuilder debugStringBuilder = new StringBuilder();
            parametersAndQualifiersASTNode.printRecursive(debugStringBuilder, 0);
            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println(debugStringBuilder.toString());
        }

        stringBuilder.append("Function(\"").append(functionName).append("\", ");
        stringBuilder.append(global);

        if (parametersAndQualifiersASTNode.children.size() > 0) {

            ParameterDeclarationListASTNode parameterDeclarationList = (ParameterDeclarationListASTNode) parametersAndQualifiersASTNode.children
                    .get(0);

            // formal parameters
            for (ASTNode tempASTNode : parameterDeclarationList.getChildren()) {

                ParameterDeclarationASTNode parameter = (ParameterDeclarationASTNode) tempASTNode;
                ASTNode paramNameASTNode = parameter.children.get(0);
                String paramName = paramNameASTNode.value;
                String paramType = parameter.type;

                stringBuilder.append(", ").append(paramName);

                // TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = new
                // TACKYStackFrameVariableDescriptor();
                // tackyStackFrameVariableDescriptor.name = paramName;
                // tackyStackFrameVariableDescriptor.tackyDataType =
                // TackyDataType.fromString(paramType);
                // tackyStackFrameVariableDescriptor.isPointer = parameter.isPointer;

                // tackyStackFrame.variables.put(paramName, tackyStackFrameVariableDescriptor);

                addVariableToScope(paramName, TackyDataType.fromString(paramType), parameter.isArray,
                        parameter.isPointer);
            }
        }

        stringBuilder.append(", [").append("\n");
    }

    /**
     * <pre>
     * Function("for_loop_test", true, [
     *
     * ])
     * </pre>
     *
     * @param astNode
     */
    private void exitFunctionDeclaration(int indent, ASTNode astNode) {

        stringBuilder.append("])");
        stringBuilder.append("\n");

        // stringBuilder.append("\n");

        stringBuilder.append("\n");

        removeScope();
    }

    // For-Loop

    private void enterForLoop(int indent, StatementASTNode statementASTNode) {
        addScope();
        generateForLoop(indent, statementASTNode);
    }

    private void exitForLoop(int indent, StatementASTNode statementASTNode) {
        removeScope();
    }

    // If

    private void enterIf(int indent, SelectionStatementASTNode selectionStatementASTNode) {

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // selectionStatementASTNode.printRecursive(debugStringBuilder, indent);
        // System.out.println(debugStringBuilder.toString());

        String indentString = buildIndentString(indent);

        String ifSkipLabelName = "if_label_" + ifCounter;
        String ifEvalVarName = "if_eval_" + ifCounter;
        ifCounter++;

        ASTNode child0ASTNode = selectionStatementASTNode.getChildren().get(0);
        ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;

        // start comment
        stringBuilder.append(indentString).append("// if statement").append("\n");

        switch (child0ExpressionASTNode.expressionType) {

            case Primary: {

                String eval0 = evaluateToString(indent, child0ExpressionASTNode);

                defineVariable(indent, ifEvalVarName, null);
                stringBuilder.append(indentString).append(ifEvalVarName).append(" = ").append(eval0).append("\n");

                // RISCV jump if not equal to zero
                // bne x5, x0, not_zero_block

                stringBuilder.append(indentString).append("JumpIfZero(")
                        .append(ifEvalVarName).append(", ")
                        .append(ifSkipLabelName)
                        .append(")")
                        .append("\n");
            }
                break;

            case Equality: {
                // ASTNode child1ASTNode = selectionStatementASTNode.getChildren().get(0);
                // ExpressionASTNode child1ExpressionASTNode = (ExpressionASTNode) child1ASTNode;

                String evalLHS = evaluateToString(indent, (ExpressionASTNode) child0ExpressionASTNode.children.get(0));
                String evalRHS = evaluateToString(indent, (ExpressionASTNode) child0ExpressionASTNode.children.get(1));

                // generate the inverse statement since the jump acts as a guard
                stringBuilder.append(indentString).append("JumpIfNotEqual(")
                        .append(evalLHS).append(", ")
                        .append(evalRHS).append(", ")
                        .append(ifSkipLabelName)
                        .append(")")
                        .append("\n");
            }
                break;

            default:
                throw new RuntimeException("e");
        }

        addScope();

        // output all children

        // body statements

        indentString = buildIndentString(indent + 1);
        stringBuilder.append(indentString).append("// <start body statements>").append("\n");

        // body of the for loop

        for (int i = 1; i < selectionStatementASTNode.getChildren().size(); i++) {

            ASTNode astNodeChild = selectionStatementASTNode.getChildren().get(i);

            // // DEBUG
            // debugStringBuilder = new StringBuilder();
            // astNodeChild.printRecursive(debugStringBuilder, 0);
            // System.out.println(debugStringBuilder.toString());

            process(indent + 1, astNodeChild);
        }

        stringBuilder.append(indentString).append("// <end body statements>").append("\n");

        indentString = buildIndentString(indent);

    }

    private void exitIf(int indent, SelectionStatementASTNode selectionStatementASTNode) {

        String indentString = buildIndentString(indent);

        removeScope();

        // label to jump to in order to skip this if should the condition evaluate to
        // false
        ifCounter--;
        String ifSkipLabelName = "if_label_" + ifCounter;
        stringBuilder.append(indentString).append("// <if skip label> ").append("\n");
        stringBuilder.append(indentString).append("Label(" + ifSkipLabelName + ")").append("\n");
    }

    // Jump

    private void enterBreak(int indent, JumpStatementASTNode jumpStatementASTNode) {
        // System.out.println(jumpStatementASTNode.toString());

        int uniqueForLoopIndex = forLoopCount;
        // int indent = uniqueForLoopIndex;

        String indentString = buildIndentString(indent);

        String breakLabelName = "break_label_" + (uniqueForLoopIndex - 1);

        stringBuilder.append(indentString).append("// break statement").append("\n");
        stringBuilder.append(indentString).append("Jump(").append(breakLabelName).append(")").append("\n");
    }

    private void exitBreak(int indent, JumpStatementASTNode jumpStatementASTNode) {
        ;
    }

    private void enterReturn(int indent, JumpStatementASTNode returnStatementASTNode) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'enterReturn'");

        stringBuilder.append("\n");

        String indentString = buildIndentString(indent);
        stringBuilder.append(indentString);

        ExpressionASTNode returnExpression = (ExpressionASTNode) returnStatementASTNode.children.get(0);
        Object returnValue = evaluate(returnExpression);

        // TODO: implement correct return code 33
        stringBuilder.append("return(");
        if (returnValue instanceof Integer) {
            stringBuilder.append(wrapInConstant(returnValue.toString()));
        } else {
            stringBuilder.append(returnValue);
        }
        stringBuilder.append(")").append("\n");
    }

    private void exitReturn(int indent, JumpStatementASTNode returnStatementASTNode) {
        // nop
    }

    // Unknown

    private void enterUnknown(ASTNode astNode) {
    }

    private void exitUnknown(ASTNode astNode) {
    }

    // Generator Code

    // Main Entry Point

    public void outputMainEntryPoint(String data) {
        stringBuilder.append("Program(\"" + data + "\")").append("\n");
        stringBuilder.append("\n");
    }

    // For Loop

    private void generateForLoop(int indent, StatementASTNode statementASTNode) {

        int uniqueForLoopIndex = forLoopCount;
        forLoopCount++;

        String indentString = buildIndentString(indent);

        String startLabelName = "start_" + uniqueForLoopIndex;
        String breakLabelName = "break_label_" + uniqueForLoopIndex;
        String continueLabelName = "continue_label_" + uniqueForLoopIndex;

        String tmp0Name = "tmp.0." + uniqueForLoopIndex;
        String tmp1Name = "tmp.1." + uniqueForLoopIndex;

        stringBuilder.append(indentString).append("//").append("\n");
        stringBuilder.append(indentString).append("// Loop " + uniqueForLoopIndex).append("\n");
        stringBuilder.append(indentString).append("//").append("\n");

        // loop variable declaration + initialization

        ASTNode astNode0 = statementASTNode.getChildren().get(0);
        SimpleDeclarationASTNode simpleDeclarationASTNode = (SimpleDeclarationASTNode) astNode0;

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // simpleDeclarationASTNode.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        // TODO: Declare temp variables outside the loop so that the declaration
        // is not executed several times in the loop which causes an error
        // in the execution engine

        defineVariable(indent, tmp0Name, TackyDataType.INT_32);
        defineVariable(indent, tmp1Name, TackyDataType.INT_32);

        stringBuilder.append(indentString).append("// <instructions for init>").append("\n");
        process(indent, simpleDeclarationASTNode);
        // i = Var("i")
        // i = Constant(ConstInt(0))

        // Label(start)
        stringBuilder.append(indentString).append("Label(").append(startLabelName).append(")").append("\n");

        // loop condition expression

        ASTNode astNode1 = statementASTNode.getChildren().get(1);
        ExpressionASTNode expressionASTNode = (ExpressionASTNode) astNode1;

        // // DEBUG
        // debugStringBuilder = new StringBuilder();
        // astNode1.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        stringBuilder.append(indentString).append("// <instructions for condition>").append("\n");

        if (generateDefaultLoopConditionExpression) {

            // expression + temp variable
            stringBuilder.append(indentString).append(tmp0Name).append(" = ");
            stringBuilder.append(outputExpression(expressionASTNode)).append("\n");

            // JumpIfZero(tmp.0, break_label)
            stringBuilder.append(indentString).append("JumpIfZero(").append(tmp0Name)
                    .append(", " + breakLabelName + ")")
                    .append("\n");

        } else {

            switch (expressionASTNode.expressionType) {

                case LessThen: {
                    String lhs = evaluate((ExpressionASTNode) expressionASTNode.children.get(0)).toString();
                    String rhs = evaluate((ExpressionASTNode) expressionASTNode.children.get(1)).toString();

                    stringBuilder.append(indentString);
                    stringBuilder.append("JumpGreaterThanOrEqual").append("(")
                            .append(lhs).append(", ")
                            .append(rhs).append(", ")
                            .append(breakLabelName).append(")").append("\n");
                }
                    break;

                default:
                    throw new RuntimeException();
            }

        }

        // body statements

        indentString = buildIndentString(indent + 1);
        stringBuilder.append(indentString).append("// <start body statements>").append("\n");

        // body of the for loop

        for (int i = 3; i < statementASTNode.getChildren().size(); i++) {

            ASTNode astNodeChild = statementASTNode.getChildren().get(i);

            // // DEBUG
            // debugStringBuilder = new StringBuilder();
            // astNodeChild.printRecursive(debugStringBuilder, 0);
            // System.out.println(debugStringBuilder.toString());

            process(indent + 1, astNodeChild);
        }

        stringBuilder.append(indentString).append("// <end body statements>").append("\n");

        indentString = buildIndentString(indent);

        // continue label

        stringBuilder.append(indentString).append("// <continue label> ").append("\n");
        stringBuilder.append(indentString).append("Label(" + continueLabelName + ")").append("\n");

        // loop postfix

        ASTNode astNode2 = statementASTNode.getChildren().get(2);
        // ExpressionASTNode postFixExpressionASTNode = (ExpressionASTNode) astNode2;

        // // DEBUG
        // debugStringBuilder = new StringBuilder();
        // astNode2.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        // <instructions for post>

        stringBuilder.append(indentString).append("// <instructions for post>").append("\n");

        // Declare temp variable
        // tmp.1 = i + Constant(ConstInt(1))
        // stringBuilder.append("tmp.1 = Var(\"tmp.1\")").append("\n");
        stringBuilder.append(indentString).append(tmp1Name).append(" = ");
        expressionASTNode = (ExpressionASTNode) astNode2;

        String expr = outputExpression(expressionASTNode);
        stringBuilder.append(expr).append("\n");

        // i = tmp.1
        String iteratorVariable = expressionASTNode.children.get(0).value;
        stringBuilder.append(indentString).append(iteratorVariable).append(" = ").append(tmp1Name).append("\n");

        // start the next iteration of the loop
        stringBuilder.append(indentString).append("Jump(" + startLabelName + ")").append("\n");

        // end label
        stringBuilder.append(indentString).append("Label(" + breakLabelName + ")").append("\n");

        // forLoopCount--;
    }

    private void defineVariable(int indent, String name, TackyDataType tackyDataType) {
        defineVariable(indent, name, tackyDataType, false, 0);
    }

    private void defineVariable(int indent, String name, TackyDataType tackyDataType,
            boolean isArray, int arraySize) {

        String indentString = buildIndentString(indent);
        stringBuilder.append(indentString);

        // DEBUG
        // if (indentString == "") {
        // System.out.println("temp");
        // }

        if (isArray) {

            // if (indentString == "") {
            // System.out.println("temp");
            // }

            // stringBuilder.append("zzz" + indentString);

            // array1d = Var("array1d", Array(int, 5));
            stringBuilder.append(name + " = Var(\"" + name + "\", Array(" + TackyDataType.toString(tackyDataType) + ", "
                    + arraySize + "))");
            addVariableToScope(name, tackyDataType, isArray, false);

        } else {

            stringBuilder.append(name + " = Var(\"" + name + "\")");
            addVariableToScope(name, tackyDataType, isArray, false);

        }
        stringBuilder.append("\n");
    }

    private String outputExpression(ExpressionASTNode expressionASTNode) {

        // System.out.println(expressionASTNode);

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // expressionASTNode.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        StringBuilder tempStringBuilder = new StringBuilder();

        if (expressionASTNode.type.equalsIgnoreCase("REL")) {

            tempStringBuilder.append(expressionASTNode.children.get(0).value);
            switch (expressionASTNode.expressionType) {
                case LessThen:
                    tempStringBuilder.append(" < ");
                    break;
                default:
                    throw new RuntimeException();
            }
            tempStringBuilder.append(expressionASTNode.children.get(1).value);

            return tempStringBuilder.toString();

        } else if (expressionASTNode.type.equalsIgnoreCase("UNARY")) {

            // System.out.println("");

            tempStringBuilder.append(expressionASTNode.children.get(0).value);
            switch (expressionASTNode.expressionType) {

                case UnaryIncrement:
                    tempStringBuilder.append(" + Constant(ConstInt(1))");
                    break;

                case ArrayIndexing:
                    tempStringBuilder.append(" + Constant(ConstInt(1))");
                    break;

                default:
                    throw new RuntimeException();
            }

            return tempStringBuilder.toString();

        }

        throw new RuntimeException();
    }

    private Object evaluate(ExpressionASTNode expr) {

        if (expr.children.size() == 0) {

            if (NumberUtils.isParsable(expr.value)) {

                return Integer.parseInt(expr.value);
                // return wrapInConstant(expr.value);

            } else {

                // retrieve local variable
                return expr.value;
            }

        } else if (expr.children.size() == 2) {

            ExpressionASTNode exprA = (ExpressionASTNode) expr.children.get(0);
            ExpressionASTNode exprB = (ExpressionASTNode) expr.children.get(1);

            boolean exprAIsParseable = NumberUtils.isParsable(exprA.value);
            boolean exprBIsParseable = NumberUtils.isParsable(exprB.value);

            if (exprAIsParseable && exprBIsParseable) {

                int a = (int) evaluate(exprA);
                int b = (int) evaluate(exprB);

                switch (expr.expressionType) {

                    case Add:
                        return a + b;

                    case Subtract:
                        return a - b;

                    case Mul:
                        return a * b;

                    case Div:
                        return a / b;

                    default:
                        throw new RuntimeException("Unknown expression type: " + expr.expressionType);
                }

            } else {

                switch (expr.expressionType) {

                    case Add:
                        return exprA.value + " + " + exprB.value;

                    case Subtract:
                        return exprA.value + " - " + exprB.value;

                    case Mul:
                        return exprA.value + " * " + exprB.value;

                    case Div:
                        return exprA.value + " / " + exprB.value;

                    default:
                        throw new RuntimeException("Unknown expression type: " + expr.expressionType);
                }

            }
        }

        throw new RuntimeException();
    }

    private String evaluateToString(int indent, ExpressionASTNode expressionASTNode) {

        String indentString = buildIndentString(indent);

        StringBuilder exprStringBuilder = new StringBuilder();
        String lhs = "";
        String rhs = "";

        String operator = "";
        switch (expressionASTNode.expressionType) {
            case Add:
                operator = " + ";
                break;
            case Subtract:
                operator = " - ";
                break;
            case Mul:
                operator = " * ";
                break;
            case Div:
                operator = " / ";
                break;
            case Equality:
                operator = " == ";
                break;

            default:
                // throw new RuntimeException();
                // do not select an operator
                break;
        }

        switch (expressionASTNode.expressionType) {

            case Primary:
                exprStringBuilder.append("Constant(").append("ConstInt(").append(expressionASTNode.value).append("))");
                return exprStringBuilder.toString();

            case CharacterLiteral:
                exprStringBuilder.append("Constant(").append("ConstChar(").append(expressionASTNode.value).append("))");
                return exprStringBuilder.toString();

            case Add:
            case Subtract:
            case Mul:
            case Div:
            case Equality:
                lhs = evaluateToString(indent, (ExpressionASTNode) expressionASTNode.children.get(0));
                rhs = evaluateToString(indent, (ExpressionASTNode) expressionASTNode.children.get(1));

                String tempVarName = "exprTemp_" + tempCounter;
                tempCounter++;

                defineVariable(indent, tempVarName, null);
                exprStringBuilder.append(indentString)
                        .append(tempVarName).append(" = ").append(lhs).append(operator).append(rhs);
                stringBuilder.append(exprStringBuilder.toString()).append("\n");
                return tempVarName;

            case Identifier:
                return expressionASTNode.value;

            default:
                throw new RuntimeException();
        }
    }

    private String buildIndentString(int indent) {
        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "    ";
        }
        return indentString;
    }

}
