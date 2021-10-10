<%@ page import="javax.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: huangyachen
  Date: 2021/10/7
  Time: 3:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>

    <%
        System.out.println("1");

        System.out.println("2");
        for (Cookie cookie : request.getCookies()) {
           if ("JSESSIONID".equals(cookie)){

               cookie.setMaxAge(0);
               response.addCookie(cookie);
               request.getSession().removeAttribute("user");
            }

        }
        System.out.println("3");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        System.out.println("4");
    %>

</head>
<body>
<input type="text" value="你好啊">


</body>
</html>
