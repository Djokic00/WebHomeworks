<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Hakaton</title>
  <%@include file="style.jsp"%>

</head>
<body>

<%--<%@ include file="navbar.jsp" %>--%>

<%--Kreiranje instance bean-a. Scope:
application - instanca beana je dostupna celoj web aplikaciji
session - instanca beana se kreira za svaku novu sesiju
request - instanca beana se kreira kada stigne novi zahtev i dostupna je samo na nivou tog zahteva
sto znaci da ce biti dostupan i drugim stranicama, na primer ako uradimo
 <jsp:forward page="stranica.jsp"/> ili <jsp:include page="stranica.jsp"/>
page - instanca beana je dostupna samo jednoj jsp stranici --%>

<jsp:useBean id="input" scope="session" class="com.example.webhomework5.Form" />

<jsp:setProperty name="input" property="name" param="name" />
<jsp:setProperty name="input" property="email" param="email" />
<jsp:setProperty name="input" property="phone" param="phone" />
<jsp:setProperty name="input" property="moto" param="moto" />
<jsp:setProperty name="input" property="culi" param="culi" />
<jsp:setProperty name="input" property="count" param="count" />

<%
  try {
    File file = new File("/home/aleksa/Desktop/"+ input.getName() + ".txt");
    if (file.createNewFile()) {
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write("Ime tima " + input.getName() + "\n" + "Email: " + input.getEmail() + "\n" + "Telefon: " + input.getPhone() + "\n" + "Moto tima: " +
              input.getMoto() + "\n" + "Broj clanova:" + input.getCount() + "\n");

%>

<jsp:setProperty name="input" property="nameMember1" param="nameMember1" />
<jsp:setProperty name="input" property="surnameMember1" param="surnameMember1" />
<jsp:setProperty name="input" property="emailMember1" param="emailMember1" />
<jsp:setProperty name="input" property="linkedin1" param="linkedin1" />

<jsp:setProperty name="input" property="nameMember2" param="nameMember2" />
<jsp:setProperty name="input" property="surnameMember2" param="surnameMember2" />
<jsp:setProperty name="input" property="emailMember2" param="emailMember2" />
<jsp:setProperty name="input" property="linkedin2" param="linkedin2" />

<%
      fileWriter.write("--------------------------------------\n");
      fileWriter.write("Haker " + input.getNameMember1() + "\n");
      fileWriter.write("Prezime " + input.getSurnameMember1() + "\n");
      fileWriter.write("Email " + input.getEmailMember1() + "\n");
      fileWriter.write("Linkedin " + input.getLinkedin1() + "\n");

      if (input.getNameMember2() != null) {
          fileWriter.write("--------------------------------------\n");
          fileWriter.write("Haker " + input.getNameMember2() + "\n");
          fileWriter.write("Prezime " + input.getSurnameMember2() + "\n");
          fileWriter.write("Email " + input.getEmailMember2() + "\n");
          fileWriter.write("Linkedin " + input.getLinkedin2() + "\n");
      }
      fileWriter.write("--------------------------------------");
      fileWriter.close();
      response.sendRedirect("sentApplication.jsp");
    } else {
      System.out.println("?");
    }
  }  catch (IOException e) {

    e.printStackTrace();
  }
%>

</body>
</html>