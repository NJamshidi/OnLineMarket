package model.enums;

public enum TypeOfProducts {
    ELECTRONICS("electronics"),
    SHOE("shoe"),
    READABLEITEM("readableitem"),
    NOT_SET("not_set");

    private final String name;

    TypeOfProducts(String name) {
        this.name = name;
    }
}