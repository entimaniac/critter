function initCreet() {

    $("abbr.timeago").timeago();

    $(".creet").each(function () {
        var creet = $(this);
        var creetId = creet.data('creetId');
        var creetDetails = $('.creet-details[data-creet-id="'+ creetId + '"]');


        creet.click(function(){
           // alert('test');
           //$('.creet-details[data-creet-id="'+ creetId + '"]').slideToggle(400);
           creetDetails.slideToggle(150);
        });
        //Upvote functionality
        creetDetails.find('.upvote-btn').click(function() {
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
        creetDetails.find('.downvote-btn').click(function() {
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