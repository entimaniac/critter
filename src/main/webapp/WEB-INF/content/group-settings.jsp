<%--
  Created by IntelliJ IDEA.
  User: j.connal.sumlin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.GroupSettingsAction"--%>

<html>
<head>
    <app:head-common/>
    <title>GROUP SETTINGS</title>
</head>
<body>
<app:nav-back title="<img src='${pageContext.request.contextPath}/assets/img/GroupSettingsTXT.png'>"/>
<c:choose>
    <c:when test="${action.group.owner == sessionScope.get('user').id}">
        <div class="center-block user-form" style="padding-top: 10px;">

            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>

            <form role="form" action="${pageContext.request.contextPath}/group-settings?madeChanges=true" method="post">
                <input type="hidden" name="groupId" value="${action.groupId}">
                <div class="form-group">
                    <input class="form-control" id="name-field" name="name" maxlength="45" type="text" value="${action.name}" placeholder="${action.group.name}">
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon">@</span>
                    <input class="form-control" id="twitter-handle-field" name="twitterHandle" maxlength="45" type="text" value="${action.twitterHandle}" placeholder="${action.group.twitterHandle}">
                </div>
                <div class="form-group">
                    <label for="threshold-field">This is the score a creet must achieve before it gets published to Twitter.</label>
                    <input class="form-control" id="threshold-field" name="threshold" type="number" min="0" value="${action.threshold}" placeholder="${action.group.threshold}">
                </div>
                <div class="form-group">
                    <textarea class="form-control" id="description-field" maxlength="500" name="description" placeholder="${action.group.description}">${action.description}</textarea>
                </div>
                <div style="display: inline">
                    <button type="submit" class="btn btn-block btn-primary">SAVE CHANGES</button>

                </div>
            </form>
            <c:choose>
                <c:when test="${!action.linkedToTwitter}">
                    <a class="btn btn-block btn-info" target="_blank"
                       href="${pageContext.request.contextPath}/request-twitter-authorization?groupId=${action.group.id}">
                        LINK TO TWITTER
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-block btn-danger" href="${pageContext.request.contextPath}/unlink-twitter?groupId=${action.group.id}">
                        UNLINK FROM TWITTER
                    </a>
                </c:otherwise>
            </c:choose>
            <a class="btn btn-block btn-danger" href="${pageContext.request.contextPath}/delete-group?name=${action.group.name}&groupId=${action.groupId}">DELETE ${action.group.name}</a>
            <a class="btn btn-block btn-danger" href="${pageContext.request.contextPath}/group-page?groupId=${action.groupId}">CANCEL CHANGES</a>
        </div>
    </c:when >
    <c:otherwise>
        <div class="center-block user-form" align="center">
            <br/>
            <h1>You aren't allowed to be here!</h1>
            <h4>Make like a banana, and split!</h4>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
