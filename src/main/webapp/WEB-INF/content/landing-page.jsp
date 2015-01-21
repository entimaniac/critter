<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="/assets/css/styles.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <title>CRITTER</title>

</head>
<body>
<app:common-nav/>
<div>
    <%--<img src="https://scontent-a-mia.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/10641016_1487560258161099_2969431546394646204_n.jpg?oh=bf4d34a275f1983197c9df96f7c4be9d&oe=5510E236" height="60%" width="100%"/>--%>
</div>

<a class="btn btn-default btn-block btn-lg" href="${pageContext.request.contextPath}/logout">LOGOUT</a>

</body>
</html>
