<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.net.URI" %>
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
    <center>
        <br>
        <p>
        <h1>Profil użytkownika: </h1>
        <h2>${userdetails.username}</h2></p>
        <div style="margin: 100px;">
            <img class="img-circle" alt="Cinque Terre" src="/user/${userdetails.id}/image">
        </div>
        <div style="margin: 100px">
            <p>
            <h2> Imię i nazwisko:</h2>
            <h3>${userdetails.fullName}</h3></p>
            <p>
            <h2> Email:</h2>
            <h3>${userdetails.email}</h3></p>
            <p>
            <h2> Numer telefonu:</h2>
            <h3>+48 ${userdetails.phoneNumber}</h3></p>
        </div>
    </center>
    <div>
        <sec:authorize access="isAuthenticated()">
            <p style="float: left;font-weight: bold;font-size: medium">Skomentuj:</p>
            <p><form:form method="post" action="/addcomment/${userdetails.id}" modelAttribute="addcomment">
            <form:textarea cssClass="form-control" path="comment"/> <form:errors path="comment"
                                                                                 cssClass="alert alert-danger"/></p>
            <p style="float: left">
                <button class="btn btn-dark">Dodaj komentarz</button>
                <button class="btn btn-dark" type="reset">Reset</button>
            </p>
        </form:form>
        </sec:authorize>
        <br>
    </div>
    <div>
        <br>
        <p style=" font-size: medium;font-weight: bold;float:left;">Komentarze:</p>
        <br>
        <br>
        <c:forEach items="${comments}" var="comment">
            <div>
            <a style="float: left" href="/user/${comment.userCommenting.id}"><c:out value="${comment.userCommenting.username}"/></a>
            <br>
            <div class="alert alert-secondary" role="alert">
                <c:out value="${comment.comment}"/>
            </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
