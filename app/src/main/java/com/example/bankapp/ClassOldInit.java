package com.example.bankapp;

public class ClassOldInit {
    private String name;
    private String descr;

    public String getName() {
        return name;
    }

    public ClassOldInit() {
    }

    public String getDescr() {
        return descr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public ClassOldInit(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }
}
