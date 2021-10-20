package service;


import dao.CartDao;
import model.Cart;
import model.User;

import java.sql.SQLException;

public class CartService {
    CartDao cartDao = new CartDao();

    public boolean addCart(User user) {

        try {
            cartDao.insertCart(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}

        public int findCountOfProductByUserId ( int id){
            try {
                return cartDao.getCountOfProductsByUserId(id);
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return 0;
        }

}
