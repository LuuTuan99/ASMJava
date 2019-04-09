package model;
import entity.User;


import java.sql.*;

public class UserModel {

    private  static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/user?user=root&&password=");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLExeption"+e.getMessage());
        }
    }

    public  boolean insert(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customer (fullname, username, password) values (?,?,?)");
            preparedStatement.setString(1,user.getFullname());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQLExeption"+e.getMessage());
        }
        return false;
    }
    public User getByUser(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String existFullName = resultSet.getString(1);
                String existUserName = resultSet.getString(2);
                String existPassword = resultSet.getString(3);
                 User user = new User(existFullName,existUserName,existPassword);
                 return user;
            }
        } catch (SQLException e) {
            System.out.println("SQLException"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
