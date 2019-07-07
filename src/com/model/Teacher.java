package com.model;

public class Teacher {
    private String Tno;
    private String Tname;
    private char Tgender;
    private int Tage;
    private String Ttitle;
    private String Tphone;
    private String Cno;
    private String Cname;
    private float avg;
    private String classNo;
    private String className;
    private String Term;
    private int period;
    private float credit;

    public Teacher() {
    }

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public char getTgender() {
        return Tgender;
    }

    public void setTgender(char tgender) {
        Tgender = tgender;
    }

    public int getTage() {
        return Tage;
    }

    public void setTage(int tage) {
        Tage = tage;
    }

    public String getTtitle() {
        return Ttitle;
    }

    public void setTtitle(String ttitle) {
        Ttitle = ttitle;
    }

    public String getTphone() {
        return Tphone;
    }

    public void setTphone(String tphone) {
        Tphone = tphone;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}
