package service;


import dao.CartDao;
import model.User;

import java.sql.SQLException;

public class CartService {
    CartDao cartDao = new CartDao();

    public boolean checkCartExist(User user) {

        try {
          return   cartDao.checkCart(user);
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
         return   cartDao.getCartId(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int getCountOfProductsByUserId(User user) {

        try {
        return    cartDao.getCountOfProductsByUserId(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void updateCount(int cartId) {
        try {
            cartDao.updateCount(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateCountRemove(int cartId) {
        try {
            cartDao.updateCountRemove(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public double printTotlaPrice(int cartId) {

        try {
            return    cartDao.getTotalPrice(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public void updateTotalPrice(int cartId,int productId,String type) {
        try {
            cartDao.updateTPrice(cartId,productId,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateTotalPriceRemove(int cartId,int orderId) {
        try {
            cartDao.updateTPriceRemove(cartId,orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void confirmOrder(int cartId) {

        try {
                cartDao.confirm(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("confirm order");

        }

    }

}


