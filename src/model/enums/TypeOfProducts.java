package model.enums;

public enum TypeOfProducts {
    ELECTRONICS("electronics"),
    SHOES("shoes"),
    READABLE_ITEMS("readable_items"),
    NOT_SET("not_set");

    private final String name;

    TypeOfProducts(String name) {
        this.name = name;
    }
}