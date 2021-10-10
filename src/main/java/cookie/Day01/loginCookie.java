package cookie.Day01;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@WebServlet("/loginCookie")
public class loginCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp);
        resp.getWriter().println("有毒");
      resp.setContentType("text/html;charset=utf-8");
        boolean flag=false;

        Cookie[] cookie=req.getCookies();

        if (cookie !=null&&cookie.length>0){
            for (Cookie cookie1 : cookie) {

                String name=cookie1.getName();

                if (name.equals("LastTime")){
                    String value=cookie1.getValue();

                    flag=true;

                    resp.getWriter().println("欢迎回来，上次登陆的时间为："+value);

                   Date date= new Date();
                   SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                   String str_date=sdf.format(date);
                    System.out.println("未编码前的");
                    System.out.println(str_date);

//                    URLEncoder.encode("str_date",)
                   cookie1.setValue(str_date);
                   cookie1.setMaxAge(60*60*24*30);
                   resp.addCookie(cookie1);
                   break;



                }


            }
        }

        if (cookie==null|| cookie.length==0||flag==false){

            Date date= new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
            String str_date=sdf.format(date);
            Cookie cookie2=new Cookie("LastTime",str_date);

            cookie2.setMaxAge(60*60*24*30);
            resp.addCookie(cookie2);
            resp.getWriter().println("首次登陆！");
            System.out.println("首次登陆！");






        }








    }
}
