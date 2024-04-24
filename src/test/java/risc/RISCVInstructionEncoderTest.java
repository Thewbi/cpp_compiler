package risc;

import org.junit.Test;

import grammar.RISCVRow;
import grammar.RISCVRowParam;
import riscv.RISCVInstructionEncoder;

public class RISCVInstructionEncoderTest {
    
    @Test
    public void encodeLIPseudoInstructionTest() {

        RISCVRow riscVRow = new RISCVRow();
        riscVRow.setInstruction("li");
        
        RISCVRowParam riscVRowParam = new RISCVRowParam();
        riscVRowParam.setRegister("x15");
        riscVRow.getParameters().add(riscVRowParam);

        riscVRowParam = new RISCVRowParam();
        riscVRowParam.setExpression("1");
        riscVRow.getParameters().add(riscVRowParam);

        RISCVInstructionEncoder riscVInstructionEncoder = new RISCVInstructionEncoder();
        riscVInstructionEncoder.encode(riscVRow, null);

    }

}
