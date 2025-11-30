package tacky.generation.riscv;

import java.util.HashMap;
import java.util.Map;

public class RISCVStackFrame {

    public Map<String, RISCVStackEntry> stackEntryMap = new HashMap<String, RISCVStackEntry>();

    public RISCVStackEntry addVariable(String variableName) {

        if (stackEntryMap.containsKey(variableName)) {
            throw new RuntimeException();
        }

        RISCVStackEntry stackEntry = new RISCVStackEntry();
        stackEntry.variableName = variableName;

        stackEntryMap.put(variableName, stackEntry);

        return stackEntry;
    }

    public int computeAddresses(int stackPointer) {

        int address = stackPointer;

        for (Map.Entry<String, RISCVStackEntry> entry : stackEntryMap.entrySet()) {
            entry.getValue().address = address;

            address -= 4;
        }

        return stackPointer - address;
    }

}
