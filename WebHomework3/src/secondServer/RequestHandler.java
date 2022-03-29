package secondServer;

import http.HttpMethods;
import http.Request;
import http.response.Response;

public class RequestHandler {
    public Response handle(Request request) throws Exception {
        if (request.getPath().equals("/qod") && request.getHttpMethod().equals(HttpMethods.GET)) {
            return (new QuotesController(request)).doGet();
        }
        throw new Exception("Page: " + request.getPath() + ". Method: " + request.getHttpMethod() + " not found!");
    }
}
