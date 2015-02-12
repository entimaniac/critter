
<!-- Optional theme -->


<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">--%>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.touchSwipe.min.js"></script>
<script src="/assets/js/critter.js"></script>

<link rel="stylesheet" href="/assets/css/styles.css">


<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">


<script>
    $( document ).ready(function() {
        $('.nav-button').on('touchstart', function(){
        /*    $(this).addClass('mock-hover-nav');
        }).bind('touchend', function(){
            $(this).removeClass('mock-hover-nav');*/
        });

        $('.menu-toggle').on('click', function(){
            $('.menu').slideToggle(200);
            $(this).removeClass('mock-hover-nav');
        });

        $('.group-list-display').on('touchstart', function(){
             $(this).addClass('touch-hover-group-list');
             }).bind('touchend', function(){
             $(this).removeClass('touch-hover-group-list');
        });

    });

</script>