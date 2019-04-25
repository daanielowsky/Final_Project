<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SellOut</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/media/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<div class="container">
    <h2>Informacje o sprzedawcy:</h2>
    <sec:authorize access="!isAuthenticated()">
        <center>

        <div class="panel panel-danger" style="width: 50%">

                Aby zobaczyć informacje o sprzedawcy musisz się <a href="/login">zalogować</a>.
        </div>
        </center>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <br>
        <h4>Imię i nazwisko: ${user.fullName}</h4>
        <h4>Email: ${user.email}</h4>
        <h4>Numer kontaktowy: ${user.phoneNumber}</h4>
        <h4>Profil: <a href="/user/${user.id}"> >>KLIK<< </a> </h4>
    </sec:authorize>
    <center>
        <h2>Tytuł aukcji: ${dto.title}</h2>
        <img class="img-rounded" alt="Cinque Terre" src="/offer/${dto.id}/image">
        <br>
        <br>
        <h2>Cena: ${dto.price} PLN</h2>
        <br>
        <br>
        <h2>Opis: </h2>
        <h3>${dto.description}</h3>
        <br>
        <br>

    </center>
    <sec:authorize access="isAuthenticated()">
    <form:form method="post">
    <button class="btn btn-dark" type="submit" style="float: right;margin-bottom: 10px">Dodaj to Wishlisty</button>
    </form:form>
    </sec:authorize>
    <br>
</div>
</body>
</html>
