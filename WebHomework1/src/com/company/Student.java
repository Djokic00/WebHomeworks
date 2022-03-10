package com.company;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Student implements Runnable {
    private String studentName;
    private String nameOfExaminer;
    private Professor professor;
    private Assistant assistant;
    private long timeOfArrival;
    private long beginningOfDefending = -1;
    private long defending;
    private boolean isDone = false;
    private int mark = 0;

    public Student(String studentName, Assistant assistant, Professor professor, long defending) {
        this.studentName = studentName;
        this.assistant = assistant;
        this.professor = professor;
        this.defending = defending;
    }

    @Override
    public void run() {
        timeOfArrival = System.currentTimeMillis();
        if (timeOfArrival + defending - Main.timeOfInitialization >= 5000) return;

        while (!Main.isFinished.get() && !isDone) {
            Random random = new Random();
            int professorOrAssistant = random.nextInt(2);
            if (professorOrAssistant == 0) {
                if (!Main.isFinished.get()) {
                    try {
                        professor.getSemaphore().acquire();
                        professor.getCyclicBarrier().await();
                        beginningOfDefending = System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        return;

                    } catch (BrokenBarrierException e) {
                        continue;
                    }
                    try {
                        Thread.sleep(defending);

                    } catch (InterruptedException e) {
                        timeOfArrival -= Main.timeOfInitialization;
                        beginningOfDefending -= Main.timeOfInitialization;
                        nameOfExaminer = professor.getName();

                        System.out.println("\n");
                        System.out.println("Interrupted: " + studentName +
                                " | Arrival time: " + timeOfArrival + "ms" +
                                " | Professor: " + nameOfExaminer +
                                " | Beginning of defending: " + beginningOfDefending + "ms" +
                                " | TTC: " + defending + "ms");
                        return;
                    }
                    professor.getSemaphore().release();
                    nameOfExaminer = professor.getName();
                    mark = professor.markStudent();
                    isDone = true;
                }
            } else {
                assistant();
            }
            if (isDone) {
                Main.sum.addAndGet(mark);
                Main.defendNumber.incrementAndGet();
                timeOfArrival -= Main.timeOfInitialization;
                beginningOfDefending -= Main.timeOfInitialization;

                System.out.println("Thread: <" + studentName + ">" +
                        " < Arrival time: " + timeOfArrival + "ms>" +
                        " < Name of Examiner: " + nameOfExaminer + ">" +
                        " < Beginning of defending: " + beginningOfDefending + "ms>" +
                        " < TTC: " + defending + "ms>" +
                        " < Score: " + mark + ">");
            }
        }
    }

    private void assistant() {
        if (!isDone && Main.isFinished.get()) {
            try {
                assistant.getSemaphore().acquire();
                beginningOfDefending = System.currentTimeMillis();
                try {
                    Thread.sleep(defending);
                } catch (InterruptedException e) {
                    nameOfExaminer = assistant.getName();
                    timeOfArrival -= Main.timeOfInitialization;
                    beginningOfDefending -= Main.timeOfInitialization;

                    System.out.println("\n");
                    System.out.println("Interrupted: " + studentName +
                            " | Arrival time: " + timeOfArrival + "ms" +
                            " | Assistant: " + nameOfExaminer +
                            " | Beginning of defending: " + beginningOfDefending + "ms" +
                            " | TTC: " + defending + "ms");
                    return;
                }
                mark = assistant.markStudent();
                isDone = true;
                assistant.getSemaphore().release();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
