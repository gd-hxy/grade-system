package com.controller;

import com.dao.SearchDao;
import com.model.Rank;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "courseSearchServlet", urlPatterns = {"/courseSearchServlet.do"})
public class courseSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String term = request.getParameter("term");
        String sno = (String) session.getAttribute("username");
        float sum = 0;
        SearchDao searchDao = new SearchDao();
        ArrayList<Rank> ranks = searchDao.searchCourseAndCredit(sno, term);
        for (Rank rank : ranks) {
            sum += rank.getCredit();
        }
        session.setAttribute("ranks", ranks);
        session.setAttribute("creditSum", sum);
        RequestDispatcher rd = request.getRequestDispatcher("courseAndCredit.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sno = (String) session.getAttribute("username");
        float sumAll = 0;
        SearchDao searchDao = new SearchDao();
        ArrayList<Rank> rankList = searchDao.searchAllCourse(sno);
        for (Rank rank : rankList) {
            sumAll += rank.getCredit();
        }
        session.setAttribute("rankList", rankList);
        session.setAttribute("creditSumAll", sumAll);
        RequestDispatcher rd = request.getRequestDispatcher("allCourseSearch.jsp");
        rd.forward(request, response);
    }
}
