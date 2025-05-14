package org.app.demo3.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.entities.User;
import org.app.demo3.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static boolean checkAccount(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        return email.equals("admin") && pass.equals("1234");
    }

    public static List<User> getAllUser() throws SQLException {
        ResultSet resultSet = UserModel.getAll();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            User u = new User(id, name, email, phone, address);
            users.add(u);
        }
        return users;
    }

    public static void destroyUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel.removeUser(id);
    }

    public static void  storeUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User u = new User(name, email, phone, address);
        UserModel.save(u);
    }

    public static  User getUserById(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        ResultSet resultSet = UserModel.findById(id);
        User user = null;
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            user = new User(id, name, email, phone, address);
        }
        return user;
    }

    public static void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User u = new User(id, name, email, phone, address);
        UserModel.update(u);
    }
}
