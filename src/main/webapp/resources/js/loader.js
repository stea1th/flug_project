$body = $("body");

$(document).ajaxStart(function(){
    event.preventDefault();
    $('#page-preloader').show();
}).ajaxStop(function(){
    $('#page-preloader').fadeOut('slow');
});




