package com.dao;

import com.model.Student;

import java.sql.*;

public class StudentDao extends BaseDao {

    BaseDao baseDao = new BaseDao();

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO huangxy_Student08(hxy_Sno08, hxy_classNo08, hxy_Sname08, hxy_Sgender08, hxy_Sage08, hxy_Shome08, hxy_Scredit08) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getSno());
            pstmt.setString(2, student.getClassNo());
            pstmt.setString(3, student.getSname());
            pstmt.setString(4, student.getSgender());
            pstmt.setInt(5, student.getSage());
            pstmt.setString(6, student.getShome());
            pstmt.setFloat(7, student.getScredit());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Student findById(String id) {
        String sql = "SELECT * FROM huangxy_Student08 WHERE hxy_Sno08 = ?";
        Student student = new Student();
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                student.setSno(rst.getString("hxy_Sno08"));
                student.setClassNo(rst.getString("hxy_classNo08"));
                student.setSname(rst.getString("hxy_Sname08"));
                student.setSgender(rst.getString("hxy_Sgender08"));
                student.setSage(rst.getInt("hxy_Sage08"));
                student.setShome(rst.getString("hxy_Shome08"));
                student.setScredit(rst.getFloat("hxy_Scredit08"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }


    public boolean updataStudent(Student student) {
        String updateSql = "UPDATE huangxy_Student08 SET hxy_Sno08 = ?, hxy_classNo08 = ?, hxy_Sname08 = ?, hxy_Sgender08 = ?, hxy_Sage08 = ?, hxy_Shome08 = ?, hxy_Scredit08 = ? WHERE hxy_Sno08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(updateSql);
            pstmt.setString(1, student.getSno());
            pstmt.setString(2, student.getClassNo());
            pstmt.setString(3, student.getSname());
            pstmt.setString(4, student.getSgender());
            pstmt.setInt(5, student.getSage());
            pstmt.setString(6, student.getShome());
            pstmt.setFloat(7, student.getScredit());
            pstmt.setString(8, student.getSno());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteStudent(String id) {
        String deleteSql = "DELETE FROM huangxy_Student08 WHERE hxy_Sno08 = ?";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(deleteSql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean passChange(String sno, String oldPass, String newPass){
        String changeSql = "UPDATE huangxy_StudentLogin08 SET hxy_Spass08 = ? WHERE hxy_Saccount08 = ? and hxy_Spass08 = ?";
        Connection con = null;
        try {
            con = baseDao.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(changeSql);
            pstmt.setString(1, newPass);
            pstmt.setString(2, sno);
            pstmt.setString(3, oldPass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertGrade(String sno, String cno, String cname, String term, float grade){
        String insertSql = "INSERT INTO huangxy_Select08(hxy_Sno08, hxy_Cno08, hxy_grade08) VALUES(?,?,?)";
        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(insertSql);
            pstmt.setString(1, sno);
            pstmt.setString(2, cno);
            pstmt.setFloat(3, grade);
            pstmt.executeUpdate();
            CallableStatement callableStatement = con.prepareCall("{call PRO_countCreditAUTO(?,?,?,?,?)}");
            callableStatement.setString(1, sno);
            callableStatement.setString(2, cno);
            callableStatement.setString(3, cname);
            callableStatement.setString(4, term);
            callableStatement.setFloat(5, grade);
            callableStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
