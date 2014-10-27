<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>UserList</title>
</head>
<body>

    USERS<br>
    <c:forEach var="iterUser" items="${users}">
        <p>id = ${iterUser.id}"</p>
        <p>login = ${iterUser.login}</p>
    </c:forEach>


</body>
</html>
