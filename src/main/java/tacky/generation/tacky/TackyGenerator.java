package tacky.generation.tacky;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.math.NumberUtils;

import ast.ASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.SimpleDeclarationASTNode;
import ast.StatementASTNode;

public class TackyGenerator {

    public StringBuilder stringBuilder = new StringBuilder();

    public void process(ASTNode astNode) {

        switch (astNode.astNodeType) {

            case ROOT:
                for (ASTNode childNode : astNode.children) {
                    process(childNode);
                }
                break;

            case FUNCTION_DECLARATION:
                enterFunctionDeclaration(astNode);
                for (ASTNode child : astNode.children) {
                    process(child);
                }
                exitFunctionDeclaration(astNode);
                break;

            case ITERATION_STATEMENT:
                System.out.println("");

                StatementASTNode statementASTNode = (StatementASTNode) astNode;
                switch (statementASTNode.statementType) {
                    case FOR:
                        enterForLoop(statementASTNode);
                        // the children of the FOR loop are visited within enterForLoop()
                        // for (ASTNode child : astNode.children) {
                        //     process(child);
                        // }
                        exitForLoop(statementASTNode);
                        break;

                    default:
                        enterUnknown(astNode);
                        for (ASTNode child : astNode.children) {
                            process(child);
                        }
                        exitUnknown(astNode);
                        break;
                }
                break;

            case SIMPLE_DECLARATION:
                SimpleDeclarationASTNode simpleDeclarationASTNode = (SimpleDeclarationASTNode) astNode;
                enterSimpleDeclaration(simpleDeclarationASTNode);
                exitSimpleDeclaration(simpleDeclarationASTNode);
                break;

            case INIT_DECLARATION:
                DeclaratorASTNode declaratorASTNode = (DeclaratorASTNode) astNode;
                enterInitDeclaration(declaratorASTNode);
                exitInitDeclaration(declaratorASTNode);
                break;

            // case EXPRESSION:
            //     System.out.println("");
            //     break;

            default:
                System.out.println("Unknown type: \"" + astNode.astNodeType + "\" ");
                enterUnknown(astNode);
                for (ASTNode child : astNode.children) {
                    process(child);
                }
                exitUnknown(astNode);
                return;
        }

    }

    //
    // Declarations
    //

    private void enterSimpleDeclaration(SimpleDeclarationASTNode simpleDeclarationASTNode) {
        System.out.println();
        for (ASTNode astNode : simpleDeclarationASTNode.children) {
            process(astNode);
        }
    }

    private void exitSimpleDeclaration(SimpleDeclarationASTNode simpleDeclarationASTNode) {
    }

    private void enterInitDeclaration(DeclaratorASTNode declaratorASTNode) {
        System.out.println(declaratorASTNode);

        // DEBUG
        StringBuilder debugStringBuilder = new StringBuilder();
        declaratorASTNode.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());

        // retrieve type from parent
        SimpleDeclarationASTNode parent = (SimpleDeclarationASTNode) declaratorASTNode.parent;

