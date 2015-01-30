<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 1/30/15
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${action.group.name}

<a href="${pageContext.request.contextPath}/create-creet?groupId=${group.id}">Post a creet</a>
</body>
</html>
