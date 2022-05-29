package app.repositories.post;

import app.entities.Comment;
import app.entities.Post;
import app.repositories.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlPostRepository extends MySqlAbstractRepository implements PostRepository {
    @Override
    public Post addPost(Post post) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();
            String[] generatedColumns={"id"};
            preparedStatement = connection.prepareStatement("INSERT INTO posts ( author, title, content) VALUES(?, ?, ?)",generatedColumns);
            preparedStatement.setString(1, post.getAuthor());
            preparedStatement.setString(2, post.getTitle());
            preparedStatement.setString(3, post.getContent());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                post.setPostId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return post;
    }

    @Override
    public List<Post> allPosts() {
        List<Post> posts = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSetComments = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts");
            while (resultSet.next()) {
                Post post = new Post(resultSet.getInt("id"),resultSet.getString("author"), resultSet.getString("title"), resultSet.getString("content"), resultSet.getDate("createdAt"));
                System.out.println(post);
                preparedStatement = connection.prepareStatement("select * from comments  where  postId = ?");
                preparedStatement.setInt(1, resultSet.getInt("id"));
                resultSetComments = preparedStatement.executeQuery();
                while (resultSetComments.next()){
                    Comment comment = new Comment(resultSetComments.getInt("id"), resultSetComments.getString("author"), resultSetComments.getString("content"));
                    System.out.println(comment);
                    synchronized (this) {
                        post.getComments().add(comment);
                    }
                }
                posts.add(post);
            }
            resultSetComments.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(resultSetComments);
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return posts;
    }

    @Override
    public Post findPost(Integer id) {
        Post post = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSet resultSetComments = null;

        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM posts where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                post = new Post(resultSet.getInt("id"),resultSet.getString("author"), resultSet.getString("title"), resultSet.getString("content"), resultSet.getDate("createdAt"));
                preparedStatement = connection.prepareStatement("select * from comments  where  postId = ?");
                preparedStatement.setInt(1, resultSet.getInt("id"));
                resultSetComments = preparedStatement.executeQuery();
                while (resultSetComments.next()){
                    Comment comment = new Comment(resultSetComments.getInt("id"),resultSetComments.getString("author"), resultSetComments.getString("content"));
                    synchronized (this) {
                        post.getComments().add(comment);
                    }
                }
            }
            resultSetComments.close();
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(resultSetComments);
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return post;
    }

    @Override
    public Comment addComment(Comment comment, Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();
            String[] generatedColumns={"id"};

            preparedStatement = connection.prepareStatement("INSERT INTO comments ( author, content, postId) VALUES(?, ?, ?)",generatedColumns);
            preparedStatement.setString(1, comment.getAuthor());
            preparedStatement.setString(2, comment.getContent());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                comment.setCommentId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return comment;
    }

    @Override
    public void delete(Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM posts where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }
    }

}
