<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${sessionScope.correctLogin}">
    <c:out value="login incorrect"/>
</c:if>

<c:if test="${not empty sessionScope.login}">
    <c:redirect url="/user.jsp"/>
</c:if>

<form action="/controller" method="post">
    <input type="hidden" name="action" value="login"/>
    Login <input type="text" name="login"/><br/>
    Pass <input type="password" name="password"/><br/>
    <input type="submit" name="submit"/>
</form>

</body>
</html>
