package com.solvd.laba.pooling;

public class RunnableAndThreadTest {

    public void test() {
        RunnableTest runnableTest = new RunnableTest();
        ThreadTest threadTest = new ThreadTest();
        //Thread childTread = new Thread(anotherRun);
        threadTest.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("m" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            threadTest.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");
    }

    public void testNoName() {
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread0");
            }
        });
        thread0.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        };
        thread1.start();
    }

    class RunnableTest implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("r" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt");
                }
            }
        }
    }

    class ThreadTest extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("r" + i);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    System.out.println("Interrupt");
                }
            }
        }
    }
}

