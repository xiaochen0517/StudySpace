<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/11
  Time: 上午10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("tom");
    list.add("jack");

    request.setAttribute("list", list);

    Map<String, String> map = new HashMap<>();
    map.put("name", "tom");
    map.put("age", "22");
    map.put("sex", "man");

    request.setAttribute("map", map);
%>
<p>获取list</p>
${list}
<br>
${list[0]}
<br>
${list[1]}
<p>获取map</p>
${map.name}
<br>
${map["name"]}
</body>
</html>
