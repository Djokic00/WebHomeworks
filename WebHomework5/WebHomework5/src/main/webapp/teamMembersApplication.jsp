<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Hakaton</title>
  <%@include file="style.jsp"%>

</head>
<body>

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


<div class="page-wrapper bg-gra-03 p-t-45 p-b-50" style="margin-top: 100px;">
  <div class="wrapper wrapper--w790">
    <div class="card card-5">
      <div class="card-heading">
        <h2 class="title">PRIJAVA CLANOVA</h2>
      </div>
      <div class="card-body">
        <h1 style="margin-left: 300px;">Clan 1</h1>
        <br><br>
        <form action="submit.jsp" method="POST">
          <div class="form-row">
            <div class="name">Ime</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="text" name="nameMember1" id="nameMember1">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Prezime</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="text" name="surnameMember1" id="surnameMember1">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Kontakt email</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="email" name="emailMember1" id="emailMember1">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Link LinkedIn</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="url" name="linkedin1" id="linkedin1">
              </div>
            </div>
          </div>

          <% if (input.getCount() == 2) { %>
          <h1 style="margin-left: 300px;">Clan 2</h1>
          <br><br>
          <div class="form-row">
            <div class="name">Ime</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="text" name="nameMember2" id="nameMember2">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Prezime</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="text" name="surnameMember2" id="surnameMember2">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Kontakt email</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="email" name="emailMember2" id="emailMember2">
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="name">Link LinkedIn</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="url" name="linkedin2" id="linkedin2">
              </div>
            </div>
          </div>
          <% } %>
          <div>
            <button style="margin-left: 230px;" class="btn btn--radius-2 btn--blue" type="submit" >Posalji prijavu</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>