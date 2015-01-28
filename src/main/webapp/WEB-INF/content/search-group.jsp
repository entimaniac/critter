<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.SearchGroupAction"--%>

<html>
<head>
    <app:common-head/>
    <title>CRITTER</title>
</head>
<body>
<app:common-nav/>

<div class="container">
    <div class="row">
        <div class="center-block title" >
            <h2>SEARCH FOR A GROUP</h2>
        </div>
    </div>

    <div class="center-block user-form">

        <form role="form" action="${pageContext.request.contextPath}/search-group" method="post">
            <div class="form-group">
                <input class="form-control" id="searchTerm-field" name="searchTerm" type="text" value="${action.searchTerm}" placeholder="search for a group">
            </div>
            <button type="submit" class="btn btn-primary btn-block btn-lg">SEARCH</button>
        </form>

    </div>
    <div id="groups-list">
        <c:forEach var="group" items="${action.groups}">
            <div class="group-description">
                <a href="/join-group?groupId=${group.id}">${group.name}</a>
            </div>
        </c:forEach>


    </div>

</div>
</body>


</body>
</html>