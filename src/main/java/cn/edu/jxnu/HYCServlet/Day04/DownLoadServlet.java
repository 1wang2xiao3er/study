package cn.edu.jxnu.HYCServlet.Day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DownLoad",value = "/DownLoad")
public class DownLoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
     String fileName=req.getParameter("filename");
     String realPath=this.getServletContext().getRealPath("/");
        System.out.println(realPath);
        String filePath=realPath+"txt/"+fileName;
        System.out.println(filePath);

        //fileName= URLEncoder.encode(fileName,"UTF-8");

        fileName =new String(fileName.getBytes(StandardCharsets.UTF_8),"iso8859-1");

        System.out.println("user-agent:"+req.getHeader("user-agent"));


        FileInputStream infile=null;
        OutputStream outFile=null;
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        try {
            infile=new FileInputStream(filePath);
            outFile=resp.getOutputStream();

            byte b []=new byte[1024];
            int len=0;
            while ((len=infile.read(b))!=-1){

                outFile.write(b,0,len);
            }
            infile.close();
            outFile.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
