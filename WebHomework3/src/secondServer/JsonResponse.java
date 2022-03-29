package secondServer;

import com.google.gson.Gson;
import http.response.Response;

public class JsonResponse extends Response {

    private final String html;
    private Gson gson = new Gson();


    public JsonResponse(String html) {
        this.html = html;
    }

    @Override
    public String sendResponseString() {
        String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n " + "\r\n" + gson.toJson(html, String.class);
        return response;
    }
}
