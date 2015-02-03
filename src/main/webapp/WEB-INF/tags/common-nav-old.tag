<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">critter</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">My Groups<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">

                        <c:forEach var="group" items="${sessionScope.userGroups}">
                            <li><a href="${pageContext.request.contextPath}/group-page?groupId=${group.id}">${group.name}</a></li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/search-group">Join A Group</a></li>
                        <li><a href="${pageContext.request.contextPath}/create-group">Create A Group</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Settings<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>

                </li>
                <li>
                    <a href="#" role="button">My Account</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/logout" role="button">LOGOUT</a>
                </li>


            </ul>
        </div>
    </div>
</nav>
