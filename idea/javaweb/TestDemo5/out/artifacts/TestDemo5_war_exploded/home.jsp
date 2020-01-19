<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: mochen
  Date: 2020/1/10
  Time: 上午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<%
    //解决中文乱码
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    //是否第一次访问
    boolean firstAccess = true;
    //获取当前时间
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    String nowTime = sdf.format(d);
    System.out.println("当前时间：" + nowTime);
    //获取cookie
    Cookie[] cookies = request.getCookies();
    if (cookies !=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("lastTime")){
                //不是第一次访问
                firstAccess = false;
                //显示时间
                PrintWriter writer = response.getWriter();
                writer.write("<h1>欢迎您，上次访问时间："+ URLDecoder.decode(cookie.getValue(), "utf-8")+"</h1>");
                //刷新cookie
                Cookie newCookie = new Cookie("lastTime", URLEncoder.encode(nowTime,"utf-8"));
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(newCookie);
                break;
            }
        }
    }
    //第一次访问
    if (firstAccess){
        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(nowTime,"utf-8"));
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        PrintWriter writer = response.getWriter();
        writer.write("<h1>当前是您第一次访问本网站！</h1>");
    }
%>
</body>
</html>
