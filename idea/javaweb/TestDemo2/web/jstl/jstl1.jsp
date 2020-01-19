<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/12
  Time: 上午8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="true">
    显示
</c:if>
<p>----------------</p>

<%
    request.setAttribute("num", 2);
%>

<c:choose>
    <c:when test="${num == 1}">1</c:when>
    <c:when test="${num == 2}">2</c:when>

    <c:otherwise>other</c:otherwise>
</c:choose>

<p>----------------</p>

<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>

<p>----------------</p>

<%
    List<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    request.setAttribute("list", list);
%>

<c:forEach items="${list}" var="str" varStatus="s">
    ${str}<br>
</c:forEach>

</body>
</html>
