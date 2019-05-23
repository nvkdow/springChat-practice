<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>board</title>
    <style>
        table {
            width: 70%;
            margin-left: 15%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
        }
        thead, td {
            border-bottom: 1px solid #444444;
            padding: 10px;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">board list</h2>
<div id="nav" style="text-align: center;">
    <a href="<c:url value="/logout"/> ">logout</a>
    <a href="<c:url value="/board/write"/> ">post new article</a>
</div>
<div id="board">
    <table style="width:70%">
        <thead><tr><td>id</td><td>title</td><td>author</td><td>date</td></tr></thead>
        <c:forEach items="${articleList}" var="article">
            <tr><td>${article.articleid}</td><td>${article.title}</td><td>${article.author}</td><td>${article.created}</td></tr>
        </c:forEach>
    </table>
</div>
<div id="pagination" style="text-align: center;">
    <c:forEach begin="1" end="${articleNum + 1}" var="page">
        <a href="<c:url value="/board/list/${page}"/> ">${page}</a>
    </c:forEach>
</div>
</body>
</html>
