package com.oo.test.t1;

import com.oo.test.utils.DButil;

import java.sql.*;

//yubianyi
public class Test07 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps= null;

        try {
            conn=DButil.getConnection();
            String sql1 ="update shiyan set money=money-1000 where name=? and money>0";
            ps = conn.prepareStatement(sql1);
            ps.setString(1,"1");
            int i = ps.executeUpdate();
            ps.close();
            String sql2 ="update shiyan set money=money+1000 where name=?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1,"2");
            int j=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
