package ide;

import java.util.regex.Matcher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.controlsfx.control.spreadsheet.GridChange;

import javax.swing.event.DocumentEvent.EventType;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import riscv.DecodingRISCVProcessor;
import riscv.DefaultMemory;
import riscv.DefaultRegisterFile;
import riscv.ExplicitRISCVProcessor;
import riscv.RISCVInstructionEncoder;
import riscv.RISCVProcessor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.GridChange;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.GenericStyledArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.Paragraph;
import org.fxmisc.richtext.model.StyleSpan;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.collection.ListModification;
import org.reactfx.collection.LiveList;

import com.cpp.grammar.RISCVLexer;
import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.RISCVParser.Asm_fileContext;

import grammar.ConsoleCPP14ParserListener;
import grammar.ExplicitRISCVRow;
import grammar.RISCVRow;
import grammar.RISCVRowListener;
import grammar.SyntaxErrorListener;

import org.reactfx.Subscription;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

/**
 * <ul>
 * <li>https://github.com/miho/MonacoFX</li>
 * <li>https://github.com/miho/MonacoFX-Tutorials</li>
 * <li>https://venus.kvakil.me/</li>
 * <li>https://riscvasm.lucasteske.dev/#</li>
 * <li>https://luplab.gitlab.io/rvcodecjs/#q=fffff06f&abi=false&isa=AUTO</li>
 * </ul>
 * 
 * 1. Read text from code area into string
 * 
 * <pre>
 * ((CodeArea) getOwnerNode()).getText()
 * </pre>
 * 
 * 2. Use the antlr parser to return list of rows
 * The rows have to store the source line number into the .s file.
 *
 * 3. Assemble each row. The row has to store a {list of pointers} into the
 * assembled byte array.
 * A pseudo instruction might be converted into several real instructions, that
 * is why
 * a list of pointers is required.
 * 
 * 4. Single Step button.
 * Find the row that the PC points to, highlight the row in the source code
 * Reference the byte array and make the cpu execute the current instruction
 * 
 * 5. Increment PC, make the new row the current row
 */
public class App extends Application {

    private byte[] buffer = new byte[1024];

    private List<RISCVRow> rows = new ArrayList<>();

    //private ExplicitRISCVProcessor riscVProcessor = new ExplicitRISCVProcessor();
    // private RISCVProcessor riscVProcessor = new RISCVProcessor();
    private DecodingRISCVProcessor riscVProcessor = new DecodingRISCVProcessor();

    private CodeArea codeArea = new CodeArea();
    private int paragraphIdx;
    private int start;
    private int end;
        
    private static final String[] KEYWORDS = new String[] {
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/" // for whole text processing
                                                                                         // (text blocks)
            + "|" + "/\\*[^\\v]*" + "|" + "^\\h*\\*([^\\v]*|/)"; // for visible paragraph processing (line by line)

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")");

    private static final Pattern LINE = Pattern.compile("(?m)^.*$");

    private static final String sampleCode_C = String.join("\n", new String[] {
            "package com.example;",
            "",
            "import java.util.*;",
            "",
            "public class Foo extends Bar implements Baz {",
            "",
            "    /*",
            "     * multi-line comment",
            "     */",
            "    public static void main(String[] args) {",
            "        // single-line comment",
            "        for(String arg: args) {",
            "            if(arg.length() != 0)",
            "                System.out.println(arg);",
            "            else",
            "                System.err.println(\"Warning: empty string as argument\");",
            "        }",
            "    }",
            "",
            "}"
    });

    // private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
    //         "# create stack frame",
    //         "addi   sp, sp, 1024",
    //         "addi	sp,sp,-32",
    //         "",
    //         "sw     ra,28(sp)",
    //         "sw     s0,24(sp)",
    //         "sw     s1,20(sp)",
    //         "addi	s0,sp,32"
    // });

    // private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
    //     "li x15, 1"
    // });

    // private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
    //     "j 2"
    // });

    // private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
    //     "blt x15, x14, -4"
    // });

