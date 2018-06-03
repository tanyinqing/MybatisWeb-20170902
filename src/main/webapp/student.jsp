<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-06-03
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student page</title>
</head>
<body>
<h1>student</h1>
<p>${sessionScope.student.name}</p>
<ul>
    <c:forEach var="course" items="${sessionScope.student.courses}">
        <li>${course.title}</li>
    </c:forEach>
</ul>
</body>
</html>
</jsp:root>