<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/2/2019
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<%
    request.setAttribute("id", 1L);
    request.getRequestDispatcher("./attribute/requestAttribute.do").forward(request, response);
%>
</body>
</html>
