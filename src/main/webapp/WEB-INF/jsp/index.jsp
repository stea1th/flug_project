<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlugProject</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/preloader.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/preloader.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/postrequest.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/loader.js"></script>
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
<br>
<br>
<br>
<form class="form-inline" id="customerForm" >
    <div class="form-group">
    <label>
        <input type="text" class="form-control" id="filename" required />
        <div class="label-text">Bitte geben Sie eine XLS-Datei ein</div>
    </label>
    </div>
    <button type="submit" class="btn" id="btn">Submit</button>
</form>
<br>
<br>
<div id="postResultDiv"></div>
<br>
<br>
</body>
</html>