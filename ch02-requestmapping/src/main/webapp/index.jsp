<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>打一个springmvc项目</p>
    <p><a href="test/some.do">发起一个some.do的请求 get</a></p>
    <br>
    <form action="test/other.do" method="post">
        <input type="text" name="name"><br>
        <input type="submit" value="post请求  other.do">
    </form>
    <br>
    <form action="test/first.do" method="post">
        <input type="text" name="name"><br>
        <input type="submit" value="post请求  first.do">
    </form>
    <br>
    <p><a href="test/first.do">first.do的请求</a></p>

</body>
</html>
