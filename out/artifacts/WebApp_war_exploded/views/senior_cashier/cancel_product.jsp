<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Cancel Product</title>
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<h2>Product <c:out value="${product}"></c:out> removed from check <c:out value="${check}"></c:out></h2>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>
