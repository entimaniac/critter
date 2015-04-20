<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.MyGroupsAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>

</head>
<body>
<app:nav-common/>


<img src="${pageContext.request.contextPath}/assets/img/MyGroupsTXT.png">

<c:choose>
    <c:when test="${action.userGroups.size() > 0}">
            <div class="group-list-container">
                <c:forEach var="group" items="${action.userGroups}">
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
            </div>
    </c:when>
    <c:otherwise>
        <p>You are not a part of any groups. Poor you...</p>
        <p><a href="${pageContext.request.contextPath}search-group">Click here to search for groups to join!</a></p>
    </c:otherwise>
</c:choose>


</body>
</html>
