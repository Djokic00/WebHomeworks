package com.example.webhomework4;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private List<String> days = new ArrayList<>();
    private ArrayList<Meal> saveMeal = new ArrayList<>();
    private Map<String, List<Meal>> map = new HashMap<>();

    public void init() {
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        getServletContext().setAttribute("days", days);
        for(String day: days) {
            try {
                Scanner scanner = new Scanner(new File("/home/aleksa/Documents/JavaProjects/WebHomework/WebHomework4/src/database/" + day + ".txt"));
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    Meal meal = new Meal(day, data);
                    saveMeal.add(meal);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }}
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (getServletContext().getAttribute(request.getSession().getId()) != null) {
            out.println("<h3>" + "Done" + "</h3>");
            List<Meal> meals = map.get(request.getSession().getId());
            for (Meal meal: meals) {
                out.println(meal.getDay());
                out.println("<br>");
                out.println(meal.getFood());
                out.println("<br>");
                out.println("<br>");
            }
            return;
        }

        out.println("<html><body><form method=\"POST\" action = \"hello-servlet\">");
        out.println("<h1>" + "Choose your lunch" + "</h1>");
        for (String day: days) {
            out.println("<h3>" + day + "</h3>");
            out.println("<select name = \""+ day + "\" id=\"" + day + "\">");
            System.out.println("<select name = \" "+ day + "\" id=\"" + day+ "\">" );
            for (Meal meal: saveMeal) {
                if (meal.getDay().equals(day)) {
                    out.println("<option value = \"" + meal.getFood() + "\" selected>" + meal.getFood() + "</option>");
                }
            }
            out.println("</select><br>");
            out.println("--------------------------------");
        }
        out.println("<br><input type=\"submit\" name\"submit\" value\"Save\"/></form>");
        out.println("</body></html>");
        getServletContext().setAttribute("allMeals", saveMeal);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/response.html");
        getServletContext().setAttribute(request.getSession().getId(),true);
        List<Meal> list = new ArrayList<>();
        for (String day: days) {
            String meal = request.getParameter(day);
            System.out.println(meal);
            Meal o = returnMeal(day, meal);
            o.setOrderNumber(o.getOrderNumber()  + 1);
            list.add(o);
        }
        map.put(request.getSession().getId(), list);
        getServletContext().setAttribute("map", map);
    }

    private Meal returnMeal(String day, String meal){
        for (Meal m : saveMeal){
            if (m.getDay().equals(day) && m.getFood().equals(meal))
                return m;
        }
        System.out.println(day + " " + meal);
        return null;
    }

    public void destroy() {}
}