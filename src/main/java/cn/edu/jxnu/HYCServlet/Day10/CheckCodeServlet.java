package cn.edu.jxnu.HYCServlet.Day10;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);

        int width=120;
        int height=30;

        BufferedImage image =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=(Graphics2D)image.getGraphics();
        g.setColor(Color.GRAY);

        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String words="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        g.setColor(Color.YELLOW);
        g.setFont(new Font("隶书",Font.BOLD,20));

        Random random=new Random();

        StringBuilder sb=new StringBuilder();

        int x=20;
        int y=20;
        for (int i=0;i<4;i++){

            int jiaodu=random.nextInt(60)-30;
            double hudu=jiaodu*Math.PI/180;
            g.rotate(hudu,x,y);

            int index=random.nextInt(words.length());

            char ch= words.charAt(index);
            sb.append(ch);

            g.drawString(""+ch,x,y);

            g.rotate(-hudu,x,y);
            x+=20;

        }

        String checkCode_session=sb.toString();
        req.getSession().setAttribute("checkCode_session",checkCode_session);

        g.setColor(Color.GREEN);
        int x1,x2,y1,y2;
        for (int i=0;i<4;i++){
            x1=random.nextInt(width);
            y1=random.nextInt(height);
            x2=random.nextInt(width);
            y2=random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        ImageIO.write(image,"jpg",resp.getOutputStream());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }
}
