package preprocessor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public abstract class AbstractFileStackFrame implements IFileStackFrame {

    public String filename;

    /**
     * When angle brackets / chevrons are used, the include file
     * is resolved using the include-path. The include-path is a variable
     * combining several folders where include files are searched.
     *
     * If this variable is set to true, then the application looks for the
     * include file in the include-path.
     *
     * If this variable is set to false, then the application looks for the
     * include file in relative paths, relative to the basePath variable which
     * is also defined in this class.
     */
    public boolean useIncludePathResolution;

    public List<Path> includePath = new ArrayList<>();

    public Path basePath;

    public StringBuilder outputStringBuilder;

    public FileStackFrameCallback callback;

    public Stack<IFileStackFrame> fileStack;

    abstract public void start() throws IOException;

    public static Optional<Path> match(String glob, String location) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
        return Files.walk(Paths.get(location)).filter(pathMatcher::matches).findFirst();
    }

    public CharStream includeToCharStream() throws IOException {

        CharStream charStream = null;

        if (useIncludePathResolution) {

            for (Path path : includePath) {
                Optional<Path> result = match("glob:**/stdio.h", path.toAbsolutePath().toString());
                if (result.isPresent()) {
                    String foundFile = result.get().toAbsolutePath().toString();
                    System.out.println("Result: \"" + foundFile + "\"");
                    charStream = CharStreams.fromFileName(foundFile);
                    break;
                }
            }

        } else if (basePath == null) {

            basePath = Path.of(filename);
            //System.out.println("BasePath: \"" + basePath.getParent().toString() + "\"");
            charStream = CharStreams .fromFileName(filename);

        } else {

            Path newFile = basePath.resolveSibling(filename);
            charStream = CharStreams
                    .fromFileName(newFile.toString());

        }

        return charStream;
    }

    public static boolean isBinaryOperator(String text) {

        return
        text.equalsIgnoreCase(".")
        ||
        text.equalsIgnoreCase("||")
        ||
        text.equalsIgnoreCase("&&")
        ||
        text.equalsIgnoreCase(">")
        ||
        text.equalsIgnoreCase(">=")
        ||
        text.equalsIgnoreCase("<")
        ||
        text.equalsIgnoreCase("<=")
        ||
        text.equalsIgnoreCase("==");
    }

    /**
     * https://en.cppreference.com/w/c/language/operator_precedence.html
     * @param operator
     * @return
     */
    public static int getPriority(String operator) {
        if (operator.equalsIgnoreCase(".")) {
            return 1000 - 1;
        }
        else if (operator.equalsIgnoreCase("||")) {
            return 1000 - 12;
        }
        else if (operator.equalsIgnoreCase("&&")) {
            return 1000 - 11;
        }
        else if (operator.equalsIgnoreCase(">")) {
            return 1000 - 6;
        }
        else if (operator.equalsIgnoreCase(">=")) {
            return 1000 - 6;
        }
        else if (operator.equalsIgnoreCase("<")) {
            return 1000 - 6;
        }
        else if (operator.equalsIgnoreCase("<=")) {
            return 1000 - 6;
        }
        else if (operator.equalsIgnoreCase("==")) {
            return 1000 - 7;
        }
        return Integer.MAX_VALUE;
    }

}
