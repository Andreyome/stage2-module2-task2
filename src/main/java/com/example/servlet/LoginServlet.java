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
resp.sendRedirect("/user/hello.jsp");
        }
        else{
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
if( Users.getInstance().getUsers().contains(req.getParameter("login"))&& !(req.getParameter("password")==null) && !(req.getParameter("password").trim().isEmpty())){
    req.getSession().setAttribute("user",req.getParameter("login"));
    resp.sendRedirect("/user/hello.jsp");
}
else{
    req.getRequestDispatcher("/login.jsp").forward(req, resp);
}
    }
//write your code here!
}
