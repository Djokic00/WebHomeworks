package servlets;

import models.News;
import models.Posts;
import repository.INewsRepository;
import repository.InMemoryNewsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SingleSubjectServlet", value = "/posts/*")
public class SinglePostServlet extends HttpServlet {
    private INewsRepository subjectRepository;

    @Override
    public void init() throws ServletException {
        this.subjectRepository = new InMemoryNewsRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getPathInfo());
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        News post = this.subjectRepository.find(id);
        request.setAttribute("post", post);

        request.getRequestDispatcher("/single-post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        News post = this.subjectRepository.find(id);
        List<Posts> comments = post.getComments();
        String author = req.getParameter("name");
        String comment = req.getParameter("comment");
        Posts newComment = new Posts(author, comment);
        comments.add(newComment);
        post.setComments(comments);
        this.subjectRepository.update(post);
        resp.sendRedirect("/posts/"+post.getId());
    }

}
