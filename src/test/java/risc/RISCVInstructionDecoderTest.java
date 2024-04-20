package risc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import riscv.RISCVInstructionDecoder;

public class RISCVInstructionDecoderTest {

    @Test
    public void decodeTest() {

        RISCVInstructionDecoder riscVInstructionDecoder = new RISCVInstructionDecoder();
        riscVInstructionDecoder.decode();

    }

    
    
}
