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
import java.util.regex.Pattern;

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

    /**
     * Option 1 - useIncludePathResolution is set to true, the function uses the include path
     * to resolve the file
     *
     * Option 2 - useIncludePathResolution is false and a base path is configured,
     * the file is loaded from the base path
     *
     * Option 3 - useIncludePathResolution is false and no base path is configured,
     * the file is loaded without base path just using the specified filename.
     * The basepath membervariable is updated with the folder that contains the file!
     * This will change the state of the file stack frame for subsequent loads!
     *
     * This function iterates over all paths contained in the includePath list collection.
     * It looks for the filename in each folder.
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public Path includeToCharStream(final String filename) throws IOException {

        // CharStream charStream = null;

        if (useIncludePathResolution) {

            // option 1 - use include path

            String foundFile = null;
            int filesFound = 0;

            for (Path path : includePath) {

                String pathAsString = path.toAbsolutePath().toString();
                // String filenameAsString = StringUtil.unwrap(filename);

                // DEBUG
                System.out.println("Path: \"" + pathAsString + "\" Filename: \"" + filename + "\"");

                Optional<Path> result = match("glob:**/" + filename, pathAsString);
                if (result.isPresent()) {
                    foundFile = result.get().toAbsolutePath().toString();
                    filesFound++;

                    // DEBUG
                    System.out.println("Found file: \"" + foundFile + "\"");
                }
            }

            if (filesFound == 1) {
                // DEBUG
                System.out.println("Including file: \"" + foundFile + "\"");

                //charStream = CharStreams.fromFileName(foundFile);

                Path newFile = basePath.resolveSibling(foundFile);
                return newFile;
            } else if (filesFound > 1) {
                throw new RuntimeException("File \"" + filename + "\" found in more than a single directory! Ambiguous! Aborting operation!");
            } else {
                throw new RuntimeException("File \"" + filename + "\" not found! Aborting operation!");
            }



        } else if (basePath != null) {

            // option 2 - use basepath

            Path newFile = basePath.resolveSibling(filename);
            return newFile;
            //charStream = CharStreams.fromFileName(newFile.toString());

        } else {

            // option 3 - just use the filename and update the base path

            basePath = Path.of(filename);
            return basePath;
            //charStream = CharStreams.fromFileName(filename);

            // DEBUG - output the new basepath
            //System.out.println("BasePath: \"" + basePath.getParent().toString() + "\"");

        }

        // return charStream;
    }

    public static boolean isBinaryOperator(String token) {

        return
        token.equalsIgnoreCase(",")
        ||
        token.equalsIgnoreCase("%")
        ||
        token.equalsIgnoreCase("+")
        ||
        token.equalsIgnoreCase("*")
        ||
        token.equalsIgnoreCase(".")
        ||
        token.equalsIgnoreCase("||")
        ||
        token.equalsIgnoreCase("&&")
        ||
        token.equalsIgnoreCase(">")
        ||
        token.equalsIgnoreCase(">=")
        ||
        token.equalsIgnoreCase("<")
        ||
        token.equalsIgnoreCase("<=")
        ||
        token.equalsIgnoreCase("==")
        ||
        token.equalsIgnoreCase("!=");
    }

    public static boolean isUnaryOperator(String token) {
        return
        token.equalsIgnoreCase("!");
    }

    /**
     * https://en.cppreference.com/w/c/language/operator_precedence.html
     * @param operator
     * @return
     */
    public static int getOperatorPriority(String operator) {

        if (operator == null) {
            System.out.println("null!");
        }

        if (operator.equalsIgnoreCase("%")) {
            return 1000 - 3;
        } else if (operator.equalsIgnoreCase("+")) {
            return 1000 - 4;
        } else if (operator.equalsIgnoreCase("*")) {
            return 1000 - 3;
        } else if (operator.equalsIgnoreCase(".")) {
            return 1000 - 1;
        } else if (operator.equalsIgnoreCase("||")) {
            return 1000 - 12;
        } else if (operator.equalsIgnoreCase("&&")) {
            return 1000 - 11;
        } else if (operator.equalsIgnoreCase(">")) {
            return 1000 - 6;
        } else if (operator.equalsIgnoreCase(">=")) {
            return 1000 - 6;
        } else if (operator.equalsIgnoreCase("<")) {
            return 1000 - 6;
        } else if (operator.equalsIgnoreCase("<=")) {
            return 1000 - 6;
        } else if (operator.equalsIgnoreCase("==")) {
            return 1000 - 7;
        } else if (operator.equalsIgnoreCase("!=")) {
            return 1000 - 7;
        } else if (operator.equalsIgnoreCase("!")) {
            return 1000 - 2;
        } else if (operator.equalsIgnoreCase(",")) {
            return Integer.MAX_VALUE - 200000;
        }
        return Integer.MAX_VALUE - 100000;
    }

    static Pattern isNumericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    static Pattern isBracePattern = Pattern.compile("[\\[\\]\\{\\}\\()\\)]");
    static Pattern isLetterPattern = Pattern.compile("[a-zA-Z]([a-zA-Z0-9])*");

    public static boolean isIdentifier(String token) {

        if (token.isBlank()) {
            return false;
        }
        if (token.equalsIgnoreCase("defined")) { // the keyword defined is not an identifier!
            return false;
        }
        if (!isLetterPattern.matcher(token).matches()) {
            return false;
        }
        if (token.startsWith("\"")) {
            return false;
        }
        if (isNumericPattern.matcher(token).matches()) {
            return false;
        }
        if (isBracePattern.matcher(token).matches()) {
            return false;
        }

        return true;
    }


}
