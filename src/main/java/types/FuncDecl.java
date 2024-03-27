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
        //return "FuncDecl [name=" + name + ", returnType=" + returnType + ", params=" + params + "]";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("FuncDecl [name=" + name + ", returnType=" + returnType + " ");

        int i = 1;
        for (FormalParameter formalParameter : params) {
            stringBuilder.append("\n");
            stringBuilder.append("Parameter ").append(i).append(" ").append(formalParameter);
            i++;
        }

        return stringBuilder.toString();
    }

}
