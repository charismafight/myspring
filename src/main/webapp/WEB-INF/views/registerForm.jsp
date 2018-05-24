<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
<h1>Register</h1>
<sf:form method="post" modelAttribute="spitter">
    First Name:<sf:input path="firstName"></sf:input><br/>
    <sf:errors path="firstName" cssClass="error"></sf:errors><br/>
    Last Name:<input type="text" name="lastName"/><br/>
    Username:<input type="text" name="username" id="username"><br/>
    Password:<input type="text" name="password" id="password"><br/>
    <input type="submit" value="register">
</sf:form>
</body>
</html>
