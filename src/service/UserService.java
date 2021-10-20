package service;

import dao.UserDao;
import model.User;
import model.products.Product;

import java.sql.SQLException;

public class UserService {
    UserDao userDao = new UserDao();
    CartService cartService = new CartService();

    public User getByUserName(String userName) {
        try {
            return userDao.getUserByUserName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(String username, String pass,String address) {

        try {
            userDao.insertUser(new User(username, pass ,address));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


}
