<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>提交参数给Controller</p>
    <br>
    <form action="receiveparam/first.do" method="post">
        姓名 <input type="text" name="name"><br>
        年龄 <input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <br>
    <p>请求中处理器方法和形参名不一样</p> <br>
    <form action="receiveparam1.do" method="post">
        姓名 <input type="text" name="rname"><br>
        年龄 <input type="text" name="rage"><br>
        <input type="submit" value="提交参数">
    </form>

    <br>
    <p>请求中使用java对象来接收请求参数</p> <br>
    <form action="receiveObject.do" method="post">
        姓名 <input type="text" name="name"><br>
        年龄 <input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

</body>
</html>
