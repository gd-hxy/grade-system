package com.controller;

import com.dao.SearchDao;
import com.model.classCourse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "classSearchServlet", urlPatterns = {"/classSearchServlet.do"})
public class classSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sno = (String) session.getAttribute("username");
        String term = request.getParameter("term");
        SearchDao searchDao = new SearchDao();
        ArrayList<classCourse> classCourseArrayList = searchDao.searchClassCourse(sno, term);
        session.setAttribute("classCourseArrayList", classCourseArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("courseOfClass.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
