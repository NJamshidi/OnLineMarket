package service;


import dao.CartDao;
import model.User;

import java.sql.SQLException;

public class CartService {
    CartDao cartDao = new CartDao();

    public boolean checkCartExist(User user) {

        try {
            return cartDao.checkCart(user);
        } catch (SQLException e) {
            System.out.println("can not chek cart exist or not exist :" + e.getMessage());

        }
        return false;

    }

    public void addCartForUser(User user) {

        try {
            cartDao.insertCart(user);
        } catch (SQLException e) {
            System.out.println("can not add cart for this user :" + e.getMessage());

        }


    }

    public int findCartId(User user) {

        try {
            return cartDao.getCartId(user);
        } catch (SQLException e) {
            System.out.println("can not find cartId :" + e.getMessage());

        }

        return -1;
    }

    public int getCountOfProductsByUserId(User user) {

        try {
            return cartDao.getCountOfProductsByUserId(user.getUsername());
        } catch (SQLException e) {
            System.out.println("can not find count of products by userId :" + e.getMessage());

        }

        return 0;
    }

    public void updateCount(int cartId) {
        try {
            cartDao.updateCount(cartId);
        } catch (SQLException e) {
            System.out.println("can not increase count of items in cart when add product in cart :" + e.getMessage());

        }

    }

    public void updateCountRemove(int cartId) {
        try {
            cartDao.updateCountRemove(cartId);
        } catch (SQLException e) {
            System.out.println("can not decrees count of items in cart when delete product in cart :" + e.getMessage());

        }

    }

    public double printTotlaPrice(int cartId) {

        try {
            return cartDao.getTotalPrice(cartId);
        } catch (SQLException e) {
            System.out.println("can not print totalPrice in cart :" + e.getMessage());

        }

        return 0;
    }

    public void updateTotalPrice(int cartId, int productId, String type) {
        try {
            cartDao.updateTPrice(cartId, productId, type);
        } catch (SQLException e) {
            System.out.println("can not increase totalPrice when add items in cart :" + e.getMessage());

        }

    }

    public void updateTotalPriceRemove(int cartId, int orderId) {
        try {
            cartDao.updateTPriceRemove(cartId, orderId);
        } catch (SQLException e) {
            System.out.println("can not decrees totalPrice when delete items in cart :" + e.getMessage());

        }

    }

    public void confirmOrder(int cartId) {

        try {
            cartDao.confirm(cartId);
        } catch (SQLException e) {
            System.out.println("confirm order" + e.getMessage());

        }

    }

}


