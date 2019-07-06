package com.controller;

import com.dao.LoginDao;
import sun.plugin.com.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Parameter;

@WebServlet(name = "userLoginServlet", urlPatterns = {"/userLoginServlet.do"})
public class userLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("form-username");
        String password = request.getParameter("form-password");
        LoginDao loginDao = new LoginDao();
        if (loginDao.studentLogin(username, password)) {
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            rd.forward(request, response);
        } else if (loginDao.teacherLogin(username, password)) {
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("teacher.jsp");
            rd.forward(request, response);
        } else if (loginDao.AdminLogin(username, password)) {
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);
        } else {
            String message = "您输入的用户名或密码不正确，请重新输入！";
            session.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
