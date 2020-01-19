<%@ page import="com.lxc.domain.User" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/11
  Time: 上午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setName("tom");
    user.setAge(23);
    user.setTime(new Date());

    request.setAttribute("user", user);
%>

${requestScope.user.name}
<br>
${requestScope.user.age}
<br>
${requestScope.user.time}
<br>
${user.birStr}
</body>
</html>
