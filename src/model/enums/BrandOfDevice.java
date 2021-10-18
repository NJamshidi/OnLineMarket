package model.enums;

public enum BrandOfDevice {
    BOSCH("bosch"),
    LG("lg"),
    SAMSUNG("samsung"),
    NOT_SET("not_set");
    private String name;

    BrandOfDevice(String name) {
        this.name = name;
    }
}
