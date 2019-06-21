<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Create product</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<c:import url="/views/import/header.jsp"/>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>New product</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Name:
                <input required type="text" name="productName"
                       class="w3-input w3-animate-input w3-border w3-round-large" maxlength="20"
                       style="width: 30%"><br/>
            </label>
            <label>Code:
                <input required type="number" name="code" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Price:
                <input required type="number" name="price" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Create</button>
        </form>
    </div>
</div>


<div class="w3-container w3-blue-grey w3-opacity ">
    <%
        if (request.getAttribute("code") != null) {
            out.println("<p>Product '" + request.getAttribute("code") + "' created!</p>");
        } else {
            out.println("<p>Fail! Try again!</p>");
        }
    %>
</div>


<c:import url="/views/import/footer.jsp"/>
</body>
</html>