<%-- 
    Document   : page3
    Created on : Dec 10, 2018, 11:06:58 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/page3.css">

        <title>JSP Page3</title>
    </head>
    <body>
        <h1>Page 3</h1>
        ${info}<br>
        <a href="index.html">Главная страница</a>
        <ul>
    <c:forEach var="reader" items="${listReaders}">
        <li>${reader.code}, ${reader.name} ${reader.surname}
    </c:forEach>
        </ul>
</body>
</html>
