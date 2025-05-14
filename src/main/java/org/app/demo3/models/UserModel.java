package org.app.demo3.models;

import org.app.demo3.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private static Connection connection;

    public static void loadData() {
        connection = DatabaseModel.getConnect();
    }

    public static ResultSet getAll() throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public static void removeUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, phone, address, password) VALUES (?, ?, ?, ?, 'ewewewe')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getAddress());
        statement.execute();
    }

    public static ResultSet findById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public static void update(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getAddress());
        statement.setInt(5, user.getId());
        statement.execute();
    }

}
