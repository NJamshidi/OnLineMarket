import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Enter userName: ");
        String username = scanner.nextLine();
        User user = userService.getByUserName(username);
        if (user == null) {
            System.out.println("user not exit");
            System.out.println("enter password:");
            String pass = scanner.nextLine();
            boolean result = userService.addUser(username, pass);
            if (result == true)
                showMenu();
            else
                return;
        } else {
            System.out.println("enter password:");
            String pass = scanner.nextLine();
            if (user.getPassword().equals(pass))
                showMenu();
            else
                return;
        }
    }

    public static void showMenu() {
        while (true) {
            System.out.println("*** Welcome to Online Market ***");
            System.out.println("1.Add product to cart");
            System.out.println("2.Remove product from cart");
            System.out.println("3.Show a list of products with details");
            System.out.println("4.Show the total prices cart");
            System.out.println("5.exit");
            System.out.println("select>>");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection. Try again please!");
            }

        }

    }
}