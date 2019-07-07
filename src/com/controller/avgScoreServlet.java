package com.controller;

import com.dao.SearchDao;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "avgScoreServlet", urlPatterns = {"/avgScoreServlet.do"})
public class avgScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tno = (String)session.getAttribute("username");
        SearchDao searchDao = new SearchDao();
        ArrayList<Teacher> teacherArrayList = searchDao.searchAvgScore(tno);
        session.setAttribute("avgScore", teacherArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("avgScore.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
