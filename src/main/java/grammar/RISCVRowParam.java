package grammar;

public class RISCVRowParam {

    private int offset;

    private String register;

    private String label;

    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RISCVRowParam [offset=" + offset + ", register=" + register + ", label=" + label + ", expression="
                + expression + "]";
    } 
    
}
