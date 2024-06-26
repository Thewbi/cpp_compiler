package grammar;

import java.util.ArrayList;
import java.util.List;

public class RISCVRow {

    /** The line in the source file where this row has been parsed from.
     * Is used during debugging to correlate the executed instruction with the source code.
     */
    private int line;

    private List<Integer> bufferIdxs = new ArrayList<>();

    private String label;

    private String intrinsic;
    
    private String instruction;

    private List<RISCVRowParam> parameters = new ArrayList<>();

    private List<String> intrinsicParameters = new ArrayList<>();

    private List<RISCVRow> children = new ArrayList<>();

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line + ") RISCVRow [label=" + label + ", intrinsic=" + intrinsic + ", instruction=" + instruction);

        for (RISCVRowParam parameter : parameters) {
            stringBuilder.append("\n    ").append(parameter);
        }
        for (String parameter : intrinsicParameters) {
            stringBuilder.append("\n    ").append(parameter);
        }

        return stringBuilder.toString();
    }
    
    public List<String> getIntrinsicParameters() {
        return intrinsicParameters;
    }

    public List<RISCVRowParam> getParameters() {
        return parameters;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
    
    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public List<Integer> getBufferIdxs() {
        return bufferIdxs;
    }

    public List<RISCVRow> getChildren() {
        return children;
    }

}
