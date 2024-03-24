package types;

public class Type {

    private String name;

    private Type arraySubType;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (arraySubType != null) {
            stringBuilder.append("Type [ArrayOf=").append(arraySubType.getName()).append("]");
        } else {
            stringBuilder.append("Type [name=").append(name).append("]");
        }

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Type other = (Type) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getArraySubType() {
        return arraySubType;
    }

    public void setArraySubType(Type arraySubType) {
        this.arraySubType = arraySubType;
    }

}
