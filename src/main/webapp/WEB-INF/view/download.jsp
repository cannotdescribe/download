<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/7
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文件下载</title>

    <script type="text/javascript" src="/js/jquery/jquery-1.4.4.min.js"></script>

    <script type="text/javascript">
        $(function(){
            var urlPrefix = "";

            getData = function (param) {
                console.log(param);
                $.ajax({
                    url:  urlPrefix + "/" + param,
                    type: "POST",
                    success: function(result){
                        urlPrefix = "/" + param;
                        console.log(result.childrenPath);
                        var value = $("#h1").html();
                        value = result.nowPath;
                        $("#h1").html(value);

                        var arr = result.childrenPath;
                    }
                });
            };
            getData("list");

        });
    </script>
</head>
<body>
当前路径：<label id="h1"></label>
<table>
    <thead>
        <tr>
            <th>文件名称</th>
            <th>上传时间</th>
            <th>文件大小</th>
            <th>文件描述</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><a href="#" onclick="getData(this.innerHTML)">video</a></td>
        </tr>
    </tbody>
</table>
</body>
</html>
