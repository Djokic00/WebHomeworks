package models;

import java.time.LocalDate;
import java.util.List;

public class News {
    private int id;
    private String author;
    private String title;
    private String text;
    private LocalDate date;
    private List<Posts> comments;

    public News() {

    }

    public News(int id, String author, String title, String text, List<Posts> comments, LocalDate date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.comments = comments;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Posts> getComments() {
        return comments;
    }

    public void setComments(List<Posts> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
