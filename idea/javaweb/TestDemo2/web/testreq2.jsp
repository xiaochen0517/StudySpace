<%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/7
  Time: 上午9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestReq2</title>
</head>
<body>
<h4>POST</h4>
<form action="testreq2" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>

    <input type="checkbox" name="checkbox" value="game">游戏
    <input type="checkbox" name="checkbox" value="movie">电影<br>

    <input type="submit" name="commit" value="提交">
</form>
<h4>GET</h4>
<form action="testreq2" method="get">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit" name="commit">
</form>
</body>
</html>
