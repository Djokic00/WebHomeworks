package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Professor implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;

    public Professor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        semaphore = new Semaphore(2, true);
        cyclicBarrier = new CyclicBarrier(2);
        name = "Professor";
    }

    public int markStudent() {
        return (new Random()).nextInt(6) + 5;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("Professor is initialized");
        countDownLatch.countDown();
    }

    public String getName() {
        return name;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

}
