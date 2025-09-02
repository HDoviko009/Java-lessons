package com.example.selflesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Login</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background:#0f172a; color:#e5e7eb; display:flex; justify-content:center; align-items:center; height:100vh; margin:0; }");
        out.println(".login-box { background:#111827; padding:30px; border-radius:12px; box-shadow:0 5px 20px rgba(0,0,0,.3); width:300px; }");
        out.println(".login-box h2 { text-align:center; margin-bottom:20px; color:#22d3ee; }");
        out.println("input[type=text], input[type=password] { width:100%; padding:10px; margin:8px 0; border:1px solid #374151; border-radius:8px; background:#1f2937; color:#fff; }");
        out.println("input[type=submit] { width:100%; background:#22d3ee; color:#001; padding:10px; border:none; border-radius:8px; font-weight:bold; cursor:pointer; }");
        out.println("input[type=submit]:hover { filter:brightness(0.95); }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='login-box'>");
        out.println("<h2>Login</h2>");
        out.println("<form action='login' method='post'>");
        out.println("<input type='text' placeholder='Username' name='username'>");
        out.println("<input type='password' placeholder='Password' name='password'>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("admin") && password.equals("admin123")) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            resp.sendRedirect(req.getContextPath() + "/Home");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }
}
