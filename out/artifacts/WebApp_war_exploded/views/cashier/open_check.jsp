<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check</title>
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/cash_machine"
                   user="root" password="root"/>
<sql:query dataSource="${snapshot}" var="resultCashiers">
    SELECT Id FROM cashiers WHERE SeniorPosition=0
</sql:query>
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Create check</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Id Cashier:
                <select class="w3-select w3-animate-select w3-border w3-round-large" name="idCashier" required>
                    <option value="" disabled selected>Choose your option</option>
                    <c:forEach var="row" items="${resultCashiers.rows}">
                        <option><c:out value="${row.Id}"/></option>
                    </c:forEach>
                </select>
            </label></br>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Create</button>
        </form>
    </div>
</div>

<c:import url="/views/import/footer.jsp"/>
</body>
</html>