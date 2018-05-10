<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 18-5-9
  Time: 下午10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
This is Home page
<a href="<c:url value="//list"></c:url>">Spittles</a>
<a href="<c:url value="/spittles/register"></c:url>">Register</a>
</body>
</html>
