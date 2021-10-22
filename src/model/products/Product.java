package model.products;

import model.enums.TypeOfProducts;

public class Product {
    private int id;
   private int count;
   private double amount;
   TypeOfProducts typeOfProducts;

    public Product(int count, double amount) {
        this.count = count;
        this.amount = amount;
    }

    public Product(int id, int count, double amount) {
        this.id = id;
        this.count = count;
        this.amount = amount;
    }
    public Product( int count, double amount, TypeOfProducts typeOfProducts) {
        this.count = count;
        this.amount = amount;
        this.typeOfProducts = typeOfProducts;
    }

    public Product(int id, int count, double amount, TypeOfProducts typeOfProducts) {
        this.id = id;
        this.count = count;
        this.amount = amount;
        this.typeOfProducts = typeOfProducts;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeOfProducts getTypeOfProducts() {
        return typeOfProducts;
    }

    public void setTypeOfProducts(TypeOfProducts typeOfProducts) {
        this.typeOfProducts = typeOfProducts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", count=" + count +
                ", amount=" + amount +
                ", typeOfProducts=" + typeOfProducts +
                '}';
    }
}
