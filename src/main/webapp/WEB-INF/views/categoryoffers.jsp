<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="media/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <table class="table table-bordered" style="background-color: #bfbfbf">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tytuł</th>
            <th scope="col">Opis</th>
            <th scope="col">Kategoria</th>
            <th scope="col">Cena</th>
        </tr>
        </thead>
        <c:forEach items="${oferts}" var="ofert">
            <tbody>
            <tr>
                <th scope="row">${ofert.id}</th>
                <td>${ofert.title}</td>
                <td>${ofert.description}</td>
                <td>${ofert.category}</td>
                <td>${ofert.price}</td>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
