package dao;

import model.Cart;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao extends BaseDao{
    private static class SqlStatement {
        static final String INSERT_ORDER = "INSERT INTO orders  (cartId ,productId ,typeOfProduct ) VALUES (?,?,?)";}
    public void insertOrder(int cartId,int productId,String type) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(OrderDao.SqlStatement.INSERT_ORDER);
            statement.setInt(1, cartId);
            statement.setInt(2, productId);
            statement.setString(3, type);

            statement.executeUpdate();
        }
    }
}
