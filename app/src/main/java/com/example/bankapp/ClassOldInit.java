package com.example.bankapp;

public class ClassOldInit {
    private int id;
    private String name;
    private String descript;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescript() {
        return descript;
    }


    public ClassOldInit(int id, String name, String descript) {
        this.id = id;
        this.name = name;
        this.descript = descript;
    }
}
