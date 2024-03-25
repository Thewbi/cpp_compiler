package types;

public class FormalParameter {

    private String name;

    private Type type;

    @Override
    public String toString() {
        return "FormalParameter [name=" + name + ", type=" + type + "]";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
