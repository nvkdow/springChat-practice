<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>room ${roomKey}</title>
</head>
<body>
<jsp:include page="../modules/navbar.jsp" />

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

<script type="text/javascript">
    var roomKey = "<c:out value="${roomKey}"/>";
</script>
<script type="text/javascript" src="<c:url value="/js/ws-client.js" /> "></script>
</body>
</html>