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
    <script>
        /*$(document).ready(function () {
            var data = {
                roleName: 'role',
                note: 'note',

                pageParams: {
                    start: 1,
                    limit: 20
                }
            };

            $.post({
                url: "./params/findRoles.do",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (result) {
                    document.writeln("hello, world")
                }
            })
        })*/

        /* $(document).ready(function () {
             var idList = [1, 2, 3];

             $.post({
                 url: "./params/deleteRoles.do",
                 data: JSON.stringify(idList),
                 contentType: "application/json",
                 success: function (result) {
                     document.writeln("hello, world")
                     document.writeln(result)
                 }
             })
         })*/

         /* $(document).ready(function () {
              var roleList = [
                  {roleName: 'role_name_one', note: 'note_one'},
                  {roleName: 'role_name_two', note: 'note_two'},
                  {roleName: 'role_name_three', note: 'note_three'}
              ];

              $.post({
                  url:"./params/addRoles.do",
                  data: JSON.stringify(roleList),
                  contentType: "application/json",
                  success:function (result) {

                  }
              })
          })*/

        $(document).ready(function () {
            $("#commit").click(function () {
                var str = $("form").serialize();
                $.post({
                    url: "./params/addRole2.do",
                    data: str,
                    success: function (result) {
                        document.writeln("Success!!!");
                        document.writeln(result)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form id="form">
    <table>
        <tr>
            <td>角色名稱</td>
            <td><input id="roleName" name="role_name" value=""/></td>
        </tr>
        <tr>
            <td>備註</td>
            <td><input id="note" name="note"/></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input id="commit" type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
