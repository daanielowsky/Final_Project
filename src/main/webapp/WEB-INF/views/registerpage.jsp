<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>meKnife - Rejestracja</title>
    <style>
        body{
            background-color: white;
            margin-left: 10%;
            margin-right: 10%;
            margin-top: 30px;
        }
        .header {
            background-color: #bfbfbf;
            padding: 30px;
            text-align: center;
        }
        #data{
            padding:10px;
            color:#585858;
            font-weight:bold;
        }

    </style>
</head>
<body>
<div class="wrapper">
    <p style="float: left" id="data"> Teraz mamy: ${date}.</p>
    <p style="float: right"><button type="button" onclick="javascript:document.location.href='/login'" class="btn btn-secondary btn-lg">Zaloguj</button>
        <button type="button" onclick="javascript:document.location.href='/register'" class="btn btn-secondary btn-lg">Zarejestruj się</button></p>
</div>
<div class="header">
    <br>
    <br>
    <br>
    <p><a href="/"><img src="https://i.ibb.co/zHrRg6Q/Cool-Text-meknife-321318491053171.png" border="0"></a></p>
</div>
<div>
    szukajka
</div>
<br>
<div style="font-weight: bold; padding: 10px;background-color: #bfbfbf">
    <p><h2>Zarejestruj się</h2></p>
    <form:form modelAttribute="user" method="post">
        <p>Imię i nazwisko: <form:input cssClass="form-control" cssStyle="width: 30%" path="fullName"/>       <form:errors path="fullName" cssClass="alert alert-danger"/></p>
        <p>Nazwa użytkownika: <form:input cssClass="form-control" cssStyle="width: 30%" path="username" />       <form:errors path="username" cssClass="alert alert-danger"/> </p>
        <p>Hasło: <form:password cssClass="form-control" cssStyle="width: 30%" path="password"/>      <form:errors path="password" cssClass="alert alert-danger"/> </p>
        <p>Powtórz hasło: <form:password cssClass="form-control" cssStyle="width: 30%" path="confirmedPassword"/>      <form:errors path="confirmedPassword" cssClass="alert alert-danger"/> </p>
        <br>
        <button class="btn btn-dark" >Zarejestruj się</button>
        <button class="btn btn-dark" type="reset">Reset</button>
    </form:form>
</div>
</body>
</html>
