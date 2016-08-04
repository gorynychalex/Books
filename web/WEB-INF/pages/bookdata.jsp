<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 29.07.2016
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book data</title>
</head>
<body>
<h1>Информация о книге:</h1>
<table >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.bookTitle}</td>
        <td>${book.bookAuthor}</td>
        <td>${book.price}</td>
    </tr>
</table>
</body>
</html>
