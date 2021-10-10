<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: huangyachen
  Date: 2021/9/23
  Time: 2:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>



<%
    Cookie [] cookies=request.getCookies();
    boolean flag=false;
      if (cookies!=null&&cookies.length>0){
          for (Cookie cookie : cookies) {
              String name=cookie.getName();

              if ("lastTime".equals(name)){
                  flag=true;
                  Date date=new Date();
                  SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                  String str_date=sdf.format(date);

                  System.out.println("编码前"+str_date);
                  str_date= URLEncoder.encode(str_date,"utf-8");
                  System.out.println("编码后"+str_date);

                  cookie.setValue(str_date);
                  cookie.setMaxAge(60*60*24*30);
                  response.addCookie(cookie);

                  String value=cookie.getValue();
                  System.out.println("解码前"+value);
                  value= URLDecoder.decode(value,"utf-8");
                  System.out.println("解码后"+value);
                  out.write("<h1>欢迎回来，您上次访问的时间为："+value+"</h1>");

                  break;


              }

          }
      }

       if (cookies==null||cookies.length==0||flag==false){

           Date date=new Date();
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
           String str_date=sdf.format(date);

           System.out.println("编码前"+str_date);
           str_date= URLEncoder.encode(str_date,"utf-8");
           System.out.println("编码后"+str_date);

           Cookie cookie=new Cookie("lastTime",str_date);

           cookie.setValue(str_date);
           cookie.setMaxAge(60*60*24*30);
           response.addCookie(cookie);

           out.write("<h1>您好，欢迎您首次访问</h1>");









       }
















%>

</body>
</html>
