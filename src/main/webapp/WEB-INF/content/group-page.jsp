<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.GroupPageAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
    <script type="text/javascript">
        $(document).ready(function() {
            initCreet();
        });
    </script>
</head>
<body>
<app:nav-common/>

<h1>${action.group.name}</h1>

<c:if test="${action.group.owner == sessionScope.get('user').id}">
    <div class="edit-group-settings-button">
        <a href="${pageContext.request.contextPath}/create-group?groupId=${action.group.id}&isEdit=True">
            <img src="${pageContext.request.contextPath}/assets/img/settings-32.png"><span>Settings</span>
        </a>
    </div>
    <div class="edit-group-settings-button">
        <a href="${pageContext.request.contextPath}/delete-group?groupId=${action.group.id}&name=${action.group.name}">
            <img src="${pageContext.request.contextPath}/assets/img/trash-delete-32.png"><span>Delete Group</span>
        </a>
    </div>
    <a class="btn btn-block btn-primary" target="_blank" href="${pageContext.request.contextPath}/request-twitter-authorization?groupId=${group.id}">LINK TO TWITTER</a>
</c:if>

<c:if test="${action.group.owner != sessionScope.get('user').id}">
    <div class="leave-group-btn btn">
        <a href="${pageContext.request.contextPath}/leave-group?groupId=${action.group.id}&isEdit=True">
            Leave group
        </a>
    </div>
</c:if>

<h3>${action.group.twitterHandle}</h3>
<p>
    ${action.group.description}
</p>


<c:choose>
    <c:when test="${action.groupMember}">
        <c:forEach var="creet" items="${action.creets}">
            <app:creet creet="${creet.creet}" voteStatus="${creet.voteStatus}"/>
        </c:forEach>
    </c:when>

    <c:otherwise>
        <a class="btn btn-block btn-primary" href="${pageContext.request.contextPath}/join-group?groupId=${group.id}">JOIN THIS GROUP</a>
    </c:otherwise>
</c:choose>

</body>
</html>