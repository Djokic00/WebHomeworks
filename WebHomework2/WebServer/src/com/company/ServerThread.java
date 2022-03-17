package com.company;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerThread implements Runnable {
    private Socket socket;
    private BufferedReader inputFromClient = null;
    private PrintWriter outputToClient = null;
    public static List<ServerThread> listOfClients = new CopyOnWriteArrayList<>();
    private HashSet<String> forbiddenWords = new HashSet<>();
    private String message = "";
    private String username;

    public ServerThread(Socket socket) {
        this.socket = socket;
        setForbiddenWords();
    }

    @Override
    public void run() {
        while (true) {
            try {
                inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outputToClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                outputToClient.println("Enter your username");
                username = inputFromClient.readLine();
                if (Main.database.contains(username)) {
                    System.out.println("Client is rejected, username already exists");
                    outputToClient.println("Client with that username already exists");
                } else {
                    Main.database.add(username);
                    System.out.println("Client " + username + " is connected");
                    outputToClient.println("Welcome");
                    listOfClients.add(this);
                    listOfClients.iterator().forEachRemaining((ServerThread serverThread) -> {
                        if (!serverThread.equals(this)) {
                            serverThread.outputToClient.println("New user " + username + " joined");
                        }
                    });
                    Main.messageHistory.iterator().forEachRemaining((Message message) -> {
                        this.outputToClient.println(message);
                    });
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                message = inputFromClient.readLine();
                if (message.equals("exit")) {
                    listOfClients.iterator().forEachRemaining((ServerThread serverThread) ->{
                        if (!serverThread.equals(this)) {
                            serverThread.outputToClient.println("User " + username + " has left the chat.");
                        }
                        else {
                            serverThread.outputToClient.println("Status code: Exit");
                            System.out.println("User " + username + " is disconnected");
                        }
                    });
                    listOfClients.remove(this);
                    Main.database.remove(username);
                    socket.close();
                    inputFromClient.close();
                    outputToClient.close();
                    break;
                }
                else if (message.equals("ListHistory")) {
                    outputToClient.println(Main.messageHistory.toString());
                }
                else
                {
                    changeWordIfForbidden(message);
                    if (Main.messageHistory.size() > 100) Main.messageHistory.remove(0);
                    Main.database.add(username);
                    Message messageToClient = new Message(message, username, time());
                    Main.messageHistory.add(messageToClient);
                    outputToClient.println(messageToClient);
                    listOfClients.iterator().forEachRemaining((ServerThread serverThread) -> {
                        if (!serverThread.equals(this)) {
                            serverThread.outputToClient.println(messageToClient);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "messageHistory = " + Main.messageHistory;
    }

    private void setForbiddenWords() {
        forbiddenWords.add("kill");
        forbiddenWords.add("war");
    }

    private void changeWordIfForbidden(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitWord = word.split(" ");
        int wordCounter = 0;
        for (String s : splitWord) {
            if (forbiddenWords.contains(s)) {
                for (int i = 0; i < s.length(); i++) {
                    if (i == 0 || i == s.length() - 1) stringBuilder.append(s.charAt(i));
                    else stringBuilder.append("*");
                }
            }
            else stringBuilder.append(s);
            wordCounter++;
            if (wordCounter < splitWord.length) stringBuilder.append(" ");
        }
        setMessage(stringBuilder.toString());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String time(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
        String time = dateTimeFormatter.format(localDateTime);
        return time;
    }
}
