<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.incorrect}">
    <c:out value="registarion incorrect"/>
</c:if>



<form action="/controllerRegistration" method="post">
    <input type="hidden" name="action" value="registration"/>
    Name <input type="text" name="name"/>
    Login <input type="text" name="login"/><br/>
    Pass <input type="password" name="password"/><br/>
    <input type="submit" name="submit"/>
</form>
</body>
</html>
