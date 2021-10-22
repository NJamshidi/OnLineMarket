package model.enums;

public enum TypeOfReadableItems {
    BOOK("book"),
    JOURNAL("journal"),
    NOT_SET("not_set");

    private String name;

    TypeOfReadableItems(String name) {
        this.name = name;
    }
    public TypeOfReadableItems getValue(String name) {
        for (TypeOfReadableItems type : values()) {
            if (type.name.equalsIgnoreCase(name.trim()))
                return type;
        }
        return NOT_SET;
    }
}
