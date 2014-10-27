<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.10.2014
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<String> names = (List<String>) request.getAttribute("names");%>
<html>
<head>
    <title></title>
</head>
<body>

    <h1>NAMES:</h1>
        <%for(String name : names) {%>
            <%=name%></br>
        <%}%>


</body>
</html>
