package org.app.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.controllers.UserController;
import org.app.demo3.models.UserModel;

import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/users/*"})
public class UserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserModel.loadData();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getPathInfo();
        if (uri == null) {
            uri = "";
        }
        switch (uri) {
            case "/create":
                UserController.renderPageCreateUser(req, resp);
                break;
            case "/delete":
                UserController.deleteUser(req, resp);
                break;

            case "/update":
                UserController.renderPageUpdateUser(req, resp);
                break;
            default:
                UserController.renderPageListUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getPathInfo();
        if (uri == null) {
            uri = "";
        }
        if (uri.equals("/create")) {
            UserController.createUser(req, resp);
        } else if (uri.equals("/update")) {
            UserController.updateUser(req, resp);
        } else {
            resp.sendRedirect("/users");
        }

    }
}
