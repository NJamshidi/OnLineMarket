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
    public void showAllOrders(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            String sql="SELECT * FROM orders left outer join electronics on orders.productId=electronics.id and orders.typeOfProduct='electronics'" +
                    "left outer join readableitems on orders.productId=readableitems.idreadableItems and orders.typeOfProduct='readableitems' "+
                    "left outer join shoe on orders.productId=shoe.idshoe and orders.typeOfProduct='shoe'  where orders.cartId=? " ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cartId);

           ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("productId")+" "+resultSet.getInt("count")+" "+resultSet.getDouble("amount"));
            }

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

}
