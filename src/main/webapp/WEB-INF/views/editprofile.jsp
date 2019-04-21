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
<div class="registerpage">
    <p><h2>Edytuj profil</h2></p>
    <form:form modelAttribute="editUserDTO" method="post">
        <p>Imię i nazwisko: <form:input cssClass="form-control" cssStyle="width: 30%" path="fullName"/>       <form:errors path="fullName" cssClass="alert alert-danger"/></p>
        <p>Email: <form:input cssClass="form-control" cssStyle="width: 30%" path="email" />       <form:errors path="email" cssClass="alert alert-danger"/> </p>
        <p>Numer telefonu: <form:input cssClass="form-control" cssStyle="width: 30%" path="phoneNumber" />       <form:errors path="phoneNumber" cssClass="alert alert-danger"/> </p>
        <br>
        <button type="submit" class="btn btn-dark" >Zapisz</button>
    </form:form>
</div>
</body>
</html>
