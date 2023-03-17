<%--
  Created by IntelliJ IDEA.
  User: 80629
  Date: 2022/7/29
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String a = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
//    String requesturl = request.getRequestURI();

    request.setAttribute("basePath",a);
/*
scheme获取传输协议
serverName获取ip地址   http://localhost:8080/guigubook/
serverport获取端口号
contextpath获取工程名
*
**/

%>

<%--<%=a%>--%>
<base href="<%=a%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</body>
</html>
