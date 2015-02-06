<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.CreateGroupAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CREATE A GROUP</title>
</head>
<body>
    <app:nav-back/>


    <h2>CREATE A GROUP</h2>



        <div class="center-block user-form">
            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>

            <form role="form" action="${pageContext.request.contextPath}/create-group" method="post">

                <input id="name-field" name="name" type="text" value="${action.name}" placeholder="NAME">

                <input id="twitter-handle-field" name="twitterHandle" type="text" value="${action.twitterHandle}" placeholder="TWITTER HANDLE">

                <textarea id="description-field" name="description" placeholder="Write a brief description of your group.">${action.description}</textarea>

                <button type="submit" class="btn btn-primary btn-block btn-lg">CREATE GROUP</button>
                <a class="ui-btn ui-shadow ui-btn-corner-all" href="${pageContext.request.contextPath}/login">CANCEL</a>
            </form>
        </div>

</body>
</html>
