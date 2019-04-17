<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>meKnife</title>
    <link rel="stylesheet" href="/media/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="font-weight: bold; padding: 10px;background-color: #bfbfbf">
    <p><h2>Dodaj ofertę</h2></p>
    <form:form modelAttribute="addoffer" method="post">
        <p>Tytuł: <form:input cssClass="form-control" cssStyle="width: 30%" path="title"/>       <form:errors path="title" cssClass="alert alert-danger"/></p>
        <p>Opis: <form:textarea cssClass="form-control" path="description" />       <form:errors path="description" cssClass="alert alert-danger"/> </p>
        <p>Cena: <form:input path="price" cssStyle="width: 25%" cssClass="form-control"/> </p>
        <p>Kategoria: <form:select cssClass="form-control" path="category">
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
        <br>
        <button class="btn btn-dark" >Dodaj ofertę</button>
        <button class="btn btn-dark" type="reset">Reset</button>
    </form:form>
</div>
</body>
</html>
