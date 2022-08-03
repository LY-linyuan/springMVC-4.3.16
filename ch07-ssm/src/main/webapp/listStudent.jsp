<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>查询学生ajax</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 在当前页面加载后, 执行loadStudentData()
            loadStudentData();
            $("#btnLoader").click(function () {
                loadStudentData();
            })
        })

        function loadStudentData() {
            $.ajax({
                url: "student/queryStudent.do",
                dataTypes: "json",
                type: "get",
                success: function (data) {
                    var html = "";
                    $.each(data, function (i, n) {
                        html += "<tr>";
                        html += "<td>" + n.id + "</td>";
                        html += "<td>" + n.name + "</td>";
                        html += "<td>" + n.age + "</td>";
                        html += "</tr>";
                    })
                    $("#info").html(html);
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询数据">
    </div>
</body>
</html>
