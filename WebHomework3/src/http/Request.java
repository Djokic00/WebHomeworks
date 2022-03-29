package http;

import java.util.HashMap;

public class Request {

    private final HttpMethods httpMethods;
    private final String path;
    private HashMap<String, String> content;

    public Request(HttpMethods httpMethods, String path, HashMap<String, String> content) {
        this.httpMethods = httpMethods;
        this.path = path;
        this.content = content;
    }

    public HttpMethods getHttpMethod() {
        return httpMethods;
    }
    public String getPath() {
        return path;
    }
    public HashMap<String, String> getContent() {
        return content;
    }
}
