<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Welcome to the main page</title>
</head>
<body>
    <h2>Company Home Page</h2>
    <hr>

    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <hr>

    <!-- Add a link to point to /leaders -->
    <security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
    </p>
    </security:authorize>

    <!-- Add a link to point to /systems -->
    <security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems meeting</a>
    </p>
    </security:authorize>
    <hr>

    Welcome to the company home page

</body>
</html>
