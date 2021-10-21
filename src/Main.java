import dao.CartDao;
import dao.OrderDao;
import dao.ProductDao;
import model.Cart;
import model.Order;
import model.User;
import model.products.Product;
import service.CartService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static UserService userService = new UserService();
    static CartService cartService = new CartService();
    static ProductService productService = new ProductService();
    static OrderService orderService = new OrderService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Enter userName: ");
        String username = scanner.nextLine();
        User user = userService.getByUserName(username);

        if (user == null) {
            System.out.println("user not exit");
            System.out.println("enter password:");
            String pass = scanner.nextLine();
            System.out.println("enter address:");
            String address = scanner.next();
            user = new User(username, pass, address);
            userService.addUser(user);
            showMenu(user);

        } else {
            while (true) {
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                user = userService.getUserByUserNameAndPass(username, password);
                if (user != null) {
                    showMenu(user);


                } else {
                    System.out.println("the password is incorrect");
                }
            }
        }

    }


    public static void showMenu(User user) {
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
                    int cartId = addProductToCart(user);
                    showProductMenu(scanner, cartId);

                    break;
                case 2:
                    deleteProductFromCart(user, scanner);
                    break;
                case 3:
                    cartId = addProductToCart(user);
                    orderService.showAllOfOrders(cartId);

                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid selection. Try again please!");
            }

        }

    }

    public static int addProductToCart(User user) {
        CartService cartService = new CartService();
        if (!cartService.checkCartExist(user)) {
            cartService.addCartForUser(user);
            return cartService.findCartId(user);
        } else {
            return cartService.findCartId(user);
        }
    }

    public static void showProductMenu(Scanner scanner, int cartId) {
        String type = null;

        menu:
        while (true) {
            System.out.println("select categories");
            System.out.println("a.electronics");
            System.out.println("b.readableItems");
            System.out.println("c.shoe");
            System.out.println("d.exit");
            ProductService productService = new ProductService();

            String select = scanner.next();
            switch (select) {
                case "a":
                    productService.showAllOfElectronicProducts();
                    type = "electronics";
                    break;
                case "b":
                    productService.showAllOfReadableProducts();
                    type = "readableItem";

                    break;
                case "c":
                    productService.showAllOfShoes();
                    type = "shoe";

                    break;
                case "d":
                    break menu;
                default:
                    OrderService orderService = new OrderService();
                    int productId = Integer.parseInt(select);
                    orderService.addOrdersForUser(cartId, productId, type);
                    System.out.println("product added to order!");
            }
        }
    }

    public static void deleteProductFromCart(User user, Scanner scanner) {
        int cartId = cartService.findCartId(user);
        ProductService productService = new ProductService();
        productService.showAllOfElectronicProducts();
        productService.showAllOfReadableProducts();
        productService.showAllOfShoes();
        OrderService orderService = new OrderService();
        System.out.println("which product delete? enter id:");
        int productId = scanner.nextInt();
        orderService.deleteProductFromCart(productId, cartId);
        System.out.println("product delete from order!");
    }
}


