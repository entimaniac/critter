<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>



<%--@elvariable id="action" type="com.russ4stall.critter.actions.ChangePasswordAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
</head>
<body>
<app:nav-back title="CHANGE PASSWORD"/>

<br>
            <div class="center-block user-form">
                <c:forEach items="${action.fieldErrors}" var="error">
                    <span class="text-danger">${error.value}</span><br/>
                </c:forEach>
                <form role="form" action="${pageContext.request.contextPath}/change-password" method="post">
                    <div class="form-group">
                        <input class="form-control" maxlength="65" name="password" type="password" placeholder="CURRENT PASSWORD">
                    </div>
                    <div class="form-group">
                        <input class="form-control" maxlength="65" name="newPassword" type="password" placeholder="NEW PASSWORD">
                    </div>
                    <div class="form-group">
                        <input class="form-control" maxlength="65" name="confirmNewPassword" type="password" placeholder="CONFIRM NEW PASSWORD">
                    </div>
                    <br/>
                    <button class=" btn btn-primary btn-block" type="submit">SUBMIT</button>

                </form>
            </div>

</body>
</html>
