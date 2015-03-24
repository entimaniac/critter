<%@ attribute name="creet" required="true" type="com.russ4stall.critter.core.Creet" %>


<div class="creet creet-container" data-creet-id="${creet.id}">
    <div class="score-container" data-creet-id="${creet.id}">
        <div class="upvote-btn">
            <img src="${pageContext.request.contextPath}/assets/img/up-arrow-32.png">
        </div>
        <div class="creet-score">${creet.score}</div>
        <div class="downvote-btn">
            <img src="${pageContext.request.contextPath}/assets/img/down-arrow-32.png">
        </div>
    </div>
    <div>
        <div class="creet-header">
            <div class="creet-timestamp"><abbr class="timeago" title="${creet.timestamp}"></abbr></div>
            <div class="creet-author">${creet.author.name}</div>
        </div>
        <div class="creet-message">
            ${creet.message}
        </div>
    </div>
</div>
