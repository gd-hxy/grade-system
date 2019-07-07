package com.controller;

import com.dao.SearchDao;
import com.dao.StudentDao;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "searchAllMessageServlet", urlPatterns = {"/searchAllMessageServlet.do"})
public class searchAllMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> studentArrayList = studentDao.findAllStudent();
        session.setAttribute("studentArrayList", studentArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("selectAllStudent.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SearchDao searchDao = new SearchDao();
        ArrayList<Teacher> teacherArrayList = searchDao.findAllTeacher();
        session.setAttribute("teacherArrayList", teacherArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("selectAllTeacher.jsp");
        rd.forward(request, response);
    }
}
