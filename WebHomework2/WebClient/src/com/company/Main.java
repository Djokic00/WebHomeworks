package com.company;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

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
//            System.out.println(inputFromServer.readLine());
//            Scanner scanner = new Scanner(System.in);
//            outputToServer.println(scanner.next());
//            System.out.println(inputFromServer.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
