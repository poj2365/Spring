<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<html>
<head>
    <title>에러페이지</title>
</head>
<body>
    <h2>NullPointerException발생</h2>
    <h3><%=exception.getMessage()%></h3>
    <h4>
        <a href="${pageContext.request.contextPath}">
            메인화면으로...
        </a>
    </h4>
</body>
</html>
