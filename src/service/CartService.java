package service;


import dao.CartDao;
import model.User;

import java.sql.SQLException;

public class CartService {
    CartDao cartDao = new CartDao();

    public boolean checkCartExist(User user) {

        try {
            cartDao.checkCart(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void addCartForUser(User user) {

        try {
            cartDao.insertCart(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public int findCartId(User user) {

        try {
            cartDao.getCartId(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
