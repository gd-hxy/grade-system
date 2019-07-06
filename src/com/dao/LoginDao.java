package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends BaseDao {
    BaseDao baseDao = new BaseDao();

    public boolean studentLogin(String username, String password) {
        String sql = "SELECT hxy_Spass08 FROM huangxy_StudentLogin08 WHERE hxy_Saccount08 = " + username;

        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                if (rst.getString("hxy_Spass08").equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean teacherLogin(String username, String password) {
        String sql = "SELECT hxy_Tpass08 FROM huangxy_TeacherLogin08 WHERE hxy_Taccount08 = " + username;
        Connection con = null;
        try {
            con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                if (rst.getString("hxy_Tpass08").equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean AdminLogin(String username, String password) {
        String sql = "SELECT hxy_Apass08 FROM huangxy_Admin08 WHERE hxy_Aaccount08 = ?";

        try {
            Connection con = baseDao.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                if (rst.getString("hxy_Apass08").equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
