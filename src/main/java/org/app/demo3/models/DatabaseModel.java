package org.app.demo3.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseModel {
    public static Connection getConnect() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String mysql_url = "jdbc:mysql://localhost:3306/demo2";
            String username = "root";
            String password = "123456@Abc";
            conn = DriverManager.getConnection(mysql_url, username, password);
            System.out.println("Connect db oke");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return conn;
    }
}
