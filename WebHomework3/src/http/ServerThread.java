package http;

import com.app.RequestHandler;
import http.response.Response;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ServerThread implements Runnable {

    private Socket socket;
    private BufferedReader inputFromClient;
    private PrintWriter outputToClient;
    private String contentLength;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputToClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String requestLine = inputFromClient.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);
            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();

            System.out.println("Client has sent a HTTP request");
            do {
                System.out.println(requestLine);
                requestLine = inputFromClient.readLine();
                if (requestLine.startsWith("Content-Length:")) {
                    contentLength = requestLine.substring(16, 18);
                }
            } while (!requestLine.trim().equals("")); // dokle god nije prazna linija


            HashMap<String,String> content = new HashMap<>();
            if (method.equals(HttpMethods.POST.toString())) {
                char[] buffer = new char[Integer.parseInt(contentLength)];
                inputFromClient.read(buffer);
                String parameters = new String(buffer);
                System.out.println(parameters);
                String[] array = parameters.split("&");
                for(String key: array) {
                    String parameterOne = key.split("=")[0];
                    String parameterTwo = key.split("=")[1];
                    content.put(parameterOne, URLDecoder.decode(parameterTwo, StandardCharsets.UTF_8.name()));
                }
                System.out.println(content.keySet() + " " + content.values());
            }

            Request request = new Request(HttpMethods.valueOf(method), path, content);
            RequestHandler requestHandler = new RequestHandler();
            Response response = requestHandler.handle(request);
            outputToClient.println(response.sendResponseString());

            inputFromClient.close();
            outputToClient.close();
            socket.close(); // Connection: keep-alive, a mi hocemo da se posle jedne razmene zatvori konekcija
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
