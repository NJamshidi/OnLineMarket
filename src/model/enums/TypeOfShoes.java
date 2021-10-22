package model.enums;

public enum TypeOfShoes {
    SPORT("sport"),
    FORMAL("formal"),
    NOT_SET("not_set");
    private String name;

    TypeOfShoes(String name) {
        this.name = name;
    }
    public TypeOfShoes getValue(String name) {
        for (TypeOfShoes type : values()) {
            if (type.name.equalsIgnoreCase(name.trim()))
                return type;
        }
        return NOT_SET;
    }
}
