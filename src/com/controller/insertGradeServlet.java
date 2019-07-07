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

@WebServlet(name = "insertGradeServlet", urlPatterns = {"/insertGradeServlet.do"})
public class insertGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sno = request.getParameter("Sno");
        String cno = request.getParameter("Cno");
        String cname = request.getParameter("Cname");
        String term = request.getParameter("term");
        float grade = Float.parseFloat(request.getParameter("grade"));
        StudentDao studentDao = new StudentDao();
        boolean flag = studentDao.insertGrade(sno, cno, cname, term, grade);
        session.setAttribute("flag", flag);
        RequestDispatcher rd = request.getRequestDispatcher("insertGrade.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
