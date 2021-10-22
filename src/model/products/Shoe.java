package model.products;

import model.enums.TypeOfProducts;
import model.enums.TypeOfShoes;

public class Shoe extends Product {
    private int size;
    private String color;
    private TypeOfShoes typeOfShoes;

    public Shoe(int count, double cost, int sizeOfShoe, String color, TypeOfShoes typeOfShoes) {
        super(count, cost);
        this.size = size;
        this.color = color;
        this.typeOfShoes = typeOfShoes;
        typeOfProducts = TypeOfProducts.SHOE;
    }

    public Shoe(int id, int count, double cost, int sizeOfShoe, String color, TypeOfShoes typeOfShoes) {
        super(id, count, cost);
        this.size = size;
        this.color = color;
        this.typeOfShoes = typeOfShoes;
        typeOfProducts = TypeOfProducts.SHOE;
    }

    public Shoe() {

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
        return typeOfShoes;
    }

    public void setTypeOfShoe(TypeOfShoes typeOfShoe) {
        this.typeOfShoes = typeOfShoe;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                super.toString() + '\'' +
                "size=" + size +
                ", color='" + color + '\'' +
                ", typeOfShoe=" + typeOfShoes +
                '}';
    }
}
