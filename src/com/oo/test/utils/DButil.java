package com.oo.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class DButil {



    public static Connection getConnection() throws SQLException {

        Connection connection=null;
        try {
            ResourceBundle resourceBundle=ResourceBundle.getBundle("com/oo/test/db");
            String driver = resourceBundle.getString("driver");
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs){
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
    public static int update(Connection conn,String sql,Object[] param){
        int num=0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i+1,param[i]);
            }
            num=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

}
