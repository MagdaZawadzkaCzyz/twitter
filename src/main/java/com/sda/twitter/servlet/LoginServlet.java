package com.sda.twitter.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    //    @Override
//    public void doGet(HttpServletRequest request
//            , HttpServletResponse response
//    ) throws IOException {
//        doPost(request, response);
//    }
    @Override
    public void doPost(HttpServletRequest request
            , HttpServletResponse response
    ) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (userName.equals("admin") && password.equals("password")) {
            response.sendRedirect("/");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
