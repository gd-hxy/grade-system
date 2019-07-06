package com.model;

public class Admin {
    private String Aaccount;
    private String Apass;

    public Admin() {
    }

    public Admin(String aaccount, String apass) {
        Aaccount = aaccount;
        Apass = apass;
    }

    public String getAaccount() {
        return Aaccount;
    }

    public void setAaccount(String aaccount) {
        Aaccount = aaccount;
    }

    public String getApass() {
        return Apass;
    }

    public void setApass(String apass) {
        Apass = apass;
    }
}
