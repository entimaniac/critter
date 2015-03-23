<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.LandingPageAction"--%>

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
<c:choose>
    <c:when test="${action.creets.size() > 0}">
        <c:forEach var="creet" items="${action.creets}">
            <app:creet creet="${creet}"/>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Either you are not a part of any groups, or nobody in your groups have posted any Creets.</p>
        <p><a href="${pageContext.request.contextPath}post-creet">Click here to post a Creet!</a></p>
        <p><a href="${pageContext.request.contextPath}search-group">Click here to search for groups to join!</a></p>
    </c:otherwise>
</c:choose>


</body>
</html>
