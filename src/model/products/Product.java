package model.products;

public class Product {
   private int count;
   private double amount;

    public Product(int count, double amount) {
        this.count = count;
        this.amount = amount;
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
                "count=" + count +
                ", amount=" + amount +
                '}';
    }
}
