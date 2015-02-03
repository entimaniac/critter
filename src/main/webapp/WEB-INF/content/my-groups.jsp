<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.MyGroupsAction"--%>

<html>
<head>
    <app:common-head/>
    <title>CRITTER</title>
</head>
<body>
<app:common-nav/>
<div>
    <ul>
        <c:forEach var="group" items="${action.userGroups}">
            <li><a href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">${group.name}</a></li>
        </c:forEach>
    </ul>

</div>



</body>
</html>
