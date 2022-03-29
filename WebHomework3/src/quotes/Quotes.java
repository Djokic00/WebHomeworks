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
        quotes.put("It is during our darkest moments that we must focus to see the light.", "Aristotle");
        quotes.put("In the end, it's not the years in your life that count. It's the life in your years.", "Abraham Lincoln");
        quotes.put("The only impossible journey is the one you never begin. ", "Tony Robbins");
    }

    public static Quotes getInstance() {
        if (instance == null) instance = new Quotes();
        return instance;
    }

    public HashMap<String, String> getQuotes() {
        return quotes;
    }
}
