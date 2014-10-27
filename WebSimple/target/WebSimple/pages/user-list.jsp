<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.10.14
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<String> names = (List<String>) request.getAttribute("names");%>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>   NAMES </h1><br/>

    <% for(String name : names){%>
        <%=name%></br>
        <%}%>

</body>
</html>