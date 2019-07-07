package com.controller;

import com.dao.SearchDao;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "searchHomeServlet", urlPatterns = {"/searchHomeServlet.do"})
public class searchHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SearchDao searchDao = new SearchDao();
        ArrayList<Student> studentArrayList = searchDao.searchStudentHome();
        session.setAttribute("studentArrayList", studentArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("studentHome.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
