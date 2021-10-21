package service;

import dao.OrderDao;
import model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public void addOrdersForUser(int cartId,int productId,String type) {

        try {
            orderDao.insertOrder(cartId,productId,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void showAllOfOrders(int cartId) {

        try {
            orderDao.getAllOrders(cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteProductFromCart(int productId,int cartId){

        try {
            orderDao.remove(productId,cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
