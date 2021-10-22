package model;

import model.enums.TypeOfProducts;
import model.products.Product;

public class Order {
    private int id;
    private Product product;
    private Cart cart;
    private TypeOfProducts typeOfProducts;

    public Order(int id, Product product, Cart cart, TypeOfProducts typeOfProducts) {
        this.id = id;
        this.product = product;
        this.cart = cart;
        this.typeOfProducts = typeOfProducts;
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

    public TypeOfProducts getTypeOfProducts() {
        return typeOfProducts;
    }

    public void setTypeOfProducts(TypeOfProducts typeOfProducts) {
        this.typeOfProducts = typeOfProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", cart=" + cart +
                ", typeOfProducts=" + typeOfProducts +
                '}';
    }
}
