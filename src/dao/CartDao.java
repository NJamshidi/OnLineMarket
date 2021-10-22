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
        static final String INSERT_CART2 = "INSERT INTO carts (userid ,totalPrice ,totalCount) SELECT idusers,0,0 FROM users where userName=?";
        static final String UPDATE_COUNT = "update carts set totalCount= totalCount+1 where idcarts=?";
        static final String UPDATE_COUNT_REMOVE = "update carts set totalCount= totalCount-1 where idcarts=?";
        static final String GET_TOTAL_PRICE = "select totalPrice from carts  where idcarts=?";
        static final String UPDATE_TOTAL_PRICEE = "update carts set totalPrice=(select amount from electronics where id=?)+totalPrice where idcarts=?";
        static final String UPDATE_TOTAL_PRICER = "update carts set totalPrice=(select amount from readableitems where idreadableItems=?)+totalPrice where idcarts=?";
        static final String UPDATE_TOTAL_PRICES = "update carts set totalPrice=(select amount from shoe where idshoe=?)+totalPrice where idcarts=?";
        static final String UPDATE_TOTAL_PRICE_REMOVE = "update carts set totalPrice=(select amount from shoe where idshoe=?)-totalPrice where idcarts=?";
        static final String CONFIRM_ORDER = "update carts set cartStatus=1 where idcarts=?";
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
                counter = resultSet.getInt("idcarts");
            }
            return counter;
        }
        return -1;
    }

    public void updateCount(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_COUNT);
            statement.setInt(1, cartId);

            statement.executeUpdate();

        }

    }

    public void updateCountRemove(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_COUNT_REMOVE);
            statement.setInt(1, cartId);

            statement.executeUpdate();

        }

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

    public double getTotalPrice(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.GET_TOTAL_PRICE);
            preparedStatement.setInt(1, cartId);
            ResultSet resultSet = preparedStatement.executeQuery();
            int counter = 0;
            while (resultSet.next()) {
                counter = resultSet.getInt("totalPrice");
            }
            return counter;
        }
        return -1;
    }

    public void updateTPrice(int cartId, int productId, String type) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement;
            if (type.equals("electronics")) {
                statement = connection.prepareStatement(SqlStatement.UPDATE_TOTAL_PRICEE);
            } else if (type.equals("readableitem")) {
                statement = connection.prepareStatement(SqlStatement.UPDATE_TOTAL_PRICER);
            } else {
                statement = connection.prepareStatement(SqlStatement.UPDATE_TOTAL_PRICES);
            }
            statement.setInt(1, productId);
            statement.setInt(2, cartId);
            statement.executeUpdate();

        }

    }

    public void updateTPriceRemove(int cartId, int orderId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.UPDATE_TOTAL_PRICE_REMOVE);
            statement.setInt(1, orderId);
            statement.setInt(2, cartId);
            statement.executeUpdate();
        }
    }

    public void confirm(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.CONFIRM_ORDER);
            statement.setInt(1, cartId);
            statement.executeUpdate();
        }
    }
}
