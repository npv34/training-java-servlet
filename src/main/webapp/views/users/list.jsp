<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/7/25
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<h1>User manager</h1>
<c:set var="users" value='${requestScope["users"]}' />
<c:set var="index" value='1' />
<table class="table table-striped table-hover">
    <tr>
        <td>STT</td>
        <td>Name</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Address</td>
        <td></td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${index}"/></td>
            <td><c:out value="${user.getName()}"/></td>
            <td><c:out value="${user.getEmail()}"/></td>
            <td><c:out value="${user.getPhone()}"/></td>
            <td><c:out value="${user.getAddress()}"/></td>
            <td>
                <a onclick="return confirm('Are you sure?')" href="/users/delete?id=<c:out value="${user.getId()}"/>" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        <c:set var="index" value='${index + 1}' />
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>
</html>
