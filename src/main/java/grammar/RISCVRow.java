package grammar;

import java.util.ArrayList;
import java.util.List;

public class RISCVRow {

    private String label;

    private String intrinsic;
    
    private String instruction;

    private List<RISCVRowParam> parameters = new ArrayList<>();
    
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

    @Override
    public String toString() {
        // return "RISCVRow [label=" + label + ", intrinsic=" + intrinsic + ", instruction=" + instruction
        //         + ", parameters=" + parameters + "]";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RISCVRow [label=" + label + ", intrinsic=" + intrinsic + ", instruction=" + instruction);

        for (RISCVRowParam parameter : parameters) {
            stringBuilder.append("\n    ").append(parameter);
        }

        return stringBuilder.toString();
    }
    
}
