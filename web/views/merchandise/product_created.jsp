<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elisabeth
  Date: 24.06.2019
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancel Product</title>
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<h2>Product <c:out value="${code}"></c:out> created</h2>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>
