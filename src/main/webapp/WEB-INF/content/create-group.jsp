<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.CreateGroupAction"--%>

<html>
<head>
    <app:common-head/>
    <title>CREATE A GROUP</title>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="center-block title" >
                <h2>CREATE A GROUP</h2>
            </div>
        </div>

        <div class="center-block user-form">
            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>

            <form role="form" action="${pageContext.request.contextPath}/create-group" method="post">
                <div class="form-group">
                    <input class="form-control" id="name-field" name="name" type="text" value="${action.name}" placeholder="NAME">
                </div>
                <div class="form-group">
                    <input class="form-control" id="twitter-handle-field" name="twitterHandle" type="text" value="${action.twitterHandle}" placeholder="TWITTER HANDLE">
                </div>
                <button type="submit" class="btn btn-primary btn-block btn-lg">CREATE GROUP</button>
                <a class="btn btn-default btn-block btn-lg" href="${pageContext.request.contextPath}/login">CANCEL</a>
            </form>
        </div>
    </div>
</body>
</html>
