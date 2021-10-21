package dao;

import model.Cart;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao extends BaseDao {
    private static class SqlStatement {
        static final String INSERT_ORDER = "INSERT INTO orders  (cartId ,productId ,typeOfProduct ) VALUES (?,?,?)";
    }

    public void insertOrder(int cartId, int productId, String type) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(OrderDao.SqlStatement.INSERT_ORDER);
            statement.setInt(1, cartId);
            statement.setInt(2, productId);
            statement.setString(3, type);

            statement.executeUpdate();
        }
    }

    public void getAllOrders(int cartId) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            String sql = "SELECT * FROM orders left outer join electronics on orders.productId=electronics.id and orders.typeOfProduct='electronics'" +
                    "left outer join readableitems on orders.productId=readableitems.idreadableItems and orders.typeOfProduct='readableitems' " +
                    "left outer join shoe on orders.productId=shoe.idshoe and orders.typeOfProduct='shoe'  where orders.cartId=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cartId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("productId") + " " + resultSet.getInt("count") + " " + resultSet.getDouble("amount"));
            }

        }
    }

    public void remove(int productId, int cartId) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            String sql = "DELETE FROM orders WHERE cartId=? and productId=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Cart cart =new Cart();
            preparedStatement.setInt(1,cartId );
            preparedStatement.setInt(2,productId );
            preparedStatement.executeUpdate();
        }
    }
}
