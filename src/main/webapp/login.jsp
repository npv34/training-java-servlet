<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 4/23/25
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="message" value='${requestScope["message-error"]}' />
<p><c:out value="${message}"/></p>

<h1>Login page</h1>
<form action="/auth/login" method="post">
    <label for="email">Email</label>
    <input type="email" name="email" id="email">
    <label for="pass">Pass</label>
    <input type="password" name="pass" id="pass">
    <button type="submit">Login</button>
</form>
</body>
</html>
