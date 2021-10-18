package model.enums;

public enum TypeOfShoes {
    SPORT("sport"),
    FORMAL("formal"),
    NOT_SET("not_set");
    private String name;

    TypeOfShoes(String name) {
        this.name = name;
    }
}
