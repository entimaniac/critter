
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

<h1>${action.group.name}</h1>
<h3>${action.group.twitterHandle}</h3>
<p>
    ${action.group.description}
</p>

<c:forEach var="creet" items="${action.creets}">
    <app:creet creet="${creet}"/>

</c:forEach>




</body>
</html>