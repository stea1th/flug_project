$body = $("body");

$(document).ajaxStart(function(){
    event.preventDefault();
    $('#page-preloader').fadeIn('slow');
}).ajaxStop(function(){
    $('#page-preloader').fadeOut('slow');
});




