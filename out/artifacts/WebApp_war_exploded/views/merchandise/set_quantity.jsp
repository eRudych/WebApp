<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Storage</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<c:import url="/views/import/header.jsp"/>
<%--<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"--%>
<%--                                                              url="jdbc:mysql://localhost/cash_machine"--%>
<%--                                                              user="root" password="root"/>--%>


<%--    <sql:query dataSource="${snapshot}" var="resultStorage">--%>
<%--    SELECT storage.Amount, storage.ProductCode, product.ProductName as ProductName--%>
<%--    FROM storage_for_products storage--%>
<%--    INNER JOIN products product ON storage.ProductCode =product.Code--%>
<%--    </sql:query>--%>
    <div class="w3-container w3-green">
        <h2>Setting the quantity for products</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding ">
        <label>Select code:
        <select class="w3-select w3-animate-select w3-border w3-round-large" name="code" required>
            <option value="" disabled selected>Choose your option</option>
            <c:forEach var="row" items="${resultStorage.rows}">
                <option><c:out value="${row.getInt(2)}"/></option>
            </c:forEach>
        </select>
        </label>
        <label>Quantity:
        <input class="w3-input w3-animate-input w3-border w3-round-large" type="number" name="newAmount" value="0"
               required>
        <br>
        </label>
        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Set</button>
    </form>
    <br>
    <div class="w3-container w3-green">
        <h2>Storage</h2>
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

    <c:import url="/views/import/footer.jsp"/>
</body>
</html>