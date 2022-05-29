package app.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment {
    private Integer commentId;

    @NotNull(message = "Name field is required")
    @NotEmpty(message = "Name field is required")
    private String author;

    @NotNull(message = "Comment field is required")
    @NotEmpty(message = "Comment field is required")
    private String content;

    public Comment() {}

    public Comment(Integer commentId, @NotNull(message = "Name field is required") @NotEmpty(message = "Name field is required") String name, @NotNull(message = "Comment field is required") @NotEmpty(message = "Comment field is required") String comment) {
        this.commentId = commentId;
        this.author = name;
        this.content = comment;
    }

    public Comment(String name, String comment) {
        this.author = name;
        this.content = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }


    public void setCommentId(Integer id) {
        this.commentId = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
