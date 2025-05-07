package org.app.demo3.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.entities.User;
import org.app.demo3.models.UserModel;

import java.util.List;

public class UserService {
    public static boolean checkAccount(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        return email.equals("admin") && pass.equals("1234");
    }

    public static List<User> getAllUser() {
        return UserModel.getAll();
    }

    public static void destroyUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel.removeUser(id);
    }
}
