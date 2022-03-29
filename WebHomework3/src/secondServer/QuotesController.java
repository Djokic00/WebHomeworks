package secondServer;

import com.app.Controller;
import com.google.gson.Gson;
import http.Request;
import http.response.Response;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class QuotesController extends Controller {

    String quote = "Djordje Balasevic: " + "Pricace ti o plovidbi ti sto sidro nisu digli";
    JsonResponse response;

    public QuotesController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        response = new JsonResponse(quote);
        return response;
    }

    @Override
    public Response doPost() {
        return null;
    }
}
