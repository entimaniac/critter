function initCreet() {

    $("abbr.timeago").timeago();

    $(".creet").each(function () {
        var creet = $(this);
        var creetId = creet.data('creetId');

        //Upvote functionality
        creet.find('.upvote-btn').click(function() {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/upvote",
                data: { creetId: creetId}
            })
                .done(function( msg ) {
                    //todo: add upvote animation
                    var score = +(creet.find('.creet-score').text());
                    score++;
                    creet.find('.creet-score').text(score);
                });
        });

        //Downvote functionality
        creet.find('.downvote-btn').click(function() {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/downvote",
                data: { creetId: creetId}
            })
                .done(function( msg ) {
                    //todo: add downvote animation
                    var score = +(creet.find('.creet-score').text());
                    score--;
                    creet.find('.creet-score').text(score);
                });
        });

    });
}