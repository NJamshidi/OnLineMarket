package service;


import dao.ProductDao;
import model.User;

import java.sql.SQLException;

public class ProductService {
    ProductDao productDao=new ProductDao();
    public void showAllOfElectronicProducts() {

        try {
            productDao.getAllElectronics();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void showAllOfReadableProducts() {

        try {
            productDao.getAllReadableItems();
        } catch (SQLException e) {

            e.printStackTrace();
        }


    }
    public void showAllOfShoes() {

        try {
            productDao.getAllShoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
        }
