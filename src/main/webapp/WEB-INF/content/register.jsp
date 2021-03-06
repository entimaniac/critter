<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.RegisterAction"--%>

<html>
<head>
    <app:head-common/>
    <title>REGISTER</title>
</head>
<body>

<div class="container">
    <div class="row">
        <p style="text-align: center; display: block">
            <img src="${pageContext.request.contextPath}/assets/img/critterTXTsqrl.png">
        </p>
        <br/>
    </div>

    <div class="center-block user-form">
        <c:forEach items="${action.fieldErrors}" var="error">
            <span class="text-danger">${error.value}</span><br/>
        </c:forEach>
        <form role="form" action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <input id="name-field" class="form-control"  name="name" maxlength="45" type="text" value="${action.name}" placeholder="NAME">
            </div>
            <div class="form-group">
                <input id="email-field" class="form-control" name="email" maxlength="45" type="email" value="${action.email}" placeholder="EMAIL">
            </div>
            <div class="form-group">
                <input id="password-field" class="form-control" name="password" maxlength="20" type="password" placeholder="PASSWORD">
            </div>
            <div class="form-group">
                <input id="confirm-password-field" class="form-control" name="confirmPassword" maxlength="20" type="password" placeholder="RETYPE PASSWORD">
            </div>

            <button type="submit" class="btn btn-block btn-primary">SUBMIT</button>
            <a class="btn btn-block btn-primary" href="${pageContext.request.contextPath}/login">CANCEL</a>
        </form>
    </div>
</div>
</body>
</html>
