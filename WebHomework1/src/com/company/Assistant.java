package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Assistant implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;

    public Assistant(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        semaphore = new Semaphore(1);
        name = "Assistant";
    }

    public int markStudent() {
        return (new Random()).nextInt(6) + 5;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("Assistant is initialized");
        countDownLatch.countDown();
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public String getName() {
        return name;
    }
}
