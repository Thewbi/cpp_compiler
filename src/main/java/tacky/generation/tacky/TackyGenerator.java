package tacky.generation.tacky;

import java.util.Stack;

import org.apache.commons.lang3.math.NumberUtils;

import ast.ASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.ParameterDeclarationASTNode;
import ast.ParameterDeclarationListASTNode;
import ast.ParametersAndQualifiersASTNode;
import ast.SimpleDeclarationASTNode;
import ast.StatementASTNode;
import tacky.runtime.TACKYStackFrame;
import tacky.runtime.TACKYStackFrameVariableDescriptor;

public class TackyGenerator {

    public StringBuilder stringBuilder = new StringBuilder();

    private int forLoopCount = 0;

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public TACKYStackFrame tackyStackFrame;

    private int tempCounter = 0;

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
                enterFunctionDeclaration(astNode);
                for (ASTNode child : astNode.children) {
                    process(indent, child);
                }
                exitFunctionDeclaration(indent + 1, astNode);
                break;

            case FUNCTION_CALL:
                enterFunctionCall(indent, (DeclaratorASTNode) astNode);
                exitFunctionCall(indent, (DeclaratorASTNode) astNode);
                break;

            case ITERATION_STATEMENT:
                System.out.println("");

                StatementASTNode statementASTNode = (StatementASTNode) astNode;
                switch (statementASTNode.statementType) {
                    case FOR:
                        enterForLoop(statementASTNode);
                        // the children of the FOR loop are visited within enterForLoop()
                        exitForLoop(statementASTNode);
                        break;

                    default:
                        enterUnknown(astNode);
                        for (ASTNode child : astNode.children) {
                            process(indent + 1, child);
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

            // case EXPRESSION:
            // System.out.println("");
            // break;

            default:
                System.out.println("Unknown type: \"" + astNode.astNodeType + "\" ");
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

    private void addVariableToScope(String name, TackyDataType tackyDataType, boolean isArray) {

        TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = new TACKYStackFrameVariableDescriptor();
        tackyStackFrameVariableDescriptor.name = name;
        tackyStackFrameVariableDescriptor.tackyDataType = tackyDataType;
        tackyStackFrameVariableDescriptor.isArray = isArray;

        tackyStackFrame.variables.put(name, tackyStackFrameVariableDescriptor);
    }

    // Declarations

    private void enterFunctionCall(int indent, DeclaratorASTNode astNode) {

        stringBuilder.append("\n");

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

        String calledFunctionName = astNode.value.substring(0, astNode.value.indexOf("("));

        if (calledFunctionName.equalsIgnoreCase("printf")) {

            // special treatment for printf()
            // stringBuilder.append("printf(\"test\")");
            // stringBuilder.append(astNode.value).append("\n");
            processFunctionCall(indent, astNode);

        } else {

            // Create a variable to store the functions return value
            // tmp.0 = Var("tmp.0")
            String returnValueVariableName = "tmp." + calledFunctionName;
            defineVariable(indent, returnValueVariableName, TackyDataType.INT_8);

            // Determine if a parameter requires a pointer variable

            // actual parameters
            for (int i = 1; i < astNode.children.size(); i++) {

                ASTNode param = astNode.children.get(i);
                // System.out.println(param);

                if (param instanceof ExpressionASTNode) {

                    ExpressionASTNode expr = (ExpressionASTNode) param;
                    switch (expr.expressionType) {

                        // case Primary:
                        // stringBuilder.append(",
                        // Constant(ConstInt(").append(param.value).append("))");
                        // break;

                        case Identifier:
                            TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = tackyStackFrame.variables
                                    .get(param.value);

                            // check if the identifier is an array
                            if (tackyStackFrameVariableDescriptor.isArray) {

                                stringBuilder.append("// parameter for function call").append("\n");

                                // tmp.1.ptr = Var("tmp.1.ptr") // address: 8
                                defineVariable(0, "tmp.1.ptr", TackyDataType.INT_32);
                                addVariableToScope("tmp.1.ptr", TackyDataType.INT_32, false);

                                // store an address into the pointer
                                // GetAddress(tmp.1, tmp.1.ptr)
                                stringBuilder.append(indentString).append("GetAddress(")
                                        .append(param.value).append(", ").append("tmp.1.ptr").append(")");
                                stringBuilder.append("\n");

                            }
                            break;

                        default:
                            break;
                    }
                }
            }

            // // Function Call
            // // provide actual parameters for both arguments
            // // provide a parameter for the return value
            // funccall(test_function, false, Constant(ConstInt(2)), Constant(ConstInt(3)),
            // tmp.0)

            stringBuilder.append(indentString).append("funccall(").append(calledFunctionName).append(", false");

            // actual parameters
            for (int i = 1; i < astNode.children.size(); i++) {

                ASTNode param = astNode.children.get(i);
                // System.out.println(param);

                if (param instanceof ExpressionASTNode) {

                    ExpressionASTNode expr = (ExpressionASTNode) param;
                    switch (expr.expressionType) {

                        case Primary:
                            stringBuilder.append(", Constant(ConstInt(").append(param.value).append("))");
                            break;

                        case StringLiteral:
                            stringBuilder.append(", Constant(ConstString(").append(param.value).append("))");
                            break;

                        case Identifier:

                            TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor = tackyStackFrame.variables
                                    .get(param.value);

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
                                stringBuilder.append(indentString).append(", tmp.1.ptr");

                            } else {
                                throw new RuntimeException();
                            }

                            break;

                        default:
                            throw new RuntimeException();
                    }

                } else {
                    throw new RuntimeException();
                }

            }

            // return variable
            stringBuilder.append(", ").append(returnValueVariableName).append(")").append("\n");
        }
    }

    private void exitFunctionCall(int indent, DeclaratorASTNode astNode) {
        ;
    }

    private void enterSimpleDeclaration(int indent, SimpleDeclarationASTNode simpleDeclarationASTNode) {
        // System.out.println();
        for (ASTNode astNode : simpleDeclarationASTNode.children) {
            process(indent, astNode);
        }
    }

    private void exitSimpleDeclaration(SimpleDeclarationASTNode simpleDeclarationASTNode) {
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

    private void processFunctionCall(int indent, DeclaratorASTNode declaratorASTNode) {

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

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
        }
    }

    private void processVariableDeclaration(int indent, DeclaratorASTNode declaratorASTNode) {

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

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
                ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;
            } else {
                throw new RuntimeException("type");
            }

            ASTNode child1ASTNode = declaratorASTNode.children.get(1);

            String name = child0ASTNode.value;

            ExpressionASTNode assignedValueExpression = (ExpressionASTNode) declaratorASTNode.children.get(1);

            if (isArray) {

                // create a variable for the array. Define the array as a variable

                defineVariable(0, name, TackyDataType.INT_32, isArray, arraySize);

                // sizeof
                //sizeof_int = Var("sizeof_int")
                //sizeof(int8, sizeof_int)

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
                defineVariable(0, name + ".ptr", TackyDataType.INT_32);
                // GetAddress(array1d, array1d.ptr)
                stringBuilder.append(indentString).append("GetAddress(" + name + ", " + name + ".ptr)").append("\n");

                // temp variable for loading data into the array
                // tmp.0 = Var("tmp.0")
                defineVariable(0, name + ".tmp.0", TackyDataType.INT_32);

                int index = 0;
                for (int i = 1; i < declaratorASTNode.children.size(); i++) {

                    String tempValue = declaratorASTNode.children.get(i).value;
                    assignValueToArrayElement(indent + 1, declaratorASTNode, name, index, tempValue);

                    index++;

                }

            } else if (isFunctionCall) {

                throw new RuntimeException();

            } else if (assignedValueExpression.expressionType == ExpressionType.ArrayIndexing) {

                System.out.println("ArrayIndexing");

                stringBuilder.append("\n");

                ASTNode c1 = assignedValueExpression.children.get(1);

                // int arrayIndex = 0;
                // if (NumberUtils.isParsable(c1.value)) {
                // arrayIndex = Integer.parseInt(c1.value);
                // } else {
                // System.out.println();
                // arrayIndex = (int) evaluate((ExpressionASTNode) c1);
                // }

                // DEBUG
                System.out.println(tackyStackFrame.variables.size());

                String arrayName = child1ASTNode.value;

                String destinationVariableName = child0ASTNode.value;
                defineVariable(indent + 1, destinationVariableName, null);

                if (NumberUtils.isParsable(c1.value)) {
                    int arrayIndex = (int) evaluate((ExpressionASTNode) c1);
                    retrieveValueFromArrayElement(indent + 1, declaratorASTNode, arrayName, arrayIndex,
                            destinationVariableName);
                } else {
                    // throw new RuntimeException("Need indexing by variable!");
                    retrieveValueFromArrayElementByVariable(indent + 1, declaratorASTNode, arrayName, c1.value,
                            destinationVariableName);
                }

            } else {

                addVariableToScope(name, TackyDataType.fromString(type), isArray);

                // Object assignedValue = evaluate(assignedValueExpression);
                String exprAsString = evaluateToString(indent, assignedValueExpression);

                System.out.println("Declaration. type=" + type + ", name=" + name + ", isArray=" + isArray
                        + ", assignedValue=" + exprAsString);

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
                        //.append("Constant(").append("ConstInt(")
                        // .append(assignedValue)
                        .append(exprAsString)
                        //.append("))")
                        .append("\n");
                    // @formatter:on

            }

        } else {

            // existing variable is initialized

            boolean isArray = false;
            int index = 0;

            ASTNode child0ASTNode = declaratorASTNode.children.get(0);
            if (child0ASTNode instanceof DeclaratorASTNode) {

                DeclaratorASTNode child0 = (DeclaratorASTNode) child0ASTNode;
                isArray = child0.isArray;
                index = (int) evaluate(child0.indexExpression);

                String name = child0ASTNode.value;

                Object assignedValue = evaluate((ExpressionASTNode) declaratorASTNode.children.get(1));

                System.out.println("Assignment. name=" + name + ", isArray=" + isArray + ", index=" + index
                        + ", assignedValue=" + assignedValue);

                assignValueToArrayElement(indent + 1, declaratorASTNode, name, index, assignedValue.toString());

            } else if (child0ASTNode instanceof ExpressionASTNode) {

                ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;
                System.out.println();

                ASTNode child1ASTNode = declaratorASTNode.children.get(1);

                stringBuilder.append(child0ExpressionASTNode.value).append("(").append(child1ASTNode.value).append(")")
                        .append("\n");

            } else {

                throw new RuntimeException("type");

            }

        }
    }

    private void assignValueToArrayElement(int indent, DeclaratorASTNode declaratorASTNode, String arrayName,
            int arrayElementIndex,
            String value) {

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

        stringBuilder.append("\n");
        stringBuilder.append(indentString).append("// assign to array-element").append("\n");

        // advance the pointer forward to the requested n-th element
        // to point to element #n, move the pointer four times
        //
        // array1d.ptr = array1d.ptr + (n-1) * sizeof_int
        defineVariable(indent, arrayName + ".ptr.tmp", null);
        stringBuilder.append(indentString)
                .append(arrayName + ".ptr.tmp").append(" = ")
                .append(arrayName + ".ptr").append(" + ")
                .append(arrayElementIndex).append(" * sizeof_array_type")
                .append("\n");

        // write data into the array element
        // tmp.0 = 18
        stringBuilder.append(indentString).append(arrayName + ".tmp.0").append(" = ").append(value).append("\n");

        // write data into the array element
        // Store(tmp.0, array1d.ptr)
        stringBuilder.append(indentString).append("Store(").append(arrayName + ".tmp.0").append(", ")
                .append(arrayName + ".ptr.tmp").append(")")
                .append("\n");
    }

    private void retrieveValueFromArrayElement(int indent, DeclaratorASTNode declaratorASTNode,
            String arrayName, int arrayElementIndex, String destinationVariableName) {
        generateArrayAccessIndexer(indent, arrayName, "" + arrayElementIndex, destinationVariableName);
    }

    private void retrieveValueFromArrayElementByVariable(int indent, DeclaratorASTNode declaratorASTNode,
            String arrayName, String indexVarName, String destinationVariableName) {
        generateArrayAccessIndexer(indent, arrayName, indexVarName, destinationVariableName);
    }

    private void generateArrayAccessIndexer(int indent, String arrayName, String arrayElementIndex,
            String destinationVariableName) {

                // WBI
        TACKYStackFrameVariableDescriptor tackyStackFrameVariableDescriptor 
            = tackyStackFrame.variables.get(arrayName);

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

        stringBuilder.append("\n");
        stringBuilder.append(indentString)
                .append("// retrieve from array-element").append("\n");

        // determine the size of the array element type and store it into a variable for
        // later use
        stringBuilder.append(indentString).append("sizeof_array_type = Var(\"sizeof_array_type\")")
                .append("\n");
        stringBuilder.append(indentString)
                .append("sizeof(" + TackyDataType.toString(TackyDataType.INT_32) + ", sizeof_array_type)")
                .append("\n");

        // advance the pointer forward to the requested fifth element
        // to point to element #5, move the pointer four times
        // array1d.ptr = array1d.ptr + 4 * sizeof_int
        defineVariable(indent, arrayName + ".ptr.tmp", null);
        stringBuilder.append(indentString)
                .append(arrayName + ".ptr.tmp").append(" = ")
                // .append(arrayName + ".ptr").append(" + ")
                .append(arrayName).append(" + ")
                //.append(arrayElementIndex).append(" * sizeof_array_type")
                .append(arrayElementIndex).append(" * sizeof_array_type")
                .append("\n");

        // // write data into the array element
        // // tmp.0 = 18
        // stringBuilder.append(arrayName + ".tmp.0").append(" =
        // ").append(value).append("\n");

        // write data into the array element
        // Store(tmp.0, array1d.ptr)
        stringBuilder.append(indentString).append("Load(")
                .append(arrayName + ".ptr.tmp")
                .append(", ")
                .append(destinationVariableName)
                .append(")")
                .append("\n");
    }

    private void exitInitDeclaration(DeclaratorASTNode declaratorASTNode) {
        System.out.println(declaratorASTNode);
    }

    // Function Declaration

    private void enterFunctionDeclaration(ASTNode astNode) {

        addScope();

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // astNode.printRecursive(debugStringBuilder, 0);
        // System.out.println("++++++++++++++++++++++++++++++++++++");
        // System.out.println(debugStringBuilder.toString());

        ASTNode child0 = astNode.getChildren().get(0);
        String functionName = child0.value.substring(0, child0.value.indexOf("("));
        boolean global = true;

        ParametersAndQualifiersASTNode parametersAndQualifiersASTNode = (ParametersAndQualifiersASTNode) child0
                .getChildren().get(1);

        // DEBUG
        StringBuilder debugStringBuilder = new StringBuilder();
        parametersAndQualifiersASTNode.printRecursive(debugStringBuilder, 0);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println(debugStringBuilder.toString());

        stringBuilder.append("Function(\"").append(functionName).append("\", ");
        stringBuilder.append(global);

        if (parametersAndQualifiersASTNode.children.size() > 0) {
            ParameterDeclarationListASTNode parameterDeclarationList = (ParameterDeclarationListASTNode) parametersAndQualifiersASTNode.children
                    .get(0);

            // formal parameters
            for (ASTNode tempASTNode : parameterDeclarationList.getChildren()) {

                ParameterDeclarationASTNode parameter = (ParameterDeclarationASTNode) tempASTNode;
                ASTNode paramName = parameter.children.get(0);
                String paramType = parameter.type;

                stringBuilder.append(", ").append(paramName.value);
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

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

        stringBuilder.append("\n");

        stringBuilder.append(indentString);

        // TODO: implement correct return code
        stringBuilder.append("return(Constant(ConstInt(0)))").append("\n");

        stringBuilder.append("])");

        stringBuilder.append("\n\n");

        removeScope();
    }

    // For-Loop

    private void enterForLoop(StatementASTNode statementASTNode) {
        addScope();
        generateForLoop(statementASTNode);
    }

    private void exitForLoop(StatementASTNode statementASTNode) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'exitForLoop'");
        removeScope();
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
    }

    // For Loop

    private void generateForLoop(StatementASTNode statementASTNode) {

        int uniqueForLoopIndex = forLoopCount;
        forLoopCount++;

        int indent = uniqueForLoopIndex;

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

        String startLabelName = "start_" + uniqueForLoopIndex;
        String breakLabelName = "break_label_" + uniqueForLoopIndex;
        String continueLabelName = "continue_label_" + uniqueForLoopIndex;

        String tmp0Name = "tmp.0." + uniqueForLoopIndex;
        String tmp1Name = "tmp.1." + uniqueForLoopIndex;

        stringBuilder.append(indentString).append("//").append("\n");
        stringBuilder.append(indentString).append("// Loop " + uniqueForLoopIndex).append("\n");
        stringBuilder.append(indentString).append("//").append("\n");

        //
        // loop variable declaration + initialization
        //

        ASTNode astNode0 = statementASTNode.getChildren().get(0);
        SimpleDeclarationASTNode simpleDeclarationASTNode = (SimpleDeclarationASTNode) astNode0;

        // // DEBUG
        // StringBuilder debugStringBuilder = new StringBuilder();
        // simpleDeclarationASTNode.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        // Declare temp variables outside the loop so that the declaration
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

        //
        // loop condition expression
        //

        ASTNode astNode1 = statementASTNode.getChildren().get(1);
        ExpressionASTNode expressionASTNode = (ExpressionASTNode) astNode1;

        // // DEBUG
        // debugStringBuilder = new StringBuilder();
        // astNode1.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        stringBuilder.append(indentString).append("// <instructions for condition>").append("\n");
        // stringBuilder.append("tmp.0 = Var(\"tmp.0\")").append("\n");
        stringBuilder.append(indentString).append(tmp0Name).append(" = ");
        stringBuilder.append(indentString).append(outputExpression(expressionASTNode)).append("\n");
        // JumpIfZero(tmp.0, break_label)
        stringBuilder.append(indentString).append("JumpIfZero(").append(tmp0Name).append(", " + breakLabelName + ")")
                .append("\n");

        //
        // body statements
        //

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

        //
        // Continue Label
        //

        stringBuilder.append(indentString).append("// <continue label> ").append("\n");
        stringBuilder.append(indentString).append("Label(" + continueLabelName + ")").append("\n");

        //
        // loop postfix
        //

        ASTNode astNode2 = statementASTNode.getChildren().get(2);
        // ExpressionASTNode postFixExpressionASTNode = (ExpressionASTNode) astNode2;

        // // DEBUG
        // debugStringBuilder = new StringBuilder();
        // astNode2.printRecursive(debugStringBuilder, 0);
        // System.out.println(debugStringBuilder.toString());

        //
        // <instructions for post>
        //

        stringBuilder.append(indentString).append("// <instructions for post>").append("\n");

        // Declare temp variable
        // tmp.1 = i + Constant(ConstInt(1))
        // stringBuilder.append("tmp.1 = Var(\"tmp.1\")").append("\n");
        stringBuilder.append(indentString).append(tmp1Name).append(" = ");
        expressionASTNode = (ExpressionASTNode) astNode2;

        String expr = outputExpression(expressionASTNode);
        String iteratorVariable = expressionASTNode.children.get(0).value;
        stringBuilder.append(indentString).append(expr).append("\n");

        // i = tmp.1
        stringBuilder.append(indentString).append(iteratorVariable).append(" = ").append(tmp1Name).append("\n");

        // start the next iteration of the loop
        stringBuilder.append(indentString).append("Jump(" + startLabelName + ")").append("\n");

        // end label
        stringBuilder.append(indentString).append("Label(" + breakLabelName + ")").append("\n");
    }

    private void defineVariable(int indent, String name, TackyDataType tackyDataType) {
        defineVariable(indent, name, tackyDataType, false, 0);
    }

    private void defineVariable(int indent, String name, TackyDataType tackyDataType,
            boolean isArray, int arraySize) {

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }
        stringBuilder.append(indentString);

        if (isArray) {

            // array1d = Var("array1d", Array(int, 5));
            stringBuilder.append(name + " = Var(\"" + name + "\", Array(" + TackyDataType.toString(tackyDataType) + ", "
                    + arraySize + "))");
            addVariableToScope(name, tackyDataType, isArray);

        } else {

            stringBuilder.append(name + " = Var(\"" + name + "\")");
            addVariableToScope(name, tackyDataType, isArray);

        }
        stringBuilder.append("\n");
    }

    private String outputExpression(ExpressionASTNode expressionASTNode) {

        System.out.println(expressionASTNode);

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

            System.out.println("");

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
            } else {
                // retrieve local variable
                return expr.value;

                // TACKYStackFrameVariableDescriptor varDesc =
                // tackyStackFrame.variables.get(expr.value);
                // memory[varDesc.address / 4];
            }
        } else if (expr.children.size() == 2) {
            switch (expr.expressionType) {

                case Add:
                    return (int) evaluate((ExpressionASTNode) expr.children.get(0))
                            + (int) evaluate((ExpressionASTNode) expr.children.get(1));

                default:
                    throw new RuntimeException();
            }
        }

        throw new RuntimeException();
    }

    private String evaluateToString(int indent, ExpressionASTNode expressionASTNode) {

        // System.out.println();

        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString += "  ";
        }

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
        }

        switch (expressionASTNode.expressionType) {

            case Primary:
                exprStringBuilder.append("Constant(").append("ConstInt(").append(expressionASTNode.value).append("))");
                return exprStringBuilder.toString();

            case Add:
            case Subtract:
            case Mul:
            case Div:

                lhs = evaluateToString(indent, (ExpressionASTNode) expressionASTNode.children.get(0));
                rhs = evaluateToString(indent, (ExpressionASTNode) expressionASTNode.children.get(1));

                String tempVarName = "exprTemp_" + tempCounter;
                tempCounter++;

                defineVariable(indent + 1, tempVarName, null);
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
}
