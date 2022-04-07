package com.example.webhomework4;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@WebServlet(name = "Orders", value = "/orders")
public class Orders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String password = request.getParameter("password");
        Scanner scanner = new Scanner(new File("/home/aleksa/Documents/JavaProjects/WebHomework/WebHomework4/src/database/password.txt"));
        if (password.equals(scanner.nextLine())) {
            out.println("<html><body><form method=\"POST\" action = \"orders?password=aleksa\">");
            out.println("<h1>" + "Meals" + "</h1>");
            out.println("<html><body>");

            List<Meal> listOfMeals = (List<Meal>) getServletContext().getAttribute("allMeals");
            List<String> days = (List<String>) getServletContext().getAttribute("days");

            for(String day: days) {
                out.println("<h1>" + day + "</h1>");
                out.println("<h1></h1>");
                out.println("<table style=\"width:100 % \">");
                out.println("<tr> <th>#</th> <th>Meal</th> <th>Quantity</th> </tr>");
                int j = 0;
                for (Meal meal : listOfMeals) {
                    if (meal.getDay().equals(day)) {
                        j++;
                        out.println("<tr> <th>" + j + "</th> <th>" + meal.getFood() + "</th> <th>" + meal.getOrderNumber() + "</th> </tr>");
                    }
                }
                out.println("<style>\n" +
                        "table, th, td {\n" +
                        "  border: 1px solid black;\n" +
                        "}\n" +
                        "</style></table>\n");
                out.println("<h1></h1>");
            }

            out.println("--------------------------<br>");
            out.println("<br><input type=\"submit\" name\"submit\" value\"Clear\"/></form>");
            out.println("</body></html>");
        }
        else {
            out.println("<h3>" +"Wrong password" + "</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        List<Meal> listOfMeals = (List<Meal>) getServletContext().getAttribute("allMeals");
        for (Meal o: listOfMeals) {
            o.setOrderNumber(0);
        }
        Map<String, List<Meal>> map = (Map<String, List<Meal>>) getServletContext().getAttribute("map");
        for (Map.Entry<String, List<Meal>> m: map.entrySet()){
            getServletContext().setAttribute(m.getKey(), null);
        }
        map = new HashMap<>();
        getServletContext().setAttribute("map", map);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
