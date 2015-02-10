<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.MyGroupsAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>

</head>
<body>
<app:nav-common/>
<div>
    <h1>My Groups</h1>
    <div class="group-list-container">

        <c:forEach var="group" items="${action.userGroups}">

            <a class="group-list-display" href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">${group.name}</a>

        </c:forEach>

    </div>
</div>



</body>
</html>
