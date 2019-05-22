<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
    <div id="img-logo">
        <img src="<c:url value="/images/logo.png"/>" alt="logo" style="
                display: block;
                margin: 15% auto 5% auto;
                height: 25%;" />
    </div>
    <div id="field-access">
        <div id="field-access-chat" style="text-align: center;">
            <form action="<c:url value="/chat/begin"/>">
                <button type="submit" value="chat" style="padding:10px 50px;" >chat</button>
            </form>
        </div>
        <div id="field-access-login" style="text-align: center">
            <form action="<c:url value="/login"/>">
                <button type="submit" value="login" style="padding:10px 50px;" >login</button>
            </form>
        </div>
    </div>
</body>
</html>