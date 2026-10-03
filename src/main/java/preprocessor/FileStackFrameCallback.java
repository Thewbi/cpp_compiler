package preprocessor;

public interface FileStackFrameCallback {

    void execute(DefinedSymbolStruct definedSymbolStruct);

    void executePragma(String pragma_instruction);

}
