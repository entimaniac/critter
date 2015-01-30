
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.GroupPageAction"--%>

<html>
<head>
    <app:common-head/>
    <title>CRITTER</title>
</head>
<body>
<app:common-nav/>
<div>
    <%--<img src="https://scontent-a-mia.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/10641016_1487560258161099_2969431546394646204_n.jpg?oh=bf4d34a275f1983197c9df96f7c4be9d&oe=5510E236" height="60%" width="100%"/>--%>
</div>

<h1>${action.group.name}</h1>

<a href="${pageContext.request.contextPath}/create-creet?groupId=${group.id}">Post a creet</a>

<c:forEach var="creet" items="${action.creets}">
    <div class="creet">
        ${creet.timestamp}<br/>
        ${creet.message}

    </div>

</c:forEach>

</body>
</html>