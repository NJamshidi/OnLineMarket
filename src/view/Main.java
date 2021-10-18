package view;

import model.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Enter userName: ");

    }

    public static void showMenu() {
        System.out.println("1.Add product to cart");
        System.out.println("2.Remove product from cart");
        System.out.println("3.Show a list of products with details");
        System.out.println("4.Show the total prices cart");
        System.out.println("5.exit");
    }

}