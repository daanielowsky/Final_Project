<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="boxes">
        <p>
        <h2>Zaloguj się</h2></p>
        <form method="post" action="/login">
            <c:if test="${param.error !=null}">
                <span class="alert alert-danger">Nieprawidłowe dane logowania</span>
            </c:if>
            <c:if test="${param.logout != null}">
                <span class="alert alert-success">Zostałeś wylogowany</span>
            </c:if>
            <br>
            <br>
            <p>Nazwa użytkownika: <input type="text" class="form-control" name="username" placeholder="Nazwa użytkownika" required min="3" max="20"></p>
            <p>Hasło: <input type="password" class="form-control" name="password" placeholder="Hasło" required min="3" max="20"></p>
            <p>Remember me <input type="checkbox" name="remember-me"></p>
            <br>
            <button class="btn btn-dark">Zaloguj się</button>
        </form>
    </div>
    <div class="boxes">
        <p>
        <h2>Nie masz jeszcze konta? Zarejestruj się</h2></p>
        <form:form modelAttribute="user" method="post" action="/register" enctype="multipart/form-data">
            <p>Imię i nazwisko: <form:input cssClass="form-control" path="fullName"/>       <form:errors path="fullName" cssClass="alert alert-danger"/></p>
            <p>Nazwa użytkownika: <form:input cssClass="form-control" path="username" />       <form:errors path="username" cssClass="alert alert-danger"/> </p>
            <p>Email: <form:input cssClass="form-control" path="email" />       <form:errors path="email" cssClass="alert alert-danger"/> </p>
            <p>Numer telefonu: <form:input cssClass="form-control"  path="phoneNumber" />       <form:errors path="phoneNumber" cssClass="alert alert-danger"/> </p>
            <p>Hasło: <form:password cssClass="form-control" path="password"/>      <form:errors path="password" cssClass="alert alert-danger"/> </p>
            <p>Powtórz hasło: <form:password cssClass="form-control" path="confirmedPassword"/>      <form:errors path="confirmedPassword" cssClass="alert alert-danger"/> </p>
            <p>Zdjęcie profilowe: <br><input type="file" name="userImage"/></p>

            <br>
            <button class="btn btn-dark" >Zarejestruj się</button>
            <button class="btn btn-dark" type="reset">Reset</button>
        </form:form>
    </div>
</div>
</body>
</html>
