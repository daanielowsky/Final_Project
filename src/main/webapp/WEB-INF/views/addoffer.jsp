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
<div style="font-weight: bold; padding: 10px;background-color: #bfbfbf">
    <p>
    <h2>Dodaj ofertę</h2></p>
    <form:form modelAttribute="addoffer" method="post" enctype="multipart/form-data">
        <p>Tytuł: <form:input cssClass="form-control" cssStyle="width: 30%" path="title"/> <form:errors path="title"
                                                                                                        cssClass="alert alert-danger"/>
            <small class="form-text text-muted">Tytuł powinien zawierać co najmniej 3 znaki.</small></p>
        <p>Opis: <form:textarea cssClass="form-control" path="description" cssStyle="width: 30%;height: 30%"/> <form:errors path="description"
                                                                                          cssClass="alert alert-danger"/>
            <small class="form-text text-muted">Opis powinien zawierać co najmniej 3 znaki.</small></p>
        <p>Cena: <form:input path="price" cssStyle="width: 25%" cssClass="form-control"/>
            <small class="form-text text-muted">Słownie lub liczbowo.</small>
        </p>
        <p>Kategoria:
            <form:select cssClass="form-control" cssStyle="width: 30%" path="category">
            <form:option value="Motoryzacja">Motoryzacja</form:option>
            <form:option value="Dom i ogród">Dom i ogród</form:option>
            <form:option value="Elektronika">Elektronika</form:option>
            <form:option value="Moda">Moda</form:option>
            <form:option value="Rolnictwo">Rolnictwo</form:option>
            <form:option value="Zwierzęta">Zwierzęta</form:option>
            <form:option value="Dla dzieci">Dla dzieci</form:option>
            <form:option value="Sport">Sport</form:option>
            <form:option value="Muzyka">Muzyka</form:option>
            <form:option value="Za darmo">Za darmo</form:option>
            </form:select>
            <small class="form-text text-muted">Dobierz odpowiednią kategorię do produktu.</small></p>
        <p>Zdjęcie przedmiotu: </p>
        <input type="file" name="offerImage"/>
        <br>
        <br>
        <button class="btn btn-dark">Dodaj ofertę</button>
        <button class="btn btn-dark" type="reset">Reset</button>
    </form:form>
</div>
</body>
</html>
