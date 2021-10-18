package model.enums;

public enum TypeOfElectronics {
    RADIO("radio"),
    TV("tv"),
    NOT_SET("not_set");

    private String name;

    TypeOfElectronics(String name) {
        this.name = name;
    }
}
