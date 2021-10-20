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

  public void  showElectronics() throws SQLException {
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
    public void  showReadableItems() throws SQLException {
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
    public void  showShoe() throws SQLException {
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

/*   public Product insertProduct(ResultSet resultSet, String tableName) throws SQLException {
        switch (tableName) {
            case "electronics":
                return new Electronics(resultSet.getInt(1), resultSet.getInt(3), resultSet.getDouble(2),
                        BrandOfDevice.valueOf(resultSet.getString(4)));

            case "shoes":
                return new Shoe(resultSet.getInt(1), resultSet.getInt(3), resultSet.getDouble(2), resultSet.getInt(4),
                        resultSet.getString(5), TypeOfShoes.valueOf(resultSet.getString(6)));

            case "readable_items":
                return new ReadableItem(resultSet.getInt(1), resultSet.getInt(3), resultSet.getDouble(2), resultSet.getInt(4),
                        TypeOfReadableItems.valueOf(resultSet.getString(5)));
        }
        return null;
    }
    public List<Product> getAll(String tableName) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection= getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format("SELECT * FROM %s ;", tableName));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(insertProduct(resultSet, tableName));
            }
        }
        return products;
   } */
}
