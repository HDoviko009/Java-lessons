package com.example.selflesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("username") : null;

        if (username != null) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Home</title></head>");
            out.println("<body style='display:flex; justify-content:center; align-items:center; height:100vh; margin:0;'>");
            out.println("<h1 style='font-family:Arial; color:#333;'>Welcome Home, " + username + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
