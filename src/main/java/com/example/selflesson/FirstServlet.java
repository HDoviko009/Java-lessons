package com.example.selflesson;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstPage")
public class FirstServlet implements Servlet {
    ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        PrintWriter out = servletResponse.getWriter();
        out.println("Hello " + username + " " + password);
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
