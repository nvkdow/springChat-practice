<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>chat begin</title>
</head>
<body>
<jsp:include page="../modules/navbar.jsp" />

<div>
    <span>Your Chat Room is</span>
    <input type="text" value="${roomKey}" disabled />
    <a href="<c:url value="/chat/${roomKey}" />">enter</a>
</div>
</body>
</html>