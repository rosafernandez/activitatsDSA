<%--
  Created by IntelliJ IDEA.
  User: rosa
  Date: 17/11/2016
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>FIBONACCI</h2>
</br>
<a>
    <form action="/FibonaciServlet" method="get">
        Elige cuántas sucesiones deseas:
        <input type="text" name="num">
        <input type="submit" value="Accept">
    </form>
</a>
</body>
</html>
