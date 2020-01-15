<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null || username.equals("")){
        response.setStatus(302);
        response.setHeader("location", "login.jsp");
        return;
    }
%>
