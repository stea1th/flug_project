<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlugProject</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/preloader.css">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(window).on('load', function () {
            var $preloader = $('#page-preloader'),
                $spinner   = $preloader.find('.spinner');
            // $spinner.fadeOut(5000);
            $preloader.delay(3000).fadeOut('slow');
        });
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<div id="page-preloader">
    <div class="contpre">
        <span class="spinner"></span>
        <br>Bitte<br>
        <small>warten Sie...</small>
    </div>
</div>
<form method="post" action="upload">
    <label>
        <input type="text" name="text" required />
        <div class="label-text">Bitte geben Sie eine XLS-Datei ein</div>
    </label>
    <button type="submit">Submit</button>
</form>
<br>
<br>
<form>
    <div><c:set var="message" value="${mess}"/></div>
    <div class="text"><c:if test="${message.length()>0}">
        <div><p><c:out value="${message}"/></p></div>
    </c:if>
    </div>
</form>
<br>
<br>
</body>
</html>