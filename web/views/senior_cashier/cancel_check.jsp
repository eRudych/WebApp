<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Check</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<h2>Check <c:out value="${check}"></c:out> canceled</h2>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>
