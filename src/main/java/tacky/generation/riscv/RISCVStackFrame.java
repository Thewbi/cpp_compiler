package tacky.generation.riscv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ByteArrayUtil;

public class RISCVStackFrame {

    public Map<String, RISCVStackEntry> stackEntryMap = new HashMap<String, RISCVStackEntry>();

    public List<RISCVStackEntry> stackEntryList = new ArrayList<>();

    public int stackSizeUsed;

    public RISCVStackEntry addVariable(String variableName, boolean isArray, int arraySize) {

        if (stackEntryMap.containsKey(variableName)) {
            return stackEntryMap.get(variableName);
        }

        RISCVStackEntry stackEntry = new RISCVStackEntry();
        stackEntry.variableName = variableName;
        stackEntry.isArray = isArray;
        stackEntry.arraySize = arraySize;

        stackEntryMap.put(variableName, stackEntry);
        stackEntryList.add(stackEntry);

        return stackEntry;
    }

    public int computeAddresses(int stackPointer) {

        int address = stackPointer;

        // System.out.println("fp: " + ByteArrayUtil.byteToHex(address));

        // subtract -4 because the first stack element is not used?!?!??!!?
        address = address -4;

        for (RISCVStackEntry stackEntry : stackEntryList) {

            if (stackEntry.isArray) {

                stackEntry.address = address;
                stackEntry.fpRelativeAddress = stackPointer - address;

                System.out.println(stackEntry.variableName + ":" +  ByteArrayUtil.byteToHex(stackEntry.address) + " (" + (stackEntry.address - stackPointer) + ")");

                address -= (4 * stackEntry.arraySize);

            } else {

                stackEntry.address = address;
                stackEntry.fpRelativeAddress = stackPointer - address;

                System.out.println(stackEntry.variableName + ":" +  ByteArrayUtil.byteToHex(stackEntry.address) + " (" + (stackEntry.address - stackPointer) + ")");

                address -= 4;

            }
        }

        return stackPointer - address;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°").append("\n");
        for (RISCVStackEntry entry : stackEntryList) {
            stringBuilder.append(entry.toString()).append("\n");
        }
        stringBuilder.append("000000000000000000000000000000000000000").append("\n");

        return stringBuilder.toString();
    }

}
