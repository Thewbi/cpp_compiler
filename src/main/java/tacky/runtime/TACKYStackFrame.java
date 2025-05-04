package tacky.runtime;

import java.util.HashMap;

public class TACKYStackFrame {

    /** When removing this stack frame from the stack, continue executing at this index */
    public int returnIndex;

    public HashMap<String, Integer> variables = new HashMap<>();

    public HashMap<String, Integer> labels = new HashMap<>();

}
