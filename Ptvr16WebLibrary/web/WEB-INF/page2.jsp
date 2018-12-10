<%-- 
    Document   : page2
    Created on : Dec 10, 2018, 10:40:37 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/page2.css">
        <title>JSP Page2</title>
    </head>
    <body>
        <h1>Page 2</h1>
        <b>${info}</b><br>
        <a href="index.html">Главная страница</a>
        <ul>
            
            <c:forEach var="book" items="${listBooks}">
                <li>${book.name}, ${book.author}, ${book.isbn}
            </c:forEach>
            
        </ul>
    </body>
</html>
