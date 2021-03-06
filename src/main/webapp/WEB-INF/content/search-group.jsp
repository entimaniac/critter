<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.SearchGroupAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
</head>
<body>

<app:nav-back title="<img src='${pageContext.request.contextPath}/assets/img/GroupSearchTxt.png'>"/>


    <div class="center-block user-form">

        <form role="form" action="${pageContext.request.contextPath}/search-group" method="post">
            <div class="form-group">
                <input class="form-control" id="searchTerm-field" maxlength="120" name="searchTerm" type="search" value="${action.searchTerm}" placeholder="search for a group">
            </div>
            <button type="submit" class="btn btn-primary btn-block btn-lg">SEARCH</button>
        </form>

    </div>
    <div id="groups-list">
    <c:choose>
        <c:when test="${ !empty(action.groups) }">
            <c:forEach var="group" items="${action.groups}">
                <div class="group-list-display">
                    <a class="group-list-display-name" href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">
                            ${group.name}
                        <c:if test="${group.owner == sessionScope.get('user').id}">
                            <span class="group-list-display-owner">
                                owner
                                <img src="${pageContext.request.contextPath}/assets/img/32blue.png">
                            </span>
                        </c:if>
                    </a>
                </div>
            </c:forEach>
        </c:when>
        <c:when test="${ empty(action.groups) && !empty(action.searchTerm)}">
            <div class="group-list-display">
                <p align="center" class="group-list-display-name">Search returned no groups!</p>
                <img src="">
            </div>
        </c:when>
    </c:choose>
</div>
</body>
</html>