<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>show.jsp  从request作用域中获取数据</h1>  <br>
    <h3>mas 数据 : ${param.name}</h3>
    <h3>fun 数据 : <%=request.getParameter("age")%></h3>
</body>
</html>
