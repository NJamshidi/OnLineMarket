package dao;

import model.Cart;
import model.Order;
import model.User;
import model.enums.TypeOfProducts;
import model.enums.TypeOfShoes;
import model.products.Shoe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDao extends BaseDao {
    private static class SqlStatement {
        static final String INSERT_ORDER = "INSERT INTO orders  (cartId ,productId ,typeOfProduct ) VALUES (?,?,?)";
        static final String GET_ALL_ORDER = "SELECT * FROM orders left outer join electronics on orders.productId=electronics.id and orders.typeOfProduct='electronics'" +
                "left outer join readableitems on orders.productId=readableitems.idreadableItems and orders.typeOfProduct='readableitems' " +
                "left outer join shoe on orders.productId=shoe.idshoe and orders.typeOfProduct='shoe'  where orders.cartId=? ";
        static final String  REMOVE  ="DELETE FROM orders WHERE  idorders=?";


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
            List<Order> orders = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(SqlStatement.GET_ALL_ORDER);
            statement.setInt(1, cartId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)+" "+ resultSet.getInt(2) + " "+resultSet.getInt(3)+" "+TypeOfProducts.valueOf(resultSet.getString(4)));
            }

        }
    }

    public void remove(int orderId) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.REMOVE);
            preparedStatement.setInt(1,orderId );
            preparedStatement.executeUpdate();
        }
    }
}
