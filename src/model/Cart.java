package model;

import model.products.Product;

import java.util.List;

public class Cart {
    private int id;
    private User user;
    private double totalPrice;
    private boolean cartStatus;
    private int totalCount;


    public Cart(int id, User user, double totalPrice, boolean cartStatus, int totalCount) {
        this.id = id;
        this.user = user;
        this.totalPrice = totalPrice;
        this.cartStatus = cartStatus;
        this.totalCount = totalCount;
    }

    public Cart(User user, double totalPrice, boolean cartStatus, int totalCount) {
        this.user = user;
        this.totalPrice = totalPrice;
        this.cartStatus = cartStatus;
        this.totalCount = totalCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", totalPrice=" + totalPrice +
                ", cartStatus=" + cartStatus +
                ", totalCount=" + totalCount +
                '}';
    }
}
