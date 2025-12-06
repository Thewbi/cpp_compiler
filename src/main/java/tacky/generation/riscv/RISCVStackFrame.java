package tacky.generation.riscv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for (RISCVStackEntry stackEntry : stackEntryList) {

            if (stackEntry.isArray) {

                address -= (4 * stackEntry.arraySize);
                stackEntry.address = address + 4;

            } else {

                stackEntry.address = address;
                address -= 4;

            }
        }

        return stackPointer - address;
    }

}
