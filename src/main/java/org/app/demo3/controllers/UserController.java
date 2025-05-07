package org.app.demo3.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.UserServlet;
import org.app.demo3.entities.User;
import org.app.demo3.services.UserService;

import java.io.IOException;
import java.util.List;

public class UserController {
    public static void renderPageListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserService.getAllUser();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/users/list.jsp");
        requestDispatcher.forward(request, response);
    }

    public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService.destroyUser(request, response);
        response.sendRedirect("/users");
    }
}
