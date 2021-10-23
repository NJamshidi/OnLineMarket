
import model.User;
import service.CartService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.util.Scanner;

public class Main {
    static UserService userService = new UserService();
    static CartService cartService = new CartService();
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
            System.out.println("5.confirm Order");
            System.out.println("6.update shop");
            System.out.println("7.exit");
            System.out.println("select>>");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    int cartId = addProductToCart(user);
                    showProductMenu(scanner, cartId, user);

                    break;
                case 2:
                    deleteProductFromCart(user, scanner);

                    break;
                case 3:
                    cartId = addProductToCart(user);
                    orderService.showAllOfOrders(cartId);

                    break;
                case 4:
                    System.out.println(printTotalPrice(user));
                    break;
                case 5:
                    cartId = addProductToCart(user);
                    cartService.confirmOrder(cartId);
                    System.out.println("confirm order");
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid selection. Try again please!");
            }

        }

    }

    public static int addProductToCart(User user) {
        if (!cartService.checkCartExist(user)) {
            cartService.addCartForUser(user);
            return cartService.findCartId(user);
        } else {
            return cartService.findCartId(user);
        }
    }

    public static void showProductMenu(Scanner scanner, int cartId, User user) {
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
                    System.out.println(productService.showAllOfElectronicProducts());
                    type = "electronics";
                    System.out.println("select productId for add to cart: ");
                    break;
                case "b":
                    System.out.println(productService.showAllOfReadableProducts());
                    type = "readableitem";
                    System.out.println("select productId for add to cart: ");

                    break;
                case "c":
                    System.out.println(productService.showAllOfShoes());
                    type = "shoe";
                    System.out.println("select productId for add to cart: ");

                    break;
                case "d":
                    break menu;
                default:
                    int count = userService.findCountOfProductsByUserId(user);
                    if (count < 5) {
                        System.out.printf("your cart has %o items so you can add %o items%n", count, (5 - count));
                        OrderService orderService = new OrderService();
                        int productId = Integer.parseInt(select);
                        orderService.addOrdersForUser(cartId, productId, type);
                        cartService.updateCount(cartId);
                        cartService.updateTotalPrice(cartId, productId, type);
                        System.out.println("product added to order!");
                    }else
                        System.out.println("can not add more than 5 items!");
            }
        }
    }

    public static void deleteProductFromCart(User user, Scanner scanner) {
        int cartId = cartService.findCartId(user);
        orderService.showAllOfOrders(cartId);
        System.out.println("which order delete? enter id:");
        int orderId = scanner.nextInt();
        cartService.updateTotalPriceRemove(cartId, orderId);
        orderService.deleteProductFromCart(orderId);
        cartService.updateCountRemove(cartId);
        System.out.println("product delete from order!");
    }

    public static double printTotalPrice(User user) {
        int cartId = cartService.findCartId(user);
        return cartService.printTotlaPrice(cartId);

    }

}


