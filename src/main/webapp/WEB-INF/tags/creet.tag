<%@ attribute name="creet" required="true" type="com.russ4stall.critter.core.Creet" %>


<div class="creet creet-container" data-creet-id="${creet.id}">
    <div class="score-container">

        <div class="creet-score">${creet.score}</div>

    </div>
    <div class="creet-header">
        <div class="creet-timestamp">${creet.timestamp}</div>
        <div class="creet-author">${creet.author.name}</div>
    </div>
    <div class="creet-message">
        ${creet.message}
    </div>
</div>

<div class="creet-details" data-creet-id="${creet.id}" style="display: none">
    <div class="upvote-btn">
        <img src="${pageContext.request.contextPath}/assets/img/up-arrow-64.png">
    </div>
    <div class="downvote-btn">
        <img src="${pageContext.request.contextPath}/assets/img/down-arrow-64.png">
    </div>
</div>