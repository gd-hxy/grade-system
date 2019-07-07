package com.controller;

import com.dao.SearchDao;
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

@WebServlet(name = "teacherCourseServlet", urlPatterns = {"/teacherCourseServlet.do"})
public class teacherCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String term = request.getParameter("term");
        String tno = (String) session.getAttribute("username");
        SearchDao searchDao = new SearchDao();
        ArrayList<Teacher> teachers = searchDao.searchCourseThisTerm(tno, term);
        session.setAttribute("teachers", teachers);
        RequestDispatcher rd = request.getRequestDispatcher("teachSituation.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