    private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
        "L1: addi	x1, x1, 1",
        "    j L1"
    });

    // private static final String sampleCode_RISV_V_ASM = String.join("\n", new String[] {
    //     "fib: addi x1, x1, 1",
    //     "     call fib"
    // });

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // add line numbers to the left of area
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        // codeArea.setParagraphGraphicFactory(ShitFuckFactory.get(codeArea));
        codeArea.setContextMenu(new DefaultContextMenu());
        /*
         * // recompute the syntax highlighting for all text, 500 ms after user stops
         * editing area
         * // Note that this shows how it can be done but is not recommended for
         * production with
         * // large files as it does a full scan of ALL the text every time there is a
         * change !
         * Subscription cleanupWhenNoLongerNeedIt = codeArea
         * 
         * // plain changes = ignore style changes that are emitted when syntax
         * highlighting is reapplied
         * // multi plain changes = save computation by not rerunning the code multiple
         * times
         * // when making multiple changes (e.g. renaming a method at multiple parts in
         * file)
         * .multiPlainChanges()
         * 
         * // do not emit an event until 500 ms have passed since the last emission of
         * previous stream
         * .successionEnds(Duration.ofMillis(500))
         * 
         * // run the following code block when previous stream emits an event
         * .subscribe(ignore -> codeArea.setStyleSpans(0,
         * computeHighlighting(codeArea.getText())));
         * 
         * // when no longer need syntax highlighting and wish to clean up memory leaks
         * // run: `cleanupWhenNoLongerNeedIt.unsubscribe();`
         */

        // recompute syntax highlighting only for visible paragraph changes
        // Note that this shows how it can be done but is not recommended for production
        // where multi-
        // line syntax requirements are needed, like comment blocks without a leading *
        // on each line.
        //
        // codeArea.getVisibleParagraphs().addModificationObserver(
        // new VisibleParagraphStyler<>(codeArea, this::computeHighlighting));

        // // auto-indent: insert previous line's indents on enter
        // final Pattern whiteSpace = Pattern.compile("^\\s+");
        // codeArea.addEventHandler(KeyEvent.KEY_PRESSED, KE -> {
        // if (KE.getCode() == KeyCode.ENTER) {
        // int caretPosition = codeArea.getCaretPosition();
        // int currentParagraph = codeArea.getCurrentParagraph();
        // Matcher m0 = whiteSpace.matcher(codeArea.getParagraph(currentParagraph -
        // 1).getSegments().get(0));
        // if (m0.find())
        // Platform.runLater(() -> codeArea.insertText(caretPosition, m0.group()));

        // }
        // });

        // codeArea.replaceText(0, 0, sampleCode_C);
        codeArea.replaceText(0, 0, sampleCode_RISV_V_ASM);

        // works
        // codeArea.setStyleClass(0, 100, "hili");

        // LiveList<Paragraph<Collection<String>, String, Collection<String>>>
        // paragraphs = codeArea.getParagraphs();

        Button assembleButton = new Button("Assemble");
        assembleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("assembleButton {}\n" + codeArea.getText());

                processDocument(codeArea.getText());
            }

            private void processDocument(String document) {

                final CharStream charStream = CharStreams
                        .fromString(document);

                final RISCVLexer lexer = new RISCVLexer(charStream);

                // create a buffer of tokens pulled from the lexer
                final CommonTokenStream tokens = new CommonTokenStream(lexer);

                SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();

                final RISCVParser parser = new RISCVParser(tokens);
                parser.addErrorListener(syntaxErrorListener);

                // parse
                Asm_fileContext root = parser.asm_file();

                if (syntaxErrorListener.getErrorCount() > 0) {
                    throw new RuntimeException("Errors detected!");
                }

                // Create a generic parse tree walker that can trigger callbacks
                final ParseTreeWalker walker = new ParseTreeWalker();

                boolean print = false;
                // boolean print = true;
                if (print) {
                    ConsoleCPP14ParserListener printListener = new ConsoleCPP14ParserListener();
                    walker.walk(printListener, root);
                }

                // RISCVParserListener listener = new RISCVParserListener();
                // ConsoleRISCVParserListener listener = new ConsoleRISCVParserListener();
                // FormattingRISCVParserListener listener = new FormattingRISCVParserListener();
                RISCVRowListener listener = new RISCVRowListener();

                walker.walk(listener, root);

                listener.enterNewline(null);

                rows.addAll(listener.getRows());

                RISCVInstructionEncoder riscVInstructionEncoder = new RISCVInstructionEncoder();
                riscVInstructionEncoder.setBuffer(buffer);

                int bufferIdx = 0;
                List<String> queuedLabels = new ArrayList<>();
                Map<String, Integer> labelMap = new HashMap<>();
                for (RISCVRow row : rows) {

                    if (StringUtils.isNotBlank(row.getLabel())) {
                        queuedLabels.add(row.getLabel());
                    }

                    if (StringUtils.isNotBlank(row.getInstruction())) {

                        if (queuedLabels.size() > 0) {
                            for (String label : queuedLabels) {
                                labelMap.put(label, bufferIdx);
                            }
                            queuedLabels.clear();
                        }

                        bufferIdx += 4;
                    }
                    
                }

                int temp = 1;
                for (RISCVRow row : rows) {

                    System.out.println(row);

                    riscVInstructionEncoder.encode(row, labelMap);

                    System.out.println(temp + ") [OK] " + row);

                    temp++;
                }

                riscVProcessor.setBuffer(buffer);

                System.out.println("test");

                int pc = riscVProcessor.getPc();
                highlightRow(pc);
            }
            
        });

        Button singleStepButton = new Button("Step");
        singleStepButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {

                //System.out.println("singleStepButton {}\n " + codeArea.getText());

                // if (CollectionUtils.isEmpty(riscVProcessor.getRows())) {

                //     riscVProcessor.getRows().addAll(rows);
                //     riscVProcessor.processLabels();
                //     riscVProcessor.startAtLabel("main");

                //     System.out.println("Start Execution: ---------------------------------------");
                // }
                
                // riscVProcessor.processRow();

                ExplicitRISCVRow explicitRISCVRow = riscVProcessor.fetchAndDecode();
                if (explicitRISCVRow == null) {
                    System.out.println("Could not decode instruction from buffer!");
                } else {
                    riscVProcessor.executeInstruction(explicitRISCVRow);

                    System.out.println(riscVProcessor);

                    int pc = riscVProcessor.getPc();                
                    highlightRow(pc);
                }
            }
        });

        ToolBar toolBar = new ToolBar(
                assembleButton,
                singleStepButton,
                new Button("Open"),
                new Button("Save"),
                new Separator(),
                new Button("Clean"),
                new Button("Compile"),
                new Button("Run"),
                new Separator(),
                new Button("Debug"),
                new Button("Profile"));

        VirtualizedScrollPane<CodeArea> virtualizedScrollPane = new VirtualizedScrollPane<>(codeArea);
        StackPane stackPane = new StackPane(virtualizedScrollPane);
        // the stackpane gets all the space
        VBox.setVgrow(stackPane, Priority.ALWAYS);

        VBox vboxCodeArea = new VBox();
        vboxCodeArea.getChildren().add(stackPane);
        vboxCodeArea.setPrefWidth(800);
        vboxCodeArea.setPrefHeight(800);

        // Label s0Label = new Label("s0");
        // TextField s0TextField = new TextField();
        // Bindings.bindBidirectional(s0TextField.textProperty(), riscVProcessor.getTextProperty("x1"));
        // HBox hboxRegisterArea = new HBox();
        // hboxRegisterArea.getChildren().addAll(s0Label, s0TextField);


        DefaultRegisterFile registerFile = new DefaultRegisterFile();

        GridBase grid = new GridBase(registerFile.getRowCount(), registerFile.getColumnCount());
        grid.setRows(registerFile.getRows());

        //grid.addEventHandler(EventHandler<GridChange.GRID_CHANGE_EVENT>, memory);
        grid.addEventHandler(GridChange.GRID_CHANGE_EVENT, registerFile);

        // grid.addEventHandler(javafx.event.EventType.ROOT, R -> {

        //     // DEBUG
        //     System.out.println(R);

        //     if (R instanceof GridChange) {

        //         GridChange gridChangeEvent = (GridChange)R;
        //         System.out.println(gridChangeEvent);

        //         System.out.println("Row: " + gridChangeEvent.getRow());
        //         System.out.println("Column: " + gridChangeEvent.getColumn());
        //         System.out.println("Old: " + gridChangeEvent.getOldValue());
        //         System.out.println("New: " + gridChangeEvent.getNewValue());
        //     }
        // });

        riscVProcessor.setRegisterFile(registerFile);

        SpreadsheetView spreadsheetView = new SpreadsheetView(grid);
        
        HBox hboxRegisterArea = new HBox();
        hboxRegisterArea.getChildren().add(spreadsheetView);




        DefaultMemory memory = new DefaultMemory();

        grid = new GridBase(memory.getRowCount(), memory.getColumnCount());
        grid.setRows(memory.getRows());

        //grid.addEventHandler(EventHandler<GridChange.GRID_CHANGE_EVENT>, memory);
        grid.addEventHandler(GridChange.GRID_CHANGE_EVENT, memory);

        // grid.addEventHandler(javafx.event.EventType.ROOT, R -> {

        //     // DEBUG
        //     System.out.println(R);

        //     if (R instanceof GridChange) {

        //         GridChange gridChangeEvent = (GridChange)R;
        //         System.out.println(gridChangeEvent);

        //         System.out.println("Row: " + gridChangeEvent.getRow());
        //         System.out.println("Column: " + gridChangeEvent.getColumn());
        //         System.out.println("Old: " + gridChangeEvent.getOldValue());
        //         System.out.println("New: " + gridChangeEvent.getNewValue());
        //     }
        // });

        riscVProcessor.setMemory(memory);

        spreadsheetView = new SpreadsheetView(grid);
        
        HBox hboxMemoryArea = new HBox();
        hboxMemoryArea.getChildren().add(spreadsheetView);






        VBox vboxRightArea = new VBox();
        vboxRightArea.getChildren().add(hboxRegisterArea);
        vboxRightArea.getChildren().add(hboxMemoryArea);

        HBox hbox = new HBox();
        hbox.getChildren().add(vboxCodeArea);
        hbox.getChildren().add(vboxRightArea);
        // the stackpane gets all the space
        VBox.setVgrow(hbox, Priority.ALWAYS);

        VBox vboxMain = new VBox();
        vboxMain.getChildren().add(toolBar);
        vboxMain.getChildren().add(hbox);

        

        

        

        Scene scene = new Scene(vboxMain, 1024, 768);

        // scene.getStylesheets().add(App.class.getResource("java-keywords.css").toExternalForm());
        scene.getStylesheets().add("java-keywords.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java Keywords Demo");
        primaryStage.show();

        // List<String> styles = new ArrayList<>();
        // styles.add("-rtfx-background-color: red;");
        // codeArea.setStyle(0, 0, 10, styles);
    }

    protected void highlightRow(int bufferIdx) {
        
        RISCVRow sourceFileRow = null;

        // find the source file row that matches the buffer idx
        for (RISCVRow row : rows) {

            if (row.getBufferIdxs().contains(bufferIdx)) {

                sourceFileRow = row;
                break;
            }
        }

        if (sourceFileRow == null) {
            //throw new RuntimeException("No sourceFileRow found for bufferIdx: " + bufferIdx);
            System.out.println("No sourceFileRow found for bufferIdx: " + bufferIdx);
            return;
        }

        int lineNumber = sourceFileRow.getLine();
        paragraphIdx = lineNumber-1;
        highlightParagraph();
    }

    private StyleSpans<Collection<String>> computeHighlighting(String text) {

        Matcher matcher = PATTERN.matcher(text);

        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();

        while (matcher.find()) {
            String styleClass = matcher.group("KEYWORD") != null ? "keyword"
                    : matcher.group("PAREN") != null ? "paren"
                            : matcher.group("BRACE") != null ? "brace"
                                    : matcher.group("BRACKET") != null ? "bracket"
                                            : matcher.group("SEMICOLON") != null ? "semicolon"
                                                    : matcher.group("STRING") != null ? "string"
                                                            : matcher.group("COMMENT") != null ? "comment" : null;
            // never happens
            assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);

        return spansBuilder.create();
    }

    private class VisibleParagraphStyler<PS, SEG, S>
            implements Consumer<ListModification<? extends Paragraph<PS, SEG, S>>> {
        private final GenericStyledArea<PS, SEG, S> area;
        private final Function<String, StyleSpans<S>> computeStyles;
        private int prevParagraph, prevTextLength;

        public VisibleParagraphStyler(GenericStyledArea<PS, SEG, S> area,
                Function<String, StyleSpans<S>> computeStyles) {
            this.computeStyles = computeStyles;
            this.area = area;
        }

        @Override
        public void accept(ListModification<? extends Paragraph<PS, SEG, S>> lm) {
            if (lm.getAddedSize() > 0)
                Platform.runLater(() -> {
                    int paragraph = Math.min(area.firstVisibleParToAllParIndex() + lm.getFrom(),
                            area.getParagraphs().size() - 1);
                    String text = area.getText(paragraph, 0, paragraph, area.getParagraphLength(paragraph));

                    if (paragraph != prevParagraph || text.length() != prevTextLength) {
                        if (paragraph < area.getParagraphs().size() - 1) {
                            int startPos = area.getAbsolutePosition(paragraph, 0);
                            area.setStyleSpans(startPos, computeStyles.apply(text));
                        }
                        prevTextLength = text.length();
                        prevParagraph = paragraph;
                    }
                });
        }
    }

    private void highlightParagraph() {

        System.out.println("paragraphIdx: " + paragraphIdx);

        // CodeArea codeArea = (CodeArea) getOwnerNode();
        codeArea.clearParagraphStyle(paragraphIdx);
        codeArea.setStyleClass(start, end, "");

        Paragraph<Collection<String>, String, Collection<String>> paragraph = codeArea
                .getParagraph(paragraphIdx);

        // start = codeArea.getAbsolutePosition( paragraphIdx-1, codeArea.getCurrentLineStartInParargraph() );
        // end = codeArea.getAbsolutePosition( paragraphIdx-1, codeArea.getCurrentLineEndInParargraph() );
        start = codeArea.getAbsolutePosition( paragraphIdx, 0 );
        end = codeArea.getAbsolutePosition( paragraphIdx, paragraph.getText().length() );

        //end += 1;

        // System.out.println(paragraph.getText() + " " + paragraph.getText().length());
        // start = end;
        // end += paragraph.getText().length() + 1;

        System.out.println("start: " + start + " end: " + end);

        // Paragraph<Collection<String>, String, Collection<String>> paragraph =
        // codeArea.getParagraph(paragraphIdx);
        // System.out.println(paragraph);

        // //Matcher m = WORD_OR_SYMBOL.matcher( getText( paragraph ) );

        // codeArea.clearParagraphStyle(paragraphIdx);

        // List<String> styles = new ArrayList<>();
        // //styles.add("-fx-background-color: #f2f9fc;");
        // styles.add("-rtfx-background-color: yellow;");
        // codeArea.setParagraphStyle(paragraphIdx, styles);

        // StyleSpan<Collection<String>> styleSpan =
        // paragraph.getStyleSpans().getStyleSpan(0);
        // styleSpan.getStyle().add("-rtfx-background-color: yellow;");
        // System.out.println(styleSpan);

        // String test = paragraph.getSegments().get(0);
        // Matcher matcher = PATTERN.matcher(test);

        // if (matcher.hasMatch()) {
        // int start = matcher.start();
        // int end = matcher.end();

        // codeArea.setStyleClass(start, end, "hili");
        // }

        //paragraphIdx++;
        codeArea.setStyleClass(start, end, "hili");

        // String string = paragraph.getSegments().get(0);

        // List<String> styles = new ArrayList<>();
        // // styles.add("-rtfx-background-color: red;");
        // // styles.add("-fx-background-color: red;");
        // styles.add("hili");

        // // codeArea.setParagraphStyle(paragraphIdx, styles);

        // paragraph.restyle(styles);

        // // paragraph.setParagraphStyle(styles);
    }

    private class DefaultContextMenu extends ContextMenu {

        

        private MenuItem next;
        // private MenuItem fold, unfold, print;

        public DefaultContextMenu() {

            next = new MenuItem("Next");
            next.setOnAction(AE -> {

                hide();

                highlightParagraph();

            });

            // fold = new MenuItem("Fold selected text");
            // fold.setOnAction(AE -> {
            // hide();
            // fold();
            // });

            // unfold = new MenuItem("Unfold from cursor");
            // unfold.setOnAction(AE -> {
            // hide();
            // unfold();
            // });

            // print = new MenuItem("Print");
            // print.setOnAction(AE -> {
            // hide();
            // print();
            // });

            getItems().addAll(next);
            // getItems().addAll(fold, unfold, print);
        }

        

        /**
         * Folds multiple lines of selected text, only showing the first line and hiding
         * the rest.
         */
        private void fold() {
            ((CodeArea) getOwnerNode()).foldSelectedParagraphs();
        }

        /**
         * Unfold the CURRENT line/paragraph if it has a fold.
         */
        private void unfold() {
            CodeArea area = (CodeArea) getOwnerNode();
            area.unfoldParagraphs(area.getCurrentParagraph());
        }

        private void print() {
            System.out.println(((CodeArea) getOwnerNode()).getText());
        }
    }
}
