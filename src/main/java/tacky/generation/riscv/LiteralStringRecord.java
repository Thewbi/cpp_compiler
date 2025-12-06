package tacky.generation.riscv;

public class LiteralStringRecord {

    public int index;

    public String getLabel() {
        return ".SLL" + index; // SLL = String Literal Label
    }

    public String value;

}
