<%--
  Created by IntelliJ IDEA.
  User: 1157724662
  Date: 2019/10/27
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入页面</title>
</head>
<body>
    <form action="LoginServlet" method="post">

        账号：<input type="text" name="uname"/>
        密码：<input type="password" name="upwd"/>
        <input type="submit" value="登入"/>

    </form>
</body>
</html>