        // determine if this is a variable declaration or not
        if (parent.type != null) {

            // declaration of new variable (possibly with initialization)

            String type = parent.type;

            boolean isArray = false;

            ASTNode child0ASTNode = declaratorASTNode.children.get(0);
            if (child0ASTNode instanceof DeclaratorASTNode) {
                DeclaratorASTNode child0 = (DeclaratorASTNode) child0ASTNode;
                isArray = child0.isArray;
            } else if (child0ASTNode instanceof ExpressionASTNode) {
                ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;
            } else {
                throw new RuntimeException("type");
            }

            String name = child0ASTNode.value;

            Object assignedValue = evaluate((ExpressionASTNode) declaratorASTNode.children.get(1));

            System.out.println("Declaration. type=" + type + ", name=" + name + ", isArray=" + isArray
                    + ", assignedValue=" + assignedValue);

            if (isArray) {

            } else {
                //i = Var("i")
                stringBuilder.append(name).append(" = Var(").append("\"").append(name).append("\")").append("\n");

                if (type.equalsIgnoreCase("int")) {
                    //i = Constant(ConstInt(0))
                    stringBuilder.append(name).append(" = Constant(").append("ConstInt(").append(assignedValue).append("))").append("\n");
                }
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
            } else if (child0ASTNode instanceof ExpressionASTNode) {
                ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0ASTNode;
                System.out.println();

                ASTNode child1ASTNode = declaratorASTNode.children.get(1);

                stringBuilder.append(child0ExpressionASTNode.value).append("(").append(child1ASTNode.value).append(")").append("\n");
            } else {
                throw new RuntimeException("type");
            }
            
            String name = child0ASTNode.value;

            Object assignedValue = evaluate((ExpressionASTNode) declaratorASTNode.children.get(1));

            System.out.println("Assignment. name=" + name + ", isArray=" + isArray + ", index=" + index
                    + ", assignedValue=" + assignedValue);
        }

    }

    private Object evaluate(ExpressionASTNode expr) {
        if (expr.children.size() == 0) {

            if (NumberUtils.isParsable(expr.value)) {
                return Integer.parseInt(expr.value);
            } else {
                return expr.value;
            }
            
        }
        throw new RuntimeException();
    }

    private void exitInitDeclaration(DeclaratorASTNode declaratorASTNode) {
        System.out.println(declaratorASTNode);
    }

    //
    // Function Declaration
    //

    private void enterFunctionDeclaration(ASTNode astNode) {
        ASTNode child0 = astNode.getChildren().get(0);
        String functionName = child0.value.substring(0, child0.value.indexOf("("));

        stringBuilder.append("Function(\"").append(functionName).append("\", true, [").append("\n");

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
    private void exitFunctionDeclaration(ASTNode astNode) {

        // TODO: implement correct return code
        stringBuilder.append("return(Constant(ConstInt(0)))").append("\n");

        stringBuilder.append("])");

        stringBuilder.append("\n\n");
    }

    //
    // For-Loop
    //

    private void enterForLoop(StatementASTNode statementASTNode) {

        //
        // loop variable declaration + initialization
        //

        ASTNode astNode0 = statementASTNode.getChildren().get(0);
        SimpleDeclarationASTNode simpleDeclarationASTNode = (SimpleDeclarationASTNode) astNode0;

        // DEBUG
        StringBuilder debugStringBuilder = new StringBuilder();
        simpleDeclarationASTNode.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());

        // Declare temp variables outside the loop so that the declaration
        // is not executed several times in the loop which causes an error
        // in the execution engine
        stringBuilder.append("tmp.0 = Var(\"tmp.0\")").append("\n");
        stringBuilder.append("tmp.1 = Var(\"tmp.1\")").append("\n");

        stringBuilder.append("// <instructions for init>").append("\n");
        process(simpleDeclarationASTNode);
        //i = Var("i")
        //i = Constant(ConstInt(0))

        // Label(start)
        stringBuilder.append("Label(start)").append("\n");

        //
        // loop condition expression
        //

        ASTNode astNode1 = statementASTNode.getChildren().get(1);
        ExpressionASTNode expressionASTNode = (ExpressionASTNode) astNode1;

        // DEBUG
        debugStringBuilder = new StringBuilder();
        astNode1.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());

        stringBuilder.append("// <instructions for condition>").append("\n");
        //stringBuilder.append("tmp.0 = Var(\"tmp.0\")").append("\n");
        stringBuilder.append("tmp.0 = ");
        stringBuilder.append(outputExpression(expressionASTNode)).append("\n");
        // JumpIfZero(tmp.0, break_label)
        stringBuilder.append("JumpIfZero(tmp.0, break_label)").append("\n");

        //
        // body statements
        //

        stringBuilder.append("// <start body statements>").append("\n");

        // body of the for loop
        for (int i = 3; i < statementASTNode.getChildren().size(); i++) {

            ASTNode astNodeChild = statementASTNode.getChildren().get(i);

            // DEBUG
            debugStringBuilder = new StringBuilder();
            astNodeChild.printRecursive(debugStringBuilder, 0);
            System.out.println(debugStringBuilder.toString());

            process(astNodeChild);
        }

        stringBuilder.append("// <end body statements>").append("\n");

        //
        // Continue Label
        //

        stringBuilder.append("// <continue label> ").append("\n");
        stringBuilder.append("Label(Continue_Label)").append("\n");

        //
        // loop postfix
        //

        ASTNode astNode2 = statementASTNode.getChildren().get(2);
        ExpressionASTNode postFixExpressionASTNode = (ExpressionASTNode) astNode2;

        // DEBUG
        debugStringBuilder = new StringBuilder();
        astNode2.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());

        //
        // <instructions for post>
        //

        stringBuilder.append("// <instructions for post>").append("\n");

        // Declare temp variable
        // tmp.1 = i + Constant(ConstInt(1))
        //stringBuilder.append("tmp.1 = Var(\"tmp.1\")").append("\n");
        stringBuilder.append("tmp.1 = ");
        expressionASTNode = (ExpressionASTNode) astNode2;
        stringBuilder.append(outputExpression(expressionASTNode)).append("\n");

        // i = tmp.1
        stringBuilder.append("i = tmp.1").append("\n");

        // start the next iteration of the loop
        stringBuilder.append("Jump(start)").append("\n");

        // end label
        stringBuilder.append("Label(break_label)").append("\n");
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
                default:
                    throw new RuntimeException();
            }

            return tempStringBuilder.toString();

        }

        throw new RuntimeException();
    }

    private void exitForLoop(StatementASTNode statementASTNode) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'exitForLoop'");
    }

    //
    // Unknown
    //

    private void enterUnknown(ASTNode astNode) {
    }

    private void exitUnknown(ASTNode astNode) {
    }

}
