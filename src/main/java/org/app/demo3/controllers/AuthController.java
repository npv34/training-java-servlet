package org.app.demo3.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthController {
    public static void showFormLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String error = req.getParameter("error");
        if ("true".equals(error)) {
            req.setAttribute("message-error", "Account not exist!");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        System.out.println(requestDispatcher);
        requestDispatcher.forward(req, res);
    }

    public static void showFormRegister(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter printWriter = res.getWriter();
        printWriter.write("<h1>Register page</h1>");
        printWriter.close();
    }

    public static void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        if (email.equals("admin") && pass.equals("1234")) {
            res.sendRedirect("/home");
        }else {

            res.sendRedirect("/auth/login?error=true");
        }
    }
}
