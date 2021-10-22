package model.products;

import model.enums.TypeOfProducts;
import model.enums.TypeOfReadableItems;

public class ReadableItem extends Product {
    private int numberOfPage;
    private TypeOfReadableItems typeOfReadableItems;

    public ReadableItem(int count, double cost, int numberOfPage, TypeOfReadableItems typeOfReadableItems) {
        super(count, cost);
        this.numberOfPage = numberOfPage;
        this.typeOfReadableItems = typeOfReadableItems;
        typeOfProducts = TypeOfProducts.READABLEITEM;
    }

    public ReadableItem(int id, int count, double cost, int numberOfPage, TypeOfReadableItems typeOfReadableItems) {
        super(id, count, cost);
        this.numberOfPage = numberOfPage;
        this.typeOfReadableItems = typeOfReadableItems;
        typeOfProducts = TypeOfProducts.READABLEITEM;
    }

    public ReadableItem(int count, double amount, TypeOfReadableItems typeOfReadableItems) {
        super(count, amount);
        this.typeOfReadableItems = typeOfReadableItems;
    }

    public ReadableItem(int id, int count, double amount, TypeOfReadableItems typeOfReadableItems) {
        super(id, count, amount);
        this.typeOfReadableItems = typeOfReadableItems;
    }

    public ReadableItem(int count, double amount, TypeOfProducts typeOfProducts, TypeOfReadableItems typeOfReadableItems) {
        super(count, amount, typeOfProducts);
        this.typeOfReadableItems = typeOfReadableItems;
    }

    public ReadableItem(int id, int count, double amount, TypeOfProducts typeOfProducts, TypeOfReadableItems typeOfReadableItems) {
        super(id, count, amount, typeOfProducts);
        this.typeOfReadableItems = typeOfReadableItems;
    }

    public ReadableItem(TypeOfReadableItems typeOfReadableItems) {
        this.typeOfReadableItems = typeOfReadableItems;
    }

    public ReadableItem() {

    }


    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public TypeOfReadableItems getTypeOfReadableItem() {
        return typeOfReadableItems;
    }

    public void setTypeOfReadableItem(TypeOfReadableItems typeOfReadableItems) {
        this.typeOfReadableItems = typeOfReadableItems;
    }

    @Override
    public String toString() {
        return "ReadableItem{" +
                super.toString() + '\'' +
                "numberOfPage=" + numberOfPage +
                ", typeOfReadableItem=" + typeOfReadableItems +
                '}';
    }
}
