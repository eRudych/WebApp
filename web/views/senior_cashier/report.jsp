<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/views/import/header.jsp"/>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/cash_machine"
                   user="root" password="root"/>
<sql:query dataSource="${snapshot}" var="resultDocumentation">
    SELECT * FROM documentation_of_work
</sql:query>
<table border="1" class="w3-table-all w3-hoverable">
    <tr class="w3-green">
        <th class="w3-quarter">Id</th>
        <th class="w3-quarter">Operation</th>
        <th class="w3-quarter">Cashier</th>
        <th class="w3-quarter">Check</th>
    </tr>
    <c:forEach var="row" items="${resultDocumentation.rows}">
        <tr>
            <td class="w3-quarter w3-green"><input type="number" name="id"
                                                   class="w3-input w3-animate-input w3-border w3-round-large" readonly
                                                   value="${row.Id}"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="number"
                                          readonly value="<c:out value = "${row.OperationId}"/>"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="number"
                                          readonly value="<c:out value = "${row.CashierId}"/>"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="number"
                                          readonly value="<c:out value = "${row.CheckId}"/>"></td>
        </tr>
    </c:forEach>
</table>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>
