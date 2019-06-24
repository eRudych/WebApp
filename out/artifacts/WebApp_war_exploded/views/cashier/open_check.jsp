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

<%--<div class="w3-row-padding">--%>
<%--    <div class="w3-third w3-margin-bottom">--%>
<%--        <ul class="w3-ul w3-border w3-center w3-hover-shadow">--%>
<%--            <li class="w3-blue-grey w3-xlarge w3-padding-32">Cashier</li>--%>
<%--            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/check'">Add product</button></li>--%>
<%--            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/close_check'">Close check</button></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"--%>
<%--                   url="jdbc:mysql://localhost/cash_machine"--%>
<%--                   user="root" password="root"/>--%>
<%--    <sql:query dataSource="${snapshot}" var="resultStorage">--%>
<%--        SELECT storage.Amount, storage.ProductCode, product.ProductName as ProductName--%>
<%--        FROM storage_for_products storage--%>
<%--        INNER JOIN products product ON storage.ProductCode =product.Code--%>
<%--    </sql:query>--%>
<%--    <div class="w3-container w3-green">--%>
<%--        <h2>Add product to check</h2>--%>
<%--    </div>--%>
<%--    <form method="post" class="w3-selection w3-light-grey w3-padding ">--%>
<%--        <p>--%>
<%--            <label>Code:--%>
<%--                <select class="w3-select w3-animate-select w3-border w3-round-large" name="code" required>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <c:forEach var="row" items="${resultStorage.rows}">--%>
<%--                        <option><c:out value="${row.ProductCode}"/></option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </label>--%>
<%--&lt;%&ndash;            <b>OR</b>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <label>Name:&ndash;%&gt;--%>
<%--&lt;%&ndash;                <select class="w3-select w3-animate-select w3-border w3-round-large" name="name" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <option value="" disabled selected>Choose your option</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <c:forEach var="row" items="${resultStorage.rows}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <option><c:out value="${row.ProductName}"/></option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </label>&ndash;%&gt;--%>
<%--        </p>--%>
<%--        <input class="w3-input w3-animate-input w3-border w3-round-large" type="number" name="newAmount" value="${newAmount}"--%>
<%--               required>--%>
<%--        <br>--%>
<%--        <button type="Add" class="w3-btn w3-green w3-round-large w3-margin-bottom">Add</button>--%>
<%--    </form>--%>
<%--    <br>--%>
<%--<sql:query dataSource="${snapshot}" var="resulChecks">--%>
<%--    SELECT MAX(Id) AS IdMax FROM checks--%>
<%--    SELECT ProductCode, Amount--%>
<%--    FROM checks--%>
<%--    WHERE checks.Id=IdMax--%>

<%--</sql:query>--%>
<%--    <div class="w3-container w3-green">--%>
<%--        <h2>Check</h2>--%>
<%--    </div>--%>
<%--    <table border="1" class="w3-table-all w3-hoverable">--%>
<%--        <tr class="w3-green">--%>
<%--            <th class="w3-third">Code</th>--%>
<%--            <th class="w3-third">Name</th>--%>
<%--            <th class="w3-third">Amount</th>--%>
<%--        </tr>--%>

<%--        <c:forEach var="item" items="${resultChecks.items}">--%>
<%--            <tr>--%>
<%--                <td class="w3-third"><input name=""productCode class="w3-input w3-animate-input w3-border w3-round-large" type="number"--%>
<%--                                            readonly value="<c:out value = "${item.ProductCode}"/>"></td>--%>
<%--                <td class="w3-third"><input name="productName" class="w3-input w3-animate-input w3-border w3-round-large" type="text"--%>
<%--                                            readonly value="<c:out value = "${item.ProductName}"/>"></td>--%>
<%--                <td class="w3-third w3-green"><input type="number" name="amount"--%>
<%--                                                     class="w3-input w3-animate-input w3-border w3-round-large" readonly--%>
<%--                                                     value="${item.Amount}"></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>

<%--    </table>--%>
<c:import url="/views/import/footer.jsp"/>
</body>
</html>