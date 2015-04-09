<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.DeleteGroupAction"--%>

<html>
<head>
    <app:head-common/>
    <title>DELETE A GROUP</title>
</head>
<body>
<app:nav-back title="Delete a Group"/>

<div class="center-block user-form">
    <c:forEach items="${action.fieldErrors}" var="error">
        <span class="text-danger">${error.value}</span><br/>
    </c:forEach>

    <form role="form" action="${pageContext.request.contextPath}/delete-group" method="post">
        <h2 class="">Are you sure?</h2>
        <input type="hidden" name="groupId" value="${action.groupId}">
        <button type="submit" class="btn btn-primary btn-block">DELETE GROUP</button>
        <a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/login">CANCEL</a>
    </form>
</div>

</body>
</html>
