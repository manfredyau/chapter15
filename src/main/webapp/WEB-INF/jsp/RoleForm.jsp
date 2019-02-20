<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/2/2019
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>參數</title>
    <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
</head>
<body>
<form id="form" action="./params/commonParams.do">
    <table>
        <tr>
            <td>角色名稱</td>
            <td><input id="roleName" name="roleName" value=""/></td>
        </tr>
        <tr>
            <td>備註</td>
            <td><input id="note" name="note"/></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
