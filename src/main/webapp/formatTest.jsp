<%--
  Created by IntelliJ IDEA.
  User: Yau
  Date: 2019/2/24
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Format Test</title>
</head>
<body>
<form method="post" action="./convert/format.do">
    <table>
        <tr>
            <td>日期</td>
            <td><input name="date1" type="text" value="2019-01-01"></td>
        </tr>
        <tr>
            <td>金額</td>
            <td><input name="amount1" value="123,000.00" type="text"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
