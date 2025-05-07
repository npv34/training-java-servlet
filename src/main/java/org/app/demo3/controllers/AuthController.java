package org.app.demo3.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.demo3.services.UserService;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthController {
    public static void showFormLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String error = req.getParameter("error");
        if ("true".equals(error)) {
            req.setAttribute("message-error", "Account not exist!");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
        requestDispatcher.forward(req, res);
    }

    public static void showFormRegister(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter printWriter = res.getWriter();
        printWriter.write("<h1>Register page</h1>");
        printWriter.close();
    }

    public static void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (UserService.checkAccount(req, res)) {
            res.sendRedirect("/users");
        }else {
            res.sendRedirect("/auth/login?error=true");
        }
    }
}
