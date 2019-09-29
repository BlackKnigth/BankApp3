package com.example.bankapp;

import java.util.List;

public class ClassNewInit {
    private String name;
    private String descr;
    private int count;
    private List<Question> q;

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }


    public ClassNewInit(String _name, String _descr, Integer _count, List<Question> q) {
        name = _name;
        descr = _descr;
        count = _count;
        this.q = q;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getCount() {
        return count;
    }

    public ClassNewInit() {
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Question> getQ() {
        return q;
    }

    public void setQ(List<Question> q) {
        this.q = q;
    }
}
