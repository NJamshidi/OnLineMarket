package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    UserDao userDao = new UserDao();

    public User getByUserName(String userName) {
        try {
            return userDao.getUserByUserName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(String username, String pass) {

        try {
            userDao.insertUser(new User(username, pass));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
