$(window).on('load', function () {
    var $preloader = $('#page-preloader'),
        $spinner   = $preloader.find('.spinner');
     // $spinner.fadeOut(3000);
    $preloader.delay(3000).fadeOut('slow');
});
