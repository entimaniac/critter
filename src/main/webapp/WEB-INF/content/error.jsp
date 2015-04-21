<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <app:head-common/>
    <title>ERROR</title>
</head>
<body>
    <div class="container">
        <div class="center-block">
            <h2>OH NO!</h2>
            <img src="${pageContext.request.contextPath}/assets/img/180blue.png">
            <p>You have reached this page because something exploded!.</p>
            <a class="btn btn-block btn-primary" href="${pageContext.request.contextPath}/landing-page">CLICK HERE TO RETURN</a>
        </div>
    </div>
</body>
</html>
