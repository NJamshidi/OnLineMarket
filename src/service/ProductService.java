package service;


import dao.ProductDao;
import model.User;
import model.products.Electronics;
import model.products.ReadableItem;
import model.products.Shoe;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public List<Electronics> showAllOfElectronicProducts() {

        try {
            return productDao.getAllElectronics();
        } catch (SQLException e) {
            System.out.println("can not show electronics products :" + e.getMessage());
        }
        return null;

    }

    public List<ReadableItem> showAllOfReadableProducts() {

        try {
            return productDao.getAllReadableItems();
        } catch (SQLException e) {
            System.out.println("can not show readable products :" + e.getMessage());

        }

        return null;
    }

    public List<Shoe> showAllOfShoes() {

        try {
            return productDao.getAllShoes();
        } catch (SQLException e) {
            System.out.println("can not show shoe products :" + e.getMessage());
        }
        return null;

    }
}
