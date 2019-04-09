package model;

import entity.FeedBack;

import java.sql.*;

public class FeedBackModel {
   private  static Connection connection;
   static {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost/user?user=root&&password=")
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           System.out.println("SQLException"+e.getMessage());
       }
   }

   public boolean insert(FeedBack feedBack){
       try {
           PreparedStatement preparedStatement  = connection.prepareStatement("insert into customer(content) values (?)");
           preparedStatement.setString(1,feedBack.getContend());
       } catch (SQLException e) {
           System.out.println("SQLExceeption"+e.getMessage());
           return true;
       }
       return false;
   }
}
