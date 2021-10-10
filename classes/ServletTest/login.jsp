<%@ page import="javax.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: huangyachen
  Date: 2021/9/23
  Time: 7:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>




<%--<%--%>

<%--       String user = (String) request.getSession().getAttribute("user");--%>
<%--       if (user!=null)--%>
<%--      response.sendRedirect(request.getContextPath()+"/success.jsp");--%>
<%--%>--%>




        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/Servlet/CheckCodeServlet?" + new Date().getTime();

            }
        }


    </script>
    <style>
        div {
            color: red;
        }
    </style>


</head>
<body>
<form action="/Servlet/loginServlet" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" ></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>

            <td colspan="2"><img id="img" src="/Servlet/CheckCodeServlet"></td>
        </tr>
        <tr>

            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>


    </table>


</form>

<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
</div>
<div><%=request.getAttribute("login_msg") == null ? "" : request.getAttribute("login_msg")%>
</div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
</div>

</body>
</html>
