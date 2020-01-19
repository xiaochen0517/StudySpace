<%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/11
  Time: 上午10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "tom");
%>
${requestScope.name}
</body>
</html>
