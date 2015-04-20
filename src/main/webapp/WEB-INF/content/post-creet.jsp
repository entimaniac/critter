<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>



<%--@elvariable id="action" type="com.russ4stall.critter.actions.PostCreetAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>

    <script>
        function getCharCount() {
            var count = $('#message-field').val().length;
            var remaining = 120 - count;
            $('#chars-left').html(remaining + " characters remaining");
        }

        $( document ).ready(function() {
            $("#message-field").keyup(function() {
                getCharCount();
            });
        });
    </script>
</head>
<body>
    <app:nav-back title="<img src='${pageContext.request.contextPath}/assets/img/PostTXT.png'>"/>

    <c:choose>
        <c:when test="${action.userGroups.size() > 0}">
            <div class="group-list-container">

                    <div class="center-block user-form">
                        <c:forEach items="${action.fieldErrors}" var="error">
                            <span class="text-danger">${error.value}</span><br/>
                        </c:forEach>
                        <form role="form" action="${pageContext.request.contextPath}/post-creet" method="post">

                            <label for="message-field">Message:</label>
                            <textarea class="form-control" id="message-field" name="message" maxlength="120" type="text" value="${action.message}"></textarea>
                            <span id="chars-left">120 characters remaining</span>
                            <br>
                            <label for="group-field">Post in group:</label>
                            <select id="group-field" name="groupId" class="form-control">
                                <c:forEach var="group" items="${action.userGroups}">
                                    <option value="${group.id}"
                                            <c:if test="${action.groupId == group.id}">selected="selected" </c:if>
                                            >${group.name}</option>
                                </c:forEach>

                            </select>
                            <br/>
                            <button class=" btn btn-primary btn-block" type="submit">SUBMIT</button>

                        </form>
                    </div>


            </div>
        </c:when>
        <c:otherwise>
            <p>You are not a part of any groups. Poor you...</p>
            <p><a href="${pageContext.request.contextPath}search-group">Click here to search for groups to join!</a></p>
        </c:otherwise>
    </c:choose>

</body>
</html>
