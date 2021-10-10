package cn.edu.jxnu.HYCServlet.Day02;

import com.mysql.cj.callback.UsernameCallback;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "register",value = "/register")
public class CustomerTRegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        String name=req.getParameter("userName");
//        String pwd=req.getParameter("password");
//        String repwd=req.getParameter("rePassword");
//        String email=req.getParameter("email");
//
//        CustomerT cust=new CustomerT();
//        CustomerTDao dao=new CustomerTDao();
//        CustomerTService service=new CustomerTService();
//
//        if (name!=null&&pwd!=null){
//            if (pwd.equals(repwd)){
//                cust.setName(name);
//                cust.setPwd(pwd);
//                cust.setDate(new Date());
//                cust.setEmail(email);
//
//
//                boolean flag=service.add(cust);
//
//                PrintWriter out =resp.getWriter();
//                out.println("12345");
//                if (flag){
//                    PrintWriter out1 =resp.getWriter();
//                    out1.println("12356");
//                    req.getRequestDispatcher("/RegisterSuccess.html").forward(req,resp);
//                }
//
//
//
//            }else {
//                System.out.println("两次密码不一致");
//                PrintWriter out =resp.getWriter();
//                out.println("1234");
//            }
//
//        }else {
//            PrintWriter out =resp.getWriter();
//            out.println("123");
//            System.out.println("用户名或密码为空");
//        }
//
//
//

        String uName=req.getParameter("userName");
        String uPWD=req.getParameter("password");
        String reUserPWD=req.getParameter("rePassword");
        String email=req.getParameter("email");

        if (uPWD!=null && uPWD.equals(reUserPWD)==false){
            System.out.println("密码不一致");
        }

        CustomerT domain=new CustomerT();
        //注入用户信息
        domain.setName(uName);
        domain.setPwd(uPWD);
        domain.setEmail(email);
        //domain.setDate(new Date());
        CustomerTService service=new CustomerTService();
        boolean flag=false;
        try {
            flag=service.add(domain);
            System.out.println(flag);
            if (flag==true) {
                req.getRequestDispatcher("/RegisterSuccess.html").forward(req,resp);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.println("reg error!");
        }







   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
