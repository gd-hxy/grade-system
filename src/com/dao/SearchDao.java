package com.dao;

import com.model.Rank;
import com.model.Student;
import com.model.Teacher;
import com.model.classCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDao extends BaseDao {
    BaseDao baseDao = new BaseDao();

    public ArrayList<Rank> searchRank(String sno, String term) {
        ArrayList<Rank> rankArrayList = new ArrayList<Rank>();
        String sql = "select a.hxy_Sno08, hxy_Cname08, hxy_Cterm08, hxy_Ccredit08, hxy_grade08,(select COUNT(distinct b.hxy_grade08) from huangxy_Select08 b where a.hxy_grade08 < b.hxy_grade08 and a.hxy_Cno08 = b.hxy_Cno08)+1 as hxy_rank08 from huangxy_Select08 a, huangxy_Student08, huangxy_Course08 where a.hxy_Sno08 = huangxy_Student08.hxy_Sno08 and a.hxy_Cno08 = huangxy_Course08.hxy_Cno08 and a.hxy_Sno08 = ? and hxy_Cterm08 = ? order by a.hxy_Cno08, hxy_rank08";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sno);
            pstmt.setString(2, term);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Rank rank = new Rank();
                rank.setSno(rst.getString(1));
                rank.setCname(rst.getString(2));
                rank.setTerm(rst.getString(3));
                rank.setCredit(rst.getInt(4));
                rank.setScore(rst.getFloat(5));
                rank.setRank(rst.getInt(6));
                rankArrayList.add(rank);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return rankArrayList;
    }

    public ArrayList<Rank> searchCourseAndCredit(String sno, String term) {
        ArrayList<Rank> rankArrayList = new ArrayList<Rank>();
        String sql = "SELECT * FROM courseAndCreditThisTerm WHERE hxy_Sno08 = ? and hxy_Cterm08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sno);
            pstmt.setString(2, term);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Rank rank = new Rank();
                rank.setSno(rst.getString(1));
                rank.setCname(rst.getString(2));
                rank.setTerm(rst.getString(3));
                rank.setCredit(rst.getInt(4));

                rankArrayList.add(rank);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return rankArrayList;
    }

    public ArrayList<Rank> searchAllCourse(String sno) {
        ArrayList<Rank> rankArrayList = new ArrayList<Rank>();
        String sql = "SELECT * FROM courseAndCreditALL WHERE hxy_Sno08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sno);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Rank rank = new Rank();
                rank.setSno(rst.getString(1));
                rank.setCname(rst.getString(2));
                rank.setTerm(rst.getString(3));
                rank.setCredit(rst.getInt(4));
                rankArrayList.add(rank);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return rankArrayList;
    }

    public ArrayList<classCourse> searchClassCourse(String sno, String term) {
        ArrayList<classCourse> classCourseArrayList = new ArrayList<classCourse>();
        String sql = "SELECT classAndCourse.hxy_classNo08, hxy_className08, hxy_Cno08, hxy_Cname08, hxy_Cterm08, hxy_Cperiod08, hxy_Ccredit08 FROM classAndCourse, huangxy_Student08 WHERE huangxy_Student08.hxy_Sno08 = ? and hxy_Cterm08 = ? and huangxy_Student08.hxy_classNo08 = classAndCourse.hxy_classNo08";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sno);
            pstmt.setString(2, term);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                classCourse classcourse = new classCourse();
                classcourse.setClassNo(rst.getString(1));
                classcourse.setClassName(rst.getString(2));
                classcourse.setCno(rst.getString(3));
                classcourse.setCname(rst.getString(4));
                classcourse.setTerm(rst.getString(5));
                classcourse.setCperiod(rst.getInt(6));
                classcourse.setCredit(rst.getFloat(7));
                classCourseArrayList.add(classcourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return classCourseArrayList;
    }

    public ArrayList<Teacher> searchAvgScore(String tno)
    {
        ArrayList<Teacher> teacherArrayList = new ArrayList<Teacher>();
        String sql = "SELECT huangxy_Teach08.hxy_Cno08, hxy_Cname08, avgGrade.hxy_avg08 FROM avgGrade, huangxy_Teach08, huangxy_Course08 WHERE huangxy_Teach08.hxy_Tno08 = ? and huangxy_Teach08.hxy_Cno08 = huangxy_Course08.hxy_Cno08 and huangxy_Teach08.hxy_Cno08 = avgGrade.hxy_Cno08 group by huangxy_Teach08.hxy_Cno08, hxy_Cname08, avgGrade.hxy_avg08";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tno);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Teacher teacher = new Teacher();
                teacher.setCno(rst.getString(1));
                teacher.setCname(rst.getString(2));
                teacher.setAvg(rst.getFloat(3));
                teacherArrayList.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return teacherArrayList;
    }

    public ArrayList<Teacher> searchCourseThisTerm(String tno, String term)
    {
        ArrayList<Teacher> teacherArrayList = new ArrayList<Teacher>();
        String sql = "SELECT * FROM teacherAndCourse WHERE hxy_Tno08 = ? and hxy_Cterm08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tno);
            pstmt.setString(2, term);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Teacher teacher = new Teacher();
                teacher.setTno(rst.getString(1));
                teacher.setTname(rst.getString(2));
                teacher.setClassName(rst.getString(3));
                teacher.setCno(rst.getString(4));
                teacher.setCname(rst.getString(5));
                teacher.setTerm(rst.getString(6));
                teacher.setPeriod(rst.getInt(7));
                teacher.setCredit(rst.getFloat(8));
                teacherArrayList.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return teacherArrayList;
    }

    public ArrayList<Student> searchStudentHome(){
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        String sql = "SELECT * FROM areaStudentNumber";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Student student = new Student();
                student.setShome(rst.getString(1));
                student.setArea(rst.getInt(2));
                studentArrayList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return studentArrayList;
    }

    public boolean teacherPassChange(String tno, String oldPass, String newPass){
        String changeSql = "UPDATE huangxy_TeacherLogin08 SET hxy_Tpass08 = ? WHERE hxy_Taccount08 = ? and hxy_Tpass08 = ?";
        Connection con = null;
        try {
            con = baseDao.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(changeSql);
            pstmt.setString(1, newPass);
            pstmt.setString(2, tno);
            pstmt.setString(3, oldPass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Teacher findTeacherById(String tno){
        String sql = "SELECT * FROM huangxy_Teacher08 WHERE hxy_Tno08 = ?";
        Teacher teacher = new Teacher();
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tno);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                teacher.setTno(rst.getString(1));
                teacher.setTname(rst.getString(2));
                teacher.setTgender(rst.getString(3));
                teacher.setTage(rst.getInt(4));
                teacher.setTtitle(rst.getString(5));
                teacher.setTphone(rst.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return teacher;
    }

    public ArrayList<Teacher> findAllTeacher(){
        String sql = "SELECT * FROM huangxy_Teacher08";
        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()) {
                Teacher teacher = new Teacher();
                teacher.setTno(rst.getString(1));
                teacher.setTname(rst.getString(2));
                teacher.setTgender(rst.getString(3));
                teacher.setTage(rst.getInt(4));
                teacher.setTtitle(rst.getString(5));
                teacher.setTphone(rst.getString(6));
                teacherArrayList.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return teacherArrayList;
    }

    public boolean addTeacher(String tno, String tname, String tgender, int age, String title, String phone){
        String sql = "INSERT INTO huangxy_Teacher08(hxy_Tno08, hxy_Tname08, hxy_Tgender08, hxy_Tage08, hxy_Ttitle08, hxy_Tphone08) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tno);
            pstmt.setString(2, tname);
            pstmt.setString(3, tgender);
            pstmt.setInt(4, age);
            pstmt.setString(5, title);
            pstmt.setString(6, phone);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateTeacher(String tno, String tname, String tgender, int age, String title, String phone){
        String updateSql = "UPDATE huangxy_Teacher08 SET hxy_Tno08 = ?, hxy_Tname08 = ?, hxy_Tgender08 = ?, hxy_Tage08 = ?, hxy_Ttitle08 = ?, hxy_Tphone08 = ? WHERE hxy_Tno08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(updateSql);
            pstmt.setString(1, tno);
            pstmt.setString(2, tname);
            pstmt.setString(3, tgender);
            pstmt.setInt(4, age);
            pstmt.setString(5, title);
            pstmt.setString(6, phone);
            pstmt.setString(7, tno);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
