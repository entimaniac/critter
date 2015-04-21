var UPVOTED_STATUS = "UPVOTED";
var DOWNVOTED_STATUS = "DOWNVOTED";
var NEUTRAL_STATUS = "NEUTRAL";

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

        //Delete Creet functionality
        creet.find('.delete-creet').click(function () {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/delete-creet",
                data: {creetId: creetId}
            })
                .done(function (msg) {
                    creet.hide('slow');
                });
        });


        //Upvote functionality
        creet.find('.upvote-btn').click(function () {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/upvote",
                data: {creetId: creetId, voteStatus: creet.data('vote-status')}
            })
                .done(function (msg) {
                    //todo: add upvote animation
                    var score = +(creet.find('.creet-score').text());
                    if (creet.data('vote-status') == DOWNVOTED_STATUS) {
                        score++;
                        creet.find('.downvote-btn').removeClass('button-downvoted');
                    }
                    if (creet.data('vote-status') != UPVOTED_STATUS) {
                        score++;
                        creet.find('.upvote-btn').addClass('button-upvoted');
                        creet.data('vote-status', UPVOTED_STATUS);
                    } else {
                        score--;
                        creet.find('.upvote-btn').addClass('upvote-btn');
                        creet.find('.upvote-btn').removeClass('button-upvoted');
                        creet.data('vote-status', NEUTRAL_STATUS);
                    }
                    creet.find('.creet-score').text(score);
                });
        });

        //Downvote functionality
        creet.find('.downvote-btn').click(function () {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/downvote",
                data: {creetId: creetId, voteStatus: creet.data('vote-status')}
            })
                .done(function (msg) {
                    //todo: add downvote animation
                    var score = +(creet.find('.creet-score').text());
                    if (creet.data('vote-status') == UPVOTED_STATUS) {
                        score--;
                        creet.find('.upvote-btn').removeClass('button-upvoted');
                    }
                    if (creet.data('vote-status') != DOWNVOTED_STATUS) {
                        score--;
                        creet.find('.downvote-btn').addClass('button-downvoted');
                        creet.data('vote-status', DOWNVOTED_STATUS);
                    } else {
                        score++;
                        creet.find('.downvote-btn').addClass('downvote-btn');
                        creet.find('.downvote-btn').removeClass('button-downvoted');
                        creet.data('vote-status', NEUTRAL_STATUS);
                    }
                    creet.find('.creet-score').text(score);
                });

        });

})}
