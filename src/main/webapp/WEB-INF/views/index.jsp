<%@ page import="java.net.URI" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>meKnife</title>
    <style>
        body{
            background-color: white;
            margin-left: 10%;
            margin-right: 10%;
            margin-top: 30px;
        }
        .header {
            background-color: #bfbfbf
        ;
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
</body>
</html>
