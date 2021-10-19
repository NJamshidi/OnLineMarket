package model.products;

import model.enums.TypeOfReadableItems;

public class ReadableItem extends Product {
    private int numberOfPage;
    private TypeOfReadableItems typeOfReadableItem;

    public ReadableItem(int count, double amount, int numberOfPage, TypeOfReadableItems typeOfReadableItem) {
        super(count, amount);
        this.numberOfPage = numberOfPage;
        this.typeOfReadableItem = typeOfReadableItem;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public TypeOfReadableItems getTypeOfReadableItem() {
        return typeOfReadableItem;
    }

    public void setTypeOfReadableItem(TypeOfReadableItems typeOfReadableItem) {
        this.typeOfReadableItem = typeOfReadableItem;
    }

    @Override
    public String toString() {
        return "ReadableItem{" +
                super.toString() + '\'' +
                "numberOfPage=" + numberOfPage +
                ", typeOfReadableItem=" + typeOfReadableItem +
                '}';
    }
}
