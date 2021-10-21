package dao;


import model.Cart;
import model.User;
import model.products.Product;
import model.products.ReadableItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao extends BaseDao {


    private static class SqlStatement {
        static final String GET_BY_USERID = "SELECT * FROM carts where userId=(select idUsers from users where userName=? limit 1) AND cartStatus=0;";
        static final String GET_CART_ID = "SELECT idcarts FROM carts where userId=(select idUsers from users where userName=? limit 1) AND cartStatus=0 limit 1;";
        static final String INSERT_CART = "INSERT INTO carts  (userid ,totalPrice ,totalCount ) VALUES (?,?,?)";
        static final String INSERT_CART2 = "INSERT INTO carts (userid ,totalPrice ,totalCount) SELECT idusers,0,0 FROM users where userName=?";
    }

    public boolean checkCart(User user) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.GET_BY_USERID);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            int counter = 0;
            while (resultSet.next()) {
                counter++;
            }
            return counter != 0;
        }
        return false;
    }

    public void insertCart(User user) throws SQLException {

        int totalPrice = 0;
        Cart cart = new Cart(user, totalPrice, false, 0);
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.INSERT_CART2);
            statement.setString(1, user.getUsername());

            statement.executeUpdate();
        }
    }
    public int getCartId(User user) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.GET_CART_ID);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            int counter = 0;
            while (resultSet.next()) {
                counter=resultSet.getInt("idcarts");
            }
            return counter ;
        }
        return 0;
    }






    public int getCountOfProductsByUserId(int id) throws SQLException {
        int count = 0;
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.GET_BY_USERID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                count++;
        }
        return count;
    }

}
