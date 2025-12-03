package tacky.generation.riscv;

import common.ByteArrayUtil;

public class RISCVStackEntry {

    public String variableName;

    public Integer address;

    public boolean isArray;

    public int arraySize;

    @Override
    public String toString() {

        if (isArray) {
            return "RISCVStackEntry [address=" + ByteArrayUtil.intToHex(address) + " (" + address + ")"
                    + ", isArray=" + isArray
                    + ", arraySize=" + arraySize + ", variableName=" + variableName + "]";

        }

        return "RISCVStackEntry [address=" + ByteArrayUtil.intToHex(address) + " (" + address + ")" + ", variableName="
                + variableName + "]";
    }

    // DATA TYPE: Assume integer for now
}
