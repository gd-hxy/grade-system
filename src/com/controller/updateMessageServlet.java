package com.controller;

import com.dao.SearchDao;
import com.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateMessageServlet", urlPatterns = {"/updateMessageServlet.do"})
public class updateMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("Sno");
        String classNo = request.getParameter("classNo");
        String sname = request.getParameter("Sname");
        String sgender = request.getParameter("Sgender");
        int sage = Integer.parseInt(request.getParameter("Sage"));
        String shome = request.getParameter("Shome");
        float credit = Float.parseFloat(request.getParameter("Scredit"));
        StudentDao studentDao = new StudentDao();
        boolean isFlag = studentDao.updataStudent(sno, classNo, sname, sgender, sage, shome, credit);
        session.setAttribute("isFlag", isFlag);
        RequestDispatcher rd = request.getRequestDispatcher("updateStudent.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String tno = request.getParameter("Tno");
        String tname = request.getParameter("Tname");
        String tgender = request.getParameter("Tgender");
        int tage = Integer.parseInt(request.getParameter("Tage"));
        String title = request.getParameter("title");
        String phone = request.getParameter("phone");
        SearchDao searchDao = new SearchDao();
        boolean Success = searchDao.updateTeacher(tno, tname, tgender, tage, title, phone);
        session.setAttribute("Success", Success);
        RequestDispatcher rd = request.getRequestDispatcher("updateTeacher.jsp");
        rd.forward(request, response);
    }
}
