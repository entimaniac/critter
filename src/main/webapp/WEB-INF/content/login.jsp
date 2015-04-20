<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.LoginAction"--%>

<html>
<head>
    <app:head-common/>
    <title>LOGIN</title>

</head>
<body>
<div>

       <p style="text-align: center; display: block">
           <img src="${pageContext.request.contextPath}/assets/img/critterTXTsqrl.png">
       </p>

        <br/>

        <div class="center-block user-form">
            <c:forEach items="${action.fieldErrors}" var="error">
                <span class="text-danger">${error.value}</span><br/>
            </c:forEach>
            <form role="form" action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <input class="form-control" id="email-field" name="email" maxlength="45" type="email" value="${action.email}" placeholder="EMAIL">
                </div>
                <div class="form-group">
                    <input class="form-control" id="password-field" maxlength="65" name="password" type="password" placeholder="PASSWORD">
                </div>
                <div style="display: inline">
                    <button class="btn btn-block btn-primary" type="submit">SIGN IN</button>
                    <a class="btn btn-block btn-primary" href="${pageContext.request.contextPath}/register">CREATE AN ACCOUNT</a>
                </div>
            </form>
        </div>

</div>
</body>
</html>
