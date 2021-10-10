//package cn.edu.jxnu.HYCServlet.Day10;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet("/quitServlet")
//public class QuitServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        System.out.println("1");
//        req.getSession().setMaxInactiveInterval(0);
//        System.out.println("2");
//        resp.sendRedirect("/Servlet/login.jsp");
//        System.out.println("你好");
//
//
//
//    }
//}
