package com.model;

public class Teacher {
    private String Tno;
    private String Tname;
    private char Tgender;
    private int Tage;
    private String Ttitle;
    private String Tphone;

    public Teacher() {
    }

    public Teacher(String tno, String tname, char tgender, int tage, String ttitle, String tphone) {
        Tno = tno;
        Tname = tname;
        Tgender = tgender;
        Tage = tage;
        Ttitle = ttitle;
        Tphone = tphone;
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
}
