package grammar;

import tacky.generation.tacky.TackyDataType;

public class ActualParameter {

    public TackyDataType tackyDataType = TackyDataType.UNKNOWN;

    public boolean isVariable;
    public String name; // var name for pointer or variables

    public boolean isConstant;
    public int intValue; // a value field for constants
    public String stringValue;

}
