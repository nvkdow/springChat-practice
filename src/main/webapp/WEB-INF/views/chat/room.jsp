<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>room ${roomKey}</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />" />
</head>
<body>
<jsp:include page="../modules/navbar.jsp" />

<div class="text-center">
    <div>
        <input type="text" id="message_input" />
    </div>
    <div>
        <button type="button" onclick="openSocket();">Open</button>
        <button type="button" onclick="send();">Send</button>
        <button type="button" onclick="closeSocket();">Close</button>
    </div>
    <!-- Server responses get written here -->
    <div id="chat_box"></div>
</div>

<script type="text/javascript">
    var roomKey = "<c:out value="${roomKey}"/>";
</script>
<script type="text/javascript" src="<c:url value="/js/ws-client.js" /> "></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
</body>
</html>