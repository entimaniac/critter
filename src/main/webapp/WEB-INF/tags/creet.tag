<%@ attribute name="creet" required="true" type="com.russ4stall.critter.core.Creet" %>


<div id="${creet.id}" class="creet creet-container">
    <div class="score-container">
        <div class="upvote-btn">
            <img src="${pageContext.request.contextPath}/assets/img/up-arrow-16.png">
        </div>
        <div class="creet-score">${creet.score}</div>
        <div class="downvote-btn">
            <img src="${pageContext.request.contextPath}/assets/img/down-arrow-16.png">
        </div>
    </div>
    <div class="creet-header">
        <div class="creet-timestamp">${creet.timestamp}</div>
        <div class="creet-author">${creet.author.name}</div>
    </div>
    <div class="creet-message">
        ${creet.message}
    </div>

</div>