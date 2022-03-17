package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class SenderThread implements Runnable {
    private PrintWriter outputFromServer;
    private Scanner scanner = new Scanner(System.in);

    public SenderThread(PrintWriter outputFromServer) {
        this.outputFromServer = outputFromServer;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) break;
            String message = scanner.nextLine();
            outputFromServer.println(message);
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}
