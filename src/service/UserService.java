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

    public boolean addUser(User user) {

        try {
            userDao.insertUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}
        public User getUserByUserNameAndPass(String username, String  password){
            try {
                return userDao.getUserByUserNameAndPass( username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public int findCountOfProductsByUserId(User user){
            return cartService.getCountOfProductsByUserId(user);
        }

    }



