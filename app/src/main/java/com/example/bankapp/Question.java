package com.example.bankapp;

import java.util.List;

public class Question {
    private int count;
    private String quest;
    private int type;
    private List<String> q;

    public Question(int count, String quest, int type, List<String> q) {
        this.count = count;
        this.quest = quest;
        this.type = type;
        this.q = q;
    }

    public Question() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getQ() {
        return q;
    }

    public void setQ(List<String> q) {
        this.q = q;
    }
}
