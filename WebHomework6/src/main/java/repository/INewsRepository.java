package repository;

import models.News;

import java.util.List;

public interface INewsRepository {
    public List<News> all();
    public void insert(News news);
    public void update(News news);
    public List<News> allPosts();
    public News find(int id);
}
