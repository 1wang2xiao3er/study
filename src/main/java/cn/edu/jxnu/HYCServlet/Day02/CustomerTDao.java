package cn.edu.jxnu.HYCServlet.Day02;

import JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;

public class CustomerTDao {

    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public  boolean add(CustomerT ct){
        boolean flag=false;
        try {
            conn=JDBCUtils.getConnection();
            String sql="insert into customerT(cust_no,cust_pwd,last_login,email) values(?,?,?,?)";

            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,ct.getName());
            pstmt.setString(2,ct.getPwd());
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date= new Date();
            pstmt.setString(3,sf.format(date).toString());
            pstmt.setString(4,ct.getEmail());
            int count=pstmt.executeUpdate();


            if (count == 1){
                flag=true;

          }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }


        return flag;
    }

}
