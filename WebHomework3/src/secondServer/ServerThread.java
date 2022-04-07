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
    private PrintWriter outputToClient;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputToClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String requestLine = inputFromClient.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);
            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();
            do {
                System.out.println(requestLine);
                requestLine = inputFromClient.readLine();
            } while (!requestLine.trim().equals(""));

            HashMap<String,String> content = new HashMap<>();

            Request request = new Request(HttpMethods.valueOf(method), path, content);

            RequestHandler requestHandler = new RequestHandler();
            Response response = requestHandler.handle(request);

            System.out.println("\nHTTP response:\n");
            System.out.println(response.sendResponseString());

            outputToClient.println(response.sendResponseString());

            inputFromClient.close();
            outputToClient.close();
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
