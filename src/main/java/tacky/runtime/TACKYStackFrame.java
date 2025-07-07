package tacky.runtime;

import java.util.HashMap;

public class TACKYStackFrame {

    /** When removing this stack frame from the stack, continue executing at this index */
    public int returnIndex;

    public int startAddress;

    public int endAddress;

    public HashMap<String, TACKYStackFrameVariableDescriptor> variables = new HashMap<>();

    public HashMap<String, Integer> labels = new HashMap<>();

}
