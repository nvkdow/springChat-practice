<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new article</title>
</head>
<body>
<h2 style="text-align: center">write new article</h2>
<div style="text-align: center">
    <form action="<c:url value="/board/write"/>" method="post">
        <div>
            <label><input type="text" name="title" placeholder="Input Title..." style="height: 50px; width: 500px"></label>
        </div>
        <div>
            <label><input type="text" name="content" placeholder="Input Contents..." style="height: 600px; width: 500px"/></label>
        </div>
        <button type="submit" value="upload" style="padding: 10px 40px;"></button>
    </form>
</div>
</body>
</html>
