<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/2/2019
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp set session attribute and then controller read it.</title>
</head>
<body>
<%
    session.setAttribute("id", 8L);
    response.sendRedirect("./attribute/sessionAttribute.do");
%>
</body>
</html>
