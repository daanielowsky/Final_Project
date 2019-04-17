<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.net.URI" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>meKnife</title>
    <link rel="stylesheet" href="media/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<center>
    <div><img src="https://i.ibb.co/rk1D5S5/cooltext321562730776893.png"/></div>
    <div style="margin: 15px">
        <div style="margin: 15px">
            <img src="https://i.ibb.co/8Dfb7Gg/button-2.png" onclick="javascript:document.location.href='/search?category=Motoryzacja'"/>
            <img src="https://i.ibb.co/GMdLkbY/button-3.png" onclick="javascript:document.location.href='/search?category=Dom+i+ogród'"/>
            <img src="https://i.ibb.co/XpWcNLL/button-4.png" onclick="javascript:document.location.href='/search?category=Elektronika'"/></div>
        <div style="margin: 15px">
            <img src="https://i.ibb.co/c2nCJzp/button-5.png" onclick="javascript:document.location.href='/search?category=Moda'"/>
            <img src="https://i.ibb.co/8xZthtX/button-6.png" onclick="javascript:document.location.href='/search?category=Rolnictwo'"/>
            <img src="https://i.ibb.co/2Fb49CN/button-7.png" onclick="javascript:document.location.href='/search?category=Zwierzęta'"/></div>
        <div style="margin: 15px">
            <img src="https://i.ibb.co/tsqFc1v/button-8.png" onclick="javascript:document.location.href='/search?category=Dla+dzieci'"/>
            <img src="https://i.ibb.co/k6N2D0h/button-9.png" onclick="javascript:document.location.href='/search?category=Sport'"/>
            <img src="https://i.ibb.co/mtmmK0F/button-10.png" onclick="javascript:document.location.href='/search?category=Muzyka'"/>
            <img src="https://i.ibb.co/VxBxy2w/button-11.png" onclick="javascript:document.location.href='/search?category=Za+darmo'"/></div>
    </div>
</center>

</body>
</html>
