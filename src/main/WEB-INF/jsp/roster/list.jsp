<%--
  Created by IntelliJ IDEA.
  User: chari
  Date: 2018/4/30
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Roster</title>
</head>
<body>
<h1>Roster</h1>
<ul>
    <c:forEach var="member" items="${memberList}" varStatus="status">
        <li>
            <a href="member.do?id=${status.index}">
                <c:out value="${member}"></c:out>
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
