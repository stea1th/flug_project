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
<div class="modal"><!-- Place at bottom of page --></div>
<%--<div id="loading"></div>--%>
<div id="loading" hidden>
    <p><img src="http://i.stack.imgur.com/FhHRx.gif" />Please Wait</p>
</div>

<div id="page-preloader">
    <div class="contpre">
        <span class="spinner"></span>
        <br>Bitte<br>
        <small>warten Sie...</small>
    </div>
</div>
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
<%--<form>--%>
    <%--<div><c:set var="message" value="${mess}"/></div>--%>
    <%--<div class="text"><c:if test="${message.length()>0}">--%>
        <%--<div><p><c:out value="${message}"/></p></div>--%>
    <%--</c:if>--%>
    <%--</div>--%>
<%--</form>--%>
<br>
<br>
<div id="test1"></div>
</body>
</html>