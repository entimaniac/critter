<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.RegisterAction"--%>

<html>
<head>
    <app:common-head/>
    <title>REGISTER</title>
   <%-- <style>
        body {
            margin-top: 40px;
            background-color: #343838;
        }

        .center-block {
            margin-left: auto;
            margin-right: auto;
        }
        .user-form {
            max-width: 300px;
        }

        .title {
            width: 140px;
            margin-bottom: 40px;
        }

    </style>--%>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="center-block title" >
            <h2>CRITTER</h2>
        </div>
    </div>

    <div class="center-block user-form">
        <c:forEach items="${action.fieldErrors}" var="error">
            <span class="text-danger">${error.value}</span><br/>
        </c:forEach>
        <form role="form" action="${pageContext.request.contextPath}/register" method="post">
            <input id="name-field" name="name" type="text" value="${action.name}" placeholder="NAME">
            <input id="email-field" name="email" type="email" value="${action.email}" placeholder="EMAIL">
            <input id="password-field" name="password" type="password" placeholder="PASSWORD">
            <input id="confirm-password-field" name="confirmPassword" type="password" placeholder="RETYPE PASSWORD">
            <button type="submit" class="">SUBMIT</button>
            <a class="ui-btn ui-shadow ui-btn-corner-all" href="${pageContext.request.contextPath}/login">CANCEL</a>
        </form>
    </div>
</div>
</body>
</html>
