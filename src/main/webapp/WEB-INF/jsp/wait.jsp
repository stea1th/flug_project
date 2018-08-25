
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please Wait</title>
    <style>
        #p_prldr{
            position: fixed;
            left: 0;
            top: 0;
            right:0;
            bottom:0;
            background: #9A12B3;
            z-index: 30;}

        .contpre small{font-size:25px;}

        .contpre{
            width: 250px;
            height: 100px;
            position: absolute;
            left: 50%;top: 48%;
            margin-left:-125px;
            margin-top:-75px;
            color:#fff;
            font-size:40px;
            letter-spacing:-2px;
            text-align:center;
            line-height:35px;}

        #p_prldr .svg_anm {
            position: absolute;
            width: 41px;
            height: 41px;
            background: url(http://gnatkovsky.com.ua/files/preload/spinning-circles.svg) center center no-repeat;
            background-size:41px;
            margin: -16px 0 0 -16px;}
    </style>
</head>
<body>
<div class="contpre">
    <span class="svg_anm"></span>
    <br>Подождите<br>
    <small>идет загрузка</small>
</div>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script type="text/javascript">
    $(window).on('load', function () {
        var $preloader = $('#page-preloader'),
            $spinner   = $preloader.find('.spinner');
        $spinner.fadeOut();
        $preloader.delay(500).fadeOut('slow');
    });
</script>
</body>
</html>
