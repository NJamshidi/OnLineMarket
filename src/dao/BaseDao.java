package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private Connection connection;


    protected Connection getConnection() throws SQLException {

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineShop", "root", "123asPKb73!");
        return connection;
    }
}