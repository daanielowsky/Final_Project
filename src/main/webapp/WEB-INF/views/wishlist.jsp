<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
    <h3>Subskrypcje kategorii:</h3>
    <form method="post" action="/wishlist/category">
        <c:forEach items="${categories}" var="category">
            ${category.name}
            <label class="switch">
            <input type="checkbox" value="${category.name}"
                                   name="category" ${userCategories.contains(category) ? 'checked' : ''}/>
                <span class="slider round"></span>
            </label>
            <br>
        </c:forEach>
        <br>
        <small id="emailHelp" class="form-text text-muted">Po zaznaczeniu subskrypcji kategorii będziesz informowany mailowo o nowych ofertach z danej kategorii.</small>
        <button class="btn btn-dark" type="submit">Zapisz</button>
    </form>
    <c:forEach items="${wishlist}" var="wishlist">
    <div>
        <a style="float: left" href="/offer/${wishlist.id}"><c:out value="${wishlist.title}"/></a>
        <br>
        <div class="alert alert-secondary" role="alert">
            <c:out value="${wishlist.description}"/>
        </div>
        <button class="btn btn-dark" type="submit" style="float: right"
                onclick="javascript:document.location.href='/wishlist/delete/${wishlist.id}'">Usuń
        </button>
        <br>
        <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
