<%--
  Created by IntelliJ IDEA.
  User: rosa
  Date: 17/11/2016
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to calculator</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p>Bienvenido ${name}</p>
<p>Escoge los números y la operación que desees realizar:</p>
<form action="/CalculadoraServlet" method="post">
    Operando 1:<br>
    <input type="number" name="operando1" step="any"><br>
    Operando 2:<br>
    <input type="number" name="operando2" step="any"><br>
    <select operacion="operacion" name="operacion">
        <option value="SUMA">SUMA</option>
        <option value="RESTA">RESTA</option>
        <option value="MULTIPLICACION">MULTIPLICACION</option>
        <option value="DIVISION">DIVISIÓN</option>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>