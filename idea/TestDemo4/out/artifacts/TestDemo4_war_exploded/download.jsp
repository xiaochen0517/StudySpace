<%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/9
  Time: 上午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<input id="input" type="text">
<input id="button" type="button" value="下载文件">
<script>
    var inputbox = document.getElementById("input");
    var button = document.getElementById("button");

    button.onclick = function () {
        var inputValue = inputbox.value;
        window.location.href = "filedownload?filename="+inputValue;
    }
</script>
</body>
</html>
