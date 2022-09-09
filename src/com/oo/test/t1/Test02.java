package com.oo.test.t1;

import java.sql.*;
import java.util.Scanner;

public class Test02 {
        public static void main(String[] args) {
            Connection conn =null;
            Statement stmt =null;
            ResultSet rs =null;
            Scanner scanner = new Scanner(System.in);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/erlingerer";
                String user="root";
                String password="121600";
                conn= DriverManager.getConnection(url,user,password);
                System.out.println(conn);
                System.out.println("输入课程");
                String s1= scanner.next();
                System.out.println("输入名字");
                String s2= scanner.next();
                String sql ="select cno,cname from course where cno= '"+s1+"'and cname='"+s2+"'";
                stmt =conn.createStatement();
                rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String cno=rs.getString("cno");
                    String cname=rs.getString("cname");
                    System.out.println(cno+"  "+cname);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                if (rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if (stmt!=null){
                    try {
                        stmt.close();
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
