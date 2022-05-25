package repository;

import models.News;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryNewsRepository implements INewsRepository{
    private static final List<News> newsMap = new CopyOnWriteArrayList<>();


    static {
        newsMap.add(new News(1, "Aleksa", "Web programiranje", "Razumevanje dinamičkog kreiranja veb sadržaja, pojma sesije i načina praćenja sesije.", new ArrayList<>(), java.time.LocalDate.now()));
        newsMap.add(new News(2,"Mike", "Napredno Web programiranje", "Upoznavanje sa konceptima naprednog programiranja aplikacija velikog obima (Enterprise aplikacija).",  new ArrayList<>(), java.time.LocalDate.now()));
        newsMap.add(new News(3,"Petar", "Softversko inženjerstvo", "Upoznavanje sa savremenim metodama i principima softverskog inženjerstva.",  new ArrayList<>(), java.time.LocalDate.now()));
    }


    public List<News> all() {
        List<News> newsList = new ArrayList<>();
        newsMap.iterator().forEachRemaining(e -> {
            newsList.add(e);
        });

        return newsList;
    }

    public void insert(News news) {
        newsMap.add(news);
    }

    @Override
    public void update(News news) {
        for(News n: newsMap) {
            if(n.getId() == news.getId()) {
                newsMap.remove(n);
                newsMap.add(news);
            }
        }
    }

    @Override
    public News find(int id) {
        for(News n: newsMap) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }
}
