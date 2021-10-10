package cn.edu.jxnu.HYCServlet.Day02;

import JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {



    public static Boolean login(String name,String pwd){

        boolean flag=false;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn=JDBCUtils.getConnection();
            String sql="SELECT * FROM student WHERE `name`=? AND pwd=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);

            rs=pstmt.executeQuery();
            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return flag;

  }
  public int add(String name,String pic){
      Connection conn=null;
      PreparedStatement pstmt=null;
      int i=0;
      try {
          conn=JDBCUtils.getConnection();
          String sql="update student set pic=? where name=?" ;
          pstmt=conn.prepareStatement(sql);
          pstmt.setString(1,pic);
          pstmt.setString(2,name);

           i=pstmt.executeUpdate();


      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          JDBCUtils.close(pstmt,conn);
      }
      return i;

  }
    public  String get(String name){

        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn=JDBCUtils.getConnection();
            String sql="SELECT pic FROM student WHERE `name`=? ";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);

            rs=pstmt.executeQuery();
            if (rs.next()){
                return rs.getString("pic");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return "";

    }

}