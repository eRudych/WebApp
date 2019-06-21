<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Elisabeth
  Date: 16.06.2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<sql:query dataSource="${snapshot}" var="resultStorage">
    SELECT * FROM checks
</sql:query>
<body>
<div class="w3-container w3-green">
    <h2>Check</h2>
</div>
<table border="1" class="w3-table-all w3-hoverable">
    <tr class="w3-green">
        <th class="w3-third">Code</th>
        <th class="w3-third">Name</th>
        <th class="w3-third">Amount</th>
    </tr>

    <c:forEach var="row" items="${resultStorage.rows}">
        <tr>
            <td class="w3-third"><input class="w3-input w3-animate-input w3-border w3-round-large" type="number"
                                        readonly value="<c:out value = "${row.ProductCode}"/>"></td>
            <td class="w3-third"><input class="w3-input w3-animate-input w3-border w3-round-large" type="text"
                                        readonly value="<c:out value = "${row.ProductName}"/>"></td>
            <td class="w3-third w3-green"><input type="number" name="amount"
                                                 class="w3-input w3-animate-input w3-border w3-round-large" readonly
                                                 value="${row.Amount}"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
