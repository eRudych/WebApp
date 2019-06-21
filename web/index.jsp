<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Cash machine</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
    <style>
        a:lang(ru) {
            background: cornflowerblue;
        }
    </style>

</head>
<body>
    <c:import url="/views/import/header.jsp"/>
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <a lang="ru">Русский</a>
    <a>English</a>
</div>
<br>
<div class="w3-row-padding">

    <div class="w3-third w3-margin-bottom">
        <ul class="w3-ul w3-border w3-center w3-hover-shadow">
            <li class="w3-blue-grey w3-xlarge w3-padding-32">Cashier</li>
            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/open_check'">Open check</button></li>
        </ul>
    </div>

    <div class="w3-third w3-margin-bottom">

        <ul class="w3-ul w3-border w3-center w3-hover-shadow">
            <li class="w3-green w3-xlarge w3-padding-32">Senior Cashier</li>
            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/select_senior_cashier'">Cancel check</button></li>
            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/select_senior_cashier_for_product'">Cancel product</button></li>
            <li class="w3-padding-16"><button class="w3-button w3-green w3-padding-large" onclick="location.href='/select_senior_cashier'">Submit reports X&Y</button></li>
        </ul>
    </div>

    <div class="w3-third w3-margin-bottom">
        <ul class="w3-ul w3-border w3-center w3-hover-shadow">
            <li class="w3-blue-grey w3-xlarge w3-padding-32">Merchandise</li>
            <li class="w3-padding-16"> <button class="w3-button w3-green w3-padding-large" onclick="location.href='/create'">Create product</button></li>
            <li class="w3-padding-16"> <button class="w3-button w3-green w3-padding-large" onclick="location.href='/set_quantity'">Set quantity</button></li>
        </ul>
    </div>

</div>

</body>
</html>
