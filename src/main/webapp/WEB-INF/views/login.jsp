<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div id="img-logo">
        <img src="<c:url value="/images/logo.png"/>" alt="logo" style="
                display: block;
                margin: 15% auto 5% auto;
                height: 25%;" />
    </div>
    <div id="field-access">
        <div id="field-access-login" style="text-align: center;">
            <form action="<c:url value="/login"/>" method="post">
                <label><input type="text" name="username" placeholder="user-id"/></label><br/>
                <label><input type="password" name="password" placeholder="password"/></label><br/>
                <button type="submit" value="login" style="
                        height: 20px;
                        width: 60px;
                        margin: 5px;"></button>
            </form>
        </div>
        <div id="field-access-register" style="text-align: center">
            <a href="<c:url value="/register"/>">register</a>
        </div>
    </div>
</body>
</html>
