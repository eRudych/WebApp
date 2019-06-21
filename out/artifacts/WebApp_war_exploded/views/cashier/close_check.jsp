<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elisabeth
  Date: 11.06.2019
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/views/import/header.jsp"/>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/cash_machine"
                   user="root" password="root"/>


<sql:query dataSource="${snapshot}" var="resultStorage">
<%--    SELECT  * FROM check_contents WHERE IdCheck=?--%>
<%--    <sql:param value = "${id}" />--%>

    SELECT check_.Amount, check_.ProductCode, product.ProductName as ProductName
    FROM check_contents check_
    INNER JOIN products product ON check_.ProductCode =product.Code
    WHERE IdCheck=?
    <sql:param value = "${id}" />
</sql:query>
<div class="w3-container w3-green">
    <h2>Check number <c:out value = "${id}" /></h2>
</div>
<table border="1" class="w3-table-all w3-hoverable">
    <tr class="w3-green">
        <th class="w3-third">ProductCode</th>
        <th class="w3-third">ProductName</th>
        <th class="w3-third">Amount</th>
    </tr>

    <c:forEach var="row" items="${resultStorage.rows}">
        <tr>
            <td class="w3-third"><input class="w3-input w3-animate-input w3-border w3-round-large" type="text"
                                        readonly value="<c:out value = "${row.ProductCode}"/>"></td>
            <td class="w3-third"><input class="w3-input w3-animate-input w3-border w3-round-large" type="text"
                                        readonly value="<c:out value = "${row.ProductName}"/>"></td>
            <td class="w3-third "><input type="number" name="amount" class="w3-input w3-animate-input w3-border w3-round-large" readonly value="<c:out value = "${row.Amount}"/>"></td>
        </tr>
    </c:forEach>

</table>

<c:import url="/views/import/footer.jsp"/>
</body>
</html>
