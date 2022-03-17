package com.company;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Thread receiverThread = new Thread(new ReceiverThread(inputFromServer));
            Thread senderThread = new Thread(new SenderThread(outputToServer));
            receiverThread.start();
            senderThread.start();
            receiverThread.join();
            senderThread.join();
            socket.close();
            inputFromServer.close();
            outputToServer.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
