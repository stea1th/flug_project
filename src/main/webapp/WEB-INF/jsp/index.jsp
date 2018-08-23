
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlugProject</title>
</head>
<body>
<h3>Bitte geben Sie eine XLS-Datei:</h3>
<form method="post" action="${pageContext.request.contextPath}">
    <input type="text" name="file" />
    <br/><br/>
    <input type="submit" value="Upload" />
</form>

</body>
</html>
