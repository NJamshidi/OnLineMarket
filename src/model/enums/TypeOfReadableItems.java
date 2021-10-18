package model.enums;

public enum TypeOfReadableItems {
    BOOK("book"),
    JOURNAL("journal"),
    NOT_SET("not_set");

    private String name;

    TypeOfReadableItems(String name) {
        this.name = name;
    }

}
