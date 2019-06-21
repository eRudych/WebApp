<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
<head>
    <title>JSTL sql:query Tag</title>
</head>

<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                   url = "jdbc:mysql://localhost/cash_machine"
                   user = "root"  password = "root"/>

<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from products;
</sql:query>

<table border = "1" width = "100%">
    <tr>
        <th>Emp ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.ProductName}"/></td>
            <td> <c:out value = "${row.Code}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>