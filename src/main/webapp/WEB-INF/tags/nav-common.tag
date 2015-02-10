
<nav class="nav mobile-nav-top">
    <ul>
        <li>
            <a class="nav-button"  href="${pageContext.request.contextPath}/landing-page">
                <img src="/assets/img/home-32.png" height="16" width="16">
                <br/>
                <span>HOME</span>
            </a>
        </li>
        <li>
            <a class="nav-button" href="${pageContext.request.contextPath}/my-groups">
                <img src="/assets/img/group-32.png" height="16" width="16">
                <br/>
                <span>GROUPS</span>
            </a>
        </li>
        <li>
            <a class="nav-button" data-ftrans="slide" href="${pageContext.request.contextPath}/post-creet?groupId=${group.id}">
                <img src="/assets/img/post-32.png" height="16" width="16">
                <br/>
                <span>POST</span>
            </a>
        </li>
        <li>
            <a href="#" class="menu-toggle">
                <img src="/assets/img/menu-bars-32.png" height="16" width="16">
                <br/>
                <span>MENU</span>
            </a>
        </li>
    </ul>
</nav>
<div class="menu" style="display:none">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/search-group">Join A Group</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/create-group">Create A Group</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout">LOG OUT</a>
        </li>
    </ul>
</div>

<br/>
