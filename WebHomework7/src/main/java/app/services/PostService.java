package app.services;

import app.entities.Comment;
import app.entities.Post;
import app.repositories.post.PostRepository;

import javax.inject.Inject;
import java.util.List;

public class PostService {
    public PostService() {}

    @Inject
    private PostRepository postRepository;

    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }

    public List<Post> allPosts() {
        return this.postRepository.allPosts();
    }

    public Post findPost(Integer id) {
        return this.postRepository.findPost(id);
    }

    public void delete(Integer id){
        this.postRepository.delete(id);
    }

    public Comment addComment(Comment comment, Integer id) {
        return this.postRepository.addComment(comment,id);
    }
}
