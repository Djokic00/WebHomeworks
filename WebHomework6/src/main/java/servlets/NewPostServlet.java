package servlets;

import models.News;
import repository.INewsRepository;
import repository.InMemoryNewsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewsServlet", value = "/new-post")
public class NewPostServlet extends HttpServlet {

    private static int counter = 4;

    private INewsRepository newsRepository;

    @Override
    public void init() throws ServletException {
        this.newsRepository = new InMemoryNewsRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        News post = this.newsRepository.find(id);
        req.setAttribute("post", post);
        req.getRequestDispatcher("/single-post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        News news = new News(counter++, author, title, text, new ArrayList<>(), java.time.LocalDate.now());
        this.newsRepository.insert(news);
        resp.sendRedirect(getServletContext().getContextPath() + "/posts");
    }
}
