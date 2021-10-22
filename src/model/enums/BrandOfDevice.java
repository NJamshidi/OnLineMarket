package model.enums;

public enum BrandOfDevice {
    BOSCH("bosch"),
    LG("LG"),
    SAMSUNG("samsung"),
    NOT_SET("not_set");
    private String name;

    BrandOfDevice(String name) {
        this.name = name;
    }
    public BrandOfDevice getValue(String name) {
        for (BrandOfDevice brand : values()) {
            if (brand.name.equalsIgnoreCase(name.trim()))
                return brand;
        }
        return NOT_SET;
    }
}
