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
            <app:creet creet="${creet.creet}" voteStatus="${creet.voteStatus}"/>
        </c:forEach>"
    </c:when>
    <c:otherwise>
        <div align="center">
            <br/>
            <h2>Looking pretty lonely in here!</h2>
            <br/><br/><br/>
            <div style="width: 40%">
                <p><a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}post-creet">POST A CREET</a></p>
                <p><a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}search-group">SEARCH GROUPS</a></p>
                <p><a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}create-group">CREATE A GROUP</a></p>
            </div>
        </div>
    </c:otherwise>
</c:choose>


</body>
</html>
