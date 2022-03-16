package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceiverThread implements Runnable {
    private BufferedReader inputFromServer;

    public ReceiverThread(BufferedReader inputFromServer) {
        this.inputFromServer = inputFromServer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = inputFromServer.readLine();
                if (message.equals("ListHistory")) {
                    System.out.println(message);
                }
                else {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
