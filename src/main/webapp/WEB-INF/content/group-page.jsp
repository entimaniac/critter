
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="action" type="com.russ4stall.critter.actions.GroupPageAction"--%>

<html>
<head>
    <app:head-common/>
    <title>CRITTER</title>
</head>
<body>
<app:nav-common/>

<h1 style="color: cyan">${action.group.name}</h1>
<h3>${action.group.twitterHandle}</h3>
<p>
    ${action.group.description}
</p>

<c:forEach var="creet" items="${action.creets}">
    <app:creet creet="${creet}"/>

</c:forEach>


<script type="text/javascript">
    function initCreet() {

        $(".creet").each(function () {
            var creet = $(this);
            var creetId = creet.attr('id');
            creet.on("swipeleft",function(){
                alert("lefty loosey");
            });
            creet.on("swiperight",function(){
                alert("righty tighty");
            });
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

    $(document).ready(function() {
        initCreet();



    });



</script>

</body>
</html>