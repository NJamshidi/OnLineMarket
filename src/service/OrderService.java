package service;

import dao.OrderDao;
import model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public void addOrdersForUser(int cartId, int productId, String type) {

        try {
            orderDao.insertOrder(cartId, productId, type);
        } catch (SQLException e) {
            System.out.println("can not add order for user :" + e.getMessage());
        }

    }

    public void showAllOfOrders(int cartId) {

        try {
            orderDao.getAllOrders(cartId);
        } catch (SQLException e) {
            System.out.println("can not show orders :" + e.getMessage());
        }

    }

    public void deleteProductFromCart(int orderId) {

        try {
            orderDao.remove(orderId);
        } catch (SQLException e) {
            System.out.println("can not delete product from orders :" + e.getMessage());
        }

    }
}
