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
    <c:forEach var="creet" items="${action.creets}">
        <app:creet creet="${creet}"/>
    </c:forEach>



</body>
</html>
