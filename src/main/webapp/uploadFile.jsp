<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/2/2019
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上傳</title>
</head>
<body>
<form action="./file/uploadMultipartFile.do" enctype="multipart/form-data">
    <input type="file" name="file" value="請選擇上傳的文件"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
