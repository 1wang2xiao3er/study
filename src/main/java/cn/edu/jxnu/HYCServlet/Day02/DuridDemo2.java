package cn.edu.jxnu.HYCServlet.Day02;

import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DuridDemo2 {
    public static void main(String[] args) {

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn= JDBCUtils.getConnection();
            String sql="select * from student";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            while (rs.next()){

                System.out.println(rs.getInt("id")+"  "+ rs.getString("name")+"   "+rs.getString("pwd"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
}
