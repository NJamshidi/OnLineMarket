import dao.CartDao;
import dao.ProductDao;
import model.User;
import model.products.Product;
import service.CartService;
import service.ProductService;
import service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static UserService userService = new UserService();
    static CartService cartService = new CartService();
    static ProductService productService = new ProductService();
    ProductDao productDao = new ProductDao();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Enter userName: ");
        String username = scanner.nextLine();
//        User user = userService.getByUserName(username);

//        if (user == null) {
            System.out.println("user not exit");
            System.out.println("enter password:");
            String pass = scanner.nextLine();
            System.out.println("enter address:");

            String address=scanner.next();
//            boolean result = userService.addUser(username, pass ,address);
//            if (result == true)
            User user=new User(username, pass ,address);
UserService userService =new UserService();
userService.addUser(username,pass,address);
            showMenu(user);
//            else
//                return;
//        } else {
//            System.out.println("enter password:");
//            String pass = scanner.nextLine();
//            if (user.getPassword().equals(pass))
//                showMenu(user);
////            else
////                return;
//        }
    }

    public static void showMenu(User user) throws SQLException {
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
                    addProductToCart(user);
                    showProductMenu(scanner);


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

    public static void addProductToCart(User user) throws SQLException {

//      int count =  cartService.findCountOfProductByUserId(user.getId());
//        if (count < 5) {

            CartDao cartDao=new CartDao();
            if(!cartDao.checkCartExist(user)){
                cartDao.insertCart(user);

            }else
                System.out.println('2');
//            cartDao.insertCart(user);
//            cartService.addCart(user);
//        } else
//            System.out.println("you can not add more than 5 item!");

        }
        public static void showProductMenu(Scanner scanner){
            System.out.println("select categories");
            System.out.println("1.electronics");
            System.out.println("2.readableItems");
            System.out.println("3.shoe");
            int select= scanner.nextInt();
            switch (select) {
                case 1:
                productDao.showElectronics();
                break;
                case 2:
                    productDao.showReadableItems();
                    break;
                case 3:
                    productDao.showShoe();
                    break;

            }
        }
  /*  private static void addProductToCart(User user) {
        int count = userService.findCountOfItemsInCart(user);
        if (count < 5) {
            List<Product> products = productService.getAllProducts();
            int productsSize = showAllProducts(products);
            System.out.print("Enter number of product: ");
            Scanner scanner =new Scanner(System.in);
            int number = scanner.nextInt();
            if (number > productsSize + 1) {
                System.out.println("invalid Input");;
                return;
            }
            Product product =   returnProductInListWithNumber(products, number - 1);
            if (product == null)
                return;
            if (product.getCount() == 0) {
                System.out.println("finished");
                return;
            }

            System.out.println("your item : " + product.toString());
            int countOfOrder = scanner.nextInt();
            while (!countOfOrderIsValid(product, countOfOrder)) {
                System.out.println("it is more than the allowed count");
                countOfOrder = scanner.nextInt();
            }
            System.out.println(product.getTypeOfProducts().toString().toLowerCase());

        } else
            System.out.println("you can not add more to cart");
    }



    private static int showAllProducts(List<Product> lists) {
        int index = 0;
        for (Product list : lists) {
            System.out.println((++index) + ")" + list);
        }
        return index;
    }
    private static Product returnProductInListWithNumber(List<Product> lists, int number) {
        return lists.get(number);
    }

    private static boolean countOfOrderIsValid(Product product, int countOfOrder) {
        return product.getCount() >= countOfOrder;
    } */
}