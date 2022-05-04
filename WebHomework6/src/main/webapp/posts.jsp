<%@ page import="java.util.List" %>
<%@ page import="models.News" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h1 class="naslov">All Posts</h1>
    <br>

    <% List<News> newsList = (List<News>) request.getAttribute("posts"); %>

    <div class="container">
        <% for (News news : newsList) { %>
        <br>
        <h4><%= news.getTitle() %>
        </h4>
        <a href="<%=application.getContextPath()%>/posts/<%= news.getId() %>">Opsirnije...
        </a>
        <br>

        <% } %>
        <br>
        <a href="new-post.jsp" class="btn btn-primary btn-sm active" role="button" aria-pressed="true">New Post</a>
    </div>
</div>

</body>
</html>

