<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.PostCreetAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
</head>
<body>
    <app:nav-back title="POST"/>

        <div class="center-block user-form">
            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>
            <form role="form" action="${pageContext.request.contextPath}/post-creet" method="post">

                <label for="message-field">Message:</label>
                <textarea class="form-control" id="message-field" name="message" type="text" value="${action.message}"></textarea>
                <label for="group-field">Post in group:</label>
                <select id="group-field" name="groupId" class="form-control">
                    <c:forEach var="group" items="${action.userGroups}">
                        <option value="${group.id}"
                                <c:if test="${action.groupId == group.id}">selected="selected" </c:if>
                                >${group.name}</option>
                    </c:forEach>

                </select>
                <br/>
                <button class=" btn btn-primary btn-block" type="submit">SUBMIT</button>

            </form>
</body>
</html>