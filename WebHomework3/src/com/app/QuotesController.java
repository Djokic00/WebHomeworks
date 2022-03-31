package com.app;

import com.google.gson.Gson;
import http.Request;
import http.response.HtmlResponse;
import http.response.RedirectResponse;
import http.response.Response;
import quotes.Quotes;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class QuotesController extends Controller {
    private Request request;
    private HashMap<String, String> quotes;
    private BufferedReader inputFromServer;
    private PrintWriter outputToServer;
    Gson gson = new Gson();
    String requestLine;

    public QuotesController(Request request) {
        super(request);
        this.request = request;
        quotes = Quotes.getInstance().getQuotes();
    }

    @Override
    public Response doGet() {
        String htmlBody = "" +
//              stavljamo action = save-quote da bi se post izvrsio na toj putanji, a ne na quotes putanji
                "<form method=\"POST\" action = \"/save-quote\">" +
                "<label>Author: </label><input name=\"author\" type=\"text\"><br><br>" +
                "<label>Quote: </label><input name=\"quote\" type=\"text\"><br><br>" +
                "<button type = \"submit\">Add quote</button>" +
                "</form>" +
                "<form>" +
                "<h1>Saved quotes</h1>";

        for (Map.Entry<String, String> map : quotes.entrySet()) {
            htmlBody += "<br><br>" + map.getKey() + " " + '"' + map.getValue() + '"' + "<br>";
        }
        htmlBody += "</form>";

        try {
            Socket socket = new Socket("localhost", 8081);
            inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputToServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            outputToServer.println("GET /qod HTTP/1.1\n" + "Accept: application/json\r\n\r\n");
            requestLine = inputFromServer.readLine();
            do {
                System.out.println(requestLine);
                requestLine = inputFromServer.readLine();
            } while (!requestLine.trim().equals(""));

            String quoteOfTheDay = gson.fromJson(inputFromServer.readLine(), String.class);
            htmlBody += "<h1>Quote of the Day</h1>\n" +"<h2>" + quoteOfTheDay + "</h2>";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HtmlResponse(htmlBody);
    }

    @Override
    public Response doPost() {
        String author = request.getContent().get("author");
        String quote = request.getContent().get("quote");
        quotes.put(author, quote);
        return new RedirectResponse("/quotes");
    }


}
