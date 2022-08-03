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
    <p>处理异常, 全局异常处理</p>
    <form action="some.do" method="post">
        姓名 : <input type="text" name="name">      <br>
        年龄 : <input type="text" name="age">       <br>
        <input type="submit" value="注册">       <br>
    </form>
</body>
</html>
