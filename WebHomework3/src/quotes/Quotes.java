package quotes;

import java.util.HashMap;

public class Quotes {
    private static Quotes instance = null;
    HashMap<String, String> quotes = new HashMap<>();

    private Quotes() {
        initQuotes();
    }

    private void initQuotes() {
        quotes.put("Life is never fair, and perhaps it is a good thing for most of us that it is not.", "Oscar Wilde");
        quotes.put("What I hear, I forget. What I see, I remember. What I do, I understand.", "Xunzi");
        quotes.put("The way to get started is to quit talking and begin doing.", "Walt Disney");
    }

    public static Quotes getInstance() {
        if (instance == null) instance = new Quotes();
        return instance;
    }

    public HashMap<String, String> getQuotes() {
        return quotes;
    }
}
