package grammar;

import org.antlr.v4.runtime.ParserRuleContext;

import com.cpp.grammar.CPP14ParserBaseListener;

public class ConsoleCPP14ParserListener extends CPP14ParserBaseListener {

    private int indent;

	@Override 
	public void enterEveryRule(ParserRuleContext ctx) {

        for (int i = 0; i < indent; i++)
        {
            System.out.print("  ");
        }

        System.out.print(ctx.getClass().getSimpleName() + " " + ctx.getStart().getText());
        System.out.println("");
		
		// TO DEBUG UNCOMMENT THIS:
		descend();
	}

    @Override 
	public void exitEveryRule(ParserRuleContext ctx) {
		// TO DEBUG UNCOMMENT THIS
		ascend();
	}

    // @Override 
	// public void visitTerminal(TerminalNode node) { 
	// 	descend();
	// 	currentNode.setLabel("TERMINAL: " + node.getText());
	// 	ascend();
	// }

    private void descend() {
        indent++;

		// Node parent = getCurrentNode();
		// currentNode = createNode();
		// parent.getChildren().add(currentNode);
		// currentNode.setParentNode(parent);
	}

	private void ascend() {
        indent--;

		// if (currentNode != null) {
		// 	currentNode = currentNode.getParentNode();
		// }
	}
    
}
