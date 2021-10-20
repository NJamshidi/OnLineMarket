package model;

import model.products.Product;

public class Order {
    private int id;
    private Product product;
    private Cart cart;

    public Order(int id, Product product, Cart cart) {
        this.id = id;
        this.product = product;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", cart=" + cart +
                '}';
    }
}
