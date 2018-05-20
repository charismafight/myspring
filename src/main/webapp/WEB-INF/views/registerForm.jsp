<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 18-5-20
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>">
</head>
<body>
<h1>Register</h1>
<form method="post">
    First Name:<input type="text" name="firstName"/><br/>
    Last Name:<input type="text" name="lastName"/><br/>
    Username:<input type="text" name="username" id="username"><br/>
    Password:<input type="text" name="password" id="password"><br/>
    <input type="submit" value="register">
</form>
</body>
</html>
