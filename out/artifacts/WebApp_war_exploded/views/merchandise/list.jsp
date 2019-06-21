<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Elisabeth
  Date: 05.06.2019
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Products</h2>
        </div>
        <select name="foo"  value="${products.ProductName}">
            <option value="">ALL</option>

        </select>
        <sql:query dataSource = "${products}" var = "product">
            SELECT * from products;
        </sql:query>
        <%
            List<String> names = (List<String>) request.getAttribute("productNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no products yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='../../index.jsp'">Back to main</button>
</div>
</body>
</html>