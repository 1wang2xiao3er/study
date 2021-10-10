package cn.edu.jxnu.HYCServlet.Day04;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login02" )

public class Login extends HttpServlet {
    static String  name=null;
    static String pwd=null;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        PrintWriter out=resp.getWriter();
        out.println("nihao");
       name= req.getParameter("userName");
      pwd =req.getParameter("password");
        System.out.println(name+"   "+pwd);

        String love[]=req.getParameterValues("love");

        if (love!=null) {
            for (int i = 0; i < love.length; i++) {
                System.out.println(love[i]);
            }
        }
        if("abc".equals(name)&&"123".equals(pwd)){
            req.getRequestDispatcher("/refresh.html").forward(req,resp);
        }else {
            System.out.println("error");
            resp.sendRedirect(req.getContextPath()+"/Login.html");
            //resp.sendRedirect("https://baidu.com");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
//    public static String getName(){
//        return name;
//    }
//    public static String getPwd(){
//        return pwd;
//    }



}
