<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<c:import url="/views/import/header.jsp"/>
<div class="w3-container w3-green">
    <h2><c:out value="Check created"></c:out></h2>
</div>
<br>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/cash_machine"
                   user="root" password="root"/>
<sql:query dataSource="${snapshot}" var="resultStorage">
    SELECT storage.Amount, storage.ProductCode, product.ProductName as ProductName
    FROM storage_for_products storage
    INNER JOIN products product ON storage.ProductCode =product.Code
</sql:query>

<div class="w3-container w3-green">
    <h2>Add product to check</h2>
</div>
<form method="post" class="w3-selection w3-light-grey w3-padding w3-half">
    <p>
        <label>Code:
            <select class="w3-select w3-animate-select w3-border w3-round-large" name="code" required>
                <option value="" disabled selected>Choose your option</option>
                <c:forEach var="row" items="${resultStorage.rows}">
                    <option><c:out value="${row.ProductCode}"/></option>
                </c:forEach>
            </select>
        </label>

    </p>
    <input class="w3-input w3-animate-input w3-border w3-round-large" type="number" name="amount" min="0" value="${amount}"
           required>
    <br>
    <button type="Add" class="w3-btn w3-green w3-round-large w3-margin-bottom">Add</button>
</form>
<form method="post" class="w3-selection w3-light-grey w3-padding w3-half">
    <p>
        <label>Name:
            <select class="w3-select w3-animate-select w3-border w3-round-large" name="name" required>
                <option value="" disabled selected>Choose your option</option>
                <c:forEach var="row" items="${resultStorage.rows}">
                    <option><c:out value="${row.ProductName}"/></option>
                </c:forEach>
            </select>
        </label>
    </p>
    <input class="w3-input w3-animate-input w3-border w3-round-large" type="number" name="amount" min="0" value="${amount}"
           required>
    <br>
    <button type="Add" class="w3-btn w3-green w3-round-large w3-margin-bottom">Add</button>
</form>
<br>
<div>
    <form action="/close_check">
        <button type="Close" class="w3-btn w3-green w3-round-large w3-margin-bottom">Close check</button>
    </form>
</div>

</div>
</body>
</html>
