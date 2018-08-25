<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlugProject</title>
    <style>
        body {
            background-color: #333333;
            font-family: "Open Sans", Helvetica, serif;
        }

        form {
            text-align: center;
        }

        label {
            display: block;
            letter-spacing: 4px;
            padding-top: 30px;
            text-align: center;
        }
        label .label-text, .text{
            color: #9B9B9B;
            cursor: text;
            font-size: 20px;
            line-height: 20px;
            text-transform: uppercase;
            -moz-transform: translateY(-34px);
            -ms-transform: translateY(-34px);
            -webkit-transform: translateY(-34px);
            transform: translateY(-34px);
            transition: all 0.3s;
        }
        label input {
            background-color: transparent;
            border: 0;
            border-bottom: 2px solid #4A4A4A;
            color: white;
            font-size: 28px;
            letter-spacing: -1px;
            outline: 0;
            padding: 5px 20px;
            text-align: center;
            transition: all 0.3s;
            width: 200px;
        }
        label input:focus {
            max-width: 100%;
            width: 400px;
        }
        label input:focus + .label-text {
            color: #F0F0F0;
            font-size: 13px;
            -moz-transform: translateY(-74px);
            -ms-transform: translateY(-74px);
            -webkit-transform: translateY(-74px);
            transform: translateY(-74px);
        }
        label input:valid + .label-text {
            font-size: 13px;
            -moz-transform: translateY(-74px);
            -ms-transform: translateY(-74px);
            -webkit-transform: translateY(-74px);
            transform: translateY(-74px);
        }

        button {
            background-color: #333333;
            border: 2px solid white;
            border-radius: 27px;
            color: white;
            cursor: pointer;
            font-size: 20px;
            margin-top: 20px;
            padding: 15px 30px;
            text-transform: uppercase;
            transition: all 200ms;
        }
        button:hover, button:focus {
            background-color: white;
            color: #333333;
            outline: 0;
        }
    </style>
</head>
<body>
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
</body>
</html>