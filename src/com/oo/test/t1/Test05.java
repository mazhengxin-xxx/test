package com.oo.test.t1;

import com.oo.test.utils.DButil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Test05 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs= null;
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/oo/test/db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            conn = DriverManager.getConnection(url,user,password);
            String sql ="insert into course values('3-369','计算',?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"669");
            int readCount = ps.executeUpdate();
            System.out.println(readCount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,rs);
        }

    }
}
