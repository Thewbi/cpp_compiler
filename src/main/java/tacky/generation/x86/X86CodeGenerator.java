package tacky.generation.x86;

import ast.ASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.ReturnASTNode;
import tacky.generation.Generator;
import tacky.runtime.TACKYStackFrame;

public class X86CodeGenerator implements Generator {

    public StringBuilder stringBuilder = new StringBuilder();

    @Override
    public int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
            FunctionDefinitionASTNode functionDefinition) {
        
        // function is started with a .globl symbol
        stringBuilder.append("\t").append(".globl ").append(functionDefinition.value).append("\n");

        // add _start symbol otherwise the assemblers will complain (https://app.x64.halb.it/) GNU as
        if (currentIndex == 0) {
            stringBuilder.append("\t").append(".globl _start").append("\n");
        }

        // add a label carrying the function name for the function
        stringBuilder.append(functionDefinition.value).append(":").append("\n");
        stringBuilder.append("_start:").append("\n");

        for (ASTNode astNode : functionDefinition.children) {
            execute(astNode);
        }

        stringBuilder.append("\n");
        stringBuilder.append(".section .note.GNU-stack,\"\",@progbits");
        stringBuilder.append("\n");

        return 0;
    }

    private void execute(ASTNode astNode) {
        if (astNode instanceof ReturnASTNode) {
            ReturnASTNode returnASTNode = (ReturnASTNode) astNode;
            generateReturnStatement(returnASTNode);
        } else {
            throw new RuntimeException("Unknown!");
        }
    }

    private void generateReturnStatement(ReturnASTNode returnASTNode) {
        String value = "";
        ASTNode child = returnASTNode.children.get(0);
        if (child instanceof ConstantDeclarationASTNode) {
            ConstantDeclarationASTNode constantDeclarationASTNode = (ConstantDeclarationASTNode) child;
            ConstIntASTNode constantIntASTNode = (ConstIntASTNode) constantDeclarationASTNode.children.get(0);
            value = "$" + constantIntASTNode.value;
        } else {
            throw new RuntimeException("Unknown!");
        }

        stringBuilder.append("\t").append("movl ").append(value).append(", %eax").append("\n");
        stringBuilder.append("\t").append("ret").append("\n");
    }

}
