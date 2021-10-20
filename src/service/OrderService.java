package service;

import dao.OrderDao;

import java.sql.SQLException;
public class OrderService {
    OrderDao orderDao = new OrderDao();

    public void addOrdersForUser(int cartId,int productId,String type) {

        try {
            orderDao.insertOrder(cartId,productId,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
