<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.net.URI" %>
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
    <p style="float: left; " id="data"> Teraz mamy: ${date}.</p>
    <p style="float: right; padding: 10px">
        <button type="button" onclick="javascript:document.location.href='/addoffer'"
                class="btn btn-secondary btn-lg">
            Dodaj ofertę
        </button>
        <button type="button" onclick="javascript:document.location.href='/offers'"
                class="btn btn-secondary btn-lg">
            Twoje Oferty
        </button>
        <button type="button" onclick="javascript:document.location.href='/logout'"
                class="btn btn-secondary btn-lg">
            Wyloguj
        </button>
    </p>
</sec:authorize>
<div class="header">
    <br>
    <br>
    <br>
    <p><a href="/"><img src="https://i.ibb.co/zHrRg6Q/Cool-Text-meknife-321318491053171.png" border="0"></a></p>
</div>
<div style="height: 40px">
<form method="get" action="/searchoffers">
    <input type="text" name="title" class="form-control" style="float: left;width: 90%;margin: 5px">
    <button type="submit" class="btn btn-dark" style="margin: 5px;float: right">Szukaj</button>
</form>
</div>