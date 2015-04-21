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

    <c:if test="${action.group.owner == sessionScope.get('user').id}">
        <div>
            <h1>
                ${action.group.name}

                <a style='float: right' href="${pageContext.request.contextPath}/group-settings?groupId=${action.group.id}">
                    <img src="${pageContext.request.contextPath}/assets/img/settings-32.png">
                </a>
             </h1>
        </div>

        <c:if test="${false == true}">
            <a class="btn btn-block btn-primary" target="_blank" href="${pageContext.request.contextPath}/request-twitter-authorization?groupId=${action.group.id}">LINK TO TWITTER</a>
        </c:if>

    </c:if>

    <c:if test="${action.group.owner != sessionScope.get('user').id}">
        <div>
            <h1>
            ${action.group.name}
                <c:if test="${action.groupMember}">
                    <a style='float: right;' href="${pageContext.request.contextPath}/leave-group?groupId=${action.group.id}&isEdit=True">
                        <img src="${pageContext.request.contextPath}/assets/img/leave-group.png">
                    </a>
                </c:if>
            </h1>
        </div>
    </c:if>

    <h3>
        <a href="http://twitter.com/${action.group.twitterHandle}">
            @${action.group.twitterHandle}
            <c:if test="${action.linkedToTwitter}">
                <img src="${pageContext.request.contextPath}/assets/img/twitter-bird-blue-16x16.png">
            </c:if>
        </a>
    </h3>
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
            <a class="btn btn-block btn-primary" href="${pageContext.request.contextPath}/join-group?groupId=${action.group.id}">JOIN THIS GROUP</a>
        </c:otherwise>
    </c:choose>

</body>
</html>