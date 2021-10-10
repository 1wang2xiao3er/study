package session;

import cn.edu.jxnu.HYCServlet.Day02.CustomerT;
import cn.edu.jxnu.HYCServlet.Day02.StudentDao;
import cn.edu.jxnu.HYCServlet.Day02.StudentLoginServlet;
import cn.edu.jxnu.HYCServlet.Day02.StudentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
       req.setCharacterEncoding("utf-8");

       String username=req.getParameter("username");
       String password=req.getParameter("password");
       String checkCode=req.getParameter("checkCode");

        StudentService stuS=new StudentService();
        boolean flag= stuS.login(username,password);

        HttpSession session=req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");




        if (checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){


            if (flag){
                StudentDao studentDao=new StudentDao();
                String pic=studentDao.get(username);

                if (pic!=null&&pic.length()!=0){
                    req.getSession().setAttribute("pic",pic);
                }else {
                    pic="bookImages/1c44542b-2e43-4877-895a-941625ed58d2.jpg";
                    req.getSession().setAttribute("pic",pic);
                }
                session.setAttribute("user",username);
                session.setMaxInactiveInterval(60*10);
                String id = session.getId();
                Cookie cookie=new Cookie("JSESSIONID",id);
                cookie.setMaxAge(60*10);
                resp.addCookie(cookie);
                resp.sendRedirect(req.getContextPath()+"/success.jsp");



            }else {
                req.setAttribute("login_error","用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);


            }

        }else {
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);


        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
    }
}
