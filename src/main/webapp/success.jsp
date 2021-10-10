<%@ page import="cn.edu.jxnu.HYCServlet.Day02.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: huangyachen
  Date: 2021/9/23
  Time: 8:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>


   <h1><%=request.getSession().getAttribute("user")%>你登陆成功！</h1>
       <br>  <br> <br>  <br>

   <img src="${pic}" height="750" width="700"/>

       <a href="/Servlet/quit.jsp"><input type="button" value="退出"  ></a>
       <a href="/Servlet/upload.jsp"><input type="button" value="更换头像"  ></a>





</body>
</html>
