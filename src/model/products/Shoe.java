package model.products;

import model.enums.TypeOfShoes;

public class Shoe extends Product{
private int size;
private String color;
private TypeOfShoes typeOfShoe;

    public Shoe(int count, double amount, int size, String color, TypeOfShoes typeOfShoe) {
        super(count, amount);
        this.size = size;
        this.color = color;
        this.typeOfShoe = typeOfShoe;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TypeOfShoes getTypeOfShoe() {
        return typeOfShoe;
    }

    public void setTypeOfShoe(TypeOfShoes typeOfShoe) {
        this.typeOfShoe = typeOfShoe;
    }
}
