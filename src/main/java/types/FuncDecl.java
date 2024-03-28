package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FuncDecl {

    private String name;

    private Type returnType;

    private List<FormalParameter> params = new ArrayList<>();

    public List<FormalParameter> getParams() {
        return params;
    }

    public void setParams(List<FormalParameter> params) {
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toString(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public String toString(StringBuilder stringBuilder, int indent) {
        //return "FuncDecl [name=" + name + ", returnType=" + returnType + ", params=" + params + "]";

        // StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }

        stringBuilder.append("FuncDecl [name=" + name + ", returnType=" + returnType + " ");

        int i = 1;
        for (FormalParameter formalParameter : params) {
            stringBuilder.append("\n");

            for (int j = 0; j < indent+1; j++) {
                stringBuilder.append("  ");
            }

            stringBuilder.append("Parameter ").append(i).append(" ").append(formalParameter);
            i++;
        }

        return stringBuilder.toString();
    }

}
