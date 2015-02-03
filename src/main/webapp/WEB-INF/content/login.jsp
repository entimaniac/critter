<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.LoginAction"--%>

<html>
<head>
    <app:common-head/>
    <title>LOGIN</title>
    <style>
        body {
            margin-top: 40px;
        }
        .center-block {
            margin-left: auto;
            margin-right: auto;
        }
        .user-form {
            max-width: 300px;
        }
        .title {
            margin-bottom: 40px;
            width: 140px;
            color: #00DFFC;
        }
    </style>


</head>
<body>
<div>

    <div class="container">
        <div class="row">
            <div class="center-block title">
                 <h2>CRITTER</h2>
            </div>
        </div>

        <div class="center-block user-form">
            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>
            <form role="form" action="${pageContext.request.contextPath}/login" method="post">
                <input id="email-field" name="email" type="email" value="${action.email}" placeholder="EMAIL">
                <input id="password-field" name="password" type="password" placeholder="PASSWORD">
                <button type="submit">SIGN IN</button>
                <a class="ui-btn ui-shadow ui-btn-corner-all" href="${pageContext.request.contextPath}/register">CREATE AN ACCOUNT</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
