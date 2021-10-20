package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends BaseDao{
    private static class SqlStatement{
        static final String GET_BY_USERNAME="SELECT * FROM users where userName=?";
        static final String INSERT_USER="INSERT INTO users  (userName, password ,address ) VALUES (?,?,?)";
    }
    public void insertUser(User user) throws SQLException {
      Connection connection= getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(SqlStatement.INSERT_USER);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getAddress());
            statement.executeUpdate();

        }
    }
    public User getUserByUserName(String username) throws SQLException {
        Connection connection= getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatement.GET_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUser(resultSet);
            }
        }
        return null;
    }
    public User createUser(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet.getString(2));
        return new User(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
    }

}
