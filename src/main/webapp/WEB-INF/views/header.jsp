<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.net.URI" %>
<%@ page import="com.github.daanielowsky.FinalProject.services.UserService" %>
<%@ page import="com.github.daanielowsky.FinalProject.entity.User" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authorize access="!isAuthenticated()">
    <div class="wrapper">
        <p style="float: left;" id="data"> Teraz mamy: ${date}.</p>
        <p style="float: right; padding: 10px;">
            <button type="button" onclick="javascript:document.location.href='/login'" class="btn btn-secondary btn-lg">
                Zaloguj
            </button>
            <button type="button" onclick="javascript:document.location.href='/register'"
                    class="btn btn-secondary btn-lg">
                Zarejestruj się
            </button>
        </p>
    </div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div style="float: left; " id="data"> Teraz mamy: ${date}.</div>
    <div class="dropdown" style="float: right; padding: 10px">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Opcje
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/editprofile">Edytuj profil</a>
            <a class="dropdown-item" href="/user/${userprofile.id}">Twój profil</a>
            <a class="dropdown-item" href="/offers">Twoje oferty</a>
            <a class="dropdown-item" href="/addoffer">Dodaj ofertę</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/logout">Wyloguj</a>
        </div>
    </div>
</sec:authorize>
<div class="header">
    <br>
    <br>
    <br>
    <p><a href="/"><img src="https://i.ibb.co/h1f24jy/cooltext321742886283374.png" border="0"></a></p>
</div>
<div style="height: 40px">
    <form method="get" action="/searchoffers">
        <input type="text" name="title" class="form-control" style="float: left;width: 90%;margin: 5px">
        <button type="submit" class="btn btn-dark" style="margin: 5px;float: right">Szukaj</button>
    </form>
</div>