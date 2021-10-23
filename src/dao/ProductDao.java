package dao;


import model.enums.BrandOfDevice;
import model.enums.TypeOfProducts;
import model.enums.TypeOfReadableItems;
import model.enums.TypeOfShoes;
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

    public List<Electronics> getAllElectronics() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            List<Electronics> electronics = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM electronics");
            while (resultSet.next()) {
                Electronics electronics1 = new Electronics(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3), BrandOfDevice.valueOf(resultSet.getString(4)));
                electronics.add(electronics1);
            }
            return electronics;
        } else {
            return Collections.emptyList();
        }
    }

    public List<ReadableItem> getAllReadableItems() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            List<ReadableItem> readableItems = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM readableitems");
            while (resultSet.next()) {
                ReadableItem readableItem = new ReadableItem(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3), TypeOfReadableItems.valueOf(resultSet.getString(4)));
                readableItems.add(readableItem);
            }
            return readableItems;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Shoe> getAllShoes() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            List<Shoe> shoes = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shoe");
            while (resultSet.next()) {
                Shoe shoe = new Shoe(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getString(5), TypeOfShoes.valueOf(resultSet.getString(6)));
                shoes.add(shoe);
            }
            return shoes;
        } else {
            return Collections.emptyList();
        }
    }

    public void updateCoutOfProductsInShop(int productId, String type) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement;
            if (type.equals("electronics")) {
                statement = connection.prepareStatement("update electronics set count=count-1 where id=?");
            } else if (type.equals("readableitem")) {
                statement = connection.prepareStatement("update readableitems set count=count-1 where idreadableItems=?");
            } else {
                statement = connection.prepareStatement("update shoe set count=count-1 where idshoe=?");
            }
            statement.setInt(1, productId);
            statement.executeUpdate();

        }

    }

    public int checkCountOfProductsInShop(int productId, String type) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement statement;
            if (type.equals("electronics")) {
                statement = connection.prepareStatement("select count from electronics where id=?");

            } else if (type.equals("readableitem")) {
                statement = connection.prepareStatement("select count from readableitems where idreadableItems=?");
            } else {
                statement = connection.prepareStatement("select count from shoe  where idshoe=?");
            }
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            int counter = 0;
            while (resultSet.next()) {
                counter = resultSet.getInt("count");
            }
            return counter;

        }
        return 0;
    }

}
