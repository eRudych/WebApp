<%--
  Created by IntelliJ IDEA.
  User: Elisabeth
  Date: 12.06.2019
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Cash machine</h1>
    <h1>Машина для счета</h1>
    <p:commandLink value="English" action="#{localeController.selectLanguage('en')}" rendered="#{localeController.ru}"/>
    <p:commandLink value="Русский" action="#{localeController.selectLanguage('ru')}" rendered="#{not localeController.ru}"/>
</div>
</body>
</html>