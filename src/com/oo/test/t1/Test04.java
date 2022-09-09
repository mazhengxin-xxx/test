package com.oo.test.t1;
import java.sql.*;
import java.util.ResourceBundle;

public class Test04 {
    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt =null;
        ResultSet rs =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/samp_db","root","121600");
            stmt = conn.createStatement();
            String sql="select * from student ";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String age = rs.getString("age");
                System.out.println(id+"  "+name+"  "+sex+"  "+age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
