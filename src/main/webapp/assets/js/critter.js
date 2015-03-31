var UPVOTED_STATUS = "UPVOTED"
var DOWNVOTED_STATUS = "DOWNVOTED"

function initCreet() {

    $("abbr.timeago").timeago();


    $(".creet").each(function () {
        var creet = $(this);
        var creetId = creet.data('creetId');

        if (creet.data('vote-status') == UPVOTED_STATUS) {
            creet.find('.upvote-btn').addClass('button-upvoted');
        } else if (creet.data('vote-status') == DOWNVOTED_STATUS) {
            creet.find('.downvote-btn').addClass('button-downvoted');
        }

        //Upvote functionality
        creet.find('.upvote-btn').click(function() {
            if (creet.data('vote-status') != UPVOTED_STATUS) {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/upvote",
                    data: { creetId: creetId, voteStatus: creet.data('vote-status') }
                })
                    .done(function (msg) {
                        //todo: add upvote animation
                        var score = +(creet.find('.creet-score').text());
                        score++;
                        creet.find('.creet-score').text(score);
                        creet.data('vote-status', UPVOTED_STATUS);
                        creet.find('.upvote-btn').addClass('button-upvoted');
                        creet.find('.downvote-btn').removeClass('button-downvoted');

                    });
            } else {
                alert("You've already upvoted this creet!");
            }
        });

        //Downvote functionality
        creet.find('.downvote-btn').click(function() {
            if (creet.data('vote-status') != DOWNVOTED_STATUS) {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/downvote",
                    data: { creetId: creetId, voteStatus: creet.data('vote-status') }
                })
                    .done(function( msg ) {
                        //todo: add downvote animation
                        var score = +(creet.find('.creet-score').text());
                        score--;
                        creet.find('.creet-score').text(score);
                        creet.data('vote-status', DOWNVOTED_STATUS);
                        creet.find('.downvote-btn').addClass('button-downvoted');
                        creet.find('.upvote-btn').removeClass('button-upvoted');
                    });
            } else {
                alert("You've already downvoted this creet!");
            }
        });

    });
}