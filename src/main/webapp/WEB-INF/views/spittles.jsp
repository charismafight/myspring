<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 18-5-10
  Time: 下午11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles</title>
</head>
<body>
<c:forEach var="spittle" items="${spittleList}">
    <li id="spittle_<c:out value="spittle.id"></c:out>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"></c:out>
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"></c:out> </span>
            <span class="spittleLocation">(<c:out value="${spittle.latitude}"></c:out>,<c:out
                    value="${spittle.longtitude}"></c:out> )</span>
        </div>
    </li>
</c:forEach>
</body>
</html>
