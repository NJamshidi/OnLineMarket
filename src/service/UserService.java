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
            System.out.println("can not find user by this username :" + e.getMessage());
        }
        return null;
    }

    public boolean addUser(User user) {

        try {
            userDao.insertUser(user);
            return true;
        } catch (SQLException e) {
            System.out.println("can not add user :" + e.getMessage());
            return false;
        }
    }

    public User getUserByUserNameAndPass(String username, String password) {
        try {
            return userDao.getUserByUserNameAndPass(username, password);
        } catch (SQLException e) {
            System.out.println("can not find each user by username and password :" + e.getMessage());
        }
        return null;
    }

    public int findCountOfProductsByUserId(User user) {
        return cartService.getCountOfProductsByUserId(user);
    }

}



