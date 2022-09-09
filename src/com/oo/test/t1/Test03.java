package com.oo.test.t1;

import java.sql.*;

public class Test03 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/erlingerer";
            String user="root";
            String password ="121600";
            conn = DriverManager.getConnection(url,user,password);
            String sql ="delete from course where cname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"地点");
            int readCount = ps.executeUpdate();
            System.out.println(readCount);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
