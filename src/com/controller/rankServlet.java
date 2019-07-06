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

@WebServlet(name = "rankServlet", urlPatterns = {"/rankServlet.do"})
public class rankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String term = request.getParameter("term");
        String sno = (String) session.getAttribute("username");
        SearchDao searchDao = new SearchDao();
        ArrayList<Rank> rankArrayList = searchDao.searchRank(sno, term);
        session.setAttribute("rankArrayList", rankArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("rank.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
