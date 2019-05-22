<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <div id="img-logo">
        <img src="<c:url value="/images/logo.png"/>" alt="logo" style="
                display: block;
                margin: 15% auto 5% auto;
                height: 25%;" />
    </div>
    <div id="registerUser" style="text-align: center;">
        <form action="<c:url value="/register"/>" method="post">
            <label><input type="text" name="username" placeholder="user-id"/></label><br/>
            <label><input type="password" name="password" placeholder="password"/></label><br/>
            <label><input type="email" name="usermail" placeholder="user-email"/></label><br/>
            <button type="submit" value="register" style="
                    height: 20px;
                    width: 60px;
                    margin: 5px;">register</button>
        </form>
    </div>
</body>
</html>
