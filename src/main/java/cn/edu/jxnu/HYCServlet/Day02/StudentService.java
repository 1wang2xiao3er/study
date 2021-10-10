package cn.edu.jxnu.HYCServlet.Day02;

import org.junit.jupiter.api.Test;

public class StudentService {

     private StudentDao student=new StudentDao();

    public  Boolean login(String name,String pwd){

        return student.login(name,pwd);

    }
}
