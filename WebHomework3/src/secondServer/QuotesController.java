package secondServer;

import com.app.Controller;
import com.google.gson.Gson;
import http.Request;
import http.response.Response;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Random;

public class QuotesController extends Controller {

    String quote1 = "Djordje Balasevic: " + "Pricace ti o plovidbi ti sto sidro nisu digli";
    String quote2 = "Aristotle: " + "It is during our darkest moments that we must focus to see the light.";
    String quote3 = "Abraham Lincoln: " + "In the end, it's not the years in your life that count. It's the life in your years.";
    String quote4 = "Tony Robbins: " + "The only impossible journey is the one you never begin.";
    JsonResponse response;

    public QuotesController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        String quote = chooseRandom();
        response = new JsonResponse(quote);
        return response;
    }

    @Override
    public Response doPost() {
        return null;
    }

    private String chooseRandom() {
        String quote = "";
        Random random = new Random();
        int num = random.nextInt(4);
        switch (num) {
            case 0:
                quote = quote1;
                break;
            case 1:
                quote = quote2;
                break;
            case 2:
                quote = quote3;
                break;
            case 3:
                quote = quote4;
                break;
            default:
                System.out.println("Error");
                break;
        }
        return quote;
    }
}
