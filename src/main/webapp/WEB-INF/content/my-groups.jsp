<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.MyGroupsAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
    <style>
        .group-list-display {
            display: block;
            border-bottom:1px solid lightgray;
            padding: 10px;
            text-decoration: none;
        }

        .group-list-display:hover {
            background-color: lightblue;

        }
    </style>
</head>
<body>
<app:nav-common/>
<div>
    <a href="${pageContext.request.contextPath}/search-group">Join A Group</a>
    <br/>
    <a href="${pageContext.request.contextPath}/create-group">Create A Group</a>

    <h3>My Groups</h3>
        <c:forEach var="group" items="${action.userGroups}">

            <a class="group-list-display" href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">${group.name}</a>

        </c:forEach>


</div>



</body>
</html>
