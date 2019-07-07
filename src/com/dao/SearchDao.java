package com.dao;

import com.model.Rank;
import com.model.classCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
