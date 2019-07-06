package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDao {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String dburl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=huangxiaoyangMIS08";
    private String username = "sa";
    private String password = "austin567";

    protected Connection conn = null;

    public Connection getConnection() throws Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(dburl, username, password);
        return conn;
    }
}
