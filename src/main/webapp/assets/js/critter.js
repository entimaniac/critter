function initCreet() {

    $("abbr.timeago").timeago();


    $(".creet").each(function () {
        var creet = $(this);
        var creetId = creet.data('creetId');

        //Upvote functionality
        creet.find('.upvote-btn').click(function() {
            if (creet.data('vote-status') != 'upvoted') {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/upvote",
                    data: {creetId: creetId}
                })
                    .done(function (msg) {
                        //todo: add upvote animation
                        var score = +(creet.find('.creet-score').text());
                        score++;
                        creet.find('.creet-score').text(score);
                        creet.data('vote-status', 'upvoted');
                        creet.find('.upvote-btn').addClass('button-upvoted');
                        creet.find('.downvote-btn').removeClass('button-downvoted');

                    });
            } else {
                alert("You've already upvoted this creet!");
            }
        });

        //Downvote functionality
        creet.find('.downvote-btn').click(function() {
            if (creet.data('vote-status') != 'downvoted') {
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
                        creet.data('vote-status', 'downvoted');
                        creet.find('.downvote-btn').addClass('button-downvoted');
                        creet.find('.upvote-btn').removeClass('button-upvoted');
                    });
            } else {
                alert("You've already downvoted this creet!");
            }
        });

    });
}