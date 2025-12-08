package tacky.generation.riscv;

import common.ByteArrayUtil;

public class RISCVStackEntry {

    public String variableName;

    /**
     * Used during computation of the stack frame structure. Virtually useless
     * thereafter
     */
    public Integer address;

    /**
     * this is the address of the variable within the stack frame relative to the
     * frame pointer during runtime
     */
    public int fpRelativeAddress;

    public boolean isArray;

    public int arraySize;

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("RISCVStackEntry [")
                .append("address=" + ByteArrayUtil.intToHex(address) + " (" + address + ")");

        stringBuilder.append(", fpRelAddress=").append(ByteArrayUtil.intToHex(fpRelativeAddress)).append(" (")
                .append(fpRelativeAddress).append(")");

        if (isArray) {
            stringBuilder.append(", isArray=" + isArray);
            stringBuilder.append(", arraySize=" + arraySize);
        }

        // put var name last since it will shift the column layout around too much if
        // placed at the start
        stringBuilder.append(", variableName=").append(variableName);

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    // DATA TYPE: Assume integer for now
}
