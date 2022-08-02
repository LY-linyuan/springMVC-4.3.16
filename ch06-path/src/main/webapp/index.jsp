<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
                    request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath() +"/";
%>
<html>
<head>
    <%--<base href="http://127.0.0.1:8080/ch06_path/">--%>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    <p>打一个springmvc项目</p>
    <p><a href="user/first.do">user/first.do</a></p><br>
    <p><a href="/user/first.do">/user/first.do</a></p><br>
    <p><a href="/ch06_path/user/first.do">/ch06_path/user/first.do</a></p><br>
    <p><a href="${pageContext.request.contextPath}/user/first.do">${pageContext.request.contextPath}/user/first.do</a></p><br>
</body>
</html>
