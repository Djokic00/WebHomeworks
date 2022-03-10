package com.company;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger sum = new AtomicInteger();
    public static AtomicInteger defendNumber = new AtomicInteger();
    public static AtomicBoolean isFinished = new AtomicBoolean(false);
    public static long timeOfInitialization;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter the number of students");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        CountDownLatch examiners = new CountDownLatch(2);
        Professor professor = new Professor(examiners);
        Assistant assistant = new Assistant(examiners);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(professor);
        executorService.execute(assistant);

        examiners.await();
        System.out.println("Defending can now begin");

        timeOfInitialization = System.currentTimeMillis();
        ScheduledExecutorService studentService = Executors.newScheduledThreadPool(n);

        for (int i = 0; i < n; i++) {
            long defending = (new Random()).nextInt(500) + 500;
            long timeOfDefending = (new Random()).nextInt(1000);
            String studentName = "Student " + (i + 1);
            Student student = new Student(studentName, assistant, professor, defending);
            studentService.schedule(student, timeOfDefending, TimeUnit.MILLISECONDS);
        }

        Thread beginning = new Thread();
        beginning.start();
        Thread.sleep(5000);
        beginning.join();

        isFinished.set(true);
        studentService.shutdownNow();
        executorService.shutdownNow();

        DecimalFormat decimal = new DecimalFormat("0.00");
        System.out.println("Number of students that defended their work: " + defendNumber.intValue());
        System.out.println("Average mark: " + decimal.format(sum.doubleValue() / defendNumber.doubleValue()));
    }
}

