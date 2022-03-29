package secondServer;

import http.HttpMethods;
import http.Request;
import http.response.Response;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ServerThread implements Runnable {

    private Socket socket;
    private BufferedReader inputFromClient;
    private PrintWriter outputFromClient;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputFromClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String requestLine = null;
        try {
            requestLine = inputFromClient.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);
            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();

            System.out.println("\nHTTP ZAHTEV KLIJENTA:\n");
            do {
                System.out.println(requestLine);
                requestLine = inputFromClient.readLine();
            } while (!requestLine.trim().equals(""));

            HashMap<String,String> ubaci = new HashMap<>();

            Request request = new Request(HttpMethods.valueOf(method), path, ubaci);

            RequestHandler requestHandler = new RequestHandler();
            Response response = requestHandler.handle(request);

            System.out.println("\nHTTP odgovor:\n");
            System.out.println(response.sendResponseString());

            outputFromClient.println(response.sendResponseString());

            inputFromClient.close();
            outputFromClient.close();
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
