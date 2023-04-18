package com.scriptServer.script.bean;

import cn.hutool.json.JSONObject;

public class Script {
    private String title;
    private int playTimes;
    private String author;
    //    private String picLoc;
    private int rate;
    private int id;

//    public static void main(String[] args) {
//        Script script = new Script("11", 1, "111", 5, 1);
//        System.out.println(script.toJsonObj().toString());
//    }

    public Script() {
        super();
    }

    public JSONObject toJsonObj() {
        return new JSONObject(this);
    }

    @Override
    public String toString() {
        return "{" + "title='" + title + '\'' + ", playTimes=" + playTimes + ", author='" + author + '\'' + ", rate=" + rate + ", id=" + id + '}';
    }

    public Script(String title, int playTimes, String author, int rate, int id) {
        this.title = title;
        this.playTimes = playTimes;
        this.author = author;
        this.rate = rate;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
