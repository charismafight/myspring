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
    <sf:errors element="div" path="*" cssClass="errors"></sf:errors>
    <sf:label path="firstName" cssErrorClass="errors">First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="errors"></sf:input><br/>
    <sf:label path="lastName" cssErrorClass="errors">Last Name:</sf:label><sf:input path="lastName"/><br/>
    Username:<input type="text" name="username" id="username"><br/>
    Password:<input type="text" name="password" id="password"><br/>

    <input type="submit" value="register">
</sf:form>
</body>
</html>
