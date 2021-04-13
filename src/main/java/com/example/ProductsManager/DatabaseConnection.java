package com.example.ProductsManager;
import java.sql.*;
import com.example.ProductsManager.*;


public class DatabaseConnection {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6403704";

        Connection con=DriverManager.getConnection(url, "sql6403704", "5rHvBDiza5");
        return con;
    }
}





