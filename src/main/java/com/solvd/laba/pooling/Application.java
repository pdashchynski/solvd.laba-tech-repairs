package com.solvd.laba.pooling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    static {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
    }

    public void launch() {
        ExecutorService executor = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            Runnable worker = new RunnableExample(i);
            Runnable workerT = new ThreadExample(i);
            executor.execute(worker);
            executor.execute(workerT);
        }
        executor.shutdown();
    }

    public void launchCF() {
      /*  CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });*/

        for (int i = 1; i <= 7; i++) {
            Connection connection = null;
            try {
                connection = ConnectionPool.getConnection();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Runnable worker = new RunnableExample(i);
            CompletableFuture.runAsync(worker);
        }
    }
}
