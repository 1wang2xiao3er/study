package work;

import cn.edu.jxnu.HYCServlet.Day02.StudentDao;
import com.mysql.cj.Session;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileUploadServlet", value = "/fileUpLoad")
public class FileUpLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 创建一个文件上传的工厂实例
        DiskFileItemFactory factory=new DiskFileItemFactory();


        //设置文件缓存和大小
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        factory.setSizeThreshold(1024*1024*20);
        //创建上传文件对象
        ServletFileUpload upload=new ServletFileUpload(factory);

// 处理页面传过来的表单项
        List<FileItem> items = null;

        String fosPath="";


        //获取真实路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("realPath====="+realPath);
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        //利用迭代器遍历items
        Iterator<FileItem> iter = items.iterator();

        while(iter.hasNext()){
            FileItem fileItem=iter.next();

            if (fileItem.isFormField()){
                //普通表单域
                String fieldName = fileItem.getFieldName();
                //表单名字
                System.out.println("fieldName="+fieldName);
                String fieldValue=fileItem.getString("utf-8");
                System.out.println("fieldValue="+fieldValue);

                request.setAttribute(fieldName, fieldValue);
            }else{
// 取得文件域的表单域名
                String fieldName = fileItem.getFieldName();
                System.out.println("fieldName="+fieldName);
                System.out.println(fileItem.getSize());
                // 取得文件名
                String fileName = fileItem.getName();
                System.out.println("fileName="+fileName);
                // 取得文件类型
                String contentType = fileItem.getContentType();
                System.out.println("contentType="+contentType);
                // 对于上传文件的存放地址来建立一个输出流
                fosPath="bookImages/"+ UUID.randomUUID()
                        + fileName.substring(fileName.lastIndexOf("."));
                // fosPath="bookImages/"+fileName;

                //    String fosName="d:/test/"+fosPath;
                StudentDao studentDao=new StudentDao();
                String name=(String) request.getSession().getAttribute("user");
                studentDao.add(name,fosPath);

                request.getSession().setAttribute("pic",fosPath);
                System.out.println(request.getSession().getAttribute("pic"));
                String fosName=realPath+fosPath;
                System.out.println("fosName="+fosName);
                try{
                    File file=new File(fosName);
                    fileItem.write(file);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }

        RequestDispatcher dispatcher=request.getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);

    }
}
