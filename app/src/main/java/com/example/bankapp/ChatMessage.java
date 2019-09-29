package com.example.bankapp;

public class ChatMessage {
    private int userID;
    private String msg;

    public ChatMessage() {
        userID=0;
        msg="";
    }

    public String getUserID() {
        return Integer.valueOf(userID).toString();
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMsg() {
        return msg;
    }

    public ChatMessage(int userID, String msg) {
        this.userID = userID;
        this.msg = msg;
    }
    public ChatMessage(String userID, String msg) {
        this.userID =Integer.parseInt(userID.replaceAll("[^1234567890]",""));
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
