package cn.edu.jxnu.HYCServlet.Day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@WebServlet("/loginCheck")
public class StudentLoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        String name=req.getParameter("userName");
        String pwd=req.getParameter("password");

        StudentService service=new StudentService();

        boolean flag=service.login(name,pwd);
        if (flag){
            StudentDao studentDao=new StudentDao();
            String pic = studentDao.get(name);
            req.getSession().setAttribute("pic",pic);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else {
            System.out.println("error");
        }






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }



}
