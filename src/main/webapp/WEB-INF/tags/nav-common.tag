
<nav class="nav mobile-nav-top">
    <ul>
        <li>
            <a class="nav-button"  href="${pageContext.request.contextPath}/landing-page">
                <img src="${pageContext.request.contextPath}/assets/img/home-32.png" height="16" width="16">
                <br/>
                <span>HOME</span>
            </a>
        </li>
        <li>
            <a class="nav-button" href="${pageContext.request.contextPath}/my-groups">
                <img src="${pageContext.request.contextPath}/assets/img/group-32.png" height="16" width="16">
                <br/>
                <span>GROUPS</span>
            </a>
        </li>
        <li>
            <a class="nav-button" data-ftrans="slide" href="${pageContext.request.contextPath}/post-creet?groupId=${group.id}">
                <img src="${pageContext.request.contextPath}/assets/img/post-32.png" height="16" width="16">
                <br/>
                <span>POST</span>
            </a>
        </li>
        <li>
            <a href="#" class="menu-toggle">
                <img src="${pageContext.request.contextPath}/assets/img/menu-bars-32.png" height="16" width="16">
                <br/>
                <span>MORE</span>
            </a>
        </li>
    </ul>
</nav>
<div class="menu" style="display:none">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/search-group">Search For A Group</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/create-group">Create A Group</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/change-password">Change Password</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </li>
    </ul>
</div>
