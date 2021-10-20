package dao;


import model.products.Electronics;
import model.products.Product;
import model.products.ReadableItem;
import model.products.Shoe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ProductDao extends BaseDao {

  public void  getAllElectronics() throws SQLException {
      Connection connection = getConnection();
      if (connection != null) {
          List<Electronics> electronics = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * FROM electronics");
          while (resultSet.next()) {
              System.out.println(resultSet.getInt("count")+" "+resultSet.getDouble("amount")+" "+resultSet.getString("brandOfDevice"));
          }

//          return electronics;
//      } else {
//          return Collections.emptyList();
      }
  }
    public void  getAllReadableItems() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            List<ReadableItem> readableItems = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM readableitems");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("count")+" "+resultSet.getDouble("amount")+ " "+resultSet.getString("typeOfReadableItems"));
            }

//            return readableItems;
//        } else {
//            return Collections.emptyList();
        }
    }
    public void  getAllShoes() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            List<Shoe> shoes = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shoe");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("count")+" "+resultSet.getDouble("amount")+" "+resultSet.getInt("size")+ " " +resultSet.getString("color")+" "+resultSet.getString("typeOfShoe"));
            }

//            return shoes;
//        } else {
//            return Collections.emptyList();
        }
    }


}
