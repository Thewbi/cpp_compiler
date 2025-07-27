package main;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

import com.cpp.grammar.CPP14Lexer;

import ast.ASTNode;

public class ExpressionBuilderExecutor {

    ASTNode execute(String data) {

        if (data.isBlank()) {
            throw new RuntimeException("no data!");
        }

        final CharStream charStream = CharStreams
                .fromString(data);

        final CPP14Lexer lexer = new CPP14Lexer(charStream);

        Vocabulary vocabulary = lexer.getVocabulary();
        int maxTokenType = vocabulary.getMaxTokenType();

        // maxTokenType is 144 for reference
        int ruleIndexOffset = 1;
        ExpressionBuilderRule.exprType = maxTokenType + ruleIndexOffset++;
        ExpressionBuilderRule.startSymbolType = maxTokenType + ruleIndexOffset++;
        ExpressionBuilderRule.cStyleCast = maxTokenType + ruleIndexOffset++;
        ExpressionBuilderRule.exprCommaListType = maxTokenType + ruleIndexOffset++;

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // build the ExpressionBuilder including all rules of the grammar
        ExpressionBuilderFactory factory = new ExpressionBuilderFactory();
        ExpressionBuilder expressionBuilder = factory.build();

        // run the ExpressionBuilder on the input data
        boolean done = false;
        int tokenIndex = 0;
        boolean readNextToken = true;
        while (!done) {

            if (readNextToken) {
                tokenIndex++;
            }

            Token currentToken = tokenStream.LT(tokenIndex);
            Token lookAheadToken = tokenStream.LT(tokenIndex + 1);

            System.out.println(currentToken + " Type: " + vocabulary.getSymbolicName(currentToken.getType()));

            readNextToken = expressionBuilder.addToken(currentToken, lookAheadToken);

            if (expressionBuilder.getStack().peek().token.getType() == ExpressionBuilderRule.startSymbolType) {
                done = true;
                continue;
            }
        }
        
        ASTNode astNode = expressionBuilder.getStack().peek();

        return astNode;

    }
    
}
