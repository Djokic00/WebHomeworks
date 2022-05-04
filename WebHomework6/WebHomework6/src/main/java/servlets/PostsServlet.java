package servlets;

import repository.INewsRepository;
import repository.InMemoryNewsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostServlet", value = {"/", "/posts"})
public class PostsServlet extends HttpServlet {
    private INewsRepository subjectRepository;

    @Override
    public void init() throws ServletException {
        this.subjectRepository = new InMemoryNewsRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("posts", this.subjectRepository.all());
        request.getRequestDispatcher("/posts.jsp").forward(request, response);
    }
}
