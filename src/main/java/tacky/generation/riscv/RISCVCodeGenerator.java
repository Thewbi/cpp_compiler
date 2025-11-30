package tacky.generation.riscv;

import ast.ASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.PrintfASTNode;
import tacky.ast.ReturnASTNode;
import tacky.generation.Generator;
import tacky.runtime.TACKYStackFrame;

public class RISCVCodeGenerator implements Generator {

    public StringBuilder stringBuilder = new StringBuilder();

    @Override
    public int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
            FunctionDefinitionASTNode functionDefinition) {

        for (ASTNode astNode : functionDefinition.children) {
            execute(astNode);
        }

        return 0;

    }

    private void execute(ASTNode astNode) {

        // DEBUG print node
        boolean printAST = true;
        // boolean printAST = false;
        if (printAST) {
            StringBuilder tempStringBuilder = new StringBuilder();
            astNode.printRecursive(tempStringBuilder, 0, true);
            System.out.print(tempStringBuilder.toString());
        }

        switch (astNode.astNodeType) {

            case ROOT:
                break;

            case FUNCTION_DECLARATION:
                break;

            case FUNCTION_CALL:
                processFunctionCall(astNode);
                break;

            case INIT_DECLARATION:
                break;

            case ITERATION_STATEMENT:
                break;

            case JUMP_STATEMENT:
                break;

            case SIMPLE_DECLARATION:
                break;
            
            case EXPRESSION:
                break;

            case UNKNOWN:
            default:
                System.out.println("Unknown type: " + astNode.astNodeType);
                //throw new RuntimeException("Unknown type: " + astNode.astNodeType);
                return;
        }

        // if (astNode instanceof ReturnASTNode) {
        //     ReturnASTNode returnASTNode = (ReturnASTNode) astNode;
        //     // generateReturnStatement(returnASTNode);
        // } else {
        //     throw new RuntimeException("Unknown!");
        // }
    }

    private void processFunctionCall(ASTNode astNode) {
        if (astNode instanceof PrintfASTNode) {
            processPrintfFunctionCall((PrintfASTNode) astNode);
        } else {
            throw new RuntimeException();
        }
    }

    private void processPrintfFunctionCall(PrintfASTNode astNode) {
        
        //System.out.println(astNode);

        // a7 describes the service that is called by the ecall
        // a0 is a parameter register. a0 contains the address of the data

        String indent = "        ";

        //
        // DATA SEGMENT
        //

        // stringBuilder.append(indent).append(".data").append("\n").append("\n");

        // define data
        // .string "abc"
        String labelName = ".LABEL_0";
        stringBuilder.append(labelName).append(": ").append("\n");
        stringBuilder.append(indent).append(".string ").append(astNode.value).append("\n");

        //
        // CODE SEGMENT
        //

        // stringBuilder.append("\n").append(indent).append(".text").append("\n").append("\n");

        // start symbol
        stringBuilder.append("main:").append("\n");
        stringBuilder.append("_start:").append("\n");

        // load address of data into a5

        // lui     a5, %hi(.LC3)
        stringBuilder.append(indent).append("lui     a5, ").append("%hi(").append(labelName).append(")").append("\n");
        // addi    a0, a5, %lo(.LC3)
        stringBuilder.append(indent).append("addi    a0, a5, ").append("%lo(").append(labelName).append(")").append("\n");
        // call    puts
        stringBuilder.append(indent).append("call    puts").append("\n");

        stringBuilder.append(indent).append("ret").append("\n");

        // call puts

        // puts:
        stringBuilder.append("puts:").append("\n");
        // li a7, 92   ; ecall for puts
        stringBuilder.append(indent).append("li      a7, 92   # ecall for puts").append("\n");
        // ecall
        stringBuilder.append(indent).append("ecall").append("\n");
        // jr      ra
        stringBuilder.append(indent).append("jr      ra").append("\n");
    }
    
}
