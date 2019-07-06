package com.dao;

import com.model.Rank;

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
}
