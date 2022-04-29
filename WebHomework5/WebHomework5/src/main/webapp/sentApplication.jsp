<%@ page import="com.example.webhomework5.Form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Hakaton</title>
    <%@include file="style.jsp"%>


</head>
<body>

<jsp:useBean id="input" scope="session" class="com.example.webhomework5.Form" />

<%@ include file="navbar.jsp" %>
<div class="priajavaObavestenje" style="color: white; margin-top: 300px;margin-left: 500px;">
    <h1 style="font-size: 57px;" class="imeTima"><%=input.getName()%> Hvala na prijavi!</h1>

    <br>
    <div class="pregledanje">
        <h3 style="font-size: 30px;">Nas tim pregleda prijavu i  obavestice vas o konacnoj
            odluci do 11. decembra na email: <br><%=input.getEmail()%> </h3>
    </div>
</div>

</body>
</html>