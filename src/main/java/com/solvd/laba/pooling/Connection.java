package com.solvd.laba.pooling;

public class Connection {
    private String url;
    private int number;

    public Connection(int number, String url) {
        this.number = number;
        this.url = url;
    }

    public String connect() {
        return (this.url + " " + this.number);
    }

    public int getNumber() {
        return number;
    }
}
