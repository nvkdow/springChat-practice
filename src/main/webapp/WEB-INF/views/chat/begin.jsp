<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>chat begin</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />" />
</head>
<body>
<jsp:include page="../modules/navbar.jsp" />

<div class="text-center">
    <span>Your Chat Room is</span>
    <input type="text" value="${roomKey}" disabled />
    <a href="<c:url value="/chat/room-${roomKey}" />">enter</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
</body>
</html>