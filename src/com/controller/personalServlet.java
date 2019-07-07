package com.controller;

import com.dao.StudentDao;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "personalServlet", urlPatterns = {"/personalServlet.do"})
public class personalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sno = (String)session.getAttribute("username");
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.findById(sno);
        session.setAttribute("studentMessage", student);
        RequestDispatcher rd = request.getRequestDispatcher("studentMessage.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
