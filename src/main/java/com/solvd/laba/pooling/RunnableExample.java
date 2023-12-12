package com.solvd.laba.pooling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableExample implements Runnable{
    private static final int DURATION = 1000;
    private static final Logger LOGGER = LogManager.getLogger(RunnableExample.class);


    public RunnableExample() {
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int duration = DURATION + DURATION * connection.getNumber();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info(Thread.currentThread().getName() + " " + connection.connect() + " this slept for " + duration);
        try {
            ConnectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
