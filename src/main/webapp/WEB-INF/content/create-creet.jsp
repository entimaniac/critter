<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.CreateCreetAction"--%>

<html>
<head>
    <app:common-head/>
    <title>CRITTER</title>
    <style>
        body {
            margin-top: 40px;
            background-color: #343838;
        }

        .center-block {
            margin-left: auto;
            margin-right: auto;
        }
        .user-form {
            max-width: 300px;
        }

        .title {
            width: 140px;
            margin-bottom: 40px;
        }

    </style>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="center-block title" >
            <h2>POST NEW CREET</h2>
        </div>
    </div>

    <div class="center-block user-form">
        <c:forEach items="${action.fieldErrors}" var="error">
            <span class="text-danger">${error.value}</span><br/>
        </c:forEach>
        <form role="form" action="${pageContext.request.contextPath}/create-creet" method="post">
            <div class="form-group">
                <textarea class="form-control" id="message-field" name="message" type="text" value="${action.message}"></textarea>
            </div>
            <div class="form-group">

                <select name="groupId" class="form-control">
                <c:forEach var="group" items="${sessionScope.userGroups}">
                    <option value="${group.id}"
                            <c:if test="${action.groupId == group.id}">selected="selected" </c:if>
                            >${group.name}</option>
                </c:forEach>

                </select>
            <br/>
            <button type="submit" class="btn btn-primary btn-block btn-lg">SUBMIT</button>
            <a class="btn btn-default btn-block btn-lg" href="${pageContext.request.contextPath}/landing-page">CANCEL</a>

        </form>
    </div>
</div>
</body>
</html>