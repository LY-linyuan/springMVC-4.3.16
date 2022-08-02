<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#butten").click(function () {
                // alert("button click");
                $.ajax({
                    // url: "returnVoid-ajax.do",
                    // url: "returnStudentJson.do",
                    // url: "returnStudentJsonArray.do",
                    url: "returnStringData.do",
                    data: {
                        name: "李四",
                        age: 200
                    },
                    type: "post",
                    // dataType: "json",
                    success: function (resp) {
                        // alert(resp);
                        // alert("==============>" + resp.name + resp.age);
                        /*$.each(resp, function (i, n) {
                            alert("=======>>>>" + n.name + n.age);
                        })*/
                        alert(resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理其方法返回String表示视图名称</p>
    <br>
    <form action="returnString-view.do" method="post">
        姓名 <input type="text" name="name"><br>
        年龄 <input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <br>
    <p>处理其方法返回视图完整路径</p><br>
    <form action="returnString-view2.do" method="post">
        姓名 <input type="text" name="name"><br>
        年龄 <input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
        <button id="butten">发送ajax请求</button>
</body>
</html>
