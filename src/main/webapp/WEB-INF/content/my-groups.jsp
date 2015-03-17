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

<h1>My Groups</h1>
<div class="group-list-container">
    <c:forEach var="group" items="${action.userGroups}">
        <div class="group-list-display">
            <a class="group-list-display-name" href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">
                ${group.name}
                <c:if test="${group.owner == sessionScope.get('user').id}">
                    <span class="group-list-display-owner">owner</span>
                </c:if>
            </a>

        </div>

    </c:forEach>

</div>




</body>
</html>
