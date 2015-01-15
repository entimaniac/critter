<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--@elvariable id="action" type="com.russ4stall.jorb.actions.RegisterAction"--%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="/assets/css/styles.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

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
            <h2>CRITTER</h2>
        </div>
    </div>

    <div class="center-block user-form">
        <c:forEach items="${action.fieldErrors}" var="error">
            <span class="text-danger">${error.value}</span><br/>
        </c:forEach>
        <form role="form" action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <input class="form-control" id="name-field" name="name" type="text" value="${action.name}" placeholder="NAME">
            </div>
            <div class="form-group">
                <input class="form-control" id="email-field" name="email" type="email" value="${action.email}" placeholder="EMAIL">
            </div>
            <div class="form-group">
                <input class="form-control" id="password-field" name="password" type="password" placeholder="PASSWORD">
            </div>
            <div class="form-group">
                <input class="form-control" id="confirm-password-field" name="confirmPassword" type="password" placeholder="RETYPE PASSWORD">
            </div>
            <button type="submit" class="btn btn-primary btn-block btn-lg">SUBMIT</button>
            <a class="btn btn-default btn-block btn-lg" href="${pageContext.request.contextPath}/login">CANCEL</a>

        </form>
    </div>
</div>
</body>
</html>
