<%@page language="java" contentType="text/html; ISO-8859-1"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>validate</title>
</head>
<body>
<form action="/validate/annotation.do">
    <table>
        <tr>
            <td>產品編號：</td>
            <td><input name="productId" id="productId"></td>
        </tr>
        <tr>
            <td>用戶編號：</td>
            <td><input name="userId" id="userId"></td>
        </tr>

        <tr>
            <td>交易日期：</td>
            <td><input name="date" id="date"></td>
        </tr>
        <tr>
            <td>價格：</td>
            <td><input name="price" id="price"></td>
        </tr>
        <tr>
            <td>數量：</td>
            <td><input name="quantity" id="quantity"></td>
        </tr>
        <tr>
            <td>交易金額：</td>
            <td><input name="amount" id="amount"></td>
        </tr>
        <tr>
            <td>用戶郵件：</td>
            <td><input name="email" id="email"></td>
        </tr>
        <tr>
            <td>備注：</td>
            <td><textarea name="note" id="note" cols="20" rows="5"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>