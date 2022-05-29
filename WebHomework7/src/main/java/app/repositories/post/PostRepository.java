package app.repositories.post;

import app.entities.Post;
import app.entities.Comment;

import java.util.List;

public interface PostRepository {
    Post addPost(Post post);
    List<Post> allPosts();
    Post findPost(Integer id);
    Comment addComment(Comment comment, Integer id);
    void delete(Integer id);
}
