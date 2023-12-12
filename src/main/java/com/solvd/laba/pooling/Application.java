package com.solvd.laba.pooling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    private static final Logger LOGGER = LogManager.getLogger(RunnableExample.class);

    static {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
    }

    public void launch() {
        ExecutorService executor = Executors.newFixedThreadPool(7);
        Runnable worker = new RunnableExample();
        Runnable workerT = new ThreadExample();
        executor.execute(worker);
        executor.execute(workerT);
        for (int i = 0; i < 5; i++) {
            executor.execute(worker);
            executor.execute(workerT);
        }
        executor.shutdown();
    }

    public void launchCF() {
        ExecutorService executor = Executors.newFixedThreadPool(7);
        Runnable worker = new RunnableExample();
        Runnable workerT = new ThreadExample();
        CompletableFuture.runAsync(worker, executor);
        CompletableFuture.runAsync(workerT, executor);
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(worker, executor);
            CompletableFuture.runAsync(workerT, executor);
        }
        executor.shutdown();
    }
}
