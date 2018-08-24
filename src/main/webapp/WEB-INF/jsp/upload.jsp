<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *,
        *:before,
        *:after {
            box-sizing: border-box;
            outline: none;
        }

        html {
            font-size: 100%;
        }

        body {
            font-family: 'Open Sans', sans-serif;
            font-size: 1rem;
            margin: 0;
        }

        .body-wrapper {
            display: flex;
            flex-direction: column;
        }

        .body-page {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            flex: 1 1 auto;
        }
        .body-page > header,
        .body-page > footer {
            color: white;
            background: #333;
            width: 100%;
            text-align: center;
            padding: 10px;
            text-transform: uppercase;
            width: 100%;
        }

        main {
            text-align: center;
            flex: 1 1 auto;
            display: flex;
            justify-content: space-around;
            align-items: center;
            flex-direction: column;
            width: 100%;
        }

        .loading h1 {
            width: 100%;
            color: #0078d7;
        }
        .loading .dots {
            position: relative;
            width: 100%;
            -webkit-animation: move-2 3s linear infinite;
            animation: move-2 3s linear infinite;
            -webkit-animation-delay: -400ms;
            animation-delay: -400ms;
        }
        .loading .dot {
            display: inline-block;
            border-radius: 50%;
            width: 1rem;
            height: 1rem;
            background: #0078d7;
            -webkit-animation: move 3s cubic-bezier(0.1, 0.8, 0.9, 0.1) infinite;
            animation: move 3s cubic-bezier(0.1, 0.8, 0.9, 0.1) infinite;
        }
        .loading .dot:nth-of-type(2) {
            -webkit-animation-delay: -100ms;
            animation-delay: -100ms;
        }
        .loading .dot:nth-of-type(3) {
            -webkit-animation-delay: -200ms;
            animation-delay: -200ms;
        }
        .loading .dot:nth-of-type(4) {
            -webkit-animation-delay: -300ms;
            animation-delay: -300ms;
        }
        .loading .dot:nth-of-type(5) {
            -webkit-animation-delay: -400ms;
            animation-delay: -400ms;
        }

        @-webkit-keyframes move {
            0% {
                -webkit-transform: translateX(-10em);
                transform: translateX(-10em);
                opacity: 0;
            }
            10%,
            70% {
                opacity: .9;
            }
            80%,
            100% {
                -webkit-transform: translateX(10em);
                transform: translateX(10em);
                opacity: 0;
            }
        }

        @keyframes move {
            0% {
                -webkit-transform: translateX(-10em);
                transform: translateX(-10em);
                opacity: 0;
            }
            10%,
            70% {
                opacity: .9;
            }
            80%,
            100% {
                -webkit-transform: translateX(10em);
                transform: translateX(10em);
                opacity: 0;
            }
        }
        @-webkit-keyframes move-2 {
            0% {
                -webkit-transform: translateX(4em);
                transform: translateX(4em);
            }
            100% {
                -webkit-transform: translateX(-4em);
                transform: translateX(-4em);
            }
        }
        @keyframes move-2 {
            0% {
                -webkit-transform: translateX(4em);
                transform: translateX(4em);
            }
            100% {
                -webkit-transform: translateX(-4em);
                transform: translateX(-4em);
            }
        }
    </style>
</head>
<body>
<div>
    <c:set var="message" value="${mess}"/>
    <c:if test="${message.length()>0}">
        <div><p><c:out value="${message}"/></p></div>
        <%--<div><c:redirect url="/upload"/></div>--%>
        <div class="body-wrapper">
            <div class="body-page">
                <main>
                    <div class="loading">
                        <h1>Please wait</h1>
                        <div class="dots">
                            <div class="dot"></div>
                            <div class="dot"></div>
                            <div class="dot"></div>
                            <div class="dot"></div>
                            <div class="dot"></div>
                        </div>
                    </div>
                    <div class="content"></div>
                </main>
            </div>
        </div>
    </c:if>
</div>





</body>
</html>
