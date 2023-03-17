package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!(req.getSession().getAttribute("user")==null)){
resp.sendRedirect("/login.jsp");
        }
        else{
            resp.sendRedirect("/user/hello.jsp.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
if( Users.getInstance().getUsers().contains(req.getParameter("login"))&& (req.getParameter("password")!=null)){
    resp.sendRedirect("/user/hello.jsp");
    req.getSession().setAttribute("user",req.getParameter("login"));
}
else{
    resp.sendRedirect("/login.jsp");
}
    }
//write your code here!
}
