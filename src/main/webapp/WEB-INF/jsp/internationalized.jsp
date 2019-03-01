<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25/2/2019
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Internationalized</title>
</head>
<body>
<h2>
    <spring:message code="welcome"/>
</h2>
Locale:${pageContext.response.locale}
</body>
</html>
