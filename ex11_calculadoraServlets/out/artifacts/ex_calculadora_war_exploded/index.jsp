<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: rosa
  Date: 17/11/2016
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Inicio de nuestro servlet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p>
  Escoge una opción: Fibonaci o Calculadora ${name}
</p>
<form action ="/calculadora.jsp" method="post">
  <a href= "calculadora.jsp">Accecer a Calculadora</a>
</form>
<p>
<form action ="/fibonaci.jsp" method="get">
  <a href= "fibonaci.jsp">Accecer a Fibonacci</a>
</form>
</p>
<% Date date = new Date(); %>
<div>La fecha actual es: <%=date%></div>
</body>
</html>