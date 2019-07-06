package com.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String Sno;
    private String classNo;
    private String Sname;
    private String Sgender;
    private int Sage;
    private String Shome;
    private float Scredit;

    public Student() {
    }

    public Student(String sno, String classNo, String sname, String sgender, int sage, String shome, float scredit) {
        Sno = sno;
        this.classNo = classNo;
        Sname = sname;
        Sgender = sgender;
        Sage = sage;
        Shome = shome;
        Scredit = scredit;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSgender() {
        return Sgender;
    }

    public void setSgender(String sgender) {
        Sgender = sgender;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getShome() {
        return Shome;
    }

    public void setShome(String shome) {
        Shome = shome;
    }

    public float getScredit() {
        return Scredit;
    }

    public void setScredit(float scredit) {
        Scredit = scredit;
    }

}
