package com.model;

public class Rank {
    private String Sno;
    private String Cname;
    private String term;
    private int credit;
    private float score;
    private int rank;

    public Rank() {
    }

    public Rank(String sno, String cname, String term, int credit, float score, int rank) {
        Sno = sno;
        Cname = cname;
        this.term = term;
        this.credit = credit;
        this.score = score;
        this.rank = rank;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
