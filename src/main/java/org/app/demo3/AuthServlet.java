package org.app.demo3;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.controllers.AuthController;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthServlet", urlPatterns = {"/auth/*"})
public class AuthServlet extends HttpServlet {
    public AuthServlet() {

    }

    @Override
    public void init() throws ServletException {
        System.out.println("AuthServlet Init");
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getPathInfo();
        switch (uri) {
            case "/login":
                AuthController.showFormLogin(req, resp);
                break;
            case "/register":
                AuthController.showFormRegister(req, resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getPathInfo();
        switch (uri) {
            case "/login":
                AuthController.login(req, resp);
                break;
        }
    }
}
