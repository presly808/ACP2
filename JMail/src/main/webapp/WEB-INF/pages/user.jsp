<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>USER INFO</title>
</head>
<body>
    USER INFO<br>
    id = ${user.id}<br>
    login = ${user.login}<br> <%--JSTL Expression Language, get user from context with its fields by getters--%>
</body>
</html>
