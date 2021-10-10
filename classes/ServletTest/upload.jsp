<%--
  Created by IntelliJ IDEA.
  User: tls
  Date: 2021/9/28
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <script src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>

<form action="/Servlet/fileUpLoad" method="post" enctype="multipart/form-data" style="border:1px solid red;width:600px;margin:0 auto;">
    <h1>单文件上传</h1>
    上传头像：<input name="file1" type="file" /> <br/>
    <input type="submit"/>
</form>
<br><br><br>

<form action="multifileupload.do" method="post" enctype="multipart/form-data" style="border:1px solid red;width:600px;margin:0 auto;">
    <h1>多文件上传</h1>
    上传头像1：<input name="file1" type="file" /> <br/>
    上传头像2：<input name="file1" type="file" /> <br/>
    上传头像3：<input name="file1" type="file" /> <br/>
    <input type="submit"/>
</form>
<br><br><br>
<form action="/multifileupload.do" method="post" encType="multipart/form-data" style="border:1px solid red;width:600px;margin:0 auto;">
    <h1>基于jQuery的多文件上传</h1>
    <input id="addFile" type="button" value="增加文件" ><br><br><br>
    <input type="file" name="file1"><br>
    <div id="content">
    </div>
    <input type="submit" value="上传">
</form>
<br><br><br><br><br><br><br><br><br>

<script type="text/javascript">
    $(function (){
        $("#addFile").click(function(){
            addFile();
        });
        $("#content").on("click",".removeFile",function (){
            alert("hhh");
            $(this).parent().remove();
        })

    })
    function addFile(){
        // var div=document.getElementById("content");
        var div=$("#content");
        div.append("<div class='addFile'><input type='file' name='file'><input type='button' value='删除文件' class='removeFile'></div>");
    }

    function removeFile(btn){

        document.getElementById("content").removeChild(btn.parentNode);

    }
</script>
</body>
</html>
