package com.solvd.laba.pooling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private String url;
    private int number;
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

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
