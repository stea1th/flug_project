<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlugProject</title>
</head>
<body>
<h3>Bitte geben Sie eine XLS-Datei:</h3>
<form method="post" action="upload">
    <input type="text" name="text" />
    <br/><br/>
    <input type="submit" value="Upload"/>
</form>

<c:set var="message" value="${mess}"/>
<c:if test="${message.length()>0}">
    <div><p><c:out value="${message}"/></p></div>
</c:if>

</body>
</html>