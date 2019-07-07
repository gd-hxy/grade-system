package com.controller;

import com.dao.SearchDao;
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

@WebServlet(name = "passChangeServlet", urlPatterns = {"/passChangeServlet.do"})
public class passChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sno = (String)session.getAttribute("username");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        StudentDao studentDao = new StudentDao();
        boolean isSuccess = studentDao.passChange(sno, oldPass, newPass);
        session.setAttribute("isSuccess", isSuccess);
        RequestDispatcher rd = request.getRequestDispatcher("studentPassChange.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tno = (String)session.getAttribute("username");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        SearchDao searchDao = new SearchDao();
        boolean isSuccess = searchDao.teacherPassChange(tno, oldPass, newPass);
        session.setAttribute("isSuccess", isSuccess);
        RequestDispatcher rd = request.getRequestDispatcher("teacherPassChange.jsp");
        rd.forward(request, response);
    }
}
