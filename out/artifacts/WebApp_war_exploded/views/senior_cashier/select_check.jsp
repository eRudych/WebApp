<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select check</title>
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/cash_machine"
                   user="root" password="root"/>
<sql:query dataSource="${snapshot}" var="resultStorage">
    SELECT check_.IdCheck, check_.Amount, check_.ProductCode as ProductCode, product.ProductName as ProductName
    FROM check_contents check_
    INNER JOIN products product ON check_.ProductCode =product.Code
    ORDER BY IdCheck
</sql:query>
<div class="w3-container w3-green">
    <h2>Selecting a check to remove</h2>
</div>
<form method="post" class="w3-selection w3-light-grey w3-padding ">
    <label>Select code:
        <select class="w3-select w3-animate-select w3-border w3-round-large" name="check" required>
            <option value="" disabled selected>Choose your option</option>
            <c:forEach var="row" items="${resultStorage.rows}">
                <option><c:out value="${row.IdCheck}"/></option>
            </c:forEach>
        </select>
    </label>
    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Select</button>
</form>
<br>
<div class="w3-container w3-green">
    <h2>Storage</h2>
</div>
<table border="1" class="w3-table-all w3-hoverable">
    <tr class="w3-green">
        <th class="w3-quarter">Id</th>
        <th class="w3-quarter">ProductCode</th>
        <th class="w3-quarter">ProductName</th>
        <th class="w3-quarter">Amount</th>
    </tr>
    <c:forEach var="row" items="${resultStorage.rows}">
        <tr>
            <td class="w3-quarter w3-green"><input type="number" name="id"
                                                   class="w3-input w3-animate-input w3-border w3-round-large" readonly
                                                   value="${row.IdCheck}"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="number"
                                          readonly value="<c:out value = "${row.ProductCode}"/>"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="text"
                                          readonly value="<c:out value = "${row.ProductName}"/>"></td>
            <td class="w3-quarter"><input class="w3-input w3-animate-input w3-border w3-round-large" type="text"
                                          readonly value="<c:out value = "${row.Amount}"/>"></td>
        </tr>
    </c:forEach>
</table>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>


